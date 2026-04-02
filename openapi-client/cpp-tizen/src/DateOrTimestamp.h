/*
 * DateOrTimestamp.h
 *
 * A date/time value accepted as either a Unix timestamp (integer seconds since epoch) or a date string parseable by &#x60;strtotime()&#x60; (e.g. &#x60;2024-01-15&#x60;, &#x60;last monday&#x60;).
 */

#ifndef _DateOrTimestamp_H_
#define _DateOrTimestamp_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief A date/time value accepted as either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` (e.g. `2024-01-15`, `last monday`).
 *
 *  \ingroup Models
 *
 */

class DateOrTimestamp : public Object {
public:
	/*! \brief Constructor.
	 */
	DateOrTimestamp();
	DateOrTimestamp(char* str);

	/*! \brief Destructor.
	 */
	virtual ~DateOrTimestamp();

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

#endif /* _DateOrTimestamp_H_ */
