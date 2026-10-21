namespace MailBabyFsharpGiraffeServer

open System.Collections.Generic
open Giraffe
open Microsoft.AspNetCore.Http
open FSharp.Control.Tasks.V2.ContextInsensitive
open ServicesApiHandlerParams
open ServicesApiServiceInterface
open ServicesApiServiceImplementation
open MailBabyFsharpGiraffeServer.Model.ErrorMessage
open MailBabyFsharpGiraffeServer.Model.MailOrder
open MailBabyFsharpGiraffeServer.Model.MailOrderDetail

module ServicesApiHandler =

    /// <summary>
    /// 
    /// </summary>

    //#region GetMailOrderById
    /// <summary>
    /// Get one mail order&#39;s full detail including SMTP password
    /// </summary>

    let GetMailOrderById (pathParams:GetMailOrderByIdPathParams) : HttpHandler =
      fun (next : HttpFunc) (ctx : HttpContext) ->
        task {
          let serviceArgs = {    pathParams=pathParams;  } : GetMailOrderByIdArgs
          let result = ServicesApiService.GetMailOrderById ctx serviceArgs
          return! (match result with
                      | GetMailOrderByIdStatusCode200 resolved ->
                            setStatusCode 200 >=> json resolved.content
                      | GetMailOrderByIdStatusCode400 resolved ->
                            setStatusCode 400 >=> json resolved.content
                      | GetMailOrderByIdStatusCode401 resolved ->
                            setStatusCode 401 >=> json resolved.content
                      | GetMailOrderByIdStatusCode404 resolved ->
                            setStatusCode 404 >=> json resolved.content
          ) next ctx
        }
    //#endregion

    //#region GetMailOrders
    /// <summary>
    /// List your provisioned mail orders (sending accounts)
    /// </summary>

    let GetMailOrders  : HttpHandler =
      fun (next : HttpFunc) (ctx : HttpContext) ->
        task {
          let result = ServicesApiService.GetMailOrders ctx 
          return! (match result with
                      | GetMailOrdersStatusCode200 resolved ->
                            setStatusCode 200 >=> json resolved.content
                      | GetMailOrdersStatusCode401 resolved ->
                            setStatusCode 401 >=> json resolved.content
          ) next ctx
        }
    //#endregion

