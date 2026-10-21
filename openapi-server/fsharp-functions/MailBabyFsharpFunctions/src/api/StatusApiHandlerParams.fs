namespace MailBabyFsharpFunctions

open System.Collections.Generic
open System

module StatusApiHandlerParams =



    type PingServerStatusCode200Response = {
      content:string;
      
    }

    type PingServerDefaultStatusCodeResponse = {
      content:string;
      
    }
    type PingServerResult = PingServerStatusCode200 of PingServerStatusCode200Response|PingServerDefaultStatusCode of PingServerDefaultStatusCodeResponse

