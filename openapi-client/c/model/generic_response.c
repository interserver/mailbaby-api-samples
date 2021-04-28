#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "generic_response.h"



generic_response_t *generic_response_create(
    char *status,
    char *status_text
    ) {
    generic_response_t *generic_response_local_var = malloc(sizeof(generic_response_t));
    if (!generic_response_local_var) {
        return NULL;
    }
    generic_response_local_var->status = status;
    generic_response_local_var->status_text = status_text;

    return generic_response_local_var;
}


void generic_response_free(generic_response_t *generic_response) {
    if(NULL == generic_response){
        return ;
    }
    listEntry_t *listEntry;
    if (generic_response->status) {
        free(generic_response->status);
        generic_response->status = NULL;
    }
    if (generic_response->status_text) {
        free(generic_response->status_text);
        generic_response->status_text = NULL;
    }
    free(generic_response);
}

cJSON *generic_response_convertToJSON(generic_response_t *generic_response) {
    cJSON *item = cJSON_CreateObject();

    // generic_response->status
    if(generic_response->status) { 
    if(cJSON_AddStringToObject(item, "status", generic_response->status) == NULL) {
    goto fail; //String
    }
     } 


    // generic_response->status_text
    if(generic_response->status_text) { 
    if(cJSON_AddStringToObject(item, "status_text", generic_response->status_text) == NULL) {
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

generic_response_t *generic_response_parseFromJSON(cJSON *generic_responseJSON){

    generic_response_t *generic_response_local_var = NULL;

    // generic_response->status
    cJSON *status = cJSON_GetObjectItemCaseSensitive(generic_responseJSON, "status");
    if (status) { 
    if(!cJSON_IsString(status))
    {
    goto end; //String
    }
    }

    // generic_response->status_text
    cJSON *status_text = cJSON_GetObjectItemCaseSensitive(generic_responseJSON, "status_text");
    if (status_text) { 
    if(!cJSON_IsString(status_text))
    {
    goto end; //String
    }
    }


    generic_response_local_var = generic_response_create (
        status ? strdup(status->valuestring) : NULL,
        status_text ? strdup(status_text->valuestring) : NULL
        );

    return generic_response_local_var;
end:
    return NULL;

}
