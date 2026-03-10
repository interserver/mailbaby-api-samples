/*
 * mail_attachment.h
 *
 * A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
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
    char *data; //ByteArray

    int _library_owned; // Is the library responsible for freeing this object?
} mail_attachment_t;

__attribute__((deprecated)) mail_attachment_t *mail_attachment_create(
    char *filename,
    char *data
);

void mail_attachment_free(mail_attachment_t *mail_attachment);

mail_attachment_t *mail_attachment_parseFromJSON(cJSON *mail_attachmentJSON);

cJSON *mail_attachment_convertToJSON(mail_attachment_t *mail_attachment);

#endif /* _mail_attachment_H_ */

