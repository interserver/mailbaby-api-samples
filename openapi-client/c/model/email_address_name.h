/*
 * email_address_name.h
 *
 * An email contact with an optional display name.  Used in structured address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;) in &#x60;SendMailAdv&#x60;.
 */

#ifndef _email_address_name_H_
#define _email_address_name_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct email_address_name_t email_address_name_t;




typedef struct email_address_name_t {
    char *email; // string
    char *name; // string

    int _library_owned; // Is the library responsible for freeing this object?
} email_address_name_t;

__attribute__((deprecated)) email_address_name_t *email_address_name_create(
    char *email,
    char *name
);

void email_address_name_free(email_address_name_t *email_address_name);

email_address_name_t *email_address_name_parseFromJSON(cJSON *email_address_nameJSON);

cJSON *email_address_name_convertToJSON(email_address_name_t *email_address_name);

#endif /* _email_address_name_H_ */

