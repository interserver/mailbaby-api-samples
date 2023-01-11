note
    description: "API tests for DEFAULT_API"
    date: "$Date$"
    revision: "$Revision$"


class DEFAULT_API_TEST

inherit

    EQA_TEST_SET

feature -- Test routines


    test_mail_orders
            -- displays a list of mail service orders
            --
            -- 
        local
            l_response: LIST [GET_MAIL_ORDERS_200_RESPONSE_INNER]
        do
            -- TODO: Initialize required params.

            -- l_response := api.mail_orders
            assert ("not_implemented", False)
        end

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

    test_send_adv_mail
            -- Sends an Email with Advanced Options
            --
            -- Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
        local
            l_response: GENERIC_RESPONSE
            l_send_mail_adv: SEND_MAIL_ADV
        do
            -- TODO: Initialize required params.
            -- l_send_mail_adv

            -- l_response := api.send_adv_mail(l_send_mail_adv)
            assert ("not_implemented", False)
        end

    test_send_mail
            -- Sends an Email
            --
            -- Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
        local
            l_response: GENERIC_RESPONSE
            l_to: STRING_32
            l_var_from: STRING_32
            l_subject: STRING_32
            l_body: STRING_32
        do
            -- TODO: Initialize required params.
            -- l_to
            -- l_var_from
            -- l_subject
            -- l_body

            -- l_response := api.send_mail(l_to, l_var_from, l_subject, l_body)
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
        do
            -- TODO: Initialize required params.

            -- l_response := api.view_mail_log(l_id, l_origin, l_mx, l_var_from, l_to, l_subject, l_mailid, l_skip, l_limit, l_start_date, l_end_date)
            assert ("not_implemented", False)
        end

feature {NONE} -- Implementation

    api: DEFAULT_API
            -- Create an object instance of `DEFAULT_API'.
        once
            create { DEFAULT_API } Result
        end

end
