#include <map>
#include <cstdlib>
#include <glib-object.h>
#include <json-glib/json-glib.h>
#include "Helpers.h"


#include "GenericResponse.h"

using namespace std;
using namespace Tizen::ArtikCloud;

GenericResponse::GenericResponse()
{
	//__init();
}

GenericResponse::~GenericResponse()
{
	//__cleanup();
}

void
GenericResponse::__init()
{
	//status = std::string();
	//status_text = std::string();
}

void
GenericResponse::__cleanup()
{
	//if(status != NULL) {
	//
	//delete status;
	//status = NULL;
	//}
	//if(status_text != NULL) {
	//
	//delete status_text;
	//status_text = NULL;
	//}
	//
}

void
GenericResponse::fromJson(char* jsonStr)
{
	JsonObject *pJsonObject = json_node_get_object(json_from_string(jsonStr,NULL));
	JsonNode *node;
	const gchar *statusKey = "status";
	node = json_object_get_member(pJsonObject, statusKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&status, node, "std::string", "");
		} else {
			
		}
	}
	const gchar *status_textKey = "status_text";
	node = json_object_get_member(pJsonObject, status_textKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&status_text, node, "std::string", "");
		} else {
			
		}
	}
}

GenericResponse::GenericResponse(char* json)
{
	this->fromJson(json);
}

char*
GenericResponse::toJson()
{
	JsonObject *pJsonObject = json_object_new();
	JsonNode *node;
	if (isprimitive("std::string")) {
		std::string obj = getStatus();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *statusKey = "status";
	json_object_set_member(pJsonObject, statusKey, node);
	if (isprimitive("std::string")) {
		std::string obj = getStatusText();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *status_textKey = "status_text";
	json_object_set_member(pJsonObject, status_textKey, node);
	node = json_node_alloc();
	json_node_init(node, JSON_NODE_OBJECT);
	json_node_take_object(node, pJsonObject);
	char * ret = json_to_string(node, false);
	json_node_free(node);
	return ret;
}

std::string
GenericResponse::getStatus()
{
	return status;
}

void
GenericResponse::setStatus(std::string  status)
{
	this->status = status;
}

std::string
GenericResponse::getStatusText()
{
	return status_text;
}

void
GenericResponse::setStatusText(std::string  status_text)
{
	this->status_text = status_text;
}


