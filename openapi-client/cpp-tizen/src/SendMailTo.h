/*
 * SendMail_to.h
 *
 * The primary recipient address.  Accepts a single email address string or an array of email address strings for multiple recipients.
 */

#ifndef _SendMail_to_H_
#define _SendMail_to_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief The primary recipient address.  Accepts a single email address string or an array of email address strings for multiple recipients.
 *
 *  \ingroup Models
 *
 */

class SendMail_to : public Object {
public:
	/*! \brief Constructor.
	 */
	SendMail_to();
	SendMail_to(char* str);

	/*! \brief Destructor.
	 */
	virtual ~SendMail_to();

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

#endif /* _SendMail_to_H_ */
