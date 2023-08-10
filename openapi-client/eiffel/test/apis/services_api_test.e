note
    description: "API tests for SERVICES_API"
    date: "$Date$"
    revision: "$Revision$"


class SERVICES_API_TEST

inherit

    EQA_TEST_SET

feature -- Test routines


    test_mail_orders
            -- displays a list of mail service orders
            --
            -- This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
        local
            l_response: LIST [MAIL_ORDER]
        do
            -- TODO: Initialize required params.

            -- l_response := api.mail_orders
            assert ("not_implemented", False)
        end

feature {NONE} -- Implementation

    api: SERVICES_API
            -- Create an object instance of `SERVICES_API'.
        once
            create { SERVICES_API } Result
        end

end
