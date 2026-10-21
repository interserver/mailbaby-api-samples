namespace MailBabyFsharpGiraffeServer.Model

open System
open System.Collections.Generic
open MailBabyFsharpGiraffeServer.Model.EmailAddressTypes
open MailBabyFsharpGiraffeServer.Model.EmailAddressesTypes
open MailBabyFsharpGiraffeServer.Model.MailAttachment

module SendMailAdv =

  //#region SendMailAdv


  type SendMailAdv = {
    Subject : string;
    Body : string;
    From : EmailAddressTypes;
    To : EmailAddressesTypes;
    Replyto : EmailAddressesTypes;
    Cc : EmailAddressesTypes;
    Bcc : EmailAddressesTypes;
    Attachments : MailAttachment[];
    Id : int64;
  }
  //#endregion
