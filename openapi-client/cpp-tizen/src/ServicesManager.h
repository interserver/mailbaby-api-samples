#ifndef _ServicesManager_H_
#define _ServicesManager_H_

#include <string>
#include <cstring>
#include <list>
#include <glib.h>
#include "GetMailOrders_401_response.h"
#include "MailOrder.h"
#include <list>
#include "Error.h"

/** \defgroup Operations API Endpoints
 *  Classes containing all the functions for calling API endpoints
 *
 */

namespace Tizen{
namespace ArtikCloud {
/** \addtogroup Services Services
 * \ingroup Operations
 *  @{
 */
class ServicesManager {
public:
	ServicesManager();
	virtual ~ServicesManager();

/*! \brief displays a list of mail service orders. *Synchronous*
 *
 * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getMailOrdersSync(char * accessToken,
	
	void(* handler)(std::list<MailOrder>, Error, void* )
	, void* userData);

/*! \brief displays a list of mail service orders. *Asynchronous*
 *
 * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getMailOrdersAsync(char * accessToken,
	
	void(* handler)(std::list<MailOrder>, Error, void* )
	, void* userData);



	static std::string getBasePath()
	{
		return "https://api.mailbaby.net";
	}
};
/** @}*/

}
}
#endif /* ServicesManager_H_ */
