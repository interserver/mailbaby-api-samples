/*
 * deny_rule_record.h
 *
 * The data for a email deny rule record.
 */

#ifndef _deny_rule_record_H_
#define _deny_rule_record_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct deny_rule_record_t deny_rule_record_t;


// Enum TYPE for deny_rule_record

typedef enum  { mailbaby_email_delivery_and_management_service_api_deny_rule_record_TYPE_NULL = 0, mailbaby_email_delivery_and_management_service_api_deny_rule_record_TYPE_domain, mailbaby_email_delivery_and_management_service_api_deny_rule_record_TYPE_email, mailbaby_email_delivery_and_management_service_api_deny_rule_record_TYPE_startswith } mailbaby_email_delivery_and_management_service_api_deny_rule_record_TYPE_e;

char* deny_rule_record_type_ToString(mailbaby_email_delivery_and_management_service_api_deny_rule_record_TYPE_e type);

mailbaby_email_delivery_and_management_service_api_deny_rule_record_TYPE_e deny_rule_record_type_FromString(char* type);



typedef struct deny_rule_record_t {
    int id; //numeric
    char *created; //date time
    mailbaby_email_delivery_and_management_service_api_deny_rule_record_TYPE_e type; //enum
    char *data; // string
    char *user; // string

} deny_rule_record_t;

deny_rule_record_t *deny_rule_record_create(
    int id,
    char *created,
    mailbaby_email_delivery_and_management_service_api_deny_rule_record_TYPE_e type,
    char *data,
    char *user
);

void deny_rule_record_free(deny_rule_record_t *deny_rule_record);

deny_rule_record_t *deny_rule_record_parseFromJSON(cJSON *deny_rule_recordJSON);

cJSON *deny_rule_record_convertToJSON(deny_rule_record_t *deny_rule_record);

#endif /* _deny_rule_record_H_ */

