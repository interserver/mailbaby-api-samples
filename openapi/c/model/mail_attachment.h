/*
 * mail_attachment.h
 *
 * A File attachment for an email
 */

#ifndef _mail_attachment_H_
#define _mail_attachment_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct mail_attachment_t mail_attachment_t;




typedef struct mail_attachment_t {
    char *filename; // string
    binary_t* data; //binary

} mail_attachment_t;

mail_attachment_t *mail_attachment_create(
    char *filename,
    binary_t* data
);

void mail_attachment_free(mail_attachment_t *mail_attachment);

mail_attachment_t *mail_attachment_parseFromJSON(cJSON *mail_attachmentJSON);

cJSON *mail_attachment_convertToJSON(mail_attachment_t *mail_attachment);

#endif /* _mail_attachment_H_ */

