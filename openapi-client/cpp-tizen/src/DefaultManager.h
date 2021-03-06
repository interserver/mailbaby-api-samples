#ifndef _DefaultManager_H_
#define _DefaultManager_H_

#include <string>
#include <cstring>
#include <list>
#include <glib.h>
#include "GenericResponse.h"
#include "GetMailOrders_200_response_inner.h"
#include "GetMailOrders_401_response.h"
#include "MailLog.h"
#include "SendMailAdv.h"
#include "Error.h"

/** \defgroup Operations API Endpoints
 *  Classes containing all the functions for calling API endpoints
 *
 */

namespace Tizen{
namespace ArtikCloud {
/** \addtogroup Default Default
 * \ingroup Operations
 *  @{
 */
class DefaultManager {
public:
	DefaultManager();
	virtual ~DefaultManager();

/*! \brief displays a list of mail service orders. *Synchronous*
 *
 * 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getMailOrdersSync(char * accessToken,
	
	void(* handler)(std::list<GetMailOrders_200_response_inner>, Error, void* )
	, void* userData);

/*! \brief displays a list of mail service orders. *Asynchronous*
 *
 * 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getMailOrdersAsync(char * accessToken,
	
	void(* handler)(std::list<GetMailOrders_200_response_inner>, Error, void* )
	, void* userData);


/*! \brief Checks if the server is running. *Synchronous*
 *
 * 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool pingServerSync(char * accessToken,
	
	
	void(* handler)(Error, void* ) , void* userData);

/*! \brief Checks if the server is running. *Asynchronous*
 *
 * 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool pingServerAsync(char * accessToken,
	
	
	void(* handler)(Error, void* ) , void* userData);


/*! \brief Sends an Email with Advanced Options. *Synchronous*
 *
 * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
 * \param sendMailAdv  *Required*
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool sendAdvMailSync(char * accessToken,
	std::shared_ptr<SendMailAdv> sendMailAdv, 
	void(* handler)(GenericResponse, Error, void* )
	, void* userData);

/*! \brief Sends an Email with Advanced Options. *Asynchronous*
 *
 * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
 * \param sendMailAdv  *Required*
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool sendAdvMailAsync(char * accessToken,
	std::shared_ptr<SendMailAdv> sendMailAdv, 
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


/*! \brief displays the mail log. *Synchronous*
 *
 * By passing in the appropriate options, you can search for available inventory in the system 
 * \param id The ID of your mail order this will be sent through.
 * \param search pass an optional search string for looking up inventory
 * \param skip number of records to skip for pagination
 * \param limit maximum number of records to return
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool viewMailLogSync(char * accessToken,
	long long id, std::string search, int skip, int limit, 
	void(* handler)(MailLog, Error, void* )
	, void* userData);

/*! \brief displays the mail log. *Asynchronous*
 *
 * By passing in the appropriate options, you can search for available inventory in the system 
 * \param id The ID of your mail order this will be sent through.
 * \param search pass an optional search string for looking up inventory
 * \param skip number of records to skip for pagination
 * \param limit maximum number of records to return
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool viewMailLogAsync(char * accessToken,
	long long id, std::string search, int skip, int limit, 
	void(* handler)(MailLog, Error, void* )
	, void* userData);



	static std::string getBasePath()
	{
		return "https://api.mailbaby.net";
	}
};
/** @}*/

}
}
#endif /* DefaultManager_H_ */
