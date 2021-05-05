#include <stdlib.h>
#include <stdio.h>
#include "../include/apiClient.h"
#include "../include/list.h"
#include "../external/cJSON.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"
#include "../model/body.h"
#include "../model/error_response.h"
#include "../model/generic_response.h"
#include "../model/mail_log.h"
#include "../model/mail_order.h"
#include "../model/send_mail_adv.h"


// displays a list of mail service orders
//
list_t*
DefaultAPI_getMailOrders(apiClient_t *apiClient, long id );


// Checks if the server is running
//
void
DefaultAPI_pingServer(apiClient_t *apiClient);


// places a mail order
//
// Adds an item to the system
//
void
DefaultAPI_placeMailOrder(apiClient_t *apiClient, mail_order_t * mail_order );


// Sends an Email with Advanced Options
//
// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
//
generic_response_t*
DefaultAPI_sendAdvMail(apiClient_t *apiClient, send_mail_adv_t * send_mail_adv );


// Sends an Email
//
// Sends An email through one of your mail orders.
//
generic_response_t*
DefaultAPI_sendMail(apiClient_t *apiClient, body_t * body );


// validatess order details before placing an order
//
void
DefaultAPI_validateMailOrder(apiClient_t *apiClient);


// displays the mail log
//
// By passing in the appropriate options, you can search for available inventory in the system 
//
list_t*
DefaultAPI_viewMailLogById(apiClient_t *apiClient, long id , char * searchString , int skip , int limit );


