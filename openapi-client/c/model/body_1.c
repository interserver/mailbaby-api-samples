#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "body_1.h"



body_1_t *body_1_create(
    char *to,
    char *from,
    char *subject,
    char *body
    ) {
    body_1_t *body_1_local_var = malloc(sizeof(body_1_t));
    if (!body_1_local_var) {
        return NULL;
    }
    body_1_local_var->to = to;
    body_1_local_var->from = from;
    body_1_local_var->subject = subject;
    body_1_local_var->body = body;

    return body_1_local_var;
}


void body_1_free(body_1_t *body_1) {
    if(NULL == body_1){
        return ;
    }
    listEntry_t *listEntry;
    if (body_1->to) {
        free(body_1->to);
        body_1->to = NULL;
    }
    if (body_1->from) {
        free(body_1->from);
        body_1->from = NULL;
    }
    if (body_1->subject) {
        free(body_1->subject);
        body_1->subject = NULL;
    }
    if (body_1->body) {
        free(body_1->body);
        body_1->body = NULL;
    }
    free(body_1);
}

cJSON *body_1_convertToJSON(body_1_t *body_1) {
    cJSON *item = cJSON_CreateObject();

    // body_1->to
    if(body_1->to) { 
    if(cJSON_AddStringToObject(item, "to", body_1->to) == NULL) {
    goto fail; //String
    }
     } 


    // body_1->from
    if(body_1->from) { 
    if(cJSON_AddStringToObject(item, "from", body_1->from) == NULL) {
    goto fail; //String
    }
     } 


    // body_1->subject
    if(body_1->subject) { 
    if(cJSON_AddStringToObject(item, "subject", body_1->subject) == NULL) {
    goto fail; //String
    }
     } 


    // body_1->body
    if(body_1->body) { 
    if(cJSON_AddStringToObject(item, "body", body_1->body) == NULL) {
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

body_1_t *body_1_parseFromJSON(cJSON *body_1JSON){

    body_1_t *body_1_local_var = NULL;

    // body_1->to
    cJSON *to = cJSON_GetObjectItemCaseSensitive(body_1JSON, "to");
    if (to) { 
    if(!cJSON_IsString(to))
    {
    goto end; //String
    }
    }

    // body_1->from
    cJSON *from = cJSON_GetObjectItemCaseSensitive(body_1JSON, "from");
    if (from) { 
    if(!cJSON_IsString(from))
    {
    goto end; //String
    }
    }

    // body_1->subject
    cJSON *subject = cJSON_GetObjectItemCaseSensitive(body_1JSON, "subject");
    if (subject) { 
    if(!cJSON_IsString(subject))
    {
    goto end; //String
    }
    }

    // body_1->body
    cJSON *body = cJSON_GetObjectItemCaseSensitive(body_1JSON, "body");
    if (body) { 
    if(!cJSON_IsString(body))
    {
    goto end; //String
    }
    }


    body_1_local_var = body_1_create (
        to ? strdup(to->valuestring) : NULL,
        from ? strdup(from->valuestring) : NULL,
        subject ? strdup(subject->valuestring) : NULL,
        body ? strdup(body->valuestring) : NULL
        );

    return body_1_local_var;
end:
    return NULL;

}
