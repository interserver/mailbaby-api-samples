#ifndef TINY_CPP_CLIENT_ServicesApi_H_
#define TINY_CPP_CLIENT_ServicesApi_H_


#include "Response.h"
#include "Arduino.h"
#include "Service.h"
#include "Helpers.h"
#include <list>

#include "ErrorMessage.h"
#include "MailOrder.h"
#include "MailOrderDetail.h"

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
    * Displays details for a single mail order.
    *
    * Returns the full detail record for one specific mail order identified by its numeric `id`.  In addition to the fields returned by `GET /mail`, this endpoint also includes the current **SMTP password** for the order.  The `username` and `password` values returned here can be used directly to authenticate against `relay.mailbaby.net:25` (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The `id` path parameter is the same integer `id` value returned by `GET /mail`. 
    * \param id The numeric ID of the mail order. *Required*
    */
    Response<
                MailOrderDetail
        >
    getMailOrderById(
            
            long id
            
    );
    /**
    * Displays a list of mail service orders.
    *
    * Returns every mail order (active **and** inactive) associated with your account. Each record includes the numeric `id`, the `status` (`active` or `canceled`), the SMTP `username` (always `mb<id>`), and an optional human-readable `comment`.  The `id` values returned here are used as the `id` input parameter on all sending endpoints (`/mail/send`, `/mail/advsend`, `/mail/rawsend`) as well as the log and stats queries.  When the `id` parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use `GET /mail/{id}`. 
    */
    Response<
                    std::list<MailOrder>
        >
    getMailOrders(
    );
}; 

} 

#endif /* TINY_CPP_CLIENT_ServicesApi_H_ */