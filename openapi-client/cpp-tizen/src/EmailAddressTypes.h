/*
 * EmailAddressTypes.h
 *
 * 
 */

#ifndef _EmailAddressTypes_H_
#define _EmailAddressTypes_H_


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

class EmailAddressTypes : public Object {
public:
	/*! \brief Constructor.
	 */
	EmailAddressTypes();
	EmailAddressTypes(char* str);

	/*! \brief Destructor.
	 */
	virtual ~EmailAddressTypes();

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
	/*! \brief Get Name to use for the sending contact.
	 */
	std::string getName();

	/*! \brief Set Name to use for the sending contact.
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

#endif /* _EmailAddressTypes_H_ */
