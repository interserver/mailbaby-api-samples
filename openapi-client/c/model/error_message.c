#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "error_message.h"



static error_message_t *error_message_create_internal(
    int *code,
    char *message
    ) {
    error_message_t *error_message_local_var = malloc(sizeof(error_message_t));
    if (!error_message_local_var) {
        return NULL;
    }
    memset(error_message_local_var, 0, sizeof(error_message_t));
    error_message_local_var->_library_owned = 1;
    error_message_local_var->code = code;
    error_message_local_var->message = message;
    return error_message_local_var;
}

__attribute__((deprecated)) error_message_t *error_message_create(
    int *code,
    char *message
    ) {
    int *code_copy = NULL;
    if (code) {
        code_copy = malloc(sizeof(int));
        if (code_copy) *code_copy = *code;
    }
    error_message_t *result = error_message_create_internal (
        code_copy,
        message
        );
    if (!result) {
        free(code_copy);
    }
    return result;
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
    if (error_message->code) {
        free(error_message->code);
        error_message->code = NULL;
    }
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
    if(cJSON_AddNumberToObject(item, "code", *error_message->code) == NULL) {
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

    // define the local variable for error_message->code
    int *code_local_var = NULL;

    char *message_local_str = NULL;

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
    code_local_var = malloc(sizeof(int));
    if(!code_local_var)
    {
        goto end;
    }
    *code_local_var = code->valuedouble;

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


    if (message && !cJSON_IsNull(message)) message_local_str = strdup(message->valuestring);

    error_message_local_var = error_message_create_internal (
        code_local_var,
        message_local_str
        );

    if (!error_message_local_var) {
        goto end;
    }

    return error_message_local_var;
end:
    if (code_local_var) {
        free(code_local_var);
        code_local_var = NULL;
    }
    if (message_local_str) {
        free(message_local_str);
        message_local_str = NULL;
    }
    return NULL;

}
