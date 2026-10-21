require "json"

module OpenAPIClient
  module Api
  class Mail
    def initialize(@conn : Connection); end

    # Send email with multiple recipients, CC/BCC, attachments, named contacts **Use this when the simple send is not enough** — multiple recipients, CC/BCC, named contacts, custom Reply-To, or file attachments. Required: &#x60;from&#x60;, &#x60;to&#x60;, &#x60;subject&#x60;, &#x60;body&#x60;. Optional: &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;, &#x60;attachments&#x60; (array of &#x60;{filename,data}&#x60; with base64 data), &#x60;id&#x60;. Sends through one of your mail orders with full control over recipients, headers, and attachments.  **Content-type flexibility** — the request body may be submitted as either &#x60;application/x-www-form-urlencoded&#x60; or &#x60;application/json&#x60;.  When using form encoding, address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) accept both a plain RFC 822 comma-separated string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;, jane@example.com\&quot;&#x60;) and the structured &#x60;[{\&quot;email\&quot;:\&quot;...\&quot;,\&quot;name\&quot;:\&quot;...\&quot;}]&#x60; array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if &#x60;body&#x60; contains HTML tags the &#x60;Content-Type&#x60; is set to &#x60;text/html&#x60;; otherwise &#x60;text/plain&#x60;.  **Attachments** must be base64-encoded.  Each attachment requires at least a &#x60;data&#x60; field; the optional &#x60;filename&#x60; field controls the attachment name shown to recipients.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response &#x60;text&#x60; field contains the relay transaction ID which can be looked up in &#x60;GET /mail/log&#x60; via the &#x60;mailid&#x60; query parameter.  ## Examples  ### Form — basic string addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/x-www-form-urlencoded&#39; \\   -d &#39;subject&#x3D;Welcome&#39; \\   -d &#39;body&#x3D;Hello&#39; \\   -d from&#x3D;user@domain.com \\   -d to&#x3D;support@interserver.net &#x60;&#x60;&#x60; ### Form — RFC 822 named addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/x-www-form-urlencoded&#39; \\   -d &#39;subject&#x3D;Welcome&#39; \\   -d &#39;body&#x3D;Hello&#39; \\   -d &#39;from&#x3D;Joe &lt;user@domain.com&gt;&#39; \\   -d &#39;to&#x3D;Jane &lt;support@interserver.net&gt;&#39; &#x60;&#x60;&#x60; ### Form — multiple recipients as array &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/x-www-form-urlencoded&#39; \\   -d &#39;subject&#x3D;Welcome&#39; -d &#39;body&#x3D;Hello&#39; \\   -d from&#x3D;user@domain.com \\   -d &#39;to[0][name]&#x3D;Joe&#39; -d &#39;to[0][email]&#x3D;support@interserver.net&#39; \\   -d &#39;to[1][name]&#x3D;Jane&#39; -d &#39;to[1][email]&#x3D;jane@interserver.net&#39; &#x60;&#x60;&#x60; ### JSON — structured objects &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -d &#39;{     \&quot;subject\&quot;: \&quot;Welcome\&quot;,     \&quot;body\&quot;: \&quot;&lt;h1&gt;Hello&lt;/h1&gt;\&quot;,     \&quot;from\&quot;: {\&quot;email\&quot;: \&quot;user@domain.com\&quot;, \&quot;name\&quot;: \&quot;Sender Name\&quot;},     \&quot;to\&quot;: [{\&quot;email\&quot;: \&quot;joe@client.com\&quot;, \&quot;name\&quot;: \&quot;Joe Client\&quot;}],     \&quot;cc\&quot;: [{\&quot;email\&quot;: \&quot;manager@client.com\&quot;}],     \&quot;attachments\&quot;: [{\&quot;filename\&quot;: \&quot;report.pdf\&quot;, \&quot;data\&quot;: \&quot;BASE64_DATA\&quot;}]   }&#39; &#x60;&#x60;&#x60; 
    def advsend(subject : String? = nil, body : String? = nil, from : OpenAPIClient::EmailAddressTypes? = nil, to : OpenAPIClient::EmailAddressesTypes? = nil, replyto : OpenAPIClient::EmailAddressesTypes? = nil, cc : OpenAPIClient::EmailAddressesTypes? = nil, bcc : OpenAPIClient::EmailAddressesTypes? = nil, attachments : Array(OpenAPIClient::MailAttachment)? = nil, id : Int64? = nil) : Response(OpenAPIClient::GenericResponse)
      @conn.request(OpenAPIClient::GenericResponse,
        method: :POST,
        path: "/mail/advsend",
        form: Hash(String, Crest::ParamsValue){ "subject" => subject, "body" => body, "from" => from, "to" => to, "replyto" => replyto, "cc" => cc, "bcc" => bcc, "attachments" => attachments, "id" => id },
        accept: %w[application/json],
        auth: %w[apiKeyAuth])
    end

    # List addresses currently flagged by spam-filter block lists **Use this to discover which addresses to delist.** The &#x60;from&#x60; value of any returned entry can be passed to &#x60;POST /mail/blocks/delete&#x60; (as the &#x60;email&#x60; field) to remove the block. Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s). Three categories are returned:  - **&#x60;local&#x60;** — messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule.  These are   messages sent to recipients on your account&#39;s local block list. - **&#x60;mbtrap&#x60;** — messages flagged by the &#x60;MBTRAP&#x60; rspamd rule.  These are messages   that triggered MailBaby&#39;s internal trap / honeypot detection. - **&#x60;subject&#x60;** — senders whose recent messages contain spam-indicative subjects   (strings containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The &#x60;local&#x60; and &#x60;mbtrap&#x60; results cover the last 5 days.  The &#x60;subject&#x60; results cover the last 3 days.  A sender address returned in any of these lists can be delisted using &#x60;POST /mail/blocks/delete&#x60; with the &#x60;email&#x60; field set to that address. 
    def blocks() : Response(OpenAPIClient::MailBlocks)
      @conn.request(OpenAPIClient::MailBlocks,
        method: :GET,
        path: "/mail/blocks",
        accept: %w[application/json],
        auth: %w[apiKeyAuth])
    end

    # Delist an email address from the spam-filter block lists **Destructive — wipes block records for the given address.** Required: &#x60;email&#x60; (must be a valid address; typically a &#x60;from&#x60; value previously returned by &#x60;GET /mail/blocks&#x60; or &#x60;GET /mail/log&#x60;). Delists an email address from all three block list stores: 1. The rspamd spam-filter database (&#x60;fromemail&#x60; / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use &#x60;GET /mail/blocks&#x60; to discover which addresses are currently blocked.  The &#x60;from&#x60; field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. 
    def blocks_delete(email_address_param : OpenAPIClient::EmailAddressParam) : Response(OpenAPIClient::GenericResponse)
      @conn.request(OpenAPIClient::GenericResponse,
        method: :POST,
        path: "/mail/blocks/delete",
        body: email_address_param,
        accept: %w[application/json],
        content_type: %w[application/json application/x-www-form-urlencoded],
        auth: %w[apiKeyAuth])
    end

    # Get one mail order&#39;s full detail including SMTP password **Returns the SMTP password** in addition to the basic &#x60;GET /mail&#x60; fields. Use when you need to authenticate against &#x60;relay.mailbaby.net:25&#x60; from an SMTP client directly. Required: &#x60;id&#x60; (path; obtain from &#x60;GET /mail&#x60;). Returns the full detail record for one specific mail order identified by its numeric &#x60;id&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; values returned here can be used directly to authenticate against &#x60;relay.mailbaby.net:25&#x60; (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The &#x60;id&#x60; path parameter is the same integer &#x60;id&#x60; value returned by &#x60;GET /mail&#x60;. 
    def get(id : Int64) : Response(OpenAPIClient::MailOrderDetail)
      @conn.request(OpenAPIClient::MailOrderDetail,
        method: :GET,
        path: "/mail/{id}".sub("{id}", OpenAPIClient.enc(id)),
        accept: %w[application/json],
        auth: %w[apiKeyAuth])
    end

    # List your provisioned mail orders (sending accounts) Use this **before sending** if you need to discover which mail order &#x60;id&#x60; to pass to &#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, &#x60;/mail/rawsend&#x60;, &#x60;/mail/log&#x60;, or &#x60;/mail/stats&#x60;. Returns every mail order (active **and** canceled) on your account. Each record includes the numeric &#x60;id&#x60;, the &#x60;status&#x60; (&#x60;active&#x60; or &#x60;canceled&#x60;), the SMTP &#x60;username&#x60; (always &#x60;mb&lt;id&gt;&#x60;), and an optional &#x60;comment&#x60;.  The &#x60;id&#x60; values returned here are used as the &#x60;id&#x60; input parameter on all sending endpoints (&#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, &#x60;/mail/rawsend&#x60;) as well as the log and stats queries.  When the &#x60;id&#x60; parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use &#x60;GET /mail/{id}&#x60;. 
    def list() : Response(Array(OpenAPIClient::MailOrder))
      @conn.request(Array(OpenAPIClient::MailOrder),
        method: :GET,
        path: "/mail",
        accept: %w[application/json],
        auth: %w[apiKeyAuth])
    end

    # Query the mail delivery log (filterable, paginated) **Use this to find or audit sent messages.** All filters are optional and combinable. The most useful filters: &#x60;mailid&#x60; (the transaction id returned by a send call), &#x60;from&#x60; / &#x60;to&#x60; (envelope addresses), &#x60;subject&#x60;, &#x60;messageId&#x60; (case-insensitive substring on the &#x60;Message-ID&#x60; header), &#x60;delivered&#x60; (&#x60;1&#x60;&#x3D;delivered, &#x60;0&#x60;&#x3D;queued/failed), and the &#x60;startDate&#x60;/&#x60;endDate&#x60; date range. Returns a paginated list of every email message accepted by the relay for your mail account(s).  **Row grouping** is controlled by the &#x60;groupby&#x60; parameter.  By default (&#x60;groupby&#x3D;recipient&#x60;), the response contains one row per delivery attempt — so a single message sent to 4 recipients produces 4 rows, each with its own &#x60;recipient&#x60;, &#x60;delivered&#x60;, &#x60;response&#x60;, and &#x60;mxHostname&#x60; values.  Set &#x60;groupby&#x3D;message&#x60; to collapse to one row per message (delivery fields will reflect one arbitrary recipient).  **Pagination** is controlled by &#x60;skip&#x60; and &#x60;limit&#x60;.  The &#x60;total&#x60; in the response reflects the row count **after** grouping, so it matches the number of pages you need to fetch.  **Date filtering** accepts either a Unix timestamp (integer) or a date string parseable by PHP &#x60;strtotime()&#x60; such as &#x60;2024-01-15&#x60;, &#x60;last monday&#x60;, or &#x60;2024-01-01 00:00:00&#x60;.  Examples: &#x60;startDate&#x3D;1704067200&amp;endDate&#x3D;1706745599&#x60; or &#x60;startDate&#x3D;2024-01-01&amp;endDate&#x3D;2024-01-31&#x60;.  **Sorting** is controlled by &#x60;sort&#x60; and &#x60;dir&#x60;.  Currently the only sort key is &#x60;time&#x60; (default), which orders by internal row ID.  **Delivery status** can be filtered with the &#x60;delivered&#x60; parameter: &#x60;delivered&#x3D;1&#x60; returns only successfully delivered messages; &#x60;delivered&#x3D;0&#x60; returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (&#x60;from&#x60;, &#x60;to&#x60;) and message headers (&#x60;headerfrom&#x60; for the &#x60;From:&#x60; header, &#x60;replyto&#x60; for &#x60;Reply-To:&#x60;). These may differ when a message is sent on behalf of another address.  The &#x60;mailid&#x60; parameter corresponds to the &#x60;id&#x60; field in the returned &#x60;MailLogEntry&#x60; objects, **not** the &#x60;_id&#x60; field.  It also matches the transaction ID returned in the &#x60;text&#x60; field of a successful send response from &#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, or &#x60;/mail/rawsend&#x60;.  The &#x60;messageId&#x60; parameter searches the &#x60;Message-ID&#x60; email header (case-insensitive substring match). 
    def log(*, id : Int64? = nil, origin : String? = nil, mx : String? = nil, from : String? = nil, to : String? = nil, subject : String? = nil, mailid : String? = nil, message_id : String? = nil, replyto : String? = nil, headerfrom : String? = nil, delivered : Int32? = nil, skip : Int32? = nil, limit : Int32? = nil, start_date : String? = nil, end_date : String? = nil, sort : String? = nil, dir : String? = nil, groupby : String? = nil) : Response(OpenAPIClient::MailLog)
      @conn.request(OpenAPIClient::MailLog,
        method: :GET,
        path: "/mail/log",
        query: { "id" => id, "origin" => origin, "mx" => mx, "from" => from, "to" => to, "subject" => subject, "mailid" => mailid, "messageId" => message_id, "replyto" => replyto, "headerfrom" => headerfrom, "delivered" => delivered, "skip" => skip, "limit" => limit, "startDate" => start_date, "endDate" => end_date, "sort" => sort, "dir" => dir, "groupby" => groupby },
        accept: %w[application/json],
        auth: %w[apiKeyAuth])
    end

    # Send a pre-built RFC 822 message verbatim (preserves DKIM) **Use this when you have already built (and possibly DKIM-signed) the full RFC 822 message yourself** and want the relay to transmit it byte-for-byte. Required: &#x60;raw_email&#x60; (full RFC 822 string with headers + body). Optional: &#x60;id&#x60; (mail order to authenticate as). Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact. If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The &#x60;From&#x60; and recipient addresses are parsed automatically from the message headers (&#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, &#x60;Bcc&#x60;).  You do **not** need to specify them separately.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record. 
    def rawsend(send_mail_raw : OpenAPIClient::SendMailRaw) : Response(OpenAPIClient::GenericResponse)
      @conn.request(OpenAPIClient::GenericResponse,
        method: :POST,
        path: "/mail/rawsend",
        body: send_mail_raw,
        accept: %w[application/json],
        content_type: %w[application/json multipart/form-data],
        auth: %w[apiKeyAuth])
    end

    # Send a simple email (single recipient, plain or HTML) **Use this for the simplest case** — one or a few plain-string recipients, no attachments, no CC/BCC, no named contacts. Required: &#x60;from&#x60;, &#x60;to&#x60;, &#x60;subject&#x60;, &#x60;body&#x60;. Optional: &#x60;id&#x60; (selects which mail order to send through; auto-selects your first active order if omitted). Sends through one of your mail orders using a flat set of fields.  **HTML detection** is automatic — if the &#x60;body&#x60; value contains any HTML tags the message will be sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is also automatically set as the &#x60;Reply-To&#x60; header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use &#x60;POST /mail/advsend&#x60; instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use &#x60;POST /mail/rawsend&#x60;.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record. 
    def send(to : OpenAPIClient::SendMailTo? = nil, from : String? = nil, subject : String? = nil, body : String? = nil, id : Int64? = nil) : Response(OpenAPIClient::GenericResponse)
      @conn.request(OpenAPIClient::GenericResponse,
        method: :POST,
        path: "/mail/send",
        form: Hash(String, Crest::ParamsValue){ "to" => to, "from" => from, "subject" => subject, "body" => body, "id" => id },
        accept: %w[application/json],
        auth: %w[apiKeyAuth])
    end

    # Account usage, cost, and volume statistics for a time window **Use this for dashboards or billing-cycle reviews.** Returns aggregate sending statistics for your mail account(s). The &#x60;time&#x60; query param controls the window for &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; (&#x60;1h&#x60;, &#x60;24h&#x60;, &#x60;7d&#x60;, &#x60;month&#x60;, &#x60;day&#x60;, &#x60;billing&#x60;, &#x60;all&#x60;). The &#x60;usage&#x60; and &#x60;cost&#x60; fields are always for the current billing cycle, regardless of &#x60;time&#x60;.  The response includes: - **&#x60;usage&#x60;** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **&#x60;cost&#x60;** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **&#x60;received&#x60;** / **&#x60;sent&#x60;** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected &#x60;time&#x60; window. - **&#x60;volume&#x60;** — top-500 breakdown of message counts grouped by source IP (&#x60;ip&#x60;),   destination address (&#x60;to&#x60;), and sender address (&#x60;from&#x60;) within the selected window.   **Time windows** (controlled by the &#x60;time&#x60; parameter): | Value | Window | |-------|--------| | &#x60;1h&#x60; | Last 1 hour (default) | | &#x60;24h&#x60; | Last 24 hours | | &#x60;7d&#x60; | Last 7 days | | &#x60;month&#x60; | Current calendar month (1st to now) | | &#x60;day&#x60; | Today (midnight to now) | | &#x60;billing&#x60; | Current billing cycle (last invoice date to next invoice date) | | &#x60;all&#x60; | All time | 
    def stats(*, time : String? = nil) : Response(OpenAPIClient::MailStatsType)
      @conn.request(OpenAPIClient::MailStatsType,
        method: :GET,
        path: "/mail/stats",
        query: { "time" => time },
        accept: %w[application/json],
        auth: %w[apiKeyAuth])
    end
  end
  end

end
