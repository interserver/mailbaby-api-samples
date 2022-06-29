

#include "GetMailOrders_401_response.h"

using namespace Tiny;

GetMailOrders_401_response::GetMailOrders_401_response()
{
	code = std::string();
	message = std::string();
}

GetMailOrders_401_response::GetMailOrders_401_response(std::string jsonString)
{
	this->fromJson(jsonString);
}

GetMailOrders_401_response::~GetMailOrders_401_response()
{

}

void
GetMailOrders_401_response::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);

    const char *codeKey = "code";

    if(object.has_key(codeKey))
    {
        bourne::json value = object[codeKey];



        jsonToValue(&code, value, "std::string");


    }

    const char *messageKey = "message";

    if(object.has_key(messageKey))
    {
        bourne::json value = object[messageKey];



        jsonToValue(&message, value, "std::string");


    }


}

bourne::json
GetMailOrders_401_response::toJson()
{
    bourne::json object = bourne::json::object();





    object["code"] = getCode();






    object["message"] = getMessage();



    return object;

}

std::string
GetMailOrders_401_response::getCode()
{
	return code;
}

void
GetMailOrders_401_response::setCode(std::string  code)
{
	this->code = code;
}

std::string
GetMailOrders_401_response::getMessage()
{
	return message;
}

void
GetMailOrders_401_response::setMessage(std::string  message)
{
	this->message = message;
}



