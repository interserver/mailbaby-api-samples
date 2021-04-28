/*
 * MailAttachment.h
 *
 * A File attachment for an email
 */

#ifndef _MailAttachment_H_
#define _MailAttachment_H_


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

	/*! \brief Get Contents of the attached file
	 */
	std::string getData();

	/*! \brief Set Contents of the attached file
	 */
	void setData(std::string  data);
	/*! \brief Get Optional filename to specify for the attachment.
	 */
	std::string getFilename();

	/*! \brief Set Optional filename to specify for the attachment.
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

#endif /* _MailAttachment_H_ */
