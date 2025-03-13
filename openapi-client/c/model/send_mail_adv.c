#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "send_mail_adv.h"



static send_mail_adv_t *send_mail_adv_create_internal(
    char *subject,
    char *body,
    email_address_types_t *from,
    email_addresses_types_t *to,
    email_addresses_types_t *replyto,
    email_addresses_types_t *cc,
    email_addresses_types_t *bcc,
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

    send_mail_adv_local_var->_library_owned = 1;
    return send_mail_adv_local_var;
}

__attribute__((deprecated)) send_mail_adv_t *send_mail_adv_create(
    char *subject,
    char *body,
    email_address_types_t *from,
    email_addresses_types_t *to,
    email_addresses_types_t *replyto,
    email_addresses_types_t *cc,
    email_addresses_types_t *bcc,
    list_t *attachments,
    long id
    ) {
    return send_mail_adv_create_internal (
        subject,
        body,
        from,
        to,
        replyto,
        cc,
        bcc,
        attachments,
        id
        );
}

void send_mail_adv_free(send_mail_adv_t *send_mail_adv) {
    if(NULL == send_mail_adv){
        return ;
    }
    if(send_mail_adv->_library_owned != 1){
        fprintf(stderr, "WARNING: %s() does NOT free objects allocated by the user\n", "send_mail_adv_free");
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
        email_address_types_free(send_mail_adv->from);
        send_mail_adv->from = NULL;
    }
    if (send_mail_adv->to) {
        email_addresses_types_free(send_mail_adv->to);
        send_mail_adv->to = NULL;
    }
    if (send_mail_adv->replyto) {
        email_addresses_types_free(send_mail_adv->replyto);
        send_mail_adv->replyto = NULL;
    }
    if (send_mail_adv->cc) {
        email_addresses_types_free(send_mail_adv->cc);
        send_mail_adv->cc = NULL;
    }
    if (send_mail_adv->bcc) {
        email_addresses_types_free(send_mail_adv->bcc);
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
    cJSON *from_local_JSON = email_address_types_convertToJSON(send_mail_adv->from);
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
    cJSON *to_local_JSON = email_addresses_types_convertToJSON(send_mail_adv->to);
    if(to_local_JSON == NULL) {
    goto fail; //model
    }
    cJSON_AddItemToObject(item, "to", to_local_JSON);
    if(item->child == NULL) {
    goto fail;
    }


    // send_mail_adv->replyto
    if(send_mail_adv->replyto) {
    cJSON *replyto_local_JSON = email_addresses_types_convertToJSON(send_mail_adv->replyto);
    if(replyto_local_JSON == NULL) {
    goto fail; //model
    }
    cJSON_AddItemToObject(item, "replyto", replyto_local_JSON);
    if(item->child == NULL) {
    goto fail;
    }
    }


    // send_mail_adv->cc
    if(send_mail_adv->cc) {
    cJSON *cc_local_JSON = email_addresses_types_convertToJSON(send_mail_adv->cc);
    if(cc_local_JSON == NULL) {
    goto fail; //model
    }
    cJSON_AddItemToObject(item, "cc", cc_local_JSON);
    if(item->child == NULL) {
    goto fail;
    }
    }


    // send_mail_adv->bcc
    if(send_mail_adv->bcc) {
    cJSON *bcc_local_JSON = email_addresses_types_convertToJSON(send_mail_adv->bcc);
    if(bcc_local_JSON == NULL) {
    goto fail; //model
    }
    cJSON_AddItemToObject(item, "bcc", bcc_local_JSON);
    if(item->child == NULL) {
    goto fail;
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
    email_address_types_t *from_local_nonprim = NULL;

    // define the local variable for send_mail_adv->to
    email_addresses_types_t *to_local_nonprim = NULL;

    // define the local variable for send_mail_adv->replyto
    email_addresses_types_t *replyto_local_nonprim = NULL;

    // define the local variable for send_mail_adv->cc
    email_addresses_types_t *cc_local_nonprim = NULL;

    // define the local variable for send_mail_adv->bcc
    email_addresses_types_t *bcc_local_nonprim = NULL;

    // define the local list for send_mail_adv->attachments
    list_t *attachmentsList = NULL;

    // send_mail_adv->subject
    cJSON *subject = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "subject");
    if (cJSON_IsNull(subject)) {
        subject = NULL;
    }
    if (!subject) {
        goto end;
    }

    
    if(!cJSON_IsString(subject))
    {
    goto end; //String
    }

    // send_mail_adv->body
    cJSON *body = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "body");
    if (cJSON_IsNull(body)) {
        body = NULL;
    }
    if (!body) {
        goto end;
    }

    
    if(!cJSON_IsString(body))
    {
    goto end; //String
    }

    // send_mail_adv->from
    cJSON *from = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "from");
    if (cJSON_IsNull(from)) {
        from = NULL;
    }
    if (!from) {
        goto end;
    }

    
    from_local_nonprim = email_address_types_parseFromJSON(from); //nonprimitive

    // send_mail_adv->to
    cJSON *to = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "to");
    if (cJSON_IsNull(to)) {
        to = NULL;
    }
    if (!to) {
        goto end;
    }

    
    to_local_nonprim = email_addresses_types_parseFromJSON(to); //nonprimitive

    // send_mail_adv->replyto
    cJSON *replyto = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "replyto");
    if (cJSON_IsNull(replyto)) {
        replyto = NULL;
    }
    if (replyto) { 
    replyto_local_nonprim = email_addresses_types_parseFromJSON(replyto); //nonprimitive
    }

    // send_mail_adv->cc
    cJSON *cc = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "cc");
    if (cJSON_IsNull(cc)) {
        cc = NULL;
    }
    if (cc) { 
    cc_local_nonprim = email_addresses_types_parseFromJSON(cc); //nonprimitive
    }

    // send_mail_adv->bcc
    cJSON *bcc = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "bcc");
    if (cJSON_IsNull(bcc)) {
        bcc = NULL;
    }
    if (bcc) { 
    bcc_local_nonprim = email_addresses_types_parseFromJSON(bcc); //nonprimitive
    }

    // send_mail_adv->attachments
    cJSON *attachments = cJSON_GetObjectItemCaseSensitive(send_mail_advJSON, "attachments");
    if (cJSON_IsNull(attachments)) {
        attachments = NULL;
    }
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
    if (cJSON_IsNull(id)) {
        id = NULL;
    }
    if (id) { 
    if(!cJSON_IsNumber(id))
    {
    goto end; //Numeric
    }
    }


    send_mail_adv_local_var = send_mail_adv_create_internal (
        strdup(subject->valuestring),
        strdup(body->valuestring),
        from_local_nonprim,
        to_local_nonprim,
        replyto ? replyto_local_nonprim : NULL,
        cc ? cc_local_nonprim : NULL,
        bcc ? bcc_local_nonprim : NULL,
        attachments ? attachmentsList : NULL,
        id ? id->valuedouble : 0
        );

    return send_mail_adv_local_var;
end:
    if (from_local_nonprim) {
        email_address_types_free(from_local_nonprim);
        from_local_nonprim = NULL;
    }
    if (to_local_nonprim) {
        email_addresses_types_free(to_local_nonprim);
        to_local_nonprim = NULL;
    }
    if (replyto_local_nonprim) {
        email_addresses_types_free(replyto_local_nonprim);
        replyto_local_nonprim = NULL;
    }
    if (cc_local_nonprim) {
        email_addresses_types_free(cc_local_nonprim);
        cc_local_nonprim = NULL;
    }
    if (bcc_local_nonprim) {
        email_addresses_types_free(bcc_local_nonprim);
        bcc_local_nonprim = NULL;
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
