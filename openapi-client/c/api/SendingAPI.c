#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#include "SendingAPI.h"

#define MAX_NUMBER_LENGTH 16
#define MAX_BUFFER_LENGTH 4096


// Sends an Email with Advanced Options
//
// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ```BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ```ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ```NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ```MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ```MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ```MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ```BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }' ```  ```ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }' ```  ```NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }' ``` 
//
generic_response_t*
SendingAPI_sendAdvMail(apiClient_t *apiClient, char *subject, char *body, email_address_types_t *from, email_addresses_types_t *to, email_addresses_types_t *replyto, email_addresses_types_t *cc, email_addresses_types_t *bcc, list_t *attachments, long id)
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = list_createList();
    list_t *localVarHeaderType = list_createList();
    list_t *localVarContentType = list_createList();
    char      *localVarBodyParameters = NULL;
    size_t     localVarBodyLength = 0;

    // clear the error code from the previous api call
    apiClient->response_code = 0;

    // create the path
    char *localVarPath = strdup("/mail/advsend");





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

    // form parameters
    char *keyForm_from = NULL;
    email_address_types_t * valueForm_from = 0;
    keyValuePair_t *keyPairForm_from = 0;
    if (from != NULL)
    {
        keyForm_from = strdup("from");
        valueForm_from = (from);
        keyPairForm_from = keyValuePair_create(keyForm_from,&valueForm_from);
        list_addElement(localVarFormParameters,keyPairForm_from);
    }

    // form parameters
    char *keyForm_to = NULL;
    email_addresses_types_t * valueForm_to = 0;
    keyValuePair_t *keyPairForm_to = 0;
    if (to != NULL)
    {
        keyForm_to = strdup("to");
        valueForm_to = (to);
        keyPairForm_to = keyValuePair_create(keyForm_to,&valueForm_to);
        list_addElement(localVarFormParameters,keyPairForm_to);
    }

    // form parameters
    char *keyForm_replyto = NULL;
    email_addresses_types_t * valueForm_replyto = 0;
    keyValuePair_t *keyPairForm_replyto = 0;
    if (replyto != NULL)
    {
        keyForm_replyto = strdup("replyto");
        valueForm_replyto = (replyto);
        keyPairForm_replyto = keyValuePair_create(keyForm_replyto,&valueForm_replyto);
        list_addElement(localVarFormParameters,keyPairForm_replyto);
    }

    // form parameters
    char *keyForm_cc = NULL;
    email_addresses_types_t * valueForm_cc = 0;
    keyValuePair_t *keyPairForm_cc = 0;
    if (cc != NULL)
    {
        keyForm_cc = strdup("cc");
        valueForm_cc = (cc);
        keyPairForm_cc = keyValuePair_create(keyForm_cc,&valueForm_cc);
        list_addElement(localVarFormParameters,keyPairForm_cc);
    }

    // form parameters
    char *keyForm_bcc = NULL;
    email_addresses_types_t * valueForm_bcc = 0;
    keyValuePair_t *keyPairForm_bcc = 0;
    if (bcc != NULL)
    {
        keyForm_bcc = strdup("bcc");
        valueForm_bcc = (bcc);
        keyPairForm_bcc = keyValuePair_create(keyForm_bcc,&valueForm_bcc);
        list_addElement(localVarFormParameters,keyPairForm_bcc);
    }

    // form parameters
    char *keyForm_attachments = NULL;
     valueForm_attachments = 0;
    keyValuePair_t *keyPairForm_attachments = 0;
    if (attachments != NULL)
    {
        keyForm_attachments = strdup("attachments");
        valueForm_attachments = (attachments);
        keyPairForm_attachments = keyValuePair_create(keyForm_attachments,&valueForm_attachments);
        list_addElement(localVarFormParameters,keyPairForm_attachments);
    }

    // form parameters
    char *keyForm_id = NULL;
    long valueForm_id = 0;
    keyValuePair_t *keyPairForm_id = 0;
    if (id != NULL)
    {
        keyForm_id = strdup("id");
        valueForm_id = (id);
        keyPairForm_id = keyValuePair_create(keyForm_id,&valueForm_id);
        list_addElement(localVarFormParameters,keyPairForm_id);
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
                    localVarBodyLength,
                    "POST");

    // uncomment below to debug the error response
    //if (apiClient->response_code == 200) {
    //    printf("%s\n","search results matching criteria");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 400) {
    //    printf("%s\n","Error message when there was a problem with the input parameters.");
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
    generic_response_t *elementToReturn = NULL;
    if(apiClient->response_code >= 200 && apiClient->response_code < 300) {
        cJSON *SendingAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
        elementToReturn = generic_response_parseFromJSON(SendingAPIlocalVarJSON);
        cJSON_Delete(SendingAPIlocalVarJSON);
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
    
    
    list_freeList(localVarFormParameters);
    list_freeList(localVarHeaderType);
    list_freeList(localVarContentType);
    free(localVarPath);
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
    if (keyForm_from) {
        free(keyForm_from);
        keyForm_from = NULL;
    }
    free(keyPairForm_from);
    if (keyForm_to) {
        free(keyForm_to);
        keyForm_to = NULL;
    }
    free(keyPairForm_to);
    if (keyForm_replyto) {
        free(keyForm_replyto);
        keyForm_replyto = NULL;
    }
    free(keyPairForm_replyto);
    if (keyForm_cc) {
        free(keyForm_cc);
        keyForm_cc = NULL;
    }
    free(keyPairForm_cc);
    if (keyForm_bcc) {
        free(keyForm_bcc);
        keyForm_bcc = NULL;
    }
    free(keyPairForm_bcc);
    if (keyForm_attachments) {
        free(keyForm_attachments);
        keyForm_attachments = NULL;
    }
    free(keyPairForm_attachments);
    if (keyForm_id) {
        free(keyForm_id);
        keyForm_id = NULL;
    }
    free(keyPairForm_id);
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
SendingAPI_sendMail(apiClient_t *apiClient, char *to, char *from, char *subject, char *body)
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = list_createList();
    list_t *localVarHeaderType = list_createList();
    list_t *localVarContentType = list_createList();
    char      *localVarBodyParameters = NULL;
    size_t     localVarBodyLength = 0;

    // clear the error code from the previous api call
    apiClient->response_code = 0;

    // create the path
    char *localVarPath = strdup("/mail/send");





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
                    localVarBodyLength,
                    "POST");

    // uncomment below to debug the error response
    //if (apiClient->response_code == 200) {
    //    printf("%s\n","search results matching criteria");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 400) {
    //    printf("%s\n","Error message when there was a problem with the input parameters.");
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
    generic_response_t *elementToReturn = NULL;
    if(apiClient->response_code >= 200 && apiClient->response_code < 300) {
        cJSON *SendingAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
        elementToReturn = generic_response_parseFromJSON(SendingAPIlocalVarJSON);
        cJSON_Delete(SendingAPIlocalVarJSON);
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

