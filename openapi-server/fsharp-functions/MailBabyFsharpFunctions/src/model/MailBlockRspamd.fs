namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json

module MailBlockRspamd =

  //#region MailBlockRspamd

  [<CLIMutable>]
  type MailBlockRspamd = {
    [<JsonProperty(PropertyName = "from")>]
    From : string;
    [<JsonProperty(PropertyName = "subject")>]
    Subject : string;
  }

  //#endregion
