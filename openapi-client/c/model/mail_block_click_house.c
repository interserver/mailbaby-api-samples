#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "mail_block_click_house.h"



mail_block_click_house_t *mail_block_click_house_create(
    char *date,
    char *from,
    char *message_id,
    char *subject,
    char *to
    ) {
    mail_block_click_house_t *mail_block_click_house_local_var = malloc(sizeof(mail_block_click_house_t));
    if (!mail_block_click_house_local_var) {
        return NULL;
    }
    mail_block_click_house_local_var->date = date;
    mail_block_click_house_local_var->from = from;
    mail_block_click_house_local_var->message_id = message_id;
    mail_block_click_house_local_var->subject = subject;
    mail_block_click_house_local_var->to = to;

    return mail_block_click_house_local_var;
}


void mail_block_click_house_free(mail_block_click_house_t *mail_block_click_house) {
    if(NULL == mail_block_click_house){
        return ;
    }
    listEntry_t *listEntry;
    if (mail_block_click_house->date) {
        free(mail_block_click_house->date);
        mail_block_click_house->date = NULL;
    }
    if (mail_block_click_house->from) {
        free(mail_block_click_house->from);
        mail_block_click_house->from = NULL;
    }
    if (mail_block_click_house->message_id) {
        free(mail_block_click_house->message_id);
        mail_block_click_house->message_id = NULL;
    }
    if (mail_block_click_house->subject) {
        free(mail_block_click_house->subject);
        mail_block_click_house->subject = NULL;
    }
    if (mail_block_click_house->to) {
        free(mail_block_click_house->to);
        mail_block_click_house->to = NULL;
    }
    free(mail_block_click_house);
}

cJSON *mail_block_click_house_convertToJSON(mail_block_click_house_t *mail_block_click_house) {
    cJSON *item = cJSON_CreateObject();

    // mail_block_click_house->date
    if (!mail_block_click_house->date) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "date", mail_block_click_house->date) == NULL) {
    goto fail; //Date
    }


    // mail_block_click_house->from
    if (!mail_block_click_house->from) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "from", mail_block_click_house->from) == NULL) {
    goto fail; //String
    }


    // mail_block_click_house->message_id
    if (!mail_block_click_house->message_id) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "messageId", mail_block_click_house->message_id) == NULL) {
    goto fail; //String
    }


    // mail_block_click_house->subject
    if (!mail_block_click_house->subject) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "subject", mail_block_click_house->subject) == NULL) {
    goto fail; //String
    }


    // mail_block_click_house->to
    if (!mail_block_click_house->to) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "to", mail_block_click_house->to) == NULL) {
    goto fail; //String
    }

    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

mail_block_click_house_t *mail_block_click_house_parseFromJSON(cJSON *mail_block_click_houseJSON){

    mail_block_click_house_t *mail_block_click_house_local_var = NULL;

    // mail_block_click_house->date
    cJSON *date = cJSON_GetObjectItemCaseSensitive(mail_block_click_houseJSON, "date");
    if (!date) {
        goto end;
    }

    
    if(!cJSON_IsString(date))
    {
    goto end; //Date
    }

    // mail_block_click_house->from
    cJSON *from = cJSON_GetObjectItemCaseSensitive(mail_block_click_houseJSON, "from");
    if (!from) {
        goto end;
    }

    
    if(!cJSON_IsString(from))
    {
    goto end; //String
    }

    // mail_block_click_house->message_id
    cJSON *message_id = cJSON_GetObjectItemCaseSensitive(mail_block_click_houseJSON, "messageId");
    if (!message_id) {
        goto end;
    }

    
    if(!cJSON_IsString(message_id))
    {
    goto end; //String
    }

    // mail_block_click_house->subject
    cJSON *subject = cJSON_GetObjectItemCaseSensitive(mail_block_click_houseJSON, "subject");
    if (!subject) {
        goto end;
    }

    
    if(!cJSON_IsString(subject))
    {
    goto end; //String
    }

    // mail_block_click_house->to
    cJSON *to = cJSON_GetObjectItemCaseSensitive(mail_block_click_houseJSON, "to");
    if (!to) {
        goto end;
    }

    
    if(!cJSON_IsString(to))
    {
    goto end; //String
    }


    mail_block_click_house_local_var = mail_block_click_house_create (
        strdup(date->valuestring),
        strdup(from->valuestring),
        strdup(message_id->valuestring),
        strdup(subject->valuestring),
        strdup(to->valuestring)
        );

    return mail_block_click_house_local_var;
end:
    return NULL;

}
