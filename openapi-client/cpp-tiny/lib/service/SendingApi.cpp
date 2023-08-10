#include "SendingApi.h"

using namespace Tiny;



        Response<
            GenericResponse
        >
        SendingApi::
        sendAdvMail(
            
            std::string subject
            , 
            
            std::string body
            , 
            
            EmailAddressName from
            , 
            std::list<EmailAddressName> to
            
            , 
            std::list<EmailAddressName> replyto
            
            , 
            std::list<EmailAddressName> cc
            
            , 
            std::list<EmailAddressName> bcc
            
            , 
            std::list<MailAttachment> attachments
            
            , 
            
            long id
            
        )
        {
            std::string url = basepath + "/mail/advsend"; //


            // Headers  | 

            // Query    | 

            // Form     | subject body from to replyto cc bcc attachments id 
            addHeader("Content-Type", "application/x-www-form-urlencoded");

            addFormParam("subject",subject);
            addFormParam("body",body);
            addFormParam("from",from);
            for (auto &x : to){
                addFormParam("to", std::string(x));
            }
            for (auto &x : replyto){
                addFormParam("replyto", std::string(x));
            }
            for (auto &x : cc){
                addFormParam("cc", std::string(x));
            }
            for (auto &x : bcc){
                addFormParam("bcc", std::string(x));
            }
            for (auto &x : attachments){
                addFormParam("attachments", std::string(x));
            }
            addFormParam("id",id);




            std::string payload = "";
            // Send Request
            // METHOD | POST
            // Body     | 
            int httpCode = sendRequest(url, "POST", reinterpret_cast<uint8_t*>(&payload[0]), payload.length());

            // Handle Request
            String output = getResponseBody();
            std::string output_string = output.c_str();




            GenericResponse obj(output_string);


            Response<GenericResponse> response(obj, httpCode);
            return response;
        }

        Response<
            GenericResponse
        >
        SendingApi::
        sendMail(
            
            std::string to
            , 
            
            std::string from
            , 
            
            std::string subject
            , 
            
            std::string body
            
        )
        {
            std::string url = basepath + "/mail/send"; //


            // Headers  | 

            // Query    | 

            // Form     | to from subject body 
            addHeader("Content-Type", "application/x-www-form-urlencoded");

            addFormParam("to",to);
            addFormParam("from",from);
            addFormParam("subject",subject);
            addFormParam("body",body);




            std::string payload = "";
            // Send Request
            // METHOD | POST
            // Body     | 
            int httpCode = sendRequest(url, "POST", reinterpret_cast<uint8_t*>(&payload[0]), payload.length());

            // Handle Request
            String output = getResponseBody();
            std::string output_string = output.c_str();




            GenericResponse obj(output_string);


            Response<GenericResponse> response(obj, httpCode);
            return response;
        }



