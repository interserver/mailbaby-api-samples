/*
 * MailBlockClickHouse.h
 *
 * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
 */

#ifndef _MailBlockClickHouse_H_
#define _MailBlockClickHouse_H_


#include <string>
#include "Date.h"
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 *
 *  \ingroup Models
 *
 */

class MailBlockClickHouse : public Object {
public:
	/*! \brief Constructor.
	 */
	MailBlockClickHouse();
	MailBlockClickHouse(char* str);

	/*! \brief Destructor.
	 */
	virtual ~MailBlockClickHouse();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get The date the block event was recorded.
	 */
	Date getDate();

	/*! \brief Set The date the block event was recorded.
	 */
	void setDate(Date  date);
	/*! \brief Get The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
	 */
	std::string getFrom();

	/*! \brief Set The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
	 */
	void setFrom(std::string  from);
	/*! \brief Get The `Subject` header of the blocked message.
	 */
	std::string getSubject();

	/*! \brief Set The `Subject` header of the blocked message.
	 */
	void setSubject(std::string  subject);
	/*! \brief Get The serialized list of recipients of the blocked message.
	 */
	std::string getTo();

	/*! \brief Set The serialized list of recipients of the blocked message.
	 */
	void setTo(std::string  to);
	/*! \brief Get The `Message-ID` header of the blocked message, or `null` if not present.
	 */
	std::string getMessageId();

	/*! \brief Set The `Message-ID` header of the blocked message, or `null` if not present.
	 */
	void setMessageId(std::string  messageId);

private:
	Date date;
	std::string from;
	std::string subject;
	std::string to;
	std::string messageId;
	void __init();
	void __cleanup();

};
}
}

#endif /* _MailBlockClickHouse_H_ */
