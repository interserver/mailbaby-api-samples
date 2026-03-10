

#include "SendMailRaw.h"

using namespace Tiny;

SendMailRaw::SendMailRaw()
{
	raw_email = std::string();
	id = long(0);
}

SendMailRaw::SendMailRaw(std::string jsonString)
{
	this->fromJson(jsonString);
}

SendMailRaw::~SendMailRaw()
{

}

void
SendMailRaw::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);

    const char *raw_emailKey = "raw_email";

    if(object.has_key(raw_emailKey))
    {
        bourne::json value = object[raw_emailKey];



        jsonToValue(&raw_email, value, "std::string");


    }

    const char *idKey = "id";

    if(object.has_key(idKey))
    {
        bourne::json value = object[idKey];



        jsonToValue(&id, value, "long");


    }


}

bourne::json
SendMailRaw::toJson()
{
    bourne::json object = bourne::json::object();





    object["raw_email"] = getRawEmail();






    object["id"] = getId();



    return object;

}

std::string
SendMailRaw::getRawEmail()
{
	return raw_email;
}

void
SendMailRaw::setRawEmail(std::string raw_email)
{
	this->raw_email = raw_email;
}

long
SendMailRaw::getId()
{
	return id;
}

void
SendMailRaw::setId(long id)
{
	this->id = id;
}



