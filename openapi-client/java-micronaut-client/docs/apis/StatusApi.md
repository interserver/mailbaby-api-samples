# StatusApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**pingServer**](StatusApi.md#pingServer) | **GET** /ping | Checks if the server is running |


## Creating StatusApi

To initiate an instance of `StatusApi`, you can use micronaut's `ApplicationContext`:
```java
/* imports
import io.micronaut.runtime.Micronaut;
import io.micronaut.context.ApplicationContext;
import org.openapitools.api.StatusApi;
*/

ApplicationContext context = Micronaut.run(/* ... */);
PetApi apiInstance = context.getBean(StatusApi.class);
```

Or the `@Inject` annotation:
```java
@Singleton
class MyClass {
    @Inject
    StatusApi statusApi;

    /* ... use the injected variable */
}
```
Note that the class needs to be annotated with one of Micronaut's [scope annotations](https://docs.micronaut.io/latest/guide/#scopes) like `Singleton` in order to be processed.

More information can be found inside [Inversion of Control guide section](https://docs.micronaut.io/latest/guide/#ioc).

<a id="pingServer"></a>
# **pingServer**
```java
Mono<Void> StatusApi.pingServer()
```

Checks if the server is running





### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: Not defined
 - **Accept**: Not defined

