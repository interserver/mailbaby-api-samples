/*
 * mail_contact.h
 *
 * An Email Contact
 */

#ifndef _mail_contact_H_
#define _mail_contact_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct mail_contact_t mail_contact_t;




typedef struct mail_contact_t {
    char *email; // string
    char *name; // string

} mail_contact_t;

mail_contact_t *mail_contact_create(
    char *email,
    char *name
);

void mail_contact_free(mail_contact_t *mail_contact);

mail_contact_t *mail_contact_parseFromJSON(cJSON *mail_contactJSON);

cJSON *mail_contact_convertToJSON(mail_contact_t *mail_contact);

#endif /* _mail_contact_H_ */

