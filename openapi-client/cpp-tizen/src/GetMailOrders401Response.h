/*
 * GetMailOrders_401_response.h
 *
 * 
 */

#ifndef _GetMailOrders_401_response_H_
#define _GetMailOrders_401_response_H_


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

class GetMailOrders_401_response : public Object {
public:
	/*! \brief Constructor.
	 */
	GetMailOrders_401_response();
	GetMailOrders_401_response(char* str);

	/*! \brief Destructor.
	 */
	virtual ~GetMailOrders_401_response();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get 
	 */
	std::string getCode();

	/*! \brief Set 
	 */
	void setCode(std::string  code);
	/*! \brief Get 
	 */
	std::string getMessage();

	/*! \brief Set 
	 */
	void setMessage(std::string  message);

private:
	std::string code;
	std::string message;
	void __init();
	void __cleanup();

};
}
}

#endif /* _GetMailOrders_401_response_H_ */
