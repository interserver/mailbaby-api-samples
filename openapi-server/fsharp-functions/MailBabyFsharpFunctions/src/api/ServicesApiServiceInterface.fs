namespace MailBabyFsharpFunctions
open ServicesApiHandlerParams
open System
open Microsoft.AspNetCore.Http


module ServicesApiServiceInterface =

    //#region Service interface
    type IServicesApiService =
      abstract member GetMailOrderById : unit -> GetMailOrderByIdResult
      abstract member GetMailOrders : unit -> GetMailOrdersResult
    //#endregion