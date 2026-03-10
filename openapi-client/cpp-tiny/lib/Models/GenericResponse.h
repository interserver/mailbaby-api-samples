
/*
 * GenericResponse.h
 *
 * Standard success response returned by write operations (send, add rule, delete, etc.).  The &#x60;status&#x60; field is always &#x60;\&quot;ok\&quot;&#x60; on success.  The &#x60;text&#x60; field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record&#39;s ID; for delete calls it contains a confirmation string.
 */

#ifndef TINY_CPP_CLIENT_GenericResponse_H_
#define TINY_CPP_CLIENT_GenericResponse_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief Standard success response returned by write operations (send, add rule, delete, etc.).  The `status` field is always `\"ok\"` on success.  The `text` field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record's ID; for delete calls it contains a confirmation string.
 *
 *  \ingroup Models
 *
 */

class GenericResponse{
public:

    /*! \brief Constructor.
	 */
    GenericResponse();
    GenericResponse(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~GenericResponse();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get Always `\"ok\"` on success.
	 */
	std::string getStatus();

	/*! \brief Set Always `\"ok\"` on success.
	 */
	void setStatus(std::string status);
	/*! \brief Get Operation-specific result string.  For send operations this is the relay transaction ID (e.g. `185caa69ff7000f47c`) which can be used as the `mailid` parameter in `GET /mail/log`.  For create operations this is the new record's numeric ID.  For delete operations this is a human-readable confirmation.
	 */
	std::string getText();

	/*! \brief Set Operation-specific result string.  For send operations this is the relay transaction ID (e.g. `185caa69ff7000f47c`) which can be used as the `mailid` parameter in `GET /mail/log`.  For create operations this is the new record's numeric ID.  For delete operations this is a human-readable confirmation.
	 */
	void setText(std::string text);


    private:
    std::string status{};
    std::string text{};
};
}

#endif /* TINY_CPP_CLIENT_GenericResponse_H_ */
