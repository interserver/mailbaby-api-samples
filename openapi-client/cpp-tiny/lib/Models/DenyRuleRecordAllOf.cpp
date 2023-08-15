

#include "DenyRuleRecord_allOf.h"

using namespace Tiny;

DenyRuleRecord_allOf::DenyRuleRecord_allOf()
{
	id = int(0);
	created = std::string();
}

DenyRuleRecord_allOf::DenyRuleRecord_allOf(std::string jsonString)
{
	this->fromJson(jsonString);
}

DenyRuleRecord_allOf::~DenyRuleRecord_allOf()
{

}

void
DenyRuleRecord_allOf::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);

    const char *idKey = "id";

    if(object.has_key(idKey))
    {
        bourne::json value = object[idKey];



        jsonToValue(&id, value, "int");


    }

    const char *createdKey = "created";

    if(object.has_key(createdKey))
    {
        bourne::json value = object[createdKey];



        jsonToValue(&created, value, "std::string");


    }


}

bourne::json
DenyRuleRecord_allOf::toJson()
{
    bourne::json object = bourne::json::object();





    object["id"] = getId();






    object["created"] = getCreated();



    return object;

}

int
DenyRuleRecord_allOf::getId()
{
	return id;
}

void
DenyRuleRecord_allOf::setId(int  id)
{
	this->id = id;
}

std::string
DenyRuleRecord_allOf::getCreated()
{
	return created;
}

void
DenyRuleRecord_allOf::setCreated(std::string  created)
{
	this->created = created;
}



