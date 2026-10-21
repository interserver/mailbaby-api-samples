# StatusController

All URIs are relative to `""`

The controller class is defined in **[StatusController.java](../../src/main/java/org/openapitools/controller/StatusController.java)**

Method | HTTP request | Description
------------- | ------------- | -------------
[**pingServer**](#pingServer) | **GET** /ping | Health check — verify the API is reachable

<a id="pingServer"></a>
# **pingServer**
```java
Mono<String> StatusController.pingServer()
```

Health check — verify the API is reachable

**No authentication required.** Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 


### Return type
`String`


### HTTP request headers
 - **Accepts Content-Type**: Not defined
 - **Produces Content-Type**: `text/plain`, `application/json`

