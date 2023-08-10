#include "ServicesApi.h"

using namespace Tiny;



        Response<
            std::list<MailOrder>
        >
        ServicesApi::
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



            std::list<MailOrder> obj = std::list<MailOrder>();
            bourne::json jsonPayload(output_string);








            
            for(auto& var : jsonPayload.array_range())
            {
                MailOrder tmp(var.dump());
                obj.push_back(tmp);
            }
            







            Response<std::list<MailOrder>> response(obj, httpCode);
            return response;
        }



