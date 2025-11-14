#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "raw_mail.h"



static raw_mail_t *raw_mail_create_internal(
    char *raw_email
    ) {
    raw_mail_t *raw_mail_local_var = malloc(sizeof(raw_mail_t));
    if (!raw_mail_local_var) {
        return NULL;
    }
    raw_mail_local_var->raw_email = raw_email;

    raw_mail_local_var->_library_owned = 1;
    return raw_mail_local_var;
}

__attribute__((deprecated)) raw_mail_t *raw_mail_create(
    char *raw_email
    ) {
    return raw_mail_create_internal (
        raw_email
        );
}

void raw_mail_free(raw_mail_t *raw_mail) {
    if(NULL == raw_mail){
        return ;
    }
    if(raw_mail->_library_owned != 1){
        fprintf(stderr, "WARNING: %s() does NOT free objects allocated by the user\n", "raw_mail_free");
        return ;
    }
    listEntry_t *listEntry;
    if (raw_mail->raw_email) {
        free(raw_mail->raw_email);
        raw_mail->raw_email = NULL;
    }
    free(raw_mail);
}

cJSON *raw_mail_convertToJSON(raw_mail_t *raw_mail) {
    cJSON *item = cJSON_CreateObject();

    // raw_mail->raw_email
    if (!raw_mail->raw_email) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "raw_email", raw_mail->raw_email) == NULL) {
    goto fail; //String
    }

    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

raw_mail_t *raw_mail_parseFromJSON(cJSON *raw_mailJSON){

    raw_mail_t *raw_mail_local_var = NULL;

    // raw_mail->raw_email
    cJSON *raw_email = cJSON_GetObjectItemCaseSensitive(raw_mailJSON, "raw_email");
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


    raw_mail_local_var = raw_mail_create_internal (
        strdup(raw_email->valuestring)
        );

    return raw_mail_local_var;
end:
    return NULL;

}
