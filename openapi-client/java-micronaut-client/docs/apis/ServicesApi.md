# ServicesApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getMailOrders**](ServicesApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders |


## Creating ServicesApi

To initiate an instance of `ServicesApi`, you can use micronaut's `ApplicationContext`:
```java
/* imports
import io.micronaut.runtime.Micronaut;
import io.micronaut.context.ApplicationContext;
import org.openapitools.api.ServicesApi;
*/

ApplicationContext context = Micronaut.run(/* ... */);
PetApi apiInstance = context.getBean(ServicesApi.class);
```

Or the `@Inject` annotation:
```java
@Singleton
class MyClass {
    @Inject
    ServicesApi servicesApi;

    /* ... use the injected variable */
}
```
Note that the class needs to be annotated with one of Micronaut's [scope annotations](https://docs.micronaut.io/latest/guide/#scopes) like `Singleton` in order to be processed.

More information can be found inside [Inversion of Control guide section](https://docs.micronaut.io/latest/guide/#ioc).

<a id="getMailOrders"></a>
# **getMailOrders**
```java
Mono<List<MailOrder>> ServicesApi.getMailOrders()
```

displays a list of mail service orders

This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.



### Return type
[**List&lt;MailOrder&gt;**](MailOrder.md)

### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: Not defined
 - **Accept**: `application/json`

