require "json"

module OpenAPIClient
  module Api
  class Ping
    def initialize(@conn : Connection); end

    # Health check — verify the API is reachable **No authentication required.** Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 
    def server() : Response(String)
      @conn.request(String,
        method: :GET,
        path: "/ping",
        accept: %w[text/plain application/json],
        auth: %w[])
    end
  end
  end

end
