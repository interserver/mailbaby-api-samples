/*
 * EmailAddressName.h
 *
 * An email contact with an optional display name.  Used in structured address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;) in &#x60;SendMailAdv&#x60;.
 */

#ifndef _EmailAddressName_H_
#define _EmailAddressName_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief An email contact with an optional display name.  Used in structured address fields (`from`, `to`, `cc`, `bcc`, `replyto`) in `SendMailAdv`.
 *
 *  \ingroup Models
 *
 */

class EmailAddressName : public Object {
public:
	/*! \brief Constructor.
	 */
	EmailAddressName();
	EmailAddressName(char* str);

	/*! \brief Destructor.
	 */
	virtual ~EmailAddressName();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get The email address.
	 */
	std::string getEmail();

	/*! \brief Set The email address.
	 */
	void setEmail(std::string  email);
	/*! \brief Get Optional display name shown to recipients (e.g. in the `From:` header).
	 */
	std::string getName();

	/*! \brief Set Optional display name shown to recipients (e.g. in the `From:` header).
	 */
	void setName(std::string  name);

private:
	std::string email;
	std::string name;
	void __init();
	void __cleanup();

};
}
}

#endif /* _EmailAddressName_H_ */
