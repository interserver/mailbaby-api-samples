--  MailBaby Email Delivery and Management Service API
--  **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**  # Overview  This is the API interface to the [Mail Baby](https://mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).  # Mail Orders  Every sending account in MailBaby is backed by a **Mail Order** — a provisioned sending credential with a numeric `id` and a corresponding SMTP username (`mb<id>`).  Most calls accept an optional `id` parameter; when omitted the API automatically selects the first active order on your account. Use `GET /mail` to list all orders, and `GET /mail/{id}` to inspect a single order including its current SMTP password.  # Sending Email  Three sending methods are available depending on your use_case: | Endpoint | Best for | |__________|__________| | `POST /mail/send` | Simple single_recipient messages | | `POST /mail/advsend` | Multiple recipients, CC/BCC, attachments, named contacts | | `POST /mail/rawsend` | Pre_built RFC 822 messages (e.g. DKIM_signed payloads) |  After a successful send each endpoint returns a `GenericResponse` whose `text` field contains the **transaction ID** assigned by the relay.  This ID can later be matched against entries in `GET /mail/log` via the `mailid` query parameter.  # Filtering & Logs  `GET /mail/log` provides paginated access to every message accepted by the relay for your account. Combine any of the query parameters to narrow results — e.g. `from`, `to`, `subject`, `messageId`, `origin`, `mx`, `startDate`/`endDate`, and `delivered`.  # Blocking  Two independent mechanisms exist for suppressing unwanted email: _ **Block lists** (`GET /mail/blocks`, `POST /mail/blocks/delete`) — addresses flagged by the   system spam filters (LOCAL_BL_RCPT / MBTRAP rules in rspamd, and suspicious subjects). _ **Deny rules** (`GET /mail/rules`, `POST /mail/rules`, `DELETE /mail/rules/{ruleId}`) —   custom rules you configure to reject specific senders, domains, destination addresses, or   subject_line prefixes before a message is even attempted.   # Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. Pass your key in the `X_API_KEY` HTTP request header for every protected call. 
--  ------------ EDIT NOTE ------------
--  This file was generated with openapi-generator.  You can modify it to implement
--  the server.  After you modify this file, you should add the following line
--  to the .openapi-generator-ignore file:
--
--  src/-servers.adb
--
--  Then, you can drop this edit note comment.
--  ------------ EDIT NOTE ------------
package body .Servers is


   --  Create a deny rule to block a sender, domain, destination, or prefix
   --  **Use this to prevent future relay attempts that match a pattern.** Required: `type` (`email`, `domain`, `destination`, or `startswith`) and `data` (the value to match). Optional: `user` (SMTP username; auto-selects first active order if omitted). Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.
   --  
   --  The `type` field selects the matching strategy:
   --  - **`email`** — exact match against the SMTP envelope `MAIL FROM` address. - **`domain`** — matches any sender address at the specified domain. - **`destination`** — exact match against the SMTP envelope `RCPT TO` address. - **`startswith`** — matches any sender address whose local-part (the portion
   --    before the `@`) starts with the given string.  Only alphanumeric characters
   --    and `+`, `_`, `.`, `-` are permitted in the prefix.
   --  
   --  
   --  If `username` is provided it must be the SMTP username of one of your active mail orders (e.g. `mb20682`).  If omitted the rule is associated with your first active order.
   --  
   --  On success the response `text` field contains the newly created rule's `id`, which can later be passed to `DELETE /mail/rules/{ruleId}` to remove it.
   overriding
   procedure Add_Rule
      (Server : in out Server_Type;
       P_Type : in Swagger.UString;
       Data : in Swagger.UString;
       User : in Swagger.Nullable_UString;
       Result  : out .Models.GenericResponse_Type;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end Add_Rule;

   --  Delete a deny rule by its numeric ruleId
   --  **Destructive — permanently removes the rule.** Required: `ruleId` (path param; obtain from the `id` field returned by `GET /mail/rules` or the `text` field returned by `POST /mail/rules`). Permanently removes a single deny rule identified by its numeric `ruleId`.
   --  
   --  The `ruleId` is the `id` field returned by `GET /mail/rules` or the `text` field from a successful `POST /mail/rules` response.
   --  
   --  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account.
   overriding
   procedure Delete_Rule
      (Server : in out Server_Type;
       Rule_Id : in Integer;
       Result  : out .Models.GenericResponse_Type;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end Delete_Rule;

   --  Delist an email address from the spam_filter block lists
   --  **Destructive — wipes block records for the given address.** Required: `email` (must be a valid address; typically a `from` value previously returned by `GET /mail/blocks` or `GET /mail/log`). Delists an email address from all three block list stores:
   --  1. The rspamd spam-filter database (`fromemail` / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.
   --  
   --  Use `GET /mail/blocks` to discover which addresses are currently blocked.  The `from` field in any returned block entry is a valid input for this call.
   --  
   --  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules.
   overriding
   procedure Delist_Block
      (Server : in out Server_Type;
       Email_Address_Param_Type : in EmailAddressParam_Type;
       Result  : out .Models.GenericResponse_Type;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end Delist_Block;

   --  List addresses currently flagged by spam_filter block lists
   --  **Use this to discover which addresses to delist.** The `from` value of any returned entry can be passed to `POST /mail/blocks/delete` (as the `email` field) to remove the block. Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s). Three categories are returned:
   --  
   --  - **`local`** — messages flagged by the `LOCAL_BL_RCPT` rspamd rule.  These are
   --    messages sent to recipients on your account's local block list.
   --  - **`mbtrap`** — messages flagged by the `MBTRAP` rspamd rule.  These are messages
   --    that triggered MailBaby's internal trap / honeypot detection.
   --  - **`subject`** — senders whose recent messages contain spam-indicative subjects
   --    (strings containing `@`, `smtp`, `socks4`, or `socks5`) with high repetition
   --    (more than 4 identical subjects from the same sender in the last 3 days).
   --  
   --  
   --  The `local` and `mbtrap` results cover the last 5 days.  The `subject` results cover the last 3 days.
   --  
   --  A sender address returned in any of these lists can be delisted using `POST /mail/blocks/delete` with the `email` field set to that address.
   overriding
   procedure Get_Mail_Blocks
      (Server : in out Server_Type
       ;
       Result  : out .Models.MailBlocks_Type;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end Get_Mail_Blocks;

   --  List custom deny rules (sender / domain / destination / prefix)
   --  **Use this to inspect or pick a `ruleId` to delete.** Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.
   --  
   --  Four rule types are supported:
   --  | `type` | `data` format | Effect | |--------|---------------|--------| | `email` | `user@domain.com` | Rejects any message from this exact sender address | | `domain` | `domain.com` | Rejects any message from any address at this domain | | `destination` | `user@domain.com` | Rejects any message addressed to this recipient | | `startswith` | `prefix` | Rejects any message whose sender address begins with this string (alphanumeric, `+`, `_`, `.`, `-` only) |
   --  
   --  Use `POST /mail/rules` to add new rules and `DELETE /mail/rules/{ruleId}` to remove them.  The `id` field in each returned record is the value needed for the delete call.
   overriding
   procedure Get_Rules
      (Server : in out Server_Type
       ;
       Result  : out ;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end Get_Rules;

   --  Account usage, cost, and volume statistics for a time window
   --  **Use this for dashboards or billing-cycle reviews.** Returns aggregate sending statistics for your mail account(s). The `time` query param controls the window for `received`, `sent`, and `volume` (`1h`, `24h`, `7d`, `month`, `day`, `billing`, `all`). The `usage` and `cost` fields are always for the current billing cycle, regardless of `time`.
   --  
   --  The response includes:
   --  - **`usage`** — total messages accepted by the relay during the current billing
   --    cycle (used for cost calculation).
   --  - **`cost`** — estimated cost for the billing cycle based on the base plan price
   --    plus per-email charges.
   --  - **`received`** / **`sent`** — count of messages accepted by the relay /
   --    successfully delivered to the destination MX within the selected `time` window.
   --  - **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),
   --    destination address (`to`), and sender address (`from`) within the selected window.
   --  
   --  
   --  **Time windows** (controlled by the `time` parameter):
   --  | Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time |
   overriding
   procedure Get_Stats
      (Server : in out Server_Type;
       Time : in Swagger.Nullable_UString;
       Result  : out .Models.MailStatsType_Type;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end Get_Stats;

   --  Query the mail delivery log (filterable, paginated)
   --  **Use this to find or audit sent messages.** All filters are optional and combinable. The most useful filters: `mailid` (the transaction id returned by a send call), `from` / `to` (envelope addresses), `subject`, `messageId` (case-insensitive substring on the `Message-ID` header), `delivered` (`1`=delivered, `0`=queued/failed), and the `startDate`/`endDate` date range. Returns a paginated list of every email message accepted by the relay for your mail account(s).
   --  
   --  **Row grouping** is controlled by the `groupby` parameter.  By default (`groupby=recipient`), the response contains one row per delivery attempt — so a single message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and `mxHostname` values.  Set `groupby=message` to collapse to one row per message (delivery fields will reflect one arbitrary recipient).
   --  
   --  **Pagination** is controlled by `skip` and `limit`.  The `total` in the response reflects the row count **after** grouping, so it matches the number of pages you need to fetch.
   --  
   --  **Date filtering** accepts either a Unix timestamp (integer) or a date string parseable by PHP `strtotime()` such as `2024-01-15`, `last monday`, or `2024-01-01 00:00:00`.  Examples: `startDate=1704067200&endDate=1706745599` or `startDate=2024-01-01&endDate=2024-01-31`.
   --  
   --  **Sorting** is controlled by `sort` and `dir`.  Currently the only sort key is `time` (default), which orders by internal row ID.
   --  
   --  **Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.
   --  
   --  **Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.
   --  
   --  The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.
   --  
   --  The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match).
   overriding
   procedure View_Mail_Log
      (Server : in out Server_Type;
       Id : in Swagger.Nullable_Long;
       Origin : in Swagger.Nullable_UString;
       Mx : in Swagger.Nullable_UString;
       From : in Swagger.Nullable_UString;
       To : in Swagger.Nullable_UString;
       Subject : in Swagger.Nullable_UString;
       Mailid : in Swagger.Nullable_UString;
       Message_Id : in Swagger.Nullable_UString;
       Replyto : in Swagger.Nullable_UString;
       Headerfrom : in Swagger.Nullable_UString;
       Delivered : in Swagger.Nullable_Integer;
       Skip : in Swagger.Nullable_Integer;
       Limit : in Swagger.Nullable_Integer;
       Start_Date : in Swagger.Nullable_UString;
       End_Date : in Swagger.Nullable_UString;
       Sort : in Swagger.Nullable_UString;
       Dir : in Swagger.Nullable_UString;
       Groupby : in Swagger.Nullable_UString;
       Result  : out .Models.MailLog_Type;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end View_Mail_Log;

   --  Send a pre_built RFC 822 message verbatim (preserves DKIM)
   --  **Use this when you have already built (and possibly DKIM-signed) the full RFC 822 message yourself** and want the relay to transmit it byte-for-byte. Required: `raw_email` (full RFC 822 string with headers + body). Optional: `id` (mail order to authenticate as). Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.
   --  
   --  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact. If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.
   --  
   --  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.
   --  
   --  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.
   --  
   --  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record.
   overriding
   procedure Raw_Mail
      (Server : in out Server_Type;
       Send_Mail_Raw_Type : in SendMailRaw_Type;
       Result  : out .Models.GenericResponse_Type;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end Raw_Mail;

   --  Send email with multiple recipients, CC/BCC, attachments, named contacts
   --  **Use this when the simple send is not enough** — multiple recipients, CC/BCC, named contacts, custom Reply-To, or file attachments. Required: `from`, `to`, `subject`, `body`. Optional: `cc`, `bcc`, `replyto`, `attachments` (array of `{filename,data}` with base64 data), `id`. Sends through one of your mail orders with full control over recipients, headers, and attachments.
   --  
   --  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `"Joe <joe@example.com>, jane@example.com"`) and the structured `[{"email":"...","name":"..."}]` array format.  When using JSON, both formats are equally supported.
   --  
   --  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.
   --  
   --  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.
   --  
   --  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.
   --  
   --  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.
   --  
   --  ## Examples
   --  
   --  ### Form — basic string addresses
   --  ```sh curl -X POST https://api.mailbaby.net/mail/advsend \
   --    -H 'X-API-KEY: YOUR_API_KEY' \
   --    -H 'Content-Type: application/x-www-form-urlencoded' \
   --    -d 'subject=Welcome' \
   --    -d 'body=Hello' \
   --    -d from=user@domain.com \
   --    -d to=support@interserver.net
   --  ```
   --  ### Form — RFC 822 named addresses
   --  ```sh curl -X POST https://api.mailbaby.net/mail/advsend \
   --    -H 'X-API-KEY: YOUR_API_KEY' \
   --    -H 'Content-Type: application/x-www-form-urlencoded' \
   --    -d 'subject=Welcome' \
   --    -d 'body=Hello' \
   --    -d 'from=Joe <user@domain.com>' \
   --    -d 'to=Jane <support@interserver.net>'
   --  ```
   --  ### Form — multiple recipients as array
   --  ```sh curl -X POST https://api.mailbaby.net/mail/advsend \
   --    -H 'X-API-KEY: YOUR_API_KEY' \
   --    -H 'Content-Type: application/x-www-form-urlencoded' \
   --    -d 'subject=Welcome' -d 'body=Hello' \
   --    -d from=user@domain.com \
   --    -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \
   --    -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net'
   --  ```
   --  ### JSON — structured objects
   --  ```sh curl -X POST https://api.mailbaby.net/mail/advsend \
   --    -H 'X-API-KEY: YOUR_API_KEY' \
   --    -H 'Content-Type: application/json' \
   --    -d '{
   --      "subject": "Welcome",
   --      "body": "<h1>Hello</h1>",
   --      "from": {"email": "user@domain.com", "name": "Sender Name"},
   --      "to": [{"email": "joe@client.com", "name": "Joe Client"}],
   --      "cc": [{"email": "manager@client.com"}],
   --      "attachments": [{"filename": "report.pdf", "data": "BASE64_DATA"}]
   --    }'
   --  ```
   overriding
   procedure Send_Adv_Mail
      (Server : in out Server_Type;
       Subject : in Swagger.UString;
       P_Body : in Swagger.UString;
       From : in .Models.EmailAddressTypes_Type;
       To : in .Models.EmailAddressesTypes_Type;
       Replyto : in .Models.EmailAddressesTypes_Type;
       Cc : in .Models.EmailAddressesTypes_Type;
       Bcc : in .Models.EmailAddressesTypes_Type;
       Attachments : in .Models.MailAttachment_Type_Vectors.Vector;
       Id : in Swagger.Nullable_Long;
       Result  : out .Models.GenericResponse_Type;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end Send_Adv_Mail;

   --  Send a simple email (single recipient, plain or HTML)
   --  **Use this for the simplest case** — one or a few plain-string recipients, no attachments, no CC/BCC, no named contacts. Required: `from`, `to`, `subject`, `body`. Optional: `id` (selects which mail order to send through; auto-selects your first active order if omitted). Sends through one of your mail orders using a flat set of fields.
   --  
   --  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.
   --  
   --  The `from` address is also automatically set as the `Reply-To` header.
   --  
   --  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.
   --  
   --  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record.
   overriding
   procedure Send_Mail
      (Server : in out Server_Type;
       To : in .Models.SendMailTo_Type;
       From : in Swagger.UString;
       Subject : in Swagger.UString;
       P_Body : in Swagger.UString;
       Id : in Swagger.Nullable_Long;
       Result  : out .Models.GenericResponse_Type;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end Send_Mail;

   --  Get one mail order's full detail including SMTP password
   --  **Returns the SMTP password** in addition to the basic `GET /mail` fields. Use when you need to authenticate against `relay.mailbaby.net:25` from an SMTP client directly. Required: `id` (path; obtain from `GET /mail`). Returns the full detail record for one specific mail order identified by its numeric `id`.
   --  
   --  The `username` and `password` values returned here can be used directly to authenticate against `relay.mailbaby.net:25` (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.
   --  
   --  The `id` path parameter is the same integer `id` value returned by `GET /mail`.
   overriding
   procedure Get_Mail_Order_By_Id
      (Server : in out Server_Type;
       Id : in Swagger.Long;
       Result  : out .Models.MailOrderDetail_Type;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end Get_Mail_Order_By_Id;

   --  List your provisioned mail orders (sending accounts)
   --  Use this **before sending** if you need to discover which mail order `id` to pass to `/mail/send`, `/mail/advsend`, `/mail/rawsend`, `/mail/log`, or `/mail/stats`. Returns every mail order (active **and** canceled) on your account. Each record includes the numeric `id`, the `status` (`active` or `canceled`), the SMTP `username` (always `mb<id>`), and an optional `comment`.
   --  
   --  The `id` values returned here are used as the `id` input parameter on all sending endpoints (`/mail/send`, `/mail/advsend`, `/mail/rawsend`) as well as the log and stats queries.  When the `id` parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.
   --  
   --  To retrieve full details — including the current SMTP password — for a single order use `GET /mail/{id}`.
   overriding
   procedure Get_Mail_Orders
      (Server : in out Server_Type
       ;
       Result  : out ;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end Get_Mail_Orders;

   --  Health check — verify the API is reachable
   --  **No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests.
   overriding
   procedure Ping_Server
      (Server : in out Server_Type
       ;
       Result  : out Swagger.UString;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end Ping_Server;

end .Servers;
