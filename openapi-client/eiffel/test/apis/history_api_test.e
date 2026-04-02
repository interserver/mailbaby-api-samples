note
    description: "API tests for HISTORY_API"
    date: "$Date$"
    revision: "$Revision$"


class HISTORY_API_TEST

inherit

    EQA_TEST_SET

feature -- Test routines


    test_stats
            -- Account usage statistics
            --
            -- Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.  The response includes: - **&#x60;usage&#x60;** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **&#x60;cost&#x60;** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **&#x60;received&#x60;** / **&#x60;sent&#x60;** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected &#x60;time&#x60; window. - **&#x60;volume&#x60;** — top-500 breakdown of message counts grouped by source IP (&#x60;ip&#x60;),   destination address (&#x60;to&#x60;), and sender address (&#x60;from&#x60;) within the selected window.   **Time windows** (controlled by the &#x60;time&#x60; parameter): | Value | Window | |-------|--------| | &#x60;1h&#x60; | Last 1 hour (default) | | &#x60;24h&#x60; | Last 24 hours | | &#x60;7d&#x60; | Last 7 days | | &#x60;month&#x60; | Current calendar month (1st to now) | | &#x60;day&#x60; | Today (midnight to now) | | &#x60;billing&#x60; | Current billing cycle (last invoice date to next invoice date) | | &#x60;all&#x60; | All time | 
        local
            l_response: MAIL_STATS_TYPE
            l_time: STRING_32
        do
            -- TODO: Initialize required params.

            -- l_response := api.stats(l_time)
            assert ("not_implemented", False)
        end

    test_view_mail_log
            -- Displays the mail log
            --
            -- Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.  **Row grouping** is controlled by the &#x60;groupby&#x60; parameter.  By default (&#x60;groupby&#x3D;recipient&#x60;), the response contains one row per delivery attempt — so a single message sent to 4 recipients produces 4 rows, each with its own &#x60;recipient&#x60;, &#x60;delivered&#x60;, &#x60;response&#x60;, and &#x60;mxHostname&#x60; values.  Set &#x60;groupby&#x3D;message&#x60; to collapse to one row per message (delivery fields will reflect one arbitrary recipient).  **Pagination** is controlled by &#x60;skip&#x60; and &#x60;limit&#x60;.  The &#x60;total&#x60; in the response reflects the row count **after** grouping, so it matches the number of pages you need to fetch.  **Date filtering** accepts either a Unix timestamp (integer) or a date string parseable by PHP &#x60;strtotime()&#x60; such as &#x60;2024-01-15&#x60;, &#x60;last monday&#x60;, or &#x60;2024-01-01 00:00:00&#x60;.  Examples: &#x60;startDate&#x3D;1704067200&amp;endDate&#x3D;1706745599&#x60; or &#x60;startDate&#x3D;2024-01-01&amp;endDate&#x3D;2024-01-31&#x60;.  **Sorting** is controlled by &#x60;sort&#x60; and &#x60;dir&#x60;.  Currently the only sort key is &#x60;time&#x60; (default), which orders by internal row ID.  **Delivery status** can be filtered with the &#x60;delivered&#x60; parameter: &#x60;delivered&#x3D;1&#x60; returns only successfully delivered messages; &#x60;delivered&#x3D;0&#x60; returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (&#x60;from&#x60;, &#x60;to&#x60;) and message headers (&#x60;headerfrom&#x60; for the &#x60;From:&#x60; header, &#x60;replyto&#x60; for &#x60;Reply-To:&#x60;). These may differ when a message is sent on behalf of another address.  The &#x60;mailid&#x60; parameter corresponds to the &#x60;id&#x60; field in the returned &#x60;MailLogEntry&#x60; objects, **not** the &#x60;_id&#x60; field.  It also matches the transaction ID returned in the &#x60;text&#x60; field of a successful send response from &#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, or &#x60;/mail/rawsend&#x60;.  The &#x60;messageId&#x60; parameter searches the &#x60;Message-ID&#x60; email header (case-insensitive substring match). 
        local
            l_response: MAIL_LOG
            l_id: INTEGER_64
            l_origin: STRING_32
            l_mx: STRING_32
            l_var_from: STRING_32
            l_to: STRING_32
            l_subject: STRING_32
            l_mailid: STRING_32
            l_message_id: STRING_32
            l_replyto: STRING_32
            l_headerfrom: STRING_32
            l_delivered: INTEGER_32
            l_skip: INTEGER_32
            l_limit: INTEGER_32
            l_start_date: VIEW_MAIL_LOG_START_DATE_PARAMETER
            l_end_date: VIEW_MAIL_LOG_START_DATE_PARAMETER
            l_sort: STRING_32
            l_dir: STRING_32
            l_groupby: STRING_32
        do
            -- TODO: Initialize required params.

            -- l_response := api.view_mail_log(l_id, l_origin, l_mx, l_var_from, l_to, l_subject, l_mailid, l_message_id, l_replyto, l_headerfrom, l_delivered, l_skip, l_limit, l_start_date, l_end_date, l_sort, l_dir, l_groupby)
            assert ("not_implemented", False)
        end

feature {NONE} -- Implementation

    api: HISTORY_API
            -- Create an object instance of `HISTORY_API'.
        once
            create { HISTORY_API } Result
        end

end
