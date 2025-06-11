#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#include "HistoryAPI.h"

#define MAX_NUMBER_LENGTH 16
#define MAX_BUFFER_LENGTH 4096

// Functions for enum TIME for HistoryAPI_getStats

static char* getStats_TIME_ToString(mailbaby_email_delivery_and_management_service_api_getStats_time_e TIME){
    char *TIMEArray[] =  { "NULL", "all", "billing", "month", "7d", "24h", "1d", "1h" };
    return TIMEArray[TIME];
}

static mailbaby_email_delivery_and_management_service_api_getStats_time_e getStats_TIME_FromString(char* TIME){
    int stringToReturn = 0;
    char *TIMEArray[] =  { "NULL", "all", "billing", "month", "7d", "24h", "1d", "1h" };
    size_t sizeofArray = sizeof(TIMEArray) / sizeof(TIMEArray[0]);
    while(stringToReturn < sizeofArray) {
        if(strcmp(TIME, TIMEArray[stringToReturn]) == 0) {
            return stringToReturn;
        }
        stringToReturn++;
    }
    return 0;
}

/*
// Function getStats_TIME_convertToJSON is not currently used,
// since conversion to JSON passes through the conversion of the model, and ToString. The function is kept for future reference.
//
static cJSON *getStats_TIME_convertToJSON(mailbaby_email_delivery_and_management_service_api_getStats_time_e TIME) {
    cJSON *item = cJSON_CreateObject();
    if(cJSON_AddStringToObject(item, "time", getStats_TIME_ToString(TIME)) == NULL) {
        goto fail;
    }
    return item;
    fail:
    cJSON_Delete(item);
    return NULL;
}

// Function getStats_TIME_parseFromJSON is not currently used,
// since conversion from JSON passes through the conversion of the model, and FromString. The function is kept for future reference.
//
static mailbaby_email_delivery_and_management_service_api_getStats_time_e getStats_TIME_parseFromJSON(cJSON* TIMEJSON) {
    mailbaby_email_delivery_and_management_service_api_getStats_time_e TIMEVariable = 0;
    cJSON *TIMEVar = cJSON_GetObjectItemCaseSensitive(TIMEJSON, "time");
    if(!cJSON_IsString(TIMEVar) || (TIMEVar->valuestring == NULL))
    {
        goto end;
    }
    TIMEVariable = getStats_TIME_FromString(TIMEVar->valuestring);
    return TIMEVariable;
end:
    return 0;
}
*/

// Functions for enum DELIVERED for HistoryAPI_viewMailLog

static char* viewMailLog_DELIVERED_ToString(mailbaby_email_delivery_and_management_service_api_viewMailLog_delivered_e DELIVERED){
    char *DELIVEREDArray[] =  { "NULL", "0", "1" };
    return DELIVEREDArray[DELIVERED];
}

static mailbaby_email_delivery_and_management_service_api_viewMailLog_delivered_e viewMailLog_DELIVERED_FromString(char* DELIVERED){
    int stringToReturn = 0;
    char *DELIVEREDArray[] =  { "NULL", "0", "1" };
    size_t sizeofArray = sizeof(DELIVEREDArray) / sizeof(DELIVEREDArray[0]);
    while(stringToReturn < sizeofArray) {
        if(strcmp(DELIVERED, DELIVEREDArray[stringToReturn]) == 0) {
            return stringToReturn;
        }
        stringToReturn++;
    }
    return 0;
}

/*
// Function viewMailLog_DELIVERED_convertToJSON is not currently used,
// since conversion to JSON passes through the conversion of the model, and ToString. The function is kept for future reference.
//
static cJSON *viewMailLog_DELIVERED_convertToJSON(mailbaby_email_delivery_and_management_service_api_viewMailLog_delivered_e DELIVERED) {
    cJSON *item = cJSON_CreateObject();
    if(cJSON_AddStringToObject(item, "delivered", viewMailLog_DELIVERED_ToString(DELIVERED)) == NULL) {
        goto fail;
    }
    return item;
    fail:
    cJSON_Delete(item);
    return NULL;
}

// Function viewMailLog_DELIVERED_parseFromJSON is not currently used,
// since conversion from JSON passes through the conversion of the model, and FromString. The function is kept for future reference.
//
static mailbaby_email_delivery_and_management_service_api_viewMailLog_delivered_e viewMailLog_DELIVERED_parseFromJSON(cJSON* DELIVEREDJSON) {
    mailbaby_email_delivery_and_management_service_api_viewMailLog_delivered_e DELIVEREDVariable = 0;
    cJSON *DELIVEREDVar = cJSON_GetObjectItemCaseSensitive(DELIVEREDJSON, "delivered");
    if(!cJSON_IsString(DELIVEREDVar) || (DELIVEREDVar->valuestring == NULL))
    {
        goto end;
    }
    DELIVEREDVariable = viewMailLog_DELIVERED_FromString(DELIVEREDVar->valuestring);
    return DELIVEREDVariable;
end:
    return 0;
}
*/


// Account usage statistics.
//
// Returns information about the usage on your mail accounts.
//
mail_stats_type_t*
HistoryAPI_getStats(apiClient_t *apiClient, mailbaby_email_delivery_and_management_service_api_getStats_time_e time)
{
    list_t    *localVarQueryParameters = list_createList();
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_createList();
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;
    size_t     localVarBodyLength = 0;

    // clear the error code from the previous api call
    apiClient->response_code = 0;

    // create the path
    char *localVarPath = strdup("/mail/stats");





    // query parameters
    char *keyQuery_time = NULL;
    mailbaby_email_delivery_and_management_service_api_getStats_time_e valueQuery_time ;
    keyValuePair_t *keyPairQuery_time = 0;
    if (time)
    {
        keyQuery_time = strdup("time");
        valueQuery_time = (time);
        keyPairQuery_time = keyValuePair_create(keyQuery_time, strdup(getStats_TIME_ToString(
        valueQuery_time)));
        list_addElement(localVarQueryParameters,keyPairQuery_time);
    }
    list_addElement(localVarHeaderType,"application/json"); //produces
    apiClient_invoke(apiClient,
                    localVarPath,
                    localVarQueryParameters,
                    localVarHeaderParameters,
                    localVarFormParameters,
                    localVarHeaderType,
                    localVarContentType,
                    localVarBodyParameters,
                    localVarBodyLength,
                    "GET");

    // uncomment below to debug the error response
    //if (apiClient->response_code == 200) {
    //    printf("%s\n","OK");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 401) {
    //    printf("%s\n","Unauthorized");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 404) {
    //    printf("%s\n","Unauthorized");
    //}
    //nonprimitive not container
    mail_stats_type_t *elementToReturn = NULL;
    if(apiClient->response_code >= 200 && apiClient->response_code < 300) {
        cJSON *HistoryAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
        elementToReturn = mail_stats_type_parseFromJSON(HistoryAPIlocalVarJSON);
        cJSON_Delete(HistoryAPIlocalVarJSON);
        if(elementToReturn == NULL) {
            // return 0;
        }
    }

    //return type
    if (apiClient->dataReceived) {
        free(apiClient->dataReceived);
        apiClient->dataReceived = NULL;
        apiClient->dataReceivedLen = 0;
    }
    list_freeList(localVarQueryParameters);
    
    
    list_freeList(localVarHeaderType);
    
    free(localVarPath);
    if(keyQuery_time){
        free(keyQuery_time);
        keyQuery_time = NULL;
    }
    if(keyPairQuery_time){
        keyValuePair_free(keyPairQuery_time);
        keyPairQuery_time = NULL;
    }
    return elementToReturn;
end:
    free(localVarPath);
    return NULL;

}

// displays the mail log
//
// Get a listing of the emails sent through this system 
//
mail_log_t*
HistoryAPI_viewMailLog(apiClient_t *apiClient, long id, char *origin, char *mx, char *from, char *to, char *subject, char *mailid, int *skip, int *limit, long startDate, long endDate, char *replyto, char *headerfrom, mailbaby_email_delivery_and_management_service_api_viewMailLog_delivered_e delivered)
{
    list_t    *localVarQueryParameters = list_createList();
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_createList();
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;
    size_t     localVarBodyLength = 0;

    // clear the error code from the previous api call
    apiClient->response_code = 0;

    // create the path
    char *localVarPath = strdup("/mail/log");





    // query parameters
    char *keyQuery_id = NULL;
    long valueQuery_id ;
    keyValuePair_t *keyPairQuery_id = 0;
    if (id)
    {
        keyQuery_id = strdup("id");
        valueQuery_id = (id);
        keyPairQuery_id = keyValuePair_create(keyQuery_id, &valueQuery_id);
        list_addElement(localVarQueryParameters,keyPairQuery_id);
    }

    // query parameters
    char *keyQuery_origin = NULL;
    char * valueQuery_origin = NULL;
    keyValuePair_t *keyPairQuery_origin = 0;
    if (origin)
    {
        keyQuery_origin = strdup("origin");
        valueQuery_origin = strdup((origin));
        keyPairQuery_origin = keyValuePair_create(keyQuery_origin, valueQuery_origin);
        list_addElement(localVarQueryParameters,keyPairQuery_origin);
    }

    // query parameters
    char *keyQuery_mx = NULL;
    char * valueQuery_mx = NULL;
    keyValuePair_t *keyPairQuery_mx = 0;
    if (mx)
    {
        keyQuery_mx = strdup("mx");
        valueQuery_mx = strdup((mx));
        keyPairQuery_mx = keyValuePair_create(keyQuery_mx, valueQuery_mx);
        list_addElement(localVarQueryParameters,keyPairQuery_mx);
    }

    // query parameters
    char *keyQuery_from = NULL;
    char * valueQuery_from = NULL;
    keyValuePair_t *keyPairQuery_from = 0;
    if (from)
    {
        keyQuery_from = strdup("from");
        valueQuery_from = strdup((from));
        keyPairQuery_from = keyValuePair_create(keyQuery_from, valueQuery_from);
        list_addElement(localVarQueryParameters,keyPairQuery_from);
    }

    // query parameters
    char *keyQuery_to = NULL;
    char * valueQuery_to = NULL;
    keyValuePair_t *keyPairQuery_to = 0;
    if (to)
    {
        keyQuery_to = strdup("to");
        valueQuery_to = strdup((to));
        keyPairQuery_to = keyValuePair_create(keyQuery_to, valueQuery_to);
        list_addElement(localVarQueryParameters,keyPairQuery_to);
    }

    // query parameters
    char *keyQuery_subject = NULL;
    char * valueQuery_subject = NULL;
    keyValuePair_t *keyPairQuery_subject = 0;
    if (subject)
    {
        keyQuery_subject = strdup("subject");
        valueQuery_subject = strdup((subject));
        keyPairQuery_subject = keyValuePair_create(keyQuery_subject, valueQuery_subject);
        list_addElement(localVarQueryParameters,keyPairQuery_subject);
    }

    // query parameters
    char *keyQuery_mailid = NULL;
    char * valueQuery_mailid = NULL;
    keyValuePair_t *keyPairQuery_mailid = 0;
    if (mailid)
    {
        keyQuery_mailid = strdup("mailid");
        valueQuery_mailid = strdup((mailid));
        keyPairQuery_mailid = keyValuePair_create(keyQuery_mailid, valueQuery_mailid);
        list_addElement(localVarQueryParameters,keyPairQuery_mailid);
    }

    // query parameters
    char *keyQuery_skip = NULL;
    char * valueQuery_skip = NULL;
    keyValuePair_t *keyPairQuery_skip = 0;
    if (skip)
    {
        keyQuery_skip = strdup("skip");
        valueQuery_skip = calloc(1,MAX_NUMBER_LENGTH);
        snprintf(valueQuery_skip, MAX_NUMBER_LENGTH, "%d", *skip);
        keyPairQuery_skip = keyValuePair_create(keyQuery_skip, valueQuery_skip);
        list_addElement(localVarQueryParameters,keyPairQuery_skip);
    }

    // query parameters
    char *keyQuery_limit = NULL;
    char * valueQuery_limit = NULL;
    keyValuePair_t *keyPairQuery_limit = 0;
    if (limit)
    {
        keyQuery_limit = strdup("limit");
        valueQuery_limit = calloc(1,MAX_NUMBER_LENGTH);
        snprintf(valueQuery_limit, MAX_NUMBER_LENGTH, "%d", *limit);
        keyPairQuery_limit = keyValuePair_create(keyQuery_limit, valueQuery_limit);
        list_addElement(localVarQueryParameters,keyPairQuery_limit);
    }

    // query parameters
    char *keyQuery_startDate = NULL;
    long valueQuery_startDate ;
    keyValuePair_t *keyPairQuery_startDate = 0;
    if (startDate)
    {
        keyQuery_startDate = strdup("startDate");
        valueQuery_startDate = (startDate);
        keyPairQuery_startDate = keyValuePair_create(keyQuery_startDate, &valueQuery_startDate);
        list_addElement(localVarQueryParameters,keyPairQuery_startDate);
    }

    // query parameters
    char *keyQuery_endDate = NULL;
    long valueQuery_endDate ;
    keyValuePair_t *keyPairQuery_endDate = 0;
    if (endDate)
    {
        keyQuery_endDate = strdup("endDate");
        valueQuery_endDate = (endDate);
        keyPairQuery_endDate = keyValuePair_create(keyQuery_endDate, &valueQuery_endDate);
        list_addElement(localVarQueryParameters,keyPairQuery_endDate);
    }

    // query parameters
    char *keyQuery_replyto = NULL;
    char * valueQuery_replyto = NULL;
    keyValuePair_t *keyPairQuery_replyto = 0;
    if (replyto)
    {
        keyQuery_replyto = strdup("replyto");
        valueQuery_replyto = strdup((replyto));
        keyPairQuery_replyto = keyValuePair_create(keyQuery_replyto, valueQuery_replyto);
        list_addElement(localVarQueryParameters,keyPairQuery_replyto);
    }

    // query parameters
    char *keyQuery_headerfrom = NULL;
    char * valueQuery_headerfrom = NULL;
    keyValuePair_t *keyPairQuery_headerfrom = 0;
    if (headerfrom)
    {
        keyQuery_headerfrom = strdup("headerfrom");
        valueQuery_headerfrom = strdup((headerfrom));
        keyPairQuery_headerfrom = keyValuePair_create(keyQuery_headerfrom, valueQuery_headerfrom);
        list_addElement(localVarQueryParameters,keyPairQuery_headerfrom);
    }

    // query parameters
    char *keyQuery_delivered = NULL;
    mailbaby_email_delivery_and_management_service_api_viewMailLog_delivered_e valueQuery_delivered ;
    keyValuePair_t *keyPairQuery_delivered = 0;
    if (delivered)
    {
        keyQuery_delivered = strdup("delivered");
        valueQuery_delivered = (delivered);
        keyPairQuery_delivered = keyValuePair_create(keyQuery_delivered, strdup(viewMailLog_DELIVERED_ToString(
        valueQuery_delivered)));
        list_addElement(localVarQueryParameters,keyPairQuery_delivered);
    }
    list_addElement(localVarHeaderType,"application/json"); //produces
    apiClient_invoke(apiClient,
                    localVarPath,
                    localVarQueryParameters,
                    localVarHeaderParameters,
                    localVarFormParameters,
                    localVarHeaderType,
                    localVarContentType,
                    localVarBodyParameters,
                    localVarBodyLength,
                    "GET");

    // uncomment below to debug the error response
    //if (apiClient->response_code == 200) {
    //    printf("%s\n","search results matching criteria");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 400) {
    //    printf("%s\n","bad input parameter");
    //}
    //nonprimitive not container
    mail_log_t *elementToReturn = NULL;
    if(apiClient->response_code >= 200 && apiClient->response_code < 300) {
        cJSON *HistoryAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
        elementToReturn = mail_log_parseFromJSON(HistoryAPIlocalVarJSON);
        cJSON_Delete(HistoryAPIlocalVarJSON);
        if(elementToReturn == NULL) {
            // return 0;
        }
    }

    //return type
    if (apiClient->dataReceived) {
        free(apiClient->dataReceived);
        apiClient->dataReceived = NULL;
        apiClient->dataReceivedLen = 0;
    }
    list_freeList(localVarQueryParameters);
    
    
    list_freeList(localVarHeaderType);
    
    free(localVarPath);
    if(keyQuery_id){
        free(keyQuery_id);
        keyQuery_id = NULL;
    }
    if(keyPairQuery_id){
        keyValuePair_free(keyPairQuery_id);
        keyPairQuery_id = NULL;
    }
    if(keyQuery_origin){
        free(keyQuery_origin);
        keyQuery_origin = NULL;
    }
    if(valueQuery_origin){
        free(valueQuery_origin);
        valueQuery_origin = NULL;
    }
    if(keyPairQuery_origin){
        keyValuePair_free(keyPairQuery_origin);
        keyPairQuery_origin = NULL;
    }
    if(keyQuery_mx){
        free(keyQuery_mx);
        keyQuery_mx = NULL;
    }
    if(valueQuery_mx){
        free(valueQuery_mx);
        valueQuery_mx = NULL;
    }
    if(keyPairQuery_mx){
        keyValuePair_free(keyPairQuery_mx);
        keyPairQuery_mx = NULL;
    }
    if(keyQuery_from){
        free(keyQuery_from);
        keyQuery_from = NULL;
    }
    if(valueQuery_from){
        free(valueQuery_from);
        valueQuery_from = NULL;
    }
    if(keyPairQuery_from){
        keyValuePair_free(keyPairQuery_from);
        keyPairQuery_from = NULL;
    }
    if(keyQuery_to){
        free(keyQuery_to);
        keyQuery_to = NULL;
    }
    if(valueQuery_to){
        free(valueQuery_to);
        valueQuery_to = NULL;
    }
    if(keyPairQuery_to){
        keyValuePair_free(keyPairQuery_to);
        keyPairQuery_to = NULL;
    }
    if(keyQuery_subject){
        free(keyQuery_subject);
        keyQuery_subject = NULL;
    }
    if(valueQuery_subject){
        free(valueQuery_subject);
        valueQuery_subject = NULL;
    }
    if(keyPairQuery_subject){
        keyValuePair_free(keyPairQuery_subject);
        keyPairQuery_subject = NULL;
    }
    if(keyQuery_mailid){
        free(keyQuery_mailid);
        keyQuery_mailid = NULL;
    }
    if(valueQuery_mailid){
        free(valueQuery_mailid);
        valueQuery_mailid = NULL;
    }
    if(keyPairQuery_mailid){
        keyValuePair_free(keyPairQuery_mailid);
        keyPairQuery_mailid = NULL;
    }
    if(keyQuery_skip){
        free(keyQuery_skip);
        keyQuery_skip = NULL;
    }
    if(valueQuery_skip){
        free(valueQuery_skip);
        valueQuery_skip = NULL;
    }
    if(keyPairQuery_skip){
        keyValuePair_free(keyPairQuery_skip);
        keyPairQuery_skip = NULL;
    }
    if(keyQuery_limit){
        free(keyQuery_limit);
        keyQuery_limit = NULL;
    }
    if(valueQuery_limit){
        free(valueQuery_limit);
        valueQuery_limit = NULL;
    }
    if(keyPairQuery_limit){
        keyValuePair_free(keyPairQuery_limit);
        keyPairQuery_limit = NULL;
    }
    if(keyQuery_startDate){
        free(keyQuery_startDate);
        keyQuery_startDate = NULL;
    }
    if(keyPairQuery_startDate){
        keyValuePair_free(keyPairQuery_startDate);
        keyPairQuery_startDate = NULL;
    }
    if(keyQuery_endDate){
        free(keyQuery_endDate);
        keyQuery_endDate = NULL;
    }
    if(keyPairQuery_endDate){
        keyValuePair_free(keyPairQuery_endDate);
        keyPairQuery_endDate = NULL;
    }
    if(keyQuery_replyto){
        free(keyQuery_replyto);
        keyQuery_replyto = NULL;
    }
    if(valueQuery_replyto){
        free(valueQuery_replyto);
        valueQuery_replyto = NULL;
    }
    if(keyPairQuery_replyto){
        keyValuePair_free(keyPairQuery_replyto);
        keyPairQuery_replyto = NULL;
    }
    if(keyQuery_headerfrom){
        free(keyQuery_headerfrom);
        keyQuery_headerfrom = NULL;
    }
    if(valueQuery_headerfrom){
        free(valueQuery_headerfrom);
        valueQuery_headerfrom = NULL;
    }
    if(keyPairQuery_headerfrom){
        keyValuePair_free(keyPairQuery_headerfrom);
        keyPairQuery_headerfrom = NULL;
    }
    if(keyQuery_delivered){
        free(keyQuery_delivered);
        keyQuery_delivered = NULL;
    }
    if(keyPairQuery_delivered){
        keyValuePair_free(keyPairQuery_delivered);
        keyPairQuery_delivered = NULL;
    }
    return elementToReturn;
end:
    free(localVarPath);
    return NULL;

}

