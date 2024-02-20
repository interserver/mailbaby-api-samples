
/*
 * ErrorMessage.h
 *
 * The resposne when an error occurs.
 */

#ifndef TINY_CPP_CLIENT_ErrorMessage_H_
#define TINY_CPP_CLIENT_ErrorMessage_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief The resposne when an error occurs.
 *
 *  \ingroup Models
 *
 */

class ErrorMessage{
public:

    /*! \brief Constructor.
	 */
    ErrorMessage();
    ErrorMessage(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~ErrorMessage();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get The response code associated with the error.
	 */
	int getCode();

	/*! \brief Set The response code associated with the error.
	 */
	void setCode(int  code);
	/*! \brief Get The details or description of the error.
	 */
	std::string getMessage();

	/*! \brief Set The details or description of the error.
	 */
	void setMessage(std::string  message);


    private:
    int code{};
    std::string message{};
};
}

#endif /* TINY_CPP_CLIENT_ErrorMessage_H_ */
