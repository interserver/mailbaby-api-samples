
/*
 * SendMailAdv_attachments_inner.h
 *
 * A File attachment for an email
 */

#ifndef TINY_CPP_CLIENT_SendMailAdv_attachments_inner_H_
#define TINY_CPP_CLIENT_SendMailAdv_attachments_inner_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief A File attachment for an email
 *
 *  \ingroup Models
 *
 */

class SendMailAdv_attachments_inner{
public:

    /*! \brief Constructor.
	 */
    SendMailAdv_attachments_inner();
    SendMailAdv_attachments_inner(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~SendMailAdv_attachments_inner();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

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
    std::string data{};
    std::string filename{};
};
}

#endif /* TINY_CPP_CLIENT_SendMailAdv_attachments_inner_H_ */
