
/*
 * RawMail.h
 *
 * Raw Email Object
 */

#ifndef TINY_CPP_CLIENT_RawMail_H_
#define TINY_CPP_CLIENT_RawMail_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief Raw Email Object
 *
 *  \ingroup Models
 *
 */

class RawMail{
public:

    /*! \brief Constructor.
	 */
    RawMail();
    RawMail(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~RawMail();


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
	void setRawEmail(std::string  raw_email);


    private:
    std::string raw_email{};
};
}

#endif /* TINY_CPP_CLIENT_RawMail_H_ */
