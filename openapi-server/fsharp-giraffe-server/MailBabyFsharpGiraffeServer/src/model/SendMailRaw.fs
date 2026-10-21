namespace MailBabyFsharpGiraffeServer.Model

open System
open System.Collections.Generic

module SendMailRaw =

  //#region SendMailRaw


  type SendMailRaw = {
    RawEmail : string;
    Id : int64;
  }
  //#endregion
