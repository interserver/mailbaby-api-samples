# Mail Baby API
#
# This is an API for accesssing the mail services.
#
# The version of the OpenAPI document: 1.0.0
# Contact: detain@interserver.net
# Generated by: https://openapi-generator.tech

#' @docType class
#' @title GenericResponse
#'
#' @description GenericResponse Class
#'
#' @format An \code{R6Class} generator object
#'
#' @field status  character [optional]
#'
#' @field status_text  character [optional]
#'
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
GenericResponse <- R6::R6Class(
  'GenericResponse',
  public = list(
    `status` = NULL,
    `status_text` = NULL,
    initialize = function(
        `status`=NULL, `status_text`=NULL, ...
    ) {
      local.optional.var <- list(...)
      if (!is.null(`status`)) {
        stopifnot(is.character(`status`), length(`status`) == 1)
        self$`status` <- `status`
      }
      if (!is.null(`status_text`)) {
        stopifnot(is.character(`status_text`), length(`status_text`) == 1)
        self$`status_text` <- `status_text`
      }
    },
    toJSON = function() {
      GenericResponseObject <- list()
      if (!is.null(self$`status`)) {
        GenericResponseObject[['status']] <-
          self$`status`
      }
      if (!is.null(self$`status_text`)) {
        GenericResponseObject[['status_text']] <-
          self$`status_text`
      }

      GenericResponseObject
    },
    fromJSON = function(GenericResponseJson) {
      GenericResponseObject <- jsonlite::fromJSON(GenericResponseJson)
      if (!is.null(GenericResponseObject$`status`)) {
        self$`status` <- GenericResponseObject$`status`
      }
      if (!is.null(GenericResponseObject$`status_text`)) {
        self$`status_text` <- GenericResponseObject$`status_text`
      }
      self
    },
    toJSONString = function() {
      jsoncontent <- c(
        if (!is.null(self$`status`)) {
        sprintf(
        '"status":
          "%s"
                ',
        self$`status`
        )},
        if (!is.null(self$`status_text`)) {
        sprintf(
        '"status_text":
          "%s"
                ',
        self$`status_text`
        )}
      )
      jsoncontent <- paste(jsoncontent, collapse = ",")
      paste('{', jsoncontent, '}', sep = "")
    },
    fromJSONString = function(GenericResponseJson) {
      GenericResponseObject <- jsonlite::fromJSON(GenericResponseJson)
      self$`status` <- GenericResponseObject$`status`
      self$`status_text` <- GenericResponseObject$`status_text`
      self
    }
  )
)
