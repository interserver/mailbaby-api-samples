# OpenAPIClient::SendingApi

## Load the API package
```perl
use OpenAPIClient::Object::SendingApi;
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**raw_mail**](SendingApi.md#raw_mail) | **POST** /mail/rawsend | Sends a raw email
[**send_adv_mail**](SendingApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](SendingApi.md#send_mail) | **POST** /mail/send | Sends an Email


# **raw_mail**
> GenericResponse raw_mail(raw_mail => $raw_mail)

Sends a raw email

This call will let you pass the raw / complete email contents (including headers) as a string and have it get sent as-is.  This is useful for things like DKIM signed messages.

### Example
```perl
use Data::Dumper;
use OpenAPIClient::SendingApi;
my $api_instance = OpenAPIClient::SendingApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
);

my $raw_mail = OpenAPIClient::Object::RawMail->new(); # RawMail | 

eval {
    my $result = $api_instance->raw_mail(raw_mail => $raw_mail);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling SendingApi->raw_mail: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **raw_mail** | [**RawMail**](RawMail.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_adv_mail**
> GenericResponse send_adv_mail(subject => $subject, body => $body, from => $from, to => $to, replyto => $replyto, cc => $cc, bcc => $bcc, attachments => $attachments, id => $id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ```BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ```ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ```NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ```MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ```MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ```MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ```BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }' ```  ```ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }' ```  ```NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }' ``` 

### Example
```perl
use Data::Dumper;
use OpenAPIClient::SendingApi;
my $api_instance = OpenAPIClient::SendingApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
);

my $subject = "subject_example"; # string | The subject or title of the email
my $body = "body_example"; # string | The main email contents.
my $from = new OpenAPIClient.EmailAddressTypes(); # EmailAddressTypes | 
my $to = new OpenAPIClient.EmailAddressesTypes(); # EmailAddressesTypes | 
my $replyto = new OpenAPIClient.EmailAddressesTypes(); # EmailAddressesTypes | 
my $cc = new OpenAPIClient.EmailAddressesTypes(); # EmailAddressesTypes | 
my $bcc = new OpenAPIClient.EmailAddressesTypes(); # EmailAddressesTypes | 
my $attachments = [(new OpenAPIClient.MailAttachment())]; # ARRAY[MailAttachment] | (optional) File attachments to include in the email.  The file contents must be base64 encoded!
my $id = 789; # int | (optional)  ID of the Mail order within our system to use as the Mail Account.

eval {
    my $result = $api_instance->send_adv_mail(subject => $subject, body => $body, from => $from, to => $to, replyto => $replyto, cc => $cc, bcc => $bcc, attachments => $attachments, id => $id);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling SendingApi->send_adv_mail: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **string**| The subject or title of the email | 
 **body** | **string**| The main email contents. | 
 **from** | [**EmailAddressTypes**](EmailAddressTypes.md)|  | 
 **to** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | 
 **replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | [optional] 
 **cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | [optional] 
 **bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | [optional] 
 **attachments** | [**ARRAY[MailAttachment]**](MailAttachment.md)| (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
 **id** | **int**| (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_mail**
> GenericResponse send_mail(to => $to, from => $from, subject => $subject, body => $body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```perl
use Data::Dumper;
use OpenAPIClient::SendingApi;
my $api_instance = OpenAPIClient::SendingApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
);

my $to = "to_example"; # string | The Contact whom is the primary recipient of this email.
my $from = "from_example"; # string | The contact whom is the this email is from.
my $subject = "subject_example"; # string | The subject or title of the email
my $body = "body_example"; # string | The main email contents.

eval {
    my $result = $api_instance->send_mail(to => $to, from => $from, subject => $subject, body => $body);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling SendingApi->send_mail: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **string**| The Contact whom is the primary recipient of this email. | 
 **from** | **string**| The contact whom is the this email is from. | 
 **subject** | **string**| The subject or title of the email | 
 **body** | **string**| The main email contents. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

