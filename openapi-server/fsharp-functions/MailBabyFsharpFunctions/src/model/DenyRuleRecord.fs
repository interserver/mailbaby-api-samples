namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json

module DenyRuleRecord =

  //#region DenyRuleRecord

  [<CLIMutable>]
  type DenyRuleRecord = {
    [<JsonProperty(PropertyName = "type")>]
    Type : string;
    [<JsonProperty(PropertyName = "data")>]
    Data : string;
    [<JsonProperty(PropertyName = "id")>]
    Id : string;
    [<JsonProperty(PropertyName = "created")>]
    Created : DateTime;
    [<JsonProperty(PropertyName = "user")>]
    User : string;
  }

  //#endregion
