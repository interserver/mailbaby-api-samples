namespace MailBabyFsharpGiraffeServer.Model

open System
open System.Collections.Generic
open MailBabyFsharpGiraffeServer.Model.SendMailTo

module SendMail =

  //#region SendMail


  type SendMail = {
    To : SendMailTo;
    From : string;
    Subject : string;
    Body : string;
    Id : int64;
  }
  //#endregion
