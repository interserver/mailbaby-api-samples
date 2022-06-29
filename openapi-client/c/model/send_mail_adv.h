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

#include "send_mail_adv_attachments_inner.h"
#include "send_mail_adv_bcc_inner.h"
#include "send_mail_adv_cc_inner.h"
#include "send_mail_adv_from.h"
#include "send_mail_adv_replyto_inner.h"
#include "send_mail_adv_to_inner.h"



typedef struct send_mail_adv_t {
    char *subject; // string
    char *body; // string
    struct send_mail_adv_from_t *from; //model
    list_t *to; //nonprimitive container
    list_t *replyto; //nonprimitive container
    list_t *cc; //nonprimitive container
    list_t *bcc; //nonprimitive container
    list_t *attachments; //nonprimitive container
    long id; //numeric

} send_mail_adv_t;

send_mail_adv_t *send_mail_adv_create(
    char *subject,
    char *body,
    send_mail_adv_from_t *from,
    list_t *to,
    list_t *replyto,
    list_t *cc,
    list_t *bcc,
    list_t *attachments,
    long id
);

void send_mail_adv_free(send_mail_adv_t *send_mail_adv);

send_mail_adv_t *send_mail_adv_parseFromJSON(cJSON *send_mail_advJSON);

cJSON *send_mail_adv_convertToJSON(send_mail_adv_t *send_mail_adv);

#endif /* _send_mail_adv_H_ */

