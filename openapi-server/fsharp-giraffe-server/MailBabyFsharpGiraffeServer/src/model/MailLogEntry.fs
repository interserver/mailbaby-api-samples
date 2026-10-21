namespace MailBabyFsharpGiraffeServer.Model

open System
open System.Collections.Generic
open MailBabyFsharpGiraffeServer.Model.int option
open MailBabyFsharpGiraffeServer.Model.string option

module MailLogEntry =

  //#region MailLogEntry


  type MailLogEntry = {
    Id : int;
    Id : string;
    From : string;
    To : string;
    Created : string;
    Time : int;
    User : string;
    Transtype : string;
    Origin : string;
    Interface : string;
    Subject : string option;
    MessageId : string option;
    SendingZone : string option;
    BodySize : int option;
    Seq : int option;
    Delivered : int option;
    Code : int option;
    Response : string option;
    Recipient : string option;
    Domain : string option;
    Locked : int option;
    LockTime : string option;
    Assigned : string option;
    Queued : string option;
    MxHostname : string option;
  }
  //#endregion
