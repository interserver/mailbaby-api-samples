#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#include "DefaultAPI.h"

#define MAX_NUMBER_LENGTH 16
#define MAX_BUFFER_LENGTH 4096
#define intToStr(dst, src) \
    do {\
    char dst[256];\
    snprintf(dst, 256, "%ld", (long int)(src));\
}while(0)


// displays a list of mail service orders
//
list_t*
DefaultAPI_getMailOrders(apiClient_t *apiClient)
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_createList();
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail");



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
    cJSON *DefaultAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    if(!cJSON_IsArray(DefaultAPIlocalVarJSON)) {
        return 0;//nonprimitive container
    }
    list_t *elementToReturn = list_createList();
    cJSON *VarJSON;
    cJSON_ArrayForEach(VarJSON, DefaultAPIlocalVarJSON)
    {
        if(!cJSON_IsObject(VarJSON))
        {
           // return 0;
        }
        char *localVarJSONToChar = cJSON_Print(VarJSON);
        list_addElement(elementToReturn , localVarJSONToChar);
    }

    cJSON_Delete( DefaultAPIlocalVarJSON);
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

// Checks if the server is running
//
void
DefaultAPI_pingServer(apiClient_t *apiClient)
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = NULL;
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/ping")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/ping");



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
    //    printf("%s\n","Server is up and running");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 0) {
    //    printf("%s\n","Something is wrong");
    //}
    //No return type
end:
    if (apiClient->dataReceived) {
        free(apiClient->dataReceived);
        apiClient->dataReceived = NULL;
        apiClient->dataReceivedLen = 0;
    }
    
    
    
    
    
    free(localVarPath);

}

// Sends an Email with Advanced Options
//
// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
//
generic_response_t*
DefaultAPI_sendAdvMail(apiClient_t *apiClient, send_mail_adv_t * send_mail_adv )
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_createList();
    list_t *localVarContentType = list_createList();
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail/advsend")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail/advsend");




    // Body Param
    cJSON *localVarSingleItemJSON_send_mail_adv = NULL;
    if (send_mail_adv != NULL)
    {
        //string
        localVarSingleItemJSON_send_mail_adv = send_mail_adv_convertToJSON(send_mail_adv);
        localVarBodyParameters = cJSON_Print(localVarSingleItemJSON_send_mail_adv);
    }
    list_addElement(localVarHeaderType,"application/json"); //produces
    list_addElement(localVarContentType,"application/json"); //consumes
    list_addElement(localVarContentType,"application/x-www-form-urlencoded"); //consumes
    apiClient_invoke(apiClient,
                    localVarPath,
                    localVarQueryParameters,
                    localVarHeaderParameters,
                    localVarFormParameters,
                    localVarHeaderType,
                    localVarContentType,
                    localVarBodyParameters,
                    "POST");

    // uncomment below to debug the error response
    //if (apiClient->response_code == 200) {
    //    printf("%s\n","search results matching criteria");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 400) {
    //    printf("%s\n","The specified resource was not found");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 401) {
    //    printf("%s\n","Unauthorized");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 404) {
    //    printf("%s\n","The specified resource was not found");
    //}
    //nonprimitive not container
    cJSON *DefaultAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    generic_response_t *elementToReturn = generic_response_parseFromJSON(DefaultAPIlocalVarJSON);
    cJSON_Delete(DefaultAPIlocalVarJSON);
    if(elementToReturn == NULL) {
        // return 0;
    }

    //return type
    if (apiClient->dataReceived) {
        free(apiClient->dataReceived);
        apiClient->dataReceived = NULL;
        apiClient->dataReceivedLen = 0;
    }
    
    
    
    list_freeList(localVarHeaderType);
    list_freeList(localVarContentType);
    free(localVarPath);
    if (localVarSingleItemJSON_send_mail_adv) {
        cJSON_Delete(localVarSingleItemJSON_send_mail_adv);
        localVarSingleItemJSON_send_mail_adv = NULL;
    }
    free(localVarBodyParameters);
    return elementToReturn;
end:
    free(localVarPath);
    return NULL;

}

// Sends an Email
//
// Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
//
generic_response_t*
DefaultAPI_sendMail(apiClient_t *apiClient, char * to , char * from , char * subject , char * body )
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = list_createList();
    list_t *localVarHeaderType = list_createList();
    list_t *localVarContentType = list_createList();
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail/send")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail/send");




    // form parameters
    char *keyForm_to = NULL;
    char * valueForm_to = 0;
    keyValuePair_t *keyPairForm_to = 0;
    if (to != NULL)
    {
        keyForm_to = strdup("to");
        valueForm_to = strdup((to));
        keyPairForm_to = keyValuePair_create(keyForm_to,valueForm_to);
        list_addElement(localVarFormParameters,keyPairForm_to);
    }

    // form parameters
    char *keyForm_from = NULL;
    char * valueForm_from = 0;
    keyValuePair_t *keyPairForm_from = 0;
    if (from != NULL)
    {
        keyForm_from = strdup("from");
        valueForm_from = strdup((from));
        keyPairForm_from = keyValuePair_create(keyForm_from,valueForm_from);
        list_addElement(localVarFormParameters,keyPairForm_from);
    }

    // form parameters
    char *keyForm_subject = NULL;
    char * valueForm_subject = 0;
    keyValuePair_t *keyPairForm_subject = 0;
    if (subject != NULL)
    {
        keyForm_subject = strdup("subject");
        valueForm_subject = strdup((subject));
        keyPairForm_subject = keyValuePair_create(keyForm_subject,valueForm_subject);
        list_addElement(localVarFormParameters,keyPairForm_subject);
    }

    // form parameters
    char *keyForm_body = NULL;
    char * valueForm_body = 0;
    keyValuePair_t *keyPairForm_body = 0;
    if (body != NULL)
    {
        keyForm_body = strdup("body");
        valueForm_body = strdup((body));
        keyPairForm_body = keyValuePair_create(keyForm_body,valueForm_body);
        list_addElement(localVarFormParameters,keyPairForm_body);
    }
    list_addElement(localVarHeaderType,"application/json"); //produces
    list_addElement(localVarContentType,"application/x-www-form-urlencoded"); //consumes
    list_addElement(localVarContentType,"application/json"); //consumes
    apiClient_invoke(apiClient,
                    localVarPath,
                    localVarQueryParameters,
                    localVarHeaderParameters,
                    localVarFormParameters,
                    localVarHeaderType,
                    localVarContentType,
                    localVarBodyParameters,
                    "POST");

    // uncomment below to debug the error response
    //if (apiClient->response_code == 200) {
    //    printf("%s\n","search results matching criteria");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 400) {
    //    printf("%s\n","The specified resource was not found");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 401) {
    //    printf("%s\n","Unauthorized");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 404) {
    //    printf("%s\n","The specified resource was not found");
    //}
    //nonprimitive not container
    cJSON *DefaultAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    generic_response_t *elementToReturn = generic_response_parseFromJSON(DefaultAPIlocalVarJSON);
    cJSON_Delete(DefaultAPIlocalVarJSON);
    if(elementToReturn == NULL) {
        // return 0;
    }

    //return type
    if (apiClient->dataReceived) {
        free(apiClient->dataReceived);
        apiClient->dataReceived = NULL;
        apiClient->dataReceivedLen = 0;
    }
    
    
    list_freeList(localVarFormParameters);
    list_freeList(localVarHeaderType);
    list_freeList(localVarContentType);
    free(localVarPath);
    if (keyForm_to) {
        free(keyForm_to);
        keyForm_to = NULL;
    }
    if (valueForm_to) {
        free(valueForm_to);
        valueForm_to = NULL;
    }
    free(keyPairForm_to);
    if (keyForm_from) {
        free(keyForm_from);
        keyForm_from = NULL;
    }
    if (valueForm_from) {
        free(valueForm_from);
        valueForm_from = NULL;
    }
    free(keyPairForm_from);
    if (keyForm_subject) {
        free(keyForm_subject);
        keyForm_subject = NULL;
    }
    if (valueForm_subject) {
        free(valueForm_subject);
        valueForm_subject = NULL;
    }
    free(keyPairForm_subject);
    if (keyForm_body) {
        free(keyForm_body);
        keyForm_body = NULL;
    }
    if (valueForm_body) {
        free(valueForm_body);
        valueForm_body = NULL;
    }
    free(keyPairForm_body);
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
DefaultAPI_viewMailLog(apiClient_t *apiClient, long id , char * origin , char * mx , char * from , char * to , char * subject , char * mailid , int skip , int limit , long startDate , long endDate )
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
    if (skip)
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
    if (limit)
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
    cJSON *DefaultAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    mail_log_t *elementToReturn = mail_log_parseFromJSON(DefaultAPIlocalVarJSON);
    cJSON_Delete(DefaultAPIlocalVarJSON);
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

