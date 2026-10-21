package org.openapitools.api.factories;

import org.openapitools.api.PingApiService;
import org.openapitools.api.impl.PingApiServiceImpl;

public class PingApiServiceFactory {
    private static final PingApiService service = new PingApiServiceImpl();

    public static PingApiService getPingApi() {
        return service;
    }
}
