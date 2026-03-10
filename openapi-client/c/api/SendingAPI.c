#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>

#include "SendingAPI.h"

#define MAX_NUMBER_LENGTH 16
#define MAX_BUFFER_LENGTH 4096
#define MAX_NUMBER_LENGTH_LONG 21


// Sends a raw RFC 822 email
//
// Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 
//
generic_response_t*
SendingAPI_rawMail(apiClient_t *apiClient, send_mail_raw_t *send_mail_raw)
{
    list_t    *localVarQueryParameters = NULL;
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_createList();
    list_t *localVarContentType = list_createList();
    char      *localVarBodyParameters = NULL;
    size_t     localVarBodyLength = 0;

    // clear the error code from the previous api call
    apiClient->response_code = 0;

    // create the path
    char *localVarPath = strdup("/mail/rawsend");





    // Body Param
    cJSON *localVarSingleItemJSON_send_mail_raw = NULL;
    if (send_mail_raw != NULL)
    {
        //not string, not binary
        localVarSingleItemJSON_send_mail_raw = send_mail_raw_convertToJSON(send_mail_raw);
        localVarBodyParameters = cJSON_Print(localVarSingleItemJSON_send_mail_raw);
        localVarBodyLength = strlen(localVarBodyParameters);
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
                    localVarBodyLength,
                    "POST");

    // uncomment below to debug the error response
    //if (apiClient->response_code == 200) {
    //    printf("%s\n","Email accepted for delivery");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 400) {
    //    printf("%s\n","Bad request — one or more input parameters were missing or invalid.");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 401) {
    //    printf("%s\n","Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 404) {
    //    printf("%s\n","The specified resource was not found or does not belong to your account.");
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
    
    
    
    list_freeList(localVarHeaderType);
    list_freeList(localVarContentType);
    free(localVarPath);
    if (localVarSingleItemJSON_send_mail_raw) {
        cJSON_Delete(localVarSingleItemJSON_send_mail_raw);
        localVarSingleItemJSON_send_mail_raw = NULL;
    }
    free(localVarBodyParameters);
    return elementToReturn;
end:
    free(localVarPath);
    return NULL;

}

// Sends an Email with Advanced Options
//
// Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.  ## Examples  ### Form — basic string addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d from=user@domain.com \\   -d to=support@interserver.net ``` ### Form — RFC 822 named addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d 'from=Joe <user@domain.com>' \\   -d 'to=Jane <support@interserver.net>' ``` ### Form — multiple recipients as array ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' -d 'body=Hello' \\   -d from=user@domain.com \\   -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \\   -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net' ``` ### JSON — structured objects ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/json' \\   -d '{     \"subject\": \"Welcome\",     \"body\": \"<h1>Hello</h1>\",     \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},     \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],     \"cc\": [{\"email\": \"manager@client.com\"}],     \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]   }' ``` 
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
    //    printf("%s\n","Email accepted for delivery");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 400) {
    //    printf("%s\n","Bad request — one or more input parameters were missing or invalid.");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 401) {
    //    printf("%s\n","Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 404) {
    //    printf("%s\n","The specified resource was not found or does not belong to your account.");
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
// Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.  The `from` address is also automatically set as the `Reply-To` header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 
//
generic_response_t*
SendingAPI_sendMail(apiClient_t *apiClient, send_mail_to_t *to, char *from, char *subject, char *body, long id)
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
    send_mail_to_t * valueForm_to = 0;
    keyValuePair_t *keyPairForm_to = 0;
    if (to != NULL)
    {
        keyForm_to = strdup("to");
        valueForm_to = (to);
        keyPairForm_to = keyValuePair_create(keyForm_to,&valueForm_to);
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
    //    printf("%s\n","Email accepted for delivery");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 400) {
    //    printf("%s\n","Bad request — one or more input parameters were missing or invalid.");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 401) {
    //    printf("%s\n","Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).");
    //}
    // uncomment below to debug the error response
    //if (apiClient->response_code == 404) {
    //    printf("%s\n","The specified resource was not found or does not belong to your account.");
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

