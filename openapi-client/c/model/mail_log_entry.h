/*
 * mail_log_entry.h
 *
 * A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.
 */

#ifndef _mail_log_entry_H_
#define _mail_log_entry_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct mail_log_entry_t mail_log_entry_t;




typedef struct mail_log_entry_t {
    int _id; //numeric
    char *id; // string
    char *from; // string
    char *to; // string
    char *created; // string
    int time; //numeric
    char *user; // string
    char *transtype; // string
    char *origin; // string
    char *interface; // string
    char *subject; // string
    char *message_id; // string
    char *sending_zone; // string
    int body_size; //numeric
    int seq; //numeric
    int delivered; //numeric
    char *response; // string
    char *recipient; // string
    char *domain; // string
    int locked; //numeric
    char *lock_time; // string
    char *assigned; // string
    char *queued; // string
    char *mx_hostname; // string

    int _library_owned; // Is the library responsible for freeing this object?
} mail_log_entry_t;

__attribute__((deprecated)) mail_log_entry_t *mail_log_entry_create(
    int _id,
    char *id,
    char *from,
    char *to,
    char *created,
    int time,
    char *user,
    char *transtype,
    char *origin,
    char *interface,
    char *subject,
    char *message_id,
    char *sending_zone,
    int body_size,
    int seq,
    int delivered,
    char *response,
    char *recipient,
    char *domain,
    int locked,
    char *lock_time,
    char *assigned,
    char *queued,
    char *mx_hostname
);

void mail_log_entry_free(mail_log_entry_t *mail_log_entry);

mail_log_entry_t *mail_log_entry_parseFromJSON(cJSON *mail_log_entryJSON);

cJSON *mail_log_entry_convertToJSON(mail_log_entry_t *mail_log_entry);

#endif /* _mail_log_entry_H_ */

