note
    description: "API tests for SERVICES_API"
    date: "$Date$"
    revision: "$Revision$"


class SERVICES_API_TEST

inherit

    EQA_TEST_SET

feature -- Test routines


    test_mail_order_by_id
            -- Displays details for a single mail order
            --
            -- Returns the full detail record for one specific mail order identified by its numeric &#x60;id&#x60;.  In addition to the fields returned by &#x60;GET /mail&#x60;, this endpoint also includes the current **SMTP password** for the order.  The &#x60;username&#x60; and &#x60;password&#x60; values returned here can be used directly to authenticate against &#x60;relay.mailbaby.net:25&#x60; (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The &#x60;id&#x60; path parameter is the same integer &#x60;id&#x60; value returned by &#x60;GET /mail&#x60;. 
        local
            l_response: MAIL_ORDER_DETAIL
            l_id: INTEGER_64
        do
            -- TODO: Initialize required params.
            -- l_id

            -- l_response := api.mail_order_by_id(l_id)
            assert ("not_implemented", False)
        end

    test_mail_orders
            -- Displays a list of mail service orders
            --
            -- Returns every mail order (active **and** inactive) associated with your account. Each record includes the numeric &#x60;id&#x60;, the &#x60;status&#x60; (&#x60;active&#x60; or &#x60;canceled&#x60;), the SMTP &#x60;username&#x60; (always &#x60;mb&lt;id&gt;&#x60;), and an optional human-readable &#x60;comment&#x60;.  The &#x60;id&#x60; values returned here are used as the &#x60;id&#x60; input parameter on all sending endpoints (&#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, &#x60;/mail/rawsend&#x60;) as well as the log and stats queries.  When the &#x60;id&#x60; parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use &#x60;GET /mail/{id}&#x60;. 
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
