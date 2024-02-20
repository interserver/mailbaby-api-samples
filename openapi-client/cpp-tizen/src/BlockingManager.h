#ifndef _BlockingManager_H_
#define _BlockingManager_H_

#include <string>
#include <cstring>
#include <list>
#include <glib.h>
#include "DenyRuleRecord.h"
#include "ErrorMessage.h"
#include "GenericResponse.h"
#include "MailBlocks.h"
#include <list>
#include "Error.h"

/** \defgroup Operations API Endpoints
 *  Classes containing all the functions for calling API endpoints
 *
 */

namespace Tizen{
namespace ArtikCloud {
/** \addtogroup Blocking Blocking
 * \ingroup Operations
 *  @{
 */
class BlockingManager {
public:
	BlockingManager();
	virtual ~BlockingManager();

/*! \brief Creates a new email deny rule.. *Synchronous*
 *
 * Adds a new email deny rule into the system to block new emails that match the given criteria
 * \param type The type of deny rule. *Required*
 * \param data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. *Required*
 * \param user Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool addRuleSync(char * accessToken,
	std::string type, std::string data, std::string user, 
	void(* handler)(GenericResponse, Error, void* )
	, void* userData);

/*! \brief Creates a new email deny rule.. *Asynchronous*
 *
 * Adds a new email deny rule into the system to block new emails that match the given criteria
 * \param type The type of deny rule. *Required*
 * \param data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. *Required*
 * \param user Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool addRuleAsync(char * accessToken,
	std::string type, std::string data, std::string user, 
	void(* handler)(GenericResponse, Error, void* )
	, void* userData);


/*! \brief Removes an deny mail rule.. *Synchronous*
 *
 * Removes one of the configured deny mail rules from the system.
 * \param ruleId The ID of the Rules entry. *Required*
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool deleteRuleSync(char * accessToken,
	int ruleId, 
	void(* handler)(GenericResponse, Error, void* )
	, void* userData);

/*! \brief Removes an deny mail rule.. *Asynchronous*
 *
 * Removes one of the configured deny mail rules from the system.
 * \param ruleId The ID of the Rules entry. *Required*
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool deleteRuleAsync(char * accessToken,
	int ruleId, 
	void(* handler)(GenericResponse, Error, void* )
	, void* userData);


/*! \brief Removes an email address from the blocked list. *Synchronous*
 *
 * Removes an email address from the various block lists. 
 * \param body  *Required*
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool delistBlockSync(char * accessToken,
	std::string body, 
	void(* handler)(GenericResponse, Error, void* )
	, void* userData);

/*! \brief Removes an email address from the blocked list. *Asynchronous*
 *
 * Removes an email address from the various block lists. 
 * \param body  *Required*
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool delistBlockAsync(char * accessToken,
	std::string body, 
	void(* handler)(GenericResponse, Error, void* )
	, void* userData);


/*! \brief displays a list of blocked email addresses. *Synchronous*
 *
 * 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getMailBlocksSync(char * accessToken,
	
	void(* handler)(MailBlocks, Error, void* )
	, void* userData);

/*! \brief displays a list of blocked email addresses. *Asynchronous*
 *
 * 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getMailBlocksAsync(char * accessToken,
	
	void(* handler)(MailBlocks, Error, void* )
	, void* userData);


/*! \brief Displays a listing of deny email rules.. *Synchronous*
 *
 * Returns a listing of all the deny block rules you have configured.
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getRulesSync(char * accessToken,
	
	void(* handler)(std::list<DenyRuleRecord>, Error, void* )
	, void* userData);

/*! \brief Displays a listing of deny email rules.. *Asynchronous*
 *
 * Returns a listing of all the deny block rules you have configured.
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getRulesAsync(char * accessToken,
	
	void(* handler)(std::list<DenyRuleRecord>, Error, void* )
	, void* userData);



	static std::string getBasePath()
	{
		return "https://api.mailbaby.net";
	}
};
/** @}*/

}
}
#endif /* BlockingManager_H_ */
