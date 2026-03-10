
/*
 * MailBlockRspamd.h
 *
 * A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
 */

#ifndef TINY_CPP_CLIENT_MailBlockRspamd_H_
#define TINY_CPP_CLIENT_MailBlockRspamd_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 *
 *  \ingroup Models
 *
 */

class MailBlockRspamd{
public:

    /*! \brief Constructor.
	 */
    MailBlockRspamd();
    MailBlockRspamd(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~MailBlockRspamd();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.
	 */
	std::string getFrom();

	/*! \brief Set The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.
	 */
	void setFrom(std::string from);
	/*! \brief Get The suspicious subject pattern that triggered the block.
	 */
	std::string getSubject();

	/*! \brief Set The suspicious subject pattern that triggered the block.
	 */
	void setSubject(std::string subject);


    private:
    std::string from{};
    std::string subject{};
};
}

#endif /* TINY_CPP_CLIENT_MailBlockRspamd_H_ */
