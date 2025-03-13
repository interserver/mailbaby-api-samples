/*
 * email_addresses_types.h
 *
 * 
 */

#ifndef _email_addresses_types_H_
#define _email_addresses_types_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct email_addresses_types_t email_addresses_types_t;

#include "email_address_name.h"



typedef struct email_addresses_types_t {

    int _library_owned; // Is the library responsible for freeing this object?
} email_addresses_types_t;

__attribute__((deprecated)) email_addresses_types_t *email_addresses_types_create(
);

void email_addresses_types_free(email_addresses_types_t *email_addresses_types);

email_addresses_types_t *email_addresses_types_parseFromJSON(cJSON *email_addresses_typesJSON);

cJSON *email_addresses_types_convertToJSON(email_addresses_types_t *email_addresses_types);

#endif /* _email_addresses_types_H_ */

