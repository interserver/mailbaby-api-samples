#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "email_addresses_types.h"



static email_addresses_types_t *email_addresses_types_create_internal(
    ) {
    email_addresses_types_t *email_addresses_types_local_var = malloc(sizeof(email_addresses_types_t));
    if (!email_addresses_types_local_var) {
        return NULL;
    }

    email_addresses_types_local_var->_library_owned = 1;
    return email_addresses_types_local_var;
}

__attribute__((deprecated)) email_addresses_types_t *email_addresses_types_create(
    ) {
    return email_addresses_types_create_internal (
        );
}

void email_addresses_types_free(email_addresses_types_t *email_addresses_types) {
    if(NULL == email_addresses_types){
        return ;
    }
    if(email_addresses_types->_library_owned != 1){
        fprintf(stderr, "WARNING: %s() does NOT free objects allocated by the user\n", "email_addresses_types_free");
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


    email_addresses_types_local_var = email_addresses_types_create_internal (
        );

    return email_addresses_types_local_var;
end:
    return NULL;

}
