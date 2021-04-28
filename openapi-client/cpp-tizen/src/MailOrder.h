/*
 * MailOrder.h
 *
 * 
 */

#ifndef _MailOrder_H_
#define _MailOrder_H_


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

class MailOrder : public Object {
public:
	/*! \brief Constructor.
	 */
	MailOrder();
	MailOrder(char* str);

	/*! \brief Destructor.
	 */
	virtual ~MailOrder();

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

#endif /* _MailOrder_H_ */
