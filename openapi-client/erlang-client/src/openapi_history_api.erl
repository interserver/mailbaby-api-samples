-module(openapi_history_api).

-export([get_stats/1, get_stats/2,
         view_mail_log/1, view_mail_log/2]).

-define(BASE_URL, <<"">>).

%% @doc Account usage statistics.
%% Returns information about the usage on your mail accounts.
-spec get_stats(ctx:ctx()) -> {ok, openapi_mail_stats_type:openapi_mail_stats_type(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
get_stats(Ctx) ->
    get_stats(Ctx, #{}).

-spec get_stats(ctx:ctx(), maps:map()) -> {ok, openapi_mail_stats_type:openapi_mail_stats_type(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
get_stats(Ctx, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(openapi_api, config, #{})),

    Method = get,
    Path = [?BASE_URL, "/mail/stats"],
    QS = lists:flatten([])++openapi_utils:optional_params(['time'], _OptionalParams),
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc displays the mail log
%% Get a listing of the emails sent through this system 
-spec view_mail_log(ctx:ctx()) -> {ok, openapi_mail_log:openapi_mail_log(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
view_mail_log(Ctx) ->
    view_mail_log(Ctx, #{}).

-spec view_mail_log(ctx:ctx(), maps:map()) -> {ok, openapi_mail_log:openapi_mail_log(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
view_mail_log(Ctx, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(openapi_api, config, #{})),

    Method = get,
    Path = [?BASE_URL, "/mail/log"],
    QS = lists:flatten([])++openapi_utils:optional_params(['id', 'origin', 'mx', 'from', 'to', 'subject', 'mailid', 'skip', 'limit', 'startDate', 'endDate', 'replyto', 'headerfrom', 'delivered'], _OptionalParams),
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).


