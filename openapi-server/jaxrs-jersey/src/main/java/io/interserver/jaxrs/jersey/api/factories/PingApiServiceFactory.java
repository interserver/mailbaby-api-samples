package io.interserver.jaxrs.jersey.api.factories;

import io.interserver.jaxrs.jersey.api.PingApiService;
import io.interserver.jaxrs.jersey.api.impl.PingApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", comments = "Generator version: 7.26.0")
public class PingApiServiceFactory {
    private static final PingApiService service = new PingApiServiceImpl();

    public static PingApiService getPingApi() {
        return service;
    }
}
