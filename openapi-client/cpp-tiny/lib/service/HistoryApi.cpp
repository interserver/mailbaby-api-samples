#include "HistoryApi.h"

using namespace Tiny;



        Response<
            std::list<GetStats_200_response_inner>
        >
        HistoryApi::
        getStats(
        )
        {
            std::string url = basepath + "/mail/stats"; //


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



            std::list<GetStats_200_response_inner> obj = std::list<GetStats_200_response_inner>();
            bourne::json jsonPayload(output_string);








            
            for(auto& var : jsonPayload.array_range())
            {
                GetStats_200_response_inner tmp(var.dump());
                obj.push_back(tmp);
            }
            







            Response<std::list<GetStats_200_response_inner>> response(obj, httpCode);
            return response;
        }

        Response<
            MailLog
        >
        HistoryApi::
        viewMailLog(
            
            long id
            , 
            
            std::string origin
            , 
            
            std::string mx
            , 
            
            std::string from
            , 
            
            std::string to
            , 
            
            std::string subject
            , 
            
            std::string mailid
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

            // Query    | id origin mx from to subject mailid skip limit startDate endDate 
            addQueryParam("id",id);
            addQueryParam("origin",origin);
            addQueryParam("mx",mx);
            addQueryParam("from",from);
            addQueryParam("to",to);
            addQueryParam("subject",subject);
            addQueryParam("mailid",mailid);
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



