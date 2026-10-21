package controllers;

import apimodels.ErrorMessage;
import apimodels.MailOrder;
import apimodels.MailOrderDetail;

import com.google.inject.Inject;
import com.typesafe.config.Config;
import play.mvc.Controller;
import play.mvc.Http;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import play.mvc.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import openapitools.OpenAPIUtils;
import openapitools.SecurityAPIUtils;
import static play.mvc.Results.ok;
import static play.mvc.Results.unauthorized;
import play.libs.Files.TemporaryFile;

import javax.validation.constraints.*;
import javax.validation.Valid;

@SuppressWarnings("RedundantThrows")
public abstract class ServicesApiControllerImpInterface {
    @Inject private Config configuration;
    @Inject private SecurityAPIUtils securityAPIUtils;
    private ObjectMapper mapper = new ObjectMapper();

    public Result getMailOrderByIdHttp(Http.Request request, Long id) throws Exception {
        MailOrderDetail obj = getMailOrderById(request, id);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            OpenAPIUtils.validate(obj);
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract MailOrderDetail getMailOrderById(Http.Request request, Long id) throws Exception;

    public Result getMailOrdersHttp(Http.Request request) throws Exception {
        List<MailOrder> obj = getMailOrders(request);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            for (MailOrder curItem : obj) {
                OpenAPIUtils.validate(curItem);
            }
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract List<MailOrder> getMailOrders(Http.Request request) throws Exception;

}
