#ifndef TINY_CPP_CLIENT_SendingApi_H_
#define TINY_CPP_CLIENT_SendingApi_H_


#include "Response.h"
#include "Arduino.h"
#include "Service.h"
#include "Helpers.h"
#include <list>

#include "EmailAddressName.h"
#include "GenericResponse.h"
#include "GetMailOrders_401_response.h"
#include "MailAttachment.h"

namespace Tiny {

/**
 *  Class 
 * Generated with openapi::tiny-cpp-client
 */

class SendingApi : public Service {
public:
    SendingApi() = default;

    virtual ~SendingApi() = default;

    /**
    * Sends an Email with Advanced Options.
    *
    * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
    * \param subject The subject or title of the email *Required*
    * \param body The main email contents. *Required*
    * \param from  *Required*
    * \param to A list of destionation email addresses to send this to *Required*
    * \param replyto (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
    * \param cc (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
    * \param bcc (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
    * \param attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded!
    * \param id (optional)  ID of the Mail order within our system to use as the Mail Account.
    */
    Response<
                GenericResponse
        >
    sendAdvMail(
            
            std::string subject
            , 
            
            std::string body
            , 
            
            EmailAddressName from
            , 
            std::list<EmailAddressName> to
            
            , 
            std::list<EmailAddressName> replyto
            
            , 
            std::list<EmailAddressName> cc
            
            , 
            std::list<EmailAddressName> bcc
            
            , 
            std::list<MailAttachment> attachments
            
            , 
            
            long id
            
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
}; 

} 

#endif /* TINY_CPP_CLIENT_SendingApi_H_ */