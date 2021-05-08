#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "inline_response_401.h"



inline_response_401_t *inline_response_401_create(
    char *code,
    char *message
    ) {
    inline_response_401_t *inline_response_401_local_var = malloc(sizeof(inline_response_401_t));
    if (!inline_response_401_local_var) {
        return NULL;
    }
    inline_response_401_local_var->code = code;
    inline_response_401_local_var->message = message;

    return inline_response_401_local_var;
}


void inline_response_401_free(inline_response_401_t *inline_response_401) {
    if(NULL == inline_response_401){
        return ;
    }
    listEntry_t *listEntry;
    if (inline_response_401->code) {
        free(inline_response_401->code);
        inline_response_401->code = NULL;
    }
    if (inline_response_401->message) {
        free(inline_response_401->message);
        inline_response_401->message = NULL;
    }
    free(inline_response_401);
}

cJSON *inline_response_401_convertToJSON(inline_response_401_t *inline_response_401) {
    cJSON *item = cJSON_CreateObject();

    // inline_response_401->code
    if (!inline_response_401->code) {
        goto fail;
    }
    
    if(cJSON_AddStringToObject(item, "code", inline_response_401->code) == NULL) {
    goto fail; //String
    }


    // inline_response_401->message
    if (!inline_response_401->message) {
        goto fail;
    }
    
    if(cJSON_AddStringToObject(item, "message", inline_response_401->message) == NULL) {
    goto fail; //String
    }

    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

inline_response_401_t *inline_response_401_parseFromJSON(cJSON *inline_response_401JSON){

    inline_response_401_t *inline_response_401_local_var = NULL;

    // inline_response_401->code
    cJSON *code = cJSON_GetObjectItemCaseSensitive(inline_response_401JSON, "code");
    if (!code) {
        goto end;
    }

    
    if(!cJSON_IsString(code))
    {
    goto end; //String
    }

    // inline_response_401->message
    cJSON *message = cJSON_GetObjectItemCaseSensitive(inline_response_401JSON, "message");
    if (!message) {
        goto end;
    }

    
    if(!cJSON_IsString(message))
    {
    goto end; //String
    }


    inline_response_401_local_var = inline_response_401_create (
        strdup(code->valuestring),
        strdup(message->valuestring)
        );

    return inline_response_401_local_var;
end:
    return NULL;

}
