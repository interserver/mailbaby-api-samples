#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "mail_order_detail.h"



static mail_order_detail_t *mail_order_detail_create_internal(
    int id,
    char *status,
    char *username,
    char *password,
    char *comment
    ) {
    mail_order_detail_t *mail_order_detail_local_var = malloc(sizeof(mail_order_detail_t));
    if (!mail_order_detail_local_var) {
        return NULL;
    }
    mail_order_detail_local_var->id = id;
    mail_order_detail_local_var->status = status;
    mail_order_detail_local_var->username = username;
    mail_order_detail_local_var->password = password;
    mail_order_detail_local_var->comment = comment;

    mail_order_detail_local_var->_library_owned = 1;
    return mail_order_detail_local_var;
}

__attribute__((deprecated)) mail_order_detail_t *mail_order_detail_create(
    int id,
    char *status,
    char *username,
    char *password,
    char *comment
    ) {
    return mail_order_detail_create_internal (
        id,
        status,
        username,
        password,
        comment
        );
}

void mail_order_detail_free(mail_order_detail_t *mail_order_detail) {
    if(NULL == mail_order_detail){
        return ;
    }
    if(mail_order_detail->_library_owned != 1){
        fprintf(stderr, "WARNING: %s() does NOT free objects allocated by the user\n", "mail_order_detail_free");
        return ;
    }
    listEntry_t *listEntry;
    if (mail_order_detail->status) {
        free(mail_order_detail->status);
        mail_order_detail->status = NULL;
    }
    if (mail_order_detail->username) {
        free(mail_order_detail->username);
        mail_order_detail->username = NULL;
    }
    if (mail_order_detail->password) {
        free(mail_order_detail->password);
        mail_order_detail->password = NULL;
    }
    if (mail_order_detail->comment) {
        free(mail_order_detail->comment);
        mail_order_detail->comment = NULL;
    }
    free(mail_order_detail);
}

cJSON *mail_order_detail_convertToJSON(mail_order_detail_t *mail_order_detail) {
    cJSON *item = cJSON_CreateObject();

    // mail_order_detail->id
    if (!mail_order_detail->id) {
        goto fail;
    }
    if(cJSON_AddNumberToObject(item, "id", mail_order_detail->id) == NULL) {
    goto fail; //Numeric
    }


    // mail_order_detail->status
    if (!mail_order_detail->status) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "status", mail_order_detail->status) == NULL) {
    goto fail; //String
    }


    // mail_order_detail->username
    if (!mail_order_detail->username) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "username", mail_order_detail->username) == NULL) {
    goto fail; //String
    }


    // mail_order_detail->password
    if (!mail_order_detail->password) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "password", mail_order_detail->password) == NULL) {
    goto fail; //String
    }


    // mail_order_detail->comment
    if(mail_order_detail->comment) {
    if(cJSON_AddStringToObject(item, "comment", mail_order_detail->comment) == NULL) {
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

mail_order_detail_t *mail_order_detail_parseFromJSON(cJSON *mail_order_detailJSON){

    mail_order_detail_t *mail_order_detail_local_var = NULL;

    // mail_order_detail->id
    cJSON *id = cJSON_GetObjectItemCaseSensitive(mail_order_detailJSON, "id");
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

    // mail_order_detail->status
    cJSON *status = cJSON_GetObjectItemCaseSensitive(mail_order_detailJSON, "status");
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

    // mail_order_detail->username
    cJSON *username = cJSON_GetObjectItemCaseSensitive(mail_order_detailJSON, "username");
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

    // mail_order_detail->password
    cJSON *password = cJSON_GetObjectItemCaseSensitive(mail_order_detailJSON, "password");
    if (cJSON_IsNull(password)) {
        password = NULL;
    }
    if (!password) {
        goto end;
    }

    
    if(!cJSON_IsString(password))
    {
    goto end; //String
    }

    // mail_order_detail->comment
    cJSON *comment = cJSON_GetObjectItemCaseSensitive(mail_order_detailJSON, "comment");
    if (cJSON_IsNull(comment)) {
        comment = NULL;
    }
    if (comment) { 
    if(!cJSON_IsString(comment) && !cJSON_IsNull(comment))
    {
    goto end; //String
    }
    }


    mail_order_detail_local_var = mail_order_detail_create_internal (
        id->valuedouble,
        strdup(status->valuestring),
        strdup(username->valuestring),
        strdup(password->valuestring),
        comment && !cJSON_IsNull(comment) ? strdup(comment->valuestring) : NULL
        );

    return mail_order_detail_local_var;
end:
    return NULL;

}
