#ifndef TINY_CPP_CLIENT_HistoryApi_H_
#define TINY_CPP_CLIENT_HistoryApi_H_


#include "Response.h"
#include "Arduino.h"
#include "Service.h"
#include "Helpers.h"
#include <list>

#include "ErrorMessage.h"
#include "GetStats_200_response_inner.h"
#include "MailLog.h"

namespace Tiny {

/**
 *  Class 
 * Generated with openapi::tiny-cpp-client
 */

class HistoryApi : public Service {
public:
    HistoryApi() = default;

    virtual ~HistoryApi() = default;

    /**
    * Account usage statistics..
    *
    * Returns information about the usage on your mail accounts.
    */
    Response<
                    std::list<GetStats_200_response_inner>
        >
    getStats(
    );
    /**
    * displays the mail log.
    *
    * Get a listing of the emails sent through this system 
    * \param id The ID of your mail order this will be sent through.
    * \param origin originating ip address sending mail
    * \param mx mx record mail was sent to
    * \param from from email address
    * \param to to/destination email address
    * \param subject subject containing this string
    * \param mailid mail id
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
            
            std::string origin
            , 
            
            std::string mx
            , 
            
            std::string from
            , 
            
            std::string to
            , 
            
            std::string subject
            , 
            
            std::string mailid
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

#endif /* TINY_CPP_CLIENT_HistoryApi_H_ */