
/*
 * MailBlockClickHouse.h
 *
 * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
 */

#ifndef TINY_CPP_CLIENT_MailBlockClickHouse_H_
#define TINY_CPP_CLIENT_MailBlockClickHouse_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"
#include "Date.h"

namespace Tiny {


/*! \brief A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 *
 *  \ingroup Models
 *
 */

class MailBlockClickHouse{
public:

    /*! \brief Constructor.
	 */
    MailBlockClickHouse();
    MailBlockClickHouse(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~MailBlockClickHouse();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get The date the block event was recorded.
	 */
	Date getDate();

	/*! \brief Set The date the block event was recorded.
	 */
	void setDate(Date date);
	/*! \brief Get The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
	 */
	std::string getFrom();

	/*! \brief Set The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
	 */
	void setFrom(std::string from);
	/*! \brief Get The `Subject` header of the blocked message.
	 */
	std::string getSubject();

	/*! \brief Set The `Subject` header of the blocked message.
	 */
	void setSubject(std::string subject);
	/*! \brief Get The serialized list of recipients of the blocked message.
	 */
	std::string getTo();

	/*! \brief Set The serialized list of recipients of the blocked message.
	 */
	void setTo(std::string to);
	/*! \brief Get The `Message-ID` header of the blocked message, or `null` if not present.
	 */
	std::string getMessageId();

	/*! \brief Set The `Message-ID` header of the blocked message, or `null` if not present.
	 */
	void setMessageId(std::string messageId);


    private:
    Date date;
    std::string from{};
    std::string subject{};
    std::string to{};
    std::string messageId{};
};
}

#endif /* TINY_CPP_CLIENT_MailBlockClickHouse_H_ */
