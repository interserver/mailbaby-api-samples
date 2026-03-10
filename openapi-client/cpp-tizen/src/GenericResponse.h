/*
 * GenericResponse.h
 *
 * Standard success response returned by write operations (send, add rule, delete, etc.).  The &#x60;status&#x60; field is always &#x60;\&quot;ok\&quot;&#x60; on success.  The &#x60;text&#x60; field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record&#39;s ID; for delete calls it contains a confirmation string.
 */

#ifndef _GenericResponse_H_
#define _GenericResponse_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief Standard success response returned by write operations (send, add rule, delete, etc.).  The `status` field is always `\"ok\"` on success.  The `text` field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record's ID; for delete calls it contains a confirmation string.
 *
 *  \ingroup Models
 *
 */

class GenericResponse : public Object {
public:
	/*! \brief Constructor.
	 */
	GenericResponse();
	GenericResponse(char* str);

	/*! \brief Destructor.
	 */
	virtual ~GenericResponse();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get Always `\"ok\"` on success.
	 */
	std::string getStatus();

	/*! \brief Set Always `\"ok\"` on success.
	 */
	void setStatus(std::string  status);
	/*! \brief Get Operation-specific result string.  For send operations this is the relay transaction ID (e.g. `185caa69ff7000f47c`) which can be used as the `mailid` parameter in `GET /mail/log`.  For create operations this is the new record's numeric ID.  For delete operations this is a human-readable confirmation.
	 */
	std::string getText();

	/*! \brief Set Operation-specific result string.  For send operations this is the relay transaction ID (e.g. `185caa69ff7000f47c`) which can be used as the `mailid` parameter in `GET /mail/log`.  For create operations this is the new record's numeric ID.  For delete operations this is a human-readable confirmation.
	 */
	void setText(std::string  text);

private:
	std::string status;
	std::string text;
	void __init();
	void __cleanup();

};
}
}

#endif /* _GenericResponse_H_ */
