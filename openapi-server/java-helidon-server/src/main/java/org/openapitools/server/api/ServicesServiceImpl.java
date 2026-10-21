package org.openapitools.server.api;

import org.openapitools.server.model.ErrorMessage;
import java.util.HexFormat;
import java.util.List;
import org.openapitools.server.model.MailOrder;
import org.openapitools.server.model.MailOrderDetail;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class ServicesServiceImpl implements ServicesService {
    private static final ObjectMapper MAPPER = JsonProvider.objectMapper();


    @Override
    public void getMailOrderById(ServerRequest request, ServerResponse response) {
        ValidatorUtils.Validator validator = ValidatorUtils.validator();

        response.status(Status.NOT_IMPLEMENTED_501).send();
    }

    @Override
    public void getMailOrders(ServerRequest request, ServerResponse response) {
        ValidatorUtils.Validator validator = ValidatorUtils.validator();

        response.status(Status.NOT_IMPLEMENTED_501).send();
    }


    @Override
    public void afterStop() {
        System.out.println("Service ServicesService is down. Goodbye!");
    }

}
