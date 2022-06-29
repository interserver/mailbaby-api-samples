
/*
 * SendMailAdv_from.h
 *
 * The information to use for the From address in the email. from.
 */

#ifndef TINY_CPP_CLIENT_SendMailAdv_from_H_
#define TINY_CPP_CLIENT_SendMailAdv_from_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief The information to use for the From address in the email. from.
 *
 *  \ingroup Models
 *
 */

class SendMailAdv_from{
public:

    /*! \brief Constructor.
	 */
    SendMailAdv_from();
    SendMailAdv_from(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~SendMailAdv_from();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get The email address
	 */
	std::string getEmail();

	/*! \brief Set The email address
	 */
	void setEmail(std::string  email);
	/*! \brief Get (optional) Name to use for the sending contact.
	 */
	std::string getName();

	/*! \brief Set (optional) Name to use for the sending contact.
	 */
	void setName(std::string  name);


    private:
    std::string email{};
    std::string name{};
};
}

#endif /* TINY_CPP_CLIENT_SendMailAdv_from_H_ */
