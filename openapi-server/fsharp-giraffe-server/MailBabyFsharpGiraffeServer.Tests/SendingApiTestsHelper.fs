namespace MailBabyFsharpGiraffeServer.Tests

open System
open System.Net
open System.Net.Http
open System.IO
open Microsoft.AspNetCore.Builder
open Microsoft.AspNetCore.Hosting
open Microsoft.AspNetCore.TestHost
open Microsoft.Extensions.DependencyInjection
open FSharp.Control.Tasks.V2.ContextInsensitive
open Xunit
open System.Text
open TestHelper
open MailBabyFsharpGiraffeServer.SendingApiHandler
open MailBabyFsharpGiraffeServer.SendingApiHandlerParams

module SendingApiHandlerTestsHelper =


  let mutable RawMailExamples = Map.empty
  let mutable RawMailBody = ""

  RawMailBody <- WebUtility.HtmlDecode "{
  &quot;id&quot; : 39,
  &quot;raw_email&quot; : &quot;Date: Sun, 16 Nov 2025 14:30:11 -0500\nTo: Me &lt;support@interserver.net&gt;\nFrom: Mail Test &lt;support@interserver.net&gt;\nReply-To: Mail Test &lt;support@interserver.net&gt;\nSubject: testing out raw email api call\nMessage-ID: &lt;9jeLkYQIw7KqYnoiCnnYj7EC0IrSHdp8XMuJq9a5qs@interserver.net&gt;\nMIME-Version: 1.0\nContent-Type: text/plain; charset&#x3D;utf-8\nDKIM-Signature: v&#x3D;1; d&#x3D;interserver.net; s&#x3D;my; a&#x3D;rsa-sha256; ...\n\nThis is a test of the rawsend API call.\n&quot;
}"
  RawMailExamples <- RawMailExamples.Add("application/json", RawMailBody)

  RawMailBody <- WebUtility.HtmlDecode "Custom MIME type example not yet supported: multipart/form-data"
  RawMailExamples <- RawMailExamples.Add("multipart/form-data", RawMailBody)

  let getRawMailExample mediaType =
    RawMailExamples.[mediaType]
      |> getConverter mediaType

  let mutable SendAdvMailExamples = Map.empty
  let mutable SendAdvMailBody = ""

  let getSendAdvMailExample mediaType =
    SendAdvMailExamples.[mediaType]
      |> getConverter mediaType

  let mutable SendMailExamples = Map.empty
  let mutable SendMailBody = ""

  let getSendMailExample mediaType =
    SendMailExamples.[mediaType]
      |> getConverter mediaType
