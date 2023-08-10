-module(openapi_services_api).

-export([get_mail_orders/1, get_mail_orders/2]).

-define(BASE_URL, <<"">>).

%% @doc displays a list of mail service orders
%% This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
-spec get_mail_orders(ctx:ctx()) -> {ok, [openapi_mail_order:openapi_mail_order()], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
get_mail_orders(Ctx) ->
    get_mail_orders(Ctx, #{}).

-spec get_mail_orders(ctx:ctx(), maps:map()) -> {ok, [openapi_mail_order:openapi_mail_order()], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
get_mail_orders(Ctx, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(openapi_api, config, #{})),

    Method = get,
    Path = [?BASE_URL, "/mail"],
    QS = [],
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).


