# OpenAPIClient::SendingApi

## Load the API package
```perl
use OpenAPIClient::Object::SendingApi;
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**send_adv_mail**](SendingApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](SendingApi.md#send_mail) | **POST** /mail/send | Sends an Email


# **send_adv_mail**
> GenericResponse send_adv_mail(subject => $subject, body => $body, from => $from, to => $to, replyto => $replyto, cc => $cc, bcc => $bcc, attachments => $attachments, id => $id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

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
my $from = new OpenAPIClient.EmailAddressName(); # EmailAddressName | 
my $to = [(new OpenAPIClient.EmailAddressName())]; # ARRAY[EmailAddressName] | A list of destionation email addresses to send this to
my $replyto = [(new OpenAPIClient.EmailAddressName())]; # ARRAY[EmailAddressName] | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
my $cc = [(new OpenAPIClient.EmailAddressName())]; # ARRAY[EmailAddressName] | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
my $bcc = [(new OpenAPIClient.EmailAddressName())]; # ARRAY[EmailAddressName] | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
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
 **from** | [**EmailAddressName**](EmailAddressName.md)|  | 
 **to** | [**ARRAY[EmailAddressName]**](EmailAddressName.md)| A list of destionation email addresses to send this to | 
 **replyto** | [**ARRAY[EmailAddressName]**](EmailAddressName.md)| (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
 **cc** | [**ARRAY[EmailAddressName]**](EmailAddressName.md)| (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
 **bcc** | [**ARRAY[EmailAddressName]**](EmailAddressName.md)| (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
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

