# HistoryApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getStats**](HistoryApi.md#getStats) | **GET** /mail/stats | displays a list of blocked email addresses |
| [**viewMailLog**](HistoryApi.md#viewMailLog) | **GET** /mail/log | displays the mail log |


## Creating HistoryApi

To initiate an instance of `HistoryApi`, you can use micronaut's `ApplicationContext`:
```java
/* imports
import io.micronaut.runtime.Micronaut;
import io.micronaut.context.ApplicationContext;
import org.openapitools.api.HistoryApi;
*/

ApplicationContext context = Micronaut.run(/* ... */);
PetApi apiInstance = context.getBean(HistoryApi.class);
```

Or the `@Inject` annotation:
```java
@Singleton
class MyClass {
    @Inject
    HistoryApi historyApi;

    /* ... use the injected variable */
}
```
Note that the class needs to be annotated with one of Micronaut's [scope annotations](https://docs.micronaut.io/latest/guide/#scopes) like `Singleton` in order to be processed.

More information can be found inside [Inversion of Control guide section](https://docs.micronaut.io/latest/guide/#ioc).

<a id="getStats"></a>
# **getStats**
```java
Mono<List<GetStats200ResponseInner>> HistoryApi.getStats()
```

displays a list of blocked email addresses



### Return type
[**List&lt;GetStats200ResponseInner&gt;**](GetStats200ResponseInner.md)

### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: Not defined
 - **Accept**: `application/json`

<a id="viewMailLog"></a>
# **viewMailLog**
```java
Mono<MailLog> HistoryApi.viewMailLog(idoriginmxfromtosubjectmailidskiplimitstartDateendDate)
```

displays the mail log

Get a listing of the emails sent through this system 

### Parameters
| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | `Long`| The ID of your mail order this will be sent through. | [optional parameter] |
| **origin** | `String`| originating ip address sending mail | [optional parameter] |
| **mx** | `String`| mx record mail was sent to | [optional parameter] |
| **from** | `String`| from email address | [optional parameter] |
| **to** | `String`| to/destination email address | [optional parameter] |
| **subject** | `String`| subject containing this string | [optional parameter] |
| **mailid** | `String`| mail id | [optional parameter] |
| **skip** | `Integer`| number of records to skip for pagination | [optional parameter] [default to `0`] |
| **limit** | `Integer`| maximum number of records to return | [optional parameter] [default to `100`] |
| **startDate** | `Long`| earliest date to get emails in unix timestamp format | [optional parameter] |
| **endDate** | `Long`| earliest date to get emails in unix timestamp format | [optional parameter] |


### Return type
[**MailLog**](MailLog.md)

### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: Not defined
 - **Accept**: `application/json`

