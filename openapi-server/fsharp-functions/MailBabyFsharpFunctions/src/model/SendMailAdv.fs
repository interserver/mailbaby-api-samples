namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json
open MailBabyFsharpFunctions.Model.EmailAddressTypes
open MailBabyFsharpFunctions.Model.EmailAddressesTypes
open MailBabyFsharpFunctions.Model.MailAttachment

module SendMailAdv =

  //#region SendMailAdv

  [<CLIMutable>]
  type SendMailAdv = {
    [<JsonProperty(PropertyName = "subject")>]
    Subject : string;
    [<JsonProperty(PropertyName = "body")>]
    Body : string;
    [<JsonProperty(PropertyName = "from")>]
    From : EmailAddressTypes;
    [<JsonProperty(PropertyName = "to")>]
    To : EmailAddressesTypes;
    [<JsonProperty(PropertyName = "replyto")>]
    Replyto : EmailAddressesTypes;
    [<JsonProperty(PropertyName = "cc")>]
    Cc : EmailAddressesTypes;
    [<JsonProperty(PropertyName = "bcc")>]
    Bcc : EmailAddressesTypes;
    [<JsonProperty(PropertyName = "attachments")>]
    Attachments : MailAttachment[];
    [<JsonProperty(PropertyName = "id")>]
    Id : int64;
  }

  //#endregion
