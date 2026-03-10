#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "mail_stats_volume.h"



static mail_stats_volume_t *mail_stats_volume_create_internal(
    list_t* to,
    list_t* from,
    list_t* ip
    ) {
    mail_stats_volume_t *mail_stats_volume_local_var = malloc(sizeof(mail_stats_volume_t));
    if (!mail_stats_volume_local_var) {
        return NULL;
    }
    mail_stats_volume_local_var->to = to;
    mail_stats_volume_local_var->from = from;
    mail_stats_volume_local_var->ip = ip;

    mail_stats_volume_local_var->_library_owned = 1;
    return mail_stats_volume_local_var;
}

__attribute__((deprecated)) mail_stats_volume_t *mail_stats_volume_create(
    list_t* to,
    list_t* from,
    list_t* ip
    ) {
    return mail_stats_volume_create_internal (
        to,
        from,
        ip
        );
}

void mail_stats_volume_free(mail_stats_volume_t *mail_stats_volume) {
    if(NULL == mail_stats_volume){
        return ;
    }
    if(mail_stats_volume->_library_owned != 1){
        fprintf(stderr, "WARNING: %s() does NOT free objects allocated by the user\n", "mail_stats_volume_free");
        return ;
    }
    listEntry_t *listEntry;
    if (mail_stats_volume->to) {
        list_ForEach(listEntry, mail_stats_volume->to) {
            keyValuePair_t *localKeyValue = listEntry->data;
            free (localKeyValue->key);
            free (localKeyValue->value);
            keyValuePair_free(localKeyValue);
        }
        list_freeList(mail_stats_volume->to);
        mail_stats_volume->to = NULL;
    }
    if (mail_stats_volume->from) {
        list_ForEach(listEntry, mail_stats_volume->from) {
            keyValuePair_t *localKeyValue = listEntry->data;
            free (localKeyValue->key);
            free (localKeyValue->value);
            keyValuePair_free(localKeyValue);
        }
        list_freeList(mail_stats_volume->from);
        mail_stats_volume->from = NULL;
    }
    if (mail_stats_volume->ip) {
        list_ForEach(listEntry, mail_stats_volume->ip) {
            keyValuePair_t *localKeyValue = listEntry->data;
            free (localKeyValue->key);
            free (localKeyValue->value);
            keyValuePair_free(localKeyValue);
        }
        list_freeList(mail_stats_volume->ip);
        mail_stats_volume->ip = NULL;
    }
    free(mail_stats_volume);
}

cJSON *mail_stats_volume_convertToJSON(mail_stats_volume_t *mail_stats_volume) {
    cJSON *item = cJSON_CreateObject();

    // mail_stats_volume->to
    if(mail_stats_volume->to) {
    cJSON *to = cJSON_AddObjectToObject(item, "to");
    if(to == NULL) {
        goto fail; //primitive map container
    }
    cJSON *localMapObject = to;
    listEntry_t *toListEntry;
    if (mail_stats_volume->to) {
    list_ForEach(toListEntry, mail_stats_volume->to) {
        keyValuePair_t *localKeyValue = toListEntry->data;
        if(cJSON_AddNumberToObject(localMapObject, localKeyValue->key, *(double *)localKeyValue->value) == NULL)
        {
            goto fail;
        }
    }
    }
    }


    // mail_stats_volume->from
    if(mail_stats_volume->from) {
    cJSON *from = cJSON_AddObjectToObject(item, "from");
    if(from == NULL) {
        goto fail; //primitive map container
    }
    cJSON *localMapObject = from;
    listEntry_t *fromListEntry;
    if (mail_stats_volume->from) {
    list_ForEach(fromListEntry, mail_stats_volume->from) {
        keyValuePair_t *localKeyValue = fromListEntry->data;
        if(cJSON_AddNumberToObject(localMapObject, localKeyValue->key, *(double *)localKeyValue->value) == NULL)
        {
            goto fail;
        }
    }
    }
    }


    // mail_stats_volume->ip
    if(mail_stats_volume->ip) {
    cJSON *ip = cJSON_AddObjectToObject(item, "ip");
    if(ip == NULL) {
        goto fail; //primitive map container
    }
    cJSON *localMapObject = ip;
    listEntry_t *ipListEntry;
    if (mail_stats_volume->ip) {
    list_ForEach(ipListEntry, mail_stats_volume->ip) {
        keyValuePair_t *localKeyValue = ipListEntry->data;
        if(cJSON_AddNumberToObject(localMapObject, localKeyValue->key, *(double *)localKeyValue->value) == NULL)
        {
            goto fail;
        }
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

mail_stats_volume_t *mail_stats_volume_parseFromJSON(cJSON *mail_stats_volumeJSON){

    mail_stats_volume_t *mail_stats_volume_local_var = NULL;

    // define the local map for mail_stats_volume->to
    list_t *toList = NULL;

    // define the local map for mail_stats_volume->from
    list_t *fromList = NULL;

    // define the local map for mail_stats_volume->ip
    list_t *ipList = NULL;

    // mail_stats_volume->to
    cJSON *to = cJSON_GetObjectItemCaseSensitive(mail_stats_volumeJSON, "to");
    if (cJSON_IsNull(to)) {
        to = NULL;
    }
    if (to) { 
    cJSON *to_local_map = NULL;
    if(!cJSON_IsObject(to) && !cJSON_IsNull(to))
    {
        goto end;//primitive map container
    }
    if(cJSON_IsObject(to))
    {
        toList = list_createList();
        keyValuePair_t *localMapKeyPair;
        cJSON_ArrayForEach(to_local_map, to)
        {
            cJSON *localMapObject = to_local_map;
            if(!cJSON_IsNumber(localMapObject))
            {
                goto end;
            }
            localMapKeyPair = keyValuePair_create(strdup(localMapObject->string),&localMapObject->valuedouble );
            list_addElement(toList , localMapKeyPair);
        }
    }
    }

    // mail_stats_volume->from
    cJSON *from = cJSON_GetObjectItemCaseSensitive(mail_stats_volumeJSON, "from");
    if (cJSON_IsNull(from)) {
        from = NULL;
    }
    if (from) { 
    cJSON *from_local_map = NULL;
    if(!cJSON_IsObject(from) && !cJSON_IsNull(from))
    {
        goto end;//primitive map container
    }
    if(cJSON_IsObject(from))
    {
        fromList = list_createList();
        keyValuePair_t *localMapKeyPair;
        cJSON_ArrayForEach(from_local_map, from)
        {
            cJSON *localMapObject = from_local_map;
            if(!cJSON_IsNumber(localMapObject))
            {
                goto end;
            }
            localMapKeyPair = keyValuePair_create(strdup(localMapObject->string),&localMapObject->valuedouble );
            list_addElement(fromList , localMapKeyPair);
        }
    }
    }

    // mail_stats_volume->ip
    cJSON *ip = cJSON_GetObjectItemCaseSensitive(mail_stats_volumeJSON, "ip");
    if (cJSON_IsNull(ip)) {
        ip = NULL;
    }
    if (ip) { 
    cJSON *ip_local_map = NULL;
    if(!cJSON_IsObject(ip) && !cJSON_IsNull(ip))
    {
        goto end;//primitive map container
    }
    if(cJSON_IsObject(ip))
    {
        ipList = list_createList();
        keyValuePair_t *localMapKeyPair;
        cJSON_ArrayForEach(ip_local_map, ip)
        {
            cJSON *localMapObject = ip_local_map;
            if(!cJSON_IsNumber(localMapObject))
            {
                goto end;
            }
            localMapKeyPair = keyValuePair_create(strdup(localMapObject->string),&localMapObject->valuedouble );
            list_addElement(ipList , localMapKeyPair);
        }
    }
    }


    mail_stats_volume_local_var = mail_stats_volume_create_internal (
        to ? toList : NULL,
        from ? fromList : NULL,
        ip ? ipList : NULL
        );

    return mail_stats_volume_local_var;
end:
    if (toList) {
        listEntry_t *listEntry = NULL;
        list_ForEach(listEntry, toList) {
            keyValuePair_t *localKeyValue = listEntry->data;
            free(localKeyValue->key);
            localKeyValue->key = NULL;
            keyValuePair_free(localKeyValue);
            localKeyValue = NULL;
        }
        list_freeList(toList);
        toList = NULL;
    }
    if (fromList) {
        listEntry_t *listEntry = NULL;
        list_ForEach(listEntry, fromList) {
            keyValuePair_t *localKeyValue = listEntry->data;
            free(localKeyValue->key);
            localKeyValue->key = NULL;
            keyValuePair_free(localKeyValue);
            localKeyValue = NULL;
        }
        list_freeList(fromList);
        fromList = NULL;
    }
    if (ipList) {
        listEntry_t *listEntry = NULL;
        list_ForEach(listEntry, ipList) {
            keyValuePair_t *localKeyValue = listEntry->data;
            free(localKeyValue->key);
            localKeyValue->key = NULL;
            keyValuePair_free(localKeyValue);
            localKeyValue = NULL;
        }
        list_freeList(ipList);
        ipList = NULL;
    }
    return NULL;

}
