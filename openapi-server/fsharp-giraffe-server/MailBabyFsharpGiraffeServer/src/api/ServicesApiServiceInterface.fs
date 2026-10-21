namespace MailBabyFsharpGiraffeServer
open ServicesApiHandlerParams
open System
open Giraffe
open Microsoft.AspNetCore.Http


module ServicesApiServiceInterface =

    //#region Service interface
    type IServicesApiService =
      abstract member GetMailOrderById:HttpContext -> GetMailOrderByIdArgs->GetMailOrderByIdResult
      abstract member GetMailOrders:HttpContext ->GetMailOrdersResult
    //#endregion