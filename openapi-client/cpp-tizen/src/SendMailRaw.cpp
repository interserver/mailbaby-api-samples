#include <map>
#include <cstdlib>
#include <glib-object.h>
#include <json-glib/json-glib.h>
#include "Helpers.h"


#include "SendMailRaw.h"

using namespace std;
using namespace Tizen::ArtikCloud;

SendMailRaw::SendMailRaw()
{
	//__init();
}

SendMailRaw::~SendMailRaw()
{
	//__cleanup();
}

void
SendMailRaw::__init()
{
	//raw_email = std::string();
	//id = int(0);
}

void
SendMailRaw::__cleanup()
{
	//if(raw_email != NULL) {
	//
	//delete raw_email;
	//raw_email = NULL;
	//}
	//if(id != NULL) {
	//
	//delete id;
	//id = NULL;
	//}
	//
}

void
SendMailRaw::fromJson(char* jsonStr)
{
	JsonObject *pJsonObject = json_node_get_object(json_from_string(jsonStr,NULL));
	JsonNode *node;
	const gchar *raw_emailKey = "raw_email";
	node = json_object_get_member(pJsonObject, raw_emailKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&raw_email, node, "std::string", "");
		} else {
			
		}
	}
	const gchar *idKey = "id";
	node = json_object_get_member(pJsonObject, idKey);
	if (node !=NULL) {
	

		if (isprimitive("int")) {
			jsonToValue(&id, node, "int", "");
		} else {
			
		}
	}
}

SendMailRaw::SendMailRaw(char* json)
{
	this->fromJson(json);
}

char*
SendMailRaw::toJson()
{
	JsonObject *pJsonObject = json_object_new();
	JsonNode *node;
	if (isprimitive("std::string")) {
		std::string obj = getRawEmail();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *raw_emailKey = "raw_email";
	json_object_set_member(pJsonObject, raw_emailKey, node);
	if (isprimitive("int")) {
		int obj = getId();
		node = converttoJson(&obj, "int", "");
	}
	else {
		
	}
	const gchar *idKey = "id";
	json_object_set_member(pJsonObject, idKey, node);
	node = json_node_alloc();
	json_node_init(node, JSON_NODE_OBJECT);
	json_node_take_object(node, pJsonObject);
	char * ret = json_to_string(node, false);
	json_node_free(node);
	return ret;
}

std::string
SendMailRaw::getRawEmail()
{
	return raw_email;
}

void
SendMailRaw::setRawEmail(std::string  raw_email)
{
	this->raw_email = raw_email;
}

int
SendMailRaw::getId()
{
	return id;
}

void
SendMailRaw::setId(int  id)
{
	this->id = id;
}


