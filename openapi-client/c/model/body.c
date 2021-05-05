#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "body.h"



body_t *body_create(
    char *to,
    char *from,
    char *subject,
    char *body
    ) {
    body_t *body_local_var = malloc(sizeof(body_t));
    if (!body_local_var) {
        return NULL;
    }
    body_local_var->to = to;
    body_local_var->from = from;
    body_local_var->subject = subject;
    body_local_var->body = body;

    return body_local_var;
}


void body_free(body_t *body) {
    if(NULL == body){
        return ;
    }
    listEntry_t *listEntry;
    if (body->to) {
        free(body->to);
        body->to = NULL;
    }
    if (body->from) {
        free(body->from);
        body->from = NULL;
    }
    if (body->subject) {
        free(body->subject);
        body->subject = NULL;
    }
    if (body->body) {
        free(body->body);
        body->body = NULL;
    }
    free(body);
}

cJSON *body_convertToJSON(body_t *body) {
    cJSON *item = cJSON_CreateObject();

    // body->to
    if(body->to) { 
    if(cJSON_AddStringToObject(item, "to", body->to) == NULL) {
    goto fail; //String
    }
     } 


    // body->from
    if(body->from) { 
    if(cJSON_AddStringToObject(item, "from", body->from) == NULL) {
    goto fail; //String
    }
     } 


    // body->subject
    if(body->subject) { 
    if(cJSON_AddStringToObject(item, "subject", body->subject) == NULL) {
    goto fail; //String
    }
     } 


    // body->body
    if(body->body) { 
    if(cJSON_AddStringToObject(item, "body", body->body) == NULL) {
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

body_t *body_parseFromJSON(cJSON *bodyJSON){

    body_t *body_local_var = NULL;

    // body->to
    cJSON *to = cJSON_GetObjectItemCaseSensitive(bodyJSON, "to");
    if (to) { 
    if(!cJSON_IsString(to))
    {
    goto end; //String
    }
    }

    // body->from
    cJSON *from = cJSON_GetObjectItemCaseSensitive(bodyJSON, "from");
    if (from) { 
    if(!cJSON_IsString(from))
    {
    goto end; //String
    }
    }

    // body->subject
    cJSON *subject = cJSON_GetObjectItemCaseSensitive(bodyJSON, "subject");
    if (subject) { 
    if(!cJSON_IsString(subject))
    {
    goto end; //String
    }
    }

    // body->body
    cJSON *body = cJSON_GetObjectItemCaseSensitive(bodyJSON, "body");
    if (body) { 
    if(!cJSON_IsString(body))
    {
    goto end; //String
    }
    }


    body_local_var = body_create (
        to ? strdup(to->valuestring) : NULL,
        from ? strdup(from->valuestring) : NULL,
        subject ? strdup(subject->valuestring) : NULL,
        body ? strdup(body->valuestring) : NULL
        );

    return body_local_var;
end:
    return NULL;

}
