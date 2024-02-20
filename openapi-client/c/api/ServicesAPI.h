#include <stdlib.h>
#include <stdio.h>
#include "../include/apiClient.h"
#include "../include/list.h"
#include "../external/cJSON.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"
#include "../model/error_message.h"
#include "../model/mail_order.h"


// displays a list of mail service orders
//
// This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
//
list_t*
ServicesAPI_getMailOrders(apiClient_t *apiClient);


