namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json
open System.Collections.Generic

module MailStatsVolume =

  //#region MailStatsVolume

  [<CLIMutable>]
  type MailStatsVolume = {
    [<JsonProperty(PropertyName = "to")>]
    To : IDictionary<string, int>;
    [<JsonProperty(PropertyName = "from")>]
    From : IDictionary<string, int>;
    [<JsonProperty(PropertyName = "ip")>]
    Ip : IDictionary<string, int>;
  }

  //#endregion
