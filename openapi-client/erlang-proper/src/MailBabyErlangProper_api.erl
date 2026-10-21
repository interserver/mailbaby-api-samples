-module(MailBabyErlangProper_api).

-export([ ping_server/0
        ]).

-define(BASE_URL, "").

%% @doc Health check — verify the API is reachable
%% **No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 
-spec ping_server() ->
  MailBabyErlangProper_utils:response().
ping_server() ->
  Method      = get,
  Host        = application:get_env(MailBabyErlangProper, host, "http://localhost:8080"),
  Path        = ["/ping"],

  MailBabyErlangProper_utils:request(Method, [Host, ?BASE_URL, Path]).

