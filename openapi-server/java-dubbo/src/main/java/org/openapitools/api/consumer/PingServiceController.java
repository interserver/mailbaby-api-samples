package org.openapitools.api.consumer;

import org.openapitools.model.*;
import org.openapitools.api.interfaces.PingService;
import java.util.List;
import java.util.Map;
import java.time.OffsetDateTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Generated;


@Generated(value = "org.openapitools.codegen.languages.JavaDubboServerCodegen", comments = "Generator version: 7.26.0")

@RestController
@RequestMapping("/ping")
public class PingServiceController {

    @DubboReference
    private PingService pingService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String pingServer(
    ) {
        return pingService.pingServer();
    }
}
