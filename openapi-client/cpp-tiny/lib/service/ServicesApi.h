#ifndef TINY_CPP_CLIENT_ServicesApi_H_
#define TINY_CPP_CLIENT_ServicesApi_H_


#include "Response.h"
#include "Arduino.h"
#include "Service.h"
#include "Helpers.h"
#include <list>

#include "GetMailOrders_401_response.h"
#include "MailOrder.h"

namespace Tiny {

/**
 *  Class 
 * Generated with openapi::tiny-cpp-client
 */

class ServicesApi : public Service {
public:
    ServicesApi() = default;

    virtual ~ServicesApi() = default;

    /**
    * displays a list of mail service orders.
    *
    * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
    */
    Response<
                    std::list<MailOrder>
        >
    getMailOrders(
    );
}; 

} 

#endif /* TINY_CPP_CLIENT_ServicesApi_H_ */