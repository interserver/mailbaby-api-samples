#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "email_addresses_types.h"



email_addresses_types_t *email_addresses_types_create(
    ) {
    email_addresses_types_t *email_addresses_types_local_var = malloc(sizeof(email_addresses_types_t));
    if (!email_addresses_types_local_var) {
        return NULL;
    }

    return email_addresses_types_local_var;
}


void email_addresses_types_free(email_addresses_types_t *email_addresses_types) {
    if(NULL == email_addresses_types){
        return ;
    }
    listEntry_t *listEntry;
    free(email_addresses_types);
}

cJSON *email_addresses_types_convertToJSON(email_addresses_types_t *email_addresses_types) {
    cJSON *item = cJSON_CreateObject();
    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

email_addresses_types_t *email_addresses_types_parseFromJSON(cJSON *email_addresses_typesJSON){

    email_addresses_types_t *email_addresses_types_local_var = NULL;


    email_addresses_types_local_var = email_addresses_types_create (
        );

    return email_addresses_types_local_var;
end:
    return NULL;

}
