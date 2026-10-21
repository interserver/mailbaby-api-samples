namespace MailBabyFsharpGiraffeServer
open BlockingApiHandlerParams
open System
open Giraffe
open Microsoft.AspNetCore.Http


module BlockingApiServiceInterface =

    //#region Service interface
    type IBlockingApiService =
      abstract member AddRule:HttpContext -> AddRuleArgs->AddRuleResult
      abstract member DeleteRule:HttpContext -> DeleteRuleArgs->DeleteRuleResult
      abstract member DelistBlock:HttpContext -> DelistBlockArgs->DelistBlockResult
      abstract member GetMailBlocks:HttpContext ->GetMailBlocksResult
      abstract member GetRules:HttpContext ->GetRulesResult
    //#endregion