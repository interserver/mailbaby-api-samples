package org.openapitools.server.api;

import org.openapitools.server.model.DenyRuleRecord;
import org.openapitools.server.model.EmailAddressParam;
import org.openapitools.server.model.ErrorMessage;
import org.openapitools.server.model.GenericResponse;
import java.util.HexFormat;
import java.util.List;
import org.openapitools.server.model.MailBlocks;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import io.helidon.common.parameters.Parameters;
import io.helidon.http.media.multipart.ReadablePart;
import io.helidon.http.Status;
import io.helidon.common.mapper.Value;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class BlockingServiceImpl implements BlockingService {
    private static final ObjectMapper MAPPER = JsonProvider.objectMapper();


    @Override
    public void addRule(ServerRequest request, ServerResponse response) {
        Parameters formParams = request.content().as(Parameters.class);
        ValidatorUtils.Validator validator = ValidatorUtils.validator();

        response.status(Status.NOT_IMPLEMENTED_501).send();
    }

    @Override
    public void deleteRule(ServerRequest request, ServerResponse response) {
        ValidatorUtils.Validator validator = ValidatorUtils.validator();

        response.status(Status.NOT_IMPLEMENTED_501).send();
    }

    @Override
    public void delistBlock(ServerRequest request, ServerResponse response) {
        ValidatorUtils.Validator validator = ValidatorUtils.validator();

        response.status(Status.NOT_IMPLEMENTED_501).send();
    }

    @Override
    public void getMailBlocks(ServerRequest request, ServerResponse response) {
        ValidatorUtils.Validator validator = ValidatorUtils.validator();

        response.status(Status.NOT_IMPLEMENTED_501).send();
    }

    @Override
    public void getRules(ServerRequest request, ServerResponse response) {
        ValidatorUtils.Validator validator = ValidatorUtils.validator();

        response.status(Status.NOT_IMPLEMENTED_501).send();
    }


    @Override
    public void afterStop() {
        System.out.println("Service BlockingService is down. Goodbye!");
    }

}
