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

    virtual ~ServicesApi();

    /**
    * Get one mail order's full detail including SMTP password.
    *
    * **Returns the SMTP password** in addition to the basic `GET /mail` fields. Use when you need to authenticate against `relay.mailbaby.net:25` from an SMTP client directly. Required: `id` (path; obtain from `GET /mail`). Returns the full detail record for one specific mail order identified by its numeric `id`.  The `username` and `password` values returned here can be used directly to authenticate against `relay.mailbaby.net:25` (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The `id` path parameter is the same integer `id` value returned by `GET /mail`. 
    * \param id The numeric ID of the mail order. *Required*
    */
    Response<
                MailOrderDetail
        >
    getMailOrderById(
            
            long id
            
    );
    /**
    * List your provisioned mail orders (sending accounts).
    *
    * Use this **before sending** if you need to discover which mail order `id` to pass to `/mail/send`, `/mail/advsend`, `/mail/rawsend`, `/mail/log`, or `/mail/stats`. Returns every mail order (active **and** canceled) on your account. Each record includes the numeric `id`, the `status` (`active` or `canceled`), the SMTP `username` (always `mb<id>`), and an optional `comment`.  The `id` values returned here are used as the `id` input parameter on all sending endpoints (`/mail/send`, `/mail/advsend`, `/mail/rawsend`) as well as the log and stats queries.  When the `id` parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use `GET /mail/{id}`. 
    */
    Response<
                    std::list<MailOrder>
        >
    getMailOrders(
    );
}; 

} 

#endif /* TINY_CPP_CLIENT_ServicesApi_H_ */