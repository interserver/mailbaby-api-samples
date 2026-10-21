namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json
open MailBabyFsharpFunctions.Model.string option

module MailBlockClickHouse =

  //#region MailBlockClickHouse

  [<CLIMutable>]
  type MailBlockClickHouse = {
    [<JsonProperty(PropertyName = "date")>]
    Date : DateTime;
    [<JsonProperty(PropertyName = "from")>]
    From : string;
    [<JsonProperty(PropertyName = "subject")>]
    Subject : string;
    [<JsonProperty(PropertyName = "to")>]
    To : string;
    [<JsonProperty(PropertyName = "messageId")>]
    MessageId : string option;
  }

  //#endregion
