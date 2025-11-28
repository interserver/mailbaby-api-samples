/*
 * SendMailRaw.h
 *
 * Raw Email Object
 */

#ifndef _SendMailRaw_H_
#define _SendMailRaw_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief Raw Email Object
 *
 *  \ingroup Models
 *
 */

class SendMailRaw : public Object {
public:
	/*! \brief Constructor.
	 */
	SendMailRaw();
	SendMailRaw(char* str);

	/*! \brief Destructor.
	 */
	virtual ~SendMailRaw();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get The entire email contents
	 */
	std::string getRawEmail();

	/*! \brief Set The entire email contents
	 */
	void setRawEmail(std::string  raw_email);
	/*! \brief Get Optional order id
	 */
	int getId();

	/*! \brief Set Optional order id
	 */
	void setId(int  id);

private:
	std::string raw_email;
	int id;
	void __init();
	void __cleanup();

};
}
}

#endif /* _SendMailRaw_H_ */
