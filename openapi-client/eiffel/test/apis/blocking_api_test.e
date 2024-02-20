note
    description: "API tests for BLOCKING_API"
    date: "$Date$"
    revision: "$Revision$"


class BLOCKING_API_TEST

inherit

    EQA_TEST_SET

feature -- Test routines


    test_add_rule
            -- Creates a new email deny rule.
            --
            -- Adds a new email deny rule into the system to block new emails that match the given criteria
        local
            l_response: GENERIC_RESPONSE
            l_type: STRING_32
            l_data: STRING_32
            l_user: STRING_32
        do
            -- TODO: Initialize required params.
            -- l_type
            -- l_data

            -- l_response := api.add_rule(l_type, l_data, l_user)
            assert ("not_implemented", False)
        end

    test_delete_rule
            -- Removes an deny mail rule.
            --
            -- Removes one of the configured deny mail rules from the system.
        local
            l_response: GENERIC_RESPONSE
            l_rule_id: INTEGER_32
        do
            -- TODO: Initialize required params.
            -- l_rule_id

            -- l_response := api.delete_rule(l_rule_id)
            assert ("not_implemented", False)
        end

    test_delist_block
            -- Removes an email address from the blocked list
            --
            -- Removes an email address from the various block lists. 
        local
            l_response: GENERIC_RESPONSE
            l_body: STRING_32
        do
            -- TODO: Initialize required params.
            -- l_body

            -- l_response := api.delist_block(l_body)
            assert ("not_implemented", False)
        end

    test_mail_blocks
            -- displays a list of blocked email addresses
            --
            -- 
        local
            l_response: MAIL_BLOCKS
        do
            -- TODO: Initialize required params.

            -- l_response := api.mail_blocks
            assert ("not_implemented", False)
        end

    test_rules
            -- Displays a listing of deny email rules.
            --
            -- Returns a listing of all the deny block rules you have configured.
        local
            l_response: LIST [DENY_RULE_RECORD]
        do
            -- TODO: Initialize required params.

            -- l_response := api.rules
            assert ("not_implemented", False)
        end

feature {NONE} -- Implementation

    api: BLOCKING_API
            -- Create an object instance of `BLOCKING_API'.
        once
            create { BLOCKING_API } Result
        end

end
