#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "mail_order_detail.h"


char* mail_order_detail_status_ToString(mailbaby_email_delivery_and_management_service_api_mail_order_detail_STATUS_e status) {
    char* statusArray[] =  { "NULL", "active", "canceled" };
    return statusArray[status];
}

mailbaby_email_delivery_and_management_service_api_mail_order_detail_STATUS_e mail_order_detail_status_FromString(char* status){
    int stringToReturn = 0;
    char *statusArray[] =  { "NULL", "active", "canceled" };
    size_t sizeofArray = sizeof(statusArray) / sizeof(statusArray[0]);
    while(stringToReturn < sizeofArray) {
        if(strcmp(status, statusArray[stringToReturn]) == 0) {
            return stringToReturn;
        }
        stringToReturn++;
    }
    return 0;
}

static mail_order_detail_t *mail_order_detail_create_internal(
    int *id,
    mailbaby_email_delivery_and_management_service_api_mail_order_detail_STATUS_e status,
    char *username,
    char *password,
    char *comment
    ) {
    mail_order_detail_t *mail_order_detail_local_var = malloc(sizeof(mail_order_detail_t));
    if (!mail_order_detail_local_var) {
        return NULL;
    }
    memset(mail_order_detail_local_var, 0, sizeof(mail_order_detail_t));
    mail_order_detail_local_var->_library_owned = 1;
    mail_order_detail_local_var->id = id;
    mail_order_detail_local_var->status = status;
    mail_order_detail_local_var->username = username;
    mail_order_detail_local_var->password = password;
    mail_order_detail_local_var->comment = comment;
    return mail_order_detail_local_var;
}

__attribute__((deprecated)) mail_order_detail_t *mail_order_detail_create(
    int *id,
    mailbaby_email_delivery_and_management_service_api_mail_order_detail_STATUS_e status,
    char *username,
    char *password,
    char *comment
    ) {
    int *id_copy = NULL;
    if (id) {
        id_copy = malloc(sizeof(int));
        if (id_copy) *id_copy = *id;
    }
    mail_order_detail_t *result = mail_order_detail_create_internal (
        id_copy,
        status,
        username,
        password,
        comment
        );
    if (!result) {
        free(id_copy);
    }
    return result;
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
    if (mail_order_detail->id) {
        free(mail_order_detail->id);
        mail_order_detail->id = NULL;
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
    if(cJSON_AddNumberToObject(item, "id", *mail_order_detail->id) == NULL) {
    goto fail; //Numeric
    }


    // mail_order_detail->status
    if (mailbaby_email_delivery_and_management_service_api_mail_order_detail_STATUS_NULL == mail_order_detail->status) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "status", mail_order_detail_status_ToString(mail_order_detail->status)) == NULL)
    {
    goto fail; //Enum
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

    // define the local variable for mail_order_detail->id
    int *id_local_var = NULL;

    char *username_local_str = NULL;

    char *password_local_str = NULL;

    char *comment_local_str = NULL;

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
    id_local_var = malloc(sizeof(int));
    if(!id_local_var)
    {
        goto end;
    }
    *id_local_var = id->valuedouble;

    // mail_order_detail->status
    cJSON *status = cJSON_GetObjectItemCaseSensitive(mail_order_detailJSON, "status");
    if (cJSON_IsNull(status)) {
        status = NULL;
    }
    if (!status) {
        goto end;
    }

    mailbaby_email_delivery_and_management_service_api_mail_order_detail_STATUS_e statusVariable;
    
    if(!cJSON_IsString(status))
    {
    goto end; //Enum
    }
    statusVariable = mail_order_detail_status_FromString(status->valuestring);

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


    if (username && !cJSON_IsNull(username)) username_local_str = strdup(username->valuestring);
    if (password && !cJSON_IsNull(password)) password_local_str = strdup(password->valuestring);
    if (comment && !cJSON_IsNull(comment)) comment_local_str = strdup(comment->valuestring);

    mail_order_detail_local_var = mail_order_detail_create_internal (
        id_local_var,
        statusVariable,
        username_local_str,
        password_local_str,
        comment_local_str
        );

    if (!mail_order_detail_local_var) {
        goto end;
    }

    return mail_order_detail_local_var;
end:
    if (id_local_var) {
        free(id_local_var);
        id_local_var = NULL;
    }
    if (username_local_str) {
        free(username_local_str);
        username_local_str = NULL;
    }
    if (password_local_str) {
        free(password_local_str);
        password_local_str = NULL;
    }
    if (comment_local_str) {
        free(comment_local_str);
        comment_local_str = NULL;
    }
    return NULL;

}
