/*
 * EmailAddressNames.h
 *
 * An array of email contacts, each with an email address and optional display name.
 */

#ifndef _EmailAddressNames_H_
#define _EmailAddressNames_H_


#include <string>
#include "EmailAddressName.h"
#include <list>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief An array of email contacts, each with an email address and optional display name.
 *
 *  \ingroup Models
 *
 */

class EmailAddressNames : public Object {
public:
	/*! \brief Constructor.
	 */
	EmailAddressNames();
	EmailAddressNames(char* str);

	/*! \brief Destructor.
	 */
	virtual ~EmailAddressNames();

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

#endif /* _EmailAddressNames_H_ */
