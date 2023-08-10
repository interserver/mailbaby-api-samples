#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "send_mail_adv.h"



send_mail_adv_t *send_mail_adv_create(
    char *subject,
    char *body,
    email_address_name_t *from,
    list_t *to,
    list_t *replyto,
    list_t *cc,
    list_t *bcc,
    list_t *attachments,
    long id
    ) {
    send_mail_adv_t *send_mail_adv_local_var = malloc(sizeof(send_mail_adv_t));
    if (!send_mail_adv_local_var) {
        return NULL;
    }
    send_mail_adv_local_var->subject = subject;
    send_mail_adv_local_var->body = body;
    send_mail_adv_local_var->from = from;
    send_mail_adv_local_var->to = to;
    send_mail_adv_local_var->replyto = replyto;
    send_mail_adv_local_var->cc = cc;
    send_mail_adv_local_var->bcc = bcc;
    send_mail_adv_local_var->attachments = attachments;
    send_mail_adv_local_var->id = id;

    return send_mail_adv_local_var;
}


void send_mail_adv_free(send_mail_adv_t *send_mail_adv) {
    if(NULL == send_mail_adv){
        return ;
    }
    listEntry_t *listEntry;
    if (send_mail_adv->subject) {
        free(send_mail_adv->subject);
        send_mail_adv->subject = NULL;
    }
    if (send_mail_adv->body) {
        free(send_mail_adv->body);
        send_mail_adv->body = NULL;
    }
    if (send_mail_adv->from) {
        email_address_name_free(send_mail_adv->from);
        send_mail_adv->from = NULL;
    }
    if (send_mail_adv->to) {
        list_ForEach(listEntry, send_mail_adv->to) {
            email_address_name_free(listEntry->data);
        }
        list_freeList(send_mail_adv->to);
        send_mail_adv->to = NULL;
    }
    if (send_mail_adv->replyto) {
        list_ForEach(listEntry, send_mail_adv->replyto) {
            email_address_name_free(listEntry->data);
        }
        list_freeList(send_mail_adv->replyto);
        send_mail_adv->replyto = NULL;
    }
    if (send_mail_adv->cc) {
        list_ForEach(listEntry, send_mail_adv->cc) {
            email_address_name_free(listEntry->data);
        }
        list_freeList(send_mail_adv->cc);
        send_mail_adv->cc = NULL;
    }
    if (send_mail_adv->bcc) {
        list_ForEach(listEntry, send_mail_adv->bcc) {
            email_address_name_free(listEntry->data);
        }
        list_freeList(send_mail_adv->bcc);
        send_mail_adv->bcc = NULL;
    }
    if (send_mail_adv->attachments) {
        list_ForEach(listEntry, send_mail_adv->attachments) {
            mail_attachment_free(listEntry->data);
        }
        list_freeList(send_mail_adv->attachments);
        send_mail_adv->attachments = NULL;
    }
    free(send_mail_adv);
}

cJSON *send_mail_adv_convertToJSON(send_mail_adv_t *send_mail_adv) {
    cJSON *item = cJSON_CreateObject();

    // send_mail_adv->subject
    if (!send_mail_adv->subject) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "subject", send_mail_adv->subject) == NULL) {
    goto fail; //String
    }


    // send_mail_adv->body
    if (!send_mail_adv->body) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "body", send_mail_adv->body) == NULL) {
    goto fail; //String
    }


    // send_mail_adv->from
    if (!send_mail_adv->from) {
        goto fail;
    }
    cJSON *from_local_JSON = email_address_name_convertToJSON(send_mail_adv->from);
    if(from_local_JSON == NULL) {
    goto fail; //model
    }
    cJSON_AddItemToObject(item, "from", from_local_JSON);
    if(item->child == NULL) {
    goto fail;
    }


    // send_mail_adv->to
    if (!send_mail_adv->to) {
        goto fail;
    }
    cJSON *to = cJSON_AddArrayToObject(item, "to");
    if(to == NULL) {
    goto fail; //nonprimitive container
    }

    listEntry_t *toListEntry;
    if (send_mail_adv->to) {
    list_ForEach(toListEntry, send_mail_adv->to) {
    cJSON *itemLocal = email_address_name_convertToJSON(toListEntry->data);
    if(itemLocal == NULL) {
    goto fail;
    }
    cJSON_AddItemToArray(to, itemLocal);
    }
    }


    // send_mail_adv->replyto
    if(send_mail_adv->replyto) {
    cJSON *replyto = cJSON_AddArrayToObject(item, "replyto");
    if(replyto == NULL) {
    goto fail; //nonprimitive container
    }

    listEntry_t *replytoListEntry;
    if (send_mail_adv->replyto) {
    list_ForEach(replytoListEntry, send_mail_adv->replyto) {
    cJSON *itemLocal = email_address_name_convertToJSON(replytoListEntry->data);
    if(itemLocal == NULL) {
    goto fail;
    }
    cJSON_AddItemToArray(replyto, itemLocal);
    }
    }
    }


    // send_mail_adv->cc
    if(send_mail_adv->cc) {
    cJSON *cc = cJSON_AddArrayToObject(item, "cc");
    if(cc == NULL) {
    goto fail; //nonprimitive container
    }

    listEntry_t *ccListEntry;
    if (send_mail_adv->cc) {
    list_ForEach(ccListEntry, send_mail_adv->cc) {
    cJSON *itemLocal = email_address_name_convertToJSON(ccListEntry->data);
    if(itemLocal == NULL) {
    goto fail;
    }
    cJSON_AddItemToArray(cc, itemLocal);
    }
    }
    }


    // send_mail_adv->bcc
    if(send_mail_adv->bcc) {
    cJSON *bcc = cJSON_AddArrayToObject(item, "bcc");
    if(bcc == NULL) {
    goto fail; //nonprimitive container
    }

    listEntry_t *bccListEntry;
    if (send_mail_adv->bcc) {
    list_ForEach(bccListEntry, send_mail_adv->bcc) {
    cJSON *itemLocal = email_address_name_convertToJSON(bccListEntry->data);
    if(itemLocal == NULL) {
    goto fail;
    }
    cJSON_AddItemToArray(bcc, itemLocal);
    }
    }
    }


    // send_mail_adv->attachments
    if(send_mail_adv->attachments) {
    cJSON *attachments = cJSON_AddArrayToObject(item, "attachments");
    if(attachments == NULL) {
    goto fail; //nonprimitive container
    }

    listEntry_t *attachmentsListEntry;
    if (send_mail_adv->attachments) {
    list_ForEach(attachmentsListEntry, send_mail_adv->attachments) {
    cJSON *itemLocal = mail_attachment_convertToJSON(attachmentsListEntry->data);
    if(itemLocal == NULL) {
    goto fail;
    }
    cJSON_AddItemToArray(attachments, itemLocal);
    }
    }
    }


    // send_mail_adv->id
    if(send_mail_adv->id) {
    if(cJSON_AddNumberToObject(item, "id", send_mail_adv->id) == NULL) {
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

send_mail_adv_t *send_mail_adv_parseFromJSON(cJSON *send_mail_advJSON){

    send_mail_adv_t *send_mail_adv_local_var = NULL;

    // define the local variable for send_mail_adv->from
    email_address_name_t *from_local_nonprim = NULL;

    // define the local list for send_mail_adv->to
    list_t *toList = NULL;

    // define the local list for send_mail_adv->replyto
    list_t *replytoList = NULL;

    // define the local list for send_mail_adv->cc
    list_t *ccList = NULL;

    // define the local list for send_mail_adv->bcc
    list_t *bccList = NULL;

    // define the local list for send_mail_adv->attachments
    list_t *attachmentsList = NULL;

    // send_mail_adv->subject
    cJSON *subject = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "subject");
    if (!subject) {
        goto end;
    }

    
    if(!cJSON_IsString(subject))
    {
    goto end; //String
    }

    // send_mail_adv->body
    cJSON *body = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "body");
    if (!body) {
        goto end;
    }

    
    if(!cJSON_IsString(body))
    {
    goto end; //String
    }

    // send_mail_adv->from
    cJSON *from = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "from");
    if (!from) {
        goto end;
    }

    
    from_local_nonprim = email_address_name_parseFromJSON(from); //nonprimitive

    // send_mail_adv->to
    cJSON *to = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "to");
    if (!to) {
        goto end;
    }

    
    cJSON *to_local_nonprimitive = NULL;
    if(!cJSON_IsArray(to)){
        goto end; //nonprimitive container
    }

    toList = list_createList();

    cJSON_ArrayForEach(to_local_nonprimitive,to )
    {
        if(!cJSON_IsObject(to_local_nonprimitive)){
            goto end;
        }
        email_address_name_t *toItem = email_address_name_parseFromJSON(to_local_nonprimitive);

        list_addElement(toList, toItem);
    }

    // send_mail_adv->replyto
    cJSON *replyto = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "replyto");
    if (replyto) { 
    cJSON *replyto_local_nonprimitive = NULL;
    if(!cJSON_IsArray(replyto)){
        goto end; //nonprimitive container
    }

    replytoList = list_createList();

    cJSON_ArrayForEach(replyto_local_nonprimitive,replyto )
    {
        if(!cJSON_IsObject(replyto_local_nonprimitive)){
            goto end;
        }
        email_address_name_t *replytoItem = email_address_name_parseFromJSON(replyto_local_nonprimitive);

        list_addElement(replytoList, replytoItem);
    }
    }

    // send_mail_adv->cc
    cJSON *cc = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "cc");
    if (cc) { 
    cJSON *cc_local_nonprimitive = NULL;
    if(!cJSON_IsArray(cc)){
        goto end; //nonprimitive container
    }

    ccList = list_createList();

    cJSON_ArrayForEach(cc_local_nonprimitive,cc )
    {
        if(!cJSON_IsObject(cc_local_nonprimitive)){
            goto end;
        }
        email_address_name_t *ccItem = email_address_name_parseFromJSON(cc_local_nonprimitive);

        list_addElement(ccList, ccItem);
    }
    }

    // send_mail_adv->bcc
    cJSON *bcc = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "bcc");
    if (bcc) { 
    cJSON *bcc_local_nonprimitive = NULL;
    if(!cJSON_IsArray(bcc)){
        goto end; //nonprimitive container
    }

    bccList = list_createList();

    cJSON_ArrayForEach(bcc_local_nonprimitive,bcc )
    {
        if(!cJSON_IsObject(bcc_local_nonprimitive)){
            goto end;
        }
        email_address_name_t *bccItem = email_address_name_parseFromJSON(bcc_local_nonprimitive);

        list_addElement(bccList, bccItem);
    }
    }

    // send_mail_adv->attachments
    cJSON *attachments = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "attachments");
    if (attachments) { 
    cJSON *attachments_local_nonprimitive = NULL;
    if(!cJSON_IsArray(attachments)){
        goto end; //nonprimitive container
    }

    attachmentsList = list_createList();

    cJSON_ArrayForEach(attachments_local_nonprimitive,attachments )
    {
        if(!cJSON_IsObject(attachments_local_nonprimitive)){
            goto end;
        }
        mail_attachment_t *attachmentsItem = mail_attachment_parseFromJSON(attachments_local_nonprimitive);

        list_addElement(attachmentsList, attachmentsItem);
    }
    }

    // send_mail_adv->id
    cJSON *id = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "id");
    if (id) { 
    if(!cJSON_IsNumber(id))
    {
    goto end; //Numeric
    }
    }


    send_mail_adv_local_var = send_mail_adv_create (
        strdup(subject->valuestring),
        strdup(body->valuestring),
        from_local_nonprim,
        toList,
        replyto ? replytoList : NULL,
        cc ? ccList : NULL,
        bcc ? bccList : NULL,
        attachments ? attachmentsList : NULL,
        id ? id->valuedouble : 0
        );

    return send_mail_adv_local_var;
end:
    if (from_local_nonprim) {
        email_address_name_free(from_local_nonprim);
        from_local_nonprim = NULL;
    }
    if (toList) {
        listEntry_t *listEntry = NULL;
        list_ForEach(listEntry, toList) {
            email_address_name_free(listEntry->data);
            listEntry->data = NULL;
        }
        list_freeList(toList);
        toList = NULL;
    }
    if (replytoList) {
        listEntry_t *listEntry = NULL;
        list_ForEach(listEntry, replytoList) {
            email_address_name_free(listEntry->data);
            listEntry->data = NULL;
        }
        list_freeList(replytoList);
        replytoList = NULL;
    }
    if (ccList) {
        listEntry_t *listEntry = NULL;
        list_ForEach(listEntry, ccList) {
            email_address_name_free(listEntry->data);
            listEntry->data = NULL;
        }
        list_freeList(ccList);
        ccList = NULL;
    }
    if (bccList) {
        listEntry_t *listEntry = NULL;
        list_ForEach(listEntry, bccList) {
            email_address_name_free(listEntry->data);
            listEntry->data = NULL;
        }
        list_freeList(bccList);
        bccList = NULL;
    }
    if (attachmentsList) {
        listEntry_t *listEntry = NULL;
        list_ForEach(listEntry, attachmentsList) {
            mail_attachment_free(listEntry->data);
            listEntry->data = NULL;
        }
        list_freeList(attachmentsList);
        attachmentsList = NULL;
    }
    return NULL;

}
