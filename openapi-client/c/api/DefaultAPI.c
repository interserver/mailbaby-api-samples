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
    list_t *localVarHeaderType = list_create();
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail");



    list_addElement(localVarHeaderType,"application/json"); //produces
    list_addElement(localVarHeaderType,"application/xml"); //produces
    list_addElement(localVarHeaderType,"text/plain"); //produces
    apiClient_invoke(apiClient,
                    localVarPath,
                    localVarQueryParameters,
                    localVarHeaderParameters,
                    localVarFormParameters,
                    localVarHeaderType,
                    localVarContentType,
                    localVarBodyParameters,
                    "GET");

    if (apiClient->response_code == 200) {
        printf("%s\n","OK");
    }
    if (apiClient->response_code == 401) {
        printf("%s\n","Unauthorized");
    }
    if (apiClient->response_code == 404) {
        printf("%s\n","Unauthorized");
    }
    cJSON *DefaultAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    if(!cJSON_IsArray(DefaultAPIlocalVarJSON)) {
        return 0;//nonprimitive container
    }
    list_t *elementToReturn = list_create();
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
    
    
    
    list_free(localVarHeaderType);
    
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

    if (apiClient->response_code == 200) {
        printf("%s\n","Server is up and running");
    }
    if (apiClient->response_code == 0) {
        printf("%s\n","Something is wrong");
    }
    //No return type
end:
    if (apiClient->dataReceived) {
        free(apiClient->dataReceived);
        apiClient->dataReceived = NULL;
        apiClient->dataReceivedLen = 0;
    }
    
    
    
    
    
    free(localVarPath);

}

// places a mail order
//
// Adds an item to the system
//
void
DefaultAPI_placeMailOrder(apiClient_t *apiClient, mail_order_t * mail_order )
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_create();
    list_t *localVarContentType = list_create();
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail/order")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail/order");




    // Body Param
    cJSON *localVarSingleItemJSON_mail_order = NULL;
    if (mail_order != NULL)
    {
        //string
        localVarSingleItemJSON_mail_order = mail_order_convertToJSON(mail_order);
        localVarBodyParameters = cJSON_Print(localVarSingleItemJSON_mail_order);
    }
    list_addElement(localVarHeaderType,"application/json"); //produces
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

    if (apiClient->response_code == 200) {
        printf("%s\n","list of mail orders");
    }
    if (apiClient->response_code == 400) {
        printf("%s\n","The specified resource was not found");
    }
    if (apiClient->response_code == 409) {
        printf("%s\n","The specified resource was not found");
    }
    if (apiClient->response_code == 401) {
        printf("%s\n","Unauthorized");
    }
    //No return type
end:
    if (apiClient->dataReceived) {
        free(apiClient->dataReceived);
        apiClient->dataReceived = NULL;
        apiClient->dataReceivedLen = 0;
    }
    
    
    
    list_free(localVarHeaderType);
    list_free(localVarContentType);
    free(localVarPath);
    if (localVarSingleItemJSON_mail_order) {
        cJSON_Delete(localVarSingleItemJSON_mail_order);
        localVarSingleItemJSON_mail_order = NULL;
    }
    free(localVarBodyParameters);

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
    list_t *localVarHeaderType = list_create();
    list_t *localVarContentType = list_create();
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

    if (apiClient->response_code == 200) {
        printf("%s\n","search results matching criteria");
    }
    if (apiClient->response_code == 400) {
        printf("%s\n","The specified resource was not found");
    }
    if (apiClient->response_code == 401) {
        printf("%s\n","Unauthorized");
    }
    if (apiClient->response_code == 404) {
        printf("%s\n","The specified resource was not found");
    }
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
    
    
    
    list_free(localVarHeaderType);
    list_free(localVarContentType);
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
// Sends An email through one of your mail orders.
//
generic_response_t*
DefaultAPI_sendMail(apiClient_t *apiClient, char * to , char * from , char * subject , char * body )
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = list_create();
    list_t *localVarHeaderType = list_create();
    list_t *localVarContentType = list_create();
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

    if (apiClient->response_code == 200) {
        printf("%s\n","search results matching criteria");
    }
    if (apiClient->response_code == 400) {
        printf("%s\n","The specified resource was not found");
    }
    if (apiClient->response_code == 401) {
        printf("%s\n","Unauthorized");
    }
    if (apiClient->response_code == 404) {
        printf("%s\n","The specified resource was not found");
    }
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
    
    
    list_free(localVarFormParameters);
    list_free(localVarHeaderType);
    list_free(localVarContentType);
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

// validatess order details before placing an order
//
void
DefaultAPI_validateMailOrder(apiClient_t *apiClient)
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_create();
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail/order")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail/order");



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

    if (apiClient->response_code == 200) {
        printf("%s\n","list of mail orders");
    }
    if (apiClient->response_code == 401) {
        printf("%s\n","Unauthorized");
    }
    //No return type
end:
    if (apiClient->dataReceived) {
        free(apiClient->dataReceived);
        apiClient->dataReceived = NULL;
        apiClient->dataReceivedLen = 0;
    }
    
    
    
    list_free(localVarHeaderType);
    
    free(localVarPath);

}

// displays the mail log
//
// By passing in the appropriate options, you can search for available inventory in the system 
//
list_t*
DefaultAPI_viewMailLog(apiClient_t *apiClient, long id , char * searchString , int skip , int limit )
{
    list_t    *localVarQueryParameters = list_create();
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_create();
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
    char *keyQuery_searchString = NULL;
    char * valueQuery_searchString = NULL;
    keyValuePair_t *keyPairQuery_searchString = 0;
    if (searchString)
    {
        keyQuery_searchString = strdup("searchString");
        valueQuery_searchString = strdup((searchString));
        keyPairQuery_searchString = keyValuePair_create(keyQuery_searchString, valueQuery_searchString);
        list_addElement(localVarQueryParameters,keyPairQuery_searchString);
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

    if (apiClient->response_code == 200) {
        printf("%s\n","search results matching criteria");
    }
    if (apiClient->response_code == 400) {
        printf("%s\n","bad input parameter");
    }
    cJSON *DefaultAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    if(!cJSON_IsArray(DefaultAPIlocalVarJSON)) {
        return 0;//nonprimitive container
    }
    list_t *elementToReturn = list_create();
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
    list_free(localVarQueryParameters);
    
    
    list_free(localVarHeaderType);
    
    free(localVarPath);
    if(keyQuery_id){
        free(keyQuery_id);
        keyQuery_id = NULL;
    }
    if(keyPairQuery_id){
        keyValuePair_free(keyPairQuery_id);
        keyPairQuery_id = NULL;
    }
    if(keyQuery_searchString){
        free(keyQuery_searchString);
        keyQuery_searchString = NULL;
    }
    if(valueQuery_searchString){
        free(valueQuery_searchString);
        valueQuery_searchString = NULL;
    }
    if(keyPairQuery_searchString){
        keyValuePair_free(keyPairQuery_searchString);
        keyPairQuery_searchString = NULL;
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
    return elementToReturn;
end:
    free(localVarPath);
    return NULL;

}

