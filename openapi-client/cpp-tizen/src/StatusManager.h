#ifndef _StatusManager_H_
#define _StatusManager_H_

#include <string>
#include <cstring>
#include <list>
#include <glib.h>
#include "Error.h"

/** \defgroup Operations API Endpoints
 *  Classes containing all the functions for calling API endpoints
 *
 */

namespace Tizen{
namespace ArtikCloud {
/** \addtogroup Status Status
 * \ingroup Operations
 *  @{
 */
class StatusManager {
public:
	StatusManager();
	virtual ~StatusManager();

/*! \brief Checks if the server is running. *Synchronous*
 *
 * A lightweight health-check endpoint.  Returns a plain-text `200 OK` when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks. 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool pingServerSync(char * accessToken,
	
	
	void(* handler)(Error, void* ) , void* userData);

/*! \brief Checks if the server is running. *Asynchronous*
 *
 * A lightweight health-check endpoint.  Returns a plain-text `200 OK` when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks. 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool pingServerAsync(char * accessToken,
	
	
	void(* handler)(Error, void* ) , void* userData);



	static std::string getBasePath()
	{
		return "https://api.mailbaby.net";
	}
};
/** @}*/

}
}
#endif /* StatusManager_H_ */
