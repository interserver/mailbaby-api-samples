namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json
open MailBabyFsharpFunctions.Model.MailBlockClickHouse
open MailBabyFsharpFunctions.Model.MailBlockRspamd

module MailBlocks =

  //#region MailBlocks

  [<CLIMutable>]
  type MailBlocks = {
    [<JsonProperty(PropertyName = "local")>]
    Local : MailBlockClickHouse[];
    [<JsonProperty(PropertyName = "mbtrap")>]
    Mbtrap : MailBlockClickHouse[];
    [<JsonProperty(PropertyName = "subject")>]
    Subject : MailBlockRspamd[];
  }

  //#endregion
