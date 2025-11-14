/*
 * RawMail.h
 *
 * Raw Email Object
 */

#ifndef _RawMail_H_
#define _RawMail_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief Raw Email Object
 *
 *  \ingroup Models
 *
 */

class RawMail : public Object {
public:
	/*! \brief Constructor.
	 */
	RawMail();
	RawMail(char* str);

	/*! \brief Destructor.
	 */
	virtual ~RawMail();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get The entire email contents
	 */
	std::string getRawEmail();

	/*! \brief Set The entire email contents
	 */
	void setRawEmail(std::string  raw_email);

private:
	std::string raw_email;
	void __init();
	void __cleanup();

};
}
}

#endif /* _RawMail_H_ */
