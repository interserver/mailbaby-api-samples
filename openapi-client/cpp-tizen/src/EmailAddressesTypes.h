/*
 * EmailAddressesTypes.h
 *
 * 
 */

#ifndef _EmailAddressesTypes_H_
#define _EmailAddressesTypes_H_


#include <string>
#include "EmailAddressName.h"
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief 
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
