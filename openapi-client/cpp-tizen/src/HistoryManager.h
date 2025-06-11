#ifndef _HistoryManager_H_
#define _HistoryManager_H_

#include <string>
#include <cstring>
#include <list>
#include <glib.h>
#include "ErrorMessage.h"
#include "MailLog.h"
#include "MailStatsType.h"
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

/*! \brief Account usage statistics.. *Synchronous*
 *
 * Returns information about the usage on your mail accounts.
 * \param time The timeframe for the statistics.
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getStatsSync(char * accessToken,
	std::string time, 
	void(* handler)(MailStatsType, Error, void* )
	, void* userData);

/*! \brief Account usage statistics.. *Asynchronous*
 *
 * Returns information about the usage on your mail accounts.
 * \param time The timeframe for the statistics.
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool getStatsAsync(char * accessToken,
	std::string time, 
	void(* handler)(MailStatsType, Error, void* )
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
 * \param replyto Reply-To Email Address
 * \param headerfrom Header From Email Address
 * \param delivered Limiting the emails to wether or not they were delivered.
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool viewMailLogSync(char * accessToken,
	long long id, std::string origin, std::string mx, std::string from, std::string to, std::string subject, std::string mailid, int skip, int limit, long long startDate, long long endDate, std::string replyto, std::string headerfrom, std::string delivered, 
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
 * \param replyto Reply-To Email Address
 * \param headerfrom Header From Email Address
 * \param delivered Limiting the emails to wether or not they were delivered.
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool viewMailLogAsync(char * accessToken,
	long long id, std::string origin, std::string mx, std::string from, std::string to, std::string subject, std::string mailid, int skip, int limit, long long startDate, long long endDate, std::string replyto, std::string headerfrom, std::string delivered, 
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
