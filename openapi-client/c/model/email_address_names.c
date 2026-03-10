#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "email_address_names.h"



static email_address_names_t *email_address_names_create_internal(
    ) {
    email_address_names_t *email_address_names_local_var = malloc(sizeof(email_address_names_t));
    if (!email_address_names_local_var) {
        return NULL;
    }

    email_address_names_local_var->_library_owned = 1;
    return email_address_names_local_var;
}

__attribute__((deprecated)) email_address_names_t *email_address_names_create(
    ) {
    return email_address_names_create_internal (
        );
}

void email_address_names_free(email_address_names_t *email_address_names) {
    if(NULL == email_address_names){
        return ;
    }
    if(email_address_names->_library_owned != 1){
        fprintf(stderr, "WARNING: %s() does NOT free objects allocated by the user\n", "email_address_names_free");
        return ;
    }
    listEntry_t *listEntry;
    free(email_address_names);
}

cJSON *email_address_names_convertToJSON(email_address_names_t *email_address_names) {
    cJSON *item = cJSON_CreateObject();
    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

email_address_names_t *email_address_names_parseFromJSON(cJSON *email_address_namesJSON){

    email_address_names_t *email_address_names_local_var = NULL;


    email_address_names_local_var = email_address_names_create_internal (
        );

    return email_address_names_local_var;
end:
    return NULL;

}
