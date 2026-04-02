#ifndef TINY_CPP_CLIENT_StatusApi_H_
#define TINY_CPP_CLIENT_StatusApi_H_


#include "Response.h"
#include "Arduino.h"
#include "Service.h"
#include "Helpers.h"
#include <list>


namespace Tiny {

/**
 *  Class 
 * Generated with openapi::tiny-cpp-client
 */

class StatusApi : public Service {
public:
    StatusApi() = default;

    virtual ~StatusApi();

    /**
    * Checks if the server is running.
    *
    * A lightweight health-check endpoint.  Returns the plain-text string `Server is up and running` with a `200` status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. 
    */
    Response<
                std::string
        >
    pingServer(
    );
}; 

} 

#endif /* TINY_CPP_CLIENT_StatusApi_H_ */