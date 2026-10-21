namespace MailBabyFsharpGiraffeServer

open System.Collections.Generic
open Giraffe
open Microsoft.AspNetCore.Http
open FSharp.Control.Tasks.V2.ContextInsensitive
open BlockingApiHandlerParams
open BlockingApiServiceInterface
open BlockingApiServiceImplementation
open MailBabyFsharpGiraffeServer.Model.DenyRuleRecord
open MailBabyFsharpGiraffeServer.Model.EmailAddressParam
open MailBabyFsharpGiraffeServer.Model.ErrorMessage
open MailBabyFsharpGiraffeServer.Model.GenericResponse
open MailBabyFsharpGiraffeServer.Model.MailBlocks

module BlockingApiHandler =

    /// <summary>
    /// 
    /// </summary>

    //#region AddRule
    /// <summary>
    /// Create a deny rule to block a sender, domain, destination, or prefix
    /// </summary>

    let AddRule  : HttpHandler =
      fun (next : HttpFunc) (ctx : HttpContext) ->
        task {
          let! formParams = ctx.TryBindFormAsync<AddRuleFormParams>()
          let serviceArgs = {   formParams=formParams;   } : AddRuleArgs
          let result = BlockingApiService.AddRule ctx serviceArgs
          return! (match result with
                      | AddRuleStatusCode200 resolved ->
                            setStatusCode 200 >=> json resolved.content
                      | AddRuleStatusCode400 resolved ->
                            setStatusCode 400 >=> json resolved.content
                      | AddRuleStatusCode401 resolved ->
                            setStatusCode 401 >=> json resolved.content
                      | AddRuleStatusCode404 resolved ->
                            setStatusCode 404 >=> json resolved.content
          ) next ctx
        }
    //#endregion

    //#region DeleteRule
    /// <summary>
    /// Delete a deny rule by its numeric ruleId
    /// </summary>

    let DeleteRule (pathParams:DeleteRulePathParams) : HttpHandler =
      fun (next : HttpFunc) (ctx : HttpContext) ->
        task {
          let serviceArgs = {    pathParams=pathParams;  } : DeleteRuleArgs
          let result = BlockingApiService.DeleteRule ctx serviceArgs
          return! (match result with
                      | DeleteRuleStatusCode200 resolved ->
                            setStatusCode 200 >=> json resolved.content
                      | DeleteRuleStatusCode400 resolved ->
                            setStatusCode 400 >=> json resolved.content
                      | DeleteRuleStatusCode401 resolved ->
                            setStatusCode 401 >=> json resolved.content
                      | DeleteRuleStatusCode404 resolved ->
                            setStatusCode 404 >=> json resolved.content
          ) next ctx
        }
    //#endregion

    //#region DelistBlock
    /// <summary>
    /// Delist an email address from the spam-filter block lists
    /// </summary>

    let DelistBlock  : HttpHandler =
      fun (next : HttpFunc) (ctx : HttpContext) ->
        task {
          let! bodyParams =
            ctx.BindJsonAsync<DelistBlockBodyParams>()
          let serviceArgs = {     bodyParams=bodyParams } : DelistBlockArgs
          let result = BlockingApiService.DelistBlock ctx serviceArgs
          return! (match result with
                      | DelistBlockStatusCode200 resolved ->
                            setStatusCode 200 >=> json resolved.content
                      | DelistBlockStatusCode400 resolved ->
                            setStatusCode 400 >=> json resolved.content
                      | DelistBlockStatusCode401 resolved ->
                            setStatusCode 401 >=> json resolved.content
                      | DelistBlockStatusCode404 resolved ->
                            setStatusCode 404 >=> json resolved.content
          ) next ctx
        }
    //#endregion

    //#region GetMailBlocks
    /// <summary>
    /// List addresses currently flagged by spam-filter block lists
    /// </summary>

    let GetMailBlocks  : HttpHandler =
      fun (next : HttpFunc) (ctx : HttpContext) ->
        task {
          let result = BlockingApiService.GetMailBlocks ctx 
          return! (match result with
                      | GetMailBlocksStatusCode200 resolved ->
                            setStatusCode 200 >=> json resolved.content
                      | GetMailBlocksStatusCode401 resolved ->
                            setStatusCode 401 >=> json resolved.content
          ) next ctx
        }
    //#endregion

    //#region GetRules
    /// <summary>
    /// List custom deny rules (sender / domain / destination / prefix)
    /// </summary>

    let GetRules  : HttpHandler =
      fun (next : HttpFunc) (ctx : HttpContext) ->
        task {
          let result = BlockingApiService.GetRules ctx 
          return! (match result with
                      | GetRulesStatusCode200 resolved ->
                            setStatusCode 200 >=> json resolved.content
                      | GetRulesStatusCode401 resolved ->
                            setStatusCode 401 >=> json resolved.content
          ) next ctx
        }
    //#endregion

