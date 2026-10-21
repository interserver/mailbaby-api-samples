namespace MailBabyFsharpGiraffeServer
open SendingApiHandlerParams
open System
open Giraffe
open Microsoft.AspNetCore.Http


module SendingApiServiceInterface =

    //#region Service interface
    type ISendingApiService =
      abstract member RawMail:HttpContext -> RawMailArgs->RawMailResult
      abstract member SendAdvMail:HttpContext -> SendAdvMailArgs->SendAdvMailResult
      abstract member SendMail:HttpContext -> SendMailArgs->SendMailResult
    //#endregion