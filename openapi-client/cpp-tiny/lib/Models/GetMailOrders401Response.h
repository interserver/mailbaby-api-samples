
/*
 * GetMailOrders_401_response.h
 *
 * 
 */

#ifndef TINY_CPP_CLIENT_GetMailOrders_401_response_H_
#define TINY_CPP_CLIENT_GetMailOrders_401_response_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief 
 *
 *  \ingroup Models
 *
 */

class GetMailOrders_401_response{
public:

    /*! \brief Constructor.
	 */
    GetMailOrders_401_response();
    GetMailOrders_401_response(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~GetMailOrders_401_response();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get 
	 */
	std::string getCode();

	/*! \brief Set 
	 */
	void setCode(std::string  code);
	/*! \brief Get 
	 */
	std::string getMessage();

	/*! \brief Set 
	 */
	void setMessage(std::string  message);


    private:
    std::string code{};
    std::string message{};
};
}

#endif /* TINY_CPP_CLIENT_GetMailOrders_401_response_H_ */
