namespace MailBabyFsharpGiraffeServer.Model

open System
open System.Collections.Generic
open System.Collections.Generic

module MailStatsVolume =

  //#region MailStatsVolume


  type MailStatsVolume = {
    To : IDictionary<string, int>;
    From : IDictionary<string, int>;
    Ip : IDictionary<string, int>;
  }
  //#endregion
