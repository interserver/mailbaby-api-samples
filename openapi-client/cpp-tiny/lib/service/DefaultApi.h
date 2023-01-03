#ifndef TINY_CPP_CLIENT_DefaultApi_H_
#define TINY_CPP_CLIENT_DefaultApi_H_


#include "Response.h"
#include "Arduino.h"
#include "Service.h"
#include "Helpers.h"
#include <list>

#include "GenericResponse.h"
#include "GetMailOrders_200_response_inner.h"
#include "GetMailOrders_401_response.h"
#include "MailLog.h"
#include "SendMailAdv.h"

namespace Tiny {

/**
 *  Class 
 * Generated with openapi::tiny-cpp-client
 */

class DefaultApi : public Service {
public:
    DefaultApi() = default;

    virtual ~DefaultApi() = default;

    /**
    * displays a list of mail service orders.
    *
    * 
    */
    Response<
                    std::list<GetMailOrders_200_response_inner>
        >
    getMailOrders(
    );
    /**
    * Checks if the server is running.
    *
    * 
    */
    Response<
            String
        >
    pingServer(
    );
    /**
    * Sends an Email with Advanced Options.
    *
    * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
    * \param sendMailAdv  *Required*
    */
    Response<
                GenericResponse
        >
    sendAdvMail(
            
            SendMailAdv sendMailAdv
            
    );
    /**
    * Sends an Email.
    *
    * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
    * \param to The Contact whom is the primary recipient of this email. *Required*
    * \param from The contact whom is the this email is from. *Required*
    * \param subject The subject or title of the email *Required*
    * \param body The main email contents. *Required*
    */
    Response<
                GenericResponse
        >
    sendMail(
            
            std::string to
            , 
            
            std::string from
            , 
            
            std::string subject
            , 
            
            std::string body
            
    );
    /**
    * displays the mail log.
    *
    * By passing in the appropriate options, you can search for available inventory in the system 
    * \param id The ID of your mail order this will be sent through.
    * \param search pass an optional search string for looking up inventory
    * \param skip number of records to skip for pagination
    * \param limit maximum number of records to return
    * \param startDate earliest date to get emails in unix timestamp format
    * \param endDate earliest date to get emails in unix timestamp format
    */
    Response<
                MailLog
        >
    viewMailLog(
            
            long id
            , 
            
            std::string search
            , 
            
            int skip
            , 
            
            int limit
            , 
            
            long startDate
            , 
            
            long endDate
            
    );
}; 

} 

#endif /* TINY_CPP_CLIENT_DefaultApi_H_ */