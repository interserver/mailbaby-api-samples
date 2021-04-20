-module(openapi_api).

-export([ get_mail_by_id/1
        , get_mail_orders/0
        , ping_server/0
        , place_mail_order/1
        , send_adv_mail_by_id/2
        , send_mail_by_id/1
        , validate_mail_order/0
        , view_mail_log_by_id/1
        ]).

-define(BASE_URL, "").

%% @doc Gets mail order information by id
%% returns information about a mail order in the system with the given id.
-spec get_mail_by_id(integer()) ->
  openapi_utils:response().
get_mail_by_id(Id) ->
  Method      = get,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/mail/", Id, ""],

  openapi_utils:request(Method, [Host, ?BASE_URL, Path]).

%% @doc displays a list of mail service orders
%% 
-spec get_mail_orders() ->
  openapi_utils:response().
get_mail_orders() ->
  Method      = get,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/mail"],

  openapi_utils:request(Method, [Host, ?BASE_URL, Path]).

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
-spec send_adv_mail_by_id(integer(), openapi_send_mail:openapi_send_mail()) ->
  openapi_utils:response().
send_adv_mail_by_id(Id, OpenapiSendMail) ->
  Method      = post,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/mail/", Id, "/advsend"],
  Body        = OpenapiSendMail,
  ContentType = hd(["application/json", "application/xml", "application/x-www-form-urlencoded", "text/plain"]),

  openapi_utils:request(Method, [Host, ?BASE_URL, Path], jsx:encode(Body), ContentType).

%% @doc Sends an Email
%% Sends An email through one of your mail orders.
-spec send_mail_by_id(integer()) ->
  openapi_utils:response().
send_mail_by_id(Id) ->
  Method      = post,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/mail/", Id, "/send"],
  Body        = [],
  ContentType = "text/plain",
  QueryString = [<<"subject=">>, Subject, <<"&">>, <<"body=">>, Body, <<"&">>, <<"to=">>, To, <<"&">>, <<"toName=">>, ToName, <<"&">>, <<"from=">>, From, <<"&">>, <<"fromName=">>, FromName, <<"&">>],

  openapi_utils:request(Method, [Host, ?BASE_URL, Path, <<"?">>, QueryString], jsx:encode(Body), ContentType).

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
-spec view_mail_log_by_id(integer()) ->
  openapi_utils:response().
view_mail_log_by_id(Id) ->
  Method      = get,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/mail/", Id, "/log"],
  QueryString = [<<"searchString=">>, SearchString, <<"&">>, <<"skip=">>, Skip, <<"&">>, <<"limit=">>, Limit, <<"&">>],

  openapi_utils:request(Method, [Host, ?BASE_URL, Path, <<"?">>, QueryString]).

