
/*
 * SendMailAdv.h
 *
 * Details for an Email
 */

#ifndef TINY_CPP_CLIENT_SendMailAdv_H_
#define TINY_CPP_CLIENT_SendMailAdv_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"
#include "EmailAddressTypes.h"
#include "EmailAddressesTypes.h"
#include "MailAttachment.h"
#include <list>

namespace Tiny {


/*! \brief Details for an Email
 *
 *  \ingroup Models
 *
 */

class SendMailAdv{
public:

    /*! \brief Constructor.
	 */
    SendMailAdv();
    SendMailAdv(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~SendMailAdv();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get The subject or title of the email
	 */
	std::string getSubject();

	/*! \brief Set The subject or title of the email
	 */
	void setSubject(std::string  subject);
	/*! \brief Get The main email contents.
	 */
	std::string getBody();

	/*! \brief Set The main email contents.
	 */
	void setBody(std::string  body);
	/*! \brief Get 
	 */
	EmailAddressTypes getFrom();

	/*! \brief Set 
	 */
	void setFrom(EmailAddressTypes  from);
	/*! \brief Get 
	 */
	EmailAddressesTypes getTo();

	/*! \brief Set 
	 */
	void setTo(EmailAddressesTypes  to);
	/*! \brief Get 
	 */
	EmailAddressesTypes getReplyto();

	/*! \brief Set 
	 */
	void setReplyto(EmailAddressesTypes  replyto);
	/*! \brief Get 
	 */
	EmailAddressesTypes getCc();

	/*! \brief Set 
	 */
	void setCc(EmailAddressesTypes  cc);
	/*! \brief Get 
	 */
	EmailAddressesTypes getBcc();

	/*! \brief Set 
	 */
	void setBcc(EmailAddressesTypes  bcc);
	/*! \brief Get (optional) File attachments to include in the email.  The file contents must be base64 encoded!
	 */
	std::list<MailAttachment> getAttachments();

	/*! \brief Set (optional) File attachments to include in the email.  The file contents must be base64 encoded!
	 */
	void setAttachments(std::list <MailAttachment> attachments);
	/*! \brief Get (optional)  ID of the Mail order within our system to use as the Mail Account.
	 */
	long getId();

	/*! \brief Set (optional)  ID of the Mail order within our system to use as the Mail Account.
	 */
	void setId(long  id);


    private:
    std::string subject{};
    std::string body{};
    EmailAddressTypes from;
    EmailAddressesTypes to;
    EmailAddressesTypes replyto;
    EmailAddressesTypes cc;
    EmailAddressesTypes bcc;
    std::list<MailAttachment> attachments;
    long id{};
};
}

#endif /* TINY_CPP_CLIENT_SendMailAdv_H_ */
