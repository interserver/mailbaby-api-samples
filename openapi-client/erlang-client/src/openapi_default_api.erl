-module(openapi_default_api).

-export([get_mail_by_id/2, get_mail_by_id/3,
         get_mail_orders/1, get_mail_orders/2,
         ping_server/1, ping_server/2,
         place_mail_order/2, place_mail_order/3,
         send_adv_mail_by_id/3, send_adv_mail_by_id/4,
         send_mail_by_id/2, send_mail_by_id/3,
         validate_mail_order/1, validate_mail_order/2,
         view_mail_log_by_id/2, view_mail_log_by_id/3]).

-define(BASE_URL, "").

%% @doc Gets mail order information by id
%% returns information about a mail order in the system with the given id.
-spec get_mail_by_id(ctx:ctx(), integer()) -> {ok, openapi_mail_order:openapi_mail_order(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
get_mail_by_id(Ctx, Id) ->
    get_mail_by_id(Ctx, Id, #{}).

-spec get_mail_by_id(ctx:ctx(), integer(), maps:map()) -> {ok, openapi_mail_order:openapi_mail_order(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
get_mail_by_id(Ctx, Id, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(kuberl, config, #{})),

    Method = get,
    Path = ["/mail/", Id, ""],
    QS = [],
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, [?BASE_URL, Path], QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc displays a list of mail service orders
%% 
-spec get_mail_orders(ctx:ctx()) -> {ok, [openapi_mail_order:openapi_mail_order()], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
get_mail_orders(Ctx) ->
    get_mail_orders(Ctx, #{}).

-spec get_mail_orders(ctx:ctx(), maps:map()) -> {ok, [openapi_mail_order:openapi_mail_order()], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
get_mail_orders(Ctx, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(kuberl, config, #{})),

    Method = get,
    Path = ["/mail"],
    QS = [],
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, [?BASE_URL, Path], QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc Checks if the server is running
%% 
-spec ping_server(ctx:ctx()) -> {ok, [], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
ping_server(Ctx) ->
    ping_server(Ctx, #{}).

-spec ping_server(ctx:ctx(), maps:map()) -> {ok, [], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
ping_server(Ctx, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(kuberl, config, #{})),

    Method = get,
    Path = ["/ping"],
    QS = [],
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, [?BASE_URL, Path], QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc places a mail order
%% Adds an item to the system
-spec place_mail_order(ctx:ctx()) -> {ok, [], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
place_mail_order(Ctx) ->
    place_mail_order(Ctx, #{}).

-spec place_mail_order(ctx:ctx(), maps:map()) -> {ok, [], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
place_mail_order(Ctx, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(kuberl, config, #{})),

    Method = post,
    Path = ["/mail/order"],
    QS = [],
    Headers = [],
    Body1 = OpenapiMailOrder,
    ContentTypeHeader = openapi_utils:select_header_content_type([<<"application/json">>]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, [?BASE_URL, Path], QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc Sends an Email with Advanced Options
%% Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
-spec send_adv_mail_by_id(ctx:ctx(), integer(), openapi_send_mail:openapi_send_mail()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
send_adv_mail_by_id(Ctx, Id, OpenapiSendMail) ->
    send_adv_mail_by_id(Ctx, Id, OpenapiSendMail, #{}).

-spec send_adv_mail_by_id(ctx:ctx(), integer(), openapi_send_mail:openapi_send_mail(), maps:map()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
send_adv_mail_by_id(Ctx, Id, OpenapiSendMail, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(kuberl, config, #{})),

    Method = post,
    Path = ["/mail/", Id, "/advsend"],
    QS = [],
    Headers = [],
    Body1 = OpenapiSendMail,
    ContentTypeHeader = openapi_utils:select_header_content_type([<<"application/json">>, <<"application/xml">>, <<"application/x-www-form-urlencoded">>, <<"text/plain">>]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, [?BASE_URL, Path], QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc Sends an Email
%% Sends An email through one of your mail orders.
-spec send_mail_by_id(ctx:ctx(), integer()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
send_mail_by_id(Ctx, Id) ->
    send_mail_by_id(Ctx, Id, #{}).

-spec send_mail_by_id(ctx:ctx(), integer(), maps:map()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
send_mail_by_id(Ctx, Id, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(kuberl, config, #{})),

    Method = post,
    Path = ["/mail/", Id, "/send"],
    QS = lists:flatten([])++openapi_utils:optional_params(['subject', 'body', 'to', 'toName', 'from', 'fromName'], _OptionalParams),
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, [?BASE_URL, Path], QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc validatess order details before placing an order
%% 
-spec validate_mail_order(ctx:ctx()) -> {ok, [], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
validate_mail_order(Ctx) ->
    validate_mail_order(Ctx, #{}).

-spec validate_mail_order(ctx:ctx(), maps:map()) -> {ok, [], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
validate_mail_order(Ctx, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(kuberl, config, #{})),

    Method = get,
    Path = ["/mail/order"],
    QS = [],
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, [?BASE_URL, Path], QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc displays the mail log
%% By passing in the appropriate options, you can search for available inventory in the system 
-spec view_mail_log_by_id(ctx:ctx(), integer()) -> {ok, [openapi_mail_log:openapi_mail_log()], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
view_mail_log_by_id(Ctx, Id) ->
    view_mail_log_by_id(Ctx, Id, #{}).

-spec view_mail_log_by_id(ctx:ctx(), integer(), maps:map()) -> {ok, [openapi_mail_log:openapi_mail_log()], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
view_mail_log_by_id(Ctx, Id, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(kuberl, config, #{})),

    Method = get,
    Path = ["/mail/", Id, "/log"],
    QS = lists:flatten([])++openapi_utils:optional_params(['searchString', 'skip', 'limit'], _OptionalParams),
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, [?BASE_URL, Path], QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).


