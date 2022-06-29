#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "send_mail_adv_attachments_inner.h"



send_mail_adv_attachments_inner_t *send_mail_adv_attachments_inner_create(
    binary_t* data,
    char *filename
    ) {
    send_mail_adv_attachments_inner_t *send_mail_adv_attachments_inner_local_var = malloc(sizeof(send_mail_adv_attachments_inner_t));
    if (!send_mail_adv_attachments_inner_local_var) {
        return NULL;
    }
    send_mail_adv_attachments_inner_local_var->data = data;
    send_mail_adv_attachments_inner_local_var->filename = filename;

    return send_mail_adv_attachments_inner_local_var;
}


void send_mail_adv_attachments_inner_free(send_mail_adv_attachments_inner_t *send_mail_adv_attachments_inner) {
    if(NULL == send_mail_adv_attachments_inner){
        return ;
    }
    listEntry_t *listEntry;
    if (send_mail_adv_attachments_inner->data) {
        free(send_mail_adv_attachments_inner->data->data);
        send_mail_adv_attachments_inner->data = NULL;
    }
    if (send_mail_adv_attachments_inner->filename) {
        free(send_mail_adv_attachments_inner->filename);
        send_mail_adv_attachments_inner->filename = NULL;
    }
    free(send_mail_adv_attachments_inner);
}

cJSON *send_mail_adv_attachments_inner_convertToJSON(send_mail_adv_attachments_inner_t *send_mail_adv_attachments_inner) {
    cJSON *item = cJSON_CreateObject();

    // send_mail_adv_attachments_inner->data
    if (!send_mail_adv_attachments_inner->data) {
        goto fail;
    }
    char* encoded_str_data = base64encode(send_mail_adv_attachments_inner->data->data,send_mail_adv_attachments_inner->data->len);
    if(cJSON_AddStringToObject(item, "data", encoded_str_data) == NULL) {
    goto fail; //Binary
    }
    free (encoded_str_data);


    // send_mail_adv_attachments_inner->filename
    if(send_mail_adv_attachments_inner->filename) {
    if(cJSON_AddStringToObject(item, "filename", send_mail_adv_attachments_inner->filename) == NULL) {
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

send_mail_adv_attachments_inner_t *send_mail_adv_attachments_inner_parseFromJSON(cJSON *send_mail_adv_attachments_innerJSON){

    send_mail_adv_attachments_inner_t *send_mail_adv_attachments_inner_local_var = NULL;

    // send_mail_adv_attachments_inner->data
    cJSON *data = cJSON_GetObjectItemCaseSensitive(send_mail_adv_attachments_innerJSON, "data");
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

    // send_mail_adv_attachments_inner->filename
    cJSON *filename = cJSON_GetObjectItemCaseSensitive(send_mail_adv_attachments_innerJSON, "filename");
    if (filename) { 
    if(!cJSON_IsString(filename))
    {
    goto end; //String
    }
    }


    send_mail_adv_attachments_inner_local_var = send_mail_adv_attachments_inner_create (
        decoded_str_data,
        filename ? strdup(filename->valuestring) : NULL
        );

    return send_mail_adv_attachments_inner_local_var;
end:
    return NULL;

}
