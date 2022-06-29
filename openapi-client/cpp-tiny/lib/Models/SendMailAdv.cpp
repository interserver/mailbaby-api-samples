

#include "SendMailAdv.h"

using namespace Tiny;

SendMailAdv::SendMailAdv()
{
	subject = std::string();
	body = std::string();
	from = SendMailAdv_from();
	to = std::list<SendMailAdv_to_inner>();
	replyto = std::list<SendMailAdv_replyto_inner>();
	cc = std::list<SendMailAdv_cc_inner>();
	bcc = std::list<SendMailAdv_bcc_inner>();
	attachments = std::list<SendMailAdv_attachments_inner>();
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




        SendMailAdv_from* obj = &from;
		obj->fromJson(value.dump());

    }

    const char *toKey = "to";

    if(object.has_key(toKey))
    {
        bourne::json value = object[toKey];


        std::list<SendMailAdv_to_inner> to_list;
        SendMailAdv_to_inner element;
        for(auto& var : value.array_range())
        {


            element.fromJson(var.dump());

            to_list.push_back(element);
        }
        to = to_list;


    }

    const char *replytoKey = "replyto";

    if(object.has_key(replytoKey))
    {
        bourne::json value = object[replytoKey];


        std::list<SendMailAdv_replyto_inner> replyto_list;
        SendMailAdv_replyto_inner element;
        for(auto& var : value.array_range())
        {


            element.fromJson(var.dump());

            replyto_list.push_back(element);
        }
        replyto = replyto_list;


    }

    const char *ccKey = "cc";

    if(object.has_key(ccKey))
    {
        bourne::json value = object[ccKey];


        std::list<SendMailAdv_cc_inner> cc_list;
        SendMailAdv_cc_inner element;
        for(auto& var : value.array_range())
        {


            element.fromJson(var.dump());

            cc_list.push_back(element);
        }
        cc = cc_list;


    }

    const char *bccKey = "bcc";

    if(object.has_key(bccKey))
    {
        bourne::json value = object[bccKey];


        std::list<SendMailAdv_bcc_inner> bcc_list;
        SendMailAdv_bcc_inner element;
        for(auto& var : value.array_range())
        {


            element.fromJson(var.dump());

            bcc_list.push_back(element);
        }
        bcc = bcc_list;


    }

    const char *attachmentsKey = "attachments";

    if(object.has_key(attachmentsKey))
    {
        bourne::json value = object[attachmentsKey];


        std::list<SendMailAdv_attachments_inner> attachments_list;
        SendMailAdv_attachments_inner element;
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




    std::list<SendMailAdv_to_inner> to_list = getTo();
    bourne::json to_arr = bourne::json::array();

    for(auto& var : to_list)
    {
        SendMailAdv_to_inner obj = var;
        to_arr.append(obj.toJson());
    }
    object["to"] = to_arr;






    std::list<SendMailAdv_replyto_inner> replyto_list = getReplyto();
    bourne::json replyto_arr = bourne::json::array();

    for(auto& var : replyto_list)
    {
        SendMailAdv_replyto_inner obj = var;
        replyto_arr.append(obj.toJson());
    }
    object["replyto"] = replyto_arr;






    std::list<SendMailAdv_cc_inner> cc_list = getCc();
    bourne::json cc_arr = bourne::json::array();

    for(auto& var : cc_list)
    {
        SendMailAdv_cc_inner obj = var;
        cc_arr.append(obj.toJson());
    }
    object["cc"] = cc_arr;






    std::list<SendMailAdv_bcc_inner> bcc_list = getBcc();
    bourne::json bcc_arr = bourne::json::array();

    for(auto& var : bcc_list)
    {
        SendMailAdv_bcc_inner obj = var;
        bcc_arr.append(obj.toJson());
    }
    object["bcc"] = bcc_arr;






    std::list<SendMailAdv_attachments_inner> attachments_list = getAttachments();
    bourne::json attachments_arr = bourne::json::array();

    for(auto& var : attachments_list)
    {
        SendMailAdv_attachments_inner obj = var;
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

SendMailAdv_from
SendMailAdv::getFrom()
{
	return from;
}

void
SendMailAdv::setFrom(SendMailAdv_from  from)
{
	this->from = from;
}

std::list<SendMailAdv_to_inner>
SendMailAdv::getTo()
{
	return to;
}

void
SendMailAdv::setTo(std::list <SendMailAdv_to_inner> to)
{
	this->to = to;
}

std::list<SendMailAdv_replyto_inner>
SendMailAdv::getReplyto()
{
	return replyto;
}

void
SendMailAdv::setReplyto(std::list <SendMailAdv_replyto_inner> replyto)
{
	this->replyto = replyto;
}

std::list<SendMailAdv_cc_inner>
SendMailAdv::getCc()
{
	return cc;
}

void
SendMailAdv::setCc(std::list <SendMailAdv_cc_inner> cc)
{
	this->cc = cc;
}

std::list<SendMailAdv_bcc_inner>
SendMailAdv::getBcc()
{
	return bcc;
}

void
SendMailAdv::setBcc(std::list <SendMailAdv_bcc_inner> bcc)
{
	this->bcc = bcc;
}

std::list<SendMailAdv_attachments_inner>
SendMailAdv::getAttachments()
{
	return attachments;
}

void
SendMailAdv::setAttachments(std::list <SendMailAdv_attachments_inner> attachments)
{
	this->attachments = attachments;
}

long
SendMailAdv::getId()
{
	return id;
}

void
SendMailAdv::setId(long  id)
{
	this->id = id;
}



