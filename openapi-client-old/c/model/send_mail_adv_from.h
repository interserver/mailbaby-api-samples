/*
 * send_mail_adv_from.h
 *
 * An Email Contact
 */

#ifndef _send_mail_adv_from_H_
#define _send_mail_adv_from_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct send_mail_adv_from_t send_mail_adv_from_t;




typedef struct send_mail_adv_from_t {
    char *email; // string
    char *name; // string

} send_mail_adv_from_t;

send_mail_adv_from_t *send_mail_adv_from_create(
    char *email,
    char *name
);

void send_mail_adv_from_free(send_mail_adv_from_t *send_mail_adv_from);

send_mail_adv_from_t *send_mail_adv_from_parseFromJSON(cJSON *send_mail_adv_fromJSON);

cJSON *send_mail_adv_from_convertToJSON(send_mail_adv_from_t *send_mail_adv_from);

#endif /* _send_mail_adv_from_H_ */

