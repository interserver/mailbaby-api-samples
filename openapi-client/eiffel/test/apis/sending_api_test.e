note
    description: "API tests for SENDING_API"
    date: "$Date$"
    revision: "$Revision$"


class SENDING_API_TEST

inherit

    EQA_TEST_SET

feature -- Test routines


    test_send_adv_mail
            -- Sends an Email with Advanced Options
            --
            -- Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
        local
            l_response: GENERIC_RESPONSE
            l_subject: STRING_32
            l_body: STRING_32
            l_var_from: EMAIL_ADDRESS_NAME
            l_to: LIST [EMAIL_ADDRESS_NAME]
            l_replyto: LIST [EMAIL_ADDRESS_NAME]
            l_cc: LIST [EMAIL_ADDRESS_NAME]
            l_bcc: LIST [EMAIL_ADDRESS_NAME]
            l_attachments: LIST [MAIL_ATTACHMENT]
            l_id: INTEGER_64
        do
            -- TODO: Initialize required params.
            -- l_subject
            -- l_body
            -- l_var_from
            -- create {ARRAYED_LIST [EMAIL_ADDRESS_NAME]} l_to.make (2)

            -- l_response := api.send_adv_mail(l_subject, l_body, l_var_from, l_to, l_replyto, l_cc, l_bcc, l_attachments, l_id)
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

feature {NONE} -- Implementation

    api: SENDING_API
            -- Create an object instance of `SENDING_API'.
        once
            create { SENDING_API } Result
        end

end
