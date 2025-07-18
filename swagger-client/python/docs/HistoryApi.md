# swagger_client.HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_stats**](HistoryApi.md#get_stats) | **GET** /mail/stats | Account usage statistics.
[**view_mail_log**](HistoryApi.md#view_mail_log) | **GET** /mail/log | displays the mail log

# **get_stats**
> MailStatsType get_stats(time=time)

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example
```python
from __future__ import print_function
import time
import swagger_client
from swagger_client.rest import ApiException
from pprint import pprint

# Configure API key authorization: apiKeyAuth
configuration = swagger_client.Configuration()
configuration.api_key['X-API-KEY'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['X-API-KEY'] = 'Bearer'

# create an instance of the API class
api_instance = swagger_client.HistoryApi(swagger_client.ApiClient(configuration))
time = 'time_example' # str | The timeframe for the statistics. (optional)

try:
    # Account usage statistics.
    api_response = api_instance.get_stats(time=time)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling HistoryApi->get_stats: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **time** | **str**| The timeframe for the statistics. | [optional] 

### Return type

[**MailStatsType**](MailStatsType.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **view_mail_log**
> MailLog view_mail_log(id=id, origin=origin, mx=mx, _from=_from, to=to, subject=subject, mailid=mailid, skip=skip, limit=limit, start_date=start_date, end_date=end_date, replyto=replyto, headerfrom=headerfrom, delivered=delivered)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```python
from __future__ import print_function
import time
import swagger_client
from swagger_client.rest import ApiException
from pprint import pprint

# Configure API key authorization: apiKeyAuth
configuration = swagger_client.Configuration()
configuration.api_key['X-API-KEY'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['X-API-KEY'] = 'Bearer'

# create an instance of the API class
api_instance = swagger_client.HistoryApi(swagger_client.ApiClient(configuration))
id = 789 # int | The ID of your mail order this will be sent through. (optional)
origin = 'origin_example' # str | originating ip address sending mail (optional)
mx = 'mx_example' # str | mx record mail was sent to (optional)
_from = '_from_example' # str | from email address (optional)
to = 'to_example' # str | to/destination email address (optional)
subject = 'subject_example' # str | subject containing this string (optional)
mailid = 'mailid_example' # str | mail id (optional)
skip = 0 # int | number of records to skip for pagination (optional) (default to 0)
limit = 100 # int | maximum number of records to return (optional) (default to 100)
start_date = 789 # int | earliest date to get emails in unix timestamp format (optional)
end_date = 789 # int | earliest date to get emails in unix timestamp format (optional)
replyto = 'replyto_example' # str | Reply-To Email Address (optional)
headerfrom = 'headerfrom_example' # str | Header From Email Address (optional)
delivered = 'delivered_example' # str | Limiting the emails to wether or not they were delivered. (optional)

try:
    # displays the mail log
    api_response = api_instance.view_mail_log(id=id, origin=origin, mx=mx, _from=_from, to=to, subject=subject, mailid=mailid, skip=skip, limit=limit, start_date=start_date, end_date=end_date, replyto=replyto, headerfrom=headerfrom, delivered=delivered)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling HistoryApi->view_mail_log: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| The ID of your mail order this will be sent through. | [optional] 
 **origin** | **str**| originating ip address sending mail | [optional] 
 **mx** | **str**| mx record mail was sent to | [optional] 
 **_from** | **str**| from email address | [optional] 
 **to** | **str**| to/destination email address | [optional] 
 **subject** | **str**| subject containing this string | [optional] 
 **mailid** | **str**| mail id | [optional] 
 **skip** | **int**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **int**| maximum number of records to return | [optional] [default to 100]
 **start_date** | **int**| earliest date to get emails in unix timestamp format | [optional] 
 **end_date** | **int**| earliest date to get emails in unix timestamp format | [optional] 
 **replyto** | **str**| Reply-To Email Address | [optional] 
 **headerfrom** | **str**| Header From Email Address | [optional] 
 **delivered** | **str**| Limiting the emails to wether or not they were delivered. | [optional] 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

