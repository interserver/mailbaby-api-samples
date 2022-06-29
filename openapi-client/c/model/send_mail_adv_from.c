#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "send_mail_adv_from.h"



send_mail_adv_from_t *send_mail_adv_from_create(
    char *email,
    char *name
    ) {
    send_mail_adv_from_t *send_mail_adv_from_local_var = malloc(sizeof(send_mail_adv_from_t));
    if (!send_mail_adv_from_local_var) {
        return NULL;
    }
    send_mail_adv_from_local_var->email = email;
    send_mail_adv_from_local_var->name = name;

    return send_mail_adv_from_local_var;
}


void send_mail_adv_from_free(send_mail_adv_from_t *send_mail_adv_from) {
    if(NULL == send_mail_adv_from){
        return ;
    }
    listEntry_t *listEntry;
    if (send_mail_adv_from->email) {
        free(send_mail_adv_from->email);
        send_mail_adv_from->email = NULL;
    }
    if (send_mail_adv_from->name) {
        free(send_mail_adv_from->name);
        send_mail_adv_from->name = NULL;
    }
    free(send_mail_adv_from);
}

cJSON *send_mail_adv_from_convertToJSON(send_mail_adv_from_t *send_mail_adv_from) {
    cJSON *item = cJSON_CreateObject();

    // send_mail_adv_from->email
    if (!send_mail_adv_from->email) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "email", send_mail_adv_from->email) == NULL) {
    goto fail; //String
    }


    // send_mail_adv_from->name
    if(send_mail_adv_from->name) {
    if(cJSON_AddStringToObject(item, "name", send_mail_adv_from->name) == NULL) {
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

send_mail_adv_from_t *send_mail_adv_from_parseFromJSON(cJSON *send_mail_adv_fromJSON){

    send_mail_adv_from_t *send_mail_adv_from_local_var = NULL;

    // send_mail_adv_from->email
    cJSON *email = cJSON_GetObjectItemCaseSensitive(send_mail_adv_fromJSON, "email");
    if (!email) {
        goto end;
    }

    
    if(!cJSON_IsString(email))
    {
    goto end; //String
    }

    // send_mail_adv_from->name
    cJSON *name = cJSON_GetObjectItemCaseSensitive(send_mail_adv_fromJSON, "name");
    if (name) { 
    if(!cJSON_IsString(name))
    {
    goto end; //String
    }
    }


    send_mail_adv_from_local_var = send_mail_adv_from_create (
        strdup(email->valuestring),
        name ? strdup(name->valuestring) : NULL
        );

    return send_mail_adv_from_local_var;
end:
    return NULL;

}
