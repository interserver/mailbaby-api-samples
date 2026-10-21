package io.interserver.jaxrs.jersey.api.factories;

import io.interserver.jaxrs.jersey.api.PingApiService;
import io.interserver.jaxrs.jersey.api.impl.PingApiServiceImpl;


public class PingApiServiceFactory {
    private final static PingApiService service = new PingApiServiceImpl();

    public static PingApiService getPingApi() {
        return service;
    }
}
