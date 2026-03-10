/*
 * SendMail.h
 *
 * Request body for &#x60;POST /mail/send&#x60;.  Sends a simple single-recipient message. HTML detection is automatic — if &#x60;body&#x60; contains HTML tags the message is sent as &#x60;text/html&#x60;; otherwise as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is automatically set as both the &#x60;From&#x60; and &#x60;Reply-To&#x60; headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use &#x60;POST /mail/advsend&#x60; instead.
 */

#ifndef _SendMail_H_
#define _SendMail_H_


#include <string>
#include "SendMail_to.h"
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief Request body for `POST /mail/send`.  Sends a simple single-recipient message. HTML detection is automatic — if `body` contains HTML tags the message is sent as `text/html`; otherwise as `text/plain`.  The `from` address is automatically set as both the `From` and `Reply-To` headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use `POST /mail/advsend` instead.
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

	/*! \brief Get 
	 */
	SendMail_to getTo();

	/*! \brief Set 
	 */
	void setTo(SendMail_to  to);
	/*! \brief Get The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
	 */
	std::string getFrom();

	/*! \brief Set The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
	 */
	void setFrom(std::string  from);
	/*! \brief Get The subject line of the email.
	 */
	std::string getSubject();

	/*! \brief Set The subject line of the email.
	 */
	void setSubject(std::string  subject);
	/*! \brief Get The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
	 */
	std::string getBody();

	/*! \brief Set The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
	 */
	void setBody(std::string  body);
	/*! \brief Get Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
	 */
	long long getId();

	/*! \brief Set Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
	 */
	void setId(long long  id);

private:
	SendMail_to to;
	std::string from;
	std::string subject;
	std::string body;
	long long id;
	void __init();
	void __cleanup();

};
}
}

#endif /* _SendMail_H_ */
