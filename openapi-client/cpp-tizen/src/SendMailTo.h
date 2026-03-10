/*
 * SendMailTo.h
 *
 * The primary recipient address for a simple send request. Accepts a single email address string or an array of email address strings for multiple recipients.
 */

#ifndef _SendMailTo_H_
#define _SendMailTo_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief The primary recipient address for a simple send request. Accepts a single email address string or an array of email address strings for multiple recipients.
 *
 *  \ingroup Models
 *
 */

class SendMailTo : public Object {
public:
	/*! \brief Constructor.
	 */
	SendMailTo();
	SendMailTo(char* str);

	/*! \brief Destructor.
	 */
	virtual ~SendMailTo();

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

#endif /* _SendMailTo_H_ */
