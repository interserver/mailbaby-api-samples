/*
 * MailAttachment.h
 *
 * A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
 */

#ifndef _MailAttachment_H_
#define _MailAttachment_H_


#include <string>
#include "ByteArray.h"
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.
 *
 *  \ingroup Models
 *
 */

class MailAttachment : public Object {
public:
	/*! \brief Constructor.
	 */
	MailAttachment();
	MailAttachment(char* str);

	/*! \brief Destructor.
	 */
	virtual ~MailAttachment();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
	 */
	std::string getFilename();

	/*! \brief Set The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
	 */
	void setFilename(std::string  filename);
	/*! \brief Get The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
	 */
	ByteArray getData();

	/*! \brief Set The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
	 */
	void setData(ByteArray  data);

private:
	std::string filename;
	ByteArray data;
	void __init();
	void __cleanup();

};
}
}

#endif /* _MailAttachment_H_ */
