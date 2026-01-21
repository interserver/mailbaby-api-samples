
/*
 * EmailAddressTypes.h
 *
 * 
 */

#ifndef TINY_CPP_CLIENT_EmailAddressTypes_H_
#define TINY_CPP_CLIENT_EmailAddressTypes_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"
#include "EmailAddressName.h"

namespace Tiny {


/*! \brief 
 *
 *  \ingroup Models
 *
 */

class EmailAddressTypes{
public:

    /*! \brief Constructor.
	 */
    EmailAddressTypes();
    EmailAddressTypes(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~EmailAddressTypes();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get The email address.
	 */
	std::string getEmail();

	/*! \brief Set The email address.
	 */
	void setEmail(std::string email);
	/*! \brief Get Name to use for the sending contact.
	 */
	std::string getName();

	/*! \brief Set Name to use for the sending contact.
	 */
	void setName(std::string name);


    private:
    std::string email{};
    std::string name{};
};
}

#endif /* TINY_CPP_CLIENT_EmailAddressTypes_H_ */
