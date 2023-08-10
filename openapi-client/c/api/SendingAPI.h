#include <stdlib.h>
#include <stdio.h>
#include "../include/apiClient.h"
#include "../include/list.h"
#include "../external/cJSON.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"
#include "../model/email_address_name.h"
#include "../model/generic_response.h"
#include "../model/get_mail_orders_401_response.h"
#include "../model/mail_attachment.h"


// Sends an Email with Advanced Options
//
// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
//
generic_response_t*
SendingAPI_sendAdvMail(apiClient_t *apiClient, char * subject , char * body , email_address_name_t * from , list_t * to , list_t * replyto , list_t * cc , list_t * bcc , list_t * attachments , long id );


// Sends an Email
//
// Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
//
generic_response_t*
SendingAPI_sendMail(apiClient_t *apiClient, char * to , char * from , char * subject , char * body );


