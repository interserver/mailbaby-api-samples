/*
 * MailOrderDetail.h
 *
 * Extended mail order record including the current SMTP password.  Returned by &#x60;GET /mail/{id}&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; fields can be used to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
 */

#ifndef _MailOrderDetail_H_
#define _MailOrderDetail_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
 *
 *  \ingroup Models
 *
 */

class MailOrderDetail : public Object {
public:
	/*! \brief Constructor.
	 */
	MailOrderDetail();
	MailOrderDetail(char* str);

	/*! \brief Destructor.
	 */
	virtual ~MailOrderDetail();

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
	/*! \brief Get The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.
	 */
	std::string getPassword();

	/*! \brief Set The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.
	 */
	void setPassword(std::string  password);
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
	std::string password;
	std::string comment;
	void __init();
	void __cleanup();

};
}
}

#endif /* _MailOrderDetail_H_ */
