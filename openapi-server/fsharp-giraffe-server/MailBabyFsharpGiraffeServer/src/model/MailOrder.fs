namespace MailBabyFsharpGiraffeServer.Model

open System
open System.Collections.Generic

module MailOrder =

  //#region MailOrder

  //#region enums
  type StatusEnum = ActiveEnum of string  |  CanceledEnum of string  |  UnknownDefaultOpenApiEnum of string  
  //#endregion

  type MailOrder = {
    Id : int;
    Status : StatusEnum;
    Username : string;
    Comment : string;
  }
  //#endregion
