note
    description: "API tests for STATUS_API"
    date: "$Date$"
    revision: "$Revision$"


class STATUS_API_TEST

inherit

    EQA_TEST_SET

feature -- Test routines


    test_ping_server
            -- Checks if the server is running
            --
            -- 
        local
        do
            -- TODO: Initialize required params.

            -- api.ping_server
            assert ("not_implemented", False)
        end

feature {NONE} -- Implementation

    api: STATUS_API
            -- Create an object instance of `STATUS_API'.
        once
            create { STATUS_API } Result
        end

end
