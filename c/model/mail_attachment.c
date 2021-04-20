#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "mail_attachment.h"



mail_attachment_t *mail_attachment_create(
    char *filename,
    binary_t* data
    ) {
    mail_attachment_t *mail_attachment_local_var = malloc(sizeof(mail_attachment_t));
    if (!mail_attachment_local_var) {
        return NULL;
    }
    mail_attachment_local_var->filename = filename;
    mail_attachment_local_var->data = data;

    return mail_attachment_local_var;
}


void mail_attachment_free(mail_attachment_t *mail_attachment) {
    if(NULL == mail_attachment){
        return ;
    }
    listEntry_t *listEntry;
    if (mail_attachment->filename) {
        free(mail_attachment->filename);
        mail_attachment->filename = NULL;
    }
    if (mail_attachment->data) {
        free(mail_attachment->data->data);
        mail_attachment->data = NULL;
    }
    free(mail_attachment);
}

cJSON *mail_attachment_convertToJSON(mail_attachment_t *mail_attachment) {
    cJSON *item = cJSON_CreateObject();

    // mail_attachment->filename
    if(mail_attachment->filename) { 
    if(cJSON_AddStringToObject(item, "filename", mail_attachment->filename) == NULL) {
    goto fail; //String
    }
     } 


    // mail_attachment->data
    if (!mail_attachment->data) {
        goto fail;
    }
    
    char* encoded_str_data = base64encode(mail_attachment->data->data,mail_attachment->data->len);
    if(cJSON_AddStringToObject(item, "data", encoded_str_data) == NULL) {
    goto fail; //Binary
    }
    free (encoded_str_data);

    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

mail_attachment_t *mail_attachment_parseFromJSON(cJSON *mail_attachmentJSON){

    mail_attachment_t *mail_attachment_local_var = NULL;

    // mail_attachment->filename
    cJSON *filename = cJSON_GetObjectItemCaseSensitive(mail_attachmentJSON, "filename");
    if (filename) { 
    if(!cJSON_IsString(filename))
    {
    goto end; //String
    }
    }

    // mail_attachment->data
    cJSON *data = cJSON_GetObjectItemCaseSensitive(mail_attachmentJSON, "data");
    if (!data) {
        goto end;
    }

    binary_t* decoded_str_data = malloc(sizeof(struct binary_t));
    
    if(!cJSON_IsString(data))
    {
    goto end; //Binary
    }
    decoded_str_data->data = base64decode(data->valuestring, strlen(data->valuestring), &decoded_str_data->len);
    if (!decoded_str_data->data) {
        goto end;
    }


    mail_attachment_local_var = mail_attachment_create (
        filename ? strdup(filename->valuestring) : NULL,
        decoded_str_data
        );

    return mail_attachment_local_var;
end:
    return NULL;

}
