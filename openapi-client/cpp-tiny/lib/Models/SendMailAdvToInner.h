
/*
 * SendMailAdv_to_inner.h
 *
 * An Email Contact
 */

#ifndef TINY_CPP_CLIENT_SendMailAdv_to_inner_H_
#define TINY_CPP_CLIENT_SendMailAdv_to_inner_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief An Email Contact
 *
 *  \ingroup Models
 *
 */

class SendMailAdv_to_inner{
public:

    /*! \brief Constructor.
	 */
    SendMailAdv_to_inner();
    SendMailAdv_to_inner(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~SendMailAdv_to_inner();


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
	/*! \brief Get (optional) Name to use for the destination contact.
	 */
	std::string getName();

	/*! \brief Set (optional) Name to use for the destination contact.
	 */
	void setName(std::string  name);


    private:
    std::string email{};
    std::string name{};
};
}

#endif /* TINY_CPP_CLIENT_SendMailAdv_to_inner_H_ */
