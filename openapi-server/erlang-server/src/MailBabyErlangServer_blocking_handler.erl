-module(MailBabyErlangServer_blocking_handler).
-moduledoc """
Exposes the following operation IDs:

- `POST` to `/mail/rules`, OperationId: `addRule`:
Create a deny rule to block a sender, domain, destination, or prefix.
**Use this to prevent future relay attempts that match a pattern.** Required: &#x60;type&#x60; (&#x60;email&#x60;, &#x60;domain&#x60;, &#x60;destination&#x60;, or &#x60;startswith&#x60;) and &#x60;data&#x60; (the value to match). Optional: &#x60;user&#x60; (SMTP username; auto-selects first active order if omitted). Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The &#x60;type&#x60; field selects the matching strategy: - **&#x60;email&#x60;** — exact match against the SMTP envelope &#x60;MAIL FROM&#x60; address. - **&#x60;domain&#x60;** — matches any sender address at the specified domain. - **&#x60;destination&#x60;** — exact match against the SMTP envelope &#x60;RCPT TO&#x60; address. - **&#x60;startswith&#x60;** — matches any sender address whose local-part (the portion   before the &#x60;@&#x60;) starts with the given string.  Only alphanumeric characters   and &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; are permitted in the prefix.   If &#x60;username&#x60; is provided it must be the SMTP username of one of your active mail orders (e.g. &#x60;mb20682&#x60;).  If omitted the rule is associated with your first active order.  On success the response &#x60;text&#x60; field contains the newly created rule&#39;s &#x60;id&#x60;, which can later be passed to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove it. 

- `DELETE` to `/mail/rules/:ruleId`, OperationId: `deleteRule`:
Delete a deny rule by its numeric ruleId.
**Destructive — permanently removes the rule.** Required: &#x60;ruleId&#x60; (path param; obtain from the &#x60;id&#x60; field returned by &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field returned by &#x60;POST /mail/rules&#x60;). Permanently removes a single deny rule identified by its numeric &#x60;ruleId&#x60;.  The &#x60;ruleId&#x60; is the &#x60;id&#x60; field returned by &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field from a successful &#x60;POST /mail/rules&#x60; response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account. 

- `POST` to `/mail/blocks/delete`, OperationId: `delistBlock`:
Delist an email address from the spam-filter block lists.
**Destructive — wipes block records for the given address.** Required: &#x60;email&#x60; (must be a valid address; typically a &#x60;from&#x60; value previously returned by &#x60;GET /mail/blocks&#x60; or &#x60;GET /mail/log&#x60;). Delists an email address from all three block list stores: 1. The rspamd spam-filter database (&#x60;fromemail&#x60; / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use &#x60;GET /mail/blocks&#x60; to discover which addresses are currently blocked.  The &#x60;from&#x60; field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. 

- `GET` to `/mail/blocks`, OperationId: `getMailBlocks`:
List addresses currently flagged by spam-filter block lists.
**Use this to discover which addresses to delist.** The &#x60;from&#x60; value of any returned entry can be passed to &#x60;POST /mail/blocks/delete&#x60; (as the &#x60;email&#x60; field) to remove the block. Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s). Three categories are returned:  - **&#x60;local&#x60;** — messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule.  These are   messages sent to recipients on your account&#39;s local block list. - **&#x60;mbtrap&#x60;** — messages flagged by the &#x60;MBTRAP&#x60; rspamd rule.  These are messages   that triggered MailBaby&#39;s internal trap / honeypot detection. - **&#x60;subject&#x60;** — senders whose recent messages contain spam-indicative subjects   (strings containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The &#x60;local&#x60; and &#x60;mbtrap&#x60; results cover the last 5 days.  The &#x60;subject&#x60; results cover the last 3 days.  A sender address returned in any of these lists can be delisted using &#x60;POST /mail/blocks/delete&#x60; with the &#x60;email&#x60; field set to that address. 

- `GET` to `/mail/rules`, OperationId: `getRules`:
List custom deny rules (sender / domain / destination / prefix).
**Use this to inspect or pick a &#x60;ruleId&#x60; to delete.** Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | &#x60;type&#x60; | &#x60;data&#x60; format | Effect | |--------|---------------|--------| | &#x60;email&#x60; | &#x60;user@domain.com&#x60; | Rejects any message from this exact sender address | | &#x60;domain&#x60; | &#x60;domain.com&#x60; | Rejects any message from any address at this domain | | &#x60;destination&#x60; | &#x60;user@domain.com&#x60; | Rejects any message addressed to this recipient | | &#x60;startswith&#x60; | &#x60;prefix&#x60; | Rejects any message whose sender address begins with this string (alphanumeric, &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; only) |  Use &#x60;POST /mail/rules&#x60; to add new rules and &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove them.  The &#x60;id&#x60; field in each returned record is the value needed for the delete call. 

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

-type class() :: 'blocking'.

-type operation_id() ::
    'addRule' %% Create a deny rule to block a sender, domain, destination, or prefix
    | 'deleteRule' %% Delete a deny rule by its numeric ruleId
    | 'delistBlock' %% Delist an email address from the spam-filter block lists
    | 'getMailBlocks' %% List addresses currently flagged by spam-filter block lists
    | 'getRules'. %% List custom deny rules (sender / domain / destination / prefix)


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
allowed_methods(Req, #state{operation_id = 'addRule'} = State) ->
    {[<<"POST">>], Req, State};
allowed_methods(Req, #state{operation_id = 'deleteRule'} = State) ->
    {[<<"DELETE">>], Req, State};
allowed_methods(Req, #state{operation_id = 'delistBlock'} = State) ->
    {[<<"POST">>], Req, State};
allowed_methods(Req, #state{operation_id = 'getMailBlocks'} = State) ->
    {[<<"GET">>], Req, State};
allowed_methods(Req, #state{operation_id = 'getRules'} = State) ->
    {[<<"GET">>], Req, State};
allowed_methods(Req, State) ->
    {[], Req, State}.

-spec is_authorized(cowboy_req:req(), state()) ->
    {true | {false, iodata()}, cowboy_req:req(), state()}.
is_authorized(Req0,
              #state{operation_id = 'addRule' = OperationID,
                     api_key_callback = Handler} = State) ->
    case MailBabyErlangServer_auth:authorize_api_key(Handler, OperationID, header, <<"authorization">>, Req0) of
        {true, Context, Req} ->
            {true, Req, State#state{context = Context}};
        {false, AuthHeader, Req} ->
            {{false, AuthHeader}, Req, State}
    end;
is_authorized(Req0,
              #state{operation_id = 'deleteRule' = OperationID,
                     api_key_callback = Handler} = State) ->
    case MailBabyErlangServer_auth:authorize_api_key(Handler, OperationID, header, <<"authorization">>, Req0) of
        {true, Context, Req} ->
            {true, Req, State#state{context = Context}};
        {false, AuthHeader, Req} ->
            {{false, AuthHeader}, Req, State}
    end;
is_authorized(Req0,
              #state{operation_id = 'delistBlock' = OperationID,
                     api_key_callback = Handler} = State) ->
    case MailBabyErlangServer_auth:authorize_api_key(Handler, OperationID, header, <<"authorization">>, Req0) of
        {true, Context, Req} ->
            {true, Req, State#state{context = Context}};
        {false, AuthHeader, Req} ->
            {{false, AuthHeader}, Req, State}
    end;
is_authorized(Req0,
              #state{operation_id = 'getMailBlocks' = OperationID,
                     api_key_callback = Handler} = State) ->
    case MailBabyErlangServer_auth:authorize_api_key(Handler, OperationID, header, <<"authorization">>, Req0) of
        {true, Context, Req} ->
            {true, Req, State#state{context = Context}};
        {false, AuthHeader, Req} ->
            {{false, AuthHeader}, Req, State}
    end;
is_authorized(Req0,
              #state{operation_id = 'getRules' = OperationID,
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
content_types_accepted(Req, #state{operation_id = 'addRule'} = State) ->
    {[
      {<<"application/x-www-form-urlencoded">>, handle_type_accepted},
      {<<"application/json">>, handle_type_accepted}
     ], Req, State};
content_types_accepted(Req, #state{operation_id = 'deleteRule'} = State) ->
    {[], Req, State};
content_types_accepted(Req, #state{operation_id = 'delistBlock'} = State) ->
    {[
      {<<"application/json">>, handle_type_accepted},
      {<<"application/x-www-form-urlencoded">>, handle_type_accepted}
     ], Req, State};
content_types_accepted(Req, #state{operation_id = 'getMailBlocks'} = State) ->
    {[], Req, State};
content_types_accepted(Req, #state{operation_id = 'getRules'} = State) ->
    {[], Req, State};
content_types_accepted(Req, State) ->
    {[], Req, State}.

-spec valid_content_headers(cowboy_req:req(), state()) ->
    {boolean(), cowboy_req:req(), state()}.
valid_content_headers(Req, #state{operation_id = 'addRule'} = State) ->
    {true, Req, State};
valid_content_headers(Req, #state{operation_id = 'deleteRule'} = State) ->
    {true, Req, State};
valid_content_headers(Req, #state{operation_id = 'delistBlock'} = State) ->
    {true, Req, State};
valid_content_headers(Req, #state{operation_id = 'getMailBlocks'} = State) ->
    {true, Req, State};
valid_content_headers(Req, #state{operation_id = 'getRules'} = State) ->
    {true, Req, State};
valid_content_headers(Req, State) ->
    {false, Req, State}.

-spec content_types_provided(cowboy_req:req(), state()) ->
    {[{binary(), atom()}], cowboy_req:req(), state()}.
content_types_provided(Req, #state{operation_id = 'addRule'} = State) ->
    {[
      {<<"application/json">>, handle_type_provided}
     ], Req, State};
content_types_provided(Req, #state{operation_id = 'deleteRule'} = State) ->
    {[
      {<<"application/json">>, handle_type_provided}
     ], Req, State};
content_types_provided(Req, #state{operation_id = 'delistBlock'} = State) ->
    {[
      {<<"application/json">>, handle_type_provided}
     ], Req, State};
content_types_provided(Req, #state{operation_id = 'getMailBlocks'} = State) ->
    {[
      {<<"application/json">>, handle_type_provided}
     ], Req, State};
content_types_provided(Req, #state{operation_id = 'getRules'} = State) ->
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
    {Res, Req1, Context1} = Handler(blocking, OperationID, Req, Context),
    {Res, Req1, State#state{context = Context1}}.

-spec handle_type_provided(cowboy_req:req(), state()) ->
    { MailBabyErlangServer_logic_handler:provide_callback_return(), cowboy_req:req(), state()}.
handle_type_provided(Req, #state{operation_id = OperationID,
                                 provide_callback = Handler,
                                 context = Context} = State) ->
    {Res, Req1, Context1} = Handler(blocking, OperationID, Req, Context),
    {Res, Req1, State#state{context = Context1}}.
