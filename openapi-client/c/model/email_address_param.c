#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "email_address_param.h"



static email_address_param_t *email_address_param_create_internal(
    char *email
    ) {
    email_address_param_t *email_address_param_local_var = malloc(sizeof(email_address_param_t));
    if (!email_address_param_local_var) {
        return NULL;
    }
    memset(email_address_param_local_var, 0, sizeof(email_address_param_t));
    email_address_param_local_var->_library_owned = 1;
    email_address_param_local_var->email = email;
    return email_address_param_local_var;
}

__attribute__((deprecated)) email_address_param_t *email_address_param_create(
    char *email
    ) {
    email_address_param_t *result = email_address_param_create_internal (
        email
        );
    if (!result) {
    }
    return result;
}

void email_address_param_free(email_address_param_t *email_address_param) {
    if(NULL == email_address_param){
        return ;
    }
    if(email_address_param->_library_owned != 1){
        fprintf(stderr, "WARNING: %s() does NOT free objects allocated by the user\n", "email_address_param_free");
        return ;
    }
    listEntry_t *listEntry;
    if (email_address_param->email) {
        free(email_address_param->email);
        email_address_param->email = NULL;
    }
    free(email_address_param);
}

cJSON *email_address_param_convertToJSON(email_address_param_t *email_address_param) {
    cJSON *item = cJSON_CreateObject();

    // email_address_param->email
    if (!email_address_param->email) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "email", email_address_param->email) == NULL) {
    goto fail; //String
    }

    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

email_address_param_t *email_address_param_parseFromJSON(cJSON *email_address_paramJSON){

    email_address_param_t *email_address_param_local_var = NULL;

    char *email_local_str = NULL;

    // email_address_param->email
    cJSON *email = cJSON_GetObjectItemCaseSensitive(email_address_paramJSON, "email");
    if (cJSON_IsNull(email)) {
        email = NULL;
    }
    if (!email) {
        goto end;
    }

    
    if(!cJSON_IsString(email))
    {
    goto end; //String
    }


    if (email && !cJSON_IsNull(email)) email_local_str = strdup(email->valuestring);

    email_address_param_local_var = email_address_param_create_internal (
        email_local_str
        );

    if (!email_address_param_local_var) {
        goto end;
    }

    return email_address_param_local_var;
end:
    if (email_local_str) {
        free(email_local_str);
        email_local_str = NULL;
    }
    return NULL;

}
