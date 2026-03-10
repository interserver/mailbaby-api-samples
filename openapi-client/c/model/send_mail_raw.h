/*
 * send_mail_raw.h
 *
 * Request body for &#x60;POST /mail/rawsend&#x60;.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing &#x60;DKIM-Signature&#x60; header intact.  The &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, and &#x60;Bcc&#x60; addresses are extracted from the message headers automatically — you do not need to specify them separately.
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
    long id; //numeric

    int _library_owned; // Is the library responsible for freeing this object?
} send_mail_raw_t;

__attribute__((deprecated)) send_mail_raw_t *send_mail_raw_create(
    char *raw_email,
    long id
);

void send_mail_raw_free(send_mail_raw_t *send_mail_raw);

send_mail_raw_t *send_mail_raw_parseFromJSON(cJSON *send_mail_rawJSON);

cJSON *send_mail_raw_convertToJSON(send_mail_raw_t *send_mail_raw);

#endif /* _send_mail_raw_H_ */

