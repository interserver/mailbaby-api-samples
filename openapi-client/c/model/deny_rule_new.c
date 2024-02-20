#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "deny_rule_new.h"


char* typedeny_rule_new_ToString(mailbaby_email_delivery_and_management_service_api_deny_rule_new_TYPE_e type) {
    char* typeArray[] =  { "NULL", "domain", "email", "startswith", "destination" };
	return typeArray[type];
}

mailbaby_email_delivery_and_management_service_api_deny_rule_new_TYPE_e typedeny_rule_new_FromString(char* type){
    int stringToReturn = 0;
    char *typeArray[] =  { "NULL", "domain", "email", "startswith", "destination" };
    size_t sizeofArray = sizeof(typeArray) / sizeof(typeArray[0]);
    while(stringToReturn < sizeofArray) {
        if(strcmp(type, typeArray[stringToReturn]) == 0) {
            return stringToReturn;
        }
        stringToReturn++;
    }
    return 0;
}

deny_rule_new_t *deny_rule_new_create(
    mailbaby_email_delivery_and_management_service_api_deny_rule_new_TYPE_e type,
    char *data,
    char *user
    ) {
    deny_rule_new_t *deny_rule_new_local_var = malloc(sizeof(deny_rule_new_t));
    if (!deny_rule_new_local_var) {
        return NULL;
    }
    deny_rule_new_local_var->type = type;
    deny_rule_new_local_var->data = data;
    deny_rule_new_local_var->user = user;

    return deny_rule_new_local_var;
}


void deny_rule_new_free(deny_rule_new_t *deny_rule_new) {
    if(NULL == deny_rule_new){
        return ;
    }
    listEntry_t *listEntry;
    if (deny_rule_new->data) {
        free(deny_rule_new->data);
        deny_rule_new->data = NULL;
    }
    if (deny_rule_new->user) {
        free(deny_rule_new->user);
        deny_rule_new->user = NULL;
    }
    free(deny_rule_new);
}

cJSON *deny_rule_new_convertToJSON(deny_rule_new_t *deny_rule_new) {
    cJSON *item = cJSON_CreateObject();

    // deny_rule_new->type
    if (mailbaby_email_delivery_and_management_service_api_deny_rule_new_TYPE_NULL == deny_rule_new->type) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "type", typedeny_rule_new_ToString(deny_rule_new->type)) == NULL)
    {
    goto fail; //Enum
    }


    // deny_rule_new->data
    if (!deny_rule_new->data) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "data", deny_rule_new->data) == NULL) {
    goto fail; //String
    }


    // deny_rule_new->user
    if(deny_rule_new->user) {
    if(cJSON_AddStringToObject(item, "user", deny_rule_new->user) == NULL) {
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

deny_rule_new_t *deny_rule_new_parseFromJSON(cJSON *deny_rule_newJSON){

    deny_rule_new_t *deny_rule_new_local_var = NULL;

    // deny_rule_new->type
    cJSON *type = cJSON_GetObjectItemCaseSensitive(deny_rule_newJSON, "type");
    if (!type) {
        goto end;
    }

    mailbaby_email_delivery_and_management_service_api_deny_rule_new_TYPE_e typeVariable;
    
    if(!cJSON_IsString(type))
    {
    goto end; //Enum
    }
    typeVariable = typedeny_rule_new_FromString(type->valuestring);

    // deny_rule_new->data
    cJSON *data = cJSON_GetObjectItemCaseSensitive(deny_rule_newJSON, "data");
    if (!data) {
        goto end;
    }

    
    if(!cJSON_IsString(data))
    {
    goto end; //String
    }

    // deny_rule_new->user
    cJSON *user = cJSON_GetObjectItemCaseSensitive(deny_rule_newJSON, "user");
    if (user) { 
    if(!cJSON_IsString(user) && !cJSON_IsNull(user))
    {
    goto end; //String
    }
    }


    deny_rule_new_local_var = deny_rule_new_create (
        typeVariable,
        strdup(data->valuestring),
        user && !cJSON_IsNull(user) ? strdup(user->valuestring) : NULL
        );

    return deny_rule_new_local_var;
end:
    return NULL;

}
