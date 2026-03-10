
/*
 * MailLogEntry.h
 *
 * A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.
 */

#ifndef TINY_CPP_CLIENT_MailLogEntry_H_
#define TINY_CPP_CLIENT_MailLogEntry_H_


#include <string>
#include "bourne/json.hpp"
#include "Helpers.h"

namespace Tiny {


/*! \brief A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The `id` field matches the `mailid` query parameter on `GET /mail/log` and   the `text` field of a successful send response. - The `from` address can be passed to `POST /mail/blocks/delete` to delist a   flagged sender. - The `user` field is the SMTP username (e.g. `mb5658`) corresponding to the   `username` field in `GET /mail` / `GET /mail/{id}`.
 *
 *  \ingroup Models
 *
 */

class MailLogEntry{
public:

    /*! \brief Constructor.
	 */
    MailLogEntry();
    MailLogEntry(std::string jsonString);


    /*! \brief Destructor.
	 */
    virtual ~MailLogEntry();


    /*! \brief Retrieve a bourne JSON representation of this class.
	 */
    bourne::json toJson();


    /*! \brief Fills in members of this class from bourne JSON object representing it.
	 */
    void fromJson(std::string jsonObj);

	/*! \brief Get Internal auto-increment database row ID.  Not meaningful outside the API.
	 */
	int getId();

	/*! \brief Set Internal auto-increment database row ID.  Not meaningful outside the API.
	 */
	void setId(int _id);
	/*! \brief Get The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.
	 */
	std::string getId();

	/*! \brief Set The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.
	 */
	void setId(std::string id);
	/*! \brief Get SMTP envelope `MAIL FROM` address (may differ from the `From:` header).
	 */
	std::string getFrom();

	/*! \brief Set SMTP envelope `MAIL FROM` address (may differ from the `From:` header).
	 */
	void setFrom(std::string from);
	/*! \brief Get SMTP envelope `RCPT TO` address.
	 */
	std::string getTo();

	/*! \brief Set SMTP envelope `RCPT TO` address.
	 */
	void setTo(std::string to);
	/*! \brief Get Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.
	 */
	std::string getCreated();

	/*! \brief Set Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.
	 */
	void setCreated(std::string created);
	/*! \brief Get Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.
	 */
	int getTime();

	/*! \brief Set Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.
	 */
	void setTime(int time);
	/*! \brief Get The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.
	 */
	std::string getUser();

	/*! \brief Set The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.
	 */
	void setUser(std::string user);
	/*! \brief Get SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).
	 */
	std::string getTranstype();

	/*! \brief Set SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).
	 */
	void setTranstype(std::string transtype);
	/*! \brief Get IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.
	 */
	std::string getOrigin();

	/*! \brief Set IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.
	 */
	void setOrigin(std::string origin);
	/*! \brief Get Relay interface name that accepted the message (e.g. `feeder`).
	 */
	std::string getInterface();

	/*! \brief Set Relay interface name that accepted the message (e.g. `feeder`).
	 */
	void setInterface(std::string interface);
	/*! \brief Get The `Subject` header value, if available.
	 */
	std::string getSubject();

	/*! \brief Set The `Subject` header value, if available.
	 */
	void setSubject(std::string subject);
	/*! \brief Get The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
	 */
	std::string getMessageId();

	/*! \brief Set The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
	 */
	void setMessageId(std::string messageId);
	/*! \brief Get The sending zone assigned by the relay for outbound delivery.
	 */
	std::string getSendingZone();

	/*! \brief Set The sending zone assigned by the relay for outbound delivery.
	 */
	void setSendingZone(std::string sendingZone);
	/*! \brief Get Size of the message body in bytes.
	 */
	int getBodySize();

	/*! \brief Set Size of the message body in bytes.
	 */
	void setBodySize(int bodySize);
	/*! \brief Get Sequence index of this recipient in a multi-recipient message. Starts at 1.
	 */
	int getSeq();

	/*! \brief Set Sequence index of this recipient in a multi-recipient message. Starts at 1.
	 */
	void setSeq(int seq);
	/*! \brief Get Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
	 */
	int getDelivered();

	/*! \brief Set Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
	 */
	void setDelivered(int delivered);
	/*! \brief Get The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
	 */
	std::string getResponse();

	/*! \brief Set The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
	 */
	void setResponse(std::string response);
	/*! \brief Get The specific recipient address this delivery record is for.
	 */
	std::string getRecipient();

	/*! \brief Set The specific recipient address this delivery record is for.
	 */
	void setRecipient(std::string recipient);
	/*! \brief Get The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
	 */
	std::string getDomain();

	/*! \brief Set The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
	 */
	void setDomain(std::string domain);
	/*! \brief Get Whether the queue entry is currently locked for delivery processing.
	 */
	int getLocked();

	/*! \brief Set Whether the queue entry is currently locked for delivery processing.
	 */
	void setLocked(int locked);
	/*! \brief Get Millisecond-precision timestamp of the last queue lock acquisition.
	 */
	std::string getLockTime();

	/*! \brief Set Millisecond-precision timestamp of the last queue lock acquisition.
	 */
	void setLockTime(std::string lockTime);
	/*! \brief Get The relay server node assigned to deliver this message.
	 */
	std::string getAssigned();

	/*! \brief Set The relay server node assigned to deliver this message.
	 */
	void setAssigned(std::string assigned);
	/*! \brief Get ISO 8601 timestamp when the message was placed into the delivery queue.
	 */
	std::string getQueued();

	/*! \brief Set ISO 8601 timestamp when the message was placed into the delivery queue.
	 */
	void setQueued(std::string queued);
	/*! \brief Get The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
	 */
	std::string getMxHostname();

	/*! \brief Set The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
	 */
	void setMxHostname(std::string mxHostname);


    private:
    int _id{};
    std::string id{};
    std::string from{};
    std::string to{};
    std::string created{};
    int time{};
    std::string user{};
    std::string transtype{};
    std::string origin{};
    std::string interface{};
    std::string subject{};
    std::string messageId{};
    std::string sendingZone{};
    int bodySize{};
    int seq{};
    int delivered{};
    std::string response{};
    std::string recipient{};
    std::string domain{};
    int locked{};
    std::string lockTime{};
    std::string assigned{};
    std::string queued{};
    std::string mxHostname{};
};
}

#endif /* TINY_CPP_CLIENT_MailLogEntry_H_ */
