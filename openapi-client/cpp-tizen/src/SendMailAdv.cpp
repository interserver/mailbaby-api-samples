#include <map>
#include <cstdlib>
#include <glib-object.h>
#include <json-glib/json-glib.h>
#include "Helpers.h"


#include "SendMailAdv.h"

using namespace std;
using namespace Tizen::ArtikCloud;

SendMailAdv::SendMailAdv()
{
	//__init();
}

SendMailAdv::~SendMailAdv()
{
	//__cleanup();
}

void
SendMailAdv::__init()
{
	//subject = std::string();
	//body = std::string();
	//from = new EmailAddressTypes();
	//to = new EmailAddressesTypes();
	//replyto = new EmailAddressesTypes();
	//cc = new EmailAddressesTypes();
	//bcc = new EmailAddressesTypes();
	//new std::list()std::list> attachments;
	//id = long(0);
}

void
SendMailAdv::__cleanup()
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
	//
	//delete to;
	//to = NULL;
	//}
	//if(replyto != NULL) {
	//
	//delete replyto;
	//replyto = NULL;
	//}
	//if(cc != NULL) {
	//
	//delete cc;
	//cc = NULL;
	//}
	//if(bcc != NULL) {
	//
	//delete bcc;
	//bcc = NULL;
	//}
	//if(attachments != NULL) {
	//attachments.RemoveAll(true);
	//delete attachments;
	//attachments = NULL;
	//}
	//if(id != NULL) {
	//
	//delete id;
	//id = NULL;
	//}
	//
}

void
SendMailAdv::fromJson(char* jsonStr)
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
	

		if (isprimitive("EmailAddressTypes")) {
			jsonToValue(&from, node, "EmailAddressTypes", "EmailAddressTypes");
		} else {
			
			EmailAddressTypes* obj = static_cast<EmailAddressTypes*> (&from);
			obj->fromJson(json_to_string(node, false));
			
		}
	}
	const gchar *toKey = "to";
	node = json_object_get_member(pJsonObject, toKey);
	if (node !=NULL) {
	

		if (isprimitive("EmailAddressesTypes")) {
			jsonToValue(&to, node, "EmailAddressesTypes", "EmailAddressesTypes");
		} else {
			
			EmailAddressesTypes* obj = static_cast<EmailAddressesTypes*> (&to);
			obj->fromJson(json_to_string(node, false));
			
		}
	}
	const gchar *replytoKey = "replyto";
	node = json_object_get_member(pJsonObject, replytoKey);
	if (node !=NULL) {
	

		if (isprimitive("EmailAddressesTypes")) {
			jsonToValue(&replyto, node, "EmailAddressesTypes", "EmailAddressesTypes");
		} else {
			
			EmailAddressesTypes* obj = static_cast<EmailAddressesTypes*> (&replyto);
			obj->fromJson(json_to_string(node, false));
			
		}
	}
	const gchar *ccKey = "cc";
	node = json_object_get_member(pJsonObject, ccKey);
	if (node !=NULL) {
	

		if (isprimitive("EmailAddressesTypes")) {
			jsonToValue(&cc, node, "EmailAddressesTypes", "EmailAddressesTypes");
		} else {
			
			EmailAddressesTypes* obj = static_cast<EmailAddressesTypes*> (&cc);
			obj->fromJson(json_to_string(node, false));
			
		}
	}
	const gchar *bccKey = "bcc";
	node = json_object_get_member(pJsonObject, bccKey);
	if (node !=NULL) {
	

		if (isprimitive("EmailAddressesTypes")) {
			jsonToValue(&bcc, node, "EmailAddressesTypes", "EmailAddressesTypes");
		} else {
			
			EmailAddressesTypes* obj = static_cast<EmailAddressesTypes*> (&bcc);
			obj->fromJson(json_to_string(node, false));
			
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
	const gchar *idKey = "id";
	node = json_object_get_member(pJsonObject, idKey);
	if (node !=NULL) {
	

		if (isprimitive("long long")) {
			jsonToValue(&id, node, "long long", "");
		} else {
			
		}
	}
}

SendMailAdv::SendMailAdv(char* json)
{
	this->fromJson(json);
}

char*
SendMailAdv::toJson()
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
	if (isprimitive("EmailAddressTypes")) {
		EmailAddressTypes obj = getFrom();
		node = converttoJson(&obj, "EmailAddressTypes", "");
	}
	else {
		
		EmailAddressTypes obj = static_cast<EmailAddressTypes> (getFrom());
		GError *mygerror;
		mygerror = NULL;
		node = json_from_string(obj.toJson(), &mygerror);
		
	}
	const gchar *fromKey = "from";
	json_object_set_member(pJsonObject, fromKey, node);
	if (isprimitive("EmailAddressesTypes")) {
		EmailAddressesTypes obj = getTo();
		node = converttoJson(&obj, "EmailAddressesTypes", "");
	}
	else {
		
		EmailAddressesTypes obj = static_cast<EmailAddressesTypes> (getTo());
		GError *mygerror;
		mygerror = NULL;
		node = json_from_string(obj.toJson(), &mygerror);
		
	}
	const gchar *toKey = "to";
	json_object_set_member(pJsonObject, toKey, node);
	if (isprimitive("EmailAddressesTypes")) {
		EmailAddressesTypes obj = getReplyto();
		node = converttoJson(&obj, "EmailAddressesTypes", "");
	}
	else {
		
		EmailAddressesTypes obj = static_cast<EmailAddressesTypes> (getReplyto());
		GError *mygerror;
		mygerror = NULL;
		node = json_from_string(obj.toJson(), &mygerror);
		
	}
	const gchar *replytoKey = "replyto";
	json_object_set_member(pJsonObject, replytoKey, node);
	if (isprimitive("EmailAddressesTypes")) {
		EmailAddressesTypes obj = getCc();
		node = converttoJson(&obj, "EmailAddressesTypes", "");
	}
	else {
		
		EmailAddressesTypes obj = static_cast<EmailAddressesTypes> (getCc());
		GError *mygerror;
		mygerror = NULL;
		node = json_from_string(obj.toJson(), &mygerror);
		
	}
	const gchar *ccKey = "cc";
	json_object_set_member(pJsonObject, ccKey, node);
	if (isprimitive("EmailAddressesTypes")) {
		EmailAddressesTypes obj = getBcc();
		node = converttoJson(&obj, "EmailAddressesTypes", "");
	}
	else {
		
		EmailAddressesTypes obj = static_cast<EmailAddressesTypes> (getBcc());
		GError *mygerror;
		mygerror = NULL;
		node = json_from_string(obj.toJson(), &mygerror);
		
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
	if (isprimitive("long long")) {
		long long obj = getId();
		node = converttoJson(&obj, "long long", "");
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
SendMailAdv::getSubject()
{
	return subject;
}

void
SendMailAdv::setSubject(std::string  subject)
{
	this->subject = subject;
}

std::string
SendMailAdv::getBody()
{
	return body;
}

void
SendMailAdv::setBody(std::string  body)
{
	this->body = body;
}

EmailAddressTypes
SendMailAdv::getFrom()
{
	return from;
}

void
SendMailAdv::setFrom(EmailAddressTypes  from)
{
	this->from = from;
}

EmailAddressesTypes
SendMailAdv::getTo()
{
	return to;
}

void
SendMailAdv::setTo(EmailAddressesTypes  to)
{
	this->to = to;
}

EmailAddressesTypes
SendMailAdv::getReplyto()
{
	return replyto;
}

void
SendMailAdv::setReplyto(EmailAddressesTypes  replyto)
{
	this->replyto = replyto;
}

EmailAddressesTypes
SendMailAdv::getCc()
{
	return cc;
}

void
SendMailAdv::setCc(EmailAddressesTypes  cc)
{
	this->cc = cc;
}

EmailAddressesTypes
SendMailAdv::getBcc()
{
	return bcc;
}

void
SendMailAdv::setBcc(EmailAddressesTypes  bcc)
{
	this->bcc = bcc;
}

std::list<MailAttachment>
SendMailAdv::getAttachments()
{
	return attachments;
}

void
SendMailAdv::setAttachments(std::list <MailAttachment> attachments)
{
	this->attachments = attachments;
}

long long
SendMailAdv::getId()
{
	return id;
}

void
SendMailAdv::setId(long long  id)
{
	this->id = id;
}


