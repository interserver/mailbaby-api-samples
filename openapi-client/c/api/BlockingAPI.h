#include <stdlib.h>
#include <stdio.h>
#include "../include/apiClient.h"
#include "../include/list.h"
#include "../external/cJSON.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"
#include "../model/deny_rule_record.h"
#include "../model/email_address.h"
#include "../model/generic_response.h"
#include "../model/get_mail_orders_401_response.h"
#include "../model/mail_blocks.h"

// Enum TYPE for BlockingAPI_addRule
typedef enum  { mailbaby_email_delivery_and_management_service_api_addRule_TYPE_NULL = 0, mailbaby_email_delivery_and_management_service_api_addRule_TYPE_domain, mailbaby_email_delivery_and_management_service_api_addRule_TYPE_email, mailbaby_email_delivery_and_management_service_api_addRule_TYPE_startswith } mailbaby_email_delivery_and_management_service_api_addRule_type_e;


// Creates a new email deny rule.
//
// Adds a new email deny rule into the system to block new emails that match the given criteria
//
generic_response_t*
BlockingAPI_addRule(apiClient_t *apiClient, mailbaby_email_delivery_and_management_service_api_addRule_type_e type , char * data , char * user );


// Removes an deny mail rule.
//
// Removes one of the configured deny mail rules from the system.
//
generic_response_t*
BlockingAPI_deleteRule(apiClient_t *apiClient, int ruleId );


// Removes an email address from the blocked list
//
// Removes an email address from the various block lists. 
//
generic_response_t*
BlockingAPI_delistBlock(apiClient_t *apiClient, email_address_t * email_address );


// displays a list of blocked email addresses
//
mail_blocks_t*
BlockingAPI_getMailBlocks(apiClient_t *apiClient);


// Displays a listing of deny email rules.
//
// Returns a listing of all the deny block rules you have configured.
//
list_t*
BlockingAPI_getRules(apiClient_t *apiClient);


