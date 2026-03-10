

#include "SendMail_to.h"

using namespace Tiny;

SendMail_to::SendMail_to()
{
}

SendMail_to::SendMail_to(std::string jsonString)
{
	this->fromJson(jsonString);
}

SendMail_to::~SendMail_to()
{

}

void
SendMail_to::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);


}

bourne::json
SendMail_to::toJson()
{
    bourne::json object = bourne::json::object();


    return object;

}



