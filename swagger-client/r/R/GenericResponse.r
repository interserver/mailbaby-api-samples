# MailBaby Email Delivery and Management Service API
#
# **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
#
# OpenAPI spec version: 1.1.0
# Contact: support@interserver.net
# Generated by: https://github.com/swagger-api/swagger-codegen.git

#' GenericResponse Class
#'
#' @field status 
#' @field text 
#'
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
GenericResponse <- R6::R6Class(
  'GenericResponse',
  public = list(
    `status` = NULL,
    `text` = NULL,
    initialize = function(`status`, `text`){
      if (!missing(`status`)) {
        stopifnot(is.character(`status`), length(`status`) == 1)
        self$`status` <- `status`
      }
      if (!missing(`text`)) {
        stopifnot(is.character(`text`), length(`text`) == 1)
        self$`text` <- `text`
      }
    },
    toJSON = function() {
      GenericResponseObject <- list()
      if (!is.null(self$`status`)) {
        GenericResponseObject[['status']] <- self$`status`
      }
      if (!is.null(self$`text`)) {
        GenericResponseObject[['text']] <- self$`text`
      }

      GenericResponseObject
    },
    fromJSON = function(GenericResponseJson) {
      GenericResponseObject <- jsonlite::fromJSON(GenericResponseJson)
      if (!is.null(GenericResponseObject$`status`)) {
        self$`status` <- GenericResponseObject$`status`
      }
      if (!is.null(GenericResponseObject$`text`)) {
        self$`text` <- GenericResponseObject$`text`
      }
    },
    toJSONString = function() {
       sprintf(
        '{
           "status": %s,
           "text": %s
        }',
        self$`status`,
        self$`text`
      )
    },
    fromJSONString = function(GenericResponseJson) {
      GenericResponseObject <- jsonlite::fromJSON(GenericResponseJson)
      self$`status` <- GenericResponseObject$`status`
      self$`text` <- GenericResponseObject$`text`
    }
  )
)
