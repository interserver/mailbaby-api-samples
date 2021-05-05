/*
 * body.h
 *
 * Details for an Email
 */

#ifndef _body_H_
#define _body_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct body_t body_t;




typedef struct body_t {
    char *to; // string
    char *from; // string
    char *subject; // string
    char *body; // string

} body_t;

body_t *body_create(
    char *to,
    char *from,
    char *subject,
    char *body
);

void body_free(body_t *body);

body_t *body_parseFromJSON(cJSON *bodyJSON);

cJSON *body_convertToJSON(body_t *body);

#endif /* _body_H_ */

