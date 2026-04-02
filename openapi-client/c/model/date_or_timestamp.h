/*
 * date_or_timestamp.h
 *
 * A date/time value accepted as either a Unix timestamp (integer seconds since epoch) or a date string parseable by &#x60;strtotime()&#x60; (e.g. &#x60;2024-01-15&#x60;, &#x60;last monday&#x60;).
 */

#ifndef _date_or_timestamp_H_
#define _date_or_timestamp_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct date_or_timestamp_t date_or_timestamp_t;




typedef struct date_or_timestamp_t {

    int _library_owned; // Is the library responsible for freeing this object?
} date_or_timestamp_t;

__attribute__((deprecated)) date_or_timestamp_t *date_or_timestamp_create(
);

void date_or_timestamp_free(date_or_timestamp_t *date_or_timestamp);

date_or_timestamp_t *date_or_timestamp_parseFromJSON(cJSON *date_or_timestampJSON);

cJSON *date_or_timestamp_convertToJSON(date_or_timestamp_t *date_or_timestamp);

#endif /* _date_or_timestamp_H_ */

