#' MailBaby Email Delivery and Management Service API
#'
#' **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
#'
#' The version of the OpenAPI document: 1.1.0
#' Contact: support@interserver.net
#' Generated by: https://openapi-generator.tech
#'
#' @docType class
#' @title Sending operations
#' @description SendingApi
#' @format An \code{R6Class} generator object
#' @field api_client Handles the client-server communication.
#'
#' @section Methods:
#' \describe{
#' \strong{ SendAdvMail } \emph{ Sends an Email with Advanced Options }
#' Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }' ```
#'
#' \itemize{
#' \item \emph{ @param } subject character
#' \item \emph{ @param } body character
#' \item \emph{ @param } from \link{EmailAddressTypes}
#' \item \emph{ @param } to \link{EmailAddressesTypes}
#' \item \emph{ @param } replyto \link{EmailAddressesTypes}
#' \item \emph{ @param } cc \link{EmailAddressesTypes}
#' \item \emph{ @param } bcc \link{EmailAddressesTypes}
#' \item \emph{ @param } attachments list( \link{MailAttachment} )
#' \item \emph{ @param } id integer
#' \item \emph{ @returnType } \link{GenericResponse} \cr
#'
#'
#' \item status code : 200 | search results matching criteria
#'
#' \item return type : GenericResponse
#' \item response headers :
#'
#' \tabular{ll}{
#' }
#' \item status code : 400 | Error message when there was a problem with the input parameters.
#'
#' \item return type : ErrorMessage
#' \item response headers :
#'
#' \tabular{ll}{
#' }
#' \item status code : 401 | Unauthorized
#'
#' \item return type : ErrorMessage
#' \item response headers :
#'
#' \tabular{ll}{
#' }
#' \item status code : 404 | The specified resource was not found
#'
#' \item return type : ErrorMessage
#' \item response headers :
#'
#' \tabular{ll}{
#' }
#' }
#'
#' \strong{ SendMail } \emph{ Sends an Email }
#' Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead.
#'
#' \itemize{
#' \item \emph{ @param } to character
#' \item \emph{ @param } from character
#' \item \emph{ @param } subject character
#' \item \emph{ @param } body character
#' \item \emph{ @returnType } \link{GenericResponse} \cr
#'
#'
#' \item status code : 200 | search results matching criteria
#'
#' \item return type : GenericResponse
#' \item response headers :
#'
#' \tabular{ll}{
#' }
#' \item status code : 400 | Error message when there was a problem with the input parameters.
#'
#' \item return type : ErrorMessage
#' \item response headers :
#'
#' \tabular{ll}{
#' }
#' \item status code : 401 | Unauthorized
#'
#' \item return type : ErrorMessage
#' \item response headers :
#'
#' \tabular{ll}{
#' }
#' \item status code : 404 | The specified resource was not found
#'
#' \item return type : ErrorMessage
#' \item response headers :
#'
#' \tabular{ll}{
#' }
#' }
#'
#' }
#'
#'
#' @examples
#' \dontrun{
#' ####################  SendAdvMail  ####################
#'
#' library(openapi)
#' var_subject <- "subject_example" # character | The subject or title of the email
#' var_body <- "body_example" # character | The main email contents.
#' var_from <- EmailAddressTypes$new("email_example", "name_example") # EmailAddressTypes | 
#' var_to <- EmailAddressesTypes$new() # EmailAddressesTypes | 
#' var_replyto <- EmailAddressesTypes$new() # EmailAddressesTypes |  (Optional)
#' var_cc <- EmailAddressesTypes$new() # EmailAddressesTypes |  (Optional)
#' var_bcc <- EmailAddressesTypes$new() # EmailAddressesTypes |  (Optional)
#' var_attachments <- c(MailAttachment$new("filename_example", "data_example")) # array[MailAttachment] | (optional) File attachments to include in the email.  The file contents must be base64 encoded! (Optional)
#' var_id <- 56 # integer | (optional)  ID of the Mail order within our system to use as the Mail Account. (Optional)
#'
#' #Sends an Email with Advanced Options
#' api_instance <- SendingApi$new()
#'
#' # Configure API key authorization: apiKeyAuth
#' api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
#'
#' # to save the result into a file, simply add the optional `data_file` parameter, e.g.
#' # result <- api_instance$SendAdvMail(var_subject, var_body, var_from, var_to, replyto = var_replyto, cc = var_cc, bcc = var_bcc, attachments = var_attachments, id = var_iddata_file = "result.txt")
#' result <- api_instance$SendAdvMail(var_subject, var_body, var_from, var_to, replyto = var_replyto, cc = var_cc, bcc = var_bcc, attachments = var_attachments, id = var_id)
#' dput(result)
#'
#'
#' ####################  SendMail  ####################
#'
#' library(openapi)
#' var_to <- "to_example" # character | The Contact whom is the primary recipient of this email.
#' var_from <- "from_example" # character | The contact whom is the this email is from.
#' var_subject <- "subject_example" # character | The subject or title of the email
#' var_body <- "body_example" # character | The main email contents.
#'
#' #Sends an Email
#' api_instance <- SendingApi$new()
#'
#' # Configure API key authorization: apiKeyAuth
#' api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
#'
#' # to save the result into a file, simply add the optional `data_file` parameter, e.g.
#' # result <- api_instance$SendMail(var_to, var_from, var_subject, var_bodydata_file = "result.txt")
#' result <- api_instance$SendMail(var_to, var_from, var_subject, var_body)
#' dput(result)
#'
#'
#' }
#' @importFrom R6 R6Class
#' @importFrom base64enc base64encode
#' @export
SendingApi <- R6::R6Class(
  "SendingApi",
  public = list(
    api_client = NULL,
    #' Initialize a new SendingApi.
    #'
    #' @description
    #' Initialize a new SendingApi.
    #'
    #' @param api_client An instance of API client.
    #' @export
    initialize = function(api_client) {
      if (!missing(api_client)) {
        self$api_client <- api_client
      } else {
        self$api_client <- ApiClient$new()
      }
    },
    #' Sends an Email with Advanced Options
    #'
    #' @description
    #' Sends an Email with Advanced Options
    #'
    #' @param subject The subject or title of the email
    #' @param body The main email contents.
    #' @param from 
    #' @param to 
    #' @param replyto (optional) No description
    #' @param cc (optional) No description
    #' @param bcc (optional) No description
    #' @param attachments (optional) (optional) File attachments to include in the email.  The file contents must be base64 encoded!
    #' @param id (optional) (optional)  ID of the Mail order within our system to use as the Mail Account.
    #' @param data_file (optional) name of the data file to save the result
    #' @param ... Other optional arguments
    #' @return GenericResponse
    #' @export
    SendAdvMail = function(subject, body, from, to, replyto = NULL, cc = NULL, bcc = NULL, attachments = NULL, id = NULL, data_file = NULL, ...) {
      local_var_response <- self$SendAdvMailWithHttpInfo(subject, body, from, to, replyto, cc, bcc, attachments, id, data_file = data_file, ...)
      if (local_var_response$status_code >= 200 && local_var_response$status_code <= 299) {
        local_var_response$content
      } else if (local_var_response$status_code >= 300 && local_var_response$status_code <= 399) {
        local_var_response
      } else if (local_var_response$status_code >= 400 && local_var_response$status_code <= 499) {
        local_var_response
      } else if (local_var_response$status_code >= 500 && local_var_response$status_code <= 599) {
        local_var_response
      }
    },
    #' Sends an Email with Advanced Options
    #'
    #' @description
    #' Sends an Email with Advanced Options
    #'
    #' @param subject The subject or title of the email
    #' @param body The main email contents.
    #' @param from 
    #' @param to 
    #' @param replyto (optional) No description
    #' @param cc (optional) No description
    #' @param bcc (optional) No description
    #' @param attachments (optional) (optional) File attachments to include in the email.  The file contents must be base64 encoded!
    #' @param id (optional) (optional)  ID of the Mail order within our system to use as the Mail Account.
    #' @param data_file (optional) name of the data file to save the result
    #' @param ... Other optional arguments
    #' @return API response (GenericResponse) with additional information such as HTTP status code, headers
    #' @export
    SendAdvMailWithHttpInfo = function(subject, body, from, to, replyto = NULL, cc = NULL, bcc = NULL, attachments = NULL, id = NULL, data_file = NULL, ...) {
      args <- list(...)
      query_params <- list()
      header_params <- c()
      form_params <- list()
      file_params <- list()
      local_var_body <- NULL
      oauth_scopes <- NULL
      is_oauth <- FALSE

      if (missing(`subject`)) {
        stop("Missing required parameter `subject`.")
      }

      if (missing(`body`)) {
        stop("Missing required parameter `body`.")
      }

      if (missing(`from`)) {
        stop("Missing required parameter `from`.")
      }

      if (missing(`to`)) {
        stop("Missing required parameter `to`.")
      }










      form_params["subject"] <- `subject`
      form_params["body"] <- `body`
      form_params["from"] <- `from`
      form_params["to"] <- `to`
      form_params["replyto"] <- `replyto`
      form_params["cc"] <- `cc`
      form_params["bcc"] <- `bcc`
      form_params["attachments"] <- `attachments`
      form_params["id"] <- `id`
      local_var_url_path <- "/mail/advsend"
      # API key authentication
      if ("X-API-KEY" %in% names(self$api_client$api_keys) && nchar(self$api_client$api_keys["X-API-KEY"]) > 0) {
        header_params["X-API-KEY"] <- paste(unlist(self$api_client$api_keys["X-API-KEY"]), collapse = "")
      }

      # The Accept request HTTP header
      local_var_accepts <- list("application/json")

      # The Content-Type representation header
      local_var_content_types <- list("application/x-www-form-urlencoded", "application/json")

      local_var_resp <- self$api_client$CallApi(url = paste0(self$api_client$base_path, local_var_url_path),
                                 method = "POST",
                                 query_params = query_params,
                                 header_params = header_params,
                                 form_params = form_params,
                                 file_params = file_params,
                                 accepts = local_var_accepts,
                                 content_types = local_var_content_types,
                                 body = local_var_body,
                                 is_oauth = is_oauth,
                                 oauth_scopes = oauth_scopes,
                                 ...)

      if (local_var_resp$status_code >= 200 && local_var_resp$status_code <= 299) {
        # save response in a file
        if (!is.null(data_file)) {
          write(local_var_resp$response, data_file)
        }

        deserialized_resp_obj <- tryCatch(
          self$api_client$deserialize(local_var_resp$response, "GenericResponse", loadNamespace("openapi")),
          error = function(e) {
            stop("Failed to deserialize response")
          }
        )
        local_var_resp$content <- deserialized_resp_obj
        local_var_resp
      } else if (local_var_resp$status_code >= 300 && local_var_resp$status_code <= 399) {
        ApiResponse$new(paste("Server returned ", local_var_resp$status_code, " response status code."), local_var_resp)
      } else if (local_var_resp$status_code >= 400 && local_var_resp$status_code <= 499) {
        ApiResponse$new("API client error", local_var_resp)
      } else if (local_var_resp$status_code >= 500 && local_var_resp$status_code <= 599) {
        if (is.null(local_var_resp$response) || local_var_resp$response == "") {
          local_var_resp$response <- "API server error"
        }
        local_var_resp
      }
    },
    #' Sends an Email
    #'
    #' @description
    #' Sends an Email
    #'
    #' @param to The Contact whom is the primary recipient of this email.
    #' @param from The contact whom is the this email is from.
    #' @param subject The subject or title of the email
    #' @param body The main email contents.
    #' @param data_file (optional) name of the data file to save the result
    #' @param ... Other optional arguments
    #' @return GenericResponse
    #' @export
    SendMail = function(to, from, subject, body, data_file = NULL, ...) {
      local_var_response <- self$SendMailWithHttpInfo(to, from, subject, body, data_file = data_file, ...)
      if (local_var_response$status_code >= 200 && local_var_response$status_code <= 299) {
        local_var_response$content
      } else if (local_var_response$status_code >= 300 && local_var_response$status_code <= 399) {
        local_var_response
      } else if (local_var_response$status_code >= 400 && local_var_response$status_code <= 499) {
        local_var_response
      } else if (local_var_response$status_code >= 500 && local_var_response$status_code <= 599) {
        local_var_response
      }
    },
    #' Sends an Email
    #'
    #' @description
    #' Sends an Email
    #'
    #' @param to The Contact whom is the primary recipient of this email.
    #' @param from The contact whom is the this email is from.
    #' @param subject The subject or title of the email
    #' @param body The main email contents.
    #' @param data_file (optional) name of the data file to save the result
    #' @param ... Other optional arguments
    #' @return API response (GenericResponse) with additional information such as HTTP status code, headers
    #' @export
    SendMailWithHttpInfo = function(to, from, subject, body, data_file = NULL, ...) {
      args <- list(...)
      query_params <- list()
      header_params <- c()
      form_params <- list()
      file_params <- list()
      local_var_body <- NULL
      oauth_scopes <- NULL
      is_oauth <- FALSE

      if (missing(`to`)) {
        stop("Missing required parameter `to`.")
      }

      if (missing(`from`)) {
        stop("Missing required parameter `from`.")
      }

      if (missing(`subject`)) {
        stop("Missing required parameter `subject`.")
      }

      if (missing(`body`)) {
        stop("Missing required parameter `body`.")
      }





      form_params["to"] <- `to`
      form_params["from"] <- `from`
      form_params["subject"] <- `subject`
      form_params["body"] <- `body`
      local_var_url_path <- "/mail/send"
      # API key authentication
      if ("X-API-KEY" %in% names(self$api_client$api_keys) && nchar(self$api_client$api_keys["X-API-KEY"]) > 0) {
        header_params["X-API-KEY"] <- paste(unlist(self$api_client$api_keys["X-API-KEY"]), collapse = "")
      }

      # The Accept request HTTP header
      local_var_accepts <- list("application/json")

      # The Content-Type representation header
      local_var_content_types <- list("application/x-www-form-urlencoded", "application/json")

      local_var_resp <- self$api_client$CallApi(url = paste0(self$api_client$base_path, local_var_url_path),
                                 method = "POST",
                                 query_params = query_params,
                                 header_params = header_params,
                                 form_params = form_params,
                                 file_params = file_params,
                                 accepts = local_var_accepts,
                                 content_types = local_var_content_types,
                                 body = local_var_body,
                                 is_oauth = is_oauth,
                                 oauth_scopes = oauth_scopes,
                                 ...)

      if (local_var_resp$status_code >= 200 && local_var_resp$status_code <= 299) {
        # save response in a file
        if (!is.null(data_file)) {
          write(local_var_resp$response, data_file)
        }

        deserialized_resp_obj <- tryCatch(
          self$api_client$deserialize(local_var_resp$response, "GenericResponse", loadNamespace("openapi")),
          error = function(e) {
            stop("Failed to deserialize response")
          }
        )
        local_var_resp$content <- deserialized_resp_obj
        local_var_resp
      } else if (local_var_resp$status_code >= 300 && local_var_resp$status_code <= 399) {
        ApiResponse$new(paste("Server returned ", local_var_resp$status_code, " response status code."), local_var_resp)
      } else if (local_var_resp$status_code >= 400 && local_var_resp$status_code <= 499) {
        ApiResponse$new("API client error", local_var_resp)
      } else if (local_var_resp$status_code >= 500 && local_var_resp$status_code <= 599) {
        if (is.null(local_var_resp$response) || local_var_resp$response == "") {
          local_var_resp$response <- "API server error"
        }
        local_var_resp
      }
    }
  )
)
