/*
 * MailLogEntry.h
 *
 * An email record
 */

#ifndef _MailLogEntry_H_
#define _MailLogEntry_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief An email record
 *
 *  \ingroup Models
 *
 */

class MailLogEntry : public Object {
public:
	/*! \brief Constructor.
	 */
	MailLogEntry();
	MailLogEntry(char* str);

	/*! \brief Destructor.
	 */
	virtual ~MailLogEntry();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get internal db id
	 */
	int getId();

	/*! \brief Set internal db id
	 */
	void setId(int  _id);
	/*! \brief Get mail id
	 */
	std::string getId();

	/*! \brief Set mail id
	 */
	void setId(std::string  id);
	/*! \brief Get from address
	 */
	std::string getFrom();

	/*! \brief Set from address
	 */
	void setFrom(std::string  from);
	/*! \brief Get to address
	 */
	std::string getTo();

	/*! \brief Set to address
	 */
	void setTo(std::string  to);
	/*! \brief Get email subject
	 */
	std::string getSubject();

	/*! \brief Set email subject
	 */
	void setSubject(std::string  subject);
	/*! \brief Get message id
	 */
	std::string getMessageId();

	/*! \brief Set message id
	 */
	void setMessageId(std::string  messageId);
	/*! \brief Get creation date
	 */
	std::string getCreated();

	/*! \brief Set creation date
	 */
	void setCreated(std::string  created);
	/*! \brief Get creation timestamp
	 */
	int getTime();

	/*! \brief Set creation timestamp
	 */
	void setTime(int  time);
	/*! \brief Get user account
	 */
	std::string getUser();

	/*! \brief Set user account
	 */
	void setUser(std::string  user);
	/*! \brief Get transaction type
	 */
	std::string getTranstype();

	/*! \brief Set transaction type
	 */
	void setTranstype(std::string  transtype);
	/*! \brief Get transaction host
	 */
	std::string getTranshost();

	/*! \brief Set transaction host
	 */
	void setTranshost(std::string  transhost);
	/*! \brief Get origin host
	 */
	std::string getOriginhost();

	/*! \brief Set origin host
	 */
	void setOriginhost(std::string  originhost);
	/*! \brief Get origin ip
	 */
	std::string getOrigin();

	/*! \brief Set origin ip
	 */
	void setOrigin(std::string  origin);
	/*! \brief Get interface name
	 */
	std::string getInterface();

	/*! \brief Set interface name
	 */
	void setInterface(std::string  interface);
	/*! \brief Get date processed
	 */
	std::string getDate();

	/*! \brief Set date processed
	 */
	void setDate(std::string  date);
	/*! \brief Get sending zone
	 */
	std::string getSendingZone();

	/*! \brief Set sending zone
	 */
	void setSendingZone(std::string  sendingZone);
	/*! \brief Get email body size in bytes
	 */
	int getBodySize();

	/*! \brief Set email body size in bytes
	 */
	void setBodySize(int  bodySize);
	/*! \brief Get md5 sum of the email
	 */
	std::string getSourceMd5();

	/*! \brief Set md5 sum of the email
	 */
	void setSourceMd5(std::string  sourceMd5);
	/*! \brief Get delivery sequency
	 */
	int getSeq();

	/*! \brief Set delivery sequency
	 */
	void setSeq(int  seq);
	/*! \brief Get to address domain
	 */
	std::string getDomain();

	/*! \brief Set to address domain
	 */
	void setDomain(std::string  domain);
	/*! \brief Get email receiver address
	 */
	std::string getRecipient();

	/*! \brief Set email receiver address
	 */
	void setRecipient(std::string  recipient);
	/*! \brief Get locked status
	 */
	int getLocked();

	/*! \brief Set locked status
	 */
	void setLocked(int  locked);
	/*! \brief Get lock timestamp
	 */
	int getLockTime();

	/*! \brief Set lock timestamp
	 */
	void setLockTime(int  lockTime);
	/*! \brief Get assigned server
	 */
	std::string getAssigned();

	/*! \brief Set assigned server
	 */
	void setAssigned(std::string  assigned);
	/*! \brief Get queued timestamp
	 */
	std::string getQueued();

	/*! \brief Set queued timestamp
	 */
	void setQueued(std::string  queued);
	/*! \brief Get lock id
	 */
	std::string getLock();

	/*! \brief Set lock id
	 */
	void setLock(std::string  _lock);
	/*! \brief Get logger
	 */
	std::string getLogger();

	/*! \brief Set logger
	 */
	void setLogger(std::string  logger);
	/*! \brief Get mx port number
	 */
	int getMxPort();

	/*! \brief Set mx port number
	 */
	void setMxPort(int  mxPort);
	/*! \brief Get connection key
	 */
	std::string getConnectionKey();

	/*! \brief Set connection key
	 */
	void setConnectionKey(std::string  connectionKey);
	/*! \brief Get mx hostname
	 */
	std::string getMxHostname();

	/*! \brief Set mx hostname
	 */
	void setMxHostname(std::string  mxHostname);
	/*! \brief Get body hash
	 */
	std::string getSentBodyHash();

	/*! \brief Set body hash
	 */
	void setSentBodyHash(std::string  sentBodyHash);
	/*! \brief Get sent body size in bytes
	 */
	int getSentBodySize();

	/*! \brief Set sent body size in bytes
	 */
	void setSentBodySize(int  sentBodySize);
	/*! \brief Get md5 checksum matching result
	 */
	int getMd5Match();

	/*! \brief Set md5 checksum matching result
	 */
	void setMd5Match(int  md5Match);

private:
	int _id;
	std::string id;
	std::string from;
	std::string to;
	std::string subject;
	std::string messageId;
	std::string created;
	int time;
	std::string user;
	std::string transtype;
	std::string transhost;
	std::string originhost;
	std::string origin;
	std::string interface;
	std::string date;
	std::string sendingZone;
	int bodySize;
	std::string sourceMd5;
	int seq;
	std::string domain;
	std::string recipient;
	int locked;
	int lockTime;
	std::string assigned;
	std::string queued;
	std::string _lock;
	std::string logger;
	int mxPort;
	std::string connectionKey;
	std::string mxHostname;
	std::string sentBodyHash;
	int sentBodySize;
	int md5Match;
	void __init();
	void __cleanup();

};
}
}

#endif /* _MailLogEntry_H_ */
