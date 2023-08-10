#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "mail_block_rspamd.h"



mail_block_rspamd_t *mail_block_rspamd_create(
    char *from,
    char *subject
    ) {
    mail_block_rspamd_t *mail_block_rspamd_local_var = malloc(sizeof(mail_block_rspamd_t));
    if (!mail_block_rspamd_local_var) {
        return NULL;
    }
    mail_block_rspamd_local_var->from = from;
    mail_block_rspamd_local_var->subject = subject;

    return mail_block_rspamd_local_var;
}


void mail_block_rspamd_free(mail_block_rspamd_t *mail_block_rspamd) {
    if(NULL == mail_block_rspamd){
        return ;
    }
    listEntry_t *listEntry;
    if (mail_block_rspamd->from) {
        free(mail_block_rspamd->from);
        mail_block_rspamd->from = NULL;
    }
    if (mail_block_rspamd->subject) {
        free(mail_block_rspamd->subject);
        mail_block_rspamd->subject = NULL;
    }
    free(mail_block_rspamd);
}

cJSON *mail_block_rspamd_convertToJSON(mail_block_rspamd_t *mail_block_rspamd) {
    cJSON *item = cJSON_CreateObject();

    // mail_block_rspamd->from
    if (!mail_block_rspamd->from) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "from", mail_block_rspamd->from) == NULL) {
    goto fail; //String
    }


    // mail_block_rspamd->subject
    if (!mail_block_rspamd->subject) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "subject", mail_block_rspamd->subject) == NULL) {
    goto fail; //String
    }

    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

mail_block_rspamd_t *mail_block_rspamd_parseFromJSON(cJSON *mail_block_rspamdJSON){

    mail_block_rspamd_t *mail_block_rspamd_local_var = NULL;

    // mail_block_rspamd->from
    cJSON *from = cJSON_GetObjectItemCaseSensitive(mail_block_rspamdJSON, "from");
    if (!from) {
        goto end;
    }

    
    if(!cJSON_IsString(from))
    {
    goto end; //String
    }

    // mail_block_rspamd->subject
    cJSON *subject = cJSON_GetObjectItemCaseSensitive(mail_block_rspamdJSON, "subject");
    if (!subject) {
        goto end;
    }

    
    if(!cJSON_IsString(subject))
    {
    goto end; //String
    }


    mail_block_rspamd_local_var = mail_block_rspamd_create (
        strdup(from->valuestring),
        strdup(subject->valuestring)
        );

    return mail_block_rspamd_local_var;
end:
    return NULL;

}
