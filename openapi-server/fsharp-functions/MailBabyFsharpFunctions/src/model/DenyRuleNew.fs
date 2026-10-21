namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json

module DenyRuleNew =

  //#region DenyRuleNew

  [<CLIMutable>]
  type DenyRuleNew = {
    [<JsonProperty(PropertyName = "type")>]
    Type : string;
    [<JsonProperty(PropertyName = "data")>]
    Data : string;
    [<JsonProperty(PropertyName = "user")>]
    User : string;
  }

  //#endregion
