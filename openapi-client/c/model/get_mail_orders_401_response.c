#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "get_mail_orders_401_response.h"



get_mail_orders_401_response_t *get_mail_orders_401_response_create(
    char *code,
    char *message
    ) {
    get_mail_orders_401_response_t *get_mail_orders_401_response_local_var = malloc(sizeof(get_mail_orders_401_response_t));
    if (!get_mail_orders_401_response_local_var) {
        return NULL;
    }
    get_mail_orders_401_response_local_var->code = code;
    get_mail_orders_401_response_local_var->message = message;

    return get_mail_orders_401_response_local_var;
}


void get_mail_orders_401_response_free(get_mail_orders_401_response_t *get_mail_orders_401_response) {
    if(NULL == get_mail_orders_401_response){
        return ;
    }
    listEntry_t *listEntry;
    if (get_mail_orders_401_response->code) {
        free(get_mail_orders_401_response->code);
        get_mail_orders_401_response->code = NULL;
    }
    if (get_mail_orders_401_response->message) {
        free(get_mail_orders_401_response->message);
        get_mail_orders_401_response->message = NULL;
    }
    free(get_mail_orders_401_response);
}

cJSON *get_mail_orders_401_response_convertToJSON(get_mail_orders_401_response_t *get_mail_orders_401_response) {
    cJSON *item = cJSON_CreateObject();

    // get_mail_orders_401_response->code
    if (!get_mail_orders_401_response->code) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "code", get_mail_orders_401_response->code) == NULL) {
    goto fail; //String
    }


    // get_mail_orders_401_response->message
    if (!get_mail_orders_401_response->message) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "message", get_mail_orders_401_response->message) == NULL) {
    goto fail; //String
    }

    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

get_mail_orders_401_response_t *get_mail_orders_401_response_parseFromJSON(cJSON *get_mail_orders_401_responseJSON){

    get_mail_orders_401_response_t *get_mail_orders_401_response_local_var = NULL;

    // get_mail_orders_401_response->code
    cJSON *code = cJSON_GetObjectItemCaseSensitive(get_mail_orders_401_responseJSON, "code");
    if (!code) {
        goto end;
    }

    
    if(!cJSON_IsString(code))
    {
    goto end; //String
    }

    // get_mail_orders_401_response->message
    cJSON *message = cJSON_GetObjectItemCaseSensitive(get_mail_orders_401_responseJSON, "message");
    if (!message) {
        goto end;
    }

    
    if(!cJSON_IsString(message))
    {
    goto end; //String
    }


    get_mail_orders_401_response_local_var = get_mail_orders_401_response_create (
        strdup(code->valuestring),
        strdup(message->valuestring)
        );

    return get_mail_orders_401_response_local_var;
end:
    return NULL;

}
