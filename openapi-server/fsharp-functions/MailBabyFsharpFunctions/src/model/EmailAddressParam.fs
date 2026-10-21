namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json

module EmailAddressParam =

  //#region EmailAddressParam

  [<CLIMutable>]
  type EmailAddressParam = {
    [<JsonProperty(PropertyName = "email")>]
    Email : string;
  }

  //#endregion
