/*
 * send_mail_to.h
 *
 * The primary recipient address for a simple send request. Accepts a single email address string or an array of email address strings for multiple recipients.
 */

#ifndef _send_mail_to_H_
#define _send_mail_to_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct send_mail_to_t send_mail_to_t;




typedef struct send_mail_to_t {

    int _library_owned; // Is the library responsible for freeing this object?
} send_mail_to_t;

__attribute__((deprecated)) send_mail_to_t *send_mail_to_create(
);

void send_mail_to_free(send_mail_to_t *send_mail_to);

send_mail_to_t *send_mail_to_parseFromJSON(cJSON *send_mail_toJSON);

cJSON *send_mail_to_convertToJSON(send_mail_to_t *send_mail_to);

#endif /* _send_mail_to_H_ */

