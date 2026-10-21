namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json
open MailBabyFsharpFunctions.Model.EmailAddressName

module EmailAddressTypes =

  //#region EmailAddressTypes

  [<CLIMutable>]
  type EmailAddressTypes = {
    [<JsonProperty(PropertyName = "email")>]
    Email : string;
    [<JsonProperty(PropertyName = "name")>]
    Name : string;
  }

  //#endregion
