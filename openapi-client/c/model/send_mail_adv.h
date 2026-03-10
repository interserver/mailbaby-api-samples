/*
 * send_mail_adv.h
 *
 * Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.
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

    int _library_owned; // Is the library responsible for freeing this object?
} send_mail_adv_t;

__attribute__((deprecated)) send_mail_adv_t *send_mail_adv_create(
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

