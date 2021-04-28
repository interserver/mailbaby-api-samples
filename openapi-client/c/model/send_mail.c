#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "send_mail.h"



send_mail_t *send_mail_create(
    long id,
    mail_contact_t *from,
    list_t *to,
    char *subject,
    char *body,
    list_t *replyto,
    list_t *cc,
    list_t *bcc,
    list_t *attachments
    ) {
    send_mail_t *send_mail_local_var = malloc(sizeof(send_mail_t));
    if (!send_mail_local_var) {
        return NULL;
    }
    send_mail_local_var->id = id;
    send_mail_local_var->from = from;
    send_mail_local_var->to = to;
    send_mail_local_var->subject = subject;
    send_mail_local_var->body = body;
    send_mail_local_var->replyto = replyto;
    send_mail_local_var->cc = cc;
    send_mail_local_var->bcc = bcc;
    send_mail_local_var->attachments = attachments;

    return send_mail_local_var;
}


void send_mail_free(send_mail_t *send_mail) {
    if(NULL == send_mail){
        return ;
    }
    listEntry_t *listEntry;
    if (send_mail->from) {
        mail_contact_free(send_mail->from);
        send_mail->from = NULL;
    }
    if (send_mail->to) {
        list_ForEach(listEntry, send_mail->to) {
            mail_contact_free(listEntry->data);
        }
        list_free(send_mail->to);
        send_mail->to = NULL;
    }
    if (send_mail->subject) {
        free(send_mail->subject);
        send_mail->subject = NULL;
    }
    if (send_mail->body) {
        free(send_mail->body);
        send_mail->body = NULL;
    }
    if (send_mail->replyto) {
        list_ForEach(listEntry, send_mail->replyto) {
            mail_contact_free(listEntry->data);
        }
        list_free(send_mail->replyto);
        send_mail->replyto = NULL;
    }
    if (send_mail->cc) {
        list_ForEach(listEntry, send_mail->cc) {
            mail_contact_free(listEntry->data);
        }
        list_free(send_mail->cc);
        send_mail->cc = NULL;
    }
    if (send_mail->bcc) {
        list_ForEach(listEntry, send_mail->bcc) {
            mail_contact_free(listEntry->data);
        }
        list_free(send_mail->bcc);
        send_mail->bcc = NULL;
    }
    if (send_mail->attachments) {
        list_ForEach(listEntry, send_mail->attachments) {
            mail_attachment_free(listEntry->data);
        }
        list_free(send_mail->attachments);
        send_mail->attachments = NULL;
    }
    free(send_mail);
}

cJSON *send_mail_convertToJSON(send_mail_t *send_mail) {
    cJSON *item = cJSON_CreateObject();

    // send_mail->id
    if (!send_mail->id) {
        goto fail;
    }
    
    if(cJSON_AddNumberToObject(item, "id", send_mail->id) == NULL) {
    goto fail; //Numeric
    }


    // send_mail->from
    if (!send_mail->from) {
        goto fail;
    }
    
    cJSON *from_local_JSON = mail_contact_convertToJSON(send_mail->from);
    if(from_local_JSON == NULL) {
    goto fail; //model
    }
    cJSON_AddItemToObject(item, "from", from_local_JSON);
    if(item->child == NULL) {
    goto fail;
    }


    // send_mail->to
    if (!send_mail->to) {
        goto fail;
    }
    
    cJSON *to = cJSON_AddArrayToObject(item, "to");
    if(to == NULL) {
    goto fail; //nonprimitive container
    }

    listEntry_t *toListEntry;
    if (send_mail->to) {
    list_ForEach(toListEntry, send_mail->to) {
    cJSON *itemLocal = mail_contact_convertToJSON(toListEntry->data);
    if(itemLocal == NULL) {
    goto fail;
    }
    cJSON_AddItemToArray(to, itemLocal);
    }
    }


    // send_mail->subject
    if (!send_mail->subject) {
        goto fail;
    }
    
    if(cJSON_AddStringToObject(item, "subject", send_mail->subject) == NULL) {
    goto fail; //String
    }


    // send_mail->body
    if (!send_mail->body) {
        goto fail;
    }
    
    if(cJSON_AddStringToObject(item, "body", send_mail->body) == NULL) {
    goto fail; //String
    }


    // send_mail->replyto
    if(send_mail->replyto) { 
    cJSON *replyto = cJSON_AddArrayToObject(item, "replyto");
    if(replyto == NULL) {
    goto fail; //nonprimitive container
    }

    listEntry_t *replytoListEntry;
    if (send_mail->replyto) {
    list_ForEach(replytoListEntry, send_mail->replyto) {
    cJSON *itemLocal = mail_contact_convertToJSON(replytoListEntry->data);
    if(itemLocal == NULL) {
    goto fail;
    }
    cJSON_AddItemToArray(replyto, itemLocal);
    }
    }
     } 


    // send_mail->cc
    if(send_mail->cc) { 
    cJSON *cc = cJSON_AddArrayToObject(item, "cc");
    if(cc == NULL) {
    goto fail; //nonprimitive container
    }

    listEntry_t *ccListEntry;
    if (send_mail->cc) {
    list_ForEach(ccListEntry, send_mail->cc) {
    cJSON *itemLocal = mail_contact_convertToJSON(ccListEntry->data);
    if(itemLocal == NULL) {
    goto fail;
    }
    cJSON_AddItemToArray(cc, itemLocal);
    }
    }
     } 


    // send_mail->bcc
    if(send_mail->bcc) { 
    cJSON *bcc = cJSON_AddArrayToObject(item, "bcc");
    if(bcc == NULL) {
    goto fail; //nonprimitive container
    }

    listEntry_t *bccListEntry;
    if (send_mail->bcc) {
    list_ForEach(bccListEntry, send_mail->bcc) {
    cJSON *itemLocal = mail_contact_convertToJSON(bccListEntry->data);
    if(itemLocal == NULL) {
    goto fail;
    }
    cJSON_AddItemToArray(bcc, itemLocal);
    }
    }
     } 


    // send_mail->attachments
    if(send_mail->attachments) { 
    cJSON *attachments = cJSON_AddArrayToObject(item, "attachments");
    if(attachments == NULL) {
    goto fail; //nonprimitive container
    }

    listEntry_t *attachmentsListEntry;
    if (send_mail->attachments) {
    list_ForEach(attachmentsListEntry, send_mail->attachments) {
    cJSON *itemLocal = mail_attachment_convertToJSON(attachmentsListEntry->data);
    if(itemLocal == NULL) {
    goto fail;
    }
    cJSON_AddItemToArray(attachments, itemLocal);
    }
    }
     } 

    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

send_mail_t *send_mail_parseFromJSON(cJSON *send_mailJSON){

    send_mail_t *send_mail_local_var = NULL;

    // send_mail->id
    cJSON *id = cJSON_GetObjectItemCaseSensitive(send_mailJSON, "id");
    if (!id) {
        goto end;
    }

    
    if(!cJSON_IsNumber(id))
    {
    goto end; //Numeric
    }

    // send_mail->from
    cJSON *from = cJSON_GetObjectItemCaseSensitive(send_mailJSON, "from");
    if (!from) {
        goto end;
    }

    mail_contact_t *from_local_nonprim = NULL;
    
    from_local_nonprim = mail_contact_parseFromJSON(from); //nonprimitive

    // send_mail->to
    cJSON *to = cJSON_GetObjectItemCaseSensitive(send_mailJSON, "to");
    if (!to) {
        goto end;
    }

    list_t *toList;
    
    cJSON *to_local_nonprimitive;
    if(!cJSON_IsArray(to)){
        goto end; //nonprimitive container
    }

    toList = list_create();

    cJSON_ArrayForEach(to_local_nonprimitive,to )
    {
        if(!cJSON_IsObject(to_local_nonprimitive)){
            goto end;
        }
        mail_contact_t *toItem = mail_contact_parseFromJSON(to_local_nonprimitive);

        list_addElement(toList, toItem);
    }

    // send_mail->subject
    cJSON *subject = cJSON_GetObjectItemCaseSensitive(send_mailJSON, "subject");
    if (!subject) {
        goto end;
    }

    
    if(!cJSON_IsString(subject))
    {
    goto end; //String
    }

    // send_mail->body
    cJSON *body = cJSON_GetObjectItemCaseSensitive(send_mailJSON, "body");
    if (!body) {
        goto end;
    }

    
    if(!cJSON_IsString(body))
    {
    goto end; //String
    }

    // send_mail->replyto
    cJSON *replyto = cJSON_GetObjectItemCaseSensitive(send_mailJSON, "replyto");
    list_t *replytoList;
    if (replyto) { 
    cJSON *replyto_local_nonprimitive;
    if(!cJSON_IsArray(replyto)){
        goto end; //nonprimitive container
    }

    replytoList = list_create();

    cJSON_ArrayForEach(replyto_local_nonprimitive,replyto )
    {
        if(!cJSON_IsObject(replyto_local_nonprimitive)){
            goto end;
        }
        mail_contact_t *replytoItem = mail_contact_parseFromJSON(replyto_local_nonprimitive);

        list_addElement(replytoList, replytoItem);
    }
    }

    // send_mail->cc
    cJSON *cc = cJSON_GetObjectItemCaseSensitive(send_mailJSON, "cc");
    list_t *ccList;
    if (cc) { 
    cJSON *cc_local_nonprimitive;
    if(!cJSON_IsArray(cc)){
        goto end; //nonprimitive container
    }

    ccList = list_create();

    cJSON_ArrayForEach(cc_local_nonprimitive,cc )
    {
        if(!cJSON_IsObject(cc_local_nonprimitive)){
            goto end;
        }
        mail_contact_t *ccItem = mail_contact_parseFromJSON(cc_local_nonprimitive);

        list_addElement(ccList, ccItem);
    }
    }

    // send_mail->bcc
    cJSON *bcc = cJSON_GetObjectItemCaseSensitive(send_mailJSON, "bcc");
    list_t *bccList;
    if (bcc) { 
    cJSON *bcc_local_nonprimitive;
    if(!cJSON_IsArray(bcc)){
        goto end; //nonprimitive container
    }

    bccList = list_create();

    cJSON_ArrayForEach(bcc_local_nonprimitive,bcc )
    {
        if(!cJSON_IsObject(bcc_local_nonprimitive)){
            goto end;
        }
        mail_contact_t *bccItem = mail_contact_parseFromJSON(bcc_local_nonprimitive);

        list_addElement(bccList, bccItem);
    }
    }

    // send_mail->attachments
    cJSON *attachments = cJSON_GetObjectItemCaseSensitive(send_mailJSON, "attachments");
    list_t *attachmentsList;
    if (attachments) { 
    cJSON *attachments_local_nonprimitive;
    if(!cJSON_IsArray(attachments)){
        goto end; //nonprimitive container
    }

    attachmentsList = list_create();

    cJSON_ArrayForEach(attachments_local_nonprimitive,attachments )
    {
        if(!cJSON_IsObject(attachments_local_nonprimitive)){
            goto end;
        }
        mail_attachment_t *attachmentsItem = mail_attachment_parseFromJSON(attachments_local_nonprimitive);

        list_addElement(attachmentsList, attachmentsItem);
    }
    }


    send_mail_local_var = send_mail_create (
        id->valuedouble,
        from_local_nonprim,
        toList,
        strdup(subject->valuestring),
        strdup(body->valuestring),
        replyto ? replytoList : NULL,
        cc ? ccList : NULL,
        bcc ? bccList : NULL,
        attachments ? attachmentsList : NULL
        );

    return send_mail_local_var;
end:
    if (from_local_nonprim) {
        mail_contact_free(from_local_nonprim);
        from_local_nonprim = NULL;
    }
    return NULL;

}
