namespace MailBabyFsharpGiraffeServer

open MailBabyFsharpGiraffeServer.Model.DenyRuleRecord
open MailBabyFsharpGiraffeServer.Model.EmailAddressParam
open MailBabyFsharpGiraffeServer.Model.ErrorMessage
open MailBabyFsharpGiraffeServer.Model.GenericResponse
open MailBabyFsharpGiraffeServer.Model.MailBlocks
open System.Collections.Generic
open System

module BlockingApiHandlerParams =


    //#region Form parameters
    [<CLIMutable>]
    type AddRuleFormParams = {
      user : string option;
    //#endregion

    //#region Form parameters
      _type : string ;
    //#endregion

    //#region Form parameters
      data : string ;
    }
    //#endregion


    type AddRuleStatusCode200Response = {
      content:GenericResponse;
      
    }

    type AddRuleStatusCode400Response = {
      content:ErrorMessage;
      
    }

    type AddRuleStatusCode401Response = {
      content:ErrorMessage;
      
    }

    type AddRuleStatusCode404Response = {
      content:ErrorMessage;
      
    }
    type AddRuleResult = AddRuleStatusCode200 of AddRuleStatusCode200Response|AddRuleStatusCode400 of AddRuleStatusCode400Response|AddRuleStatusCode401 of AddRuleStatusCode401Response|AddRuleStatusCode404 of AddRuleStatusCode404Response

    type AddRuleArgs = {
      formParams:Result<AddRuleFormParams,string>
    }
    //#region Path parameters
    [<CLIMutable>]
    type DeleteRulePathParams = {
      ruleId : int ;
    }
    //#endregion


    type DeleteRuleStatusCode200Response = {
      content:GenericResponse;
      
    }

    type DeleteRuleStatusCode400Response = {
      content:ErrorMessage;
      
    }

    type DeleteRuleStatusCode401Response = {
      content:ErrorMessage;
      
    }

    type DeleteRuleStatusCode404Response = {
      content:ErrorMessage;
      
    }
    type DeleteRuleResult = DeleteRuleStatusCode200 of DeleteRuleStatusCode200Response|DeleteRuleStatusCode400 of DeleteRuleStatusCode400Response|DeleteRuleStatusCode401 of DeleteRuleStatusCode401Response|DeleteRuleStatusCode404 of DeleteRuleStatusCode404Response

    type DeleteRuleArgs = {
      pathParams:DeleteRulePathParams;
    }

    //#region Body parameters
    [<CLIMutable>]
    type DelistBlockBodyParams = EmailAddressParam
    //#endregion


    type DelistBlockStatusCode200Response = {
      content:GenericResponse;
      
    }

    type DelistBlockStatusCode400Response = {
      content:ErrorMessage;
      
    }

    type DelistBlockStatusCode401Response = {
      content:ErrorMessage;
      
    }

    type DelistBlockStatusCode404Response = {
      content:ErrorMessage;
      
    }
    type DelistBlockResult = DelistBlockStatusCode200 of DelistBlockStatusCode200Response|DelistBlockStatusCode400 of DelistBlockStatusCode400Response|DelistBlockStatusCode401 of DelistBlockStatusCode401Response|DelistBlockStatusCode404 of DelistBlockStatusCode404Response

    type DelistBlockArgs = {
      bodyParams:DelistBlockBodyParams
    }


    type GetMailBlocksStatusCode200Response = {
      content:MailBlocks;
      
    }

    type GetMailBlocksStatusCode401Response = {
      content:ErrorMessage;
      
    }
    type GetMailBlocksResult = GetMailBlocksStatusCode200 of GetMailBlocksStatusCode200Response|GetMailBlocksStatusCode401 of GetMailBlocksStatusCode401Response



    type GetRulesStatusCode200Response = {
      content:DenyRuleRecord[];
      
    }

    type GetRulesStatusCode401Response = {
      content:ErrorMessage;
      
    }
    type GetRulesResult = GetRulesStatusCode200 of GetRulesStatusCode200Response|GetRulesStatusCode401 of GetRulesStatusCode401Response

