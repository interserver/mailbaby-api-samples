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

    virtual ~StatusApi() = default;

    /**
    * Checks if the server is running.
    *
    * A lightweight health-check endpoint.  Returns a plain-text `200 OK` when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks. 
    */
    Response<
            String
        >
    pingServer(
    );
}; 

} 

#endif /* TINY_CPP_CLIENT_StatusApi_H_ */