#include <stdlib.h>
#include <stdio.h>
#include "../include/apiClient.h"
#include "../include/list.h"
#include "../external/cJSON.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"
#include "../model/error_message.h"
#include "../model/get_stats_200_response_inner.h"
#include "../model/mail_log.h"


// Account usage statistics.
//
// Returns information about the usage on your mail accounts.
//
list_t*
HistoryAPI_getStats(apiClient_t *apiClient);


// displays the mail log
//
// Get a listing of the emails sent through this system 
//
mail_log_t*
HistoryAPI_viewMailLog(apiClient_t *apiClient, long id, char *origin, char *mx, char *from, char *to, char *subject, char *mailid, int *skip, int *limit, long startDate, long endDate, char *replyto, char *headerfrom);


