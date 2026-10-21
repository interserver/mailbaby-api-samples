namespace MailBabyFsharpGiraffeServer

open System
open System.Net.Http
open System.Security.Claims
open System.Threading
open Microsoft.AspNetCore
open Microsoft.AspNetCore.Builder
open Microsoft.AspNetCore.Hosting
open Microsoft.AspNetCore.Http
open Microsoft.AspNetCore.Http.Features
open Microsoft.AspNetCore.Authentication
open Microsoft.AspNetCore.Authentication.Cookies
open Microsoft.Extensions.Configuration
open Microsoft.Extensions.Logging
open Microsoft.Extensions.DependencyInjection
open FSharp.Control.Tasks.V2.ContextInsensitive
open System.Diagnostics
open Giraffe.GiraffeViewEngine
open AspNet.Security.ApiKey.Providers

open BlockingApiHandlerParams
open HistoryApiHandlerParams
open SendingApiHandlerParams
open ServicesApiHandlerParams
open StatusApiHandlerParams
open Giraffe

module App =

  // ---------------------------------
  // Error handler
  // ---------------------------------

  let errorHandler (ex : Exception) (logger : ILogger) =
    logger.LogError(EventId(), ex, "An unhandled exception has occurred while executing the request.")
    clearResponse >=> setStatusCode 500 >=> text ex.Message

  // ---------------------------------
  // Web app
  // ---------------------------------

  let HttpGet = GET
  let HttpPost = POST
  let HttpPut = PUT
  let HttpDelete = DELETE

  let authFailure : HttpHandler =
    setStatusCode 401 >=> text "You must be authenticated to access this resource."

  let webApp =
    choose (CustomHandlers.handlers @ [
      HttpPost >=> route "/mail/rules" >=> challenge ApiKeyDefaults.AuthenticationScheme >=> requiresAuthentication authFailure >=>  BlockingApiHandler.AddRule;
      HttpDelete >=> routeBind<DeleteRulePathParams> "/mail/rules/{ruleId}"  (fun x -> challenge ApiKeyDefaults.AuthenticationScheme >=> requiresAuthentication authFailure >=>  BlockingApiHandler.DeleteRule x);
      HttpPost >=> route "/mail/blocks/delete" >=> challenge ApiKeyDefaults.AuthenticationScheme >=> requiresAuthentication authFailure >=>  BlockingApiHandler.DelistBlock;
      HttpGet >=> route "/mail/blocks" >=> challenge ApiKeyDefaults.AuthenticationScheme >=> requiresAuthentication authFailure >=>  BlockingApiHandler.GetMailBlocks;
      HttpGet >=> route "/mail/rules" >=> challenge ApiKeyDefaults.AuthenticationScheme >=> requiresAuthentication authFailure >=>  BlockingApiHandler.GetRules;
      HttpGet >=> route "/mail/stats" >=> challenge ApiKeyDefaults.AuthenticationScheme >=> requiresAuthentication authFailure >=>  HistoryApiHandler.GetStats;
      HttpGet >=> route "/mail/log" >=> challenge ApiKeyDefaults.AuthenticationScheme >=> requiresAuthentication authFailure >=>  HistoryApiHandler.ViewMailLog;
      HttpPost >=> route "/mail/rawsend" >=> challenge ApiKeyDefaults.AuthenticationScheme >=> requiresAuthentication authFailure >=>  SendingApiHandler.RawMail;
      HttpPost >=> route "/mail/advsend" >=> challenge ApiKeyDefaults.AuthenticationScheme >=> requiresAuthentication authFailure >=>  SendingApiHandler.SendAdvMail;
      HttpPost >=> route "/mail/send" >=> challenge ApiKeyDefaults.AuthenticationScheme >=> requiresAuthentication authFailure >=>  SendingApiHandler.SendMail;
      HttpGet >=> routeBind<GetMailOrderByIdPathParams> "/mail/{id}"  (fun x -> challenge ApiKeyDefaults.AuthenticationScheme >=> requiresAuthentication authFailure >=>  ServicesApiHandler.GetMailOrderById x);
      HttpGet >=> route "/mail" >=> challenge ApiKeyDefaults.AuthenticationScheme >=> requiresAuthentication authFailure >=>  ServicesApiHandler.GetMailOrders;
      HttpGet >=> route "/ping" >=>  StatusApiHandler.PingServer;
      RequestErrors.notFound (text "Not Found")
    ])
  // ---------------------------------
  // Main
  // ---------------------------------

  let configureApp (app : IApplicationBuilder) =
    app.UseGiraffeErrorHandler(errorHandler)
      .UseStaticFiles()
      .UseAuthentication()
      .UseResponseCaching() |> ignore
    CustomHandlers.configureApp app |> ignore
    app.UseGiraffe webApp |> ignore


  let configureServices (services : IServiceCollection) =
    services
          .AddResponseCaching()
          .AddGiraffe()
          |> AuthSchemes.configureServices
          |> CustomHandlers.configureServices services
          |> ignore
    services.AddDataProtection() |> ignore

  let configureLogging (loggerBuilder : ILoggingBuilder) =
    loggerBuilder.AddFilter(fun lvl -> lvl.Equals LogLevel.Error)
                  .AddConsole()
                  .AddDebug() |> ignore

  [<EntryPoint>]
  let main _ =
    let builder = WebHost.CreateDefaultBuilder()
                    .Configure(Action<IApplicationBuilder> configureApp)
                    .ConfigureServices(configureServices)
                    .ConfigureLogging(configureLogging)
                    |> CustomHandlers.configureWebHost
    builder.Build()
            .Run()
    0