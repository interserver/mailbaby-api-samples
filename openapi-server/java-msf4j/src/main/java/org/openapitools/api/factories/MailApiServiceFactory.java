package org.openapitools.api.factories;

import org.openapitools.api.MailApiService;
import org.openapitools.api.impl.MailApiServiceImpl;

public class MailApiServiceFactory {
    private static final MailApiService service = new MailApiServiceImpl();

    public static MailApiService getMailApi() {
        return service;
    }
}
