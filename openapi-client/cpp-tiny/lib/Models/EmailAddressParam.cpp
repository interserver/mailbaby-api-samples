

#include "EmailAddressParam.h"

using namespace Tiny;

EmailAddressParam::EmailAddressParam()
{
	email = std::string();
}

EmailAddressParam::EmailAddressParam(std::string jsonString)
{
	this->fromJson(jsonString);
}

EmailAddressParam::~EmailAddressParam()
{

}

void
EmailAddressParam::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);

    const char *emailKey = "email";

    if(object.has_key(emailKey))
    {
        bourne::json value = object[emailKey];



        jsonToValue(&email, value, "std::string");


    }


}

bourne::json
EmailAddressParam::toJson()
{
    bourne::json object = bourne::json::object();





    object["email"] = getEmail();



    return object;

}

std::string
EmailAddressParam::getEmail()
{
	return email;
}

void
EmailAddressParam::setEmail(std::string email)
{
	this->email = email;
}



