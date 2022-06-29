#include <map>
#include <cstdlib>
#include <glib-object.h>
#include <json-glib/json-glib.h>
#include "Helpers.h"


#include "GetMailOrders_401_response.h"

using namespace std;
using namespace Tizen::ArtikCloud;

GetMailOrders_401_response::GetMailOrders_401_response()
{
	//__init();
}

GetMailOrders_401_response::~GetMailOrders_401_response()
{
	//__cleanup();
}

void
GetMailOrders_401_response::__init()
{
	//code = std::string();
	//message = std::string();
}

void
GetMailOrders_401_response::__cleanup()
{
	//if(code != NULL) {
	//
	//delete code;
	//code = NULL;
	//}
	//if(message != NULL) {
	//
	//delete message;
	//message = NULL;
	//}
	//
}

void
GetMailOrders_401_response::fromJson(char* jsonStr)
{
	JsonObject *pJsonObject = json_node_get_object(json_from_string(jsonStr,NULL));
	JsonNode *node;
	const gchar *codeKey = "code";
	node = json_object_get_member(pJsonObject, codeKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&code, node, "std::string", "");
		} else {
			
		}
	}
	const gchar *messageKey = "message";
	node = json_object_get_member(pJsonObject, messageKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&message, node, "std::string", "");
		} else {
			
		}
	}
}

GetMailOrders_401_response::GetMailOrders_401_response(char* json)
{
	this->fromJson(json);
}

char*
GetMailOrders_401_response::toJson()
{
	JsonObject *pJsonObject = json_object_new();
	JsonNode *node;
	if (isprimitive("std::string")) {
		std::string obj = getCode();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *codeKey = "code";
	json_object_set_member(pJsonObject, codeKey, node);
	if (isprimitive("std::string")) {
		std::string obj = getMessage();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *messageKey = "message";
	json_object_set_member(pJsonObject, messageKey, node);
	node = json_node_alloc();
	json_node_init(node, JSON_NODE_OBJECT);
	json_node_take_object(node, pJsonObject);
	char * ret = json_to_string(node, false);
	json_node_free(node);
	return ret;
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


