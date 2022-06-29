/*
 * send_mail_adv_to_inner.h
 *
 * An Email Contact
 */

#ifndef _send_mail_adv_to_inner_H_
#define _send_mail_adv_to_inner_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct send_mail_adv_to_inner_t send_mail_adv_to_inner_t;




typedef struct send_mail_adv_to_inner_t {
    char *email; // string
    char *name; // string

} send_mail_adv_to_inner_t;

send_mail_adv_to_inner_t *send_mail_adv_to_inner_create(
    char *email,
    char *name
);

void send_mail_adv_to_inner_free(send_mail_adv_to_inner_t *send_mail_adv_to_inner);

send_mail_adv_to_inner_t *send_mail_adv_to_inner_parseFromJSON(cJSON *send_mail_adv_to_innerJSON);

cJSON *send_mail_adv_to_inner_convertToJSON(send_mail_adv_to_inner_t *send_mail_adv_to_inner);

#endif /* _send_mail_adv_to_inner_H_ */

