

#include "ErrorMessage.h"

using namespace Tiny;

ErrorMessage::ErrorMessage()
{
	code = int(0);
	message = std::string();
}

ErrorMessage::ErrorMessage(std::string jsonString)
{
	this->fromJson(jsonString);
}

ErrorMessage::~ErrorMessage()
{

}

void
ErrorMessage::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);

    const char *codeKey = "code";

    if(object.has_key(codeKey))
    {
        bourne::json value = object[codeKey];



        jsonToValue(&code, value, "int");


    }

    const char *messageKey = "message";

    if(object.has_key(messageKey))
    {
        bourne::json value = object[messageKey];



        jsonToValue(&message, value, "std::string");


    }


}

bourne::json
ErrorMessage::toJson()
{
    bourne::json object = bourne::json::object();





    object["code"] = getCode();






    object["message"] = getMessage();



    return object;

}

int
ErrorMessage::getCode()
{
	return code;
}

void
ErrorMessage::setCode(int code)
{
	this->code = code;
}

std::string
ErrorMessage::getMessage()
{
	return message;
}

void
ErrorMessage::setMessage(std::string message)
{
	this->message = message;
}



