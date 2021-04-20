#ifndef _DefaultManager_H_
#define _DefaultManager_H_

#include <string>
#include <cstring>
#include <list>
#include <glib.h>
#include "ErrorResponse.h"
#include "ErrorResposne.h"
#include "GenericResponse.h"
#include "MailLog.h"
#include "MailOrder.h"
#include "SendMail.h"
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

/*! \brief Gets mail order information by id. *Synchronous*
 *
 * returns information about a mail order in the system with the given id.
 * \param id User ID *Required*
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getMailByIdSync(char * accessToken,
	long long id, 
	void(* handler)(MailOrder, Error, void* )
	, void* userData);

/*! \brief Gets mail order information by id. *Asynchronous*
 *
 * returns information about a mail order in the system with the given id.
 * \param id User ID *Required*
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getMailByIdAsync(char * accessToken,
	long long id, 
	void(* handler)(MailOrder, Error, void* )
	, void* userData);


/*! \brief displays a list of mail service orders. *Synchronous*
 *
 * 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getMailOrdersSync(char * accessToken,
	
	void(* handler)(std::list<MailOrder>, Error, void* )
	, void* userData);

/*! \brief displays a list of mail service orders. *Asynchronous*
 *
 * 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getMailOrdersAsync(char * accessToken,
	
	void(* handler)(std::list<MailOrder>, Error, void* )
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


/*! \brief places a mail order. *Synchronous*
 *
 * Adds an item to the system
 * \param mailOrder Inventory item to add
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool placeMailOrderSync(char * accessToken,
	MailOrder mailOrder, 
	
	void(* handler)(Error, void* ) , void* userData);

/*! \brief places a mail order. *Asynchronous*
 *
 * Adds an item to the system
 * \param mailOrder Inventory item to add
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool placeMailOrderAsync(char * accessToken,
	MailOrder mailOrder, 
	
	void(* handler)(Error, void* ) , void* userData);


/*! \brief Sends an Email with Advanced Options. *Synchronous*
 *
 * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
 * \param id User ID *Required*
 * \param sendMail  *Required*
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool sendAdvMailByIdSync(char * accessToken,
	long long id, SendMail sendMail, 
	void(* handler)(GenericResponse, Error, void* )
	, void* userData);

/*! \brief Sends an Email with Advanced Options. *Asynchronous*
 *
 * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
 * \param id User ID *Required*
 * \param sendMail  *Required*
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool sendAdvMailByIdAsync(char * accessToken,
	long long id, SendMail sendMail, 
	void(* handler)(GenericResponse, Error, void* )
	, void* userData);


/*! \brief Sends an Email. *Synchronous*
 *
 * Sends An email through one of your mail orders.
 * \param id User ID *Required*
 * \param subject 
 * \param body 
 * \param to 
 * \param toName 
 * \param from 
 * \param fromName 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool sendMailByIdSync(char * accessToken,
	long long id, std::string subject, std::string body, std::string to, std::string toName, std::string from, std::string fromName, 
	void(* handler)(GenericResponse, Error, void* )
	, void* userData);

/*! \brief Sends an Email. *Asynchronous*
 *
 * Sends An email through one of your mail orders.
 * \param id User ID *Required*
 * \param subject 
 * \param body 
 * \param to 
 * \param toName 
 * \param from 
 * \param fromName 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool sendMailByIdAsync(char * accessToken,
	long long id, std::string subject, std::string body, std::string to, std::string toName, std::string from, std::string fromName, 
	void(* handler)(GenericResponse, Error, void* )
	, void* userData);


/*! \brief validatess order details before placing an order. *Synchronous*
 *
 * 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool validateMailOrderSync(char * accessToken,
	
	
	void(* handler)(Error, void* ) , void* userData);

/*! \brief validatess order details before placing an order. *Asynchronous*
 *
 * 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool validateMailOrderAsync(char * accessToken,
	
	
	void(* handler)(Error, void* ) , void* userData);


/*! \brief displays the mail log. *Synchronous*
 *
 * By passing in the appropriate options, you can search for available inventory in the system 
 * \param id User ID *Required*
 * \param searchString pass an optional search string for looking up inventory
 * \param skip number of records to skip for pagination
 * \param limit maximum number of records to return
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool viewMailLogByIdSync(char * accessToken,
	long long id, std::string searchString, int skip, int limit, 
	void(* handler)(std::list<MailLog>, Error, void* )
	, void* userData);

/*! \brief displays the mail log. *Asynchronous*
 *
 * By passing in the appropriate options, you can search for available inventory in the system 
 * \param id User ID *Required*
 * \param searchString pass an optional search string for looking up inventory
 * \param skip number of records to skip for pagination
 * \param limit maximum number of records to return
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool viewMailLogByIdAsync(char * accessToken,
	long long id, std::string searchString, int skip, int limit, 
	void(* handler)(std::list<MailLog>, Error, void* )
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
