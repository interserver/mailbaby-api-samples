-module(MailBabyErlangServer_sending_handler).
-moduledoc """
Exposes the following operation IDs:

- `POST` to `/mail/rawsend`, OperationId: `rawMail`:
Send a pre-built RFC 822 message verbatim (preserves DKIM).
**Use this when you have already built (and possibly DKIM-signed) the full RFC 822 message yourself** and want the relay to transmit it byte-for-byte. Required: &#x60;raw_email&#x60; (full RFC 822 string with headers + body). Optional: &#x60;id&#x60; (mail order to authenticate as). Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact. If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The &#x60;From&#x60; and recipient addresses are parsed automatically from the message headers (&#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, &#x60;Bcc&#x60;).  You do **not** need to specify them separately.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record. 

- `POST` to `/mail/advsend`, OperationId: `sendAdvMail`:
Send email with multiple recipients, CC/BCC, attachments, named contacts.
**Use this when the simple send is not enough** — multiple recipients, CC/BCC, named contacts, custom Reply-To, or file attachments. Required: &#x60;from&#x60;, &#x60;to&#x60;, &#x60;subject&#x60;, &#x60;body&#x60;. Optional: &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;, &#x60;attachments&#x60; (array of &#x60;{filename,data}&#x60; with base64 data), &#x60;id&#x60;. Sends through one of your mail orders with full control over recipients, headers, and attachments.  **Content-type flexibility** — the request body may be submitted as either &#x60;application/x-www-form-urlencoded&#x60; or &#x60;application/json&#x60;.  When using form encoding, address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) accept both a plain RFC 822 comma-separated string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;, jane@example.com\&quot;&#x60;) and the structured &#x60;[{\&quot;email\&quot;:\&quot;...\&quot;,\&quot;name\&quot;:\&quot;...\&quot;}]&#x60; array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if &#x60;body&#x60; contains HTML tags the &#x60;Content-Type&#x60; is set to &#x60;text/html&#x60;; otherwise &#x60;text/plain&#x60;.  **Attachments** must be base64-encoded.  Each attachment requires at least a &#x60;data&#x60; field; the optional &#x60;filename&#x60; field controls the attachment name shown to recipients.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response &#x60;text&#x60; field contains the relay transaction ID which can be looked up in &#x60;GET /mail/log&#x60; via the &#x60;mailid&#x60; query parameter.  ## Examples  ### Form — basic string addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/x-www-form-urlencoded&#39; \\   -d &#39;subject&#x3D;Welcome&#39; \\   -d &#39;body&#x3D;Hello&#39; \\   -d from&#x3D;user@domain.com \\   -d to&#x3D;support@interserver.net &#x60;&#x60;&#x60; ### Form — RFC 822 named addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/x-www-form-urlencoded&#39; \\   -d &#39;subject&#x3D;Welcome&#39; \\   -d &#39;body&#x3D;Hello&#39; \\   -d &#39;from&#x3D;Joe &lt;user@domain.com&gt;&#39; \\   -d &#39;to&#x3D;Jane &lt;support@interserver.net&gt;&#39; &#x60;&#x60;&#x60; ### Form — multiple recipients as array &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/x-www-form-urlencoded&#39; \\   -d &#39;subject&#x3D;Welcome&#39; -d &#39;body&#x3D;Hello&#39; \\   -d from&#x3D;user@domain.com \\   -d &#39;to[0][name]&#x3D;Joe&#39; -d &#39;to[0][email]&#x3D;support@interserver.net&#39; \\   -d &#39;to[1][name]&#x3D;Jane&#39; -d &#39;to[1][email]&#x3D;jane@interserver.net&#39; &#x60;&#x60;&#x60; ### JSON — structured objects &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -d &#39;{     \&quot;subject\&quot;: \&quot;Welcome\&quot;,     \&quot;body\&quot;: \&quot;&lt;h1&gt;Hello&lt;/h1&gt;\&quot;,     \&quot;from\&quot;: {\&quot;email\&quot;: \&quot;user@domain.com\&quot;, \&quot;name\&quot;: \&quot;Sender Name\&quot;},     \&quot;to\&quot;: [{\&quot;email\&quot;: \&quot;joe@client.com\&quot;, \&quot;name\&quot;: \&quot;Joe Client\&quot;}],     \&quot;cc\&quot;: [{\&quot;email\&quot;: \&quot;manager@client.com\&quot;}],     \&quot;attachments\&quot;: [{\&quot;filename\&quot;: \&quot;report.pdf\&quot;, \&quot;data\&quot;: \&quot;BASE64_DATA\&quot;}]   }&#39; &#x60;&#x60;&#x60; 

- `POST` to `/mail/send`, OperationId: `sendMail`:
Send a simple email (single recipient, plain or HTML).
**Use this for the simplest case** — one or a few plain-string recipients, no attachments, no CC/BCC, no named contacts. Required: &#x60;from&#x60;, &#x60;to&#x60;, &#x60;subject&#x60;, &#x60;body&#x60;. Optional: &#x60;id&#x60; (selects which mail order to send through; auto-selects your first active order if omitted). Sends through one of your mail orders using a flat set of fields.  **HTML detection** is automatic — if the &#x60;body&#x60; value contains any HTML tags the message will be sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is also automatically set as the &#x60;Reply-To&#x60; header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use &#x60;POST /mail/advsend&#x60; instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use &#x60;POST /mail/rawsend&#x60;.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record. 

""".

-behaviour(cowboy_rest).

-include_lib("kernel/include/logger.hrl").

%% Cowboy REST callbacks
-export([init/2]).
-export([allowed_methods/2]).
-export([content_types_accepted/2]).
-export([content_types_provided/2]).
-export([delete_resource/2]).
-export([is_authorized/2]).
-export([valid_content_headers/2]).
-export([handle_type_accepted/2, handle_type_provided/2]).

-ignore_xref([handle_type_accepted/2, handle_type_provided/2]).

-export_type([class/0, operation_id/0]).

-type class() :: 'sending'.

-type operation_id() ::
    'rawMail' %% Send a pre-built RFC 822 message verbatim (preserves DKIM)
    | 'sendAdvMail' %% Send email with multiple recipients, CC/BCC, attachments, named contacts
    | 'sendMail'. %% Send a simple email (single recipient, plain or HTML)


-record(state,
        {operation_id :: operation_id(),
         accept_callback :: MailBabyErlangServer_logic_handler:accept_callback(),
         provide_callback :: MailBabyErlangServer_logic_handler:provide_callback(),
         api_key_callback :: MailBabyErlangServer_logic_handler:api_key_callback(),
         context = #{} :: MailBabyErlangServer_logic_handler:context()}).

-type state() :: #state{}.

-spec init(cowboy_req:req(), MailBabyErlangServer_router:init_opts()) ->
    {cowboy_rest, cowboy_req:req(), state()}.
init(Req, {Operations, Module}) ->
    Method = cowboy_req:method(Req),
    OperationID = maps:get(Method, Operations, undefined),
    ?LOG_INFO(#{what => "Attempt to process operation",
                method => Method,
                operation_id => OperationID}),
    State = #state{operation_id = OperationID,
                   accept_callback = fun Module:accept_callback/4,
                   provide_callback = fun Module:provide_callback/4,
                   api_key_callback = fun Module:api_key_callback/2},
    {cowboy_rest, Req, State}.

-spec allowed_methods(cowboy_req:req(), state()) ->
    {[binary()], cowboy_req:req(), state()}.
allowed_methods(Req, #state{operation_id = 'rawMail'} = State) ->
    {[<<"POST">>], Req, State};
allowed_methods(Req, #state{operation_id = 'sendAdvMail'} = State) ->
    {[<<"POST">>], Req, State};
allowed_methods(Req, #state{operation_id = 'sendMail'} = State) ->
    {[<<"POST">>], Req, State};
allowed_methods(Req, State) ->
    {[], Req, State}.

-spec is_authorized(cowboy_req:req(), state()) ->
    {true | {false, iodata()}, cowboy_req:req(), state()}.
is_authorized(Req0,
              #state{operation_id = 'rawMail' = OperationID,
                     api_key_callback = Handler} = State) ->
    case MailBabyErlangServer_auth:authorize_api_key(Handler, OperationID, header, <<"authorization">>, Req0) of
        {true, Context, Req} ->
            {true, Req, State#state{context = Context}};
        {false, AuthHeader, Req} ->
            {{false, AuthHeader}, Req, State}
    end;
is_authorized(Req0,
              #state{operation_id = 'sendAdvMail' = OperationID,
                     api_key_callback = Handler} = State) ->
    case MailBabyErlangServer_auth:authorize_api_key(Handler, OperationID, header, <<"authorization">>, Req0) of
        {true, Context, Req} ->
            {true, Req, State#state{context = Context}};
        {false, AuthHeader, Req} ->
            {{false, AuthHeader}, Req, State}
    end;
is_authorized(Req0,
              #state{operation_id = 'sendMail' = OperationID,
                     api_key_callback = Handler} = State) ->
    case MailBabyErlangServer_auth:authorize_api_key(Handler, OperationID, header, <<"authorization">>, Req0) of
        {true, Context, Req} ->
            {true, Req, State#state{context = Context}};
        {false, AuthHeader, Req} ->
            {{false, AuthHeader}, Req, State}
    end;
is_authorized(Req, State) ->
    {true, Req, State}.

-spec content_types_accepted(cowboy_req:req(), state()) ->
    {[{binary(), atom()}], cowboy_req:req(), state()}.
content_types_accepted(Req, #state{operation_id = 'rawMail'} = State) ->
    {[
      {<<"application/json">>, handle_type_accepted},
      {<<"multipart/form-data">>, handle_type_accepted}
     ], Req, State};
content_types_accepted(Req, #state{operation_id = 'sendAdvMail'} = State) ->
    {[
      {<<"application/x-www-form-urlencoded">>, handle_type_accepted},
      {<<"application/json">>, handle_type_accepted}
     ], Req, State};
content_types_accepted(Req, #state{operation_id = 'sendMail'} = State) ->
    {[
      {<<"application/x-www-form-urlencoded">>, handle_type_accepted},
      {<<"application/json">>, handle_type_accepted}
     ], Req, State};
content_types_accepted(Req, State) ->
    {[], Req, State}.

-spec valid_content_headers(cowboy_req:req(), state()) ->
    {boolean(), cowboy_req:req(), state()}.
valid_content_headers(Req, #state{operation_id = 'rawMail'} = State) ->
    {true, Req, State};
valid_content_headers(Req, #state{operation_id = 'sendAdvMail'} = State) ->
    {true, Req, State};
valid_content_headers(Req, #state{operation_id = 'sendMail'} = State) ->
    {true, Req, State};
valid_content_headers(Req, State) ->
    {false, Req, State}.

-spec content_types_provided(cowboy_req:req(), state()) ->
    {[{binary(), atom()}], cowboy_req:req(), state()}.
content_types_provided(Req, #state{operation_id = 'rawMail'} = State) ->
    {[
      {<<"application/json">>, handle_type_provided}
     ], Req, State};
content_types_provided(Req, #state{operation_id = 'sendAdvMail'} = State) ->
    {[
      {<<"application/json">>, handle_type_provided}
     ], Req, State};
content_types_provided(Req, #state{operation_id = 'sendMail'} = State) ->
    {[
      {<<"application/json">>, handle_type_provided}
     ], Req, State};
content_types_provided(Req, State) ->
    {[], Req, State}.

-spec delete_resource(cowboy_req:req(), state()) ->
    {boolean(), cowboy_req:req(), state()}.
delete_resource(Req, State) ->
    {Res, Req1, State1} = handle_type_accepted(Req, State),
    {true =:= Res, Req1, State1}.

-spec handle_type_accepted(cowboy_req:req(), state()) ->
    { MailBabyErlangServer_logic_handler:accept_callback_return(), cowboy_req:req(), state()}.
handle_type_accepted(Req, #state{operation_id = OperationID,
                                 accept_callback = Handler,
                                 context = Context} = State) ->
    {Res, Req1, Context1} = Handler(sending, OperationID, Req, Context),
    {Res, Req1, State#state{context = Context1}}.

-spec handle_type_provided(cowboy_req:req(), state()) ->
    { MailBabyErlangServer_logic_handler:provide_callback_return(), cowboy_req:req(), state()}.
handle_type_provided(Req, #state{operation_id = OperationID,
                                 provide_callback = Handler,
                                 context = Context} = State) ->
    {Res, Req1, Context1} = Handler(sending, OperationID, Req, Context),
    {Res, Req1, State#state{context = Context1}}.
