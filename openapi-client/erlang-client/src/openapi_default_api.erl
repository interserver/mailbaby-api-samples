-module(openapi_default_api).

-export([get_mail_orders/1, get_mail_orders/2,
         ping_server/1, ping_server/2,
         send_adv_mail/2, send_adv_mail/3,
         send_mail/5, send_mail/6,
         view_mail_log/1, view_mail_log/2]).

-define(BASE_URL, <<"">>).

%% @doc displays a list of mail service orders
%% 
-spec get_mail_orders(ctx:ctx()) -> {ok, [openapi_get_mail_orders_200_response_inner:openapi_get_mail_orders_200_response_inner()], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
get_mail_orders(Ctx) ->
    get_mail_orders(Ctx, #{}).

-spec get_mail_orders(ctx:ctx(), maps:map()) -> {ok, [openapi_get_mail_orders_200_response_inner:openapi_get_mail_orders_200_response_inner()], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
get_mail_orders(Ctx, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(kuberl, config, #{})),

    Method = get,
    Path = [<<"/mail">>],
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
    Path = [<<"/ping">>],
    QS = [],
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, [?BASE_URL, Path], QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc Sends an Email with Advanced Options
%% Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
-spec send_adv_mail(ctx:ctx(), openapi_send_mail_adv:openapi_send_mail_adv()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
send_adv_mail(Ctx, OpenapiSendMailAdv) ->
    send_adv_mail(Ctx, OpenapiSendMailAdv, #{}).

-spec send_adv_mail(ctx:ctx(), openapi_send_mail_adv:openapi_send_mail_adv(), maps:map()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
send_adv_mail(Ctx, OpenapiSendMailAdv, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(kuberl, config, #{})),

    Method = post,
    Path = [<<"/mail/advsend">>],
    QS = [],
    Headers = [],
    Body1 = OpenapiSendMailAdv,
    ContentTypeHeader = openapi_utils:select_header_content_type([<<"application/json">>, <<"application/x-www-form-urlencoded">>]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, [?BASE_URL, Path], QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc Sends an Email
%% Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
-spec send_mail(ctx:ctx(), binary(), binary(), binary(), binary()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
send_mail(Ctx, To, From, Subject, Body) ->
    send_mail(Ctx, To, From, Subject, Body, #{}).

-spec send_mail(ctx:ctx(), binary(), binary(), binary(), binary(), maps:map()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
send_mail(Ctx, To, From, Subject, Body, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(kuberl, config, #{})),

    Method = post,
    Path = [<<"/mail/send">>],
    QS = [],
    Headers = [],
    Body1 = {form, [{<<"to">>, To}, {<<"from">>, From}, {<<"subject">>, Subject}, {<<"body">>, Body}]++openapi_utils:optional_params([], _OptionalParams)},
    ContentTypeHeader = openapi_utils:select_header_content_type([<<"application/x-www-form-urlencoded">>, <<"application/json">>]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, [?BASE_URL, Path], QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc displays the mail log
%% By passing in the appropriate options, you can search for available inventory in the system 
-spec view_mail_log(ctx:ctx()) -> {ok, openapi_mail_log:openapi_mail_log(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
view_mail_log(Ctx) ->
    view_mail_log(Ctx, #{}).

-spec view_mail_log(ctx:ctx(), maps:map()) -> {ok, openapi_mail_log:openapi_mail_log(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
view_mail_log(Ctx, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(kuberl, config, #{})),

    Method = get,
    Path = [<<"/mail/log">>],
    QS = lists:flatten([])++openapi_utils:optional_params(['id', 'search', 'skip', 'limit'], _OptionalParams),
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, [?BASE_URL, Path], QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).


