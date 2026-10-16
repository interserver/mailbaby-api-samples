note
    description: "API tests for STATUS_API"
    date: "$Date$"
    revision: "$Revision$"


class STATUS_API_TEST

inherit

    EQA_TEST_SET

feature -- Test routines


    test_ping_server
            -- Health check — verify the API is reachable
            --
            -- **No authentication required.** Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 
        local
            l_response: STRING_32
        do
            -- TODO: Initialize required params.

            -- l_response := api.ping_server
            assert ("not_implemented", False)
        end

feature {NONE} -- Implementation

    api: STATUS_API
            -- Create an object instance of `STATUS_API'.
        once
            create { STATUS_API } Result
        end

end
