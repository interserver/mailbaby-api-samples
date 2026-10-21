{-# LANGUAGE DataKinds                  #-}
{-# LANGUAGE DeriveDataTypeable         #-}
{-# LANGUAGE DeriveGeneric              #-}
{-# LANGUAGE DeriveTraversable          #-}
{-# LANGUAGE FlexibleContexts           #-}
{-# LANGUAGE FlexibleInstances          #-}
{-# LANGUAGE GeneralizedNewtypeDeriving #-}
{-# LANGUAGE OverloadedStrings          #-}
{-# LANGUAGE RecordWildCards            #-}
{-# LANGUAGE TypeFamilies               #-}
{-# LANGUAGE TypeOperators              #-}
{-# LANGUAGE ViewPatterns               #-}
{-# OPTIONS_GHC
-fno-warn-unused-binds -fno-warn-unused-imports -freduction-depth=328 #-}

module MailBabyEmailDeliveryAndManagementService.API
  ( -- * Client and Server
    Config(..)
  , MailBabyEmailDeliveryAndManagementServiceBackend(..)
  , createMailBabyEmailDeliveryAndManagementServiceClient
  , runMailBabyEmailDeliveryAndManagementServiceServer
  , runMailBabyEmailDeliveryAndManagementServiceMiddlewareServer
  , runMailBabyEmailDeliveryAndManagementServiceClient
  , runMailBabyEmailDeliveryAndManagementServiceClientWithManager
  , callMailBabyEmailDeliveryAndManagementService
  , MailBabyEmailDeliveryAndManagementServiceClient
  , MailBabyEmailDeliveryAndManagementServiceClientError(..)
  -- ** Servant
  , MailBabyEmailDeliveryAndManagementServiceAPI
  -- ** Plain WAI Application
  , serverWaiApplicationMailBabyEmailDeliveryAndManagementService
  -- ** Authentication
  , MailBabyEmailDeliveryAndManagementServiceAuth(..)
  , clientAuth
  , Protected
  ) where

import           MailBabyEmailDeliveryAndManagementService.Types

import           Control.Monad.Catch                (Exception, MonadThrow, throwM)
import           Control.Monad.Except               (ExceptT, runExceptT)
import           Control.Monad.IO.Class
import           Control.Monad.Trans.Reader         (ReaderT (..))
import           Data.Aeson                         (Value)
import qualified Data.Aeson                         as Aeson
import           Data.ByteString                    (ByteString)
import qualified Data.ByteString.Lazy               as BSL
import           Data.Coerce                        (coerce)
import           Data.Data                          (Data)
import           Data.Function                      ((&))
import qualified Data.Map                           as Map
import           Data.Monoid                        ((<>))
import           Data.Proxy                         (Proxy (..))
import           Data.Set                           (Set)
import           Data.Text                          (Text)
import qualified Data.Text                          as T
import qualified Data.Text.Encoding                 as T
import           Data.Time
import           Data.UUID                          (UUID)
import           GHC.Exts                           (IsString (..))
import           GHC.Generics                       (Generic)
import           Network.HTTP.Client                (Manager, newManager)
import           Network.HTTP.Client.TLS            (tlsManagerSettings)
import           Network.HTTP.Types.Method          (methodOptions)
import           Network.Wai                        (Middleware, Request, requestHeaders)
import qualified Network.Wai.Handler.Warp           as Warp
import           Servant                            (ServerError, serveWithContextT, throwError)
import           Servant.API                        hiding (addHeader)
import           Servant.API.Verbs                  (StdMethod (..), Verb)
import           Servant.API.Experimental.Auth      (AuthProtect)
import           Servant.Client                     (ClientEnv, Scheme (Http), ClientError, client,
                                                     mkClientEnv, parseBaseUrl)
import           Servant.Client.Core                (baseUrlPort, baseUrlHost, AuthClientData, AuthenticatedRequest, addHeader, mkAuthenticatedRequest)
import           Servant.Client.Internal.HttpClient (ClientM (..))
import           Servant.Server                     (Handler (..), Application, Context ((:.), EmptyContext))
import           Servant.Server.Experimental.Auth   (AuthHandler, AuthServerData, mkAuthHandler)
import           Servant.Server.StaticFiles         (serveDirectoryFileServer)
import           Web.FormUrlEncoded
import           Web.HttpApiData



data FormAddRule = FormAddRule
  { addRuleUser :: Text
  , addRuleType :: Text
  , addRuleData :: Text
  } deriving (Show, Eq, Generic, Data)

instance FromForm FormAddRule
instance ToForm FormAddRule

data FormSendAdvMail = FormSendAdvMail
  { sendAdvMailSubject :: Text
  , sendAdvMailBody :: Text
  , sendAdvMailFrom :: EmailAddressTypes
  , sendAdvMailTo :: EmailAddressesTypes
  , sendAdvMailReplyto :: EmailAddressesTypes
  , sendAdvMailCc :: EmailAddressesTypes
  , sendAdvMailBcc :: EmailAddressesTypes
  , sendAdvMailAttachments :: [MailAttachment]
  , sendAdvMailId :: Integer
  } deriving (Show, Eq, Generic, Data)

instance FromForm FormSendAdvMail
instance ToForm FormSendAdvMail

data FormSendMail = FormSendMail
  { sendMailTo :: SendMailTo
  , sendMailFrom :: Text
  , sendMailSubject :: Text
  , sendMailBody :: Text
  , sendMailId :: Integer
  } deriving (Show, Eq, Generic, Data)

instance FromForm FormSendMail
instance ToForm FormSendMail


-- | List of elements parsed from a query.
newtype QueryList (p :: CollectionFormat) a = QueryList
  { fromQueryList :: [a]
  } deriving (Functor, Applicative, Monad, Foldable, Traversable)

-- | Formats in which a list can be encoded into a HTTP path.
data CollectionFormat
  = CommaSeparated -- ^ CSV format for multiple parameters.
  | SpaceSeparated -- ^ Also called "SSV"
  | TabSeparated -- ^ Also called "TSV"
  | PipeSeparated -- ^ `value1|value2|value2`
  | MultiParamArray -- ^ Using multiple GET parameters, e.g. `foo=bar&foo=baz`. Only for GET params.

instance FromHttpApiData a => FromHttpApiData (QueryList 'CommaSeparated a) where
  parseQueryParam = parseSeparatedQueryList ','

instance FromHttpApiData a => FromHttpApiData (QueryList 'TabSeparated a) where
  parseQueryParam = parseSeparatedQueryList '\t'

instance FromHttpApiData a => FromHttpApiData (QueryList 'SpaceSeparated a) where
  parseQueryParam = parseSeparatedQueryList ' '

instance FromHttpApiData a => FromHttpApiData (QueryList 'PipeSeparated a) where
  parseQueryParam = parseSeparatedQueryList '|'

instance FromHttpApiData a => FromHttpApiData (QueryList 'MultiParamArray a) where
  parseQueryParam = error "unimplemented FromHttpApiData for MultiParamArray collection format"

parseSeparatedQueryList :: FromHttpApiData a => Char -> Text -> Either Text (QueryList p a)
parseSeparatedQueryList char = fmap QueryList . mapM parseQueryParam . T.split (== char)

instance ToHttpApiData a => ToHttpApiData (QueryList 'CommaSeparated a) where
  toQueryParam = formatSeparatedQueryList ','

instance ToHttpApiData a => ToHttpApiData (QueryList 'TabSeparated a) where
  toQueryParam = formatSeparatedQueryList '\t'

instance ToHttpApiData a => ToHttpApiData (QueryList 'SpaceSeparated a) where
  toQueryParam = formatSeparatedQueryList ' '

instance ToHttpApiData a => ToHttpApiData (QueryList 'PipeSeparated a) where
  toQueryParam = formatSeparatedQueryList '|'

instance ToHttpApiData a => ToHttpApiData (QueryList 'MultiParamArray a) where
  toQueryParam = error "unimplemented ToHttpApiData for MultiParamArray collection format"

formatSeparatedQueryList :: ToHttpApiData a => Char ->  QueryList p a -> Text
formatSeparatedQueryList char = T.intercalate (T.singleton char) . map toQueryParam . fromQueryList

newtype JSONQueryParam a = JSONQueryParam
  { fromJsonQueryParam :: a
  } deriving (Functor, Foldable, Traversable)

instance Aeson.ToJSON a => ToHttpApiData (JSONQueryParam a) where
  toQueryParam = T.decodeUtf8 . BSL.toStrict . Aeson.encode . fromJsonQueryParam

instance Aeson.FromJSON a => FromHttpApiData (JSONQueryParam a) where
  parseQueryParam = either (Left . T.pack) (Right . JSONQueryParam) . Aeson.eitherDecodeStrict . T.encodeUtf8


-- | Servant type-level API, generated from the OpenAPI spec for MailBabyEmailDeliveryAndManagementService.
type MailBabyEmailDeliveryAndManagementServiceAPI
    =    Protected :> "mail" :> "rules" :> ReqBody '[FormUrlEncoded] FormAddRule :> Verb 'POST 200 '[JSON] GenericResponse -- 'addRule' route
    :<|> Protected :> "mail" :> "rules" :> Capture "ruleId" Int :> Verb 'DELETE 200 '[JSON] GenericResponse -- 'deleteRule' route
    :<|> Protected :> "mail" :> "blocks" :> "delete" :> ReqBody '[JSON] EmailAddressParam :> Verb 'POST 200 '[JSON] GenericResponse -- 'delistBlock' route
    :<|> Protected :> "mail" :> "blocks" :> Verb 'GET 200 '[JSON] MailBlocks -- 'getMailBlocks' route
    :<|> Protected :> "mail" :> "rules" :> Verb 'GET 200 '[JSON] [DenyRuleRecord] -- 'getRules' route
    :<|> Protected :> "mail" :> "stats" :> QueryParam "time" Text :> Verb 'GET 200 '[JSON] MailStatsType -- 'getStats' route
    :<|> Protected :> "mail" :> "log" :> QueryParam "id" Integer :> QueryParam "origin" Text :> QueryParam "mx" Text :> QueryParam "from" Text :> QueryParam "to" Text :> QueryParam "subject" Text :> QueryParam "mailid" Text :> QueryParam "messageId" Text :> QueryParam "replyto" Text :> QueryParam "headerfrom" Text :> QueryParam "delivered" Int :> QueryParam "skip" Int :> QueryParam "limit" Int :> QueryParam "startDate" Text :> QueryParam "endDate" Text :> QueryParam "sort" Text :> QueryParam "dir" Text :> QueryParam "groupby" Text :> Verb 'GET 200 '[JSON] MailLog -- 'viewMailLog' route
    :<|> Protected :> "mail" :> "rawsend" :> ReqBody '[JSON] SendMailRaw :> Verb 'POST 200 '[JSON] GenericResponse -- 'rawMail' route
    :<|> Protected :> "mail" :> "advsend" :> ReqBody '[FormUrlEncoded] FormSendAdvMail :> Verb 'POST 200 '[JSON] GenericResponse -- 'sendAdvMail' route
    :<|> Protected :> "mail" :> "send" :> ReqBody '[FormUrlEncoded] FormSendMail :> Verb 'POST 200 '[JSON] GenericResponse -- 'sendMail' route
    :<|> Protected :> "mail" :> Capture "id" Integer :> Verb 'GET 200 '[JSON] MailOrderDetail -- 'getMailOrderById' route
    :<|> Protected :> "mail" :> Verb 'GET 200 '[JSON] [MailOrder] -- 'getMailOrders' route
    :<|> "ping" :> Verb 'GET 200 '[JSON] Text -- 'pingServer' route
    :<|> Raw


-- | Server or client configuration, specifying the host and port to query or serve on.
data Config = Config
  { configUrl :: String  -- ^ scheme://hostname:port/path, e.g. "http://localhost:8080/"
  } deriving (Eq, Ord, Show, Read)


-- | Custom exception type for our errors.
newtype MailBabyEmailDeliveryAndManagementServiceClientError = MailBabyEmailDeliveryAndManagementServiceClientError ClientError
  deriving (Show, Exception)
-- | Configuration, specifying the full url of the service.


-- | Backend for MailBabyEmailDeliveryAndManagementService.
-- The backend can be used both for the client and the server. The client generated from the MailBabyEmailDeliveryAndManagementService OpenAPI spec
-- is a backend that executes actions by sending HTTP requests (see @createMailBabyEmailDeliveryAndManagementServiceClient@). Alternatively, provided
-- a backend, the API can be served using @runMailBabyEmailDeliveryAndManagementServiceMiddlewareServer@.
data MailBabyEmailDeliveryAndManagementServiceBackend a m = MailBabyEmailDeliveryAndManagementServiceBackend
  { addRule :: a -> FormAddRule -> m GenericResponse{- ^ **Use this to prevent future relay attempts that match a pattern.** Required: `type` (`email`, `domain`, `destination`, or `startswith`) and `data` (the value to match). Optional: `user` (SMTP username; auto-selects first active order if omitted). Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The `type` field selects the matching strategy: - **`email`** — exact match against the SMTP envelope `MAIL FROM` address. - **`domain`** — matches any sender address at the specified domain. - **`destination`** — exact match against the SMTP envelope `RCPT TO` address. - **`startswith`** — matches any sender address whose local-part (the portion   before the `@`) starts with the given string.  Only alphanumeric characters   and `+`, `_`, `.`, `-` are permitted in the prefix.   If `username` is provided it must be the SMTP username of one of your active mail orders (e.g. `mb20682`).  If omitted the rule is associated with your first active order.  On success the response `text` field contains the newly created rule's `id`, which can later be passed to `DELETE /mail/rules/{ruleId}` to remove it.  -}
  , deleteRule :: a -> Int -> m GenericResponse{- ^ **Destructive — permanently removes the rule.** Required: `ruleId` (path param; obtain from the `id` field returned by `GET /mail/rules` or the `text` field returned by `POST /mail/rules`). Permanently removes a single deny rule identified by its numeric `ruleId`.  The `ruleId` is the `id` field returned by `GET /mail/rules` or the `text` field from a successful `POST /mail/rules` response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account.  -}
  , delistBlock :: a -> EmailAddressParam -> m GenericResponse{- ^ **Destructive — wipes block records for the given address.** Required: `email` (must be a valid address; typically a `from` value previously returned by `GET /mail/blocks` or `GET /mail/log`). Delists an email address from all three block list stores: 1. The rspamd spam-filter database (`fromemail` / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use `GET /mail/blocks` to discover which addresses are currently blocked.  The `from` field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules.  -}
  , getMailBlocks :: a -> m MailBlocks{- ^ **Use this to discover which addresses to delist.** The `from` value of any returned entry can be passed to `POST /mail/blocks/delete` (as the `email` field) to remove the block. Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s). Three categories are returned:  - **`local`** — messages flagged by the `LOCAL_BL_RCPT` rspamd rule.  These are   messages sent to recipients on your account's local block list. - **`mbtrap`** — messages flagged by the `MBTRAP` rspamd rule.  These are messages   that triggered MailBaby's internal trap / honeypot detection. - **`subject`** — senders whose recent messages contain spam-indicative subjects   (strings containing `@`, `smtp`, `socks4`, or `socks5`) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The `local` and `mbtrap` results cover the last 5 days.  The `subject` results cover the last 3 days.  A sender address returned in any of these lists can be delisted using `POST /mail/blocks/delete` with the `email` field set to that address.  -}
  , getRules :: a -> m [DenyRuleRecord]{- ^ **Use this to inspect or pick a `ruleId` to delete.** Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | `type` | `data` format | Effect | |--------|---------------|--------| | `email` | `user@domain.com` | Rejects any message from this exact sender address | | `domain` | `domain.com` | Rejects any message from any address at this domain | | `destination` | `user@domain.com` | Rejects any message addressed to this recipient | | `startswith` | `prefix` | Rejects any message whose sender address begins with this string (alphanumeric, `+`, `_`, `.`, `-` only) |  Use `POST /mail/rules` to add new rules and `DELETE /mail/rules/{ruleId}` to remove them.  The `id` field in each returned record is the value needed for the delete call.  -}
  , getStats :: a -> Maybe Text -> m MailStatsType{- ^ **Use this for dashboards or billing-cycle reviews.** Returns aggregate sending statistics for your mail account(s). The `time` query param controls the window for `received`, `sent`, and `volume` (`1h`, `24h`, `7d`, `month`, `day`, `billing`, `all`). The `usage` and `cost` fields are always for the current billing cycle, regardless of `time`.  The response includes: - **`usage`** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **`cost`** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **`received`** / **`sent`** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected `time` window. - **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),   destination address (`to`), and sender address (`from`) within the selected window.   **Time windows** (controlled by the `time` parameter): | Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time |  -}
  , viewMailLog :: a -> Maybe Integer -> Maybe Text -> Maybe Text -> Maybe Text -> Maybe Text -> Maybe Text -> Maybe Text -> Maybe Text -> Maybe Text -> Maybe Text -> Maybe Int -> Maybe Int -> Maybe Int -> Maybe Text -> Maybe Text -> Maybe Text -> Maybe Text -> Maybe Text -> m MailLog{- ^ **Use this to find or audit sent messages.** All filters are optional and combinable. The most useful filters: `mailid` (the transaction id returned by a send call), `from` / `to` (envelope addresses), `subject`, `messageId` (case-insensitive substring on the `Message-ID` header), `delivered` (`1`=delivered, `0`=queued/failed), and the `startDate`/`endDate` date range. Returns a paginated list of every email message accepted by the relay for your mail account(s).  **Row grouping** is controlled by the `groupby` parameter.  By default (`groupby=recipient`), the response contains one row per delivery attempt — so a single message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and `mxHostname` values.  Set `groupby=message` to collapse to one row per message (delivery fields will reflect one arbitrary recipient).  **Pagination** is controlled by `skip` and `limit`.  The `total` in the response reflects the row count **after** grouping, so it matches the number of pages you need to fetch.  **Date filtering** accepts either a Unix timestamp (integer) or a date string parseable by PHP `strtotime()` such as `2024-01-15`, `last monday`, or `2024-01-01 00:00:00`.  Examples: `startDate=1704067200&endDate=1706745599` or `startDate=2024-01-01&endDate=2024-01-31`.  **Sorting** is controlled by `sort` and `dir`.  Currently the only sort key is `time` (default), which orders by internal row ID.  **Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.  The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.  The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match).  -}
  , rawMail :: a -> SendMailRaw -> m GenericResponse{- ^ **Use this when you have already built (and possibly DKIM-signed) the full RFC 822 message yourself** and want the relay to transmit it byte-for-byte. Required: `raw_email` (full RFC 822 string with headers + body). Optional: `id` (mail order to authenticate as). Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact. If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record.  -}
  , sendAdvMail :: a -> FormSendAdvMail -> m GenericResponse{- ^ **Use this when the simple send is not enough** — multiple recipients, CC/BCC, named contacts, custom Reply-To, or file attachments. Required: `from`, `to`, `subject`, `body`. Optional: `cc`, `bcc`, `replyto`, `attachments` (array of `{filename,data}` with base64 data), `id`. Sends through one of your mail orders with full control over recipients, headers, and attachments.  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.  ## Examples  ### Form — basic string addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d from=user@domain.com \\   -d to=support@interserver.net ``` ### Form — RFC 822 named addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d 'from=Joe <user@domain.com>' \\   -d 'to=Jane <support@interserver.net>' ``` ### Form — multiple recipients as array ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' -d 'body=Hello' \\   -d from=user@domain.com \\   -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \\   -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net' ``` ### JSON — structured objects ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/json' \\   -d '{     \"subject\": \"Welcome\",     \"body\": \"<h1>Hello</h1>\",     \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},     \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],     \"cc\": [{\"email\": \"manager@client.com\"}],     \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]   }' ```  -}
  , sendMail :: a -> FormSendMail -> m GenericResponse{- ^ **Use this for the simplest case** — one or a few plain-string recipients, no attachments, no CC/BCC, no named contacts. Required: `from`, `to`, `subject`, `body`. Optional: `id` (selects which mail order to send through; auto-selects your first active order if omitted). Sends through one of your mail orders using a flat set of fields.  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.  The `from` address is also automatically set as the `Reply-To` header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record.  -}
  , getMailOrderById :: a -> Integer -> m MailOrderDetail{- ^ **Returns the SMTP password** in addition to the basic `GET /mail` fields. Use when you need to authenticate against `relay.mailbaby.net:25` from an SMTP client directly. Required: `id` (path; obtain from `GET /mail`). Returns the full detail record for one specific mail order identified by its numeric `id`.  The `username` and `password` values returned here can be used directly to authenticate against `relay.mailbaby.net:25` (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The `id` path parameter is the same integer `id` value returned by `GET /mail`.  -}
  , getMailOrders :: a -> m [MailOrder]{- ^ Use this **before sending** if you need to discover which mail order `id` to pass to `/mail/send`, `/mail/advsend`, `/mail/rawsend`, `/mail/log`, or `/mail/stats`. Returns every mail order (active **and** canceled) on your account. Each record includes the numeric `id`, the `status` (`active` or `canceled`), the SMTP `username` (always `mb<id>`), and an optional `comment`.  The `id` values returned here are used as the `id` input parameter on all sending endpoints (`/mail/send`, `/mail/advsend`, `/mail/rawsend`) as well as the log and stats queries.  When the `id` parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use `GET /mail/{id}`.  -}
  , pingServer :: m Text{- ^ **No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests.  -}
  }

-- | Authentication settings for MailBabyEmailDeliveryAndManagementService.
-- lookupUser is used to retrieve a user given a header value. The data type can be specified by providing an
-- type instance for AuthServerData. authError is a function that given a request returns a custom error that
-- is returned when the header is not found.
data MailBabyEmailDeliveryAndManagementServiceAuth = MailBabyEmailDeliveryAndManagementServiceAuth
  { lookupUser :: ByteString -> Handler AuthServer
  , authError :: Request -> ServerError
  }

newtype MailBabyEmailDeliveryAndManagementServiceClient a = MailBabyEmailDeliveryAndManagementServiceClient
  { runClient :: ClientEnv -> ExceptT ClientError IO a
  } deriving Functor

instance Applicative MailBabyEmailDeliveryAndManagementServiceClient where
  pure x = MailBabyEmailDeliveryAndManagementServiceClient (\_ -> pure x)
  (MailBabyEmailDeliveryAndManagementServiceClient f) <*> (MailBabyEmailDeliveryAndManagementServiceClient x) =
    MailBabyEmailDeliveryAndManagementServiceClient (\env -> f env <*> x env)

instance Monad MailBabyEmailDeliveryAndManagementServiceClient where
  (MailBabyEmailDeliveryAndManagementServiceClient a) >>= f =
    MailBabyEmailDeliveryAndManagementServiceClient (\env -> do
      value <- a env
      runClient (f value) env)

instance MonadIO MailBabyEmailDeliveryAndManagementServiceClient where
  liftIO io = MailBabyEmailDeliveryAndManagementServiceClient (\_ -> liftIO io)

createMailBabyEmailDeliveryAndManagementServiceClient :: MailBabyEmailDeliveryAndManagementServiceBackend AuthClient MailBabyEmailDeliveryAndManagementServiceClient
createMailBabyEmailDeliveryAndManagementServiceClient = MailBabyEmailDeliveryAndManagementServiceBackend{..}
  where
    ((coerce -> addRule) :<|>
     (coerce -> deleteRule) :<|>
     (coerce -> delistBlock) :<|>
     (coerce -> getMailBlocks) :<|>
     (coerce -> getRules) :<|>
     (coerce -> getStats) :<|>
     (coerce -> viewMailLog) :<|>
     (coerce -> rawMail) :<|>
     (coerce -> sendAdvMail) :<|>
     (coerce -> sendMail) :<|>
     (coerce -> getMailOrderById) :<|>
     (coerce -> getMailOrders) :<|>
     (coerce -> pingServer) :<|>
     _) = client (Proxy :: Proxy MailBabyEmailDeliveryAndManagementServiceAPI)

-- | Run requests in the MailBabyEmailDeliveryAndManagementServiceClient monad.
runMailBabyEmailDeliveryAndManagementServiceClient :: Config -> MailBabyEmailDeliveryAndManagementServiceClient a -> ExceptT ClientError IO a
runMailBabyEmailDeliveryAndManagementServiceClient clientConfig cl = do
  manager <- liftIO $ newManager tlsManagerSettings
  runMailBabyEmailDeliveryAndManagementServiceClientWithManager manager clientConfig cl

-- | Run requests in the MailBabyEmailDeliveryAndManagementServiceClient monad using a custom manager.
runMailBabyEmailDeliveryAndManagementServiceClientWithManager :: Manager -> Config -> MailBabyEmailDeliveryAndManagementServiceClient a -> ExceptT ClientError IO a
runMailBabyEmailDeliveryAndManagementServiceClientWithManager manager Config{..} cl = do
  url <- parseBaseUrl configUrl
  runClient cl $ mkClientEnv manager url

-- | Like @runClient@, but returns the response or throws
--   a MailBabyEmailDeliveryAndManagementServiceClientError
callMailBabyEmailDeliveryAndManagementService
  :: (MonadIO m, MonadThrow m)
  => ClientEnv -> MailBabyEmailDeliveryAndManagementServiceClient a -> m a
callMailBabyEmailDeliveryAndManagementService env f = do
  res <- liftIO $ runExceptT $ runClient f env
  case res of
    Left err       -> throwM (MailBabyEmailDeliveryAndManagementServiceClientError err)
    Right response -> pure response


requestMiddlewareId :: Application -> Application
requestMiddlewareId a = a

-- | Run the MailBabyEmailDeliveryAndManagementService server at the provided host and port.
runMailBabyEmailDeliveryAndManagementServiceServer
  :: (MonadIO m, MonadThrow m)
  => Config -> MailBabyEmailDeliveryAndManagementServiceAuth -> MailBabyEmailDeliveryAndManagementServiceBackend AuthServer (ExceptT ServerError IO) -> m ()
runMailBabyEmailDeliveryAndManagementServiceServer config auth backend = runMailBabyEmailDeliveryAndManagementServiceMiddlewareServer config requestMiddlewareId auth backend

-- | Run the MailBabyEmailDeliveryAndManagementService server at the provided host and port.
runMailBabyEmailDeliveryAndManagementServiceMiddlewareServer
  :: (MonadIO m, MonadThrow m)
  => Config -> Middleware -> MailBabyEmailDeliveryAndManagementServiceAuth -> MailBabyEmailDeliveryAndManagementServiceBackend AuthServer (ExceptT ServerError IO) -> m ()
runMailBabyEmailDeliveryAndManagementServiceMiddlewareServer Config{..} middleware auth backend = do
  url <- parseBaseUrl configUrl
  let warpSettings = Warp.defaultSettings
        & Warp.setPort (baseUrlPort url)
        & Warp.setHost (fromString $ baseUrlHost url)
  liftIO $ Warp.runSettings warpSettings $ middleware $ serverWaiApplicationMailBabyEmailDeliveryAndManagementService auth backend

-- | Plain "Network.Wai" Application for the MailBabyEmailDeliveryAndManagementService server.
--
-- Can be used to implement e.g. tests that call the API without a full webserver.
serverWaiApplicationMailBabyEmailDeliveryAndManagementService :: MailBabyEmailDeliveryAndManagementServiceAuth -> MailBabyEmailDeliveryAndManagementServiceBackend AuthServer (ExceptT ServerError IO) -> Application
serverWaiApplicationMailBabyEmailDeliveryAndManagementService auth backend = serveWithContextT (Proxy :: Proxy MailBabyEmailDeliveryAndManagementServiceAPI) context id (serverFromBackend backend)
  where
    context = serverContext auth
    serverFromBackend MailBabyEmailDeliveryAndManagementServiceBackend{..} =
      (coerce addRule :<|>
       coerce deleteRule :<|>
       coerce delistBlock :<|>
       coerce getMailBlocks :<|>
       coerce getRules :<|>
       coerce getStats :<|>
       coerce viewMailLog :<|>
       coerce rawMail :<|>
       coerce sendAdvMail :<|>
       coerce sendMail :<|>
       coerce getMailOrderById :<|>
       coerce getMailOrders :<|>
       coerce pingServer :<|>
       serveDirectoryFileServer "static")

-- Authentication is implemented with servants generalized authentication:
-- https://docs.servant.dev/en/stable/tutorial/Authentication.html#generalized-authentication

authHandler :: MailBabyEmailDeliveryAndManagementServiceAuth -> AuthHandler Request AuthServer
authHandler MailBabyEmailDeliveryAndManagementServiceAuth{..} = mkAuthHandler handler
  where
    handler req = case lookup "X-API-KEY" (requestHeaders req) of
      Just header -> lookupUser header
      Nothing -> throwError (authError req)

type Protected = AuthProtect "apikey"
type AuthServer = AuthServerData Protected
type AuthClient = AuthenticatedRequest Protected
type instance AuthClientData Protected = Text

clientAuth :: Text -> AuthClient
clientAuth key = mkAuthenticatedRequest key (addHeader "X-API-KEY")

serverContext :: MailBabyEmailDeliveryAndManagementServiceAuth -> Context (AuthHandler Request AuthServer ': '[])
serverContext auth = authHandler auth :. EmptyContext
