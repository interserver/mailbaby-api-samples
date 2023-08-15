
/*
 * DenyRuleRecord_allOf.h
 *
 * 
 */

#ifndef TINY_CPP_CLIENT_DenyRuleRecord_allOf_H_
#define TINY_CPP_CLIENT_DenyRuleRecord_allOf_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief 
 *
 *  \ingroup Models
 *
 */

class DenyRuleRecord_allOf{
public:

    /*! \brief Constructor.
	 */
    DenyRuleRecord_allOf();
    DenyRuleRecord_allOf(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~DenyRuleRecord_allOf();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

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
    int id{};
    std::string created{};
};
}

#endif /* TINY_CPP_CLIENT_DenyRuleRecord_allOf_H_ */
