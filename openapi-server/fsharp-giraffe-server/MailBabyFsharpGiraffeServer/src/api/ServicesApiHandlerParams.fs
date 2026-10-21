namespace MailBabyFsharpGiraffeServer

open MailBabyFsharpGiraffeServer.Model.ErrorMessage
open MailBabyFsharpGiraffeServer.Model.MailOrder
open MailBabyFsharpGiraffeServer.Model.MailOrderDetail
open System.Collections.Generic
open System

module ServicesApiHandlerParams =

    //#region Path parameters
    [<CLIMutable>]
    type GetMailOrderByIdPathParams = {
      id : int64 ;
    }
    //#endregion


    type GetMailOrderByIdStatusCode200Response = {
      content:MailOrderDetail;
      
    }

    type GetMailOrderByIdStatusCode400Response = {
      content:ErrorMessage;
      
    }

    type GetMailOrderByIdStatusCode401Response = {
      content:ErrorMessage;
      
    }

    type GetMailOrderByIdStatusCode404Response = {
      content:ErrorMessage;
      
    }
    type GetMailOrderByIdResult = GetMailOrderByIdStatusCode200 of GetMailOrderByIdStatusCode200Response|GetMailOrderByIdStatusCode400 of GetMailOrderByIdStatusCode400Response|GetMailOrderByIdStatusCode401 of GetMailOrderByIdStatusCode401Response|GetMailOrderByIdStatusCode404 of GetMailOrderByIdStatusCode404Response

    type GetMailOrderByIdArgs = {
      pathParams:GetMailOrderByIdPathParams;
    }


    type GetMailOrdersStatusCode200Response = {
      content:MailOrder[];
      
    }

    type GetMailOrdersStatusCode401Response = {
      content:ErrorMessage;
      
    }
    type GetMailOrdersResult = GetMailOrdersStatusCode200 of GetMailOrdersStatusCode200Response|GetMailOrdersStatusCode401 of GetMailOrdersStatusCode401Response

