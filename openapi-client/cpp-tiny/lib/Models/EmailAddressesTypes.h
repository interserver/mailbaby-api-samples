
/*
 * EmailAddressesTypes.h
 *
 * 
 */

#ifndef TINY_CPP_CLIENT_EmailAddressesTypes_H_
#define TINY_CPP_CLIENT_EmailAddressesTypes_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"
#include "EmailAddressName.h"

namespace Tiny {


/*! \brief 
 *
 *  \ingroup Models
 *
 */

class EmailAddressesTypes{
public:

    /*! \brief Constructor.
	 */
    EmailAddressesTypes();
    EmailAddressesTypes(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~EmailAddressesTypes();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);



    private:
};
}

#endif /* TINY_CPP_CLIENT_EmailAddressesTypes_H_ */
