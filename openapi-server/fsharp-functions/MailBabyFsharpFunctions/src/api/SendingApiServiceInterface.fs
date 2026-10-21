namespace MailBabyFsharpFunctions
open SendingApiHandlerParams
open System
open Microsoft.AspNetCore.Http


module SendingApiServiceInterface =

    //#region Service interface
    type ISendingApiService =
      abstract member RawMail : RawMailBodyParams -> RawMailResult
      abstract member SendAdvMail : unit -> SendAdvMailResult
      abstract member SendMail : unit -> SendMailResult
    //#endregion