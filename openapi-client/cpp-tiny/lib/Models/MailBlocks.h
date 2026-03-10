
/*
 * MailBlocks.h
 *
 * The complete set of blocked addresses and message patterns returned by &#x60;GET /mail/blocks&#x60;.  Three independent block sources are combined into one response. Use &#x60;POST /mail/blocks/delete&#x60; with a &#x60;from&#x60; address from any entry to delist it.
 */

#ifndef TINY_CPP_CLIENT_MailBlocks_H_
#define TINY_CPP_CLIENT_MailBlocks_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"
#include "MailBlockClickHouse.h"
#include "MailBlockRspamd.h"
#include <list>

namespace Tiny {


/*! \brief The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`.  Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.
 *
 *  \ingroup Models
 *
 */

class MailBlocks{
public:

    /*! \brief Constructor.
	 */
    MailBlocks();
    MailBlocks(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~MailBlocks();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
	 */
	std::list<MailBlockClickHouse> getLocal();

	/*! \brief Set Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
	 */
	void setLocal(std::list<MailBlockClickHouse> local);
	/*! \brief Get Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.
	 */
	std::list<MailBlockClickHouse> getMbtrap();

	/*! \brief Set Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.
	 */
	void setMbtrap(std::list<MailBlockClickHouse> mbtrap);
	/*! \brief Get Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.
	 */
	std::list<MailBlockRspamd> getSubject();

	/*! \brief Set Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.
	 */
	void setSubject(std::list<MailBlockRspamd> subject);


    private:
    std::list<MailBlockClickHouse> local;
    std::list<MailBlockClickHouse> mbtrap;
    std::list<MailBlockRspamd> subject;
};
}

#endif /* TINY_CPP_CLIENT_MailBlocks_H_ */
