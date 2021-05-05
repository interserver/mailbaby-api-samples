/*
 * Body_1.h
 *
 * Details for an Email
 */

#ifndef _Body_1_H_
#define _Body_1_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief Details for an Email
 *
 *  \ingroup Models
 *
 */

class Body_1 : public Object {
public:
	/*! \brief Constructor.
	 */
	Body_1();
	Body_1(char* str);

	/*! \brief Destructor.
	 */
	virtual ~Body_1();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get The Contact whom is the primary recipient of this email.
	 */
	std::string getTo();

	/*! \brief Set The Contact whom is the primary recipient of this email.
	 */
	void setTo(std::string  to);
	/*! \brief Get The contact whom is the this email is from.
	 */
	std::string getFrom();

	/*! \brief Set The contact whom is the this email is from.
	 */
	void setFrom(std::string  from);
	/*! \brief Get The subject or title of the email
	 */
	std::string getSubject();

	/*! \brief Set The subject or title of the email
	 */
	void setSubject(std::string  subject);
	/*! \brief Get The main email contents.
	 */
	std::string getBody();

	/*! \brief Set The main email contents.
	 */
	void setBody(std::string  body);

private:
	std::string to;
	std::string from;
	std::string subject;
	std::string body;
	void __init();
	void __cleanup();

};
}
}

#endif /* _Body_1_H_ */
