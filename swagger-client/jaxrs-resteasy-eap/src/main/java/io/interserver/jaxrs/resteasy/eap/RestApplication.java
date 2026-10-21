package io.interserver.jaxrs.resteasy.eap;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;

import java.util.Set;
import java.util.HashSet;

import io.interserver.jaxrs.resteasy.eap.api.impl.MailApiServiceImpl;
import io.interserver.jaxrs.resteasy.eap.api.impl.PingApiServiceImpl;

@ApplicationPath("/")
public class RestApplication extends Application {


    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(MailApiServiceImpl.class);
        resources.add(PingApiServiceImpl.class);


        return resources;
    }




}
