/*
 * generic_response.h
 *
 * 
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
    char *status_text; // string

} generic_response_t;

generic_response_t *generic_response_create(
    char *status,
    char *status_text
);

void generic_response_free(generic_response_t *generic_response);

generic_response_t *generic_response_parseFromJSON(cJSON *generic_responseJSON);

cJSON *generic_response_convertToJSON(generic_response_t *generic_response);

#endif /* _generic_response_H_ */

