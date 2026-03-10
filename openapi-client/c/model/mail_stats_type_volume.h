/*
 * mail_stats_type_volume.h
 *
 * Top-500 breakdown of message counts grouped by source IP, destination address, and sender address within the selected &#x60;time&#x60; window.
 */

#ifndef _mail_stats_type_volume_H_
#define _mail_stats_type_volume_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct mail_stats_type_volume_t mail_stats_type_volume_t;




typedef struct mail_stats_type_volume_t {
    list_t* to; //map
    list_t* from; //map
    list_t* ip; //map

    int _library_owned; // Is the library responsible for freeing this object?
} mail_stats_type_volume_t;

__attribute__((deprecated)) mail_stats_type_volume_t *mail_stats_type_volume_create(
    list_t* to,
    list_t* from,
    list_t* ip
);

void mail_stats_type_volume_free(mail_stats_type_volume_t *mail_stats_type_volume);

mail_stats_type_volume_t *mail_stats_type_volume_parseFromJSON(cJSON *mail_stats_type_volumeJSON);

cJSON *mail_stats_type_volume_convertToJSON(mail_stats_type_volume_t *mail_stats_type_volume);

#endif /* _mail_stats_type_volume_H_ */

