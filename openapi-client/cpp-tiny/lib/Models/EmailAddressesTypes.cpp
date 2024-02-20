

#include "EmailAddressesTypes.h"

using namespace Tiny;

EmailAddressesTypes::EmailAddressesTypes()
{
}

EmailAddressesTypes::EmailAddressesTypes(std::string jsonString)
{
	this->fromJson(jsonString);
}

EmailAddressesTypes::~EmailAddressesTypes()
{

}

void
EmailAddressesTypes::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);


}

bourne::json
EmailAddressesTypes::toJson()
{
    bourne::json object = bourne::json::object();


    return object;

}



