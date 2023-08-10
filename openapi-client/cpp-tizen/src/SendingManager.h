#ifndef _SendingManager_H_
#define _SendingManager_H_

#include <string>
#include <cstring>
#include <list>
#include <glib.h>
#include "EmailAddressName.h"
#include "GenericResponse.h"
#include "GetMailOrders_401_response.h"
#include "MailAttachment.h"
#include "Error.h"

/** \defgroup Operations API Endpoints
 *  Classes containing all the functions for calling API endpoints
 *
 */

namespace Tizen{
namespace ArtikCloud {
/** \addtogroup Sending Sending
 * \ingroup Operations
 *  @{
 */
class SendingManager {
public:
	SendingManager();
	virtual ~SendingManager();

/*! \brief Sends an Email with Advanced Options. *Synchronous*
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
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool sendAdvMailSync(char * accessToken,
	std::string subject, std::string body, EmailAddressName from, std::list<EmailAddressName> to, std::list<EmailAddressName> replyto, std::list<EmailAddressName> cc, std::list<EmailAddressName> bcc, std::list<MailAttachment> attachments, long long id, 
	void(* handler)(GenericResponse, Error, void* )
	, void* userData);

/*! \brief Sends an Email with Advanced Options. *Asynchronous*
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
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool sendAdvMailAsync(char * accessToken,
	std::string subject, std::string body, EmailAddressName from, std::list<EmailAddressName> to, std::list<EmailAddressName> replyto, std::list<EmailAddressName> cc, std::list<EmailAddressName> bcc, std::list<MailAttachment> attachments, long long id, 
	void(* handler)(GenericResponse, Error, void* )
	, void* userData);


/*! \brief Sends an Email. *Synchronous*
 *
 * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
 * \param to The Contact whom is the primary recipient of this email. *Required*
 * \param from The contact whom is the this email is from. *Required*
 * \param subject The subject or title of the email *Required*
 * \param body The main email contents. *Required*
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool sendMailSync(char * accessToken,
	std::string to, std::string from, std::string subject, std::string body, 
	void(* handler)(GenericResponse, Error, void* )
	, void* userData);

/*! \brief Sends an Email. *Asynchronous*
 *
 * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
 * \param to The Contact whom is the primary recipient of this email. *Required*
 * \param from The contact whom is the this email is from. *Required*
 * \param subject The subject or title of the email *Required*
 * \param body The main email contents. *Required*
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool sendMailAsync(char * accessToken,
	std::string to, std::string from, std::string subject, std::string body, 
	void(* handler)(GenericResponse, Error, void* )
	, void* userData);



	static std::string getBasePath()
	{
		return "https://api.mailbaby.net";
	}
};
/** @}*/

}
}
#endif /* SendingManager_H_ */
