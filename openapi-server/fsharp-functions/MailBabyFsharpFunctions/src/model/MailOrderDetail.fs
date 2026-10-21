namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json

module MailOrderDetail =

  //#region MailOrderDetail

  [<CLIMutable>]
  type MailOrderDetail = {
    [<JsonProperty(PropertyName = "id")>]
    Id : int;
    [<JsonProperty(PropertyName = "status")>]
    Status : string;
    [<JsonProperty(PropertyName = "username")>]
    Username : string;
    [<JsonProperty(PropertyName = "password")>]
    Password : string;
    [<JsonProperty(PropertyName = "comment")>]
    Comment : string;
  }

  //#endregion
