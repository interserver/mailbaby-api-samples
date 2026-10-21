-module(MailBabyErlangClient_sending_api).

-export([raw_mail/2, raw_mail/3,
         send_adv_mail/5, send_adv_mail/6,
         send_mail/5, send_mail/6]).

-define(BASE_URL, <<"">>).

%% @doc Send a pre-built RFC 822 message verbatim (preserves DKIM)
%% **Use this when you have already built (and possibly DKIM-signed) the full RFC 822 message yourself** and want the relay to transmit it byte-for-byte. Required: `raw_email` (full RFC 822 string with headers + body). Optional: `id` (mail order to authenticate as). Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact. If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 
-spec raw_mail(ctx:ctx(), MailBabyErlangClient_send_mail_raw:MailBabyErlangClient_send_mail_raw()) -> {ok, MailBabyErlangClient_generic_response:MailBabyErlangClient_generic_response(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
raw_mail(Ctx, MailBabyErlangClientSendMailRaw) ->
    raw_mail(Ctx, MailBabyErlangClientSendMailRaw, #{}).

-spec raw_mail(ctx:ctx(), MailBabyErlangClient_send_mail_raw:MailBabyErlangClient_send_mail_raw(), maps:map()) -> {ok, MailBabyErlangClient_generic_response:MailBabyErlangClient_generic_response(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
raw_mail(Ctx, MailBabyErlangClientSendMailRaw, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(MailBabyErlangClient_api, config, #{})),

    Method = post,
    Path = [?BASE_URL, "/mail/rawsend"],
    QS = [],
    Headers = [],
    Body1 = MailBabyErlangClientSendMailRaw,
    ContentTypeHeader = MailBabyErlangClient_utils:select_header_content_type([<<"application/json">>, <<"multipart/form-data">>]),
    Opts = maps:get(hackney_opts, Optional, []),

    MailBabyErlangClient_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc Send email with multiple recipients, CC/BCC, attachments, named contacts
%% **Use this when the simple send is not enough** — multiple recipients, CC/BCC, named contacts, custom Reply-To, or file attachments. Required: `from`, `to`, `subject`, `body`. Optional: `cc`, `bcc`, `replyto`, `attachments` (array of `{filename,data}` with base64 data), `id`. Sends through one of your mail orders with full control over recipients, headers, and attachments.  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.  ## Examples  ### Form — basic string addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d from=user@domain.com \\   -d to=support@interserver.net ``` ### Form — RFC 822 named addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d 'from=Joe <user@domain.com>' \\   -d 'to=Jane <support@interserver.net>' ``` ### Form — multiple recipients as array ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' -d 'body=Hello' \\   -d from=user@domain.com \\   -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \\   -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net' ``` ### JSON — structured objects ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/json' \\   -d '{     \"subject\": \"Welcome\",     \"body\": \"<h1>Hello</h1>\",     \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},     \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],     \"cc\": [{\"email\": \"manager@client.com\"}],     \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]   }' ``` 
-spec send_adv_mail(ctx:ctx(), binary(), binary(), MailBabyErlangClient_email_address_types:MailBabyErlangClient_email_address_types(), MailBabyErlangClient_email_addresses_types:MailBabyErlangClient_email_addresses_types()) -> {ok, MailBabyErlangClient_generic_response:MailBabyErlangClient_generic_response(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
send_adv_mail(Ctx, Subject, Body, From, To) ->
    send_adv_mail(Ctx, Subject, Body, From, To, #{}).

-spec send_adv_mail(ctx:ctx(), binary(), binary(), MailBabyErlangClient_email_address_types:MailBabyErlangClient_email_address_types(), MailBabyErlangClient_email_addresses_types:MailBabyErlangClient_email_addresses_types(), maps:map()) -> {ok, MailBabyErlangClient_generic_response:MailBabyErlangClient_generic_response(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
send_adv_mail(Ctx, Subject, Body, From, To, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(MailBabyErlangClient_api, config, #{})),

    Method = post,
    Path = [?BASE_URL, "/mail/advsend"],
    QS = [],
    Headers = [],
    Body1 = {form, [{<<"subject">>, Subject}, {<<"body">>, Body}, {<<"from">>, From}, {<<"to">>, To}]++MailBabyErlangClient_utils:optional_params(['replyto', 'cc', 'bcc', 'attachments', 'id'], _OptionalParams)},
    ContentTypeHeader = MailBabyErlangClient_utils:select_header_content_type([<<"application/x-www-form-urlencoded">>, <<"application/json">>]),
    Opts = maps:get(hackney_opts, Optional, []),

    MailBabyErlangClient_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc Send a simple email (single recipient, plain or HTML)
%% **Use this for the simplest case** — one or a few plain-string recipients, no attachments, no CC/BCC, no named contacts. Required: `from`, `to`, `subject`, `body`. Optional: `id` (selects which mail order to send through; auto-selects your first active order if omitted). Sends through one of your mail orders using a flat set of fields.  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.  The `from` address is also automatically set as the `Reply-To` header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 
-spec send_mail(ctx:ctx(), MailBabyErlangClient_send_mail_to:MailBabyErlangClient_send_mail_to(), binary(), binary(), binary()) -> {ok, MailBabyErlangClient_generic_response:MailBabyErlangClient_generic_response(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
send_mail(Ctx, To, From, Subject, Body) ->
    send_mail(Ctx, To, From, Subject, Body, #{}).

-spec send_mail(ctx:ctx(), MailBabyErlangClient_send_mail_to:MailBabyErlangClient_send_mail_to(), binary(), binary(), binary(), maps:map()) -> {ok, MailBabyErlangClient_generic_response:MailBabyErlangClient_generic_response(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
send_mail(Ctx, To, From, Subject, Body, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(MailBabyErlangClient_api, config, #{})),

    Method = post,
    Path = [?BASE_URL, "/mail/send"],
    QS = [],
    Headers = [],
    Body1 = {form, [{<<"to">>, To}, {<<"from">>, From}, {<<"subject">>, Subject}, {<<"body">>, Body}]++MailBabyErlangClient_utils:optional_params(['id'], _OptionalParams)},
    ContentTypeHeader = MailBabyErlangClient_utils:select_header_content_type([<<"application/x-www-form-urlencoded">>, <<"application/json">>]),
    Opts = maps:get(hackney_opts, Optional, []),

    MailBabyErlangClient_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).


