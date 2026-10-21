namespace MailBabyFsharpFunctions

open MailBabyFsharpFunctions.Model.ErrorMessage
open MailBabyFsharpFunctions.Model.MailLog
open MailBabyFsharpFunctions.Model.MailStatsType
open System.Collections.Generic
open System

module HistoryApiHandlerParams =


    //#region Query parameters
    [<CLIMutable>]
    type GetStatsQueryParams = {
      time : string option;

    }
    //#endregion


    type GetStatsStatusCode200Response = {
      content:MailStatsType;
      
    }

    type GetStatsStatusCode401Response = {
      content:ErrorMessage;
      
    }
    type GetStatsResult = GetStatsStatusCode200 of GetStatsStatusCode200Response|GetStatsStatusCode401 of GetStatsStatusCode401Response

    type GetStatsArgs = {
      queryParams:Result<GetStatsQueryParams,string>;
    }

    //#region Query parameters
    [<CLIMutable>]
    type ViewMailLogQueryParams = {
      id : int64 option;


      origin : string option;


      mx : string option;


      from : string option;


      _to : string option;


      subject : string option;


      mailid : string option;


      messageId : string option;


      replyto : string option;


      headerfrom : string option;


      delivered : int option;


      skip : int option;


      limit : int option;


      startDate : string option;


      endDate : string option;


      sort : string option;


      dir : string option;


      groupby : string option;

    }
    //#endregion


    type ViewMailLogStatusCode200Response = {
      content:MailLog;
      
    }

    type ViewMailLogStatusCode400Response = {
      content:ErrorMessage;
      
    }

    type ViewMailLogStatusCode401Response = {
      content:ErrorMessage;
      
    }
    type ViewMailLogResult = ViewMailLogStatusCode200 of ViewMailLogStatusCode200Response|ViewMailLogStatusCode400 of ViewMailLogStatusCode400Response|ViewMailLogStatusCode401 of ViewMailLogStatusCode401Response

    type ViewMailLogArgs = {
      queryParams:Result<ViewMailLogQueryParams,string>;
    }
