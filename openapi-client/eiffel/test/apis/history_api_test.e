note
    description: "API tests for HISTORY_API"
    date: "$Date$"
    revision: "$Revision$"


class HISTORY_API_TEST

inherit

    EQA_TEST_SET

feature -- Test routines


    test_stats
            -- Account usage statistics.
            --
            -- Returns information about the usage on your mail accounts.
        local
            l_response: LIST [GET_STATS_200_RESPONSE_INNER]
        do
            -- TODO: Initialize required params.

            -- l_response := api.stats
            assert ("not_implemented", False)
        end

    test_view_mail_log
            -- displays the mail log
            --
            -- Get a listing of the emails sent through this system 
        local
            l_response: MAIL_LOG
            l_id: INTEGER_64
            l_origin: STRING_32
            l_mx: STRING_32
            l_var_from: STRING_32
            l_to: STRING_32
            l_subject: STRING_32
            l_mailid: STRING_32
            l_skip: INTEGER_32
            l_limit: INTEGER_32
            l_start_date: INTEGER_64
            l_end_date: INTEGER_64
            l_replyto: STRING_32
            l_headerfrom: STRING_32
        do
            -- TODO: Initialize required params.

            -- l_response := api.view_mail_log(l_id, l_origin, l_mx, l_var_from, l_to, l_subject, l_mailid, l_skip, l_limit, l_start_date, l_end_date, l_replyto, l_headerfrom)
            assert ("not_implemented", False)
        end

feature {NONE} -- Implementation

    api: HISTORY_API
            -- Create an object instance of `HISTORY_API'.
        once
            create { HISTORY_API } Result
        end

end
