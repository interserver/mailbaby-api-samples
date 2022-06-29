/*
 * get_mail_orders_401_response.h
 *
 * 
 */

#ifndef _get_mail_orders_401_response_H_
#define _get_mail_orders_401_response_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct get_mail_orders_401_response_t get_mail_orders_401_response_t;




typedef struct get_mail_orders_401_response_t {
    char *code; // string
    char *message; // string

} get_mail_orders_401_response_t;

get_mail_orders_401_response_t *get_mail_orders_401_response_create(
    char *code,
    char *message
);

void get_mail_orders_401_response_free(get_mail_orders_401_response_t *get_mail_orders_401_response);

get_mail_orders_401_response_t *get_mail_orders_401_response_parseFromJSON(cJSON *get_mail_orders_401_responseJSON);

cJSON *get_mail_orders_401_response_convertToJSON(get_mail_orders_401_response_t *get_mail_orders_401_response);

#endif /* _get_mail_orders_401_response_H_ */

