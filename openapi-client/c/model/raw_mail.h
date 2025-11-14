/*
 * raw_mail.h
 *
 * Raw Email Object
 */

#ifndef _raw_mail_H_
#define _raw_mail_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct raw_mail_t raw_mail_t;




typedef struct raw_mail_t {
    char *raw_email; // string

    int _library_owned; // Is the library responsible for freeing this object?
} raw_mail_t;

__attribute__((deprecated)) raw_mail_t *raw_mail_create(
    char *raw_email
);

void raw_mail_free(raw_mail_t *raw_mail);

raw_mail_t *raw_mail_parseFromJSON(cJSON *raw_mailJSON);

cJSON *raw_mail_convertToJSON(raw_mail_t *raw_mail);

#endif /* _raw_mail_H_ */

