/*
 * MailBlockRspamd.h
 *
 * A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
 */

#ifndef _MailBlockRspamd_H_
#define _MailBlockRspamd_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 *
 *  \ingroup Models
 *
 */

class MailBlockRspamd : public Object {
public:
	/*! \brief Constructor.
	 */
	MailBlockRspamd();
	MailBlockRspamd(char* str);

	/*! \brief Destructor.
	 */
	virtual ~MailBlockRspamd();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.
	 */
	std::string getFrom();

	/*! \brief Set The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.
	 */
	void setFrom(std::string  from);
	/*! \brief Get The suspicious subject pattern that triggered the block.
	 */
	std::string getSubject();

	/*! \brief Set The suspicious subject pattern that triggered the block.
	 */
	void setSubject(std::string  subject);

private:
	std::string from;
	std::string subject;
	void __init();
	void __cleanup();

};
}
}

#endif /* _MailBlockRspamd_H_ */
