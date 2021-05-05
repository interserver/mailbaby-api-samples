-module(openapi_api).

-export([ get_mail_orders/0
        , ping_server/0
        , place_mail_order/1
        , send_adv_mail/1
        , send_mail/4
        , validate_mail_order/0
        , view_mail_log/0
        ]).

-define(BASE_URL, "").

%% @doc displays a list of mail service orders
%% 
-spec get_mail_orders() ->
  openapi_utils:response().
get_mail_orders() ->
  Method      = get,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/mail"],
  QueryString = [<<"id=">>, Id, <<"&">>],

  openapi_utils:request(Method, [Host, ?BASE_URL, Path, <<"?">>, QueryString]).

%% @doc Checks if the server is running
%% 
-spec ping_server() ->
  openapi_utils:response().
ping_server() ->
  Method      = get,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/ping"],

  openapi_utils:request(Method, [Host, ?BASE_URL, Path]).

%% @doc places a mail order
%% Adds an item to the system
-spec place_mail_order() ->
  openapi_utils:response().
place_mail_order() ->
  Method      = post,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/mail/order"],
  Body        = OpenapiMailOrder,
  ContentType = hd(["application/json"]),

  openapi_utils:request(Method, [Host, ?BASE_URL, Path], jsx:encode(Body), ContentType).

%% @doc Sends an Email with Advanced Options
%% Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
-spec send_adv_mail(openapi_send_mail_adv:openapi_send_mail_adv()) ->
  openapi_utils:response().
send_adv_mail(OpenapiSendMailAdv) ->
  Method      = post,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/mail/advsend"],
  Body        = OpenapiSendMailAdv,
  ContentType = hd(["application/json", "application/x-www-form-urlencoded"]),

  openapi_utils:request(Method, [Host, ?BASE_URL, Path], jsx:encode(Body), ContentType).

%% @doc Sends an Email
%% Sends An email through one of your mail orders.
-spec send_mail(binary(), binary(), binary(), binary()) ->
  openapi_utils:response().
send_mail(To, From, Subject, Body) ->
  Method      = post,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/mail/send"],
  Body        = {form, [{<<"to">>, To, {<<"from">>, From, {<<"subject">>, Subject, {<<"body">>, Body]++openapi_utils:optional_params([], _OptionalParams)},
  ContentType = hd(["application/x-www-form-urlencoded", "application/json"]),

  openapi_utils:request(Method, [Host, ?BASE_URL, Path], jsx:encode(Body), ContentType).

%% @doc validatess order details before placing an order
%% 
-spec validate_mail_order() ->
  openapi_utils:response().
validate_mail_order() ->
  Method      = get,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/mail/order"],

  openapi_utils:request(Method, [Host, ?BASE_URL, Path]).

%% @doc displays the mail log
%% By passing in the appropriate options, you can search for available inventory in the system 
-spec view_mail_log() ->
  openapi_utils:response().
view_mail_log() ->
  Method      = get,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/mail/log"],
  QueryString = [<<"id=">>, Id, <<"&">>, <<"searchString=">>, SearchString, <<"&">>, <<"skip=">>, Skip, <<"&">>, <<"limit=">>, Limit, <<"&">>],

  openapi_utils:request(Method, [Host, ?BASE_URL, Path, <<"?">>, QueryString]).

