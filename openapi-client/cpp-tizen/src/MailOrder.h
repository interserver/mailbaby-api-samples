/*
 * MailOrder.h
 *
 * A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The &#x60;id&#x60; is the numeric identifier used across most API calls.  The &#x60;username&#x60; is always &#x60;mb&lt;id&gt;&#x60; and is the SMTP AUTH username for &#x60;relay.mailbaby.net&#x60;.
 */

#ifndef _MailOrder_H_
#define _MailOrder_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The `id` is the numeric identifier used across most API calls.  The `username` is always `mb<id>` and is the SMTP AUTH username for `relay.mailbaby.net`.
 *
 *  \ingroup Models
 *
 */

class MailOrder : public Object {
public:
	/*! \brief Constructor.
	 */
	MailOrder();
	MailOrder(char* str);

	/*! \brief Destructor.
	 */
	virtual ~MailOrder();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
	 */
	int getId();

	/*! \brief Set The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
	 */
	void setId(int  id);
	/*! \brief Get The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
	 */
	std::string getStatus();

	/*! \brief Set The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
	 */
	void setStatus(std::string  status);
	/*! \brief Get The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
	 */
	std::string getUsername();

	/*! \brief Set The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
	 */
	void setUsername(std::string  username);
	/*! \brief Get Optional human-readable note associated with the order.
	 */
	std::string getComment();

	/*! \brief Set Optional human-readable note associated with the order.
	 */
	void setComment(std::string  comment);

private:
	int id;
	std::string status;
	std::string username;
	std::string comment;
	void __init();
	void __cleanup();

};
}
}

#endif /* _MailOrder_H_ */
