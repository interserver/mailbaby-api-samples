/*
 * email_address_types.h
 *
 * 
 */

#ifndef _email_address_types_H_
#define _email_address_types_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct email_address_types_t email_address_types_t;

#include "email_address_name.h"



typedef struct email_address_types_t {
    char *email; // string
    char *name; // string

    int _library_owned; // Is the library responsible for freeing this object?
} email_address_types_t;

__attribute__((deprecated)) email_address_types_t *email_address_types_create(
    char *email,
    char *name
);

void email_address_types_free(email_address_types_t *email_address_types);

email_address_types_t *email_address_types_parseFromJSON(cJSON *email_address_typesJSON);

cJSON *email_address_types_convertToJSON(email_address_types_t *email_address_types);

#endif /* _email_address_types_H_ */

