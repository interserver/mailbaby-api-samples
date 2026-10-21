package io.interserver.spring.api;

import io.interserver.spring.model.DenyRuleRecord;
import io.interserver.spring.model.EmailAddressParam;
import io.interserver.spring.model.EmailAddressTypes;
import io.interserver.spring.model.EmailAddressesTypes;
import io.interserver.spring.model.ErrorMessage;
import io.interserver.spring.model.GenericResponse;
import io.interserver.spring.model.MailAttachment;
import io.interserver.spring.model.MailBlocks;
import io.interserver.spring.model.MailLog;
import io.interserver.spring.model.MailOrder;
import io.interserver.spring.model.MailOrderDetail;
import io.interserver.spring.model.MailStatsType;
import org.springframework.lang.Nullable;
import io.interserver.spring.model.SendMailRaw;
import io.interserver.spring.model.SendMailTo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.26.0")
@Controller
@RequestMapping("${openapi.mailBabyEmailDeliveryAndManagementService.base-path:}")
public class MailApiController implements MailApi {

    private final NativeWebRequest request;

    @Autowired
    public MailApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
