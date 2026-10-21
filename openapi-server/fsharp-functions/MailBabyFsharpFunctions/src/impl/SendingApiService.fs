namespace MailBabyFsharpFunctions
open MailBabyFsharpFunctions.Model.EmailAddressTypes
open MailBabyFsharpFunctions.Model.EmailAddressesTypes
open MailBabyFsharpFunctions.Model.ErrorMessage
open MailBabyFsharpFunctions.Model.GenericResponse
open MailBabyFsharpFunctions.Model.MailAttachment
open MailBabyFsharpFunctions.Model.SendMailRaw
open MailBabyFsharpFunctions.Model.SendMailTo
open SendingApiHandlerParams
open SendingApiServiceInterface
open System.Collections.Generic
open System

module SendingApiServiceImplementation =

    //#region Service implementation
    type SendingApiServiceImpl() =
      interface ISendingApiService with

        member this.RawMail (parameters:RawMailBodyParams) =
          if true then
            let content = "Email accepted for delivery" :> obj :?> GenericResponse // this cast is obviously wrong, and is only intended to allow generated project to compile   
            RawMailStatusCode200 { content = content }
          else if true then
            let content = "Bad request — one or more input parameters were missing or invalid." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            RawMailStatusCode400 { content = content }
          else if true then
            let content = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            RawMailStatusCode401 { content = content }
          else
            let content = "The specified resource was not found or does not belong to your account." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            RawMailStatusCode404 { content = content }

        member this.SendAdvMail () =
          if true then
            let content = "Email accepted for delivery" :> obj :?> GenericResponse // this cast is obviously wrong, and is only intended to allow generated project to compile   
            SendAdvMailStatusCode200 { content = content }
          else if true then
            let content = "Bad request — one or more input parameters were missing or invalid." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            SendAdvMailStatusCode400 { content = content }
          else if true then
            let content = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            SendAdvMailStatusCode401 { content = content }
          else
            let content = "The specified resource was not found or does not belong to your account." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            SendAdvMailStatusCode404 { content = content }

        member this.SendMail () =
          if true then
            let content = "Email accepted for delivery" :> obj :?> GenericResponse // this cast is obviously wrong, and is only intended to allow generated project to compile   
            SendMailStatusCode200 { content = content }
          else if true then
            let content = "Bad request — one or more input parameters were missing or invalid." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            SendMailStatusCode400 { content = content }
          else if true then
            let content = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            SendMailStatusCode401 { content = content }
          else
            let content = "The specified resource was not found or does not belong to your account." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            SendMailStatusCode404 { content = content }

      //#endregion

    let SendingApiService = SendingApiServiceImpl() :> ISendingApiService