#include <stdlib.h>
#include <stdio.h>
#include "../include/apiClient.h"
#include "../include/list.h"
#include "../external/cJSON.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"
#include "../model/generic_response.h"
#include "../model/get_mail_orders_200_response_inner.h"
#include "../model/get_mail_orders_401_response.h"
#include "../model/mail_log.h"
#include "../model/send_mail_adv.h"


// displays a list of mail service orders
//
list_t*
DefaultAPI_getMailOrders(apiClient_t *apiClient);


// Checks if the server is running
//
void
DefaultAPI_pingServer(apiClient_t *apiClient);


// Sends an Email with Advanced Options
//
// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
//
generic_response_t*
DefaultAPI_sendAdvMail(apiClient_t *apiClient, send_mail_adv_t * send_mail_adv );


// Sends an Email
//
// Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
//
generic_response_t*
DefaultAPI_sendMail(apiClient_t *apiClient, char * to , char * from , char * subject , char * body );


// displays the mail log
//
// By passing in the appropriate options, you can search for available inventory in the system 
//
mail_log_t*
DefaultAPI_viewMailLog(apiClient_t *apiClient, long id , char * search , int skip , int limit );


