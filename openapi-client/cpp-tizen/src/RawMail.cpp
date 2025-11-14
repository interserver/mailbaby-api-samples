#include <map>
#include <cstdlib>
#include <glib-object.h>
#include <json-glib/json-glib.h>
#include "Helpers.h"


#include "RawMail.h"

using namespace std;
using namespace Tizen::ArtikCloud;

RawMail::RawMail()
{
	//__init();
}

RawMail::~RawMail()
{
	//__cleanup();
}

void
RawMail::__init()
{
	//raw_email = std::string();
}

void
RawMail::__cleanup()
{
	//if(raw_email != NULL) {
	//
	//delete raw_email;
	//raw_email = NULL;
	//}
	//
}

void
RawMail::fromJson(char* jsonStr)
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
}

RawMail::RawMail(char* json)
{
	this->fromJson(json);
}

char*
RawMail::toJson()
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
	node = json_node_alloc();
	json_node_init(node, JSON_NODE_OBJECT);
	json_node_take_object(node, pJsonObject);
	char * ret = json_to_string(node, false);
	json_node_free(node);
	return ret;
}

std::string
RawMail::getRawEmail()
{
	return raw_email;
}

void
RawMail::setRawEmail(std::string  raw_email)
{
	this->raw_email = raw_email;
}


