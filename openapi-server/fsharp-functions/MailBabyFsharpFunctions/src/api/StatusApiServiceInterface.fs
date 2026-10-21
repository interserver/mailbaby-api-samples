namespace MailBabyFsharpFunctions
open StatusApiHandlerParams
open System
open Microsoft.AspNetCore.Http


module StatusApiServiceInterface =

    //#region Service interface
    type IStatusApiService =
      abstract member PingServer : unit -> PingServerResult
    //#endregion