/*
 * inline_response_401.h
 *
 * 
 */

#ifndef _inline_response_401_H_
#define _inline_response_401_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct inline_response_401_t inline_response_401_t;




typedef struct inline_response_401_t {
    char *code; // string
    char *message; // string

} inline_response_401_t;

inline_response_401_t *inline_response_401_create(
    char *code,
    char *message
);

void inline_response_401_free(inline_response_401_t *inline_response_401);

inline_response_401_t *inline_response_401_parseFromJSON(cJSON *inline_response_401JSON);

cJSON *inline_response_401_convertToJSON(inline_response_401_t *inline_response_401);

#endif /* _inline_response_401_H_ */

