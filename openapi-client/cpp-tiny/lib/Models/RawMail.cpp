

#include "RawMail.h"

using namespace Tiny;

RawMail::RawMail()
{
	raw_email = std::string();
}

RawMail::RawMail(std::string jsonString)
{
	this->fromJson(jsonString);
}

RawMail::~RawMail()
{

}

void
RawMail::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);

    const char *raw_emailKey = "raw_email";

    if(object.has_key(raw_emailKey))
    {
        bourne::json value = object[raw_emailKey];



        jsonToValue(&raw_email, value, "std::string");


    }


}

bourne::json
RawMail::toJson()
{
    bourne::json object = bourne::json::object();





    object["raw_email"] = getRawEmail();



    return object;

}

std::string
RawMail::getRawEmail()
{
	return raw_email;
}

void
RawMail::setRawEmail(std::string  raw_email)
{
	this->raw_email = raw_email;
}



