/*
 * generic_response.h
 *
 * Standard success response returned by write operations (send, add rule, delete, etc.).  The &#x60;status&#x60; field is always &#x60;\&quot;ok\&quot;&#x60; on success.  The &#x60;text&#x60; field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record&#39;s ID; for delete calls it contains a confirmation string.
 */

#ifndef _generic_response_H_
#define _generic_response_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct generic_response_t generic_response_t;




typedef struct generic_response_t {
    char *status; // string
    char *text; // string

    int _library_owned; // Is the library responsible for freeing this object?
} generic_response_t;

__attribute__((deprecated)) generic_response_t *generic_response_create(
    char *status,
    char *text
);

void generic_response_free(generic_response_t *generic_response);

generic_response_t *generic_response_parseFromJSON(cJSON *generic_responseJSON);

cJSON *generic_response_convertToJSON(generic_response_t *generic_response);

#endif /* _generic_response_H_ */

