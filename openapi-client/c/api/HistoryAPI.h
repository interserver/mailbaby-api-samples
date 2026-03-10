#include <stdlib.h>
#include <stdio.h>
#include "../include/apiClient.h"
#include "../include/list.h"
#include "../external/cJSON.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"
#include "../model/error_message.h"
#include "../model/mail_log.h"
#include "../model/mail_stats_type.h"

// Enum TIME for HistoryAPI_getStats
typedef enum  { mailbaby_email_delivery_and_management_service_api_getStats_TIME_NULL = 0, mailbaby_email_delivery_and_management_service_api_getStats_TIME_all, mailbaby_email_delivery_and_management_service_api_getStats_TIME_billing, mailbaby_email_delivery_and_management_service_api_getStats_TIME_month, mailbaby_email_delivery_and_management_service_api_getStats_TIME__7d, mailbaby_email_delivery_and_management_service_api_getStats_TIME__24h, mailbaby_email_delivery_and_management_service_api_getStats_TIME_day, mailbaby_email_delivery_and_management_service_api_getStats_TIME__1h } mailbaby_email_delivery_and_management_service_api_getStats_time_e;

// Enum DELIVERED for HistoryAPI_viewMailLog
typedef enum  { mailbaby_email_delivery_and_management_service_api_viewMailLog_DELIVERED_NULL = 0, mailbaby_email_delivery_and_management_service_api_viewMailLog_DELIVERED__0, mailbaby_email_delivery_and_management_service_api_viewMailLog_DELIVERED__1 } mailbaby_email_delivery_and_management_service_api_viewMailLog_delivered_e;


// Account usage statistics
//
// Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.  The response includes: - **`usage`** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **`cost`** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **`received`** / **`sent`** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected `time` window. - **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),   destination address (`to`), and sender address (`from`) within the selected window.   **Time windows** (controlled by the `time` parameter): | Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time | 
//
mail_stats_type_t*
HistoryAPI_getStats(apiClient_t *apiClient, mailbaby_email_delivery_and_management_service_api_getStats_time_e time);


// Displays the mail log
//
// Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.  **Pagination** is controlled by `skip` and `limit`.  The response includes a `total` count so clients can determine how many pages exist.  **Date filtering** uses Unix timestamps (`startDate` / `endDate`).  For example, to retrieve emails sent in January 2024: `startDate=1704067200&endDate=1706745599`.  **Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.  The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.  The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match). 
//
mail_log_t*
HistoryAPI_viewMailLog(apiClient_t *apiClient, long id, char *origin, char *mx, char *from, char *to, char *subject, char *mailid, char *messageId, char *replyto, char *headerfrom, int *delivered, int *skip, int *limit, long startDate, long endDate);


