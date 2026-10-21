package org.openapitools.server.api;

import org.openapitools.server.model.DateOrTimestamp;
import org.openapitools.server.model.ErrorMessage;
import java.util.HexFormat;
import org.openapitools.server.model.MailLog;
import org.openapitools.server.model.MailStatsType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class HistoryServiceImpl implements HistoryService {
    private static final ObjectMapper MAPPER = JsonProvider.objectMapper();


    @Override
    public void getStats(ServerRequest request, ServerResponse response) {
        ValidatorUtils.Validator validator = ValidatorUtils.validator();

        response.status(Status.NOT_IMPLEMENTED_501).send();
    }

    @Override
    public void viewMailLog(ServerRequest request, ServerResponse response) {
        ValidatorUtils.Validator validator = ValidatorUtils.validator();

        response.status(Status.NOT_IMPLEMENTED_501).send();
    }


    @Override
    public void afterStop() {
        System.out.println("Service HistoryService is down. Goodbye!");
    }

}
