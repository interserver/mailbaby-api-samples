/*
 * mail_block_click_house.h
 *
 * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
 */

#ifndef _mail_block_click_house_H_
#define _mail_block_click_house_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct mail_block_click_house_t mail_block_click_house_t;




typedef struct mail_block_click_house_t {
    char *date; //date
    char *from; // string
    char *subject; // string
    char *to; // string
    char *message_id; // string

    int _library_owned; // Is the library responsible for freeing this object?
} mail_block_click_house_t;

__attribute__((deprecated)) mail_block_click_house_t *mail_block_click_house_create(
    char *date,
    char *from,
    char *subject,
    char *to,
    char *message_id
);

void mail_block_click_house_free(mail_block_click_house_t *mail_block_click_house);

mail_block_click_house_t *mail_block_click_house_parseFromJSON(cJSON *mail_block_click_houseJSON);

cJSON *mail_block_click_house_convertToJSON(mail_block_click_house_t *mail_block_click_house);

#endif /* _mail_block_click_house_H_ */

