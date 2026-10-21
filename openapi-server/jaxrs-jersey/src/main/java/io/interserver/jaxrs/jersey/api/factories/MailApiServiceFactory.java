package io.interserver.jaxrs.jersey.api.factories;

import io.interserver.jaxrs.jersey.api.MailApiService;
import io.interserver.jaxrs.jersey.api.impl.MailApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", comments = "Generator version: 7.26.0")
public class MailApiServiceFactory {
    private static final MailApiService service = new MailApiServiceImpl();

    public static MailApiService getMailApi() {
        return service;
    }
}
