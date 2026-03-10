#' Create a new MailStatsVolume
#'
#' @description
#' Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
#'
#' @docType class
#' @title MailStatsVolume
#' @description MailStatsVolume Class
#' @format An \code{R6Class} generator object
#' @field to Message counts keyed by destination (envelope `to`) email address. named list(integer) [optional]
#' @field from Message counts keyed by sender (envelope `from`) email address. named list(integer) [optional]
#' @field ip Message counts keyed by originating client IP address. named list(integer) [optional]
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
MailStatsVolume <- R6::R6Class(
  "MailStatsVolume",
  public = list(
    `to` = NULL,
    `from` = NULL,
    `ip` = NULL,

    #' @description
    #' Initialize a new MailStatsVolume class.
    #'
    #' @param to Message counts keyed by destination (envelope `to`) email address.
    #' @param from Message counts keyed by sender (envelope `from`) email address.
    #' @param ip Message counts keyed by originating client IP address.
    #' @param ... Other optional arguments.
    initialize = function(`to` = NULL, `from` = NULL, `ip` = NULL, ...) {
      if (!is.null(`to`)) {
        stopifnot(is.vector(`to`), length(`to`) != 0)
        sapply(`to`, function(x) stopifnot(is.character(x)))
        self$`to` <- `to`
      }
      if (!is.null(`from`)) {
        stopifnot(is.vector(`from`), length(`from`) != 0)
        sapply(`from`, function(x) stopifnot(is.character(x)))
        self$`from` <- `from`
      }
      if (!is.null(`ip`)) {
        stopifnot(is.vector(`ip`), length(`ip`) != 0)
        sapply(`ip`, function(x) stopifnot(is.character(x)))
        self$`ip` <- `ip`
      }
    },

    #' @description
    #' Convert to an R object. This method is deprecated. Use `toSimpleType()` instead.
    toJSON = function() {
      .Deprecated(new = "toSimpleType", msg = "Use the '$toSimpleType()' method instead since that is more clearly named. Use '$toJSONString()' to get a JSON string")
      return(self$toSimpleType())
    },

    #' @description
    #' Convert to a List
    #'
    #' Convert the R6 object to a list to work more easily with other tooling.
    #'
    #' @return MailStatsVolume as a base R list.
    #' @examples
    #' # convert array of MailStatsVolume (x) to a data frame
    #' \dontrun{
    #' library(purrr)
    #' library(tibble)
    #' df <- x |> map(\(y)y$toList()) |> map(as_tibble) |> list_rbind()
    #' df
    #' }
    toList = function() {
      return(self$toSimpleType())
    },

    #' @description
    #' Convert MailStatsVolume to a base R type
    #'
    #' @return A base R type, e.g. a list or numeric/character array.
    toSimpleType = function() {
      MailStatsVolumeObject <- list()
      if (!is.null(self$`to`)) {
        MailStatsVolumeObject[["to"]] <-
          self$`to`
      }
      if (!is.null(self$`from`)) {
        MailStatsVolumeObject[["from"]] <-
          self$`from`
      }
      if (!is.null(self$`ip`)) {
        MailStatsVolumeObject[["ip"]] <-
          self$`ip`
      }
      return(MailStatsVolumeObject)
    },

    #' @description
    #' Deserialize JSON string into an instance of MailStatsVolume
    #'
    #' @param input_json the JSON input
    #' @return the instance of MailStatsVolume
    fromJSON = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      if (!is.null(this_object$`to`)) {
        self$`to` <- ApiClient$new()$deserializeObj(this_object$`to`, "map(integer)", loadNamespace("openapi"))
      }
      if (!is.null(this_object$`from`)) {
        self$`from` <- ApiClient$new()$deserializeObj(this_object$`from`, "map(integer)", loadNamespace("openapi"))
      }
      if (!is.null(this_object$`ip`)) {
        self$`ip` <- ApiClient$new()$deserializeObj(this_object$`ip`, "map(integer)", loadNamespace("openapi"))
      }
      self
    },

    #' @description
    #' To JSON String
    #' 
    #' @param ... Parameters passed to `jsonlite::toJSON`
    #' @return MailStatsVolume in JSON format
    toJSONString = function(...) {
      simple <- self$toSimpleType()
      json <- jsonlite::toJSON(simple, auto_unbox = TRUE, digits = NA, ...)
      return(as.character(jsonlite::minify(json)))
    },

    #' @description
    #' Deserialize JSON string into an instance of MailStatsVolume
    #'
    #' @param input_json the JSON input
    #' @return the instance of MailStatsVolume
    fromJSONString = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      self$`to` <- ApiClient$new()$deserializeObj(this_object$`to`, "map(integer)", loadNamespace("openapi"))
      self$`from` <- ApiClient$new()$deserializeObj(this_object$`from`, "map(integer)", loadNamespace("openapi"))
      self$`ip` <- ApiClient$new()$deserializeObj(this_object$`ip`, "map(integer)", loadNamespace("openapi"))
      self
    },

    #' @description
    #' Validate JSON input with respect to MailStatsVolume and throw an exception if invalid
    #'
    #' @param input the JSON input
    validateJSON = function(input) {
      input_json <- jsonlite::fromJSON(input)
    },

    #' @description
    #' To string (JSON format)
    #'
    #' @return String representation of MailStatsVolume
    toString = function() {
      self$toJSONString()
    },

    #' @description
    #' Return true if the values in all fields are valid.
    #'
    #' @return true if the values in all fields are valid.
    isValid = function() {
      TRUE
    },

    #' @description
    #' Return a list of invalid fields (if any).
    #'
    #' @return A list of invalid fields (if any).
    getInvalidFields = function() {
      invalid_fields <- list()
      invalid_fields
    },

    #' @description
    #' Print the object
    print = function() {
      print(jsonlite::prettify(self$toJSONString()))
      invisible(self)
    }
  ),
  # Lock the class to prevent modifications to the method or field
  lock_class = TRUE
)
## Uncomment below to unlock the class to allow modifications of the method or field
# MailStatsVolume$unlock()
#
## Below is an example to define the print function
# MailStatsVolume$set("public", "print", function(...) {
#   print(jsonlite::prettify(self$toJSONString()))
#   invisible(self)
# })
## Uncomment below to lock the class to prevent modifications to the method or field
# MailStatsVolume$lock()

