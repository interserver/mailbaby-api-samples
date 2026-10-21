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
open Newtonsoft
open TestHelper
open HistoryApiHandlerTestsHelper
open MailBabyFsharpGiraffeServer.HistoryApiHandler
open MailBabyFsharpGiraffeServer.HistoryApiHandlerParams
open MailBabyFsharpGiraffeServer.Model.DateOrTimestamp
open MailBabyFsharpGiraffeServer.Model.ErrorMessage
open MailBabyFsharpGiraffeServer.Model.MailLog
open MailBabyFsharpGiraffeServer.Model.MailStatsType

module HistoryApiHandlerTests =

  // ---------------------------------
  // Tests
  // ---------------------------------

  [<Fact>]
  let ``GetStats - Account usage, cost, and volume statistics for a time window returns 200 where OK`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/stats" + "?time=ADDME"

      HttpGet client path
        |> isStatus (enum<HttpStatusCode>(200))
        |> readText
        |> shouldEqual "TESTME"
        |> ignore
      }

  [<Fact>]
  let ``GetStats - Account usage, cost, and volume statistics for a time window returns 401 where Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/stats" + "?time=ADDME"

      HttpGet client path
        |> isStatus (enum<HttpStatusCode>(401))
        |> readText
        |> shouldEqual "TESTME"
        |> ignore
      }

  [<Fact>]
  let ``ViewMailLog - Query the mail delivery log (filterable, paginated) returns 200 where Paginated list of mail log entries`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/log" + "?id=ADDME&origin=ADDME&mx=ADDME&from=ADDME&_to=ADDME&subject=ADDME&mailid=ADDME&messageId=ADDME&replyto=ADDME&headerfrom=ADDME&delivered=ADDME&skip=ADDME&limit=ADDME&startDate=ADDME&endDate=ADDME&sort=ADDME&dir=ADDME&groupby=ADDME"

      HttpGet client path
        |> isStatus (enum<HttpStatusCode>(200))
        |> readText
        |> shouldEqual "TESTME"
        |> ignore
      }

  [<Fact>]
  let ``ViewMailLog - Query the mail delivery log (filterable, paginated) returns 400 where Bad request — one or more input parameters were missing or invalid.`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/log" + "?id=ADDME&origin=ADDME&mx=ADDME&from=ADDME&_to=ADDME&subject=ADDME&mailid=ADDME&messageId=ADDME&replyto=ADDME&headerfrom=ADDME&delivered=ADDME&skip=ADDME&limit=ADDME&startDate=ADDME&endDate=ADDME&sort=ADDME&dir=ADDME&groupby=ADDME"

      HttpGet client path
        |> isStatus (enum<HttpStatusCode>(400))
        |> readText
        |> shouldEqual "TESTME"
        |> ignore
      }

  [<Fact>]
  let ``ViewMailLog - Query the mail delivery log (filterable, paginated) returns 401 where Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/log" + "?id=ADDME&origin=ADDME&mx=ADDME&from=ADDME&_to=ADDME&subject=ADDME&mailid=ADDME&messageId=ADDME&replyto=ADDME&headerfrom=ADDME&delivered=ADDME&skip=ADDME&limit=ADDME&startDate=ADDME&endDate=ADDME&sort=ADDME&dir=ADDME&groupby=ADDME"

      HttpGet client path
        |> isStatus (enum<HttpStatusCode>(401))
        |> readText
        |> shouldEqual "TESTME"
        |> ignore
      }

