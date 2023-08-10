#' Create a new EmailAddress
#'
#' @description
#' an email address
#'
#' @docType class
#' @title EmailAddress
#' @description EmailAddress Class
#' @format An \code{R6Class} generator object
#' @field email an email address character [optional]
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
EmailAddress <- R6::R6Class(
  "EmailAddress",
  public = list(
    `email` = NULL,
    #' Initialize a new EmailAddress class.
    #'
    #' @description
    #' Initialize a new EmailAddress class.
    #'
    #' @param email an email address
    #' @param ... Other optional arguments.
    #' @export
    initialize = function(`email` = NULL, ...) {
      if (!is.null(`email`)) {
        if (!(is.character(`email`) && length(`email`) == 1)) {
          stop(paste("Error! Invalid data for `email`. Must be a string:", `email`))
        }
        self$`email` <- `email`
      }
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return EmailAddress in JSON format
    #' @export
    toJSON = function() {
      EmailAddressObject <- list()
      if (!is.null(self$`email`)) {
        EmailAddressObject[["email"]] <-
          self$`email`
      }
      EmailAddressObject
    },
    #' Deserialize JSON string into an instance of EmailAddress
    #'
    #' @description
    #' Deserialize JSON string into an instance of EmailAddress
    #'
    #' @param input_json the JSON input
    #' @return the instance of EmailAddress
    #' @export
    fromJSON = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      if (!is.null(this_object$`email`)) {
        self$`email` <- this_object$`email`
      }
      self
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return EmailAddress in JSON format
    #' @export
    toJSONString = function() {
      jsoncontent <- c(
        if (!is.null(self$`email`)) {
          sprintf(
          '"email":
            "%s"
                    ',
          self$`email`
          )
        }
      )
      jsoncontent <- paste(jsoncontent, collapse = ",")
      json_string <- as.character(jsonlite::minify(paste("{", jsoncontent, "}", sep = "")))
    },
    #' Deserialize JSON string into an instance of EmailAddress
    #'
    #' @description
    #' Deserialize JSON string into an instance of EmailAddress
    #'
    #' @param input_json the JSON input
    #' @return the instance of EmailAddress
    #' @export
    fromJSONString = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      self$`email` <- this_object$`email`
      self
    },
    #' Validate JSON input with respect to EmailAddress
    #'
    #' @description
    #' Validate JSON input with respect to EmailAddress and throw an exception if invalid
    #'
    #' @param input the JSON input
    #' @export
    validateJSON = function(input) {
      input_json <- jsonlite::fromJSON(input)
    },
    #' To string (JSON format)
    #'
    #' @description
    #' To string (JSON format)
    #'
    #' @return String representation of EmailAddress
    #' @export
    toString = function() {
      self$toJSONString()
    },
    #' Return true if the values in all fields are valid.
    #'
    #' @description
    #' Return true if the values in all fields are valid.
    #'
    #' @return true if the values in all fields are valid.
    #' @export
    isValid = function() {
      TRUE
    },
    #' Return a list of invalid fields (if any).
    #'
    #' @description
    #' Return a list of invalid fields (if any).
    #'
    #' @return A list of invalid fields (if any).
    #' @export
    getInvalidFields = function() {
      invalid_fields <- list()
      invalid_fields
    },
    #' Print the object
    #'
    #' @description
    #' Print the object
    #'
    #' @export
    print = function() {
      print(jsonlite::prettify(self$toJSONString()))
      invisible(self)
    }
  ),
  # Lock the class to prevent modifications to the method or field
  lock_class = TRUE
)
## Uncomment below to unlock the class to allow modifications of the method or field
# EmailAddress$unlock()
#
## Below is an example to define the print function
# EmailAddress$set("public", "print", function(...) {
#   print(jsonlite::prettify(self$toJSONString()))
#   invisible(self)
# })
## Uncomment below to lock the class to prevent modifications to the method or field
# EmailAddress$lock()

