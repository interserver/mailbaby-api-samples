/*
 * GenericResponse.h
 *
 * 
 */

#ifndef _GenericResponse_H_
#define _GenericResponse_H_


#include <string>
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

class GenericResponse : public Object {
public:
	/*! \brief Constructor.
	 */
	GenericResponse();
	GenericResponse(char* str);

	/*! \brief Destructor.
	 */
	virtual ~GenericResponse();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get 
	 */
	std::string getStatus();

	/*! \brief Set 
	 */
	void setStatus(std::string  status);
	/*! \brief Get 
	 */
	std::string getStatusText();

	/*! \brief Set 
	 */
	void setStatusText(std::string  status_text);

private:
	std::string status;
	std::string status_text;
	void __init();
	void __cleanup();

};
}
}

#endif /* _GenericResponse_H_ */
