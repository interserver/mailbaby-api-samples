# OpenAPIClient::HistoryApi

## Load the API package
```perl
use OpenAPIClient::Object::HistoryApi;
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_stats**](HistoryApi.md#get_stats) | **GET** /mail/stats | Account usage statistics.
[**view_mail_log**](HistoryApi.md#view_mail_log) | **GET** /mail/log | displays the mail log


# **get_stats**
> MailStatsType get_stats(time => $time)

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example
```perl
use Data::Dumper;
use OpenAPIClient::HistoryApi;
my $api_instance = OpenAPIClient::HistoryApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
);

my $time = "time_example"; # string | The timeframe for the statistics.

eval {
    my $result = $api_instance->get_stats(time => $time);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling HistoryApi->get_stats: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **time** | **string**| The timeframe for the statistics. | [optional] 

### Return type

[**MailStatsType**](MailStatsType.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **view_mail_log**
> MailLog view_mail_log(id => $id, origin => $origin, mx => $mx, from => $from, to => $to, subject => $subject, mailid => $mailid, skip => $skip, limit => $limit, start_date => $start_date, end_date => $end_date, replyto => $replyto, headerfrom => $headerfrom, delivered => $delivered)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```perl
use Data::Dumper;
use OpenAPIClient::HistoryApi;
my $api_instance = OpenAPIClient::HistoryApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
);

my $id = 2604; # int | The ID of your mail order this will be sent through.
my $origin = 1.2.3.4; # string | originating ip address sending mail
my $mx = mx.google.com; # string | mx record mail was sent to
my $from = me@sender.com; # string | from email address
my $to = you@receiver.com; # string | to/destination email address
my $subject = Support; # string | subject containing this string
my $mailid = 185997065c60008840; # string | mail id
my $skip = 1000; # int | number of records to skip for pagination
my $limit = 1000; # int | maximum number of records to return
my $start_date = 1641781008; # int | earliest date to get emails in unix timestamp format
my $end_date = 1673317008; # int | earliest date to get emails in unix timestamp format
my $replyto = "replyto_example"; # string | Reply-To Email Address
my $headerfrom = "headerfrom_example"; # string | Header From Email Address
my $delivered = "delivered_example"; # string | Limiting the emails to wether or not they were delivered.

eval {
    my $result = $api_instance->view_mail_log(id => $id, origin => $origin, mx => $mx, from => $from, to => $to, subject => $subject, mailid => $mailid, skip => $skip, limit => $limit, start_date => $start_date, end_date => $end_date, replyto => $replyto, headerfrom => $headerfrom, delivered => $delivered);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling HistoryApi->view_mail_log: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| The ID of your mail order this will be sent through. | [optional] 
 **origin** | **string**| originating ip address sending mail | [optional] 
 **mx** | **string**| mx record mail was sent to | [optional] 
 **from** | **string**| from email address | [optional] 
 **to** | **string**| to/destination email address | [optional] 
 **subject** | **string**| subject containing this string | [optional] 
 **mailid** | **string**| mail id | [optional] 
 **skip** | **int**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **int**| maximum number of records to return | [optional] [default to 100]
 **start_date** | **int**| earliest date to get emails in unix timestamp format | [optional] 
 **end_date** | **int**| earliest date to get emails in unix timestamp format | [optional] 
 **replyto** | **string**| Reply-To Email Address | [optional] 
 **headerfrom** | **string**| Header From Email Address | [optional] 
 **delivered** | **string**| Limiting the emails to wether or not they were delivered. | [optional] 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

