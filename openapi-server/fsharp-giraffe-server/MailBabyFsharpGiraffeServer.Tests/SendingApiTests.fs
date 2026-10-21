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
open SendingApiHandlerTestsHelper
open MailBabyFsharpGiraffeServer.SendingApiHandler
open MailBabyFsharpGiraffeServer.SendingApiHandlerParams
open MailBabyFsharpGiraffeServer.Model.EmailAddressTypes
open MailBabyFsharpGiraffeServer.Model.EmailAddressesTypes
open MailBabyFsharpGiraffeServer.Model.ErrorMessage
open MailBabyFsharpGiraffeServer.Model.GenericResponse
open MailBabyFsharpGiraffeServer.Model.MailAttachment
open MailBabyFsharpGiraffeServer.Model.SendMailRaw
open MailBabyFsharpGiraffeServer.Model.SendMailTo

module SendingApiHandlerTests =

  // ---------------------------------
  // Tests
  // ---------------------------------

  [<Fact>]
  let ``RawMail - Send a pre-built RFC 822 message verbatim (preserves DKIM) returns 200 where Email accepted for delivery`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/rawsend"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/json", getRawMailExample "application/json").Add("multipart/form-data", getRawMailExample "multipart/form-data")
      // or pass a body of type SendMailRaw
      let body = obj() :?> SendMailRaw |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(200))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``RawMail - Send a pre-built RFC 822 message verbatim (preserves DKIM) returns 400 where Bad request — one or more input parameters were missing or invalid.`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/rawsend"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/json", getRawMailExample "application/json").Add("multipart/form-data", getRawMailExample "multipart/form-data")
      // or pass a body of type SendMailRaw
      let body = obj() :?> SendMailRaw |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(400))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``RawMail - Send a pre-built RFC 822 message verbatim (preserves DKIM) returns 401 where Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/rawsend"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/json", getRawMailExample "application/json").Add("multipart/form-data", getRawMailExample "multipart/form-data")
      // or pass a body of type SendMailRaw
      let body = obj() :?> SendMailRaw |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(401))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``RawMail - Send a pre-built RFC 822 message verbatim (preserves DKIM) returns 404 where The specified resource was not found or does not belong to your account.`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/rawsend"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/json", getRawMailExample "application/json").Add("multipart/form-data", getRawMailExample "multipart/form-data")
      // or pass a body of type SendMailRaw
      let body = obj() :?> SendMailRaw |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(404))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``SendAdvMail - Send email with multiple recipients, CC/BCC, attachments, named contacts returns 200 where Email accepted for delivery`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/advsend"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/x-www-form-urlencoded", getSendAdvMailExample "application/x-www-form-urlencoded").Add("application/json", getSendAdvMailExample "application/json")
      // or pass a formformformformformformformformform
      let body = obj()  |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(200))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``SendAdvMail - Send email with multiple recipients, CC/BCC, attachments, named contacts returns 400 where Bad request — one or more input parameters were missing or invalid.`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/advsend"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/x-www-form-urlencoded", getSendAdvMailExample "application/x-www-form-urlencoded").Add("application/json", getSendAdvMailExample "application/json")
      // or pass a formformformformformformformformform
      let body = obj()  |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(400))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``SendAdvMail - Send email with multiple recipients, CC/BCC, attachments, named contacts returns 401 where Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/advsend"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/x-www-form-urlencoded", getSendAdvMailExample "application/x-www-form-urlencoded").Add("application/json", getSendAdvMailExample "application/json")
      // or pass a formformformformformformformformform
      let body = obj()  |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(401))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``SendAdvMail - Send email with multiple recipients, CC/BCC, attachments, named contacts returns 404 where The specified resource was not found or does not belong to your account.`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/advsend"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/x-www-form-urlencoded", getSendAdvMailExample "application/x-www-form-urlencoded").Add("application/json", getSendAdvMailExample "application/json")
      // or pass a formformformformformformformformform
      let body = obj()  |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(404))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``SendMail - Send a simple email (single recipient, plain or HTML) returns 200 where Email accepted for delivery`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/send"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/x-www-form-urlencoded", getSendMailExample "application/x-www-form-urlencoded").Add("application/json", getSendMailExample "application/json")
      // or pass a formformformformform
      let body = obj()  |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(200))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``SendMail - Send a simple email (single recipient, plain or HTML) returns 400 where Bad request — one or more input parameters were missing or invalid.`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/send"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/x-www-form-urlencoded", getSendMailExample "application/x-www-form-urlencoded").Add("application/json", getSendMailExample "application/json")
      // or pass a formformformformform
      let body = obj()  |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(400))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``SendMail - Send a simple email (single recipient, plain or HTML) returns 401 where Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/send"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/x-www-form-urlencoded", getSendMailExample "application/x-www-form-urlencoded").Add("application/json", getSendMailExample "application/json")
      // or pass a formformformformform
      let body = obj()  |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(401))
        |> readText
        |> shouldEqual "TESTME"
      }

  [<Fact>]
  let ``SendMail - Send a simple email (single recipient, plain or HTML) returns 404 where The specified resource was not found or does not belong to your account.`` () =
    task {
      use server = new TestServer(createHost())
      use client = server.CreateClient()

      // add your setup code here

      let path = "/mail/send"

      // use an example requestBody provided by the spec
      let examples = Map.empty.Add("application/x-www-form-urlencoded", getSendMailExample "application/x-www-form-urlencoded").Add("application/json", getSendMailExample "application/json")
      // or pass a formformformformform
      let body = obj()  |> Newtonsoft.Json.JsonConvert.SerializeObject |> Encoding.UTF8.GetBytes |> MemoryStream |> StreamContent

      body
        |> HttpPost client path
        |> isStatus (enum<HttpStatusCode>(404))
        |> readText
        |> shouldEqual "TESTME"
      }

