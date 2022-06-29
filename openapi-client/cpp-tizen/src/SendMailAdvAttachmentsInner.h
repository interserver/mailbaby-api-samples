/*
 * SendMailAdv_attachments_inner.h
 *
 * A File attachment for an email
 */

#ifndef _SendMailAdv_attachments_inner_H_
#define _SendMailAdv_attachments_inner_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief A File attachment for an email
 *
 *  \ingroup Models
 *
 */

class SendMailAdv_attachments_inner : public Object {
public:
	/*! \brief Constructor.
	 */
	SendMailAdv_attachments_inner();
	SendMailAdv_attachments_inner(char* str);

	/*! \brief Destructor.
	 */
	virtual ~SendMailAdv_attachments_inner();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get Contents of the attached file (must be base64 encoded)
	 */
	std::string getData();

	/*! \brief Set Contents of the attached file (must be base64 encoded)
	 */
	void setData(std::string  data);
	/*! \brief Get (optional) Filename to specify for the attachment.
	 */
	std::string getFilename();

	/*! \brief Set (optional) Filename to specify for the attachment.
	 */
	void setFilename(std::string  filename);

private:
	std::string data;
	std::string filename;
	void __init();
	void __cleanup();

};
}
}

#endif /* _SendMailAdv_attachments_inner_H_ */
