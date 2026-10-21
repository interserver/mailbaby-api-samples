namespace MailBabyFsharpFunctions
open BlockingApiHandlerParams
open System
open Microsoft.AspNetCore.Http


module BlockingApiServiceInterface =

    //#region Service interface
    type IBlockingApiService =
      abstract member AddRule : unit -> AddRuleResult
      abstract member DeleteRule : unit -> DeleteRuleResult
      abstract member DelistBlock : DelistBlockBodyParams -> DelistBlockResult
      abstract member GetMailBlocks : unit -> GetMailBlocksResult
      abstract member GetRules : unit -> GetRulesResult
    //#endregion