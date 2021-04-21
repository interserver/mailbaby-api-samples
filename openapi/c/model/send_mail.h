/*
 * send_mail.h
 *
 * Details for an Email
 */

#ifndef _send_mail_H_
#define _send_mail_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct send_mail_t send_mail_t;

#include "mail_attachment.h"
#include "mail_contact.h"



typedef struct send_mail_t {
    long id; //numeric
    struct mail_contact_t *from; //model
    list_t *to; //nonprimitive container
    char *subject; // string
    char *body; // string
    list_t *replyto; //nonprimitive container
    list_t *cc; //nonprimitive container
    list_t *bcc; //nonprimitive container
    list_t *attachments; //nonprimitive container

} send_mail_t;

send_mail_t *send_mail_create(
    long id,
    mail_contact_t *from,
    list_t *to,
    char *subject,
    char *body,
    list_t *replyto,
    list_t *cc,
    list_t *bcc,
    list_t *attachments
);

void send_mail_free(send_mail_t *send_mail);

send_mail_t *send_mail_parseFromJSON(cJSON *send_mailJSON);

cJSON *send_mail_convertToJSON(send_mail_t *send_mail);

#endif /* _send_mail_H_ */

