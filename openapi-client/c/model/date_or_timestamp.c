#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "date_or_timestamp.h"



static date_or_timestamp_t *date_or_timestamp_create_internal(
    ) {
    date_or_timestamp_t *date_or_timestamp_local_var = malloc(sizeof(date_or_timestamp_t));
    if (!date_or_timestamp_local_var) {
        return NULL;
    }
    memset(date_or_timestamp_local_var, 0, sizeof(date_or_timestamp_t));
    date_or_timestamp_local_var->_library_owned = 1;
    return date_or_timestamp_local_var;
}

__attribute__((deprecated)) date_or_timestamp_t *date_or_timestamp_create(
    ) {
    date_or_timestamp_t *result = date_or_timestamp_create_internal (
        );
    if (!result) {
    }
    return result;
}

void date_or_timestamp_free(date_or_timestamp_t *date_or_timestamp) {
    if(NULL == date_or_timestamp){
        return ;
    }
    if(date_or_timestamp->_library_owned != 1){
        fprintf(stderr, "WARNING: %s() does NOT free objects allocated by the user\n", "date_or_timestamp_free");
        return ;
    }
    listEntry_t *listEntry;
    free(date_or_timestamp);
}

cJSON *date_or_timestamp_convertToJSON(date_or_timestamp_t *date_or_timestamp) {
    cJSON *item = cJSON_CreateObject();
    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

date_or_timestamp_t *date_or_timestamp_parseFromJSON(cJSON *date_or_timestampJSON){

    date_or_timestamp_t *date_or_timestamp_local_var = NULL;



    date_or_timestamp_local_var = date_or_timestamp_create_internal (
        );

    if (!date_or_timestamp_local_var) {
        goto end;
    }

    return date_or_timestamp_local_var;
end:
    return NULL;

}
