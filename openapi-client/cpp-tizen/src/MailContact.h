/*
 * MailContact.h
 *
 * An Email Contact
 */

#ifndef _MailContact_H_
#define _MailContact_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief An Email Contact
 *
 *  \ingroup Models
 *
 */

class MailContact : public Object {
public:
	/*! \brief Constructor.
	 */
	MailContact();
	MailContact(char* str);

	/*! \brief Destructor.
	 */
	virtual ~MailContact();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get The email address
	 */
	std::string getEmail();

	/*! \brief Set The email address
	 */
	void setEmail(std::string  email);
	/*! \brief Get Optional contact name
	 */
	std::string getName();

	/*! \brief Set Optional contact name
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

#endif /* _MailContact_H_ */
