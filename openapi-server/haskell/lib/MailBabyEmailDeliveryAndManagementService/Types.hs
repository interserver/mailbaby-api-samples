{-# LANGUAGE GeneralizedNewtypeDeriving #-}
{-# LANGUAGE DeriveDataTypeable         #-}
{-# LANGUAGE DeriveGeneric              #-}
{-# LANGUAGE DuplicateRecordFields      #-}
{-# OPTIONS_GHC -fno-warn-unused-binds -fno-warn-unused-imports #-}

module MailBabyEmailDeliveryAndManagementService.Types (
  DateOrTimestamp (..),
  DenyRuleNew (..),
  DenyRuleRecord (..),
  EmailAddressName (..),
  EmailAddressParam (..),
  EmailAddressTypes (..),
  EmailAddressesTypes (..),
  ErrorMessage (..),
  GenericResponse (..),
  MailAttachment (..),
  MailBlockClickHouse (..),
  MailBlockRspamd (..),
  MailBlocks (..),
  MailLog (..),
  MailLogEntry (..),
  MailOrder (..),
  MailOrderDetail (..),
  MailStatsType (..),
  MailStatsVolume (..),
  SendMail (..),
  SendMailAdv (..),
  SendMailRaw (..),
  SendMailTo (..),
  ) where

import Data.Data (Data)
import Data.UUID (UUID)
import Data.List (lookup)
import Data.Maybe (fromMaybe)
import Data.Aeson (Value, FromJSON(..), ToJSON(..), genericToJSON, genericParseJSON)
import Data.Aeson.Types (Options(..), defaultOptions)
import Data.Set (Set)
import Data.Text (Text)
import Data.Time
import Data.Swagger (ToSchema, declareNamedSchema)
import qualified Data.Swagger as Swagger
import qualified Data.Char as Char
import qualified Data.Text as T
import qualified Data.Map as Map
import GHC.Generics (Generic)


-- | A date/time value accepted as either a Unix timestamp (integer seconds since epoch) or a date string parseable by &#x60;strtotime()&#x60; (e.g. &#x60;2024-01-15&#x60;, &#x60;last monday&#x60;).
data DateOrTimestamp = DateOrTimestamp
  { 
  } deriving (Show, Eq, Generic, Data)

instance FromJSON DateOrTimestamp where
  parseJSON = genericParseJSON optionsDateOrTimestamp
instance ToJSON DateOrTimestamp where
  toJSON = genericToJSON optionsDateOrTimestamp
instance ToSchema DateOrTimestamp where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsDateOrTimestamp

optionsDateOrTimestamp :: Options
optionsDateOrTimestamp =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ 
      ]


-- | The fields required to create a new email deny rule via &#x60;POST /mail/rules&#x60;. The &#x60;type&#x60; controls what &#x60;data&#x60; is matched against: - &#x60;email&#x60; — exact sender address match - &#x60;domain&#x60; — all senders from a domain - &#x60;destination&#x60; — exact recipient address match - &#x60;startswith&#x60; — sender local-part prefix match (alphanumeric + &#x60;+_.-&#x60; only)
data DenyRuleNew = DenyRuleNew
  { denyRuleNewType :: Text -- ^ The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
  , denyRuleNewData :: Text -- ^ The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
  , denyRuleNewUser :: Maybe Text -- ^ Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON DenyRuleNew where
  parseJSON = genericParseJSON optionsDenyRuleNew
instance ToJSON DenyRuleNew where
  toJSON = genericToJSON optionsDenyRuleNew
instance ToSchema DenyRuleNew where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsDenyRuleNew

optionsDenyRuleNew :: Options
optionsDenyRuleNew =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("denyRuleNewType", "type")
      , ("denyRuleNewData", "data")
      , ("denyRuleNewUser", "user")
      ]


-- | A complete deny rule record as returned by &#x60;GET /mail/rules&#x60;.  Combines the rule definition fields (&#x60;DenyRuleNew&#x60;) with server-assigned metadata (&#x60;id&#x60; and &#x60;created&#x60;).  The &#x60;id&#x60; value is required by &#x60;DELETE /mail/rules/{ruleId}&#x60;.
data DenyRuleRecord = DenyRuleRecord
  { denyRuleRecordType :: Text -- ^ The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
  , denyRuleRecordData :: Text -- ^ The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
  , denyRuleRecordId :: Text -- ^ The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule.
  , denyRuleRecordCreated :: UTCTime -- ^ The timestamp when the rule was created.
  , denyRuleRecordUser :: Maybe Text -- ^ Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON DenyRuleRecord where
  parseJSON = genericParseJSON optionsDenyRuleRecord
instance ToJSON DenyRuleRecord where
  toJSON = genericToJSON optionsDenyRuleRecord
instance ToSchema DenyRuleRecord where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsDenyRuleRecord

optionsDenyRuleRecord :: Options
optionsDenyRuleRecord =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("denyRuleRecordType", "type")
      , ("denyRuleRecordData", "data")
      , ("denyRuleRecordId", "id")
      , ("denyRuleRecordCreated", "created")
      , ("denyRuleRecordUser", "user")
      ]


-- | An email contact with an optional display name.  Used in structured address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;) in &#x60;SendMailAdv&#x60;.
data EmailAddressName = EmailAddressName
  { emailAddressNameEmail :: Text -- ^ The email address.
  , emailAddressNameName :: Maybe Text -- ^ Optional display name shown to recipients (e.g. in the `From:` header).
  } deriving (Show, Eq, Generic, Data)

instance FromJSON EmailAddressName where
  parseJSON = genericParseJSON optionsEmailAddressName
instance ToJSON EmailAddressName where
  toJSON = genericToJSON optionsEmailAddressName
instance ToSchema EmailAddressName where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsEmailAddressName

optionsEmailAddressName :: Options
optionsEmailAddressName =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("emailAddressNameEmail", "email")
      , ("emailAddressNameName", "name")
      ]


-- | A single email address parameter used as the body of &#x60;POST /mail/blocks/delete&#x60;.
data EmailAddressParam = EmailAddressParam
  { emailAddressParamEmail :: Text -- ^ The email address to delist from all block lists.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON EmailAddressParam where
  parseJSON = genericParseJSON optionsEmailAddressParam
instance ToJSON EmailAddressParam where
  toJSON = genericToJSON optionsEmailAddressParam
instance ToSchema EmailAddressParam where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsEmailAddressParam

optionsEmailAddressParam :: Options
optionsEmailAddressParam =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("emailAddressParamEmail", "email")
      ]


-- | A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a structured contact object.
data EmailAddressTypes = EmailAddressTypes
  { emailAddressTypesEmail :: Text -- ^ The email address.
  , emailAddressTypesName :: Maybe Text -- ^ Optional display name shown to recipients (e.g. in the `From:` header).
  } deriving (Show, Eq, Generic, Data)

instance FromJSON EmailAddressTypes where
  parseJSON = genericParseJSON optionsEmailAddressTypes
instance ToJSON EmailAddressTypes where
  toJSON = genericToJSON optionsEmailAddressTypes
instance ToSchema EmailAddressTypes where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsEmailAddressTypes

optionsEmailAddressTypes :: Options
optionsEmailAddressTypes =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("emailAddressTypesEmail", "email")
      , ("emailAddressTypesName", "name")
      ]


-- | A flexible email address list that accepts either a plain RFC 822 string or a structured array of contact objects.  When a string is provided it is parsed as a comma-separated list of RFC 822 addresses (supporting the &#x60;\&quot;Name &lt;email&gt;\&quot;&#x60; and bare &#x60;email&#x60; formats).  When an array is provided each entry must have at least an &#x60;email&#x60; field with an optional &#x60;name&#x60; field.
data EmailAddressesTypes = EmailAddressesTypes
  { 
  } deriving (Show, Eq, Generic, Data)

instance FromJSON EmailAddressesTypes where
  parseJSON = genericParseJSON optionsEmailAddressesTypes
instance ToJSON EmailAddressesTypes where
  toJSON = genericToJSON optionsEmailAddressesTypes
instance ToSchema EmailAddressesTypes where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsEmailAddressesTypes

optionsEmailAddressesTypes :: Options
optionsEmailAddressesTypes =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ 
      ]


-- | The response body returned when an error occurs.
data ErrorMessage = ErrorMessage
  { errorMessageCode :: Int -- ^ The HTTP-style status code associated with the error.
  , errorMessageMessage :: Text -- ^ A human-readable description of the error.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON ErrorMessage where
  parseJSON = genericParseJSON optionsErrorMessage
instance ToJSON ErrorMessage where
  toJSON = genericToJSON optionsErrorMessage
instance ToSchema ErrorMessage where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsErrorMessage

optionsErrorMessage :: Options
optionsErrorMessage =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("errorMessageCode", "code")
      , ("errorMessageMessage", "message")
      ]


-- | Standard success response returned by write operations (send, add rule, delete, etc.).  The &#x60;status&#x60; field is always &#x60;\&quot;ok\&quot;&#x60; on success.  The &#x60;text&#x60; field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record&#39;s ID; for delete calls it contains a confirmation string.
data GenericResponse = GenericResponse
  { genericResponseStatus :: Text -- ^ Always `\"ok\"` on success.
  , genericResponseText :: Text -- ^ Operation-specific result string.  For send operations this is the relay transaction ID (e.g. `185caa69ff7000f47c`) which can be used as the `mailid` parameter in `GET /mail/log`.  For create operations this is the new record's numeric ID.  For delete operations this is a human-readable confirmation.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON GenericResponse where
  parseJSON = genericParseJSON optionsGenericResponse
instance ToJSON GenericResponse where
  toJSON = genericToJSON optionsGenericResponse
instance ToSchema GenericResponse where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsGenericResponse

optionsGenericResponse :: Options
optionsGenericResponse =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("genericResponseStatus", "status")
      , ("genericResponseText", "text")
      ]


-- | A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
data MailAttachment = MailAttachment
  { mailAttachmentFilename :: Text -- ^ The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
  , mailAttachmentData :: Text -- ^ The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON MailAttachment where
  parseJSON = genericParseJSON optionsMailAttachment
instance ToJSON MailAttachment where
  toJSON = genericToJSON optionsMailAttachment
instance ToSchema MailAttachment where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsMailAttachment

optionsMailAttachment :: Options
optionsMailAttachment =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("mailAttachmentFilename", "filename")
      , ("mailAttachmentData", "data")
      ]


-- | A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
data MailBlockClickHouse = MailBlockClickHouse
  { mailBlockClickHouseDate :: Day -- ^ The date the block event was recorded.
  , mailBlockClickHouseFrom :: Text -- ^ The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
  , mailBlockClickHouseSubject :: Text -- ^ The `Subject` header of the blocked message.
  , mailBlockClickHouseTo :: Text -- ^ The serialized list of recipients of the blocked message.
  , mailBlockClickHouseMessageId :: Maybe Text -- ^ The `Message-ID` header of the blocked message, or `null` if not present.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON MailBlockClickHouse where
  parseJSON = genericParseJSON optionsMailBlockClickHouse
instance ToJSON MailBlockClickHouse where
  toJSON = genericToJSON optionsMailBlockClickHouse
instance ToSchema MailBlockClickHouse where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsMailBlockClickHouse

optionsMailBlockClickHouse :: Options
optionsMailBlockClickHouse =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("mailBlockClickHouseDate", "date")
      , ("mailBlockClickHouseFrom", "from")
      , ("mailBlockClickHouseSubject", "subject")
      , ("mailBlockClickHouseTo", "to")
      , ("mailBlockClickHouseMessageId", "messageId")
      ]


-- | A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
data MailBlockRspamd = MailBlockRspamd
  { mailBlockRspamdFrom :: Text -- ^ The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.
  , mailBlockRspamdSubject :: Text -- ^ The suspicious subject pattern that triggered the block.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON MailBlockRspamd where
  parseJSON = genericParseJSON optionsMailBlockRspamd
instance ToJSON MailBlockRspamd where
  toJSON = genericToJSON optionsMailBlockRspamd
instance ToSchema MailBlockRspamd where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsMailBlockRspamd

optionsMailBlockRspamd :: Options
optionsMailBlockRspamd =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("mailBlockRspamdFrom", "from")
      , ("mailBlockRspamdSubject", "subject")
      ]


-- | The complete set of blocked addresses and message patterns returned by &#x60;GET /mail/blocks&#x60;. Three independent block sources are combined into one response. Use &#x60;POST /mail/blocks/delete&#x60; with a &#x60;from&#x60; address from any entry to delist it.
data MailBlocks = MailBlocks
  { mailBlocksLocal :: [MailBlockClickHouse] -- ^ Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
  , mailBlocksMbtrap :: [MailBlockClickHouse] -- ^ Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.
  , mailBlocksSubject :: [MailBlockRspamd] -- ^ Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON MailBlocks where
  parseJSON = genericParseJSON optionsMailBlocks
instance ToJSON MailBlocks where
  toJSON = genericToJSON optionsMailBlocks
instance ToSchema MailBlocks where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsMailBlocks

optionsMailBlocks :: Options
optionsMailBlocks =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("mailBlocksLocal", "local")
      , ("mailBlocksMbtrap", "mbtrap")
      , ("mailBlocksSubject", "subject")
      ]


-- | Paginated mail log response returned by &#x60;GET /mail/log&#x60;.  Contains the full matched count (&#x60;total&#x60;) plus a page of &#x60;MailLogEntry&#x60; records.  Use &#x60;skip&#x60; and &#x60;limit&#x60; to page through large result sets.
data MailLog = MailLog
  { mailLogTotal :: Int -- ^ Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.
  , mailLogSkip :: Int -- ^ The `skip` value used for this page (echoed from the request).
  , mailLogLimit :: Int -- ^ The `limit` value used for this page (echoed from the request).
  , mailLogEmails :: [MailLogEntry] -- ^ 
  } deriving (Show, Eq, Generic, Data)

instance FromJSON MailLog where
  parseJSON = genericParseJSON optionsMailLog
instance ToJSON MailLog where
  toJSON = genericToJSON optionsMailLog
instance ToSchema MailLog where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsMailLog

optionsMailLog :: Options
optionsMailLog =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("mailLogTotal", "total")
      , ("mailLogSkip", "skip")
      , ("mailLogLimit", "limit")
      , ("mailLogEmails", "emails")
      ]


-- | A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.
data MailLogEntry = MailLogEntry
  { mailLogEntryUnderscoreid :: Int -- ^ Internal auto-increment database row ID.  Not meaningful outside the API.
  , mailLogEntryId :: Text -- ^ The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.
  , mailLogEntryFrom :: Text -- ^ SMTP envelope `MAIL FROM` address (may differ from the `From:` header).
  , mailLogEntryTo :: Text -- ^ SMTP envelope `RCPT TO` address.
  , mailLogEntryCreated :: Text -- ^ Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.
  , mailLogEntryTime :: Int -- ^ Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.
  , mailLogEntryUser :: Text -- ^ The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.
  , mailLogEntryTranstype :: Text -- ^ SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).
  , mailLogEntryOrigin :: Text -- ^ IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.
  , mailLogEntryInterface :: Text -- ^ Relay interface name that accepted the message (e.g. `feeder`).
  , mailLogEntrySubject :: Maybe Text -- ^ The `Subject` header value, if available.
  , mailLogEntryMessageId :: Maybe Text -- ^ The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
  , mailLogEntrySendingZone :: Maybe Text -- ^ The sending zone assigned by the relay for outbound delivery.
  , mailLogEntryBodySize :: Maybe Int -- ^ Size of the message body in bytes.
  , mailLogEntrySeq :: Maybe Int -- ^ Sequence index of this recipient in a multi-recipient message. Starts at 1.
  , mailLogEntryDelivered :: Maybe Int -- ^ Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
  , mailLogEntryCode :: Maybe Int -- ^ The SMTP response code from the destination MX server (e.g. `250` for success, `550` for permanent failure).
  , mailLogEntryResponse :: Maybe Text -- ^ The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
  , mailLogEntryRecipient :: Maybe Text -- ^ The specific recipient address this delivery record is for.
  , mailLogEntryDomain :: Maybe Text -- ^ The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
  , mailLogEntryLocked :: Maybe Int -- ^ Whether the queue entry is currently locked for delivery processing.
  , mailLogEntryLockTime :: Maybe Text -- ^ Millisecond-precision timestamp of the last queue lock acquisition.
  , mailLogEntryAssigned :: Maybe Text -- ^ The relay server node assigned to deliver this message.
  , mailLogEntryQueued :: Maybe Text -- ^ ISO 8601 timestamp when the message was placed into the delivery queue.
  , mailLogEntryMxHostname :: Maybe Text -- ^ The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON MailLogEntry where
  parseJSON = genericParseJSON optionsMailLogEntry
instance ToJSON MailLogEntry where
  toJSON = genericToJSON optionsMailLogEntry
instance ToSchema MailLogEntry where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsMailLogEntry

optionsMailLogEntry :: Options
optionsMailLogEntry =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("mailLogEntryUnderscoreid", "_id")
      , ("mailLogEntryId", "id")
      , ("mailLogEntryFrom", "from")
      , ("mailLogEntryTo", "to")
      , ("mailLogEntryCreated", "created")
      , ("mailLogEntryTime", "time")
      , ("mailLogEntryUser", "user")
      , ("mailLogEntryTranstype", "transtype")
      , ("mailLogEntryOrigin", "origin")
      , ("mailLogEntryInterface", "interface")
      , ("mailLogEntrySubject", "subject")
      , ("mailLogEntryMessageId", "messageId")
      , ("mailLogEntrySendingZone", "sendingZone")
      , ("mailLogEntryBodySize", "bodySize")
      , ("mailLogEntrySeq", "seq")
      , ("mailLogEntryDelivered", "delivered")
      , ("mailLogEntryCode", "code")
      , ("mailLogEntryResponse", "response")
      , ("mailLogEntryRecipient", "recipient")
      , ("mailLogEntryDomain", "domain")
      , ("mailLogEntryLocked", "locked")
      , ("mailLogEntryLockTime", "lockTime")
      , ("mailLogEntryAssigned", "assigned")
      , ("mailLogEntryQueued", "queued")
      , ("mailLogEntryMxHostname", "mxHostname")
      ]


-- | A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The &#x60;id&#x60; is the numeric identifier used across most API calls.  The &#x60;username&#x60; is always &#x60;mb&lt;id&gt;&#x60; and is the SMTP AUTH username for &#x60;relay.mailbaby.net&#x60;.
data MailOrder = MailOrder
  { mailOrderId :: Int -- ^ The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
  , mailOrderStatus :: Text -- ^ The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
  , mailOrderUsername :: Text -- ^ The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
  , mailOrderComment :: Maybe Text -- ^ Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON MailOrder where
  parseJSON = genericParseJSON optionsMailOrder
instance ToJSON MailOrder where
  toJSON = genericToJSON optionsMailOrder
instance ToSchema MailOrder where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsMailOrder

optionsMailOrder :: Options
optionsMailOrder =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("mailOrderId", "id")
      , ("mailOrderStatus", "status")
      , ("mailOrderUsername", "username")
      , ("mailOrderComment", "comment")
      ]


-- | Extended mail order record including the current SMTP password.  Returned by &#x60;GET /mail/{id}&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; fields can be used to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
data MailOrderDetail = MailOrderDetail
  { mailOrderDetailId :: Int -- ^ The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
  , mailOrderDetailStatus :: Text -- ^ The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
  , mailOrderDetailUsername :: Text -- ^ The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
  , mailOrderDetailPassword :: Text -- ^ The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.
  , mailOrderDetailComment :: Maybe Text -- ^ Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON MailOrderDetail where
  parseJSON = genericParseJSON optionsMailOrderDetail
instance ToJSON MailOrderDetail where
  toJSON = genericToJSON optionsMailOrderDetail
instance ToSchema MailOrderDetail where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsMailOrderDetail

optionsMailOrderDetail :: Options
optionsMailOrderDetail =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("mailOrderDetailId", "id")
      , ("mailOrderDetailStatus", "status")
      , ("mailOrderDetailUsername", "username")
      , ("mailOrderDetailPassword", "password")
      , ("mailOrderDetailComment", "comment")
      ]


-- | Account usage statistics returned by &#x60;GET /mail/stats&#x60;.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
data MailStatsType = MailStatsType
  { mailStatsTypeTime :: Maybe Text -- ^ The time window these `received`, `sent`, and `volume` statistics cover.
  , mailStatsTypeUsage :: Maybe Int -- ^ Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
  , mailStatsTypeCurrency :: Maybe Text -- ^ The ISO 4217 currency code for this account (e.g. `USD`).
  , mailStatsTypeCost :: Maybe Double -- ^ Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
  , mailStatsTypeReceived :: Maybe Int -- ^ Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
  , mailStatsTypeSent :: Maybe Int -- ^ Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
  , mailStatsTypeVolume :: Maybe MailStatsVolume -- ^ 
  } deriving (Show, Eq, Generic, Data)

instance FromJSON MailStatsType where
  parseJSON = genericParseJSON optionsMailStatsType
instance ToJSON MailStatsType where
  toJSON = genericToJSON optionsMailStatsType
instance ToSchema MailStatsType where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsMailStatsType

optionsMailStatsType :: Options
optionsMailStatsType =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("mailStatsTypeTime", "time")
      , ("mailStatsTypeUsage", "usage")
      , ("mailStatsTypeCurrency", "currency")
      , ("mailStatsTypeCost", "cost")
      , ("mailStatsTypeReceived", "received")
      , ("mailStatsTypeSent", "sent")
      , ("mailStatsTypeVolume", "volume")
      ]


-- | Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
data MailStatsVolume = MailStatsVolume
  { mailStatsVolumeTo :: Maybe (Map.Map String Int) -- ^ Message counts keyed by destination (envelope `to`) email address.
  , mailStatsVolumeFrom :: Maybe (Map.Map String Int) -- ^ Message counts keyed by sender (envelope `from`) email address.
  , mailStatsVolumeIp :: Maybe (Map.Map String Int) -- ^ Message counts keyed by originating client IP address.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON MailStatsVolume where
  parseJSON = genericParseJSON optionsMailStatsVolume
instance ToJSON MailStatsVolume where
  toJSON = genericToJSON optionsMailStatsVolume
instance ToSchema MailStatsVolume where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsMailStatsVolume

optionsMailStatsVolume :: Options
optionsMailStatsVolume =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("mailStatsVolumeTo", "to")
      , ("mailStatsVolumeFrom", "from")
      , ("mailStatsVolumeIp", "ip")
      ]


-- | Request body for &#x60;POST /mail/send&#x60;.  Sends a simple single-recipient message. HTML detection is automatic — if &#x60;body&#x60; contains HTML tags the message is sent as &#x60;text/html&#x60;; otherwise as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is automatically set as both the &#x60;From&#x60; and &#x60;Reply-To&#x60; headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use &#x60;POST /mail/advsend&#x60; instead.
data SendMail = SendMail
  { sendMailTo :: SendMailTo -- ^ 
  , sendMailFrom :: Text -- ^ The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
  , sendMailSubject :: Text -- ^ The subject line of the email.
  , sendMailBody :: Text -- ^ The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
  , sendMailId :: Maybe Integer -- ^ Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON SendMail where
  parseJSON = genericParseJSON optionsSendMail
instance ToJSON SendMail where
  toJSON = genericToJSON optionsSendMail
instance ToSchema SendMail where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsSendMail

optionsSendMail :: Options
optionsSendMail =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("sendMailTo", "to")
      , ("sendMailFrom", "from")
      , ("sendMailSubject", "subject")
      , ("sendMailBody", "body")
      , ("sendMailId", "id")
      ]


-- | Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.
data SendMailAdv = SendMailAdv
  { sendMailAdvSubject :: Text -- ^ The subject line of the email.
  , sendMailAdvBody :: Text -- ^ The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
  , sendMailAdvFrom :: EmailAddressTypes -- ^ The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.
  , sendMailAdvTo :: EmailAddressesTypes -- ^ One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
  , sendMailAdvReplyto :: Maybe EmailAddressesTypes -- ^ Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.
  , sendMailAdvCc :: Maybe EmailAddressesTypes -- ^ Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.
  , sendMailAdvBcc :: Maybe EmailAddressesTypes -- ^ Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
  , sendMailAdvAttachments :: Maybe [MailAttachment] -- ^ Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
  , sendMailAdvId :: Maybe Integer -- ^ Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON SendMailAdv where
  parseJSON = genericParseJSON optionsSendMailAdv
instance ToJSON SendMailAdv where
  toJSON = genericToJSON optionsSendMailAdv
instance ToSchema SendMailAdv where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsSendMailAdv

optionsSendMailAdv :: Options
optionsSendMailAdv =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("sendMailAdvSubject", "subject")
      , ("sendMailAdvBody", "body")
      , ("sendMailAdvFrom", "from")
      , ("sendMailAdvTo", "to")
      , ("sendMailAdvReplyto", "replyto")
      , ("sendMailAdvCc", "cc")
      , ("sendMailAdvBcc", "bcc")
      , ("sendMailAdvAttachments", "attachments")
      , ("sendMailAdvId", "id")
      ]


-- | Request body for &#x60;POST /mail/rawsend&#x60;.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing &#x60;DKIM-Signature&#x60; header intact.  The &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, and &#x60;Bcc&#x60; addresses are extracted from the message headers automatically — you do not need to specify them separately.
data SendMailRaw = SendMailRaw
  { sendMailRawRawUnderscoreemail :: Text -- ^ The complete RFC 822 email message including all headers and the body. Must include at minimum `From`, `To`, `Subject`, `Date`, and `MIME-Version` headers.  DKIM signatures in the `DKIM-Signature` header are transmitted verbatim and will pass verification at the destination.
  , sendMailRawId :: Maybe Integer -- ^ Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by `GET /mail`.
  } deriving (Show, Eq, Generic, Data)

instance FromJSON SendMailRaw where
  parseJSON = genericParseJSON optionsSendMailRaw
instance ToJSON SendMailRaw where
  toJSON = genericToJSON optionsSendMailRaw
instance ToSchema SendMailRaw where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsSendMailRaw

optionsSendMailRaw :: Options
optionsSendMailRaw =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ ("sendMailRawRawUnderscoreemail", "raw_email")
      , ("sendMailRawId", "id")
      ]


-- | The primary recipient address for a simple send request. Accepts a single email address string or an array of email address strings for multiple recipients.
data SendMailTo = SendMailTo
  { 
  } deriving (Show, Eq, Generic, Data)

instance FromJSON SendMailTo where
  parseJSON = genericParseJSON optionsSendMailTo
instance ToJSON SendMailTo where
  toJSON = genericToJSON optionsSendMailTo
instance ToSchema SendMailTo where
  declareNamedSchema = Swagger.genericDeclareNamedSchema
    $ Swagger.fromAesonOptions
    $ optionsSendMailTo

optionsSendMailTo :: Options
optionsSendMailTo =
  defaultOptions
    { omitNothingFields  = True
    , fieldLabelModifier = \s -> fromMaybe ("did not find JSON field name for " ++ show s) $ lookup s table
    }
  where
    table =
      [ 
      ]

