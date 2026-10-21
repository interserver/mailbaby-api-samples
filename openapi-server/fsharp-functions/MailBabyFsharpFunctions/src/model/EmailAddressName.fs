namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json

module EmailAddressName =

  //#region EmailAddressName

  [<CLIMutable>]
  type EmailAddressName = {
    [<JsonProperty(PropertyName = "email")>]
    Email : string;
    [<JsonProperty(PropertyName = "name")>]
    Name : string;
  }

  //#endregion
