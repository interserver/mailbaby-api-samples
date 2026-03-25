#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "send_mail_raw.h"



static send_mail_raw_t *send_mail_raw_create_internal(
    char *raw_email,
    long *id
    ) {
    send_mail_raw_t *send_mail_raw_local_var = malloc(sizeof(send_mail_raw_t));
    if (!send_mail_raw_local_var) {
        return NULL;
    }
    memset(send_mail_raw_local_var, 0, sizeof(send_mail_raw_t));
    send_mail_raw_local_var->_library_owned = 1;
    send_mail_raw_local_var->raw_email = raw_email;
    send_mail_raw_local_var->id = id;
    return send_mail_raw_local_var;
}

__attribute__((deprecated)) send_mail_raw_t *send_mail_raw_create(
    char *raw_email,
    long *id
    ) {
    long *id_copy = NULL;
    if (id) {
        id_copy = malloc(sizeof(long));
        if (id_copy) *id_copy = *id;
    }
    send_mail_raw_t *result = send_mail_raw_create_internal (
        raw_email,
        id_copy
        );
    if (!result) {
        free(id_copy);
    }
    return result;
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
    if (send_mail_raw->id) {
        free(send_mail_raw->id);
        send_mail_raw->id = NULL;
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
    if(cJSON_AddNumberToObject(item, "id", *send_mail_raw->id) == NULL) {
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

    char *raw_email_local_str = NULL;

    // define the local variable for send_mail_raw->id
    long *id_local_var = NULL;

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
    id_local_var = malloc(sizeof(long));
    if(!id_local_var)
    {
        goto end;
    }
    *id_local_var = id->valuedouble;
    }


    if (raw_email && !cJSON_IsNull(raw_email)) raw_email_local_str = strdup(raw_email->valuestring);

    send_mail_raw_local_var = send_mail_raw_create_internal (
        raw_email_local_str,
        id_local_var
        );

    if (!send_mail_raw_local_var) {
        goto end;
    }

    return send_mail_raw_local_var;
end:
    if (raw_email_local_str) {
        free(raw_email_local_str);
        raw_email_local_str = NULL;
    }
    if (id_local_var) {
        free(id_local_var);
        id_local_var = NULL;
    }
    return NULL;

}
