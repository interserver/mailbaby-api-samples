namespace MailBabyFsharpGiraffeServer

open System.Collections.Generic
open Giraffe
open Microsoft.AspNetCore.Http
open FSharp.Control.Tasks.V2.ContextInsensitive
open StatusApiHandlerParams
open StatusApiServiceInterface
open StatusApiServiceImplementation

module StatusApiHandler =

    /// <summary>
    /// 
    /// </summary>

    //#region PingServer
    /// <summary>
    /// Health check — verify the API is reachable
    /// </summary>

    let PingServer  : HttpHandler =
      fun (next : HttpFunc) (ctx : HttpContext) ->
        task {
          let result = StatusApiService.PingServer ctx 
          return! (match result with
                      | PingServerStatusCode200 resolved ->
                            setStatusCode 200 >=> text resolved.content
                      | PingServerDefaultStatusCode resolved ->
                            setStatusCode 0 >=> text resolved.content
          ) next ctx
        }
    //#endregion

