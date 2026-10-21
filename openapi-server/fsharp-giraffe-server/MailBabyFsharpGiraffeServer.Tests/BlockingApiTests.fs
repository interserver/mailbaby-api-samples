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
open BlockingApiHandlerTestsHelper
open MailBabyFsharpGiraffeServer.BlockingApiHandler
open MailBabyFsharpGiraffeServer.BlockingApiHandlerParams
open MailBabyFsharpGiraffeServer.Model.DenyRuleRecord
open MailBabyFsharpGiraffeServer.Model.EmailAddressParam
open MailBabyFsharpGiraffeServer.Model.ErrorMessage
open MailBabyFsharpGiraffeServer.Model.GenericResponse
open MailBabyFsharpGiraffeServer.Model.MailBlocks

module BlockingApiHandlerTests =

  // ---------------------------------
  // Tests
  // ---------------------------------

  [<Fact>]
  let ``AddRule - Create a deny rule to block a sender, domain, destination, or prefix returns 200 where Rule created successfully`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/rules"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/x-www-form-urlencoded", getAddRuleExample "application/x-www-form-urlencoded").Add("application/json", getAddRuleExample "application/json")
      // or pass a formformform
      let body = obj()  |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(200))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``AddRule - Create a deny rule to block a sender, domain, destination, or prefix returns 400 where Bad request — one or more input parameters were missing or invalid.`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/rules"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/x-www-form-urlencoded", getAddRuleExample "application/x-www-form-urlencoded").Add("application/json", getAddRuleExample "application/json")
      // or pass a formformform
      let body = obj()  |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(400))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``AddRule - Create a deny rule to block a sender, domain, destination, or prefix returns 401 where Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/rules"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/x-www-form-urlencoded", getAddRuleExample "application/x-www-form-urlencoded").Add("application/json", getAddRuleExample "application/json")
      // or pass a formformform
      let body = obj()  |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(401))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``AddRule - Create a deny rule to block a sender, domain, destination, or prefix returns 404 where The specified resource was not found or does not belong to your account.`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/rules"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/x-www-form-urlencoded", getAddRuleExample "application/x-www-form-urlencoded").Add("application/json", getAddRuleExample "application/json")
      // or pass a formformform
      let body = obj()  |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(404))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``DeleteRule - Delete a deny rule by its numeric ruleId returns 200 where Rule deleted successfully`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/rules/{ruleId}".Replace("ruleId", "ADDME")

      HttpDelete client path
        |> isStatus (enum<HttpStatusCode>(200))
        |> readText
        |> shouldEqual "TESTME"
        |> ignore
      }

  [<Fact>]
  let ``DeleteRule - Delete a deny rule by its numeric ruleId returns 400 where Bad request — one or more input parameters were missing or invalid.`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/rules/{ruleId}".Replace("ruleId", "ADDME")

      HttpDelete client path
        |> isStatus (enum<HttpStatusCode>(400))
        |> readText
        |> shouldEqual "TESTME"
        |> ignore
      }

  [<Fact>]
  let ``DeleteRule - Delete a deny rule by its numeric ruleId returns 401 where Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/rules/{ruleId}".Replace("ruleId", "ADDME")

      HttpDelete client path
        |> isStatus (enum<HttpStatusCode>(401))
        |> readText
        |> shouldEqual "TESTME"
        |> ignore
      }

  [<Fact>]
  let ``DeleteRule - Delete a deny rule by its numeric ruleId returns 404 where The specified resource was not found or does not belong to your account.`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/rules/{ruleId}".Replace("ruleId", "ADDME")

      HttpDelete client path
        |> isStatus (enum<HttpStatusCode>(404))
        |> readText
        |> shouldEqual "TESTME"
        |> ignore
      }

  [<Fact>]
  let ``DelistBlock - Delist an email address from the spam-filter block lists returns 200 where Address successfully delisted`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/blocks/delete"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/json", getDelistBlockExample "application/json").Add("application/x-www-form-urlencoded", getDelistBlockExample "application/x-www-form-urlencoded")
      // or pass a body of type EmailAddressParam
      let body = obj() :?> EmailAddressParam |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(200))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``DelistBlock - Delist an email address from the spam-filter block lists returns 400 where Bad request — one or more input parameters were missing or invalid.`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/blocks/delete"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/json", getDelistBlockExample "application/json").Add("application/x-www-form-urlencoded", getDelistBlockExample "application/x-www-form-urlencoded")
      // or pass a body of type EmailAddressParam
      let body = obj() :?> EmailAddressParam |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(400))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``DelistBlock - Delist an email address from the spam-filter block lists returns 401 where Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/blocks/delete"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/json", getDelistBlockExample "application/json").Add("application/x-www-form-urlencoded", getDelistBlockExample "application/x-www-form-urlencoded")
      // or pass a body of type EmailAddressParam
      let body = obj() :?> EmailAddressParam |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(401))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``DelistBlock - Delist an email address from the spam-filter block lists returns 404 where The specified resource was not found or does not belong to your account.`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/blocks/delete"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/json", getDelistBlockExample "application/json").Add("application/x-www-form-urlencoded", getDelistBlockExample "application/x-www-form-urlencoded")
      // or pass a body of type EmailAddressParam
      let body = obj() :?> EmailAddressParam |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(404))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``GetMailBlocks - List addresses currently flagged by spam-filter block lists returns 200 where OK`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/blocks"

      HttpGet client path
        |> isStatus (enum<HttpStatusCode>(200))
        |> readText
        |> shouldEqual "TESTME"
        |> ignore
      }

  [<Fact>]
  let ``GetMailBlocks - List addresses currently flagged by spam-filter block lists returns 401 where Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/blocks"

      HttpGet client path
        |> isStatus (enum<HttpStatusCode>(401))
        |> readText
        |> shouldEqual "TESTME"
        |> ignore
      }

  [<Fact>]
  let ``GetRules - List custom deny rules (sender / domain / destination / prefix) returns 200 where OK`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/rules"

      HttpGet client path
        |> isStatus (enum<HttpStatusCode>(200))
        |> readText
        |> shouldEqual "TESTME"
        |> ignore
      }

  [<Fact>]
  let ``GetRules - List custom deny rules (sender / domain / destination / prefix) returns 401 where Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/rules"

      HttpGet client path
        |> isStatus (enum<HttpStatusCode>(401))
        |> readText
        |> shouldEqual "TESTME"
        |> ignore
      }

