#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "email_address_types.h"



email_address_types_t *email_address_types_create(
    char *email,
    char *name
    ) {
    email_address_types_t *email_address_types_local_var = malloc(sizeof(email_address_types_t));
    if (!email_address_types_local_var) {
        return NULL;
    }
    email_address_types_local_var->email = email;
    email_address_types_local_var->name = name;

    return email_address_types_local_var;
}


void email_address_types_free(email_address_types_t *email_address_types) {
    if(NULL == email_address_types){
        return ;
    }
    listEntry_t *listEntry;
    if (email_address_types->email) {
        free(email_address_types->email);
        email_address_types->email = NULL;
    }
    if (email_address_types->name) {
        free(email_address_types->name);
        email_address_types->name = NULL;
    }
    free(email_address_types);
}

cJSON *email_address_types_convertToJSON(email_address_types_t *email_address_types) {
    cJSON *item = cJSON_CreateObject();

    // email_address_types->email
    if (!email_address_types->email) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "email", email_address_types->email) == NULL) {
    goto fail; //String
    }


    // email_address_types->name
    if(email_address_types->name) {
    if(cJSON_AddStringToObject(item, "name", email_address_types->name) == NULL) {
    goto fail; //String
    }
    }

    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

email_address_types_t *email_address_types_parseFromJSON(cJSON *email_address_typesJSON){

    email_address_types_t *email_address_types_local_var = NULL;

    // email_address_types->email
    cJSON *email = cJSON_GetObjectItemCaseSensitive(email_address_typesJSON, "email");
    if (!email) {
        goto end;
    }

    
    if(!cJSON_IsString(email))
    {
    goto end; //String
    }

    // email_address_types->name
    cJSON *name = cJSON_GetObjectItemCaseSensitive(email_address_typesJSON, "name");
    if (name) { 
    if(!cJSON_IsString(name) && !cJSON_IsNull(name))
    {
    goto end; //String
    }
    }


    email_address_types_local_var = email_address_types_create (
        strdup(email->valuestring),
        name && !cJSON_IsNull(name) ? strdup(name->valuestring) : NULL
        );

    return email_address_types_local_var;
end:
    return NULL;

}
