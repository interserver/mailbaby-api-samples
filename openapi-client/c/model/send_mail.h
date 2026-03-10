/*
 * send_mail.h
 *
 * Request body for &#x60;POST /mail/send&#x60;.  Sends a simple single-recipient message. HTML detection is automatic — if &#x60;body&#x60; contains HTML tags the message is sent as &#x60;text/html&#x60;; otherwise as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is automatically set as both the &#x60;From&#x60; and &#x60;Reply-To&#x60; headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use &#x60;POST /mail/advsend&#x60; instead.
 */

#ifndef _send_mail_H_
#define _send_mail_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct send_mail_t send_mail_t;

#include "send_mail_to.h"



typedef struct send_mail_t {
    struct send_mail_to_t *to; //model
    char *from; // string
    char *subject; // string
    char *body; // string
    long id; //numeric

    int _library_owned; // Is the library responsible for freeing this object?
} send_mail_t;

__attribute__((deprecated)) send_mail_t *send_mail_create(
    send_mail_to_t *to,
    char *from,
    char *subject,
    char *body,
    long id
);

void send_mail_free(send_mail_t *send_mail);

send_mail_t *send_mail_parseFromJSON(cJSON *send_mailJSON);

cJSON *send_mail_convertToJSON(send_mail_t *send_mail);

#endif /* _send_mail_H_ */

