

#include "SendMail.h"

using namespace Tiny;

SendMail::SendMail()
{
	to = SendMail_to();
	from = std::string();
	subject = std::string();
	body = std::string();
	id = long(0);
}

SendMail::SendMail(std::string jsonString)
{
	this->fromJson(jsonString);
}

SendMail::~SendMail()
{

}

void
SendMail::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);

    const char *toKey = "to";

    if(object.has_key(toKey))
    {
        bourne::json value = object[toKey];




        SendMail_to* obj = &to;
		obj->fromJson(value.dump());

    }

    const char *fromKey = "from";

    if(object.has_key(fromKey))
    {
        bourne::json value = object[fromKey];



        jsonToValue(&from, value, "std::string");


    }

    const char *subjectKey = "subject";

    if(object.has_key(subjectKey))
    {
        bourne::json value = object[subjectKey];



        jsonToValue(&subject, value, "std::string");


    }

    const char *bodyKey = "body";

    if(object.has_key(bodyKey))
    {
        bourne::json value = object[bodyKey];



        jsonToValue(&body, value, "std::string");


    }

    const char *idKey = "id";

    if(object.has_key(idKey))
    {
        bourne::json value = object[idKey];



        jsonToValue(&id, value, "long");


    }


}

bourne::json
SendMail::toJson()
{
    bourne::json object = bourne::json::object();






	object["to"] = getTo().toJson();





    object["from"] = getFrom();






    object["subject"] = getSubject();






    object["body"] = getBody();






    object["id"] = getId();



    return object;

}

SendMail_to
SendMail::getTo()
{
	return to;
}

void
SendMail::setTo(SendMail_to to)
{
	this->to = to;
}

std::string
SendMail::getFrom()
{
	return from;
}

void
SendMail::setFrom(std::string from)
{
	this->from = from;
}

std::string
SendMail::getSubject()
{
	return subject;
}

void
SendMail::setSubject(std::string subject)
{
	this->subject = subject;
}

std::string
SendMail::getBody()
{
	return body;
}

void
SendMail::setBody(std::string body)
{
	this->body = body;
}

long
SendMail::getId()
{
	return id;
}

void
SendMail::setId(long id)
{
	this->id = id;
}



