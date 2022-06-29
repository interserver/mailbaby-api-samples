#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "send_mail_adv_to_inner.h"



send_mail_adv_to_inner_t *send_mail_adv_to_inner_create(
    char *email,
    char *name
    ) {
    send_mail_adv_to_inner_t *send_mail_adv_to_inner_local_var = malloc(sizeof(send_mail_adv_to_inner_t));
    if (!send_mail_adv_to_inner_local_var) {
        return NULL;
    }
    send_mail_adv_to_inner_local_var->email = email;
    send_mail_adv_to_inner_local_var->name = name;

    return send_mail_adv_to_inner_local_var;
}


void send_mail_adv_to_inner_free(send_mail_adv_to_inner_t *send_mail_adv_to_inner) {
    if(NULL == send_mail_adv_to_inner){
        return ;
    }
    listEntry_t *listEntry;
    if (send_mail_adv_to_inner->email) {
        free(send_mail_adv_to_inner->email);
        send_mail_adv_to_inner->email = NULL;
    }
    if (send_mail_adv_to_inner->name) {
        free(send_mail_adv_to_inner->name);
        send_mail_adv_to_inner->name = NULL;
    }
    free(send_mail_adv_to_inner);
}

cJSON *send_mail_adv_to_inner_convertToJSON(send_mail_adv_to_inner_t *send_mail_adv_to_inner) {
    cJSON *item = cJSON_CreateObject();

    // send_mail_adv_to_inner->email
    if (!send_mail_adv_to_inner->email) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "email", send_mail_adv_to_inner->email) == NULL) {
    goto fail; //String
    }


    // send_mail_adv_to_inner->name
    if(send_mail_adv_to_inner->name) {
    if(cJSON_AddStringToObject(item, "name", send_mail_adv_to_inner->name) == NULL) {
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

send_mail_adv_to_inner_t *send_mail_adv_to_inner_parseFromJSON(cJSON *send_mail_adv_to_innerJSON){

    send_mail_adv_to_inner_t *send_mail_adv_to_inner_local_var = NULL;

    // send_mail_adv_to_inner->email
    cJSON *email = cJSON_GetObjectItemCaseSensitive(send_mail_adv_to_innerJSON, "email");
    if (!email) {
        goto end;
    }

    
    if(!cJSON_IsString(email))
    {
    goto end; //String
    }

    // send_mail_adv_to_inner->name
    cJSON *name = cJSON_GetObjectItemCaseSensitive(send_mail_adv_to_innerJSON, "name");
    if (name) { 
    if(!cJSON_IsString(name))
    {
    goto end; //String
    }
    }


    send_mail_adv_to_inner_local_var = send_mail_adv_to_inner_create (
        strdup(email->valuestring),
        name ? strdup(name->valuestring) : NULL
        );

    return send_mail_adv_to_inner_local_var;
end:
    return NULL;

}
