namespace MailBabyFsharpGiraffeServer.Model

open System
open System.Collections.Generic

module ErrorMessage =

  //#region ErrorMessage


  type ErrorMessage = {
    Code : int;
    Message : string;
  }
  //#endregion
