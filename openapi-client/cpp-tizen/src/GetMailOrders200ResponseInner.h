/*
 * GetMailOrders_200_response_inner.h
 *
 * 
 */

#ifndef _GetMailOrders_200_response_inner_H_
#define _GetMailOrders_200_response_inner_H_


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

class GetMailOrders_200_response_inner : public Object {
public:
	/*! \brief Constructor.
	 */
	GetMailOrders_200_response_inner();
	GetMailOrders_200_response_inner(char* str);

	/*! \brief Destructor.
	 */
	virtual ~GetMailOrders_200_response_inner();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get 
	 */
	int getId();

	/*! \brief Set 
	 */
	void setId(int  id);
	/*! \brief Get 
	 */
	std::string getStatus();

	/*! \brief Set 
	 */
	void setStatus(std::string  status);
	/*! \brief Get 
	 */
	std::string getUsername();

	/*! \brief Set 
	 */
	void setUsername(std::string  username);
	/*! \brief Get 
	 */
	std::string getPassword();

	/*! \brief Set 
	 */
	void setPassword(std::string  password);
	/*! \brief Get 
	 */
	std::string getComment();

	/*! \brief Set 
	 */
	void setComment(std::string  comment);

private:
	int id;
	std::string status;
	std::string username;
	std::string password;
	std::string comment;
	void __init();
	void __cleanup();

};
}
}

#endif /* _GetMailOrders_200_response_inner_H_ */
