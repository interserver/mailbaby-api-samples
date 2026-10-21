package io.interserver.jaxrs.jersey.api.factories;

import io.interserver.jaxrs.jersey.api.MailApiService;
import io.interserver.jaxrs.jersey.api.impl.MailApiServiceImpl;


public class MailApiServiceFactory {
    private final static MailApiService service = new MailApiServiceImpl();

    public static MailApiService getMailApi() {
        return service;
    }
}
