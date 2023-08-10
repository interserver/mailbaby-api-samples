#include "BlockingApi.h"

using namespace Tiny;



        Response<
            GenericResponse
        >
        BlockingApi::
        addRule(
            
            std::string type
            , 
            
            std::string data
            , 
            
            std::string user
            
        )
        {
            std::string url = basepath + "/mail/rules"; //


            // Headers  | 

            // Query    | 

            // Form     | user type data 
            addHeader("Content-Type", "application/x-www-form-urlencoded");

            addFormParam("user",user);
            addFormParam("type",type);
            addFormParam("data",data);




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
        BlockingApi::
        deleteRule(
            
            int ruleId
            
        )
        {
            std::string url = basepath + "/mail/rules/{ruleId}"; //ruleId 


            // Headers  | 

            // Query    | 

            // Form     | 



                std::string s_ruleId("{");
                s_ruleId.append("ruleId");
                s_ruleId.append("}");

                int pos = url.find(s_ruleId);

                url.erase(pos, s_ruleId.length());
                url.insert(pos, stringify(ruleId));


            std::string payload = "";
            // Send Request
            // METHOD | DELETE
            // Body     | 
            int httpCode = sendRequest(url, "DELETE", reinterpret_cast<uint8_t*>(&payload[0]), payload.length());

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
        BlockingApi::
        delistBlock(
            
            EmailAddress emailAddress
            
        )
        {
            std::string url = basepath + "/mail/blocks/delete"; //


            // Headers  | 

            // Query    | 

            // Form     | 
            addHeader("Content-Type", "application/json");





            std::string payload = "";
            // Send Request
            // METHOD | POST
            // Body     | emailAddress



            payload = emailAddress.toJson().dump();

            int httpCode = sendRequest(url, "POST", reinterpret_cast<uint8_t*>(&payload[0]), payload.length());

            // Handle Request
            String output = getResponseBody();
            std::string output_string = output.c_str();




            GenericResponse obj(output_string);


            Response<GenericResponse> response(obj, httpCode);
            return response;
        }

        Response<
            MailBlocks
        >
        BlockingApi::
        getMailBlocks(
        )
        {
            std::string url = basepath + "/mail/blocks"; //


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




            MailBlocks obj(output_string);


            Response<MailBlocks> response(obj, httpCode);
            return response;
        }

        Response<
            std::list<DenyRuleRecord>
        >
        BlockingApi::
        getRules(
        )
        {
            std::string url = basepath + "/mail/rules"; //


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



            std::list<DenyRuleRecord> obj = std::list<DenyRuleRecord>();
            bourne::json jsonPayload(output_string);








            
            for(auto& var : jsonPayload.array_range())
            {
                DenyRuleRecord tmp(var.dump());
                obj.push_back(tmp);
            }
            







            Response<std::list<DenyRuleRecord>> response(obj, httpCode);
            return response;
        }



