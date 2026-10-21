namespace MailBabyFsharpGiraffeServer
open StatusApiHandlerParams
open System
open Giraffe
open Microsoft.AspNetCore.Http


module StatusApiServiceInterface =

    //#region Service interface
    type IStatusApiService =
      abstract member PingServer:HttpContext ->PingServerResult
    //#endregion