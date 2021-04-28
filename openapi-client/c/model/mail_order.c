#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "mail_order.h"



mail_order_t *mail_order_create(
    int id,
    char *status,
    char *username,
    char *password,
    char *comment
    ) {
    mail_order_t *mail_order_local_var = malloc(sizeof(mail_order_t));
    if (!mail_order_local_var) {
        return NULL;
    }
    mail_order_local_var->id = id;
    mail_order_local_var->status = status;
    mail_order_local_var->username = username;
    mail_order_local_var->password = password;
    mail_order_local_var->comment = comment;

    return mail_order_local_var;
}


void mail_order_free(mail_order_t *mail_order) {
    if(NULL == mail_order){
        return ;
    }
    listEntry_t *listEntry;
    if (mail_order->status) {
        free(mail_order->status);
        mail_order->status = NULL;
    }
    if (mail_order->username) {
        free(mail_order->username);
        mail_order->username = NULL;
    }
    if (mail_order->password) {
        free(mail_order->password);
        mail_order->password = NULL;
    }
    if (mail_order->comment) {
        free(mail_order->comment);
        mail_order->comment = NULL;
    }
    free(mail_order);
}

cJSON *mail_order_convertToJSON(mail_order_t *mail_order) {
    cJSON *item = cJSON_CreateObject();

    // mail_order->id
    if (!mail_order->id) {
        goto fail;
    }
    
    if(cJSON_AddNumberToObject(item, "id", mail_order->id) == NULL) {
    goto fail; //Numeric
    }


    // mail_order->status
    if (!mail_order->status) {
        goto fail;
    }
    
    if(cJSON_AddStringToObject(item, "status", mail_order->status) == NULL) {
    goto fail; //String
    }


    // mail_order->username
    if (!mail_order->username) {
        goto fail;
    }
    
    if(cJSON_AddStringToObject(item, "username", mail_order->username) == NULL) {
    goto fail; //String
    }


    // mail_order->password
    if(mail_order->password) { 
    if(cJSON_AddStringToObject(item, "password", mail_order->password) == NULL) {
    goto fail; //String
    }
     } 


    // mail_order->comment
    if(mail_order->comment) { 
    if(cJSON_AddStringToObject(item, "comment", mail_order->comment) == NULL) {
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

mail_order_t *mail_order_parseFromJSON(cJSON *mail_orderJSON){

    mail_order_t *mail_order_local_var = NULL;

    // mail_order->id
    cJSON *id = cJSON_GetObjectItemCaseSensitive(mail_orderJSON, "id");
    if (!id) {
        goto end;
    }

    
    if(!cJSON_IsNumber(id))
    {
    goto end; //Numeric
    }

    // mail_order->status
    cJSON *status = cJSON_GetObjectItemCaseSensitive(mail_orderJSON, "status");
    if (!status) {
        goto end;
    }

    
    if(!cJSON_IsString(status))
    {
    goto end; //String
    }

    // mail_order->username
    cJSON *username = cJSON_GetObjectItemCaseSensitive(mail_orderJSON, "username");
    if (!username) {
        goto end;
    }

    
    if(!cJSON_IsString(username))
    {
    goto end; //String
    }

    // mail_order->password
    cJSON *password = cJSON_GetObjectItemCaseSensitive(mail_orderJSON, "password");
    if (password) { 
    if(!cJSON_IsString(password))
    {
    goto end; //String
    }
    }

    // mail_order->comment
    cJSON *comment = cJSON_GetObjectItemCaseSensitive(mail_orderJSON, "comment");
    if (comment) { 
    if(!cJSON_IsString(comment))
    {
    goto end; //String
    }
    }


    mail_order_local_var = mail_order_create (
        id->valuedouble,
        strdup(status->valuestring),
        strdup(username->valuestring),
        password ? strdup(password->valuestring) : NULL,
        comment ? strdup(comment->valuestring) : NULL
        );

    return mail_order_local_var;
end:
    return NULL;

}
