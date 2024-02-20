-module(openapi_blocking_api).

-export([add_rule/3, add_rule/4,
         delete_rule/2, delete_rule/3,
         delist_block/2, delist_block/3,
         get_mail_blocks/1, get_mail_blocks/2,
         get_rules/1, get_rules/2]).

-define(BASE_URL, <<"">>).

%% @doc Creates a new email deny rule.
%% Adds a new email deny rule into the system to block new emails that match the given criteria
-spec add_rule(ctx:ctx(), binary(), binary()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
add_rule(Ctx, Type, Data) ->
    add_rule(Ctx, Type, Data, #{}).

-spec add_rule(ctx:ctx(), binary(), binary(), maps:map()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
add_rule(Ctx, Type, Data, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(openapi_api, config, #{})),

    Method = post,
    Path = [?BASE_URL, "/mail/rules"],
    QS = [],
    Headers = [],
    Body1 = {form, [{<<"type">>, Type}, {<<"data">>, Data}]++openapi_utils:optional_params(['user'], _OptionalParams)},
    ContentTypeHeader = openapi_utils:select_header_content_type([<<"application/x-www-form-urlencoded">>, <<"application/json">>]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc Removes an deny mail rule.
%% Removes one of the configured deny mail rules from the system.
-spec delete_rule(ctx:ctx(), integer()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
delete_rule(Ctx, RuleId) ->
    delete_rule(Ctx, RuleId, #{}).

-spec delete_rule(ctx:ctx(), integer(), maps:map()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
delete_rule(Ctx, RuleId, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(openapi_api, config, #{})),

    Method = delete,
    Path = [?BASE_URL, "/mail/rules/", RuleId, ""],
    QS = [],
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc Removes an email address from the blocked list
%% Removes an email address from the various block lists. 
-spec delist_block(ctx:ctx(), binary()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
delist_block(Ctx, Body) ->
    delist_block(Ctx, Body, #{}).

-spec delist_block(ctx:ctx(), binary(), maps:map()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
delist_block(Ctx, Body, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(openapi_api, config, #{})),

    Method = post,
    Path = [?BASE_URL, "/mail/blocks/delete"],
    QS = [],
    Headers = [],
    Body1 = Body,
    ContentTypeHeader = openapi_utils:select_header_content_type([<<"application/json">>, <<"multipart/form-data">>]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc displays a list of blocked email addresses
%% 
-spec get_mail_blocks(ctx:ctx()) -> {ok, openapi_mail_blocks:openapi_mail_blocks(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
get_mail_blocks(Ctx) ->
    get_mail_blocks(Ctx, #{}).

-spec get_mail_blocks(ctx:ctx(), maps:map()) -> {ok, openapi_mail_blocks:openapi_mail_blocks(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
get_mail_blocks(Ctx, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(openapi_api, config, #{})),

    Method = get,
    Path = [?BASE_URL, "/mail/blocks"],
    QS = [],
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc Displays a listing of deny email rules.
%% Returns a listing of all the deny block rules you have configured.
-spec get_rules(ctx:ctx()) -> {ok, [openapi_deny_rule_record:openapi_deny_rule_record()], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
get_rules(Ctx) ->
    get_rules(Ctx, #{}).

-spec get_rules(ctx:ctx(), maps:map()) -> {ok, [openapi_deny_rule_record:openapi_deny_rule_record()], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
get_rules(Ctx, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(openapi_api, config, #{})),

    Method = get,
    Path = [?BASE_URL, "/mail/rules"],
    QS = [],
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).


