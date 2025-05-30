#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "error_message.h"



static error_message_t *error_message_create_internal(
    int code,
    char *message
    ) {
    error_message_t *error_message_local_var = malloc(sizeof(error_message_t));
    if (!error_message_local_var) {
        return NULL;
    }
    error_message_local_var->code = code;
    error_message_local_var->message = message;

    error_message_local_var->_library_owned = 1;
    return error_message_local_var;
}

__attribute__((deprecated)) error_message_t *error_message_create(
    int code,
    char *message
    ) {
    return error_message_create_internal (
        code,
        message
        );
}

void error_message_free(error_message_t *error_message) {
    if(NULL == error_message){
        return ;
    }
    if(error_message->_library_owned != 1){
        fprintf(stderr, "WARNING: %s() does NOT free objects allocated by the user\n", "error_message_free");
        return ;
    }
    listEntry_t *listEntry;
    if (error_message->message) {
        free(error_message->message);
        error_message->message = NULL;
    }
    free(error_message);
}

cJSON *error_message_convertToJSON(error_message_t *error_message) {
    cJSON *item = cJSON_CreateObject();

    // error_message->code
    if (!error_message->code) {
        goto fail;
    }
    if(cJSON_AddNumberToObject(item, "code", error_message->code) == NULL) {
    goto fail; //Numeric
    }


    // error_message->message
    if (!error_message->message) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "message", error_message->message) == NULL) {
    goto fail; //String
    }

    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

error_message_t *error_message_parseFromJSON(cJSON *error_messageJSON){

    error_message_t *error_message_local_var = NULL;

    // error_message->code
    cJSON *code = cJSON_GetObjectItemCaseSensitive(error_messageJSON, "code");
    if (cJSON_IsNull(code)) {
        code = NULL;
    }
    if (!code) {
        goto end;
    }

    
    if(!cJSON_IsNumber(code))
    {
    goto end; //Numeric
    }

    // error_message->message
    cJSON *message = cJSON_GetObjectItemCaseSensitive(error_messageJSON, "message");
    if (cJSON_IsNull(message)) {
        message = NULL;
    }
    if (!message) {
        goto end;
    }

    
    if(!cJSON_IsString(message))
    {
    goto end; //String
    }


    error_message_local_var = error_message_create_internal (
        code->valuedouble,
        strdup(message->valuestring)
        );

    return error_message_local_var;
end:
    return NULL;

}
