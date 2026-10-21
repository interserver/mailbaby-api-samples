package controllers;

import apimodels.DenyRuleRecord;
import apimodels.EmailAddressParam;
import apimodels.ErrorMessage;
import apimodels.GenericResponse;
import apimodels.MailBlocks;

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
public class BlockingApiControllerImp extends BlockingApiControllerImpInterface {
    @Override
    public GenericResponse addRule(Http.Request request, String type, String data, String user) throws Exception {
        //Do your magic!!!
        return new GenericResponse();
    }

    @Override
    public GenericResponse deleteRule(Http.Request request, Integer ruleId) throws Exception {
        //Do your magic!!!
        return new GenericResponse();
    }

    @Override
    public GenericResponse delistBlock(Http.Request request, EmailAddressParam emailAddressParam) throws Exception {
        //Do your magic!!!
        return new GenericResponse();
    }

    @Override
    public MailBlocks getMailBlocks(Http.Request request) throws Exception {
        //Do your magic!!!
        return new MailBlocks();
    }

    @Override
    public List<DenyRuleRecord> getRules(Http.Request request) throws Exception {
        //Do your magic!!!
        return new ArrayList<DenyRuleRecord>();
    }

}
