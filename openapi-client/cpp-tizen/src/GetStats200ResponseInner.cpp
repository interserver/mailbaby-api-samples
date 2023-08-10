#include <map>
#include <cstdlib>
#include <glib-object.h>
#include <json-glib/json-glib.h>
#include "Helpers.h"


#include "GetStats_200_response_inner.h"

using namespace std;
using namespace Tizen::ArtikCloud;

GetStats_200_response_inner::GetStats_200_response_inner()
{
	//__init();
}

GetStats_200_response_inner::~GetStats_200_response_inner()
{
	//__cleanup();
}

void
GetStats_200_response_inner::__init()
{
	//id = int(0);
	//status = std::string();
	//username = std::string();
	//password = std::string();
	//comment = std::string();
}

void
GetStats_200_response_inner::__cleanup()
{
	//if(id != NULL) {
	//
	//delete id;
	//id = NULL;
	//}
	//if(status != NULL) {
	//
	//delete status;
	//status = NULL;
	//}
	//if(username != NULL) {
	//
	//delete username;
	//username = NULL;
	//}
	//if(password != NULL) {
	//
	//delete password;
	//password = NULL;
	//}
	//if(comment != NULL) {
	//
	//delete comment;
	//comment = NULL;
	//}
	//
}

void
GetStats_200_response_inner::fromJson(char* jsonStr)
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
	const gchar *statusKey = "status";
	node = json_object_get_member(pJsonObject, statusKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&status, node, "std::string", "");
		} else {
			
		}
	}
	const gchar *usernameKey = "username";
	node = json_object_get_member(pJsonObject, usernameKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&username, node, "std::string", "");
		} else {
			
		}
	}
	const gchar *passwordKey = "password";
	node = json_object_get_member(pJsonObject, passwordKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&password, node, "std::string", "");
		} else {
			
		}
	}
	const gchar *commentKey = "comment";
	node = json_object_get_member(pJsonObject, commentKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&comment, node, "std::string", "");
		} else {
			
		}
	}
}

GetStats_200_response_inner::GetStats_200_response_inner(char* json)
{
	this->fromJson(json);
}

char*
GetStats_200_response_inner::toJson()
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
		std::string obj = getStatus();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *statusKey = "status";
	json_object_set_member(pJsonObject, statusKey, node);
	if (isprimitive("std::string")) {
		std::string obj = getUsername();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *usernameKey = "username";
	json_object_set_member(pJsonObject, usernameKey, node);
	if (isprimitive("std::string")) {
		std::string obj = getPassword();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *passwordKey = "password";
	json_object_set_member(pJsonObject, passwordKey, node);
	if (isprimitive("std::string")) {
		std::string obj = getComment();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *commentKey = "comment";
	json_object_set_member(pJsonObject, commentKey, node);
	node = json_node_alloc();
	json_node_init(node, JSON_NODE_OBJECT);
	json_node_take_object(node, pJsonObject);
	char * ret = json_to_string(node, false);
	json_node_free(node);
	return ret;
}

int
GetStats_200_response_inner::getId()
{
	return id;
}

void
GetStats_200_response_inner::setId(int  id)
{
	this->id = id;
}

std::string
GetStats_200_response_inner::getStatus()
{
	return status;
}

void
GetStats_200_response_inner::setStatus(std::string  status)
{
	this->status = status;
}

std::string
GetStats_200_response_inner::getUsername()
{
	return username;
}

void
GetStats_200_response_inner::setUsername(std::string  username)
{
	this->username = username;
}

std::string
GetStats_200_response_inner::getPassword()
{
	return password;
}

void
GetStats_200_response_inner::setPassword(std::string  password)
{
	this->password = password;
}

std::string
GetStats_200_response_inner::getComment()
{
	return comment;
}

void
GetStats_200_response_inner::setComment(std::string  comment)
{
	this->comment = comment;
}


