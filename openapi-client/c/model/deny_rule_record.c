#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "deny_rule_record.h"


char* deny_rule_record_type_ToString(mailbaby_email_delivery_and_management_service_api_deny_rule_record_TYPE_e type) {
    char* typeArray[] =  { "NULL", "domain", "email", "startswith", "destination" };
    return typeArray[type];
}

mailbaby_email_delivery_and_management_service_api_deny_rule_record_TYPE_e deny_rule_record_type_FromString(char* type){
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

deny_rule_record_t *deny_rule_record_create(
    mailbaby_email_delivery_and_management_service_api_deny_rule_record_TYPE_e type,
    char *data,
    char *id,
    char *created,
    char *user
    ) {
    deny_rule_record_t *deny_rule_record_local_var = malloc(sizeof(deny_rule_record_t));
    if (!deny_rule_record_local_var) {
        return NULL;
    }
    deny_rule_record_local_var->type = type;
    deny_rule_record_local_var->data = data;
    deny_rule_record_local_var->id = id;
    deny_rule_record_local_var->created = created;
    deny_rule_record_local_var->user = user;

    return deny_rule_record_local_var;
}


void deny_rule_record_free(deny_rule_record_t *deny_rule_record) {
    if(NULL == deny_rule_record){
        return ;
    }
    listEntry_t *listEntry;
    if (deny_rule_record->data) {
        free(deny_rule_record->data);
        deny_rule_record->data = NULL;
    }
    if (deny_rule_record->id) {
        free(deny_rule_record->id);
        deny_rule_record->id = NULL;
    }
    if (deny_rule_record->created) {
        free(deny_rule_record->created);
        deny_rule_record->created = NULL;
    }
    if (deny_rule_record->user) {
        free(deny_rule_record->user);
        deny_rule_record->user = NULL;
    }
    free(deny_rule_record);
}

cJSON *deny_rule_record_convertToJSON(deny_rule_record_t *deny_rule_record) {
    cJSON *item = cJSON_CreateObject();

    // deny_rule_record->type
    if (mailbaby_email_delivery_and_management_service_api_deny_rule_record_TYPE_NULL == deny_rule_record->type) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "type", typedeny_rule_record_ToString(deny_rule_record->type)) == NULL)
    {
    goto fail; //Enum
    }


    // deny_rule_record->data
    if (!deny_rule_record->data) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "data", deny_rule_record->data) == NULL) {
    goto fail; //String
    }


    // deny_rule_record->id
    if (!deny_rule_record->id) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "id", deny_rule_record->id) == NULL) {
    goto fail; //String
    }


    // deny_rule_record->created
    if (!deny_rule_record->created) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "created", deny_rule_record->created) == NULL) {
    goto fail; //Date-Time
    }


    // deny_rule_record->user
    if(deny_rule_record->user) {
    if(cJSON_AddStringToObject(item, "user", deny_rule_record->user) == NULL) {
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

deny_rule_record_t *deny_rule_record_parseFromJSON(cJSON *deny_rule_recordJSON){

    deny_rule_record_t *deny_rule_record_local_var = NULL;

    // deny_rule_record->type
    cJSON *type = cJSON_GetObjectItemCaseSensitive(deny_rule_recordJSON, "type");
    if (!type) {
        goto end;
    }

    mailbaby_email_delivery_and_management_service_api_deny_rule_record_TYPE_e typeVariable;
    
    if(!cJSON_IsString(type))
    {
    goto end; //Enum
    }
    typeVariable = deny_rule_record_type_FromString(type->valuestring);

    // deny_rule_record->data
    cJSON *data = cJSON_GetObjectItemCaseSensitive(deny_rule_recordJSON, "data");
    if (!data) {
        goto end;
    }

    
    if(!cJSON_IsString(data))
    {
    goto end; //String
    }

    // deny_rule_record->id
    cJSON *id = cJSON_GetObjectItemCaseSensitive(deny_rule_recordJSON, "id");
    if (!id) {
        goto end;
    }

    
    if(!cJSON_IsString(id))
    {
    goto end; //String
    }

    // deny_rule_record->created
    cJSON *created = cJSON_GetObjectItemCaseSensitive(deny_rule_recordJSON, "created");
    if (!created) {
        goto end;
    }

    
    if(!cJSON_IsString(created) && !cJSON_IsNull(created))
    {
    goto end; //DateTime
    }

    // deny_rule_record->user
    cJSON *user = cJSON_GetObjectItemCaseSensitive(deny_rule_recordJSON, "user");
    if (user) { 
    if(!cJSON_IsString(user) && !cJSON_IsNull(user))
    {
    goto end; //String
    }
    }


    deny_rule_record_local_var = deny_rule_record_create (
        typeVariable,
        strdup(data->valuestring),
        strdup(id->valuestring),
        strdup(created->valuestring),
        user && !cJSON_IsNull(user) ? strdup(user->valuestring) : NULL
        );

    return deny_rule_record_local_var;
end:
    return NULL;

}
