namespace MailBabyFsharpFunctions.Model

open System
open System.Collections.Generic
open Newtonsoft.Json
open MailBabyFsharpFunctions.Model.int option
open MailBabyFsharpFunctions.Model.string option

module MailLogEntry =

  //#region MailLogEntry

  [<CLIMutable>]
  type MailLogEntry = {
    [<JsonProperty(PropertyName = "_id")>]
    Id : int;
    [<JsonProperty(PropertyName = "id")>]
    Id : string;
    [<JsonProperty(PropertyName = "from")>]
    From : string;
    [<JsonProperty(PropertyName = "to")>]
    To : string;
    [<JsonProperty(PropertyName = "created")>]
    Created : string;
    [<JsonProperty(PropertyName = "time")>]
    Time : int;
    [<JsonProperty(PropertyName = "user")>]
    User : string;
    [<JsonProperty(PropertyName = "transtype")>]
    Transtype : string;
    [<JsonProperty(PropertyName = "origin")>]
    Origin : string;
    [<JsonProperty(PropertyName = "interface")>]
    Interface : string;
    [<JsonProperty(PropertyName = "subject")>]
    Subject : string option;
    [<JsonProperty(PropertyName = "messageId")>]
    MessageId : string option;
    [<JsonProperty(PropertyName = "sendingZone")>]
    SendingZone : string option;
    [<JsonProperty(PropertyName = "bodySize")>]
    BodySize : int option;
    [<JsonProperty(PropertyName = "seq")>]
    Seq : int option;
    [<JsonProperty(PropertyName = "delivered")>]
    Delivered : int option;
    [<JsonProperty(PropertyName = "code")>]
    Code : int option;
    [<JsonProperty(PropertyName = "response")>]
    Response : string option;
    [<JsonProperty(PropertyName = "recipient")>]
    Recipient : string option;
    [<JsonProperty(PropertyName = "domain")>]
    Domain : string option;
    [<JsonProperty(PropertyName = "locked")>]
    Locked : int option;
    [<JsonProperty(PropertyName = "lockTime")>]
    LockTime : string option;
    [<JsonProperty(PropertyName = "assigned")>]
    Assigned : string option;
    [<JsonProperty(PropertyName = "queued")>]
    Queued : string option;
    [<JsonProperty(PropertyName = "mxHostname")>]
    MxHostname : string option;
  }

  //#endregion
