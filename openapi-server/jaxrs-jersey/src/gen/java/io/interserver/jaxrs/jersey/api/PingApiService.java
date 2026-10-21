package io.interserver.jaxrs.jersey.api;

import io.interserver.jaxrs.jersey.api.*;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;


import java.util.List;
import io.interserver.jaxrs.jersey.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", comments = "Generator version: 7.26.0")
public abstract class PingApiService {
    public abstract Response pingServer(SecurityContext securityContext) throws NotFoundException;
}
