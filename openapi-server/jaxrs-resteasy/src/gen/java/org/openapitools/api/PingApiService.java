package org.openapitools.api;

import org.openapitools.api.*;
import org.openapitools.model.*;




import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", comments = "Generator version: 7.26.0")
public interface PingApiService {
      Response pingServer(SecurityContext securityContext)
      throws NotFoundException;


}
