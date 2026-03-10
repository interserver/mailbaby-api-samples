#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "send_mail_to.h"



static send_mail_to_t *send_mail_to_create_internal(
    ) {
    send_mail_to_t *send_mail_to_local_var = malloc(sizeof(send_mail_to_t));
    if (!send_mail_to_local_var) {
        return NULL;
    }

    send_mail_to_local_var->_library_owned = 1;
    return send_mail_to_local_var;
}

__attribute__((deprecated)) send_mail_to_t *send_mail_to_create(
    ) {
    return send_mail_to_create_internal (
        );
}

void send_mail_to_free(send_mail_to_t *send_mail_to) {
    if(NULL == send_mail_to){
        return ;
    }
    if(send_mail_to->_library_owned != 1){
        fprintf(stderr, "WARNING: %s() does NOT free objects allocated by the user\n", "send_mail_to_free");
        return ;
    }
    listEntry_t *listEntry;
    free(send_mail_to);
}

cJSON *send_mail_to_convertToJSON(send_mail_to_t *send_mail_to) {
    cJSON *item = cJSON_CreateObject();
    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

send_mail_to_t *send_mail_to_parseFromJSON(cJSON *send_mail_toJSON){

    send_mail_to_t *send_mail_to_local_var = NULL;


    send_mail_to_local_var = send_mail_to_create_internal (
        );

    return send_mail_to_local_var;
end:
    return NULL;

}
