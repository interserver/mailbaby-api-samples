#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "send_mail.h"



static send_mail_t *send_mail_create_internal(
    send_mail_to_t *to,
    char *from,
    char *subject,
    char *body,
    long *id
    ) {
    send_mail_t *send_mail_local_var = malloc(sizeof(send_mail_t));
    if (!send_mail_local_var) {
        return NULL;
    }
    memset(send_mail_local_var, 0, sizeof(send_mail_t));
    send_mail_local_var->_library_owned = 1;
    send_mail_local_var->to = to;
    send_mail_local_var->from = from;
    send_mail_local_var->subject = subject;
    send_mail_local_var->body = body;
    send_mail_local_var->id = id;
    return send_mail_local_var;
}

__attribute__((deprecated)) send_mail_t *send_mail_create(
    send_mail_to_t *to,
    char *from,
    char *subject,
    char *body,
    long *id
    ) {
    long *id_copy = NULL;
    if (id) {
        id_copy = malloc(sizeof(long));
        if (id_copy) *id_copy = *id;
    }
    send_mail_t *result = send_mail_create_internal (
        to,
        from,
        subject,
        body,
        id_copy
        );
    if (!result) {
        free(id_copy);
    }
    return result;
}

void send_mail_free(send_mail_t *send_mail) {
    if(NULL == send_mail){
        return ;
    }
    if(send_mail->_library_owned != 1){
        fprintf(stderr, "WARNING: %s() does NOT free objects allocated by the user\n", "send_mail_free");
        return ;
    }
    listEntry_t *listEntry;
    if (send_mail->to) {
        send_mail_to_free(send_mail->to);
        send_mail->to = NULL;
    }
    if (send_mail->from) {
        free(send_mail->from);
        send_mail->from = NULL;
    }
    if (send_mail->subject) {
        free(send_mail->subject);
        send_mail->subject = NULL;
    }
    if (send_mail->body) {
        free(send_mail->body);
        send_mail->body = NULL;
    }
    if (send_mail->id) {
        free(send_mail->id);
        send_mail->id = NULL;
    }
    free(send_mail);
}

cJSON *send_mail_convertToJSON(send_mail_t *send_mail) {
    cJSON *item = cJSON_CreateObject();

    // send_mail->to
    if (!send_mail->to) {
        goto fail;
    }
    cJSON *to_local_JSON = send_mail_to_convertToJSON(send_mail->to);
    if(to_local_JSON == NULL) {
    goto fail; //model
    }
    cJSON_AddItemToObject(item, "to", to_local_JSON);
    if(item->child == NULL) {
    goto fail;
    }


    // send_mail->from
    if (!send_mail->from) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "from", send_mail->from) == NULL) {
    goto fail; //String
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


    // send_mail->id
    if(send_mail->id) {
    if(cJSON_AddNumberToObject(item, "id", *send_mail->id) == NULL) {
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

send_mail_t *send_mail_parseFromJSON(cJSON *send_mailJSON){

    send_mail_t *send_mail_local_var = NULL;

    // define the local variable for send_mail->to
    send_mail_to_t *to_local_nonprim = NULL;

    char *from_local_str = NULL;

    char *subject_local_str = NULL;

    char *body_local_str = NULL;

    // define the local variable for send_mail->id
    long *id_local_var = NULL;

    // send_mail->to
    cJSON *to = cJSON_GetObjectItemCaseSensitive(send_mailJSON, "to");
    if (cJSON_IsNull(to)) {
        to = NULL;
    }
    if (!to) {
        goto end;
    }

    
    to_local_nonprim = send_mail_to_parseFromJSON(to); //nonprimitive

    // send_mail->from
    cJSON *from = cJSON_GetObjectItemCaseSensitive(send_mailJSON, "from");
    if (cJSON_IsNull(from)) {
        from = NULL;
    }
    if (!from) {
        goto end;
    }

    
    if(!cJSON_IsString(from))
    {
    goto end; //String
    }

    // send_mail->subject
    cJSON *subject = cJSON_GetObjectItemCaseSensitive(send_mailJSON, "subject");
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

    // send_mail->body
    cJSON *body = cJSON_GetObjectItemCaseSensitive(send_mailJSON, "body");
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

    // send_mail->id
    cJSON *id = cJSON_GetObjectItemCaseSensitive(send_mailJSON, "id");
    if (cJSON_IsNull(id)) {
        id = NULL;
    }
    if (id) { 
    if(!cJSON_IsNumber(id))
    {
    goto end; //Numeric
    }
    id_local_var = malloc(sizeof(long));
    if(!id_local_var)
    {
        goto end;
    }
    *id_local_var = id->valuedouble;
    }


    if (from && !cJSON_IsNull(from)) from_local_str = strdup(from->valuestring);
    if (subject && !cJSON_IsNull(subject)) subject_local_str = strdup(subject->valuestring);
    if (body && !cJSON_IsNull(body)) body_local_str = strdup(body->valuestring);

    send_mail_local_var = send_mail_create_internal (
        to_local_nonprim,
        from_local_str,
        subject_local_str,
        body_local_str,
        id_local_var
        );

    if (!send_mail_local_var) {
        goto end;
    }

    return send_mail_local_var;
end:
    if (to_local_nonprim) {
        send_mail_to_free(to_local_nonprim);
        to_local_nonprim = NULL;
    }
    if (from_local_str) {
        free(from_local_str);
        from_local_str = NULL;
    }
    if (subject_local_str) {
        free(subject_local_str);
        subject_local_str = NULL;
    }
    if (body_local_str) {
        free(body_local_str);
        body_local_str = NULL;
    }
    if (id_local_var) {
        free(id_local_var);
        id_local_var = NULL;
    }
    return NULL;

}
