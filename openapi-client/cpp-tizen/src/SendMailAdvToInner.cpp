#include <map>
#include <cstdlib>
#include <glib-object.h>
#include <json-glib/json-glib.h>
#include "Helpers.h"


#include "SendMailAdv_to_inner.h"

using namespace std;
using namespace Tizen::ArtikCloud;

SendMailAdv_to_inner::SendMailAdv_to_inner()
{
	//__init();
}

SendMailAdv_to_inner::~SendMailAdv_to_inner()
{
	//__cleanup();
}

void
SendMailAdv_to_inner::__init()
{
	//email = std::string();
	//name = std::string();
}

void
SendMailAdv_to_inner::__cleanup()
{
	//if(email != NULL) {
	//
	//delete email;
	//email = NULL;
	//}
	//if(name != NULL) {
	//
	//delete name;
	//name = NULL;
	//}
	//
}

void
SendMailAdv_to_inner::fromJson(char* jsonStr)
{
	JsonObject *pJsonObject = json_node_get_object(json_from_string(jsonStr,NULL));
	JsonNode *node;
	const gchar *emailKey = "email";
	node = json_object_get_member(pJsonObject, emailKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&email, node, "std::string", "");
		} else {
			
		}
	}
	const gchar *nameKey = "name";
	node = json_object_get_member(pJsonObject, nameKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&name, node, "std::string", "");
		} else {
			
		}
	}
}

SendMailAdv_to_inner::SendMailAdv_to_inner(char* json)
{
	this->fromJson(json);
}

char*
SendMailAdv_to_inner::toJson()
{
	JsonObject *pJsonObject = json_object_new();
	JsonNode *node;
	if (isprimitive("std::string")) {
		std::string obj = getEmail();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *emailKey = "email";
	json_object_set_member(pJsonObject, emailKey, node);
	if (isprimitive("std::string")) {
		std::string obj = getName();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *nameKey = "name";
	json_object_set_member(pJsonObject, nameKey, node);
	node = json_node_alloc();
	json_node_init(node, JSON_NODE_OBJECT);
	json_node_take_object(node, pJsonObject);
	char * ret = json_to_string(node, false);
	json_node_free(node);
	return ret;
}

std::string
SendMailAdv_to_inner::getEmail()
{
	return email;
}

void
SendMailAdv_to_inner::setEmail(std::string  email)
{
	this->email = email;
}

std::string
SendMailAdv_to_inner::getName()
{
	return name;
}

void
SendMailAdv_to_inner::setName(std::string  name)
{
	this->name = name;
}


