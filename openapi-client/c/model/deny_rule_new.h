/*
 * deny_rule_new.h
 *
 * The fields required to create a new email deny rule via &#x60;POST /mail/rules&#x60;. The &#x60;type&#x60; controls what &#x60;data&#x60; is matched against: - &#x60;email&#x60; — exact sender address match - &#x60;domain&#x60; — all senders from a domain - &#x60;destination&#x60; — exact recipient address match - &#x60;startswith&#x60; — sender local-part prefix match (alphanumeric + &#x60;+_.-&#x60; only)
 */

#ifndef _deny_rule_new_H_
#define _deny_rule_new_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct deny_rule_new_t deny_rule_new_t;


// Enum TYPE for deny_rule_new

typedef enum  { mailbaby_email_delivery_and_management_service_api_deny_rule_new_TYPE_NULL = 0, mailbaby_email_delivery_and_management_service_api_deny_rule_new_TYPE_domain, mailbaby_email_delivery_and_management_service_api_deny_rule_new_TYPE_email, mailbaby_email_delivery_and_management_service_api_deny_rule_new_TYPE_startswith, mailbaby_email_delivery_and_management_service_api_deny_rule_new_TYPE_destination } mailbaby_email_delivery_and_management_service_api_deny_rule_new_TYPE_e;

char* deny_rule_new_type_ToString(mailbaby_email_delivery_and_management_service_api_deny_rule_new_TYPE_e type);

mailbaby_email_delivery_and_management_service_api_deny_rule_new_TYPE_e deny_rule_new_type_FromString(char* type);



typedef struct deny_rule_new_t {
    mailbaby_email_delivery_and_management_service_api_deny_rule_new_TYPE_e type; //enum
    char *data; // string
    char *user; // string

    int _library_owned; // Is the library responsible for freeing this object?
} deny_rule_new_t;

__attribute__((deprecated)) deny_rule_new_t *deny_rule_new_create(
    mailbaby_email_delivery_and_management_service_api_deny_rule_new_TYPE_e type,
    char *data,
    char *user
);

void deny_rule_new_free(deny_rule_new_t *deny_rule_new);

deny_rule_new_t *deny_rule_new_parseFromJSON(cJSON *deny_rule_newJSON);

cJSON *deny_rule_new_convertToJSON(deny_rule_new_t *deny_rule_new);

#endif /* _deny_rule_new_H_ */

