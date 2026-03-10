#include "HistoryApi.h"

using namespace Tiny;



        Response<
            MailStatsType
        >
        HistoryApi::
        getStats(
            
            std::string time
            
        )
        {
            std::string url = basepath + "/mail/stats"; //


            // Headers  | 

            // Query    | time 
            addQueryParam("time",time);

            // Form     | 





            std::string payload = "";
            // Send Request
            // METHOD | GET
            // Body     | 
            int httpCode = sendRequest(url, "GET", reinterpret_cast<uint8_t*>(&payload[0]), payload.length());

            // Handle Request
            String output = getResponseBody();
            std::string output_string = output.c_str();




            MailStatsType obj(output_string);


            Response<MailStatsType> response(obj, httpCode);
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
            
            std::string messageId
            , 
            
            std::string replyto
            , 
            
            std::string headerfrom
            , 
            
            int delivered
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

            // Query    | id origin mx from to subject mailid messageId replyto headerfrom delivered skip limit startDate endDate 
            addQueryParam("id",id);
            addQueryParam("origin",origin);
            addQueryParam("mx",mx);
            addQueryParam("from",from);
            addQueryParam("to",to);
            addQueryParam("subject",subject);
            addQueryParam("mailid",mailid);
            addQueryParam("messageId",messageId);
            addQueryParam("replyto",replyto);
            addQueryParam("headerfrom",headerfrom);
            addQueryParam("delivered",delivered);
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



