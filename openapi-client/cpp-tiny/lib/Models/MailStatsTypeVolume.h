
/*
 * MailStatsType_volume.h
 *
 * Top-500 breakdown of message counts grouped by source IP, destination address, and sender address within the selected &#x60;time&#x60; window.
 */

#ifndef TINY_CPP_CLIENT_MailStatsType_volume_H_
#define TINY_CPP_CLIENT_MailStatsType_volume_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"
#include <map>

namespace Tiny {


/*! \brief Top-500 breakdown of message counts grouped by source IP, destination address, and sender address within the selected `time` window.
 *
 *  \ingroup Models
 *
 */

class MailStatsType_volume{
public:

    /*! \brief Constructor.
	 */
    MailStatsType_volume();
    MailStatsType_volume(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~MailStatsType_volume();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get Message counts keyed by destination (envelope `to`) email address.
	 */
	std::map<std::string, int> getTo();

	/*! \brief Set Message counts keyed by destination (envelope `to`) email address.
	 */
	void setTo(std::map<std::string, int> to);
	/*! \brief Get Message counts keyed by sender (envelope `from`) email address.
	 */
	std::map<std::string, int> getFrom();

	/*! \brief Set Message counts keyed by sender (envelope `from`) email address.
	 */
	void setFrom(std::map<std::string, int> from);
	/*! \brief Get Message counts keyed by originating client IP address.
	 */
	std::map<std::string, int> getIp();

	/*! \brief Set Message counts keyed by originating client IP address.
	 */
	void setIp(std::map<std::string, int> ip);


    private:
    std::map<std::string, int> to;
    std::map<std::string, int> from;
    std::map<std::string, int> ip;
};
}

#endif /* TINY_CPP_CLIENT_MailStatsType_volume_H_ */
