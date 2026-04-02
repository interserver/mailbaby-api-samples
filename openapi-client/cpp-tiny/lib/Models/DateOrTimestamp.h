
/*
 * DateOrTimestamp.h
 *
 * A date/time value accepted as either a Unix timestamp (integer seconds since epoch) or a date string parseable by &#x60;strtotime()&#x60; (e.g. &#x60;2024-01-15&#x60;, &#x60;last monday&#x60;).
 */

#ifndef TINY_CPP_CLIENT_DateOrTimestamp_H_
#define TINY_CPP_CLIENT_DateOrTimestamp_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief A date/time value accepted as either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` (e.g. `2024-01-15`, `last monday`).
 *
 *  \ingroup Models
 *
 */

class DateOrTimestamp{
public:

    /*! \brief Constructor.
	 */
    DateOrTimestamp();
    DateOrTimestamp(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~DateOrTimestamp();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);



    private:
};
}

#endif /* TINY_CPP_CLIENT_DateOrTimestamp_H_ */
