
/*
 * SendMailRaw.h
 *
 * Raw Email Object
 */

#ifndef TINY_CPP_CLIENT_SendMailRaw_H_
#define TINY_CPP_CLIENT_SendMailRaw_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief Raw Email Object
 *
 *  \ingroup Models
 *
 */

class SendMailRaw{
public:

    /*! \brief Constructor.
	 */
    SendMailRaw();
    SendMailRaw(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~SendMailRaw();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get The entire email contents
	 */
	std::string getRawEmail();

	/*! \brief Set The entire email contents
	 */
	void setRawEmail(std::string raw_email);
	/*! \brief Get Optional order id
	 */
	int getId();

	/*! \brief Set Optional order id
	 */
	void setId(int id);


    private:
    std::string raw_email{};
    int id{};
};
}

#endif /* TINY_CPP_CLIENT_SendMailRaw_H_ */
