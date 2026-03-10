/*
 * MailStatsType_volume.h
 *
 * Top-500 breakdown of message counts grouped by source IP, destination address, and sender address within the selected &#x60;time&#x60; window.
 */

#ifndef _MailStatsType_volume_H_
#define _MailStatsType_volume_H_


#include <string>
#include <map>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief Top-500 breakdown of message counts grouped by source IP, destination address, and sender address within the selected `time` window.
 *
 *  \ingroup Models
 *
 */

class MailStatsType_volume : public Object {
public:
	/*! \brief Constructor.
	 */
	MailStatsType_volume();
	MailStatsType_volume(char* str);

	/*! \brief Destructor.
	 */
	virtual ~MailStatsType_volume();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get Message counts keyed by destination (envelope `to`) email address.
	 */
	std::map<std::string, std::string> getTo();

	/*! \brief Set Message counts keyed by destination (envelope `to`) email address.
	 */
	void setTo(std::map <std::string, std::string> to);
	/*! \brief Get Message counts keyed by sender (envelope `from`) email address.
	 */
	std::map<std::string, std::string> getFrom();

	/*! \brief Set Message counts keyed by sender (envelope `from`) email address.
	 */
	void setFrom(std::map <std::string, std::string> from);
	/*! \brief Get Message counts keyed by originating client IP address.
	 */
	std::map<std::string, std::string> getIp();

	/*! \brief Set Message counts keyed by originating client IP address.
	 */
	void setIp(std::map <std::string, std::string> ip);

private:
	std::map <std::string, std::string>to;
	std::map <std::string, std::string>from;
	std::map <std::string, std::string>ip;
	void __init();
	void __cleanup();

};
}
}

#endif /* _MailStatsType_volume_H_ */
