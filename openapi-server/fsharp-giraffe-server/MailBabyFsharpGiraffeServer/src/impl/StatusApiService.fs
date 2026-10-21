namespace MailBabyFsharpGiraffeServer
open StatusApiHandlerParams
open StatusApiServiceInterface
open System.Collections.Generic
open System
open Giraffe

module StatusApiServiceImplementation =

    //#region Service implementation
    type StatusApiServiceImpl() =
      interface IStatusApiService with

        member this.PingServer ctx  =
          if true then
            let content = "Server is up and running" :> obj :?> string // this cast is obviously wrong, and is only intended to allow generated project to compile   
            PingServerStatusCode200 { content = content }
          else
            let content = "Something is wrong" 
            PingServerDefaultStatusCode { content = content }

      //#endregion

    let StatusApiService = StatusApiServiceImpl() :> IStatusApiService