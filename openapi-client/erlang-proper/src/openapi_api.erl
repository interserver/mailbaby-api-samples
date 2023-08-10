-module(openapi_api).

-export([ ping_server/0
        ]).

-define(BASE_URL, "").

%% @doc Checks if the server is running
%% 
-spec ping_server() ->
  openapi_utils:response().
ping_server() ->
  Method      = get,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/ping"],

  openapi_utils:request(Method, [Host, ?BASE_URL, Path]).

