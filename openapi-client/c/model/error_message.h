/*
 * error_message.h
 *
 * The resposne when an error occurs.
 */

#ifndef _error_message_H_
#define _error_message_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct error_message_t error_message_t;




typedef struct error_message_t {
    int code; //numeric
    char *message; // string

    int _library_owned; // Is the library responsible for freeing this object?
} error_message_t;

__attribute__((deprecated)) error_message_t *error_message_create(
    int code,
    char *message
);

void error_message_free(error_message_t *error_message);

error_message_t *error_message_parseFromJSON(cJSON *error_messageJSON);

cJSON *error_message_convertToJSON(error_message_t *error_message);

#endif /* _error_message_H_ */

