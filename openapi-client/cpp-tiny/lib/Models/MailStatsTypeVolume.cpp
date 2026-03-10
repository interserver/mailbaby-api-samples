

#include "MailStatsType_volume.h"

using namespace Tiny;

MailStatsType_volume::MailStatsType_volume()
{
	to = null<int>();
	from = null<int>();
	ip = null<int>();
}

MailStatsType_volume::MailStatsType_volume(std::string jsonString)
{
	this->fromJson(jsonString);
}

MailStatsType_volume::~MailStatsType_volume()
{

}

void
MailStatsType_volume::fromJson(std::string jsonObj)
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
MailStatsType_volume::toJson()
{
    bourne::json object = bourne::json::object();











    return object;

}

std::map<std::string, int>
MailStatsType_volume::getTo()
{
	return to;
}

void
MailStatsType_volume::setTo(std::map<std::string, int> to)
{
	this->to = to;
}

std::map<std::string, int>
MailStatsType_volume::getFrom()
{
	return from;
}

void
MailStatsType_volume::setFrom(std::map<std::string, int> from)
{
	this->from = from;
}

std::map<std::string, int>
MailStatsType_volume::getIp()
{
	return ip;
}

void
MailStatsType_volume::setIp(std::map<std::string, int> ip)
{
	this->ip = ip;
}



