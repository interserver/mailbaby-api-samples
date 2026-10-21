namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json

module SendMailRaw =

  //#region SendMailRaw

  [<CLIMutable>]
  type SendMailRaw = {
    [<JsonProperty(PropertyName = "raw_email")>]
    RawEmail : string;
    [<JsonProperty(PropertyName = "id")>]
    Id : int64;
  }

  //#endregion
