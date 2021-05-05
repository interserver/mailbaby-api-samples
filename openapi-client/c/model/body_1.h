/*
 * body_1.h
 *
 * Details for an Email
 */

#ifndef _body_1_H_
#define _body_1_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct body_1_t body_1_t;




typedef struct body_1_t {
    char *to; // string
    char *from; // string
    char *subject; // string
    char *body; // string

} body_1_t;

body_1_t *body_1_create(
    char *to,
    char *from,
    char *subject,
    char *body
);

void body_1_free(body_1_t *body_1);

body_1_t *body_1_parseFromJSON(cJSON *body_1JSON);

cJSON *body_1_convertToJSON(body_1_t *body_1);

#endif /* _body_1_H_ */

