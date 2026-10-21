namespace MailBabyFsharpGiraffeServer
open MailBabyFsharpGiraffeServer.Model.ErrorMessage
open MailBabyFsharpGiraffeServer.Model.MailOrder
open MailBabyFsharpGiraffeServer.Model.MailOrderDetail
open ServicesApiHandlerParams
open ServicesApiServiceInterface
open System.Collections.Generic
open System
open Giraffe

module ServicesApiServiceImplementation =

    //#region Service implementation
    type ServicesApiServiceImpl() =
      interface IServicesApiService with

        member this.GetMailOrderById ctx args =
          if true then
            let content = "OK" :> obj :?> MailOrderDetail // this cast is obviously wrong, and is only intended to allow generated project to compile   
            GetMailOrderByIdStatusCode200 { content = content }
          else if true then
            let content = "Bad request — one or more input parameters were missing or invalid." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            GetMailOrderByIdStatusCode400 { content = content }
          else if true then
            let content = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            GetMailOrderByIdStatusCode401 { content = content }
          else
            let content = "The specified resource was not found or does not belong to your account." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            GetMailOrderByIdStatusCode404 { content = content }

        member this.GetMailOrders ctx  =
          if true then
            let content = "OK" :> obj :?> MailOrder[] // this cast is obviously wrong, and is only intended to allow generated project to compile   
            GetMailOrdersStatusCode200 { content = content }
          else
            let content = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            GetMailOrdersStatusCode401 { content = content }

      //#endregion

    let ServicesApiService = ServicesApiServiceImpl() :> IServicesApiService