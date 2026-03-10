

#include "SendMailTo.h"

using namespace Tiny;

SendMailTo::SendMailTo()
{
}

SendMailTo::SendMailTo(std::string jsonString)
{
	this->fromJson(jsonString);
}

SendMailTo::~SendMailTo()
{

}

void
SendMailTo::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);


}

bourne::json
SendMailTo::toJson()
{
    bourne::json object = bourne::json::object();


    return object;

}



