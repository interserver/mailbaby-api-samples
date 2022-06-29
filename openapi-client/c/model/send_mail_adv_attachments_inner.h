/*
 * send_mail_adv_attachments_inner.h
 *
 * A File attachment for an email
 */

#ifndef _send_mail_adv_attachments_inner_H_
#define _send_mail_adv_attachments_inner_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct send_mail_adv_attachments_inner_t send_mail_adv_attachments_inner_t;




typedef struct send_mail_adv_attachments_inner_t {
    binary_t* data; //binary
    char *filename; // string

} send_mail_adv_attachments_inner_t;

send_mail_adv_attachments_inner_t *send_mail_adv_attachments_inner_create(
    binary_t* data,
    char *filename
);

void send_mail_adv_attachments_inner_free(send_mail_adv_attachments_inner_t *send_mail_adv_attachments_inner);

send_mail_adv_attachments_inner_t *send_mail_adv_attachments_inner_parseFromJSON(cJSON *send_mail_adv_attachments_innerJSON);

cJSON *send_mail_adv_attachments_inner_convertToJSON(send_mail_adv_attachments_inner_t *send_mail_adv_attachments_inner);

#endif /* _send_mail_adv_attachments_inner_H_ */

