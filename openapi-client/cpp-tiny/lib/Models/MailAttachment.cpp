

#include "MailAttachment.h"

using namespace Tiny;

MailAttachment::MailAttachment()
{
	filename = std::string();
	data = std::string();
}

MailAttachment::MailAttachment(std::string jsonString)
{
	this->fromJson(jsonString);
}

MailAttachment::~MailAttachment()
{

}

void
MailAttachment::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);

    const char *filenameKey = "filename";

    if(object.has_key(filenameKey))
    {
        bourne::json value = object[filenameKey];



        jsonToValue(&filename, value, "std::string");


    }

    const char *dataKey = "data";

    if(object.has_key(dataKey))
    {
        bourne::json value = object[dataKey];




        ByteArray* obj = &data;
		obj->fromJson(value.dump());

    }


}

bourne::json
MailAttachment::toJson()
{
    bourne::json object = bourne::json::object();





    object["filename"] = getFilename();







	object["data"] = getData().toJson();


    return object;

}

std::string
MailAttachment::getFilename()
{
	return filename;
}

void
MailAttachment::setFilename(std::string filename)
{
	this->filename = filename;
}

ByteArray
MailAttachment::getData()
{
	return data;
}

void
MailAttachment::setData(ByteArray data)
{
	this->data = data;
}



