#ifndef _HistoryManager_H_
#define _HistoryManager_H_

#include <string>
#include <cstring>
#include <list>
#include <glib.h>
#include "GetMailOrders_401_response.h"
#include "GetStats_200_response_inner.h"
#include "MailLog.h"
#include <list>
#include "Error.h"

/** \defgroup Operations API Endpoints
 *  Classes containing all the functions for calling API endpoints
 *
 */

namespace Tizen{
namespace ArtikCloud {
/** \addtogroup History History
 * \ingroup Operations
 *  @{
 */
class HistoryManager {
public:
	HistoryManager();
	virtual ~HistoryManager();

/*! \brief displays a list of blocked email addresses. *Synchronous*
 *
 * 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getStatsSync(char * accessToken,
	
	void(* handler)(std::list<GetStats_200_response_inner>, Error, void* )
	, void* userData);

/*! \brief displays a list of blocked email addresses. *Asynchronous*
 *
 * 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getStatsAsync(char * accessToken,
	
	void(* handler)(std::list<GetStats_200_response_inner>, Error, void* )
	, void* userData);


/*! \brief displays the mail log. *Synchronous*
 *
 * Get a listing of the emails sent through this system 
 * \param id The ID of your mail order this will be sent through.
 * \param origin originating ip address sending mail
 * \param mx mx record mail was sent to
 * \param from from email address
 * \param to to/destination email address
 * \param subject subject containing this string
 * \param mailid mail id
 * \param skip number of records to skip for pagination
 * \param limit maximum number of records to return
 * \param startDate earliest date to get emails in unix timestamp format
 * \param endDate earliest date to get emails in unix timestamp format
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool viewMailLogSync(char * accessToken,
	long long id, std::string origin, std::string mx, std::string from, std::string to, std::string subject, std::string mailid, int skip, int limit, long long startDate, long long endDate, 
	void(* handler)(MailLog, Error, void* )
	, void* userData);

/*! \brief displays the mail log. *Asynchronous*
 *
 * Get a listing of the emails sent through this system 
 * \param id The ID of your mail order this will be sent through.
 * \param origin originating ip address sending mail
 * \param mx mx record mail was sent to
 * \param from from email address
 * \param to to/destination email address
 * \param subject subject containing this string
 * \param mailid mail id
 * \param skip number of records to skip for pagination
 * \param limit maximum number of records to return
 * \param startDate earliest date to get emails in unix timestamp format
 * \param endDate earliest date to get emails in unix timestamp format
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool viewMailLogAsync(char * accessToken,
	long long id, std::string origin, std::string mx, std::string from, std::string to, std::string subject, std::string mailid, int skip, int limit, long long startDate, long long endDate, 
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
#endif /* HistoryManager_H_ */
