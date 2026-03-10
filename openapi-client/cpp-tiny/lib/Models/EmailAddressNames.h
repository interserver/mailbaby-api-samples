
/*
 * EmailAddressNames.h
 *
 * An array of email contacts, each with an email address and optional display name.
 */

#ifndef TINY_CPP_CLIENT_EmailAddressNames_H_
#define TINY_CPP_CLIENT_EmailAddressNames_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"
#include "EmailAddressName.h"
#include <list>

namespace Tiny {


/*! \brief An array of email contacts, each with an email address and optional display name.
 *
 *  \ingroup Models
 *
 */

class EmailAddressNames{
public:

    /*! \brief Constructor.
	 */
    EmailAddressNames();
    EmailAddressNames(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~EmailAddressNames();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);



    private:
};
}

#endif /* TINY_CPP_CLIENT_EmailAddressNames_H_ */
