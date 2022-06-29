

#include "SendMailAdv_attachments_inner.h"

using namespace Tiny;

SendMailAdv_attachments_inner::SendMailAdv_attachments_inner()
{
	data = std::string();
	filename = std::string();
}

SendMailAdv_attachments_inner::SendMailAdv_attachments_inner(std::string jsonString)
{
	this->fromJson(jsonString);
}

SendMailAdv_attachments_inner::~SendMailAdv_attachments_inner()
{

}

void
SendMailAdv_attachments_inner::fromJson(std::string jsonObj)
{
    bourne::json object = bourne::json::parse(jsonObj);

    const char *dataKey = "data";

    if(object.has_key(dataKey))
    {
        bourne::json value = object[dataKey];



        jsonToValue(&data, value, "std::string");


    }

    const char *filenameKey = "filename";

    if(object.has_key(filenameKey))
    {
        bourne::json value = object[filenameKey];



        jsonToValue(&filename, value, "std::string");


    }


}

bourne::json
SendMailAdv_attachments_inner::toJson()
{
    bourne::json object = bourne::json::object();





    object["data"] = getData();






    object["filename"] = getFilename();



    return object;

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



