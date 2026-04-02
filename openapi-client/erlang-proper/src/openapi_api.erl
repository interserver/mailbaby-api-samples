-module(openapi_api).

-export([ ping_server/0
        ]).

-define(BASE_URL, "").

%% @doc Checks if the server is running
%% A lightweight health-check endpoint.  Returns the plain-text string `Server is up and running` with a `200` status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. 
-spec ping_server() ->
  openapi_utils:response().
ping_server() ->
  Method      = get,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/ping"],

  openapi_utils:request(Method, [Host, ?BASE_URL, Path]).

