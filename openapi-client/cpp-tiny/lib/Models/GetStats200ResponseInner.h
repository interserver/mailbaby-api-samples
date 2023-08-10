
/*
 * GetStats_200_response_inner.h
 *
 * 
 */

#ifndef TINY_CPP_CLIENT_GetStats_200_response_inner_H_
#define TINY_CPP_CLIENT_GetStats_200_response_inner_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief 
 *
 *  \ingroup Models
 *
 */

class GetStats_200_response_inner{
public:

    /*! \brief Constructor.
	 */
    GetStats_200_response_inner();
    GetStats_200_response_inner(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~GetStats_200_response_inner();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

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
    int id{};
    std::string status{};
    std::string username{};
    std::string password{};
    std::string comment{};
};
}

#endif /* TINY_CPP_CLIENT_GetStats_200_response_inner_H_ */
