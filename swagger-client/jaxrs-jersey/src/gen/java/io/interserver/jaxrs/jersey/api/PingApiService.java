package io.interserver.jaxrs.jersey.api;

import io.interserver.jaxrs.jersey.api.*;
import io.interserver.jaxrs.jersey.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;


import java.util.Map;
import java.util.List;
import io.interserver.jaxrs.jersey.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

public abstract class PingApiService {
    public abstract Response pingServer(SecurityContext securityContext) throws NotFoundException;
}
