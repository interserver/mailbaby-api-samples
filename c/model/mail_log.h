/*
 * mail_log.h
 *
 * Mail Order Details
 */

#ifndef _mail_log_H_
#define _mail_log_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct mail_log_t mail_log_t;




typedef struct mail_log_t {
    long id; //numeric

} mail_log_t;

mail_log_t *mail_log_create(
    long id
);

void mail_log_free(mail_log_t *mail_log);

mail_log_t *mail_log_parseFromJSON(cJSON *mail_logJSON);

cJSON *mail_log_convertToJSON(mail_log_t *mail_log);

#endif /* _mail_log_H_ */

