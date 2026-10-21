namespace MailBabyFsharpGiraffeServer.Model

open System
open System.Collections.Generic
open MailBabyFsharpGiraffeServer.Model.MailLogEntry

module MailLog =

  //#region MailLog


  type MailLog = {
    Total : int;
    Skip : int;
    Limit : int;
    Emails : MailLogEntry[];
  }
  //#endregion
