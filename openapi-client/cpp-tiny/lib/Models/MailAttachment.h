
/*
 * MailAttachment.h
 *
 * A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
 */

#ifndef TINY_CPP_CLIENT_MailAttachment_H_
#define TINY_CPP_CLIENT_MailAttachment_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"
#include "ByteArray.h"

namespace Tiny {


/*! \brief A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.
 *
 *  \ingroup Models
 *
 */

class MailAttachment{
public:

    /*! \brief Constructor.
	 */
    MailAttachment();
    MailAttachment(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~MailAttachment();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
	 */
	std::string getFilename();

	/*! \brief Set The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
	 */
	void setFilename(std::string filename);
	/*! \brief Get The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
	 */
	ByteArray getData();

	/*! \brief Set The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
	 */
	void setData(ByteArray data);


    private:
    std::string filename{};
    ByteArray data;
};
}

#endif /* TINY_CPP_CLIENT_MailAttachment_H_ */
