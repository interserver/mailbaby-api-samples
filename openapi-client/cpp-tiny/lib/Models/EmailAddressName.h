
/*
 * EmailAddressName.h
 *
 * An email contact with an optional display name.  Used in structured address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;) in &#x60;SendMailAdv&#x60;.
 */

#ifndef TINY_CPP_CLIENT_EmailAddressName_H_
#define TINY_CPP_CLIENT_EmailAddressName_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief An email contact with an optional display name.  Used in structured address fields (`from`, `to`, `cc`, `bcc`, `replyto`) in `SendMailAdv`.
 *
 *  \ingroup Models
 *
 */

class EmailAddressName{
public:

    /*! \brief Constructor.
	 */
    EmailAddressName();
    EmailAddressName(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~EmailAddressName();


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

#endif /* TINY_CPP_CLIENT_EmailAddressName_H_ */
