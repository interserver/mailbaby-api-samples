package io.swagger.api.factories;

import io.swagger.api.MailApiService;
import io.swagger.api.impl.MailApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2024-10-15T16:37:54.418937740-04:00[America/New_York]")
public class MailApiServiceFactory {
    private final static MailApiService service = new MailApiServiceImpl();

    public static MailApiService getMailApi() {
        return service;
    }
}
