namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json
open MailBabyFsharpFunctions.Model.MailLogEntry

module MailLog =

  //#region MailLog

  [<CLIMutable>]
  type MailLog = {
    [<JsonProperty(PropertyName = "total")>]
    Total : int;
    [<JsonProperty(PropertyName = "skip")>]
    Skip : int;
    [<JsonProperty(PropertyName = "limit")>]
    Limit : int;
    [<JsonProperty(PropertyName = "emails")>]
    Emails : MailLogEntry[];
  }

  //#endregion
