package io.swagger.api.factories;

import io.swagger.api.PingApiService;
import io.swagger.api.impl.PingApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-10T11:17:11.710282-04:00[America/New_York]")public class PingApiServiceFactory {
    private final static PingApiService service = new PingApiServiceImpl();

    public static PingApiService getPingApi() {
        return service;
    }
}
