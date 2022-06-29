

#include "SendMailAdv_replyto_inner.h"

using namespace Tiny;

SendMailAdv_replyto_inner::SendMailAdv_replyto_inner()
{
	email = std::string();
	name = std::string();
}

SendMailAdv_replyto_inner::SendMailAdv_replyto_inner(std::string jsonString)
{
	this->fromJson(jsonString);
}

SendMailAdv_replyto_inner::~SendMailAdv_replyto_inner()
{

}

void
SendMailAdv_replyto_inner::fromJson(std::string jsonObj)
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
SendMailAdv_replyto_inner::toJson()
{
    bourne::json object = bourne::json::object();





    object["email"] = getEmail();






    object["name"] = getName();



    return object;

}

std::string
SendMailAdv_replyto_inner::getEmail()
{
	return email;
}

void
SendMailAdv_replyto_inner::setEmail(std::string  email)
{
	this->email = email;
}

std::string
SendMailAdv_replyto_inner::getName()
{
	return name;
}

void
SendMailAdv_replyto_inner::setName(std::string  name)
{
	this->name = name;
}



