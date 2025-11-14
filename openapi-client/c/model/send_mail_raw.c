#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "send_mail_raw.h"



static send_mail_raw_t *send_mail_raw_create_internal(
    char *raw_email,
    int id
    ) {
    send_mail_raw_t *send_mail_raw_local_var = malloc(sizeof(send_mail_raw_t));
    if (!send_mail_raw_local_var) {
        return NULL;
    }
    send_mail_raw_local_var->raw_email = raw_email;
    send_mail_raw_local_var->id = id;

    send_mail_raw_local_var->_library_owned = 1;
    return send_mail_raw_local_var;
}

__attribute__((deprecated)) send_mail_raw_t *send_mail_raw_create(
    char *raw_email,
    int id
    ) {
    return send_mail_raw_create_internal (
        raw_email,
        id
        );
}

void send_mail_raw_free(send_mail_raw_t *send_mail_raw) {
    if(NULL == send_mail_raw){
        return ;
    }
    if(send_mail_raw->_library_owned != 1){
        fprintf(stderr, "WARNING: %s() does NOT free objects allocated by the user\n", "send_mail_raw_free");
        return ;
    }
    listEntry_t *listEntry;
    if (send_mail_raw->raw_email) {
        free(send_mail_raw->raw_email);
        send_mail_raw->raw_email = NULL;
    }
    free(send_mail_raw);
}

cJSON *send_mail_raw_convertToJSON(send_mail_raw_t *send_mail_raw) {
    cJSON *item = cJSON_CreateObject();

    // send_mail_raw->raw_email
    if (!send_mail_raw->raw_email) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "raw_email", send_mail_raw->raw_email) == NULL) {
    goto fail; //String
    }


    // send_mail_raw->id
    if(send_mail_raw->id) {
    if(cJSON_AddNumberToObject(item, "id", send_mail_raw->id) == NULL) {
    goto fail; //Numeric
    }
    }

    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

send_mail_raw_t *send_mail_raw_parseFromJSON(cJSON *send_mail_rawJSON){

    send_mail_raw_t *send_mail_raw_local_var = NULL;

    // send_mail_raw->raw_email
    cJSON *raw_email = cJSON_GetObjectItemCaseSensitive(send_mail_rawJSON, "raw_email");
    if (cJSON_IsNull(raw_email)) {
        raw_email = NULL;
    }
    if (!raw_email) {
        goto end;
    }

    
    if(!cJSON_IsString(raw_email))
    {
    goto end; //String
    }

    // send_mail_raw->id
    cJSON *id = cJSON_GetObjectItemCaseSensitive(send_mail_rawJSON, "id");
    if (cJSON_IsNull(id)) {
        id = NULL;
    }
    if (id) { 
    if(!cJSON_IsNumber(id))
    {
    goto end; //Numeric
    }
    }


    send_mail_raw_local_var = send_mail_raw_create_internal (
        strdup(raw_email->valuestring),
        id ? id->valuedouble : 0
        );

    return send_mail_raw_local_var;
end:
    return NULL;

}
