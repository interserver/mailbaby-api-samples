namespace MailBabyFsharpGiraffeServer.Model

open System
open System.Collections.Generic
open MailBabyFsharpGiraffeServer.Model.MailBlockClickHouse
open MailBabyFsharpGiraffeServer.Model.MailBlockRspamd

module MailBlocks =

  //#region MailBlocks


  type MailBlocks = {
    Local : MailBlockClickHouse[];
    Mbtrap : MailBlockClickHouse[];
    Subject : MailBlockRspamd[];
  }
  //#endregion
