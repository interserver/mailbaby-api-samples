
/*
 * EmailAddressTypes.h
 *
 * A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a structured contact object.
 */

#ifndef TINY_CPP_CLIENT_EmailAddressTypes_H_
#define TINY_CPP_CLIENT_EmailAddressTypes_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"
#include "EmailAddressName.h"

namespace Tiny {


/*! \brief A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (`\"Name <email>\"`), or a structured contact object.
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
	/*! \brief Get Optional display name shown to recipients (e.g. in the `From:` header).
	 */
	std::string getName();

	/*! \brief Set Optional display name shown to recipients (e.g. in the `From:` header).
	 */
	void setName(std::string name);


    private:
    std::string email{};
    std::string name{};
};
}

#endif /* TINY_CPP_CLIENT_EmailAddressTypes_H_ */
