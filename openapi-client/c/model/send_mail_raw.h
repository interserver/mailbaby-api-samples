/*
 * send_mail_raw.h
 *
 * Raw Email Object
 */

#ifndef _send_mail_raw_H_
#define _send_mail_raw_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct send_mail_raw_t send_mail_raw_t;




typedef struct send_mail_raw_t {
    char *raw_email; // string
    int id; //numeric

    int _library_owned; // Is the library responsible for freeing this object?
} send_mail_raw_t;

__attribute__((deprecated)) send_mail_raw_t *send_mail_raw_create(
    char *raw_email,
    int id
);

void send_mail_raw_free(send_mail_raw_t *send_mail_raw);

send_mail_raw_t *send_mail_raw_parseFromJSON(cJSON *send_mail_rawJSON);

cJSON *send_mail_raw_convertToJSON(send_mail_raw_t *send_mail_raw);

#endif /* _send_mail_raw_H_ */

