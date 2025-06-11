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
typedef enum  { mailbaby_email_delivery_and_management_service_api_getStats_TIME_NULL = 0, mailbaby_email_delivery_and_management_service_api_getStats_TIME_all, mailbaby_email_delivery_and_management_service_api_getStats_TIME_billing, mailbaby_email_delivery_and_management_service_api_getStats_TIME_month, mailbaby_email_delivery_and_management_service_api_getStats_TIME__7d, mailbaby_email_delivery_and_management_service_api_getStats_TIME__24h, mailbaby_email_delivery_and_management_service_api_getStats_TIME__1d, mailbaby_email_delivery_and_management_service_api_getStats_TIME__1h } mailbaby_email_delivery_and_management_service_api_getStats_time_e;

// Enum DELIVERED for HistoryAPI_viewMailLog
typedef enum  { mailbaby_email_delivery_and_management_service_api_viewMailLog_DELIVERED_NULL = 0, mailbaby_email_delivery_and_management_service_api_viewMailLog_DELIVERED__0, mailbaby_email_delivery_and_management_service_api_viewMailLog_DELIVERED__1 } mailbaby_email_delivery_and_management_service_api_viewMailLog_delivered_e;


// Account usage statistics.
//
// Returns information about the usage on your mail accounts.
//
mail_stats_type_t*
HistoryAPI_getStats(apiClient_t *apiClient, mailbaby_email_delivery_and_management_service_api_getStats_time_e time);


// displays the mail log
//
// Get a listing of the emails sent through this system 
//
mail_log_t*
HistoryAPI_viewMailLog(apiClient_t *apiClient, long id, char *origin, char *mx, char *from, char *to, char *subject, char *mailid, int *skip, int *limit, long startDate, long endDate, char *replyto, char *headerfrom, mailbaby_email_delivery_and_management_service_api_viewMailLog_delivered_e delivered);


