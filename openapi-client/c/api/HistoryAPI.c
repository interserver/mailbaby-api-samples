#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>

#include "HistoryAPI.h"

#define MAX_NUMBER_LENGTH 16
#define MAX_BUFFER_LENGTH 4096
#define MAX_NUMBER_LENGTH_LONG 21

// Functions for enum TIME for HistoryAPI_getStats

static char* getStats_TIME_ToString(mailbaby_email_delivery_and_management_service_api_getStats_time_e TIME){
    char *TIMEArray[] =  { "NULL", "all", "billing", "month", "7d", "24h", "day", "1h" };
    return TIMEArray[TIME];
}

static mailbaby_email_delivery_and_management_service_api_getStats_time_e getStats_TIME_FromString(char* TIME){
    int stringToReturn = 0;
    char *TIMEArray[] =  { "NULL", "all", "billing", "month", "7d", "24h", "day", "1h" };
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
    return DELIVEREDVariable;
end:
    return 0;
}
*/


// Account usage statistics
//
// Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.  The response includes: - **`usage`** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **`cost`** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **`received`** / **`sent`** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected `time` window. - **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),   destination address (`to`), and sender address (`from`) within the selected window.   **Time windows** (controlled by the `time` parameter): | Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time | 
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
    //    printf("%s\n","Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).");
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

// Displays the mail log
//
// Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.  **Pagination** is controlled by `skip` and `limit`.  The response includes a `total` count so clients can determine how many pages exist.  **Date filtering** uses Unix timestamps (`startDate` / `endDate`).  For example, to retrieve emails sent in January 2024: `startDate=1704067200&endDate=1706745599`.  **Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.  The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.  The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match). 
//
mail_log_t*
HistoryAPI_viewMailLog(apiClient_t *apiClient, long id, char *origin, char *mx, char *from, char *to, char *subject, char *mailid, char *messageId, char *replyto, char *headerfrom, int *delivered, int *skip, int *limit, long startDate, long endDate)
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
    char * valueQuery_id ;
    keyValuePair_t *keyPairQuery_id = 0;
    {
        keyQuery_id = strdup("id");
        valueQuery_id = calloc(1,MAX_NUMBER_LENGTH_LONG);
        snprintf(valueQuery_id, MAX_NUMBER_LENGTH_LONG, "%d", id);
        keyPairQuery_id = keyValuePair_create(keyQuery_id, valueQuery_id);
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
    char *keyQuery_messageId = NULL;
    char * valueQuery_messageId = NULL;
    keyValuePair_t *keyPairQuery_messageId = 0;
    if (messageId)
    {
        keyQuery_messageId = strdup("messageId");
        valueQuery_messageId = strdup((messageId));
        keyPairQuery_messageId = keyValuePair_create(keyQuery_messageId, valueQuery_messageId);
        list_addElement(localVarQueryParameters,keyPairQuery_messageId);
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
    char * valueQuery_delivered = NULL;
    keyValuePair_t *keyPairQuery_delivered = 0;
    if (delivered)
    {
        keyQuery_delivered = strdup("delivered");
        valueQuery_delivered = calloc(1,MAX_NUMBER_LENGTH);
        snprintf(valueQuery_delivered, MAX_NUMBER_LENGTH, "%d", *delivered);
        keyPairQuery_delivered = keyValuePair_create(keyQuery_delivered, strdup(viewMailLog_DELIVERED_ToString(
        valueQuery_delivered)));
        list_addElement(localVarQueryParameters,keyPairQuery_delivered);
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
    char * valueQuery_startDate ;
    keyValuePair_t *keyPairQuery_startDate = 0;
    {
        keyQuery_startDate = strdup("startDate");
        valueQuery_startDate = calloc(1,MAX_NUMBER_LENGTH_LONG);
        snprintf(valueQuery_startDate, MAX_NUMBER_LENGTH_LONG, "%d", startDate);
        keyPairQuery_startDate = keyValuePair_create(keyQuery_startDate, valueQuery_startDate);
        list_addElement(localVarQueryParameters,keyPairQuery_startDate);
    }

    // query parameters
    char *keyQuery_endDate = NULL;
    char * valueQuery_endDate ;
    keyValuePair_t *keyPairQuery_endDate = 0;
    {
        keyQuery_endDate = strdup("endDate");
        valueQuery_endDate = calloc(1,MAX_NUMBER_LENGTH_LONG);
        snprintf(valueQuery_endDate, MAX_NUMBER_LENGTH_LONG, "%d", endDate);
        keyPairQuery_endDate = keyValuePair_create(keyQuery_endDate, valueQuery_endDate);
        list_addElement(localVarQueryParameters,keyPairQuery_endDate);
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
    //    printf("%s\n","Paginated list of mail log entries");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 400) {
    //    printf("%s\n","Bad request — one or more input parameters were missing or invalid.");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 401) {
    //    printf("%s\n","Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).");
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
    if(keyQuery_messageId){
        free(keyQuery_messageId);
        keyQuery_messageId = NULL;
    }
    if(valueQuery_messageId){
        free(valueQuery_messageId);
        valueQuery_messageId = NULL;
    }
    if(keyPairQuery_messageId){
        keyValuePair_free(keyPairQuery_messageId);
        keyPairQuery_messageId = NULL;
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
    if(valueQuery_delivered){
        free(valueQuery_delivered);
        valueQuery_delivered = NULL;
    }
    if(keyPairQuery_delivered){
        keyValuePair_free(keyPairQuery_delivered);
        keyPairQuery_delivered = NULL;
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
    return elementToReturn;
end:
    free(localVarPath);
    return NULL;

}

