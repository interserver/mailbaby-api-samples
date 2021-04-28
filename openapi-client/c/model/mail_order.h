/*
 * mail_order.h
 *
 * 
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
    char *password; // string
    char *comment; // string

} mail_order_t;

mail_order_t *mail_order_create(
    int id,
    char *status,
    char *username,
    char *password,
    char *comment
);

void mail_order_free(mail_order_t *mail_order);

mail_order_t *mail_order_parseFromJSON(cJSON *mail_orderJSON);

cJSON *mail_order_convertToJSON(mail_order_t *mail_order);

#endif /* _mail_order_H_ */

