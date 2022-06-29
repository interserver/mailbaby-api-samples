#include <map>
#include <cstdlib>
#include <glib-object.h>
#include <json-glib/json-glib.h>
#include "Helpers.h"


#include "SendMailAdv_attachments_inner.h"

using namespace std;
using namespace Tizen::ArtikCloud;

SendMailAdv_attachments_inner::SendMailAdv_attachments_inner()
{
	//__init();
}

SendMailAdv_attachments_inner::~SendMailAdv_attachments_inner()
{
	//__cleanup();
}

void
SendMailAdv_attachments_inner::__init()
{
	//data = std::string();
	//filename = std::string();
}

void
SendMailAdv_attachments_inner::__cleanup()
{
	//if(data != NULL) {
	//
	//delete data;
	//data = NULL;
	//}
	//if(filename != NULL) {
	//
	//delete filename;
	//filename = NULL;
	//}
	//
}

void
SendMailAdv_attachments_inner::fromJson(char* jsonStr)
{
	JsonObject *pJsonObject = json_node_get_object(json_from_string(jsonStr,NULL));
	JsonNode *node;
	const gchar *dataKey = "data";
	node = json_object_get_member(pJsonObject, dataKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&data, node, "std::string", "");
		} else {
			
			std::string* obj = static_cast<std::string*> (&data);
			obj->fromJson(json_to_string(node, false));
			
		}
	}
	const gchar *filenameKey = "filename";
	node = json_object_get_member(pJsonObject, filenameKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&filename, node, "std::string", "");
		} else {
			
		}
	}
}

SendMailAdv_attachments_inner::SendMailAdv_attachments_inner(char* json)
{
	this->fromJson(json);
}

char*
SendMailAdv_attachments_inner::toJson()
{
	JsonObject *pJsonObject = json_object_new();
	JsonNode *node;
	if (isprimitive("std::string")) {
		std::string obj = getData();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
		std::string obj = static_cast<std::string> (getData());
		GError *mygerror;
		mygerror = NULL;
		node = json_from_string(obj.toJson(), &mygerror);
		
	}
	const gchar *dataKey = "data";
	json_object_set_member(pJsonObject, dataKey, node);
	if (isprimitive("std::string")) {
		std::string obj = getFilename();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *filenameKey = "filename";
	json_object_set_member(pJsonObject, filenameKey, node);
	node = json_node_alloc();
	json_node_init(node, JSON_NODE_OBJECT);
	json_node_take_object(node, pJsonObject);
	char * ret = json_to_string(node, false);
	json_node_free(node);
	return ret;
}

std::string
SendMailAdv_attachments_inner::getData()
{
	return data;
}

void
SendMailAdv_attachments_inner::setData(std::string  data)
{
	this->data = data;
}

std::string
SendMailAdv_attachments_inner::getFilename()
{
	return filename;
}

void
SendMailAdv_attachments_inner::setFilename(std::string  filename)
{
	this->filename = filename;
}


