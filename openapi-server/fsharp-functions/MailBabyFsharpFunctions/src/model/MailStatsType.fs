namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json
open MailBabyFsharpFunctions.Model.MailStatsVolume

module MailStatsType =

  //#region MailStatsType

  [<CLIMutable>]
  type MailStatsType = {
    [<JsonProperty(PropertyName = "time")>]
    Time : string;
    [<JsonProperty(PropertyName = "usage")>]
    Usage : int;
    [<JsonProperty(PropertyName = "currency")>]
    Currency : string;
    [<JsonProperty(PropertyName = "cost")>]
    Cost : double;
    [<JsonProperty(PropertyName = "received")>]
    Received : int;
    [<JsonProperty(PropertyName = "sent")>]
    Sent : int;
    [<JsonProperty(PropertyName = "volume")>]
    Volume : MailStatsVolume;
  }

  //#endregion
