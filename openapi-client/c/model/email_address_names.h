/*
 * email_address_names.h
 *
 * An array of email contacts, each with an email address and optional display name.
 */

#ifndef _email_address_names_H_
#define _email_address_names_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct email_address_names_t email_address_names_t;

#include "email_address_name.h"



typedef struct email_address_names_t {

    int _library_owned; // Is the library responsible for freeing this object?
} email_address_names_t;

__attribute__((deprecated)) email_address_names_t *email_address_names_create(
);

void email_address_names_free(email_address_names_t *email_address_names);

email_address_names_t *email_address_names_parseFromJSON(cJSON *email_address_namesJSON);

cJSON *email_address_names_convertToJSON(email_address_names_t *email_address_names);

#endif /* _email_address_names_H_ */

