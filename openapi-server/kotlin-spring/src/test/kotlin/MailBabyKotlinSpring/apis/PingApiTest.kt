package MailBabyKotlinSpring.apis

import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class PingApiTest {

    private val api: PingApiController = PingApiController()

    /**
     * To test PingApiController.pingServer
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun pingServerTest() {
        
        
        val response: ResponseEntity<kotlin.String> = api.pingServer()

        // TODO: test validations
    }
}
