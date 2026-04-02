

#include "DateOrTimestamp.h"

using namespace Tiny;

DateOrTimestamp::DateOrTimestamp()
{
}

DateOrTimestamp::DateOrTimestamp(std::string jsonString)
{
	this->fromJson(jsonString);
}

DateOrTimestamp::~DateOrTimestamp()
{

}

void
DateOrTimestamp::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);


}

bourne::json
DateOrTimestamp::toJson()
{
    bourne::json object = bourne::json::object();


    return object;

}



