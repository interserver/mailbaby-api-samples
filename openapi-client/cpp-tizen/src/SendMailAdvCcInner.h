/*
 * SendMailAdv_cc_inner.h
 *
 * An Email Contact
 */

#ifndef _SendMailAdv_cc_inner_H_
#define _SendMailAdv_cc_inner_H_


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

class SendMailAdv_cc_inner : public Object {
public:
	/*! \brief Constructor.
	 */
	SendMailAdv_cc_inner();
	SendMailAdv_cc_inner(char* str);

	/*! \brief Destructor.
	 */
	virtual ~SendMailAdv_cc_inner();

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
	/*! \brief Get (optional) Name to use for the CC contact.
	 */
	std::string getName();

	/*! \brief Set (optional) Name to use for the CC contact.
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

#endif /* _SendMailAdv_cc_inner_H_ */
