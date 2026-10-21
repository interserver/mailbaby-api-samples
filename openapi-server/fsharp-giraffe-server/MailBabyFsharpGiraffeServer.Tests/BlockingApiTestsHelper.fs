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
open MailBabyFsharpGiraffeServer.BlockingApiHandler
open MailBabyFsharpGiraffeServer.BlockingApiHandlerParams

module BlockingApiHandlerTestsHelper =


  let mutable AddRuleExamples = Map.empty
  let mutable AddRuleBody = ""

  let getAddRuleExample mediaType =
    AddRuleExamples.[mediaType]
      |> getConverter mediaType
  ()


  let mutable DelistBlockExamples = Map.empty
  let mutable DelistBlockBody = ""

  DelistBlockBody <- WebUtility.HtmlDecode "{
  &quot;email&quot; : &quot;user@domain.com&quot;
}"
  DelistBlockExamples <- DelistBlockExamples.Add("application/json", DelistBlockBody)

  DelistBlockBody <- WebUtility.HtmlDecode "Custom MIME type example not yet supported: application/x-www-form-urlencoded"
  DelistBlockExamples <- DelistBlockExamples.Add("application/x-www-form-urlencoded", DelistBlockBody)

  let getDelistBlockExample mediaType =
    DelistBlockExamples.[mediaType]
      |> getConverter mediaType
  ()

  ()

