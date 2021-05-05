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
            l_response: LIST [MAIL_ORDER]
            l_id: INTEGER_64
        do
            -- TODO: Initialize required params.
                      
            -- l_response := api.mail_orders(l_id)
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
    
    test_place_mail_order
            -- places a mail order
            -- 
            -- Adds an item to the system 
        local
            l_mail_order: MAIL_ORDER
        do
            -- TODO: Initialize required params.
                      
            -- api.place_mail_order(l_mail_order)
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
            -- Sends An email through one of your mail orders. 
        local
            l_response: GENERIC_RESPONSE
            l_send_mail: SEND_MAIL
        do
            -- TODO: Initialize required params.
            -- l_send_mail
                      
            -- l_response := api.send_mail(l_send_mail)
            assert ("not_implemented", False)
        end
    
    test_validate_mail_order
            -- validatess order details before placing an order
            -- 
            --  
        local
        do
            -- TODO: Initialize required params.
                      
            -- api.validate_mail_order
            assert ("not_implemented", False)
        end
    
    test_view_mail_log_by_id
            -- displays the mail log
            -- 
            -- By passing in the appropriate options, you can search for available inventory in the system  
        local
            l_response: LIST [MAIL_LOG]
            l_id: INTEGER_64
            l_search_string: STRING_32
            l_skip: INTEGER_32
            l_limit: INTEGER_32
        do
            -- TODO: Initialize required params.
                      
            -- l_response := api.view_mail_log_by_id(l_id, l_search_string, l_skip, l_limit)
            assert ("not_implemented", False)
        end

feature {NONE} -- Implementation

    api: DEFAULT_API
            -- Create an object instance of `DEFAULT_API'.
        once            
            create { DEFAULT_API } Result
        end

end
