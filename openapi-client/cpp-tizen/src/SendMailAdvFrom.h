/*
 * SendMailAdv_from.h
 *
 * The information to use for the From address in the email. from.
 */

#ifndef _SendMailAdv_from_H_
#define _SendMailAdv_from_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief The information to use for the From address in the email. from.
 *
 *  \ingroup Models
 *
 */

class SendMailAdv_from : public Object {
public:
	/*! \brief Constructor.
	 */
	SendMailAdv_from();
	SendMailAdv_from(char* str);

	/*! \brief Destructor.
	 */
	virtual ~SendMailAdv_from();

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
	/*! \brief Get (optional) Name to use for the sending contact.
	 */
	std::string getName();

	/*! \brief Set (optional) Name to use for the sending contact.
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

#endif /* _SendMailAdv_from_H_ */
