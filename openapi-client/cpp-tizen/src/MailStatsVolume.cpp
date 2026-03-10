#include <map>
#include <cstdlib>
#include <glib-object.h>
#include <json-glib/json-glib.h>
#include "Helpers.h"


#include "MailStatsVolume.h"

using namespace std;
using namespace Tizen::ArtikCloud;

MailStatsVolume::MailStatsVolume()
{
	//__init();
}

MailStatsVolume::~MailStatsVolume()
{
	//__cleanup();
}

void
MailStatsVolume::__init()
{
	//new std::map()std::map> to;
	//new std::map()std::map> from;
	//new std::map()std::map> ip;
}

void
MailStatsVolume::__cleanup()
{
	//if(to != NULL) {
	//to.RemoveAll(true);
	//delete to;
	//to = NULL;
	//}
	//if(from != NULL) {
	//from.RemoveAll(true);
	//delete from;
	//from = NULL;
	//}
	//if(ip != NULL) {
	//ip.RemoveAll(true);
	//delete ip;
	//ip = NULL;
	//}
	//
}

void
MailStatsVolume::fromJson(char* jsonStr)
{
	JsonObject *pJsonObject = json_node_get_object(json_from_string(jsonStr,NULL));
	JsonNode *node;
	const gchar *toKey = "to";
	node = json_object_get_member(pJsonObject, toKey);
	if (node !=NULL) {
	
		{
			JsonObject* json_obj = json_node_get_object(node);
			map<string,string> new_map;
			json_object_foreach_member(json_obj,helper_func,&new_map);
			to = new_map;
		}
		
	}
	const gchar *fromKey = "from";
	node = json_object_get_member(pJsonObject, fromKey);
	if (node !=NULL) {
	
		{
			JsonObject* json_obj = json_node_get_object(node);
			map<string,string> new_map;
			json_object_foreach_member(json_obj,helper_func,&new_map);
			from = new_map;
		}
		
	}
	const gchar *ipKey = "ip";
	node = json_object_get_member(pJsonObject, ipKey);
	if (node !=NULL) {
	
		{
			JsonObject* json_obj = json_node_get_object(node);
			map<string,string> new_map;
			json_object_foreach_member(json_obj,helper_func,&new_map);
			ip = new_map;
		}
		
	}
}

MailStatsVolume::MailStatsVolume(char* json)
{
	this->fromJson(json);
}

char*
MailStatsVolume::toJson()
{
	JsonObject *pJsonObject = json_object_new();
	JsonNode *node;


	{
		JsonObject* json_obj;
		map<string, string> new_list = static_cast<map <string, string> > (getTo());
		json_obj = json_object_new();
		for (map<string, string>::iterator it = new_list.begin(); it != new_list.end(); it++) {
			string obj = (*it).first;
			string obj2 = (*it).second;
			JsonNode* tempnode = json_from_string(obj2.c_str(),NULL);
			json_object_set_member(json_obj, obj.c_str(), tempnode);
		}
	node = json_node_alloc();
	json_node_init_object(node, json_obj);
	json_object_unref(json_obj);
	}

	const gchar *toKey = "to";
	json_object_set_member(pJsonObject, toKey, node);


	{
		JsonObject* json_obj;
		map<string, string> new_list = static_cast<map <string, string> > (getFrom());
		json_obj = json_object_new();
		for (map<string, string>::iterator it = new_list.begin(); it != new_list.end(); it++) {
			string obj = (*it).first;
			string obj2 = (*it).second;
			JsonNode* tempnode = json_from_string(obj2.c_str(),NULL);
			json_object_set_member(json_obj, obj.c_str(), tempnode);
		}
	node = json_node_alloc();
	json_node_init_object(node, json_obj);
	json_object_unref(json_obj);
	}

	const gchar *fromKey = "from";
	json_object_set_member(pJsonObject, fromKey, node);


	{
		JsonObject* json_obj;
		map<string, string> new_list = static_cast<map <string, string> > (getIp());
		json_obj = json_object_new();
		for (map<string, string>::iterator it = new_list.begin(); it != new_list.end(); it++) {
			string obj = (*it).first;
			string obj2 = (*it).second;
			JsonNode* tempnode = json_from_string(obj2.c_str(),NULL);
			json_object_set_member(json_obj, obj.c_str(), tempnode);
		}
	node = json_node_alloc();
	json_node_init_object(node, json_obj);
	json_object_unref(json_obj);
	}

	const gchar *ipKey = "ip";
	json_object_set_member(pJsonObject, ipKey, node);
	node = json_node_alloc();
	json_node_init(node, JSON_NODE_OBJECT);
	json_node_take_object(node, pJsonObject);
	char * ret = json_to_string(node, false);
	json_node_free(node);
	return ret;
}

std::map<string, string>
MailStatsVolume::getTo()
{
	return to;
}

void
MailStatsVolume::setTo(std::map <string, string> to)
{
	this->to = to;
}

std::map<string, string>
MailStatsVolume::getFrom()
{
	return from;
}

void
MailStatsVolume::setFrom(std::map <string, string> from)
{
	this->from = from;
}

std::map<string, string>
MailStatsVolume::getIp()
{
	return ip;
}

void
MailStatsVolume::setIp(std::map <string, string> ip)
{
	this->ip = ip;
}


