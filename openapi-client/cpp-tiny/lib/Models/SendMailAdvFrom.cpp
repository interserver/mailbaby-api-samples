

#include "SendMailAdv_from.h"

using namespace Tiny;

SendMailAdv_from::SendMailAdv_from()
{
	email = std::string();
	name = std::string();
}

SendMailAdv_from::SendMailAdv_from(std::string jsonString)
{
	this->fromJson(jsonString);
}

SendMailAdv_from::~SendMailAdv_from()
{

}

void
SendMailAdv_from::fromJson(std::string jsonObj)
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
SendMailAdv_from::toJson()
{
    bourne::json object = bourne::json::object();





    object["email"] = getEmail();






    object["name"] = getName();



    return object;

}

std::string
SendMailAdv_from::getEmail()
{
	return email;
}

void
SendMailAdv_from::setEmail(std::string  email)
{
	this->email = email;
}

std::string
SendMailAdv_from::getName()
{
	return name;
}

void
SendMailAdv_from::setName(std::string  name)
{
	this->name = name;
}



