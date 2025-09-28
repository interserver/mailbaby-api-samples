package io.swagger.api.factories;

import io.swagger.api.PingApiService;
import io.swagger.api.impl.PingApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2025-09-28T16:28:50.506130034-04:00[America/New_York]")
public class PingApiServiceFactory {
    private final static PingApiService service = new PingApiServiceImpl();

    public static PingApiService getPingApi() {
        return service;
    }
}
