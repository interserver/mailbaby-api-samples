namespace MailBabyFsharpGiraffeServer
open MailBabyFsharpGiraffeServer.Model.DenyRuleRecord
open MailBabyFsharpGiraffeServer.Model.EmailAddressParam
open MailBabyFsharpGiraffeServer.Model.ErrorMessage
open MailBabyFsharpGiraffeServer.Model.GenericResponse
open MailBabyFsharpGiraffeServer.Model.MailBlocks
open BlockingApiHandlerParams
open BlockingApiServiceInterface
open System.Collections.Generic
open System
open Giraffe

module BlockingApiServiceImplementation =

    //#region Service implementation
    type BlockingApiServiceImpl() =
      interface IBlockingApiService with

        member this.AddRule ctx args =
          if true then
            let content = "Rule created successfully" :> obj :?> GenericResponse // this cast is obviously wrong, and is only intended to allow generated project to compile   
            AddRuleStatusCode200 { content = content }
          else if true then
            let content = "Bad request — one or more input parameters were missing or invalid." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            AddRuleStatusCode400 { content = content }
          else if true then
            let content = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            AddRuleStatusCode401 { content = content }
          else
            let content = "The specified resource was not found or does not belong to your account." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            AddRuleStatusCode404 { content = content }

        member this.DeleteRule ctx args =
          if true then
            let content = "Rule deleted successfully" :> obj :?> GenericResponse // this cast is obviously wrong, and is only intended to allow generated project to compile   
            DeleteRuleStatusCode200 { content = content }
          else if true then
            let content = "Bad request — one or more input parameters were missing or invalid." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            DeleteRuleStatusCode400 { content = content }
          else if true then
            let content = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            DeleteRuleStatusCode401 { content = content }
          else
            let content = "The specified resource was not found or does not belong to your account." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            DeleteRuleStatusCode404 { content = content }

        member this.DelistBlock ctx args =
          if true then
            let content = "Address successfully delisted" :> obj :?> GenericResponse // this cast is obviously wrong, and is only intended to allow generated project to compile   
            DelistBlockStatusCode200 { content = content }
          else if true then
            let content = "Bad request — one or more input parameters were missing or invalid." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            DelistBlockStatusCode400 { content = content }
          else if true then
            let content = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            DelistBlockStatusCode401 { content = content }
          else
            let content = "The specified resource was not found or does not belong to your account." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            DelistBlockStatusCode404 { content = content }

        member this.GetMailBlocks ctx  =
          if true then
            let content = "OK" :> obj :?> MailBlocks // this cast is obviously wrong, and is only intended to allow generated project to compile   
            GetMailBlocksStatusCode200 { content = content }
          else
            let content = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            GetMailBlocksStatusCode401 { content = content }

        member this.GetRules ctx  =
          if true then
            let content = "OK" :> obj :?> DenyRuleRecord[] // this cast is obviously wrong, and is only intended to allow generated project to compile   
            GetRulesStatusCode200 { content = content }
          else
            let content = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)." :> obj :?> ErrorMessage // this cast is obviously wrong, and is only intended to allow generated project to compile   
            GetRulesStatusCode401 { content = content }

      //#endregion

    let BlockingApiService = BlockingApiServiceImpl() :> IBlockingApiService