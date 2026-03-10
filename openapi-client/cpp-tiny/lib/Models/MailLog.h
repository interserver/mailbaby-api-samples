
/*
 * MailLog.h
 *
 * Paginated mail log response returned by &#x60;GET /mail/log&#x60;.  Contains the full matched count (&#x60;total&#x60;) plus a page of &#x60;MailLogEntry&#x60; records.  Use &#x60;skip&#x60; and &#x60;limit&#x60; to page through large result sets.
 */

#ifndef TINY_CPP_CLIENT_MailLog_H_
#define TINY_CPP_CLIENT_MailLog_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"
#include "MailLogEntry.h"
#include <list>

namespace Tiny {


/*! \brief Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.
 *
 *  \ingroup Models
 *
 */

class MailLog{
public:

    /*! \brief Constructor.
	 */
    MailLog();
    MailLog(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~MailLog();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.
	 */
	int getTotal();

	/*! \brief Set Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.
	 */
	void setTotal(int total);
	/*! \brief Get The `skip` value used for this page (echoed from the request).
	 */
	int getSkip();

	/*! \brief Set The `skip` value used for this page (echoed from the request).
	 */
	void setSkip(int skip);
	/*! \brief Get The `limit` value used for this page (echoed from the request).
	 */
	int getLimit();

	/*! \brief Set The `limit` value used for this page (echoed from the request).
	 */
	void setLimit(int limit);
	/*! \brief Get 
	 */
	std::list<MailLogEntry> getEmails();

	/*! \brief Set 
	 */
	void setEmails(std::list<MailLogEntry> emails);


    private:
    int total{};
    int skip{};
    int limit{};
    std::list<MailLogEntry> emails;
};
}

#endif /* TINY_CPP_CLIENT_MailLog_H_ */
