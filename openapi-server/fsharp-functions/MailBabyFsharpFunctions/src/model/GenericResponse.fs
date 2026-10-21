namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json

module GenericResponse =

  //#region GenericResponse

  [<CLIMutable>]
  type GenericResponse = {
    [<JsonProperty(PropertyName = "status")>]
    Status : string;
    [<JsonProperty(PropertyName = "text")>]
    Text : string;
  }

  //#endregion
