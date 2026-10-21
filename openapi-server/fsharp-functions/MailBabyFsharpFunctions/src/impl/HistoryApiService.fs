namespace MailBabyFsharpFunctions
open MailBabyFsharpFunctions.Model.ErrorMessage
open MailBabyFsharpFunctions.Model.MailLog
open MailBabyFsharpFunctions.Model.MailStatsType
open HistoryApiHandlerParams
open HistoryApiServiceInterface
open System.Collections.Generic
open System

module HistoryApiServiceImplementation =

    //#region Service implementation
    type HistoryApiServiceImpl() =
      interface IHistoryApiService with

        member this.GetStats () =
          if true then
            let content = "OK" :> obj :?> MailStatsType // this cast is obviously wrong, and is only intended to allow generated project to compile   
            GetStatsStatusCode200 { content = content }
          else
            let content = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            GetStatsStatusCode401 { content = content }

        member this.ViewMailLog () =
          if true then
            let content = "Paginated list of mail log entries" :> obj :?> MailLog // this cast is obviously wrong, and is only intended to allow generated project to compile   
            ViewMailLogStatusCode200 { content = content }
          else if true then
            let content = "Bad request — one or more input parameters were missing or invalid." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            ViewMailLogStatusCode400 { content = content }
          else
            let content = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            ViewMailLogStatusCode401 { content = content }

      //#endregion

    let HistoryApiService = HistoryApiServiceImpl() :> IHistoryApiService