/*
 * email_address_param.h
 *
 * A single email address parameter used as the body of &#x60;POST /mail/blocks/delete&#x60;.
 */

#ifndef _email_address_param_H_
#define _email_address_param_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct email_address_param_t email_address_param_t;




typedef struct email_address_param_t {
    char *email; // string

    int _library_owned; // Is the library responsible for freeing this object?
} email_address_param_t;

__attribute__((deprecated)) email_address_param_t *email_address_param_create(
    char *email
);

void email_address_param_free(email_address_param_t *email_address_param);

email_address_param_t *email_address_param_parseFromJSON(cJSON *email_address_paramJSON);

cJSON *email_address_param_convertToJSON(email_address_param_t *email_address_param);

#endif /* _email_address_param_H_ */

