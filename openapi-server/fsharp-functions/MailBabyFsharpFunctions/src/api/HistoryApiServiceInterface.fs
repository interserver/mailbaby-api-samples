namespace MailBabyFsharpFunctions
open HistoryApiHandlerParams
open System
open Microsoft.AspNetCore.Http


module HistoryApiServiceInterface =

    //#region Service interface
    type IHistoryApiService =
      abstract member GetStats : unit -> GetStatsResult
      abstract member ViewMailLog : unit -> ViewMailLogResult
    //#endregion