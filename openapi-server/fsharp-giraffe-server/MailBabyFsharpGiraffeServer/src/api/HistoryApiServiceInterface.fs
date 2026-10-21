namespace MailBabyFsharpGiraffeServer
open HistoryApiHandlerParams
open System
open Giraffe
open Microsoft.AspNetCore.Http


module HistoryApiServiceInterface =

    //#region Service interface
    type IHistoryApiService =
      abstract member GetStats:HttpContext -> GetStatsArgs->GetStatsResult
      abstract member ViewMailLog:HttpContext -> ViewMailLogArgs->ViewMailLogResult
    //#endregion