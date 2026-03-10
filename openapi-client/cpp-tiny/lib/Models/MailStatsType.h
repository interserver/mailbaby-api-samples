
/*
 * MailStatsType.h
 *
 * Account usage statistics returned by &#x60;GET /mail/stats&#x60;.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 */

#ifndef TINY_CPP_CLIENT_MailStatsType_H_
#define TINY_CPP_CLIENT_MailStatsType_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"
#include "MailStatsType_volume.h"

namespace Tiny {


/*! \brief Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 *
 *  \ingroup Models
 *
 */

class MailStatsType{
public:

    /*! \brief Constructor.
	 */
    MailStatsType();
    MailStatsType(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~MailStatsType();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get The time window these `received`, `sent`, and `volume` statistics cover.
	 */
	std::string getTime();

	/*! \brief Set The time window these `received`, `sent`, and `volume` statistics cover.
	 */
	void setTime(std::string time);
	/*! \brief Get Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
	 */
	int getUsage();

	/*! \brief Set Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
	 */
	void setUsage(int usage);
	/*! \brief Get The ISO 4217 currency code for this account (e.g. `USD`).
	 */
	std::string getCurrency();

	/*! \brief Set The ISO 4217 currency code for this account (e.g. `USD`).
	 */
	void setCurrency(std::string currency);
	/*! \brief Get Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
	 */
	double getCost();

	/*! \brief Set Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
	 */
	void setCost(double cost);
	/*! \brief Get Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
	 */
	int getReceived();

	/*! \brief Set Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
	 */
	void setReceived(int received);
	/*! \brief Get Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
	 */
	int getSent();

	/*! \brief Set Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
	 */
	void setSent(int sent);
	/*! \brief Get 
	 */
	MailStatsType_volume getVolume();

	/*! \brief Set 
	 */
	void setVolume(MailStatsType_volume volume);


    private:
    std::string time{};
    int usage{};
    std::string currency{};
    double cost{};
    int received{};
    int sent{};
    MailStatsType_volume volume;
};
}

#endif /* TINY_CPP_CLIENT_MailStatsType_H_ */
