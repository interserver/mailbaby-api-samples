#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "deny_rule_record_all_of.h"



deny_rule_record_all_of_t *deny_rule_record_all_of_create(
    int id,
    char *created
    ) {
    deny_rule_record_all_of_t *deny_rule_record_all_of_local_var = malloc(sizeof(deny_rule_record_all_of_t));
    if (!deny_rule_record_all_of_local_var) {
        return NULL;
    }
    deny_rule_record_all_of_local_var->id = id;
    deny_rule_record_all_of_local_var->created = created;

    return deny_rule_record_all_of_local_var;
}


void deny_rule_record_all_of_free(deny_rule_record_all_of_t *deny_rule_record_all_of) {
    if(NULL == deny_rule_record_all_of){
        return ;
    }
    listEntry_t *listEntry;
    if (deny_rule_record_all_of->created) {
        free(deny_rule_record_all_of->created);
        deny_rule_record_all_of->created = NULL;
    }
    free(deny_rule_record_all_of);
}

cJSON *deny_rule_record_all_of_convertToJSON(deny_rule_record_all_of_t *deny_rule_record_all_of) {
    cJSON *item = cJSON_CreateObject();

    // deny_rule_record_all_of->id
    if (!deny_rule_record_all_of->id) {
        goto fail;
    }
    if(cJSON_AddNumberToObject(item, "id", deny_rule_record_all_of->id) == NULL) {
    goto fail; //Numeric
    }


    // deny_rule_record_all_of->created
    if (!deny_rule_record_all_of->created) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "created", deny_rule_record_all_of->created) == NULL) {
    goto fail; //Date-Time
    }

    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

deny_rule_record_all_of_t *deny_rule_record_all_of_parseFromJSON(cJSON *deny_rule_record_all_ofJSON){

    deny_rule_record_all_of_t *deny_rule_record_all_of_local_var = NULL;

    // deny_rule_record_all_of->id
    cJSON *id = cJSON_GetObjectItemCaseSensitive(deny_rule_record_all_ofJSON, "id");
    if (!id) {
        goto end;
    }

    
    if(!cJSON_IsNumber(id))
    {
    goto end; //Numeric
    }

    // deny_rule_record_all_of->created
    cJSON *created = cJSON_GetObjectItemCaseSensitive(deny_rule_record_all_ofJSON, "created");
    if (!created) {
        goto end;
    }

    
    if(!cJSON_IsString(created) && !cJSON_IsNull(created))
    {
    goto end; //DateTime
    }


    deny_rule_record_all_of_local_var = deny_rule_record_all_of_create (
        id->valuedouble,
        strdup(created->valuestring)
        );

    return deny_rule_record_all_of_local_var;
end:
    return NULL;

}
