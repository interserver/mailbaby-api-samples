namespace MailBabyFsharpFunctions

open MailBabyFsharpFunctions.Model.EmailAddressTypes
open MailBabyFsharpFunctions.Model.EmailAddressesTypes
open MailBabyFsharpFunctions.Model.ErrorMessage
open MailBabyFsharpFunctions.Model.GenericResponse
open MailBabyFsharpFunctions.Model.MailAttachment
open MailBabyFsharpFunctions.Model.SendMailRaw
open MailBabyFsharpFunctions.Model.SendMailTo
open System.Collections.Generic
open System

module SendingApiHandlerParams =


    //#region Body parameters
    [<CLIMutable>]
    type RawMailBodyParams = SendMailRaw
    //#endregion


    type RawMailStatusCode200Response = {
      content:GenericResponse;
      
    }

    type RawMailStatusCode400Response = {
      content:ErrorMessage;
      
    }

    type RawMailStatusCode401Response = {
      content:ErrorMessage;
      
    }

    type RawMailStatusCode404Response = {
      content:ErrorMessage;
      
    }
    type RawMailResult = RawMailStatusCode200 of RawMailStatusCode200Response|RawMailStatusCode400 of RawMailStatusCode400Response|RawMailStatusCode401 of RawMailStatusCode401Response|RawMailStatusCode404 of RawMailStatusCode404Response

    type RawMailArgs = {
      bodyParams:RawMailBodyParams
    }

    //#region Form parameters
    [<CLIMutable>]
    type SendAdvMailFormParams = {
      subject : string ;
    //#endregion

    //#region Form parameters
      body : string ;
    //#endregion

    //#region Form parameters
      from : EmailAddressTypes ;
    //#endregion

    //#region Form parameters
      _to : EmailAddressesTypes ;
    //#endregion

    //#region Form parameters
      replyto : EmailAddressesTypes option;
    //#endregion

    //#region Form parameters
      cc : EmailAddressesTypes option;
    //#endregion

    //#region Form parameters
      bcc : EmailAddressesTypes option;
    //#endregion

    //#region Form parameters
      attachments : MailAttachment[] option;
    //#endregion

    //#region Form parameters
      id : int64 option;
    }
    //#endregion


    type SendAdvMailStatusCode200Response = {
      content:GenericResponse;
      
    }

    type SendAdvMailStatusCode400Response = {
      content:ErrorMessage;
      
    }

    type SendAdvMailStatusCode401Response = {
      content:ErrorMessage;
      
    }

    type SendAdvMailStatusCode404Response = {
      content:ErrorMessage;
      
    }
    type SendAdvMailResult = SendAdvMailStatusCode200 of SendAdvMailStatusCode200Response|SendAdvMailStatusCode400 of SendAdvMailStatusCode400Response|SendAdvMailStatusCode401 of SendAdvMailStatusCode401Response|SendAdvMailStatusCode404 of SendAdvMailStatusCode404Response

    type SendAdvMailArgs = {
      formParams:Result<SendAdvMailFormParams,string>
    }

    //#region Form parameters
    [<CLIMutable>]
    type SendMailFormParams = {
      _to : SendMailTo ;
    //#endregion

    //#region Form parameters
      from : string ;
    //#endregion

    //#region Form parameters
      subject : string ;
    //#endregion

    //#region Form parameters
      body : string ;
    //#endregion

    //#region Form parameters
      id : int64 option;
    }
    //#endregion


    type SendMailStatusCode200Response = {
      content:GenericResponse;
      
    }

    type SendMailStatusCode400Response = {
      content:ErrorMessage;
      
    }

    type SendMailStatusCode401Response = {
      content:ErrorMessage;
      
    }

    type SendMailStatusCode404Response = {
      content:ErrorMessage;
      
    }
    type SendMailResult = SendMailStatusCode200 of SendMailStatusCode200Response|SendMailStatusCode400 of SendMailStatusCode400Response|SendMailStatusCode401 of SendMailStatusCode401Response|SendMailStatusCode404 of SendMailStatusCode404Response

    type SendMailArgs = {
      formParams:Result<SendMailFormParams,string>
    }
