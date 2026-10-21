namespace MailBabyFsharpFunctions

open StatusApiHandlerParams
open StatusApiServiceImplementation
open Microsoft.AspNetCore.Mvc
open Microsoft.AspNetCore.Http
open Newtonsoft.Json
open Microsoft.Azure.WebJobs
open System.IO

module StatusApiHandlers =

    /// <summary>
    /// 
    /// </summary>

    //#region PingServer
    /// <summary>
    /// Health check — verify the API is reachable
    /// </summary>
   [<FunctionName("PingServer")>]
    let PingServer
        ([<HttpTrigger(Extensions.Http.AuthorizationLevel.Anonymous, "GET", Route = "/ping")>]
        req:HttpRequest ) =

      let result = StatusApiService.PingServer ()
      match result with
      | PingServerStatusCode200 resolved ->
          let content = resolved.content
          let responseContentType = "text/plain"
          ContentResult(Content = content, ContentType = responseContentType, StatusCode = System.Nullable(200))
      | PingServerDefaultStatusCode resolved ->
          let content = resolved.content
          let responseContentType = "text/plain"
          ContentResult(Content = content, ContentType = responseContentType, StatusCode = System.Nullable(0))

