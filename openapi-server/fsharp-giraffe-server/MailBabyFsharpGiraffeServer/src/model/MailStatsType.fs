namespace MailBabyFsharpGiraffeServer.Model

open System
open System.Collections.Generic
open MailBabyFsharpGiraffeServer.Model.MailStatsVolume

module MailStatsType =

  //#region MailStatsType

  //#region enums
  type TimeEnum = All of string  |  Billing of string  |  Month of string  |  SevenDays of string  |  TwentyFourHours of string  |  Day of string  |  OneHour of string  |  UnknownDefaultOpenApiEnum of string  
  //#endregion

  type MailStatsType = {
    Time : TimeEnum;
    Usage : int;
    Currency : string;
    Cost : double;
    Received : int;
    Sent : int;
    Volume : MailStatsVolume;
  }
  //#endregion
