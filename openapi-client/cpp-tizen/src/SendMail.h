/*
 * SendMail.h
 *
 * Details for an Email
 */

#ifndef _SendMail_H_
#define _SendMail_H_


#include <string>
#include "MailAttachment.h"
#include "MailContact.h"
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

class SendMail : public Object {
public:
	/*! \brief Constructor.
	 */
	SendMail();
	SendMail(char* str);

	/*! \brief Destructor.
	 */
	virtual ~SendMail();

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
	MailContact getFrom();

	/*! \brief Set 
	 */
	void setFrom(MailContact  from);
	/*! \brief Get The Contact whom is the primary recipient of this email.
	 */
	std::list<MailContact> getTo();

	/*! \brief Set The Contact whom is the primary recipient of this email.
	 */
	void setTo(std::list <MailContact> to);
	/*! \brief Get The ID of the Mail order within our system to use as the Mail Account.
	 */
	long long getId();

	/*! \brief Set The ID of the Mail order within our system to use as the Mail Account.
	 */
	void setId(long long  id);
	/*! \brief Get Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.
	 */
	std::list<MailContact> getReplyto();

	/*! \brief Set Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.
	 */
	void setReplyto(std::list <MailContact> replyto);
	/*! \brief Get Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
	 */
	std::list<MailContact> getCc();

	/*! \brief Set Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
	 */
	void setCc(std::list <MailContact> cc);
	/*! \brief Get Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
	 */
	std::list<MailContact> getBcc();

	/*! \brief Set Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
	 */
	void setBcc(std::list <MailContact> bcc);
	/*! \brief Get Optional file attachments to include in the email
	 */
	std::list<MailAttachment> getAttachments();

	/*! \brief Set Optional file attachments to include in the email
	 */
	void setAttachments(std::list <MailAttachment> attachments);

private:
	std::string subject;
	std::string body;
	MailContact from;
	std::list <MailContact>to;
	long long id;
	std::list <MailContact>replyto;
	std::list <MailContact>cc;
	std::list <MailContact>bcc;
	std::list <MailAttachment>attachments;
	void __init();
	void __cleanup();

};
}
}

#endif /* _SendMail_H_ */
