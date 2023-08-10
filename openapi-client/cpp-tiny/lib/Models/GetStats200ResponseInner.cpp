

#include "GetStats_200_response_inner.h"

using namespace Tiny;

GetStats_200_response_inner::GetStats_200_response_inner()
{
	id = int(0);
	status = std::string();
	username = std::string();
	password = std::string();
	comment = std::string();
}

GetStats_200_response_inner::GetStats_200_response_inner(std::string jsonString)
{
	this->fromJson(jsonString);
}

GetStats_200_response_inner::~GetStats_200_response_inner()
{

}

void
GetStats_200_response_inner::fromJson(std::string jsonObj)
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
GetStats_200_response_inner::toJson()
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
GetStats_200_response_inner::getId()
{
	return id;
}

void
GetStats_200_response_inner::setId(int  id)
{
	this->id = id;
}

std::string
GetStats_200_response_inner::getStatus()
{
	return status;
}

void
GetStats_200_response_inner::setStatus(std::string  status)
{
	this->status = status;
}

std::string
GetStats_200_response_inner::getUsername()
{
	return username;
}

void
GetStats_200_response_inner::setUsername(std::string  username)
{
	this->username = username;
}

std::string
GetStats_200_response_inner::getPassword()
{
	return password;
}

void
GetStats_200_response_inner::setPassword(std::string  password)
{
	this->password = password;
}

std::string
GetStats_200_response_inner::getComment()
{
	return comment;
}

void
GetStats_200_response_inner::setComment(std::string  comment)
{
	this->comment = comment;
}



