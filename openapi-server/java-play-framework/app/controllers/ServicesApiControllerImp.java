package controllers;

import apimodels.ErrorMessage;
import apimodels.MailOrder;
import apimodels.MailOrderDetail;

import play.mvc.Http;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.io.FileInputStream;
import play.libs.Files.TemporaryFile;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPlayFrameworkCodegen", comments = "Generator version: 7.26.0")
public class ServicesApiControllerImp extends ServicesApiControllerImpInterface {
    @Override
    public MailOrderDetail getMailOrderById(Http.Request request, Long id) throws Exception {
        //Do your magic!!!
        return new MailOrderDetail();
    }

    @Override
    public List<MailOrder> getMailOrders(Http.Request request) throws Exception {
        //Do your magic!!!
        return new ArrayList<MailOrder>();
    }

}
