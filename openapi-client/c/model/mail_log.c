#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "mail_log.h"



mail_log_t *mail_log_create(
    long id
    ) {
    mail_log_t *mail_log_local_var = malloc(sizeof(mail_log_t));
    if (!mail_log_local_var) {
        return NULL;
    }
    mail_log_local_var->id = id;

    return mail_log_local_var;
}


void mail_log_free(mail_log_t *mail_log) {
    if(NULL == mail_log){
        return ;
    }
    listEntry_t *listEntry;
    free(mail_log);
}

cJSON *mail_log_convertToJSON(mail_log_t *mail_log) {
    cJSON *item = cJSON_CreateObject();

    // mail_log->id
    if(mail_log->id) { 
    if(cJSON_AddNumberToObject(item, "id", mail_log->id) == NULL) {
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

mail_log_t *mail_log_parseFromJSON(cJSON *mail_logJSON){

    mail_log_t *mail_log_local_var = NULL;

    // mail_log->id
    cJSON *id = cJSON_GetObjectItemCaseSensitive(mail_logJSON, "id");
    if (id) { 
    if(!cJSON_IsNumber(id))
    {
    goto end; //Numeric
    }
    }


    mail_log_local_var = mail_log_create (
        id ? id->valuedouble : 0
        );

    return mail_log_local_var;
end:
    return NULL;

}
