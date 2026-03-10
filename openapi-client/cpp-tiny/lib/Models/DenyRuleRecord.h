
/*
 * DenyRuleRecord.h
 *
 * A complete deny rule record as returned by &#x60;GET /mail/rules&#x60;.  Combines the rule definition fields (&#x60;DenyRuleNew&#x60;) with server-assigned metadata (&#x60;id&#x60; and &#x60;created&#x60;).  The &#x60;id&#x60; value is required by &#x60;DELETE /mail/rules/{ruleId}&#x60;.
 */

#ifndef TINY_CPP_CLIENT_DenyRuleRecord_H_
#define TINY_CPP_CLIENT_DenyRuleRecord_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief A complete deny rule record as returned by `GET /mail/rules`.  Combines the rule definition fields (`DenyRuleNew`) with server-assigned metadata (`id` and `created`).  The `id` value is required by `DELETE /mail/rules/{ruleId}`.
 *
 *  \ingroup Models
 *
 */

class DenyRuleRecord{
public:

    /*! \brief Constructor.
	 */
    DenyRuleRecord();
    DenyRuleRecord(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~DenyRuleRecord();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get The type of deny rule.
	 */
	std::string getType();

	/*! \brief Set The type of deny rule.
	 */
	void setType(std::string type);
	/*! \brief Get The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
	 */
	std::string getData();

	/*! \brief Set The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
	 */
	void setData(std::string data);
	/*! \brief Get The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule.
	 */
	std::string getId();

	/*! \brief Set The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule.
	 */
	void setId(std::string id);
	/*! \brief Get The timestamp when the rule was created.
	 */
	std::string getCreated();

	/*! \brief Set The timestamp when the rule was created.
	 */
	void setCreated(std::string created);
	/*! \brief Get Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
	 */
	std::string getUser();

	/*! \brief Set Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
	 */
	void setUser(std::string user);


    private:
    std::string type{};
    std::string data{};
    std::string id{};
    std::string created{};
    std::string user{};
};
}

#endif /* TINY_CPP_CLIENT_DenyRuleRecord_H_ */
