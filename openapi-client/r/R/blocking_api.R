#' MailBaby Email Delivery and Management Service API
#'
#' **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
#'
#' The version of the OpenAPI document: 1.1.0
#' Contact: support@interserver.net
#' Generated by: https://openapi-generator.tech
#'
#' @docType class
#' @title Blocking operations
#' @description BlockingApi
#' @format An \code{R6Class} generator object
#' @field api_client Handles the client-server communication.
#'
#' @examples
#' \dontrun{
#' ####################  AddRule  ####################
#'
#' library(openapi)
#' var_type <- "type_example" # character | The type of deny rule.
#' var_data <- "data_example" # character | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
#' var_user <- "user_example" # character | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. (Optional)
#'
#' #Creates a new email deny rule.
#' api_instance <- BlockingApi$new()
#'
#' # Configure API key authorization: apiKeyAuth
#' api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
#'
#' # to save the result into a file, simply add the optional `data_file` parameter, e.g.
#' # result <- api_instance$AddRule(var_type, var_data, user = var_userdata_file = "result.txt")
#' result <- api_instance$AddRule(var_type, var_data, user = var_user)
#' dput(result)
#'
#'
#' ####################  DeleteRule  ####################
#'
#' library(openapi)
#' var_rule_id <- 34 # integer | The ID of the Rules entry.
#'
#' #Removes an deny mail rule.
#' api_instance <- BlockingApi$new()
#'
#' # Configure API key authorization: apiKeyAuth
#' api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
#'
#' # to save the result into a file, simply add the optional `data_file` parameter, e.g.
#' # result <- api_instance$DeleteRule(var_rule_iddata_file = "result.txt")
#' result <- api_instance$DeleteRule(var_rule_id)
#' dput(result)
#'
#'
#' ####################  DelistBlock  ####################
#'
#' library(openapi)
#' var_body <- {"email":"client@domain.com"} # character | 
#'
#' #Removes an email address from the blocked list
#' api_instance <- BlockingApi$new()
#'
#' # Configure API key authorization: apiKeyAuth
#' api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
#'
#' # to save the result into a file, simply add the optional `data_file` parameter, e.g.
#' # result <- api_instance$DelistBlock(var_bodydata_file = "result.txt")
#' result <- api_instance$DelistBlock(var_body)
#' dput(result)
#'
#'
#' ####################  GetMailBlocks  ####################
#'
#' library(openapi)
#'
#' #displays a list of blocked email addresses
#' api_instance <- BlockingApi$new()
#'
#' # Configure API key authorization: apiKeyAuth
#' api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
#'
#' # to save the result into a file, simply add the optional `data_file` parameter, e.g.
#' # result <- api_instance$GetMailBlocks(data_file = "result.txt")
#' result <- api_instance$GetMailBlocks()
#' dput(result)
#'
#'
#' ####################  GetRules  ####################
#'
#' library(openapi)
#'
#' #Displays a listing of deny email rules.
#' api_instance <- BlockingApi$new()
#'
#' # Configure API key authorization: apiKeyAuth
#' api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
#'
#' # to save the result into a file, simply add the optional `data_file` parameter, e.g.
#' # result <- api_instance$GetRules(data_file = "result.txt")
#' result <- api_instance$GetRules()
#' dput(result)
#'
#'
#' }
#' @importFrom R6 R6Class
#' @importFrom base64enc base64encode
#' @export
BlockingApi <- R6::R6Class(
  "BlockingApi",
  public = list(
    api_client = NULL,

    #' @description
    #' Initialize a new BlockingApi.
    #'
    #' @param api_client An instance of API client.
    initialize = function(api_client) {
      if (!missing(api_client)) {
        self$api_client <- api_client
      } else {
        self$api_client <- ApiClient$new()
      }
    },

    #' @description
    #' Creates a new email deny rule.
    #'
    #' @param type The type of deny rule.
    #' @param data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
    #' @param user (optional) Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
    #' @param data_file (optional) name of the data file to save the result
    #' @param ... Other optional arguments
    #'
    #' @return GenericResponse
    AddRule = function(type, data, user = NULL, data_file = NULL, ...) {
      local_var_response <- self$AddRuleWithHttpInfo(type, data, user, data_file = data_file, ...)
      if (local_var_response$status_code >= 200 && local_var_response$status_code <= 299) {
        return(local_var_response$content)
      } else if (local_var_response$status_code >= 300 && local_var_response$status_code <= 399) {
        return(local_var_response)
      } else if (local_var_response$status_code >= 400 && local_var_response$status_code <= 499) {
        return(local_var_response)
      } else if (local_var_response$status_code >= 500 && local_var_response$status_code <= 599) {
        return(local_var_response)
      }
    },

    #' @description
    #' Creates a new email deny rule.
    #'
    #' @param type The type of deny rule.
    #' @param data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
    #' @param user (optional) Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
    #' @param data_file (optional) name of the data file to save the result
    #' @param ... Other optional arguments
    #'
    #' @return API response (GenericResponse) with additional information such as HTTP status code, headers
    AddRuleWithHttpInfo = function(type, data, user = NULL, data_file = NULL, ...) {
      args <- list(...)
      query_params <- list()
      header_params <- c()
      form_params <- list()
      file_params <- list()
      local_var_body <- NULL
      oauth_scopes <- NULL
      is_oauth <- FALSE

      if (missing(`type`)) {
        stop("Missing required parameter `type`.")
      }

      if (missing(`data`)) {
        stop("Missing required parameter `data`.")
      }




      form_params["user"] <- `user`
      form_params["type"] <- `type`
      form_params["data"] <- `data`
      local_var_url_path <- "/mail/rules"
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
          self$api_client$WriteFile(local_var_resp, data_file)
        }

        deserialized_resp_obj <- tryCatch(
          self$api_client$DeserializeResponse(local_var_resp, "GenericResponse"),
          error = function(e) {
            stop("Failed to deserialize response")
          }
        )
        local_var_resp$content <- deserialized_resp_obj
        return(local_var_resp)
      } 
      
      local_var_error_msg <- local_var_resp$response_as_text()      
      if (local_var_resp$status_code >= 300 && local_var_resp$status_code <= 399) {
        ApiResponse$new(paste("Server returned ", local_var_resp$status_code, " response status code."), local_var_resp)
      } else if (local_var_resp$status_code >= 400 && local_var_resp$status_code <= 499) {
        ApiResponse$new("API client error", local_var_resp)
      } else if (local_var_resp$status_code >= 500 && local_var_resp$status_code <= 599) {
        if (is.null(local_var_resp$response) || local_var_resp$response == "") {
          local_var_resp$response <- "API server error"
        }
        return(local_var_resp)
      }
    },

    #' @description
    #' Removes an deny mail rule.
    #'
    #' @param rule_id The ID of the Rules entry.
    #' @param data_file (optional) name of the data file to save the result
    #' @param ... Other optional arguments
    #'
    #' @return GenericResponse
    DeleteRule = function(rule_id, data_file = NULL, ...) {
      local_var_response <- self$DeleteRuleWithHttpInfo(rule_id, data_file = data_file, ...)
      if (local_var_response$status_code >= 200 && local_var_response$status_code <= 299) {
        return(local_var_response$content)
      } else if (local_var_response$status_code >= 300 && local_var_response$status_code <= 399) {
        return(local_var_response)
      } else if (local_var_response$status_code >= 400 && local_var_response$status_code <= 499) {
        return(local_var_response)
      } else if (local_var_response$status_code >= 500 && local_var_response$status_code <= 599) {
        return(local_var_response)
      }
    },

    #' @description
    #' Removes an deny mail rule.
    #'
    #' @param rule_id The ID of the Rules entry.
    #' @param data_file (optional) name of the data file to save the result
    #' @param ... Other optional arguments
    #'
    #' @return API response (GenericResponse) with additional information such as HTTP status code, headers
    DeleteRuleWithHttpInfo = function(rule_id, data_file = NULL, ...) {
      args <- list(...)
      query_params <- list()
      header_params <- c()
      form_params <- list()
      file_params <- list()
      local_var_body <- NULL
      oauth_scopes <- NULL
      is_oauth <- FALSE

      if (missing(`rule_id`)) {
        stop("Missing required parameter `rule_id`.")
      }


      local_var_url_path <- "/mail/rules/{ruleId}"
      if (!missing(`rule_id`)) {
        local_var_url_path <- gsub("\\{ruleId\\}", URLencode(as.character(`rule_id`), reserved = TRUE), local_var_url_path)
      }

      # API key authentication
      if ("X-API-KEY" %in% names(self$api_client$api_keys) && nchar(self$api_client$api_keys["X-API-KEY"]) > 0) {
        header_params["X-API-KEY"] <- paste(unlist(self$api_client$api_keys["X-API-KEY"]), collapse = "")
      }

      # The Accept request HTTP header
      local_var_accepts <- list("application/json")

      # The Content-Type representation header
      local_var_content_types <- list()

      local_var_resp <- self$api_client$CallApi(url = paste0(self$api_client$base_path, local_var_url_path),
                                 method = "DELETE",
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
          self$api_client$WriteFile(local_var_resp, data_file)
        }

        deserialized_resp_obj <- tryCatch(
          self$api_client$DeserializeResponse(local_var_resp, "GenericResponse"),
          error = function(e) {
            stop("Failed to deserialize response")
          }
        )
        local_var_resp$content <- deserialized_resp_obj
        return(local_var_resp)
      } 
      
      local_var_error_msg <- local_var_resp$response_as_text()      
      if (local_var_resp$status_code >= 300 && local_var_resp$status_code <= 399) {
        ApiResponse$new(paste("Server returned ", local_var_resp$status_code, " response status code."), local_var_resp)
      } else if (local_var_resp$status_code >= 400 && local_var_resp$status_code <= 499) {
        ApiResponse$new("API client error", local_var_resp)
      } else if (local_var_resp$status_code >= 500 && local_var_resp$status_code <= 599) {
        if (is.null(local_var_resp$response) || local_var_resp$response == "") {
          local_var_resp$response <- "API server error"
        }
        return(local_var_resp)
      }
    },

    #' @description
    #' Removes an email address from the blocked list
    #'
    #' @param body 
    #' @param data_file (optional) name of the data file to save the result
    #' @param ... Other optional arguments
    #'
    #' @return GenericResponse
    DelistBlock = function(body, data_file = NULL, ...) {
      local_var_response <- self$DelistBlockWithHttpInfo(body, data_file = data_file, ...)
      if (local_var_response$status_code >= 200 && local_var_response$status_code <= 299) {
        return(local_var_response$content)
      } else if (local_var_response$status_code >= 300 && local_var_response$status_code <= 399) {
        return(local_var_response)
      } else if (local_var_response$status_code >= 400 && local_var_response$status_code <= 499) {
        return(local_var_response)
      } else if (local_var_response$status_code >= 500 && local_var_response$status_code <= 599) {
        return(local_var_response)
      }
    },

    #' @description
    #' Removes an email address from the blocked list
    #'
    #' @param body 
    #' @param data_file (optional) name of the data file to save the result
    #' @param ... Other optional arguments
    #'
    #' @return API response (GenericResponse) with additional information such as HTTP status code, headers
    DelistBlockWithHttpInfo = function(body, data_file = NULL, ...) {
      args <- list(...)
      query_params <- list()
      header_params <- c()
      form_params <- list()
      file_params <- list()
      local_var_body <- NULL
      oauth_scopes <- NULL
      is_oauth <- FALSE

      if (missing(`body`)) {
        stop("Missing required parameter `body`.")
      }


      if (!is.null(`body`)) {
        local_var_body <- `body`$toJSONString()
      } else {
        local_var_body <- NULL
      }

      local_var_url_path <- "/mail/blocks/delete"
      # API key authentication
      if ("X-API-KEY" %in% names(self$api_client$api_keys) && nchar(self$api_client$api_keys["X-API-KEY"]) > 0) {
        header_params["X-API-KEY"] <- paste(unlist(self$api_client$api_keys["X-API-KEY"]), collapse = "")
      }

      # The Accept request HTTP header
      local_var_accepts <- list("application/json")

      # The Content-Type representation header
      local_var_content_types <- list("application/json", "multipart/form-data")

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
          self$api_client$WriteFile(local_var_resp, data_file)
        }

        deserialized_resp_obj <- tryCatch(
          self$api_client$DeserializeResponse(local_var_resp, "GenericResponse"),
          error = function(e) {
            stop("Failed to deserialize response")
          }
        )
        local_var_resp$content <- deserialized_resp_obj
        return(local_var_resp)
      } 
      
      local_var_error_msg <- local_var_resp$response_as_text()      
      if (local_var_resp$status_code >= 300 && local_var_resp$status_code <= 399) {
        ApiResponse$new(paste("Server returned ", local_var_resp$status_code, " response status code."), local_var_resp)
      } else if (local_var_resp$status_code >= 400 && local_var_resp$status_code <= 499) {
        ApiResponse$new("API client error", local_var_resp)
      } else if (local_var_resp$status_code >= 500 && local_var_resp$status_code <= 599) {
        if (is.null(local_var_resp$response) || local_var_resp$response == "") {
          local_var_resp$response <- "API server error"
        }
        return(local_var_resp)
      }
    },

    #' @description
    #' displays a list of blocked email addresses
    #'
    #' @param data_file (optional) name of the data file to save the result
    #' @param ... Other optional arguments
    #'
    #' @return MailBlocks
    GetMailBlocks = function(data_file = NULL, ...) {
      local_var_response <- self$GetMailBlocksWithHttpInfo(data_file = data_file, ...)
      if (local_var_response$status_code >= 200 && local_var_response$status_code <= 299) {
        return(local_var_response$content)
      } else if (local_var_response$status_code >= 300 && local_var_response$status_code <= 399) {
        return(local_var_response)
      } else if (local_var_response$status_code >= 400 && local_var_response$status_code <= 499) {
        return(local_var_response)
      } else if (local_var_response$status_code >= 500 && local_var_response$status_code <= 599) {
        return(local_var_response)
      }
    },

    #' @description
    #' displays a list of blocked email addresses
    #'
    #' @param data_file (optional) name of the data file to save the result
    #' @param ... Other optional arguments
    #'
    #' @return API response (MailBlocks) with additional information such as HTTP status code, headers
    GetMailBlocksWithHttpInfo = function(data_file = NULL, ...) {
      args <- list(...)
      query_params <- list()
      header_params <- c()
      form_params <- list()
      file_params <- list()
      local_var_body <- NULL
      oauth_scopes <- NULL
      is_oauth <- FALSE

      local_var_url_path <- "/mail/blocks"
      # API key authentication
      if ("X-API-KEY" %in% names(self$api_client$api_keys) && nchar(self$api_client$api_keys["X-API-KEY"]) > 0) {
        header_params["X-API-KEY"] <- paste(unlist(self$api_client$api_keys["X-API-KEY"]), collapse = "")
      }

      # The Accept request HTTP header
      local_var_accepts <- list("application/json")

      # The Content-Type representation header
      local_var_content_types <- list()

      local_var_resp <- self$api_client$CallApi(url = paste0(self$api_client$base_path, local_var_url_path),
                                 method = "GET",
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
          self$api_client$WriteFile(local_var_resp, data_file)
        }

        deserialized_resp_obj <- tryCatch(
          self$api_client$DeserializeResponse(local_var_resp, "MailBlocks"),
          error = function(e) {
            stop("Failed to deserialize response")
          }
        )
        local_var_resp$content <- deserialized_resp_obj
        return(local_var_resp)
      } 
      
      local_var_error_msg <- local_var_resp$response_as_text()      
      if (local_var_resp$status_code >= 300 && local_var_resp$status_code <= 399) {
        ApiResponse$new(paste("Server returned ", local_var_resp$status_code, " response status code."), local_var_resp)
      } else if (local_var_resp$status_code >= 400 && local_var_resp$status_code <= 499) {
        ApiResponse$new("API client error", local_var_resp)
      } else if (local_var_resp$status_code >= 500 && local_var_resp$status_code <= 599) {
        if (is.null(local_var_resp$response) || local_var_resp$response == "") {
          local_var_resp$response <- "API server error"
        }
        return(local_var_resp)
      }
    },

    #' @description
    #' Displays a listing of deny email rules.
    #'
    #' @param data_file (optional) name of the data file to save the result
    #' @param ... Other optional arguments
    #'
    #' @return array[DenyRuleRecord]
    GetRules = function(data_file = NULL, ...) {
      local_var_response <- self$GetRulesWithHttpInfo(data_file = data_file, ...)
      if (local_var_response$status_code >= 200 && local_var_response$status_code <= 299) {
        return(local_var_response$content)
      } else if (local_var_response$status_code >= 300 && local_var_response$status_code <= 399) {
        return(local_var_response)
      } else if (local_var_response$status_code >= 400 && local_var_response$status_code <= 499) {
        return(local_var_response)
      } else if (local_var_response$status_code >= 500 && local_var_response$status_code <= 599) {
        return(local_var_response)
      }
    },

    #' @description
    #' Displays a listing of deny email rules.
    #'
    #' @param data_file (optional) name of the data file to save the result
    #' @param ... Other optional arguments
    #'
    #' @return API response (array[DenyRuleRecord]) with additional information such as HTTP status code, headers
    GetRulesWithHttpInfo = function(data_file = NULL, ...) {
      args <- list(...)
      query_params <- list()
      header_params <- c()
      form_params <- list()
      file_params <- list()
      local_var_body <- NULL
      oauth_scopes <- NULL
      is_oauth <- FALSE

      local_var_url_path <- "/mail/rules"
      # API key authentication
      if ("X-API-KEY" %in% names(self$api_client$api_keys) && nchar(self$api_client$api_keys["X-API-KEY"]) > 0) {
        header_params["X-API-KEY"] <- paste(unlist(self$api_client$api_keys["X-API-KEY"]), collapse = "")
      }

      # The Accept request HTTP header
      local_var_accepts <- list("application/json")

      # The Content-Type representation header
      local_var_content_types <- list()

      local_var_resp <- self$api_client$CallApi(url = paste0(self$api_client$base_path, local_var_url_path),
                                 method = "GET",
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
          self$api_client$WriteFile(local_var_resp, data_file)
        }

        deserialized_resp_obj <- tryCatch(
          self$api_client$DeserializeResponse(local_var_resp, "array[DenyRuleRecord]"),
          error = function(e) {
            stop("Failed to deserialize response")
          }
        )
        local_var_resp$content <- deserialized_resp_obj
        return(local_var_resp)
      } 
      
      local_var_error_msg <- local_var_resp$response_as_text()      
      if (local_var_resp$status_code >= 300 && local_var_resp$status_code <= 399) {
        ApiResponse$new(paste("Server returned ", local_var_resp$status_code, " response status code."), local_var_resp)
      } else if (local_var_resp$status_code >= 400 && local_var_resp$status_code <= 499) {
        ApiResponse$new("API client error", local_var_resp)
      } else if (local_var_resp$status_code >= 500 && local_var_resp$status_code <= 599) {
        if (is.null(local_var_resp$response) || local_var_resp$response == "") {
          local_var_resp$response <- "API server error"
        }
        return(local_var_resp)
      }
    }
  )
)
