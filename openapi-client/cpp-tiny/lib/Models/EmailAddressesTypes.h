
/*
 * EmailAddressesTypes.h
 *
 * A flexible email address list that accepts either a plain RFC 822 string or a structured array of contact objects.  When a string is provided it is parsed as a comma-separated list of RFC 822 addresses (supporting the &#x60;\&quot;Name &lt;email&gt;\&quot;&#x60; and bare &#x60;email&#x60; formats).  When an array is provided each entry must have at least an &#x60;email&#x60; field with an optional &#x60;name&#x60; field.
 */

#ifndef TINY_CPP_CLIENT_EmailAddressesTypes_H_
#define TINY_CPP_CLIENT_EmailAddressesTypes_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"
#include "EmailAddressNames.h"

namespace Tiny {


/*! \brief A flexible email address list that accepts either a plain RFC 822 string or a structured array of contact objects.  When a string is provided it is parsed as a comma-separated list of RFC 822 addresses (supporting the `\"Name <email>\"` and bare `email` formats).  When an array is provided each entry must have at least an `email` field with an optional `name` field.
 *
 *  \ingroup Models
 *
 */

class EmailAddressesTypes{
public:

    /*! \brief Constructor.
	 */
    EmailAddressesTypes();
    EmailAddressesTypes(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~EmailAddressesTypes();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);



    private:
};
}

#endif /* TINY_CPP_CLIENT_EmailAddressesTypes_H_ */
