package io.swagger.api.factories;

import io.swagger.api.MailApiService;
import io.swagger.api.impl.MailApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2026-01-21T17:25:28.684378848-05:00[America/New_York]")
public class MailApiServiceFactory {
    private final static MailApiService service = new MailApiServiceImpl();

    public static MailApiService getMailApi() {
        return service;
    }
}
