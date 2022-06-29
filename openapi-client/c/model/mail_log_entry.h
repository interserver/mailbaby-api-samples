/*
 * mail_log_entry.h
 *
 * An email record
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
    char *subject; // string
    char *message_id; // string
    char *created; // string
    int time; //numeric
    char *user; // string
    char *transtype; // string
    char *transhost; // string
    char *originhost; // string
    char *origin; // string
    char *interface; // string
    char *date; // string
    char *sending_zone; // string
    int body_size; //numeric
    char *source_md5; // string
    int seq; //numeric
    char *domain; // string
    char *recipient; // string
    int locked; //numeric
    int lock_time; //numeric
    char *assigned; // string
    char *queued; // string
    char *_lock; // string
    char *logger; // string
    int mx_port; //numeric
    char *connection_key; // string
    char *mx_hostname; // string
    char *sent_body_hash; // string
    int sent_body_size; //numeric
    int md5_match; //numeric

} mail_log_entry_t;

mail_log_entry_t *mail_log_entry_create(
    int _id,
    char *id,
    char *from,
    char *to,
    char *subject,
    char *message_id,
    char *created,
    int time,
    char *user,
    char *transtype,
    char *transhost,
    char *originhost,
    char *origin,
    char *interface,
    char *date,
    char *sending_zone,
    int body_size,
    char *source_md5,
    int seq,
    char *domain,
    char *recipient,
    int locked,
    int lock_time,
    char *assigned,
    char *queued,
    char *_lock,
    char *logger,
    int mx_port,
    char *connection_key,
    char *mx_hostname,
    char *sent_body_hash,
    int sent_body_size,
    int md5_match
);

void mail_log_entry_free(mail_log_entry_t *mail_log_entry);

mail_log_entry_t *mail_log_entry_parseFromJSON(cJSON *mail_log_entryJSON);

cJSON *mail_log_entry_convertToJSON(mail_log_entry_t *mail_log_entry);

#endif /* _mail_log_entry_H_ */

