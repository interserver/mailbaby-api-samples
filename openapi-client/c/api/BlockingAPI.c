#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#include "BlockingAPI.h"

#define MAX_NUMBER_LENGTH 16
#define MAX_BUFFER_LENGTH 4096
#define intToStr(dst, src) \
    do {\
    char dst[256];\
    snprintf(dst, 256, "%ld", (long int)(src));\
}while(0)

// Functions for enum TYPE for BlockingAPI_addRule

static char* addRule_TYPE_ToString(mailbaby_email_delivery_and_management_service_api_addRule_type_e TYPE){
    char *TYPEArray[] =  { "NULL", "domain", "email", "startswith" };
    return TYPEArray[TYPE];
}

static mailbaby_email_delivery_and_management_service_api_addRule_type_e addRule_TYPE_FromString(char* TYPE){
    int stringToReturn = 0;
    char *TYPEArray[] =  { "NULL", "domain", "email", "startswith" };
    size_t sizeofArray = sizeof(TYPEArray) / sizeof(TYPEArray[0]);
    while(stringToReturn < sizeofArray) {
        if(strcmp(TYPE, TYPEArray[stringToReturn]) == 0) {
            return stringToReturn;
        }
        stringToReturn++;
    }
    return 0;
}

/*
// Function addRule_TYPE_convertToJSON is not currently used,
// since conversion to JSON passes through the conversion of the model, and ToString. The function is kept for future reference.
//
static cJSON *addRule_TYPE_convertToJSON(mailbaby_email_delivery_and_management_service_api_addRule_type_e TYPE) {
    cJSON *item = cJSON_CreateObject();
    if(cJSON_AddStringToObject(item, "type", addRule_TYPE_ToString(TYPE)) == NULL) {
        goto fail;
    }
    return item;
    fail:
    cJSON_Delete(item);
    return NULL;
}

// Function addRule_TYPE_parseFromJSON is not currently used,
// since conversion from JSON passes through the conversion of the model, and FromString. The function is kept for future reference.
//
static mailbaby_email_delivery_and_management_service_api_addRule_type_e addRule_TYPE_parseFromJSON(cJSON* TYPEJSON) {
    mailbaby_email_delivery_and_management_service_api_addRule_type_e TYPEVariable = 0;
    cJSON *TYPEVar = cJSON_GetObjectItemCaseSensitive(TYPEJSON, "type");
    if(!cJSON_IsString(TYPEVar) || (TYPEVar->valuestring == NULL))
    {
        goto end;
    }
    TYPEVariable = addRule_TYPE_FromString(TYPEVar->valuestring);
    return TYPEVariable;
end:
    return 0;
}
*/


// Creates a new email deny rule.
//
// Adds a new email deny rule into the system to block new emails that match the given criteria
//
generic_response_t*
BlockingAPI_addRule(apiClient_t *apiClient, mailbaby_email_delivery_and_management_service_api_addRule_type_e type , char * data , char * user )
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = list_createList();
    list_t *localVarHeaderType = list_createList();
    list_t *localVarContentType = list_createList();
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail/rules")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail/rules");




    // form parameters
    char *keyForm_user = NULL;
    char * valueForm_user = 0;
    keyValuePair_t *keyPairForm_user = 0;
    if (user != NULL)
    {
        keyForm_user = strdup("user");
        valueForm_user = strdup((user));
        keyPairForm_user = keyValuePair_create(keyForm_user,valueForm_user);
        list_addElement(localVarFormParameters,keyPairForm_user);
    }

    // form parameters
    char *keyForm_type = NULL;
    mailbaby_email_delivery_and_management_service_api_addRule_type_e valueForm_type = 0;
    keyValuePair_t *keyPairForm_type = 0;
    if (type != NULL)
    {
        keyForm_type = strdup("type");
        valueForm_type = (type);
        keyPairForm_type = keyValuePair_create(keyForm_type,(void *)valueForm_type);
        list_addElement(localVarFormParameters,keyPairForm_type);
    }

    // form parameters
    char *keyForm_data = NULL;
    char * valueForm_data = 0;
    keyValuePair_t *keyPairForm_data = 0;
    if (data != NULL)
    {
        keyForm_data = strdup("data");
        valueForm_data = strdup((data));
        keyPairForm_data = keyValuePair_create(keyForm_data,valueForm_data);
        list_addElement(localVarFormParameters,keyPairForm_data);
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
    cJSON *BlockingAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    generic_response_t *elementToReturn = generic_response_parseFromJSON(BlockingAPIlocalVarJSON);
    cJSON_Delete(BlockingAPIlocalVarJSON);
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
    if (keyForm_user) {
        free(keyForm_user);
        keyForm_user = NULL;
    }
    if (valueForm_user) {
        free(valueForm_user);
        valueForm_user = NULL;
    }
    free(keyPairForm_user);
    if (keyForm_type) {
        free(keyForm_type);
        keyForm_type = NULL;
    }
    if (valueForm_type) {
        free(valueForm_type);
        valueForm_type = NULL;
    }
    free(keyPairForm_type);
    if (keyForm_data) {
        free(keyForm_data);
        keyForm_data = NULL;
    }
    if (valueForm_data) {
        free(valueForm_data);
        valueForm_data = NULL;
    }
    free(keyPairForm_data);
    return elementToReturn;
end:
    free(localVarPath);
    return NULL;

}

// Removes an deny mail rule.
//
// Removes one of the configured deny mail rules from the system.
//
generic_response_t*
BlockingAPI_deleteRule(apiClient_t *apiClient, int ruleId )
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_createList();
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail/rules/{ruleId}")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail/rules/{ruleId}");


    // Path Params
    long sizeOfPathParams_ruleId =  + strlen("{ ruleId }");
    if(ruleId == 0){
        goto end;
    }
    char* localVarToReplace_ruleId = malloc(sizeOfPathParams_ruleId);
    snprintf(localVarToReplace_ruleId, sizeOfPathParams_ruleId, "{%s}", "ruleId");

    char localVarBuff_ruleId[256];
    intToStr(localVarBuff_ruleId, ruleId);

    localVarPath = strReplace(localVarPath, localVarToReplace_ruleId, localVarBuff_ruleId);



    list_addElement(localVarHeaderType,"application/json"); //produces
    apiClient_invoke(apiClient,
                    localVarPath,
                    localVarQueryParameters,
                    localVarHeaderParameters,
                    localVarFormParameters,
                    localVarHeaderType,
                    localVarContentType,
                    localVarBodyParameters,
                    "DELETE");

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
    cJSON *BlockingAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    generic_response_t *elementToReturn = generic_response_parseFromJSON(BlockingAPIlocalVarJSON);
    cJSON_Delete(BlockingAPIlocalVarJSON);
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
    
    free(localVarPath);
    free(localVarToReplace_ruleId);
    return elementToReturn;
end:
    free(localVarPath);
    return NULL;

}

// Removes an email address from the blocked list
//
// Removes an email address from the various block lists. 
//
generic_response_t*
BlockingAPI_delistBlock(apiClient_t *apiClient, email_address_t * email_address )
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_createList();
    list_t *localVarContentType = list_createList();
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail/blocks/delete")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail/blocks/delete");




    // Body Param
    cJSON *localVarSingleItemJSON_email_address = NULL;
    if (email_address != NULL)
    {
        //string
        localVarSingleItemJSON_email_address = email_address_convertToJSON(email_address);
        localVarBodyParameters = cJSON_Print(localVarSingleItemJSON_email_address);
    }
    list_addElement(localVarHeaderType,"application/json"); //produces
    list_addElement(localVarContentType,"application/json"); //consumes
    list_addElement(localVarContentType,"multipart/form-data"); //consumes
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
    cJSON *BlockingAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    generic_response_t *elementToReturn = generic_response_parseFromJSON(BlockingAPIlocalVarJSON);
    cJSON_Delete(BlockingAPIlocalVarJSON);
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
    if (localVarSingleItemJSON_email_address) {
        cJSON_Delete(localVarSingleItemJSON_email_address);
        localVarSingleItemJSON_email_address = NULL;
    }
    free(localVarBodyParameters);
    return elementToReturn;
end:
    free(localVarPath);
    return NULL;

}

// displays a list of blocked email addresses
//
mail_blocks_t*
BlockingAPI_getMailBlocks(apiClient_t *apiClient)
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_createList();
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail/blocks")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail/blocks");



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
    //nonprimitive not container
    cJSON *BlockingAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    mail_blocks_t *elementToReturn = mail_blocks_parseFromJSON(BlockingAPIlocalVarJSON);
    cJSON_Delete(BlockingAPIlocalVarJSON);
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
    
    free(localVarPath);
    return elementToReturn;
end:
    free(localVarPath);
    return NULL;

}

// Displays a listing of deny email rules.
//
// Returns a listing of all the deny block rules you have configured.
//
list_t*
BlockingAPI_getRules(apiClient_t *apiClient)
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_createList();
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/mail/rules")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/mail/rules");



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
    cJSON *BlockingAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    if(!cJSON_IsArray(BlockingAPIlocalVarJSON)) {
        return 0;//nonprimitive container
    }
    list_t *elementToReturn = list_createList();
    cJSON *VarJSON;
    cJSON_ArrayForEach(VarJSON, BlockingAPIlocalVarJSON)
    {
        if(!cJSON_IsObject(VarJSON))
        {
           // return 0;
        }
        char *localVarJSONToChar = cJSON_Print(VarJSON);
        list_addElement(elementToReturn , localVarJSONToChar);
    }

    cJSON_Delete( BlockingAPIlocalVarJSON);
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

