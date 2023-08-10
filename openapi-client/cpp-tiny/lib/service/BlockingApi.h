#ifndef TINY_CPP_CLIENT_BlockingApi_H_
#define TINY_CPP_CLIENT_BlockingApi_H_


#include "Response.h"
#include "Arduino.h"
#include "Service.h"
#include "Helpers.h"
#include <list>

#include "DenyRuleRecord.h"
#include "EmailAddress.h"
#include "GenericResponse.h"
#include "GetMailOrders_401_response.h"
#include "MailBlocks.h"

namespace Tiny {

/**
 *  Class 
 * Generated with openapi::tiny-cpp-client
 */

class BlockingApi : public Service {
public:
    BlockingApi() = default;

    virtual ~BlockingApi() = default;

    /**
    * Creates a new email deny rule..
    *
    * Adds a new email deny rule into the system to block new emails that match the given criteria
    * \param type The type of deny rule. *Required*
    * \param data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. *Required*
    * \param user Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
    */
    Response<
                GenericResponse
        >
    addRule(
            
            std::string type
            , 
            
            std::string data
            , 
            
            std::string user
            
    );
    /**
    * Removes an deny mail rule..
    *
    * Removes one of the configured deny mail rules from the system.
    * \param ruleId The ID of the Rules entry. *Required*
    */
    Response<
                GenericResponse
        >
    deleteRule(
            
            int ruleId
            
    );
    /**
    * Removes an email address from the blocked list.
    *
    * Removes an email address from the various block lists. 
    * \param emailAddress  *Required*
    */
    Response<
                GenericResponse
        >
    delistBlock(
            
            EmailAddress emailAddress
            
    );
    /**
    * displays a list of blocked email addresses.
    *
    * 
    */
    Response<
                MailBlocks
        >
    getMailBlocks(
    );
    /**
    * Displays a listing of deny email rules..
    *
    * Returns a listing of all the deny block rules you have configured.
    */
    Response<
                    std::list<DenyRuleRecord>
        >
    getRules(
    );
}; 

} 

#endif /* TINY_CPP_CLIENT_BlockingApi_H_ */