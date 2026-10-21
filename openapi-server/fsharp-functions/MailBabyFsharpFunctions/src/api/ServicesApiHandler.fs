namespace MailBabyFsharpFunctions

open ServicesApiHandlerParams
open ServicesApiServiceImplementation
open Microsoft.AspNetCore.Mvc
open Microsoft.AspNetCore.Http
open Newtonsoft.Json
open Microsoft.Azure.WebJobs
open System.IO

module ServicesApiHandlers =

    /// <summary>
    /// 
    /// </summary>

    //#region GetMailOrderById
    /// <summary>
    /// Get one mail order&#39;s full detail including SMTP password
    /// </summary>
   [<FunctionName("GetMailOrderById")>]
    let GetMailOrderById
        ([<HttpTrigger(Extensions.Http.AuthorizationLevel.Anonymous, "GET", Route = "/mail/{id}")>]
        req:HttpRequest ) =

      let result = ServicesApiService.GetMailOrderById ()
      match result with
      | GetMailOrderByIdStatusCode200 resolved ->
          let content = JsonConvert.SerializeObject resolved.content
          let responseContentType = "application/json"
          ContentResult(Content = content, ContentType = responseContentType, StatusCode = System.Nullable(200))
      | GetMailOrderByIdStatusCode400 resolved ->
          let content = JsonConvert.SerializeObject resolved.content
          let responseContentType = "application/json"
          ContentResult(Content = content, ContentType = responseContentType, StatusCode = System.Nullable(400))
      | GetMailOrderByIdStatusCode401 resolved ->
          let content = JsonConvert.SerializeObject resolved.content
          let responseContentType = "application/json"
          ContentResult(Content = content, ContentType = responseContentType, StatusCode = System.Nullable(401))
      | GetMailOrderByIdStatusCode404 resolved ->
          let content = JsonConvert.SerializeObject resolved.content
          let responseContentType = "application/json"
          ContentResult(Content = content, ContentType = responseContentType, StatusCode = System.Nullable(404))

    //#region GetMailOrders
    /// <summary>
    /// List your provisioned mail orders (sending accounts)
    /// </summary>
   [<FunctionName("GetMailOrders")>]
    let GetMailOrders
        ([<HttpTrigger(Extensions.Http.AuthorizationLevel.Anonymous, "GET", Route = "/mail")>]
        req:HttpRequest ) =

      let result = ServicesApiService.GetMailOrders ()
      match result with
      | GetMailOrdersStatusCode200 resolved ->
          let content = JsonConvert.SerializeObject resolved.content
          let responseContentType = "application/json"
          ContentResult(Content = content, ContentType = responseContentType, StatusCode = System.Nullable(200))
      | GetMailOrdersStatusCode401 resolved ->
          let content = JsonConvert.SerializeObject resolved.content
          let responseContentType = "application/json"
          ContentResult(Content = content, ContentType = responseContentType, StatusCode = System.Nullable(401))

