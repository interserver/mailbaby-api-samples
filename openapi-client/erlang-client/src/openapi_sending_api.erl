-module(openapi_sending_api).

-export([send_adv_mail/5, send_adv_mail/6,
         send_mail/5, send_mail/6]).

-define(BASE_URL, <<"">>).

%% @doc Sends an Email with Advanced Options
%% Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
-spec send_adv_mail(ctx:ctx(), binary(), binary(), openapi_email_address_name:openapi_email_address_name(), list()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
send_adv_mail(Ctx, Subject, Body, From, To) ->
    send_adv_mail(Ctx, Subject, Body, From, To, #{}).

-spec send_adv_mail(ctx:ctx(), binary(), binary(), openapi_email_address_name:openapi_email_address_name(), list(), maps:map()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
send_adv_mail(Ctx, Subject, Body, From, To, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(openapi_api, config, #{})),

    Method = post,
    Path = [?BASE_URL, "/mail/advsend"],
    QS = [],
    Headers = [],
    Body1 = {form, [{<<"subject">>, Subject}, {<<"body">>, Body}, {<<"from">>, From}, {<<"to">>, To}]++openapi_utils:optional_params(['replyto', 'cc', 'bcc', 'attachments', 'id'], _OptionalParams)},
    ContentTypeHeader = openapi_utils:select_header_content_type([<<"application/x-www-form-urlencoded">>, <<"application/json">>]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc Sends an Email
%% Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
-spec send_mail(ctx:ctx(), binary(), binary(), binary(), binary()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
send_mail(Ctx, To, From, Subject, Body) ->
    send_mail(Ctx, To, From, Subject, Body, #{}).

-spec send_mail(ctx:ctx(), binary(), binary(), binary(), binary(), maps:map()) -> {ok, openapi_generic_response:openapi_generic_response(), openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
send_mail(Ctx, To, From, Subject, Body, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(openapi_api, config, #{})),

    Method = post,
    Path = [?BASE_URL, "/mail/send"],
    QS = [],
    Headers = [],
    Body1 = {form, [{<<"to">>, To}, {<<"from">>, From}, {<<"subject">>, Subject}, {<<"body">>, Body}]++openapi_utils:optional_params([], _OptionalParams)},
    ContentTypeHeader = openapi_utils:select_header_content_type([<<"application/x-www-form-urlencoded">>, <<"application/json">>]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).


