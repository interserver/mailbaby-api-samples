

#include "MailOrderDetail.h"

using namespace Tiny;

MailOrderDetail::MailOrderDetail()
{
	id = int(0);
	status = std::string();
	username = std::string();
	password = std::string();
	comment = std::string();
}

MailOrderDetail::MailOrderDetail(std::string jsonString)
{
	this->fromJson(jsonString);
}

MailOrderDetail::~MailOrderDetail()
{

}

void
MailOrderDetail::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);

    const char *idKey = "id";

    if(object.has_key(idKey))
    {
        bourne::json value = object[idKey];



        jsonToValue(&id, value, "int");


    }

    const char *statusKey = "status";

    if(object.has_key(statusKey))
    {
        bourne::json value = object[statusKey];



        jsonToValue(&status, value, "std::string");


    }

    const char *usernameKey = "username";

    if(object.has_key(usernameKey))
    {
        bourne::json value = object[usernameKey];



        jsonToValue(&username, value, "std::string");


    }

    const char *passwordKey = "password";

    if(object.has_key(passwordKey))
    {
        bourne::json value = object[passwordKey];



        jsonToValue(&password, value, "std::string");


    }

    const char *commentKey = "comment";

    if(object.has_key(commentKey))
    {
        bourne::json value = object[commentKey];



        jsonToValue(&comment, value, "std::string");


    }


}

bourne::json
MailOrderDetail::toJson()
{
    bourne::json object = bourne::json::object();





    object["id"] = getId();






    object["status"] = getStatus();






    object["username"] = getUsername();






    object["password"] = getPassword();






    object["comment"] = getComment();



    return object;

}

int
MailOrderDetail::getId()
{
	return id;
}

void
MailOrderDetail::setId(int id)
{
	this->id = id;
}

std::string
MailOrderDetail::getStatus()
{
	return status;
}

void
MailOrderDetail::setStatus(std::string status)
{
	this->status = status;
}

std::string
MailOrderDetail::getUsername()
{
	return username;
}

void
MailOrderDetail::setUsername(std::string username)
{
	this->username = username;
}

std::string
MailOrderDetail::getPassword()
{
	return password;
}

void
MailOrderDetail::setPassword(std::string password)
{
	this->password = password;
}

std::string
MailOrderDetail::getComment()
{
	return comment;
}

void
MailOrderDetail::setComment(std::string comment)
{
	this->comment = comment;
}



