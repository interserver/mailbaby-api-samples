namespace MailBabyFsharpGiraffeServer

open System.Collections.Generic
open Giraffe
open Microsoft.AspNetCore.Http
open FSharp.Control.Tasks.V2.ContextInsensitive
open HistoryApiHandlerParams
open HistoryApiServiceInterface
open HistoryApiServiceImplementation
open MailBabyFsharpGiraffeServer.Model.DateOrTimestamp
open MailBabyFsharpGiraffeServer.Model.ErrorMessage
open MailBabyFsharpGiraffeServer.Model.MailLog
open MailBabyFsharpGiraffeServer.Model.MailStatsType

module HistoryApiHandler =

    /// <summary>
    /// 
    /// </summary>

    //#region GetStats
    /// <summary>
    /// Account usage, cost, and volume statistics for a time window
    /// </summary>

    let GetStats  : HttpHandler =
      fun (next : HttpFunc) (ctx : HttpContext) ->
        task {
          let queryParams = ctx.TryBindQueryString<GetStatsQueryParams>()
          let serviceArgs = {  queryParams=queryParams;    } : GetStatsArgs
          let result = HistoryApiService.GetStats ctx serviceArgs
          return! (match result with
                      | GetStatsStatusCode200 resolved ->
                            setStatusCode 200 >=> json resolved.content
                      | GetStatsStatusCode401 resolved ->
                            setStatusCode 401 >=> json resolved.content
          ) next ctx
        }
    //#endregion

    //#region ViewMailLog
    /// <summary>
    /// Query the mail delivery log (filterable, paginated)
    /// </summary>

    let ViewMailLog  : HttpHandler =
      fun (next : HttpFunc) (ctx : HttpContext) ->
        task {
          let queryParams = ctx.TryBindQueryString<ViewMailLogQueryParams>()
          let serviceArgs = {  queryParams=queryParams;    } : ViewMailLogArgs
          let result = HistoryApiService.ViewMailLog ctx serviceArgs
          return! (match result with
                      | ViewMailLogStatusCode200 resolved ->
                            setStatusCode 200 >=> json resolved.content
                      | ViewMailLogStatusCode400 resolved ->
                            setStatusCode 400 >=> json resolved.content
                      | ViewMailLogStatusCode401 resolved ->
                            setStatusCode 401 >=> json resolved.content
          ) next ctx
        }
    //#endregion

