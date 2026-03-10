

#include "MailStatsVolume.h"

using namespace Tiny;

MailStatsVolume::MailStatsVolume()
{
	to = null<int>();
	from = null<int>();
	ip = null<int>();
}

MailStatsVolume::MailStatsVolume(std::string jsonString)
{
	this->fromJson(jsonString);
}

MailStatsVolume::~MailStatsVolume()
{

}

void
MailStatsVolume::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);

    const char *toKey = "to";

    if(object.has_key(toKey))
    {
        bourne::json value = object[toKey];


    }

    const char *fromKey = "from";

    if(object.has_key(fromKey))
    {
        bourne::json value = object[fromKey];


    }

    const char *ipKey = "ip";

    if(object.has_key(ipKey))
    {
        bourne::json value = object[ipKey];


    }


}

bourne::json
MailStatsVolume::toJson()
{
    bourne::json object = bourne::json::object();











    return object;

}

std::map<std::string, int>
MailStatsVolume::getTo()
{
	return to;
}

void
MailStatsVolume::setTo(std::map<std::string, int> to)
{
	this->to = to;
}

std::map<std::string, int>
MailStatsVolume::getFrom()
{
	return from;
}

void
MailStatsVolume::setFrom(std::map<std::string, int> from)
{
	this->from = from;
}

std::map<std::string, int>
MailStatsVolume::getIp()
{
	return ip;
}

void
MailStatsVolume::setIp(std::map<std::string, int> ip)
{
	this->ip = ip;
}



