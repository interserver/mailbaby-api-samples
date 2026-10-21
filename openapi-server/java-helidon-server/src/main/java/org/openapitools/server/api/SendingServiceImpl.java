package org.openapitools.server.api;

import java.util.stream.Collectors;
import org.openapitools.server.model.EmailAddressTypes;
import org.openapitools.server.model.EmailAddressesTypes;
import org.openapitools.server.model.ErrorMessage;
import org.openapitools.server.model.GenericResponse;
import java.util.HexFormat;
import org.openapitools.server.model.MailAttachment;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import io.helidon.common.parameters.Parameters;
import io.helidon.http.media.multipart.ReadablePart;
import org.openapitools.server.model.SendMailRaw;
import org.openapitools.server.model.SendMailTo;
import io.helidon.http.Status;
import jakarta.validation.Valid;
import io.helidon.common.mapper.Value;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class SendingServiceImpl implements SendingService {
    private static final ObjectMapper MAPPER = JsonProvider.objectMapper();


    @Override
    public void rawMail(ServerRequest request, ServerResponse response) {
        ValidatorUtils.Validator validator = ValidatorUtils.validator();

        response.status(Status.NOT_IMPLEMENTED_501).send();
    }

    @Override
    public void sendAdvMail(ServerRequest request, ServerResponse response) {
        Parameters formParams = request.content().as(Parameters.class);
        ValidatorUtils.Validator validator = ValidatorUtils.validator();

        response.status(Status.NOT_IMPLEMENTED_501).send();
    }

    @Override
    public void sendMail(ServerRequest request, ServerResponse response) {
        Parameters formParams = request.content().as(Parameters.class);
        ValidatorUtils.Validator validator = ValidatorUtils.validator();

        response.status(Status.NOT_IMPLEMENTED_501).send();
    }


    @Override
    public void afterStop() {
        System.out.println("Service SendingService is down. Goodbye!");
    }

}
