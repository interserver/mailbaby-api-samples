/*
 * send_mail_adv.h
 *
 * Details for an Email
 */

#ifndef _send_mail_adv_H_
#define _send_mail_adv_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct send_mail_adv_t send_mail_adv_t;

#include "email_address_types.h"
#include "email_addresses_types.h"
#include "mail_attachment.h"



typedef struct send_mail_adv_t {
    char *subject; // string
    char *body; // string
    struct email_address_types_t *from; //model
    struct email_addresses_types_t *to; //model
    struct email_addresses_types_t *replyto; //model
    struct email_addresses_types_t *cc; //model
    struct email_addresses_types_t *bcc; //model
    list_t *attachments; //nonprimitive container
    long id; //numeric

} send_mail_adv_t;

send_mail_adv_t *send_mail_adv_create(
    char *subject,
    char *body,
    email_address_types_t *from,
    email_addresses_types_t *to,
    email_addresses_types_t *replyto,
    email_addresses_types_t *cc,
    email_addresses_types_t *bcc,
    list_t *attachments,
    long id
);

void send_mail_adv_free(send_mail_adv_t *send_mail_adv);

send_mail_adv_t *send_mail_adv_parseFromJSON(cJSON *send_mail_advJSON);

cJSON *send_mail_adv_convertToJSON(send_mail_adv_t *send_mail_adv);

#endif /* _send_mail_adv_H_ */

