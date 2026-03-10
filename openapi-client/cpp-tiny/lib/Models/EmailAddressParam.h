
/*
 * EmailAddressParam.h
 *
 * A single email address parameter used as the body of &#x60;POST /mail/blocks/delete&#x60;.
 */

#ifndef TINY_CPP_CLIENT_EmailAddressParam_H_
#define TINY_CPP_CLIENT_EmailAddressParam_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief A single email address parameter used as the body of `POST /mail/blocks/delete`.
 *
 *  \ingroup Models
 *
 */

class EmailAddressParam{
public:

    /*! \brief Constructor.
	 */
    EmailAddressParam();
    EmailAddressParam(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~EmailAddressParam();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get The email address to delist from all block lists.
	 */
	std::string getEmail();

	/*! \brief Set The email address to delist from all block lists.
	 */
	void setEmail(std::string email);


    private:
    std::string email{};
};
}

#endif /* TINY_CPP_CLIENT_EmailAddressParam_H_ */
