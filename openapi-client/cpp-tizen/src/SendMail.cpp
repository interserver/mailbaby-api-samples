#include <map>
#include <cstdlib>
#include <glib-object.h>
#include <json-glib/json-glib.h>
#include "Helpers.h"


#include "SendMail.h"

using namespace std;
using namespace Tizen::ArtikCloud;

SendMail::SendMail()
{
	//__init();
}

SendMail::~SendMail()
{
	//__cleanup();
}

void
SendMail::__init()
{
	//subject = std::string();
	//body = std::string();
	//from = new MailContact();
	//new std::list()std::list> to;
	//id = long(0);
	//new std::list()std::list> replyto;
	//new std::list()std::list> cc;
	//new std::list()std::list> bcc;
	//new std::list()std::list> attachments;
}

void
SendMail::__cleanup()
{
	//if(subject != NULL) {
	//
	//delete subject;
	//subject = NULL;
	//}
	//if(body != NULL) {
	//
	//delete body;
	//body = NULL;
	//}
	//if(from != NULL) {
	//
	//delete from;
	//from = NULL;
	//}
	//if(to != NULL) {
	//to.RemoveAll(true);
	//delete to;
	//to = NULL;
	//}
	//if(id != NULL) {
	//
	//delete id;
	//id = NULL;
	//}
	//if(replyto != NULL) {
	//replyto.RemoveAll(true);
	//delete replyto;
	//replyto = NULL;
	//}
	//if(cc != NULL) {
	//cc.RemoveAll(true);
	//delete cc;
	//cc = NULL;
	//}
	//if(bcc != NULL) {
	//bcc.RemoveAll(true);
	//delete bcc;
	//bcc = NULL;
	//}
	//if(attachments != NULL) {
	//attachments.RemoveAll(true);
	//delete attachments;
	//attachments = NULL;
	//}
	//
}

void
SendMail::fromJson(char* jsonStr)
{
	JsonObject *pJsonObject = json_node_get_object(json_from_string(jsonStr,NULL));
	JsonNode *node;
	const gchar *subjectKey = "subject";
	node = json_object_get_member(pJsonObject, subjectKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&subject, node, "std::string", "");
		} else {
			
		}
	}
	const gchar *bodyKey = "body";
	node = json_object_get_member(pJsonObject, bodyKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&body, node, "std::string", "");
		} else {
			
		}
	}
	const gchar *fromKey = "from";
	node = json_object_get_member(pJsonObject, fromKey);
	if (node !=NULL) {
	

		if (isprimitive("MailContact")) {
			jsonToValue(&from, node, "MailContact", "MailContact");
		} else {
			
			MailContact* obj = static_cast<MailContact*> (&from);
			obj->fromJson(json_to_string(node, false));
			
		}
	}
	const gchar *toKey = "to";
	node = json_object_get_member(pJsonObject, toKey);
	if (node !=NULL) {
	
		{
			JsonArray* arr = json_node_get_array(node);
			JsonNode*  temp_json;
			list<MailContact> new_list;
			MailContact inst;
			for (guint i=0;i<json_array_get_length(arr);i++) {
				temp_json = json_array_get_element(arr,i);
				if (isprimitive("MailContact")) {
					jsonToValue(&inst, temp_json, "MailContact", "");
				} else {
					
					inst.fromJson(json_to_string(temp_json, false));
					
				}
				new_list.push_back(inst);
			}
			to = new_list;
		}
		
	}
	const gchar *idKey = "id";
	node = json_object_get_member(pJsonObject, idKey);
	if (node !=NULL) {
	

		if (isprimitive("long long")) {
			jsonToValue(&id, node, "long long", "");
		} else {
			
		}
	}
	const gchar *replytoKey = "replyto";
	node = json_object_get_member(pJsonObject, replytoKey);
	if (node !=NULL) {
	
		{
			JsonArray* arr = json_node_get_array(node);
			JsonNode*  temp_json;
			list<MailContact> new_list;
			MailContact inst;
			for (guint i=0;i<json_array_get_length(arr);i++) {
				temp_json = json_array_get_element(arr,i);
				if (isprimitive("MailContact")) {
					jsonToValue(&inst, temp_json, "MailContact", "");
				} else {
					
					inst.fromJson(json_to_string(temp_json, false));
					
				}
				new_list.push_back(inst);
			}
			replyto = new_list;
		}
		
	}
	const gchar *ccKey = "cc";
	node = json_object_get_member(pJsonObject, ccKey);
	if (node !=NULL) {
	
		{
			JsonArray* arr = json_node_get_array(node);
			JsonNode*  temp_json;
			list<MailContact> new_list;
			MailContact inst;
			for (guint i=0;i<json_array_get_length(arr);i++) {
				temp_json = json_array_get_element(arr,i);
				if (isprimitive("MailContact")) {
					jsonToValue(&inst, temp_json, "MailContact", "");
				} else {
					
					inst.fromJson(json_to_string(temp_json, false));
					
				}
				new_list.push_back(inst);
			}
			cc = new_list;
		}
		
	}
	const gchar *bccKey = "bcc";
	node = json_object_get_member(pJsonObject, bccKey);
	if (node !=NULL) {
	
		{
			JsonArray* arr = json_node_get_array(node);
			JsonNode*  temp_json;
			list<MailContact> new_list;
			MailContact inst;
			for (guint i=0;i<json_array_get_length(arr);i++) {
				temp_json = json_array_get_element(arr,i);
				if (isprimitive("MailContact")) {
					jsonToValue(&inst, temp_json, "MailContact", "");
				} else {
					
					inst.fromJson(json_to_string(temp_json, false));
					
				}
				new_list.push_back(inst);
			}
			bcc = new_list;
		}
		
	}
	const gchar *attachmentsKey = "attachments";
	node = json_object_get_member(pJsonObject, attachmentsKey);
	if (node !=NULL) {
	
		{
			JsonArray* arr = json_node_get_array(node);
			JsonNode*  temp_json;
			list<MailAttachment> new_list;
			MailAttachment inst;
			for (guint i=0;i<json_array_get_length(arr);i++) {
				temp_json = json_array_get_element(arr,i);
				if (isprimitive("MailAttachment")) {
					jsonToValue(&inst, temp_json, "MailAttachment", "");
				} else {
					
					inst.fromJson(json_to_string(temp_json, false));
					
				}
				new_list.push_back(inst);
			}
			attachments = new_list;
		}
		
	}
}

SendMail::SendMail(char* json)
{
	this->fromJson(json);
}

char*
SendMail::toJson()
{
	JsonObject *pJsonObject = json_object_new();
	JsonNode *node;
	if (isprimitive("std::string")) {
		std::string obj = getSubject();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *subjectKey = "subject";
	json_object_set_member(pJsonObject, subjectKey, node);
	if (isprimitive("std::string")) {
		std::string obj = getBody();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *bodyKey = "body";
	json_object_set_member(pJsonObject, bodyKey, node);
	if (isprimitive("MailContact")) {
		MailContact obj = getFrom();
		node = converttoJson(&obj, "MailContact", "");
	}
	else {
		
		MailContact obj = static_cast<MailContact> (getFrom());
		GError *mygerror;
		mygerror = NULL;
		node = json_from_string(obj.toJson(), &mygerror);
		
	}
	const gchar *fromKey = "from";
	json_object_set_member(pJsonObject, fromKey, node);
	if (isprimitive("MailContact")) {
		list<MailContact> new_list = static_cast<list <MailContact> > (getTo());
		node = converttoJson(&new_list, "MailContact", "array");
	} else {
		node = json_node_alloc();
		list<MailContact> new_list = static_cast<list <MailContact> > (getTo());
		JsonArray* json_array = json_array_new();
		GError *mygerror;
		
		for (list<MailContact>::iterator it = new_list.begin(); it != new_list.end(); it++) {
			mygerror = NULL;
			MailContact obj = *it;
			JsonNode *node_temp = json_from_string(obj.toJson(), &mygerror);
			json_array_add_element(json_array, node_temp);
			g_clear_error(&mygerror);
		}
		json_node_init_array(node, json_array);
		json_array_unref(json_array);
		
	}


	
	const gchar *toKey = "to";
	json_object_set_member(pJsonObject, toKey, node);
	if (isprimitive("long long")) {
		long long obj = getId();
		node = converttoJson(&obj, "long long", "");
	}
	else {
		
	}
	const gchar *idKey = "id";
	json_object_set_member(pJsonObject, idKey, node);
	if (isprimitive("MailContact")) {
		list<MailContact> new_list = static_cast<list <MailContact> > (getReplyto());
		node = converttoJson(&new_list, "MailContact", "array");
	} else {
		node = json_node_alloc();
		list<MailContact> new_list = static_cast<list <MailContact> > (getReplyto());
		JsonArray* json_array = json_array_new();
		GError *mygerror;
		
		for (list<MailContact>::iterator it = new_list.begin(); it != new_list.end(); it++) {
			mygerror = NULL;
			MailContact obj = *it;
			JsonNode *node_temp = json_from_string(obj.toJson(), &mygerror);
			json_array_add_element(json_array, node_temp);
			g_clear_error(&mygerror);
		}
		json_node_init_array(node, json_array);
		json_array_unref(json_array);
		
	}


	
	const gchar *replytoKey = "replyto";
	json_object_set_member(pJsonObject, replytoKey, node);
	if (isprimitive("MailContact")) {
		list<MailContact> new_list = static_cast<list <MailContact> > (getCc());
		node = converttoJson(&new_list, "MailContact", "array");
	} else {
		node = json_node_alloc();
		list<MailContact> new_list = static_cast<list <MailContact> > (getCc());
		JsonArray* json_array = json_array_new();
		GError *mygerror;
		
		for (list<MailContact>::iterator it = new_list.begin(); it != new_list.end(); it++) {
			mygerror = NULL;
			MailContact obj = *it;
			JsonNode *node_temp = json_from_string(obj.toJson(), &mygerror);
			json_array_add_element(json_array, node_temp);
			g_clear_error(&mygerror);
		}
		json_node_init_array(node, json_array);
		json_array_unref(json_array);
		
	}


	
	const gchar *ccKey = "cc";
	json_object_set_member(pJsonObject, ccKey, node);
	if (isprimitive("MailContact")) {
		list<MailContact> new_list = static_cast<list <MailContact> > (getBcc());
		node = converttoJson(&new_list, "MailContact", "array");
	} else {
		node = json_node_alloc();
		list<MailContact> new_list = static_cast<list <MailContact> > (getBcc());
		JsonArray* json_array = json_array_new();
		GError *mygerror;
		
		for (list<MailContact>::iterator it = new_list.begin(); it != new_list.end(); it++) {
			mygerror = NULL;
			MailContact obj = *it;
			JsonNode *node_temp = json_from_string(obj.toJson(), &mygerror);
			json_array_add_element(json_array, node_temp);
			g_clear_error(&mygerror);
		}
		json_node_init_array(node, json_array);
		json_array_unref(json_array);
		
	}


	
	const gchar *bccKey = "bcc";
	json_object_set_member(pJsonObject, bccKey, node);
	if (isprimitive("MailAttachment")) {
		list<MailAttachment> new_list = static_cast<list <MailAttachment> > (getAttachments());
		node = converttoJson(&new_list, "MailAttachment", "array");
	} else {
		node = json_node_alloc();
		list<MailAttachment> new_list = static_cast<list <MailAttachment> > (getAttachments());
		JsonArray* json_array = json_array_new();
		GError *mygerror;
		
		for (list<MailAttachment>::iterator it = new_list.begin(); it != new_list.end(); it++) {
			mygerror = NULL;
			MailAttachment obj = *it;
			JsonNode *node_temp = json_from_string(obj.toJson(), &mygerror);
			json_array_add_element(json_array, node_temp);
			g_clear_error(&mygerror);
		}
		json_node_init_array(node, json_array);
		json_array_unref(json_array);
		
	}


	
	const gchar *attachmentsKey = "attachments";
	json_object_set_member(pJsonObject, attachmentsKey, node);
	node = json_node_alloc();
	json_node_init(node, JSON_NODE_OBJECT);
	json_node_take_object(node, pJsonObject);
	char * ret = json_to_string(node, false);
	json_node_free(node);
	return ret;
}

std::string
SendMail::getSubject()
{
	return subject;
}

void
SendMail::setSubject(std::string  subject)
{
	this->subject = subject;
}

std::string
SendMail::getBody()
{
	return body;
}

void
SendMail::setBody(std::string  body)
{
	this->body = body;
}

MailContact
SendMail::getFrom()
{
	return from;
}

void
SendMail::setFrom(MailContact  from)
{
	this->from = from;
}

std::list<MailContact>
SendMail::getTo()
{
	return to;
}

void
SendMail::setTo(std::list <MailContact> to)
{
	this->to = to;
}

long long
SendMail::getId()
{
	return id;
}

void
SendMail::setId(long long  id)
{
	this->id = id;
}

std::list<MailContact>
SendMail::getReplyto()
{
	return replyto;
}

void
SendMail::setReplyto(std::list <MailContact> replyto)
{
	this->replyto = replyto;
}

std::list<MailContact>
SendMail::getCc()
{
	return cc;
}

void
SendMail::setCc(std::list <MailContact> cc)
{
	this->cc = cc;
}

std::list<MailContact>
SendMail::getBcc()
{
	return bcc;
}

void
SendMail::setBcc(std::list <MailContact> bcc)
{
	this->bcc = bcc;
}

std::list<MailAttachment>
SendMail::getAttachments()
{
	return attachments;
}

void
SendMail::setAttachments(std::list <MailAttachment> attachments)
{
	this->attachments = attachments;
}


