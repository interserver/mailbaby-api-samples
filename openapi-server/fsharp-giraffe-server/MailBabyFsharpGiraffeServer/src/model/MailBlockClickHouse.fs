namespace MailBabyFsharpGiraffeServer.Model

open System
open System.Collections.Generic
open MailBabyFsharpGiraffeServer.Model.string option

module MailBlockClickHouse =

  //#region MailBlockClickHouse


  type MailBlockClickHouse = {
    Date : DateTime;
    From : string;
    Subject : string;
    To : string;
    MessageId : string option;
  }
  //#endregion
