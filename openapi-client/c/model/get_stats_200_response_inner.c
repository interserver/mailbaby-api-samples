#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "get_stats_200_response_inner.h"



static get_stats_200_response_inner_t *get_stats_200_response_inner_create_internal(
    int id,
    char *status,
    char *username,
    char *password,
    char *comment
    ) {
    get_stats_200_response_inner_t *get_stats_200_response_inner_local_var = malloc(sizeof(get_stats_200_response_inner_t));
    if (!get_stats_200_response_inner_local_var) {
        return NULL;
    }
    get_stats_200_response_inner_local_var->id = id;
    get_stats_200_response_inner_local_var->status = status;
    get_stats_200_response_inner_local_var->username = username;
    get_stats_200_response_inner_local_var->password = password;
    get_stats_200_response_inner_local_var->comment = comment;

    get_stats_200_response_inner_local_var->_library_owned = 1;
    return get_stats_200_response_inner_local_var;
}

__attribute__((deprecated)) get_stats_200_response_inner_t *get_stats_200_response_inner_create(
    int id,
    char *status,
    char *username,
    char *password,
    char *comment
    ) {
    return get_stats_200_response_inner_create_internal (
        id,
        status,
        username,
        password,
        comment
        );
}

void get_stats_200_response_inner_free(get_stats_200_response_inner_t *get_stats_200_response_inner) {
    if(NULL == get_stats_200_response_inner){
        return ;
    }
    if(get_stats_200_response_inner->_library_owned != 1){
        fprintf(stderr, "WARNING: %s() does NOT free objects allocated by the user\n", "get_stats_200_response_inner_free");
        return ;
    }
    listEntry_t *listEntry;
    if (get_stats_200_response_inner->status) {
        free(get_stats_200_response_inner->status);
        get_stats_200_response_inner->status = NULL;
    }
    if (get_stats_200_response_inner->username) {
        free(get_stats_200_response_inner->username);
        get_stats_200_response_inner->username = NULL;
    }
    if (get_stats_200_response_inner->password) {
        free(get_stats_200_response_inner->password);
        get_stats_200_response_inner->password = NULL;
    }
    if (get_stats_200_response_inner->comment) {
        free(get_stats_200_response_inner->comment);
        get_stats_200_response_inner->comment = NULL;
    }
    free(get_stats_200_response_inner);
}

cJSON *get_stats_200_response_inner_convertToJSON(get_stats_200_response_inner_t *get_stats_200_response_inner) {
    cJSON *item = cJSON_CreateObject();

    // get_stats_200_response_inner->id
    if (!get_stats_200_response_inner->id) {
        goto fail;
    }
    if(cJSON_AddNumberToObject(item, "id", get_stats_200_response_inner->id) == NULL) {
    goto fail; //Numeric
    }


    // get_stats_200_response_inner->status
    if (!get_stats_200_response_inner->status) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "status", get_stats_200_response_inner->status) == NULL) {
    goto fail; //String
    }


    // get_stats_200_response_inner->username
    if (!get_stats_200_response_inner->username) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "username", get_stats_200_response_inner->username) == NULL) {
    goto fail; //String
    }


    // get_stats_200_response_inner->password
    if(get_stats_200_response_inner->password) {
    if(cJSON_AddStringToObject(item, "password", get_stats_200_response_inner->password) == NULL) {
    goto fail; //String
    }
    }


    // get_stats_200_response_inner->comment
    if(get_stats_200_response_inner->comment) {
    if(cJSON_AddStringToObject(item, "comment", get_stats_200_response_inner->comment) == NULL) {
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

get_stats_200_response_inner_t *get_stats_200_response_inner_parseFromJSON(cJSON *get_stats_200_response_innerJSON){

    get_stats_200_response_inner_t *get_stats_200_response_inner_local_var = NULL;

    // get_stats_200_response_inner->id
    cJSON *id = cJSON_GetObjectItemCaseSensitive(get_stats_200_response_innerJSON, "id");
    if (cJSON_IsNull(id)) {
        id = NULL;
    }
    if (!id) {
        goto end;
    }

    
    if(!cJSON_IsNumber(id))
    {
    goto end; //Numeric
    }

    // get_stats_200_response_inner->status
    cJSON *status = cJSON_GetObjectItemCaseSensitive(get_stats_200_response_innerJSON, "status");
    if (cJSON_IsNull(status)) {
        status = NULL;
    }
    if (!status) {
        goto end;
    }

    
    if(!cJSON_IsString(status))
    {
    goto end; //String
    }

    // get_stats_200_response_inner->username
    cJSON *username = cJSON_GetObjectItemCaseSensitive(get_stats_200_response_innerJSON, "username");
    if (cJSON_IsNull(username)) {
        username = NULL;
    }
    if (!username) {
        goto end;
    }

    
    if(!cJSON_IsString(username))
    {
    goto end; //String
    }

    // get_stats_200_response_inner->password
    cJSON *password = cJSON_GetObjectItemCaseSensitive(get_stats_200_response_innerJSON, "password");
    if (cJSON_IsNull(password)) {
        password = NULL;
    }
    if (password) { 
    if(!cJSON_IsString(password) && !cJSON_IsNull(password))
    {
    goto end; //String
    }
    }

    // get_stats_200_response_inner->comment
    cJSON *comment = cJSON_GetObjectItemCaseSensitive(get_stats_200_response_innerJSON, "comment");
    if (cJSON_IsNull(comment)) {
        comment = NULL;
    }
    if (comment) { 
    if(!cJSON_IsString(comment) && !cJSON_IsNull(comment))
    {
    goto end; //String
    }
    }


    get_stats_200_response_inner_local_var = get_stats_200_response_inner_create_internal (
        id->valuedouble,
        strdup(status->valuestring),
        strdup(username->valuestring),
        password && !cJSON_IsNull(password) ? strdup(password->valuestring) : NULL,
        comment && !cJSON_IsNull(comment) ? strdup(comment->valuestring) : NULL
        );

    return get_stats_200_response_inner_local_var;
end:
    return NULL;

}
