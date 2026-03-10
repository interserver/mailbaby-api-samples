/*
 * EmailAddressParam.h
 *
 * A single email address parameter used as the body of &#x60;POST /mail/blocks/delete&#x60;.
 */

#ifndef _EmailAddressParam_H_
#define _EmailAddressParam_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief A single email address parameter used as the body of `POST /mail/blocks/delete`.
 *
 *  \ingroup Models
 *
 */

class EmailAddressParam : public Object {
public:
	/*! \brief Constructor.
	 */
	EmailAddressParam();
	EmailAddressParam(char* str);

	/*! \brief Destructor.
	 */
	virtual ~EmailAddressParam();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get The email address to delist from all block lists.
	 */
	std::string getEmail();

	/*! \brief Set The email address to delist from all block lists.
	 */
	void setEmail(std::string  email);

private:
	std::string email;
	void __init();
	void __cleanup();

};
}
}

#endif /* _EmailAddressParam_H_ */
