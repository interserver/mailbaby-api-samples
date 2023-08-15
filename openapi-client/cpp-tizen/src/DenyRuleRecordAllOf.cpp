#include <map>
#include <cstdlib>
#include <glib-object.h>
#include <json-glib/json-glib.h>
#include "Helpers.h"


#include "DenyRuleRecord_allOf.h"

using namespace std;
using namespace Tizen::ArtikCloud;

DenyRuleRecord_allOf::DenyRuleRecord_allOf()
{
	//__init();
}

DenyRuleRecord_allOf::~DenyRuleRecord_allOf()
{
	//__cleanup();
}

void
DenyRuleRecord_allOf::__init()
{
	//id = int(0);
	//created = null;
}

void
DenyRuleRecord_allOf::__cleanup()
{
	//if(id != NULL) {
	//
	//delete id;
	//id = NULL;
	//}
	//if(created != NULL) {
	//
	//delete created;
	//created = NULL;
	//}
	//
}

void
DenyRuleRecord_allOf::fromJson(char* jsonStr)
{
	JsonObject *pJsonObject = json_node_get_object(json_from_string(jsonStr,NULL));
	JsonNode *node;
	const gchar *idKey = "id";
	node = json_object_get_member(pJsonObject, idKey);
	if (node !=NULL) {
	

		if (isprimitive("int")) {
			jsonToValue(&id, node, "int", "");
		} else {
			
		}
	}
	const gchar *createdKey = "created";
	node = json_object_get_member(pJsonObject, createdKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&created, node, "std::string", "");
		} else {
			
		}
	}
}

DenyRuleRecord_allOf::DenyRuleRecord_allOf(char* json)
{
	this->fromJson(json);
}

char*
DenyRuleRecord_allOf::toJson()
{
	JsonObject *pJsonObject = json_object_new();
	JsonNode *node;
	if (isprimitive("int")) {
		int obj = getId();
		node = converttoJson(&obj, "int", "");
	}
	else {
		
	}
	const gchar *idKey = "id";
	json_object_set_member(pJsonObject, idKey, node);
	if (isprimitive("std::string")) {
		std::string obj = getCreated();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *createdKey = "created";
	json_object_set_member(pJsonObject, createdKey, node);
	node = json_node_alloc();
	json_node_init(node, JSON_NODE_OBJECT);
	json_node_take_object(node, pJsonObject);
	char * ret = json_to_string(node, false);
	json_node_free(node);
	return ret;
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


