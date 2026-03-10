
/*
 * SendMailTo.h
 *
 * The primary recipient address for a simple send request. Accepts a single email address string or an array of email address strings for multiple recipients.
 */

#ifndef TINY_CPP_CLIENT_SendMailTo_H_
#define TINY_CPP_CLIENT_SendMailTo_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief The primary recipient address for a simple send request. Accepts a single email address string or an array of email address strings for multiple recipients.
 *
 *  \ingroup Models
 *
 */

class SendMailTo{
public:

    /*! \brief Constructor.
	 */
    SendMailTo();
    SendMailTo(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~SendMailTo();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);



    private:
};
}

#endif /* TINY_CPP_CLIENT_SendMailTo_H_ */
