/*
 * ErrorMessage.h
 *
 * The resposne when an error occurs.
 */

#ifndef _ErrorMessage_H_
#define _ErrorMessage_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief The resposne when an error occurs.
 *
 *  \ingroup Models
 *
 */

class ErrorMessage : public Object {
public:
	/*! \brief Constructor.
	 */
	ErrorMessage();
	ErrorMessage(char* str);

	/*! \brief Destructor.
	 */
	virtual ~ErrorMessage();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get The response code associated with the error.
	 */
	int getCode();

	/*! \brief Set The response code associated with the error.
	 */
	void setCode(int  code);
	/*! \brief Get The details or description of the error.
	 */
	std::string getMessage();

	/*! \brief Set The details or description of the error.
	 */
	void setMessage(std::string  message);

private:
	int code;
	std::string message;
	void __init();
	void __cleanup();

};
}
}

#endif /* _ErrorMessage_H_ */
