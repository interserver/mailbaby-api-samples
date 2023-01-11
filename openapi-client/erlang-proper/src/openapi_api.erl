-module(openapi_api).

-export([ get_mail_orders/0
        , ping_server/0
        , send_adv_mail/1
        , send_mail/4
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
%% Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
-spec send_mail(binary(), binary(), binary(), binary()) ->
  openapi_utils:response().
send_mail(To, From, Subject, Body) ->
  Method      = post,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/mail/send"],
  Body        = {form, [{<<"to">>, To, {<<"from">>, From, {<<"subject">>, Subject, {<<"body">>, Body]++openapi_utils:optional_params([], _OptionalParams)},
  ContentType = hd(["application/x-www-form-urlencoded", "application/json"]),

  openapi_utils:request(Method, [Host, ?BASE_URL, Path], jsx:encode(Body), ContentType).

%% @doc displays the mail log
%% Get a listing of the emails sent through this system 
-spec view_mail_log() ->
  openapi_utils:response().
view_mail_log() ->
  Method      = get,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/mail/log"],
  QueryString = [<<"id=">>, Id, <<"&">>, <<"origin=">>, Origin, <<"&">>, <<"mx=">>, Mx, <<"&">>, <<"from=">>, From, <<"&">>, <<"to=">>, To, <<"&">>, <<"subject=">>, Subject, <<"&">>, <<"mailid=">>, Mailid, <<"&">>, <<"skip=">>, Skip, <<"&">>, <<"limit=">>, Limit, <<"&">>, <<"startDate=">>, StartDate, <<"&">>, <<"endDate=">>, EndDate, <<"&">>],

  openapi_utils:request(Method, [Host, ?BASE_URL, Path, <<"?">>, QueryString]).

