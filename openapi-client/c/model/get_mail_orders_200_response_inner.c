#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "get_mail_orders_200_response_inner.h"



get_mail_orders_200_response_inner_t *get_mail_orders_200_response_inner_create(
    int id,
    char *status,
    char *username,
    char *password,
    char *comment
    ) {
    get_mail_orders_200_response_inner_t *get_mail_orders_200_response_inner_local_var = malloc(sizeof(get_mail_orders_200_response_inner_t));
    if (!get_mail_orders_200_response_inner_local_var) {
        return NULL;
    }
    get_mail_orders_200_response_inner_local_var->id = id;
    get_mail_orders_200_response_inner_local_var->status = status;
    get_mail_orders_200_response_inner_local_var->username = username;
    get_mail_orders_200_response_inner_local_var->password = password;
    get_mail_orders_200_response_inner_local_var->comment = comment;

    return get_mail_orders_200_response_inner_local_var;
}


void get_mail_orders_200_response_inner_free(get_mail_orders_200_response_inner_t *get_mail_orders_200_response_inner) {
    if(NULL == get_mail_orders_200_response_inner){
        return ;
    }
    listEntry_t *listEntry;
    if (get_mail_orders_200_response_inner->status) {
        free(get_mail_orders_200_response_inner->status);
        get_mail_orders_200_response_inner->status = NULL;
    }
    if (get_mail_orders_200_response_inner->username) {
        free(get_mail_orders_200_response_inner->username);
        get_mail_orders_200_response_inner->username = NULL;
    }
    if (get_mail_orders_200_response_inner->password) {
        free(get_mail_orders_200_response_inner->password);
        get_mail_orders_200_response_inner->password = NULL;
    }
    if (get_mail_orders_200_response_inner->comment) {
        free(get_mail_orders_200_response_inner->comment);
        get_mail_orders_200_response_inner->comment = NULL;
    }
    free(get_mail_orders_200_response_inner);
}

cJSON *get_mail_orders_200_response_inner_convertToJSON(get_mail_orders_200_response_inner_t *get_mail_orders_200_response_inner) {
    cJSON *item = cJSON_CreateObject();

    // get_mail_orders_200_response_inner->id
    if (!get_mail_orders_200_response_inner->id) {
        goto fail;
    }
    if(cJSON_AddNumberToObject(item, "id", get_mail_orders_200_response_inner->id) == NULL) {
    goto fail; //Numeric
    }


    // get_mail_orders_200_response_inner->status
    if (!get_mail_orders_200_response_inner->status) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "status", get_mail_orders_200_response_inner->status) == NULL) {
    goto fail; //String
    }


    // get_mail_orders_200_response_inner->username
    if (!get_mail_orders_200_response_inner->username) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "username", get_mail_orders_200_response_inner->username) == NULL) {
    goto fail; //String
    }


    // get_mail_orders_200_response_inner->password
    if(get_mail_orders_200_response_inner->password) {
    if(cJSON_AddStringToObject(item, "password", get_mail_orders_200_response_inner->password) == NULL) {
    goto fail; //String
    }
    }


    // get_mail_orders_200_response_inner->comment
    if(get_mail_orders_200_response_inner->comment) {
    if(cJSON_AddStringToObject(item, "comment", get_mail_orders_200_response_inner->comment) == NULL) {
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

get_mail_orders_200_response_inner_t *get_mail_orders_200_response_inner_parseFromJSON(cJSON *get_mail_orders_200_response_innerJSON){

    get_mail_orders_200_response_inner_t *get_mail_orders_200_response_inner_local_var = NULL;

    // get_mail_orders_200_response_inner->id
    cJSON *id = cJSON_GetObjectItemCaseSensitive(get_mail_orders_200_response_innerJSON, "id");
    if (!id) {
        goto end;
    }

    
    if(!cJSON_IsNumber(id))
    {
    goto end; //Numeric
    }

    // get_mail_orders_200_response_inner->status
    cJSON *status = cJSON_GetObjectItemCaseSensitive(get_mail_orders_200_response_innerJSON, "status");
    if (!status) {
        goto end;
    }

    
    if(!cJSON_IsString(status))
    {
    goto end; //String
    }

    // get_mail_orders_200_response_inner->username
    cJSON *username = cJSON_GetObjectItemCaseSensitive(get_mail_orders_200_response_innerJSON, "username");
    if (!username) {
        goto end;
    }

    
    if(!cJSON_IsString(username))
    {
    goto end; //String
    }

    // get_mail_orders_200_response_inner->password
    cJSON *password = cJSON_GetObjectItemCaseSensitive(get_mail_orders_200_response_innerJSON, "password");
    if (password) { 
    if(!cJSON_IsString(password))
    {
    goto end; //String
    }
    }

    // get_mail_orders_200_response_inner->comment
    cJSON *comment = cJSON_GetObjectItemCaseSensitive(get_mail_orders_200_response_innerJSON, "comment");
    if (comment) { 
    if(!cJSON_IsString(comment))
    {
    goto end; //String
    }
    }


    get_mail_orders_200_response_inner_local_var = get_mail_orders_200_response_inner_create (
        id->valuedouble,
        strdup(status->valuestring),
        strdup(username->valuestring),
        password ? strdup(password->valuestring) : NULL,
        comment ? strdup(comment->valuestring) : NULL
        );

    return get_mail_orders_200_response_inner_local_var;
end:
    return NULL;

}
