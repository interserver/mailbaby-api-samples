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


// Gets mail order information by id
//
// returns information about a mail order in the system with the given id.
//
mail_order_t*
DefaultAPI_getMailById(apiClient_t *apiClient, long id )
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_create();
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail/{id}")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail/{id}");


    // Path Params
    long sizeOfPathParams_id = sizeof(id)+3 + strlen("{ id }");
    if(id == 0){
        goto end;
    }
    char* localVarToReplace_id = malloc(sizeOfPathParams_id);
    snprintf(localVarToReplace_id, sizeOfPathParams_id, "{%s}", "id");

    char localVarBuff_id[256];
    intToStr(localVarBuff_id, id);

    localVarPath = strReplace(localVarPath, localVarToReplace_id, localVarBuff_id);



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
        printf("%s\n","Successful operation");
    }
    //nonprimitive not container
    cJSON *DefaultAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    mail_order_t *elementToReturn = mail_order_parseFromJSON(DefaultAPIlocalVarJSON);
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
    
    free(localVarPath);
    free(localVarToReplace_id);
    return elementToReturn;
end:
    free(localVarPath);
    return NULL;

}

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
        printf("%s\n","invalid input, object invalid");
    }
    if (apiClient->response_code == 409) {
        printf("%s\n","an existing item already exists");
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
DefaultAPI_sendAdvMailById(apiClient_t *apiClient, long id , send_mail_t * send_mail )
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_create();
    list_t *localVarContentType = list_create();
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail/{id}/advsend")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail/{id}/advsend");


    // Path Params
    long sizeOfPathParams_id = sizeof(id)+3 + strlen("{ id }");
    if(id == 0){
        goto end;
    }
    char* localVarToReplace_id = malloc(sizeOfPathParams_id);
    snprintf(localVarToReplace_id, sizeOfPathParams_id, "{%s}", "id");

    char localVarBuff_id[256];
    intToStr(localVarBuff_id, id);

    localVarPath = strReplace(localVarPath, localVarToReplace_id, localVarBuff_id);




    // Body Param
    cJSON *localVarSingleItemJSON_send_mail = NULL;
    if (send_mail != NULL)
    {
        //string
        localVarSingleItemJSON_send_mail = send_mail_convertToJSON(send_mail);
        localVarBodyParameters = cJSON_Print(localVarSingleItemJSON_send_mail);
    }
    list_addElement(localVarHeaderType,"application/json"); //produces
    list_addElement(localVarContentType,"application/json"); //consumes
    list_addElement(localVarContentType,"application/xml"); //consumes
    list_addElement(localVarContentType,"application/x-www-form-urlencoded"); //consumes
    list_addElement(localVarContentType,"text/plain"); //consumes
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
        printf("%s\n","bad input parameter");
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
    free(localVarToReplace_id);
    if (localVarSingleItemJSON_send_mail) {
        cJSON_Delete(localVarSingleItemJSON_send_mail);
        localVarSingleItemJSON_send_mail = NULL;
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
DefaultAPI_sendMailById(apiClient_t *apiClient, long id , char * subject , char * body , char * to , char * toName , char * from , char * fromName )
{
    list_t    *localVarQueryParameters = list_create();
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_create();
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail/{id}/send")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail/{id}/send");


    // Path Params
    long sizeOfPathParams_id = sizeof(id)+3 + strlen("{ id }");
    if(id == 0){
        goto end;
    }
    char* localVarToReplace_id = malloc(sizeOfPathParams_id);
    snprintf(localVarToReplace_id, sizeOfPathParams_id, "{%s}", "id");

    char localVarBuff_id[256];
    intToStr(localVarBuff_id, id);

    localVarPath = strReplace(localVarPath, localVarToReplace_id, localVarBuff_id);




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
    char *keyQuery_body = NULL;
    char * valueQuery_body = NULL;
    keyValuePair_t *keyPairQuery_body = 0;
    if (body)
    {
        keyQuery_body = strdup("body");
        valueQuery_body = strdup((body));
        keyPairQuery_body = keyValuePair_create(keyQuery_body, valueQuery_body);
        list_addElement(localVarQueryParameters,keyPairQuery_body);
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
    char *keyQuery_toName = NULL;
    char * valueQuery_toName = NULL;
    keyValuePair_t *keyPairQuery_toName = 0;
    if (toName)
    {
        keyQuery_toName = strdup("toName");
        valueQuery_toName = strdup((toName));
        keyPairQuery_toName = keyValuePair_create(keyQuery_toName, valueQuery_toName);
        list_addElement(localVarQueryParameters,keyPairQuery_toName);
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
    char *keyQuery_fromName = NULL;
    char * valueQuery_fromName = NULL;
    keyValuePair_t *keyPairQuery_fromName = 0;
    if (fromName)
    {
        keyQuery_fromName = strdup("fromName");
        valueQuery_fromName = strdup((fromName));
        keyPairQuery_fromName = keyValuePair_create(keyQuery_fromName, valueQuery_fromName);
        list_addElement(localVarQueryParameters,keyPairQuery_fromName);
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
                    "POST");

    if (apiClient->response_code == 200) {
        printf("%s\n","search results matching criteria");
    }
    if (apiClient->response_code == 400) {
        printf("%s\n","bad input parameter");
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
    list_free(localVarQueryParameters);
    
    
    list_free(localVarHeaderType);
    
    free(localVarPath);
    free(localVarToReplace_id);
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
    if(keyQuery_body){
        free(keyQuery_body);
        keyQuery_body = NULL;
    }
    if(valueQuery_body){
        free(valueQuery_body);
        valueQuery_body = NULL;
    }
    if(keyPairQuery_body){
        keyValuePair_free(keyPairQuery_body);
        keyPairQuery_body = NULL;
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
    if(keyQuery_toName){
        free(keyQuery_toName);
        keyQuery_toName = NULL;
    }
    if(valueQuery_toName){
        free(valueQuery_toName);
        valueQuery_toName = NULL;
    }
    if(keyPairQuery_toName){
        keyValuePair_free(keyPairQuery_toName);
        keyPairQuery_toName = NULL;
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
    if(keyQuery_fromName){
        free(keyQuery_fromName);
        keyQuery_fromName = NULL;
    }
    if(valueQuery_fromName){
        free(valueQuery_fromName);
        valueQuery_fromName = NULL;
    }
    if(keyPairQuery_fromName){
        keyValuePair_free(keyPairQuery_fromName);
        keyPairQuery_fromName = NULL;
    }
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
DefaultAPI_viewMailLogById(apiClient_t *apiClient, long id , char * searchString , int skip , int limit )
{
    list_t    *localVarQueryParameters = list_create();
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_create();
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail/{id}/log")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail/{id}/log");


    // Path Params
    long sizeOfPathParams_id = sizeof(id)+3 + strlen("{ id }");
    if(id == 0){
        goto end;
    }
    char* localVarToReplace_id = malloc(sizeOfPathParams_id);
    snprintf(localVarToReplace_id, sizeOfPathParams_id, "{%s}", "id");

    char localVarBuff_id[256];
    intToStr(localVarBuff_id, id);

    localVarPath = strReplace(localVarPath, localVarToReplace_id, localVarBuff_id);




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
    free(localVarToReplace_id);
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

