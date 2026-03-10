/*
 * mail_order_detail.h
 *
 * Extended mail order record including the current SMTP password.  Returned by &#x60;GET /mail/{id}&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; fields can be used to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
 */

#ifndef _mail_order_detail_H_
#define _mail_order_detail_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct mail_order_detail_t mail_order_detail_t;




typedef struct mail_order_detail_t {
    int id; //numeric
    char *status; // string
    char *username; // string
    char *password; // string
    char *comment; // string

    int _library_owned; // Is the library responsible for freeing this object?
} mail_order_detail_t;

__attribute__((deprecated)) mail_order_detail_t *mail_order_detail_create(
    int id,
    char *status,
    char *username,
    char *password,
    char *comment
);

void mail_order_detail_free(mail_order_detail_t *mail_order_detail);

mail_order_detail_t *mail_order_detail_parseFromJSON(cJSON *mail_order_detailJSON);

cJSON *mail_order_detail_convertToJSON(mail_order_detail_t *mail_order_detail);

#endif /* _mail_order_detail_H_ */

