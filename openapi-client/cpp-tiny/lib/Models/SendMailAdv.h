
/*
 * SendMailAdv.h
 *
 * Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.
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


/*! \brief Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.
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

	/*! \brief Get The subject line of the email.
	 */
	std::string getSubject();

	/*! \brief Set The subject line of the email.
	 */
	void setSubject(std::string subject);
	/*! \brief Get The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
	 */
	std::string getBody();

	/*! \brief Set The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
	 */
	void setBody(std::string body);
	/*! \brief Get 
	 */
	EmailAddressTypes getFrom();

	/*! \brief Set 
	 */
	void setFrom(EmailAddressTypes from);
	/*! \brief Get 
	 */
	EmailAddressesTypes getTo();

	/*! \brief Set 
	 */
	void setTo(EmailAddressesTypes to);
	/*! \brief Get 
	 */
	EmailAddressesTypes getReplyto();

	/*! \brief Set 
	 */
	void setReplyto(EmailAddressesTypes replyto);
	/*! \brief Get 
	 */
	EmailAddressesTypes getCc();

	/*! \brief Set 
	 */
	void setCc(EmailAddressesTypes cc);
	/*! \brief Get 
	 */
	EmailAddressesTypes getBcc();

	/*! \brief Set 
	 */
	void setBcc(EmailAddressesTypes bcc);
	/*! \brief Get Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
	 */
	std::list<MailAttachment> getAttachments();

	/*! \brief Set Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
	 */
	void setAttachments(std::list<MailAttachment> attachments);
	/*! \brief Get Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
	 */
	long getId();

	/*! \brief Set Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
	 */
	void setId(long id);


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
