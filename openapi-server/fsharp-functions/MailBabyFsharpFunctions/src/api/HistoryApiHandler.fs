namespace MailBabyFsharpFunctions

open HistoryApiHandlerParams
open HistoryApiServiceImplementation
open Microsoft.AspNetCore.Mvc
open Microsoft.AspNetCore.Http
open Newtonsoft.Json
open Microsoft.Azure.WebJobs
open System.IO

module HistoryApiHandlers =

    /// <summary>
    /// 
    /// </summary>

    //#region GetStats
    /// <summary>
    /// Account usage, cost, and volume statistics for a time window
    /// </summary>
   [<FunctionName("GetStats")>]
    let GetStats
        ([<HttpTrigger(Extensions.Http.AuthorizationLevel.Anonymous, "GET", Route = "/mail/stats")>]
        req:HttpRequest ) =

      let result = HistoryApiService.GetStats ()
      match result with
      | GetStatsStatusCode200 resolved ->
          let content = JsonConvert.SerializeObject resolved.content
          let responseContentType = "application/json"
          ContentResult(Content = content, ContentType = responseContentType, StatusCode = System.Nullable(200))
      | GetStatsStatusCode401 resolved ->
          let content = JsonConvert.SerializeObject resolved.content
          let responseContentType = "application/json"
          ContentResult(Content = content, ContentType = responseContentType, StatusCode = System.Nullable(401))

    //#region ViewMailLog
    /// <summary>
    /// Query the mail delivery log (filterable, paginated)
    /// </summary>
   [<FunctionName("ViewMailLog")>]
    let ViewMailLog
        ([<HttpTrigger(Extensions.Http.AuthorizationLevel.Anonymous, "GET", Route = "/mail/log")>]
        req:HttpRequest ) =

      let result = HistoryApiService.ViewMailLog ()
      match result with
      | ViewMailLogStatusCode200 resolved ->
          let content = JsonConvert.SerializeObject resolved.content
          let responseContentType = "application/json"
          ContentResult(Content = content, ContentType = responseContentType, StatusCode = System.Nullable(200))
      | ViewMailLogStatusCode400 resolved ->
          let content = JsonConvert.SerializeObject resolved.content
          let responseContentType = "application/json"
          ContentResult(Content = content, ContentType = responseContentType, StatusCode = System.Nullable(400))
      | ViewMailLogStatusCode401 resolved ->
          let content = JsonConvert.SerializeObject resolved.content
          let responseContentType = "application/json"
          ContentResult(Content = content, ContentType = responseContentType, StatusCode = System.Nullable(401))

