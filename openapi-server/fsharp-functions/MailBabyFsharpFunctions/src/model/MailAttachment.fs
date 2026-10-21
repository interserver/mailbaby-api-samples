namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json

module MailAttachment =

  //#region MailAttachment

  [<CLIMutable>]
  type MailAttachment = {
    [<JsonProperty(PropertyName = "filename")>]
    Filename : string;
    [<JsonProperty(PropertyName = "data")>]
    Data : byte[];
  }

  //#endregion
