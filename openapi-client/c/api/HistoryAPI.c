#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#include "HistoryAPI.h"

#define MAX_NUMBER_LENGTH 16
#define MAX_BUFFER_LENGTH 4096
#define intToStr(dst, src) \
    do {\
    char dst[256];\
    snprintf(dst, 256, "%ld", (long int)(src));\
}while(0)


// displays a list of blocked email addresses
//
list_t*
HistoryAPI_getStats(apiClient_t *apiClient)
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_createList();
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail/stats")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail/stats");



    list_addElement(localVarHeaderType,"application/json"); //produces
    apiClient_invoke(apiClient,
                    localVarPath,
                    localVarQueryParameters,
                    localVarHeaderParameters,
                    localVarFormParameters,
                    localVarHeaderType,
                    localVarContentType,
                    localVarBodyParameters,
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
    cJSON *HistoryAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    if(!cJSON_IsArray(HistoryAPIlocalVarJSON)) {
        return 0;//nonprimitive container
    }
    list_t *elementToReturn = list_createList();
    cJSON *VarJSON;
    cJSON_ArrayForEach(VarJSON, HistoryAPIlocalVarJSON)
    {
        if(!cJSON_IsObject(VarJSON))
        {
           // return 0;
        }
        char *localVarJSONToChar = cJSON_Print(VarJSON);
        list_addElement(elementToReturn , localVarJSONToChar);
    }

    cJSON_Delete( HistoryAPIlocalVarJSON);
    cJSON_Delete( VarJSON);
    //return type
    if (apiClient->dataReceived) {
        free(apiClient->dataReceived);
        apiClient->dataReceived = NULL;
        apiClient->dataReceivedLen = 0;
    }
    
    
    
    list_freeList(localVarHeaderType);
    
    free(localVarPath);
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
HistoryAPI_viewMailLog(apiClient_t *apiClient, long id , char * origin , char * mx , char * from , char * to , char * subject , char * mailid , int skip , int limit , long startDate , long endDate )
{
    list_t    *localVarQueryParameters = list_createList();
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_createList();
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail/log")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail/log");




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
    if (1) // Always send integer parameters to the API server
    {
        keyQuery_skip = strdup("skip");
        valueQuery_skip = calloc(1,MAX_NUMBER_LENGTH);
        snprintf(valueQuery_skip, MAX_NUMBER_LENGTH, "%d", skip);
        keyPairQuery_skip = keyValuePair_create(keyQuery_skip, valueQuery_skip);
        list_addElement(localVarQueryParameters,keyPairQuery_skip);
    }

    // query parameters
    char *keyQuery_limit = NULL;
    char * valueQuery_limit = NULL;
    keyValuePair_t *keyPairQuery_limit = 0;
    if (1) // Always send integer parameters to the API server
    {
        keyQuery_limit = strdup("limit");
        valueQuery_limit = calloc(1,MAX_NUMBER_LENGTH);
        snprintf(valueQuery_limit, MAX_NUMBER_LENGTH, "%d", limit);
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
    list_addElement(localVarHeaderType,"application/json"); //produces
    apiClient_invoke(apiClient,
                    localVarPath,
                    localVarQueryParameters,
                    localVarHeaderParameters,
                    localVarFormParameters,
                    localVarHeaderType,
                    localVarContentType,
                    localVarBodyParameters,
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
    cJSON *HistoryAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    mail_log_t *elementToReturn = mail_log_parseFromJSON(HistoryAPIlocalVarJSON);
    cJSON_Delete(HistoryAPIlocalVarJSON);
    if(elementToReturn == NULL) {
        // return 0;
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
    return elementToReturn;
end:
    free(localVarPath);
    return NULL;

}

