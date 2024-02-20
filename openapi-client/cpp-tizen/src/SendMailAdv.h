/*
 * SendMailAdv.h
 *
 * Details for an Email
 */

#ifndef _SendMailAdv_H_
#define _SendMailAdv_H_


#include <string>
#include "EmailAddressTypes.h"
#include "EmailAddressesTypes.h"
#include "MailAttachment.h"
#include <list>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief Details for an Email
 *
 *  \ingroup Models
 *
 */

class SendMailAdv : public Object {
public:
	/*! \brief Constructor.
	 */
	SendMailAdv();
	SendMailAdv(char* str);

	/*! \brief Destructor.
	 */
	virtual ~SendMailAdv();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

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
	long long getId();

	/*! \brief Set (optional)  ID of the Mail order within our system to use as the Mail Account.
	 */
	void setId(long long  id);

private:
	std::string subject;
	std::string body;
	EmailAddressTypes from;
	EmailAddressesTypes to;
	EmailAddressesTypes replyto;
	EmailAddressesTypes cc;
	EmailAddressesTypes bcc;
	std::list <MailAttachment>attachments;
	long long id;
	void __init();
	void __cleanup();

};
}
}

#endif /* _SendMailAdv_H_ */
