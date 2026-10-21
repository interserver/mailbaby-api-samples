package org.openapitools.api.factories;

import org.openapitools.api.MailApiService;
import org.openapitools.api.impl.MailApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", comments = "Generator version: 7.26.0")
public class MailApiServiceFactory {
    private static final MailApiService service = new MailApiServiceImpl();

    public static MailApiService getMailApi() {
        return service;
    }
}
