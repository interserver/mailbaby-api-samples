namespace MailBabyFsharpGiraffeServer.Model

open System
open System.Collections.Generic

module DenyRuleNew =

  //#region DenyRuleNew

  //#region enums
  type TypeEnum = DomainEnum of string  |  EmailEnum of string  |  StartswithEnum of string  |  DestinationEnum of string  |  UnknownDefaultOpenApiEnum of string  
  //#endregion

  type DenyRuleNew = {
    Type : TypeEnum;
    Data : string;
    User : string;
  }
  //#endregion
