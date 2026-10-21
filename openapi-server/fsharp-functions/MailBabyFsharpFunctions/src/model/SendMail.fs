namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json
open MailBabyFsharpFunctions.Model.SendMailTo

module SendMail =

  //#region SendMail

  [<CLIMutable>]
  type SendMail = {
    [<JsonProperty(PropertyName = "to")>]
    To : SendMailTo;
    [<JsonProperty(PropertyName = "from")>]
    From : string;
    [<JsonProperty(PropertyName = "subject")>]
    Subject : string;
    [<JsonProperty(PropertyName = "body")>]
    Body : string;
    [<JsonProperty(PropertyName = "id")>]
    Id : int64;
  }

  //#endregion
