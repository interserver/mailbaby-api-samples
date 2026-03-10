package org.openapitools.api;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import jakarta.inject.Inject;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;

/**
 * API tests for StatusApi
 */
@MicronautTest
public class StatusApiTest {

    @Inject
    StatusApi api;

    
    /**
     * Checks if the server is running
     *
     * A lightweight health-check endpoint.  Returns a plain-text &#x60;200 OK&#x60; when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks. 
     */
    @Test
    @Disabled("Not Implemented")
    public void pingServerTest() {
        // given

        // when
        api.pingServer().block();

        // then
        // TODO implement the pingServerTest()
    }

    
}
