namespace MailBabyFsharpGiraffeServer.Model

open System
open System.Collections.Generic

module DenyRuleRecord =

  //#region DenyRuleRecord

  //#region enums
  type TypeEnum = DomainEnum of string  |  EmailEnum of string  |  StartswithEnum of string  |  DestinationEnum of string  |  UnknownDefaultOpenApiEnum of string  
  //#endregion

  type DenyRuleRecord = {
    Type : TypeEnum;
    Data : string;
    Id : string;
    Created : DateTime;
    User : string;
  }
  //#endregion
