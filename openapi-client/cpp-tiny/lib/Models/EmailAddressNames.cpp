

#include "EmailAddressNames.h"

using namespace Tiny;

EmailAddressNames::EmailAddressNames()
{
}

EmailAddressNames::EmailAddressNames(std::string jsonString)
{
	this->fromJson(jsonString);
}

EmailAddressNames::~EmailAddressNames()
{

}

void
EmailAddressNames::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);


}

bourne::json
EmailAddressNames::toJson()
{
    bourne::json object = bourne::json::object();


    return object;

}



