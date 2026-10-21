namespace MailBabyFsharpGiraffeServer.Model

open System
open System.Collections.Generic

module MailAttachment =

  //#region MailAttachment


  type MailAttachment = {
    Filename : string;
    Data : byte[];
  }
  //#endregion
