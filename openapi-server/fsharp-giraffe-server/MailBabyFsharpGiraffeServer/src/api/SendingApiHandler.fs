namespace MailBabyFsharpGiraffeServer

open System.Collections.Generic
open Giraffe
open Microsoft.AspNetCore.Http
open FSharp.Control.Tasks.V2.ContextInsensitive
open SendingApiHandlerParams
open SendingApiServiceInterface
open SendingApiServiceImplementation
open MailBabyFsharpGiraffeServer.Model.EmailAddressTypes
open MailBabyFsharpGiraffeServer.Model.EmailAddressesTypes
open MailBabyFsharpGiraffeServer.Model.ErrorMessage
open MailBabyFsharpGiraffeServer.Model.GenericResponse
open MailBabyFsharpGiraffeServer.Model.MailAttachment
open MailBabyFsharpGiraffeServer.Model.SendMailRaw
open MailBabyFsharpGiraffeServer.Model.SendMailTo

module SendingApiHandler =

    /// <summary>
    /// 
    /// </summary>

    //#region RawMail
    /// <summary>
    /// Send a pre-built RFC 822 message verbatim (preserves DKIM)
    /// </summary>

    let RawMail  : HttpHandler =
      fun (next : HttpFunc) (ctx : HttpContext) ->
        task {
          let! bodyParams =
            ctx.BindJsonAsync<RawMailBodyParams>()
          let serviceArgs = {     bodyParams=bodyParams } : RawMailArgs
          let result = SendingApiService.RawMail ctx serviceArgs
          return! (match result with
                      | RawMailStatusCode200 resolved ->
                            setStatusCode 200 >=> json resolved.content
                      | RawMailStatusCode400 resolved ->
                            setStatusCode 400 >=> json resolved.content
                      | RawMailStatusCode401 resolved ->
                            setStatusCode 401 >=> json resolved.content
                      | RawMailStatusCode404 resolved ->
                            setStatusCode 404 >=> json resolved.content
          ) next ctx
        }
    //#endregion

    //#region SendAdvMail
    /// <summary>
    /// Send email with multiple recipients, CC/BCC, attachments, named contacts
    /// </summary>

    let SendAdvMail  : HttpHandler =
      fun (next : HttpFunc) (ctx : HttpContext) ->
        task {
          let! formParams = ctx.TryBindFormAsync<SendAdvMailFormParams>()
          let serviceArgs = {   formParams=formParams;   } : SendAdvMailArgs
          let result = SendingApiService.SendAdvMail ctx serviceArgs
          return! (match result with
                      | SendAdvMailStatusCode200 resolved ->
                            setStatusCode 200 >=> json resolved.content
                      | SendAdvMailStatusCode400 resolved ->
                            setStatusCode 400 >=> json resolved.content
                      | SendAdvMailStatusCode401 resolved ->
                            setStatusCode 401 >=> json resolved.content
                      | SendAdvMailStatusCode404 resolved ->
                            setStatusCode 404 >=> json resolved.content
          ) next ctx
        }
    //#endregion

    //#region SendMail
    /// <summary>
    /// Send a simple email (single recipient, plain or HTML)
    /// </summary>

    let SendMail  : HttpHandler =
      fun (next : HttpFunc) (ctx : HttpContext) ->
        task {
          let! formParams = ctx.TryBindFormAsync<SendMailFormParams>()
          let serviceArgs = {   formParams=formParams;   } : SendMailArgs
          let result = SendingApiService.SendMail ctx serviceArgs
          return! (match result with
                      | SendMailStatusCode200 resolved ->
                            setStatusCode 200 >=> json resolved.content
                      | SendMailStatusCode400 resolved ->
                            setStatusCode 400 >=> json resolved.content
                      | SendMailStatusCode401 resolved ->
                            setStatusCode 401 >=> json resolved.content
                      | SendMailStatusCode404 resolved ->
                            setStatusCode 404 >=> json resolved.content
          ) next ctx
        }
    //#endregion

