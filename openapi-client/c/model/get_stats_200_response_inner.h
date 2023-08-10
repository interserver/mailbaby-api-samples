/*
 * get_stats_200_response_inner.h
 *
 * 
 */

#ifndef _get_stats_200_response_inner_H_
#define _get_stats_200_response_inner_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct get_stats_200_response_inner_t get_stats_200_response_inner_t;




typedef struct get_stats_200_response_inner_t {
    int id; //numeric
    char *status; // string
    char *username; // string
    char *password; // string
    char *comment; // string

} get_stats_200_response_inner_t;

get_stats_200_response_inner_t *get_stats_200_response_inner_create(
    int id,
    char *status,
    char *username,
    char *password,
    char *comment
);

void get_stats_200_response_inner_free(get_stats_200_response_inner_t *get_stats_200_response_inner);

get_stats_200_response_inner_t *get_stats_200_response_inner_parseFromJSON(cJSON *get_stats_200_response_innerJSON);

cJSON *get_stats_200_response_inner_convertToJSON(get_stats_200_response_inner_t *get_stats_200_response_inner);

#endif /* _get_stats_200_response_inner_H_ */

