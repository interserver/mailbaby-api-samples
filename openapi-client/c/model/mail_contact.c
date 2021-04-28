#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "mail_contact.h"



mail_contact_t *mail_contact_create(
    char *email,
    char *name
    ) {
    mail_contact_t *mail_contact_local_var = malloc(sizeof(mail_contact_t));
    if (!mail_contact_local_var) {
        return NULL;
    }
    mail_contact_local_var->email = email;
    mail_contact_local_var->name = name;

    return mail_contact_local_var;
}


void mail_contact_free(mail_contact_t *mail_contact) {
    if(NULL == mail_contact){
        return ;
    }
    listEntry_t *listEntry;
    if (mail_contact->email) {
        free(mail_contact->email);
        mail_contact->email = NULL;
    }
    if (mail_contact->name) {
        free(mail_contact->name);
        mail_contact->name = NULL;
    }
    free(mail_contact);
}

cJSON *mail_contact_convertToJSON(mail_contact_t *mail_contact) {
    cJSON *item = cJSON_CreateObject();

    // mail_contact->email
    if (!mail_contact->email) {
        goto fail;
    }
    
    if(cJSON_AddStringToObject(item, "email", mail_contact->email) == NULL) {
    goto fail; //String
    }


    // mail_contact->name
    if(mail_contact->name) { 
    if(cJSON_AddStringToObject(item, "name", mail_contact->name) == NULL) {
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

mail_contact_t *mail_contact_parseFromJSON(cJSON *mail_contactJSON){

    mail_contact_t *mail_contact_local_var = NULL;

    // mail_contact->email
    cJSON *email = cJSON_GetObjectItemCaseSensitive(mail_contactJSON, "email");
    if (!email) {
        goto end;
    }

    
    if(!cJSON_IsString(email))
    {
    goto end; //String
    }

    // mail_contact->name
    cJSON *name = cJSON_GetObjectItemCaseSensitive(mail_contactJSON, "name");
    if (name) { 
    if(!cJSON_IsString(name))
    {
    goto end; //String
    }
    }


    mail_contact_local_var = mail_contact_create (
        strdup(email->valuestring),
        name ? strdup(name->valuestring) : NULL
        );

    return mail_contact_local_var;
end:
    return NULL;

}
