

#include "MailLogEntry.h"

using namespace Tiny;

MailLogEntry::MailLogEntry()
{
	_id = int(0);
	id = std::string();
	from = std::string();
	to = std::string();
	subject = std::string();
	messageId = std::string();
	created = std::string();
	time = int(0);
	user = std::string();
	transtype = std::string();
	transhost = std::string();
	originhost = std::string();
	origin = std::string();
	interface = std::string();
	date = std::string();
	sendingZone = std::string();
	bodySize = int(0);
	sourceMd5 = std::string();
	seq = int(0);
	domain = std::string();
	recipient = std::string();
	locked = int(0);
	lockTime = int(0);
	assigned = std::string();
	queued = std::string();
	_lock = std::string();
	logger = std::string();
	mxPort = int(0);
	connectionKey = std::string();
	mxHostname = std::string();
	sentBodyHash = std::string();
	sentBodySize = int(0);
	md5Match = int(0);
}

MailLogEntry::MailLogEntry(std::string jsonString)
{
	this->fromJson(jsonString);
}

MailLogEntry::~MailLogEntry()
{

}

void
MailLogEntry::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);

    const char *_idKey = "_id";

    if(object.has_key(_idKey))
    {
        bourne::json value = object[_idKey];



        jsonToValue(&_id, value, "int");


    }

    const char *idKey = "id";

    if(object.has_key(idKey))
    {
        bourne::json value = object[idKey];



        jsonToValue(&id, value, "std::string");


    }

    const char *fromKey = "from";

    if(object.has_key(fromKey))
    {
        bourne::json value = object[fromKey];



        jsonToValue(&from, value, "std::string");


    }

    const char *toKey = "to";

    if(object.has_key(toKey))
    {
        bourne::json value = object[toKey];



        jsonToValue(&to, value, "std::string");


    }

    const char *subjectKey = "subject";

    if(object.has_key(subjectKey))
    {
        bourne::json value = object[subjectKey];



        jsonToValue(&subject, value, "std::string");


    }

    const char *messageIdKey = "messageId";

    if(object.has_key(messageIdKey))
    {
        bourne::json value = object[messageIdKey];



        jsonToValue(&messageId, value, "std::string");


    }

    const char *createdKey = "created";

    if(object.has_key(createdKey))
    {
        bourne::json value = object[createdKey];



        jsonToValue(&created, value, "std::string");


    }

    const char *timeKey = "time";

    if(object.has_key(timeKey))
    {
        bourne::json value = object[timeKey];



        jsonToValue(&time, value, "int");


    }

    const char *userKey = "user";

    if(object.has_key(userKey))
    {
        bourne::json value = object[userKey];



        jsonToValue(&user, value, "std::string");


    }

    const char *transtypeKey = "transtype";

    if(object.has_key(transtypeKey))
    {
        bourne::json value = object[transtypeKey];



        jsonToValue(&transtype, value, "std::string");


    }

    const char *transhostKey = "transhost";

    if(object.has_key(transhostKey))
    {
        bourne::json value = object[transhostKey];



        jsonToValue(&transhost, value, "std::string");


    }

    const char *originhostKey = "originhost";

    if(object.has_key(originhostKey))
    {
        bourne::json value = object[originhostKey];



        jsonToValue(&originhost, value, "std::string");


    }

    const char *originKey = "origin";

    if(object.has_key(originKey))
    {
        bourne::json value = object[originKey];



        jsonToValue(&origin, value, "std::string");


    }

    const char *interfaceKey = "interface";

    if(object.has_key(interfaceKey))
    {
        bourne::json value = object[interfaceKey];



        jsonToValue(&interface, value, "std::string");


    }

    const char *dateKey = "date";

    if(object.has_key(dateKey))
    {
        bourne::json value = object[dateKey];



        jsonToValue(&date, value, "std::string");


    }

    const char *sendingZoneKey = "sendingZone";

    if(object.has_key(sendingZoneKey))
    {
        bourne::json value = object[sendingZoneKey];



        jsonToValue(&sendingZone, value, "std::string");


    }

    const char *bodySizeKey = "bodySize";

    if(object.has_key(bodySizeKey))
    {
        bourne::json value = object[bodySizeKey];



        jsonToValue(&bodySize, value, "int");


    }

    const char *sourceMd5Key = "sourceMd5";

    if(object.has_key(sourceMd5Key))
    {
        bourne::json value = object[sourceMd5Key];



        jsonToValue(&sourceMd5, value, "std::string");


    }

    const char *seqKey = "seq";

    if(object.has_key(seqKey))
    {
        bourne::json value = object[seqKey];



        jsonToValue(&seq, value, "int");


    }

    const char *domainKey = "domain";

    if(object.has_key(domainKey))
    {
        bourne::json value = object[domainKey];



        jsonToValue(&domain, value, "std::string");


    }

    const char *recipientKey = "recipient";

    if(object.has_key(recipientKey))
    {
        bourne::json value = object[recipientKey];



        jsonToValue(&recipient, value, "std::string");


    }

    const char *lockedKey = "locked";

    if(object.has_key(lockedKey))
    {
        bourne::json value = object[lockedKey];



        jsonToValue(&locked, value, "int");


    }

    const char *lockTimeKey = "lockTime";

    if(object.has_key(lockTimeKey))
    {
        bourne::json value = object[lockTimeKey];



        jsonToValue(&lockTime, value, "int");


    }

    const char *assignedKey = "assigned";

    if(object.has_key(assignedKey))
    {
        bourne::json value = object[assignedKey];



        jsonToValue(&assigned, value, "std::string");


    }

    const char *queuedKey = "queued";

    if(object.has_key(queuedKey))
    {
        bourne::json value = object[queuedKey];



        jsonToValue(&queued, value, "std::string");


    }

    const char *_lockKey = "_lock";

    if(object.has_key(_lockKey))
    {
        bourne::json value = object[_lockKey];



        jsonToValue(&_lock, value, "std::string");


    }

    const char *loggerKey = "logger";

    if(object.has_key(loggerKey))
    {
        bourne::json value = object[loggerKey];



        jsonToValue(&logger, value, "std::string");


    }

    const char *mxPortKey = "mxPort";

    if(object.has_key(mxPortKey))
    {
        bourne::json value = object[mxPortKey];



        jsonToValue(&mxPort, value, "int");


    }

    const char *connectionKeyKey = "connectionKey";

    if(object.has_key(connectionKeyKey))
    {
        bourne::json value = object[connectionKeyKey];



        jsonToValue(&connectionKey, value, "std::string");


    }

    const char *mxHostnameKey = "mxHostname";

    if(object.has_key(mxHostnameKey))
    {
        bourne::json value = object[mxHostnameKey];



        jsonToValue(&mxHostname, value, "std::string");


    }

    const char *sentBodyHashKey = "sentBodyHash";

    if(object.has_key(sentBodyHashKey))
    {
        bourne::json value = object[sentBodyHashKey];



        jsonToValue(&sentBodyHash, value, "std::string");


    }

    const char *sentBodySizeKey = "sentBodySize";

    if(object.has_key(sentBodySizeKey))
    {
        bourne::json value = object[sentBodySizeKey];



        jsonToValue(&sentBodySize, value, "int");


    }

    const char *md5MatchKey = "md5Match";

    if(object.has_key(md5MatchKey))
    {
        bourne::json value = object[md5MatchKey];



        jsonToValue(&md5Match, value, "int");


    }


}

bourne::json
MailLogEntry::toJson()
{
    bourne::json object = bourne::json::object();





    object["_id"] = getId();






    object["id"] = getId();






    object["from"] = getFrom();






    object["to"] = getTo();






    object["subject"] = getSubject();






    object["messageId"] = getMessageId();






    object["created"] = getCreated();






    object["time"] = getTime();






    object["user"] = getUser();






    object["transtype"] = getTranstype();






    object["transhost"] = getTranshost();






    object["originhost"] = getOriginhost();






    object["origin"] = getOrigin();






    object["interface"] = getInterface();






    object["date"] = getDate();






    object["sendingZone"] = getSendingZone();






    object["bodySize"] = getBodySize();






    object["sourceMd5"] = getSourceMd5();






    object["seq"] = getSeq();






    object["domain"] = getDomain();






    object["recipient"] = getRecipient();






    object["locked"] = getLocked();






    object["lockTime"] = getLockTime();






    object["assigned"] = getAssigned();






    object["queued"] = getQueued();






    object["_lock"] = getLock();






    object["logger"] = getLogger();






    object["mxPort"] = getMxPort();






    object["connectionKey"] = getConnectionKey();






    object["mxHostname"] = getMxHostname();






    object["sentBodyHash"] = getSentBodyHash();






    object["sentBodySize"] = getSentBodySize();






    object["md5Match"] = getMd5Match();



    return object;

}

int
MailLogEntry::getId()
{
	return _id;
}

void
MailLogEntry::setId(int  _id)
{
	this->_id = _id;
}

std::string
MailLogEntry::getId()
{
	return id;
}

void
MailLogEntry::setId(std::string  id)
{
	this->id = id;
}

std::string
MailLogEntry::getFrom()
{
	return from;
}

void
MailLogEntry::setFrom(std::string  from)
{
	this->from = from;
}

std::string
MailLogEntry::getTo()
{
	return to;
}

void
MailLogEntry::setTo(std::string  to)
{
	this->to = to;
}

std::string
MailLogEntry::getSubject()
{
	return subject;
}

void
MailLogEntry::setSubject(std::string  subject)
{
	this->subject = subject;
}

std::string
MailLogEntry::getMessageId()
{
	return messageId;
}

void
MailLogEntry::setMessageId(std::string  messageId)
{
	this->messageId = messageId;
}

std::string
MailLogEntry::getCreated()
{
	return created;
}

void
MailLogEntry::setCreated(std::string  created)
{
	this->created = created;
}

int
MailLogEntry::getTime()
{
	return time;
}

void
MailLogEntry::setTime(int  time)
{
	this->time = time;
}

std::string
MailLogEntry::getUser()
{
	return user;
}

void
MailLogEntry::setUser(std::string  user)
{
	this->user = user;
}

std::string
MailLogEntry::getTranstype()
{
	return transtype;
}

void
MailLogEntry::setTranstype(std::string  transtype)
{
	this->transtype = transtype;
}

std::string
MailLogEntry::getTranshost()
{
	return transhost;
}

void
MailLogEntry::setTranshost(std::string  transhost)
{
	this->transhost = transhost;
}

std::string
MailLogEntry::getOriginhost()
{
	return originhost;
}

void
MailLogEntry::setOriginhost(std::string  originhost)
{
	this->originhost = originhost;
}

std::string
MailLogEntry::getOrigin()
{
	return origin;
}

void
MailLogEntry::setOrigin(std::string  origin)
{
	this->origin = origin;
}

std::string
MailLogEntry::getInterface()
{
	return interface;
}

void
MailLogEntry::setInterface(std::string  interface)
{
	this->interface = interface;
}

std::string
MailLogEntry::getDate()
{
	return date;
}

void
MailLogEntry::setDate(std::string  date)
{
	this->date = date;
}

std::string
MailLogEntry::getSendingZone()
{
	return sendingZone;
}

void
MailLogEntry::setSendingZone(std::string  sendingZone)
{
	this->sendingZone = sendingZone;
}

int
MailLogEntry::getBodySize()
{
	return bodySize;
}

void
MailLogEntry::setBodySize(int  bodySize)
{
	this->bodySize = bodySize;
}

std::string
MailLogEntry::getSourceMd5()
{
	return sourceMd5;
}

void
MailLogEntry::setSourceMd5(std::string  sourceMd5)
{
	this->sourceMd5 = sourceMd5;
}

int
MailLogEntry::getSeq()
{
	return seq;
}

void
MailLogEntry::setSeq(int  seq)
{
	this->seq = seq;
}

std::string
MailLogEntry::getDomain()
{
	return domain;
}

void
MailLogEntry::setDomain(std::string  domain)
{
	this->domain = domain;
}

std::string
MailLogEntry::getRecipient()
{
	return recipient;
}

void
MailLogEntry::setRecipient(std::string  recipient)
{
	this->recipient = recipient;
}

int
MailLogEntry::getLocked()
{
	return locked;
}

void
MailLogEntry::setLocked(int  locked)
{
	this->locked = locked;
}

int
MailLogEntry::getLockTime()
{
	return lockTime;
}

void
MailLogEntry::setLockTime(int  lockTime)
{
	this->lockTime = lockTime;
}

std::string
MailLogEntry::getAssigned()
{
	return assigned;
}

void
MailLogEntry::setAssigned(std::string  assigned)
{
	this->assigned = assigned;
}

std::string
MailLogEntry::getQueued()
{
	return queued;
}

void
MailLogEntry::setQueued(std::string  queued)
{
	this->queued = queued;
}

std::string
MailLogEntry::getLock()
{
	return _lock;
}

void
MailLogEntry::setLock(std::string  _lock)
{
	this->_lock = _lock;
}

std::string
MailLogEntry::getLogger()
{
	return logger;
}

void
MailLogEntry::setLogger(std::string  logger)
{
	this->logger = logger;
}

int
MailLogEntry::getMxPort()
{
	return mxPort;
}

void
MailLogEntry::setMxPort(int  mxPort)
{
	this->mxPort = mxPort;
}

std::string
MailLogEntry::getConnectionKey()
{
	return connectionKey;
}

void
MailLogEntry::setConnectionKey(std::string  connectionKey)
{
	this->connectionKey = connectionKey;
}

std::string
MailLogEntry::getMxHostname()
{
	return mxHostname;
}

void
MailLogEntry::setMxHostname(std::string  mxHostname)
{
	this->mxHostname = mxHostname;
}

std::string
MailLogEntry::getSentBodyHash()
{
	return sentBodyHash;
}

void
MailLogEntry::setSentBodyHash(std::string  sentBodyHash)
{
	this->sentBodyHash = sentBodyHash;
}

int
MailLogEntry::getSentBodySize()
{
	return sentBodySize;
}

void
MailLogEntry::setSentBodySize(int  sentBodySize)
{
	this->sentBodySize = sentBodySize;
}

int
MailLogEntry::getMd5Match()
{
	return md5Match;
}

void
MailLogEntry::setMd5Match(int  md5Match)
{
	this->md5Match = md5Match;
}



