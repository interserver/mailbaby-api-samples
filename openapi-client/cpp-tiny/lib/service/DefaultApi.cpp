#include "DefaultApi.h"

using namespace Tiny;



        Response<
            std::list<GetMailOrders_200_response_inner>
        >
        DefaultApi::
        getMailOrders(
        )
        {
            std::string url = basepath + "/mail"; //


            // Headers  | 

            // Query    | 

            // Form     | 





            std::string payload = "";
            // Send Request
            // METHOD | GET
            // Body     | 
            int httpCode = sendRequest(url, "GET", reinterpret_cast<uint8_t*>(&payload[0]), payload.length());

            // Handle Request
            String output = getResponseBody();
            std::string output_string = output.c_str();



            std::list<GetMailOrders_200_response_inner> obj = std::list<GetMailOrders_200_response_inner>();
            bourne::json jsonPayload(output_string);








            
            for(auto& var : jsonPayload.array_range())
            {
                GetMailOrders_200_response_inner tmp(var.dump());
                obj.push_back(tmp);
            }
            







            Response<std::list<GetMailOrders_200_response_inner>> response(obj, httpCode);
            return response;
        }

        Response<
            String
        >
        DefaultApi::
        pingServer(
        )
        {
            std::string url = basepath + "/ping"; //


            // Headers  | 

            // Query    | 

            // Form     | 





            std::string payload = "";
            // Send Request
            // METHOD | GET
            // Body     | 
            int httpCode = sendRequest(url, "GET", reinterpret_cast<uint8_t*>(&payload[0]), payload.length());

            // Handle Request
            String output = getResponseBody();
            std::string output_string = output.c_str();


            Response<String> response(output, httpCode);
            return response;
        }

        Response<
            GenericResponse
        >
        DefaultApi::
        sendAdvMail(
            
            SendMailAdv sendMailAdv
            
        )
        {
            std::string url = basepath + "/mail/advsend"; //


            // Headers  | 

            // Query    | 

            // Form     | 
            addHeader("Content-Type", "application/json");





            std::string payload = "";
            // Send Request
            // METHOD | POST
            // Body     | sendMailAdv



            payload = sendMailAdv.toJson().dump();

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
        DefaultApi::
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

        Response<
            MailLog
        >
        DefaultApi::
        viewMailLog(
            
            long id
            , 
            
            std::string search
            , 
            
            int skip
            , 
            
            int limit
            , 
            
            long startDate
            , 
            
            long endDate
            
        )
        {
            std::string url = basepath + "/mail/log"; //


            // Headers  | 

            // Query    | id search skip limit startDate endDate 
            addQueryParam("id",id);
            addQueryParam("search",search);
            addQueryParam("skip",skip);
            addQueryParam("limit",limit);
            addQueryParam("startDate",startDate);
            addQueryParam("endDate",endDate);

            // Form     | 





            std::string payload = "";
            // Send Request
            // METHOD | GET
            // Body     | 
            int httpCode = sendRequest(url, "GET", reinterpret_cast<uint8_t*>(&payload[0]), payload.length());

            // Handle Request
            String output = getResponseBody();
            std::string output_string = output.c_str();




            MailLog obj(output_string);


            Response<MailLog> response(obj, httpCode);
            return response;
        }



