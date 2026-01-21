

#include "EmailAddressTypes.h"

using namespace Tiny;

EmailAddressTypes::EmailAddressTypes()
{
	email = std::string();
	name = std::string();
}

EmailAddressTypes::EmailAddressTypes(std::string jsonString)
{
	this->fromJson(jsonString);
}

EmailAddressTypes::~EmailAddressTypes()
{

}

void
EmailAddressTypes::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);

    const char *emailKey = "email";

    if(object.has_key(emailKey))
    {
        bourne::json value = object[emailKey];



        jsonToValue(&email, value, "std::string");


    }

    const char *nameKey = "name";

    if(object.has_key(nameKey))
    {
        bourne::json value = object[nameKey];



        jsonToValue(&name, value, "std::string");


    }


}

bourne::json
EmailAddressTypes::toJson()
{
    bourne::json object = bourne::json::object();





    object["email"] = getEmail();






    object["name"] = getName();



    return object;

}

std::string
EmailAddressTypes::getEmail()
{
	return email;
}

void
EmailAddressTypes::setEmail(std::string email)
{
	this->email = email;
}

std::string
EmailAddressTypes::getName()
{
	return name;
}

void
EmailAddressTypes::setName(std::string name)
{
	this->name = name;
}



