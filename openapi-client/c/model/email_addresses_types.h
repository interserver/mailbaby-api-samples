/*
 * email_addresses_types.h
 *
 * A flexible email address list that accepts either a plain RFC 822 string or a structured array of contact objects.  When a string is provided it is parsed as a comma-separated list of RFC 822 addresses (supporting the &#x60;\&quot;Name &lt;email&gt;\&quot;&#x60; and bare &#x60;email&#x60; formats).  When an array is provided each entry must have at least an &#x60;email&#x60; field with an optional &#x60;name&#x60; field.
 */

#ifndef _email_addresses_types_H_
#define _email_addresses_types_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct email_addresses_types_t email_addresses_types_t;

#include "email_address_names.h"



typedef struct email_addresses_types_t {

    int _library_owned; // Is the library responsible for freeing this object?
} email_addresses_types_t;

__attribute__((deprecated)) email_addresses_types_t *email_addresses_types_create(
);

void email_addresses_types_free(email_addresses_types_t *email_addresses_types);

email_addresses_types_t *email_addresses_types_parseFromJSON(cJSON *email_addresses_typesJSON);

cJSON *email_addresses_types_convertToJSON(email_addresses_types_t *email_addresses_types);

#endif /* _email_addresses_types_H_ */

