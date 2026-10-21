namespace MailBabyFsharpGiraffeServer.Model

open System
open System.Collections.Generic

module MailOrderDetail =

  //#region MailOrderDetail

  //#region enums
  type StatusEnum = ActiveEnum of string  |  CanceledEnum of string  |  UnknownDefaultOpenApiEnum of string  
  //#endregion

  type MailOrderDetail = {
    Id : int;
    Status : StatusEnum;
    Username : string;
    Password : string;
    Comment : string;
  }
  //#endregion
