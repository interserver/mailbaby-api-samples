
/*
 * DenyRuleNew.h
 *
 * The fields required to create a new email deny rule via &#x60;POST /mail/rules&#x60;. The &#x60;type&#x60; controls what &#x60;data&#x60; is matched against: - &#x60;email&#x60; — exact sender address match - &#x60;domain&#x60; — all senders from a domain - &#x60;destination&#x60; — exact recipient address match - &#x60;startswith&#x60; — sender local-part prefix match (alphanumeric + &#x60;+_.-&#x60; only)
 */

#ifndef TINY_CPP_CLIENT_DenyRuleNew_H_
#define TINY_CPP_CLIENT_DenyRuleNew_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief The fields required to create a new email deny rule via `POST /mail/rules`. The `type` controls what `data` is matched against: - `email` — exact sender address match - `domain` — all senders from a domain - `destination` — exact recipient address match - `startswith` — sender local-part prefix match (alphanumeric + `+_.-` only)
 *
 *  \ingroup Models
 *
 */

class DenyRuleNew{
public:

    /*! \brief Constructor.
	 */
    DenyRuleNew();
    DenyRuleNew(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~DenyRuleNew();


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
	/*! \brief Get Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
	 */
	std::string getUser();

	/*! \brief Set Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
	 */
	void setUser(std::string user);


    private:
    std::string type{};
    std::string data{};
    std::string user{};
};
}

#endif /* TINY_CPP_CLIENT_DenyRuleNew_H_ */
