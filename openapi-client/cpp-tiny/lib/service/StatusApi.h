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
    * Health check — verify the API is reachable.
    *
    * **No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 
    */
    Response<
                std::string
        >
    pingServer(
    );
}; 

} 

#endif /* TINY_CPP_CLIENT_StatusApi_H_ */