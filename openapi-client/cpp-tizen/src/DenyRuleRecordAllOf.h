/*
 * DenyRuleRecord_allOf.h
 *
 * 
 */

#ifndef _DenyRuleRecord_allOf_H_
#define _DenyRuleRecord_allOf_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief 
 *
 *  \ingroup Models
 *
 */

class DenyRuleRecord_allOf : public Object {
public:
	/*! \brief Constructor.
	 */
	DenyRuleRecord_allOf();
	DenyRuleRecord_allOf(char* str);

	/*! \brief Destructor.
	 */
	virtual ~DenyRuleRecord_allOf();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get The deny rule Id number.
	 */
	int getId();

	/*! \brief Set The deny rule Id number.
	 */
	void setId(int  id);
	/*! \brief Get the date the rule was created.
	 */
	std::string getCreated();

	/*! \brief Set the date the rule was created.
	 */
	void setCreated(std::string  created);

private:
	int id;
	std::string created;
	void __init();
	void __cleanup();

};
}
}

#endif /* _DenyRuleRecord_allOf_H_ */
