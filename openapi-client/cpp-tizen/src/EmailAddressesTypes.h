/*
 * EmailAddressesTypes.h
 *
 * A flexible email address list that accepts either a plain RFC 822 string or a structured array of contact objects.  When a string is provided it is parsed as a comma-separated list of RFC 822 addresses (supporting the &#x60;\&quot;Name &lt;email&gt;\&quot;&#x60; and bare &#x60;email&#x60; formats).  When an array is provided each entry must have at least an &#x60;email&#x60; field with an optional &#x60;name&#x60; field.
 */

#ifndef _EmailAddressesTypes_H_
#define _EmailAddressesTypes_H_


#include <string>
#include "EmailAddressNames.h"
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief A flexible email address list that accepts either a plain RFC 822 string or a structured array of contact objects.  When a string is provided it is parsed as a comma-separated list of RFC 822 addresses (supporting the `\"Name <email>\"` and bare `email` formats).  When an array is provided each entry must have at least an `email` field with an optional `name` field.
 *
 *  \ingroup Models
 *
 */

class EmailAddressesTypes : public Object {
public:
	/*! \brief Constructor.
	 */
	EmailAddressesTypes();
	EmailAddressesTypes(char* str);

	/*! \brief Destructor.
	 */
	virtual ~EmailAddressesTypes();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);


private:
	void __init();
	void __cleanup();

};
}
}

#endif /* _EmailAddressesTypes_H_ */
