require 'json'


MyApp.add_route('GET', '/ping', {
  "resourcePath" => "/Status",
  "summary" => "Health check — verify the API is reachable",
  "nickname" => "ping_server",
  "responseClass" => "String",
  "endpoint" => "/ping",
  "notes" => "**No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. ",
  "parameters" => [
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end

