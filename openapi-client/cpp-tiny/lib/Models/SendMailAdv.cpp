

#include "SendMailAdv.h"

using namespace Tiny;

SendMailAdv::SendMailAdv()
{
	subject = std::string();
	body = std::string();
	from = EmailAddressTypes();
	to = EmailAddressesTypes();
	replyto = EmailAddressesTypes();
	cc = EmailAddressesTypes();
	bcc = EmailAddressesTypes();
	attachments = std::list<MailAttachment>();
	id = long(0);
}

SendMailAdv::SendMailAdv(std::string jsonString)
{
	this->fromJson(jsonString);
}

SendMailAdv::~SendMailAdv()
{

}

void
SendMailAdv::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);

    const char *subjectKey = "subject";

    if(object.has_key(subjectKey))
    {
        bourne::json value = object[subjectKey];



        jsonToValue(&subject, value, "std::string");


    }

    const char *bodyKey = "body";

    if(object.has_key(bodyKey))
    {
        bourne::json value = object[bodyKey];



        jsonToValue(&body, value, "std::string");


    }

    const char *fromKey = "from";

    if(object.has_key(fromKey))
    {
        bourne::json value = object[fromKey];




        EmailAddressTypes* obj = &from;
		obj->fromJson(value.dump());

    }

    const char *toKey = "to";

    if(object.has_key(toKey))
    {
        bourne::json value = object[toKey];




        EmailAddressesTypes* obj = &to;
		obj->fromJson(value.dump());

    }

    const char *replytoKey = "replyto";

    if(object.has_key(replytoKey))
    {
        bourne::json value = object[replytoKey];




        EmailAddressesTypes* obj = &replyto;
		obj->fromJson(value.dump());

    }

    const char *ccKey = "cc";

    if(object.has_key(ccKey))
    {
        bourne::json value = object[ccKey];




        EmailAddressesTypes* obj = &cc;
		obj->fromJson(value.dump());

    }

    const char *bccKey = "bcc";

    if(object.has_key(bccKey))
    {
        bourne::json value = object[bccKey];




        EmailAddressesTypes* obj = &bcc;
		obj->fromJson(value.dump());

    }

    const char *attachmentsKey = "attachments";

    if(object.has_key(attachmentsKey))
    {
        bourne::json value = object[attachmentsKey];


        std::list<MailAttachment> attachments_list;
        MailAttachment element;
        for(auto& var : value.array_range())
        {


            element.fromJson(var.dump());

            attachments_list.push_back(element);
        }
        attachments = attachments_list;


    }

    const char *idKey = "id";

    if(object.has_key(idKey))
    {
        bourne::json value = object[idKey];



        jsonToValue(&id, value, "long");


    }


}

bourne::json
SendMailAdv::toJson()
{
    bourne::json object = bourne::json::object();





    object["subject"] = getSubject();






    object["body"] = getBody();







	object["from"] = getFrom().toJson();






	object["to"] = getTo().toJson();






	object["replyto"] = getReplyto().toJson();






	object["cc"] = getCc().toJson();






	object["bcc"] = getBcc().toJson();




    std::list<MailAttachment> attachments_list = getAttachments();
    bourne::json attachments_arr = bourne::json::array();

    for(auto& var : attachments_list)
    {
        MailAttachment obj = var;
        attachments_arr.append(obj.toJson());
    }
    object["attachments"] = attachments_arr;







    object["id"] = getId();



    return object;

}

std::string
SendMailAdv::getSubject()
{
	return subject;
}

void
SendMailAdv::setSubject(std::string subject)
{
	this->subject = subject;
}

std::string
SendMailAdv::getBody()
{
	return body;
}

void
SendMailAdv::setBody(std::string body)
{
	this->body = body;
}

EmailAddressTypes
SendMailAdv::getFrom()
{
	return from;
}

void
SendMailAdv::setFrom(EmailAddressTypes from)
{
	this->from = from;
}

EmailAddressesTypes
SendMailAdv::getTo()
{
	return to;
}

void
SendMailAdv::setTo(EmailAddressesTypes to)
{
	this->to = to;
}

EmailAddressesTypes
SendMailAdv::getReplyto()
{
	return replyto;
}

void
SendMailAdv::setReplyto(EmailAddressesTypes replyto)
{
	this->replyto = replyto;
}

EmailAddressesTypes
SendMailAdv::getCc()
{
	return cc;
}

void
SendMailAdv::setCc(EmailAddressesTypes cc)
{
	this->cc = cc;
}

EmailAddressesTypes
SendMailAdv::getBcc()
{
	return bcc;
}

void
SendMailAdv::setBcc(EmailAddressesTypes bcc)
{
	this->bcc = bcc;
}

std::list<MailAttachment>
SendMailAdv::getAttachments()
{
	return attachments;
}

void
SendMailAdv::setAttachments(std::list<MailAttachment> attachments)
{
	this->attachments = attachments;
}

long
SendMailAdv::getId()
{
	return id;
}

void
SendMailAdv::setId(long id)
{
	this->id = id;
}



