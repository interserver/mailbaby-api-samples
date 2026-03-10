/*
 * mail_order.h
 *
 * A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The &#x60;id&#x60; is the numeric identifier used across most API calls.  The &#x60;username&#x60; is always &#x60;mb&lt;id&gt;&#x60; and is the SMTP AUTH username for &#x60;relay.mailbaby.net&#x60;.
 */

#ifndef _mail_order_H_
#define _mail_order_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct mail_order_t mail_order_t;




typedef struct mail_order_t {
    int id; //numeric
    char *status; // string
    char *username; // string
    char *comment; // string

    int _library_owned; // Is the library responsible for freeing this object?
} mail_order_t;

__attribute__((deprecated)) mail_order_t *mail_order_create(
    int id,
    char *status,
    char *username,
    char *comment
);

void mail_order_free(mail_order_t *mail_order);

mail_order_t *mail_order_parseFromJSON(cJSON *mail_orderJSON);

cJSON *mail_order_convertToJSON(mail_order_t *mail_order);

#endif /* _mail_order_H_ */

