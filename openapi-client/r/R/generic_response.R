#' Create a new GenericResponse
#'
#' @description
#' GenericResponse Class
#'
#' @docType class
#' @title GenericResponse
#' @description GenericResponse Class
#' @format An \code{R6Class} generator object
#' @field status  character [optional]
#' @field text  character [optional]
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
GenericResponse <- R6::R6Class(
  "GenericResponse",
  public = list(
    `status` = NULL,
    `text` = NULL,
    #' Initialize a new GenericResponse class.
    #'
    #' @description
    #' Initialize a new GenericResponse class.
    #'
    #' @param status status
    #' @param text text
    #' @param ... Other optional arguments.
    #' @export
    initialize = function(`status` = NULL, `text` = NULL, ...) {
      if (!is.null(`status`)) {
        if (!(is.character(`status`) && length(`status`) == 1)) {
          stop(paste("Error! Invalid data for `status`. Must be a string:", `status`))
        }
        self$`status` <- `status`
      }
      if (!is.null(`text`)) {
        if (!(is.character(`text`) && length(`text`) == 1)) {
          stop(paste("Error! Invalid data for `text`. Must be a string:", `text`))
        }
        self$`text` <- `text`
      }
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return GenericResponse in JSON format
    #' @export
    toJSON = function() {
      GenericResponseObject <- list()
      if (!is.null(self$`status`)) {
        GenericResponseObject[["status"]] <-
          self$`status`
      }
      if (!is.null(self$`text`)) {
        GenericResponseObject[["text"]] <-
          self$`text`
      }
      GenericResponseObject
    },
    #' Deserialize JSON string into an instance of GenericResponse
    #'
    #' @description
    #' Deserialize JSON string into an instance of GenericResponse
    #'
    #' @param input_json the JSON input
    #' @return the instance of GenericResponse
    #' @export
    fromJSON = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      if (!is.null(this_object$`status`)) {
        self$`status` <- this_object$`status`
      }
      if (!is.null(this_object$`text`)) {
        self$`text` <- this_object$`text`
      }
      self
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return GenericResponse in JSON format
    #' @export
    toJSONString = function() {
      jsoncontent <- c(
        if (!is.null(self$`status`)) {
          sprintf(
          '"status":
            "%s"
                    ',
          self$`status`
          )
        },
        if (!is.null(self$`text`)) {
          sprintf(
          '"text":
            "%s"
                    ',
          self$`text`
          )
        }
      )
      jsoncontent <- paste(jsoncontent, collapse = ",")
      json_string <- as.character(jsonlite::minify(paste("{", jsoncontent, "}", sep = "")))
    },
    #' Deserialize JSON string into an instance of GenericResponse
    #'
    #' @description
    #' Deserialize JSON string into an instance of GenericResponse
    #'
    #' @param input_json the JSON input
    #' @return the instance of GenericResponse
    #' @export
    fromJSONString = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      self$`status` <- this_object$`status`
      self$`text` <- this_object$`text`
      self
    },
    #' Validate JSON input with respect to GenericResponse
    #'
    #' @description
    #' Validate JSON input with respect to GenericResponse and throw an exception if invalid
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
    #' @return String representation of GenericResponse
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
# GenericResponse$unlock()
#
## Below is an example to define the print function
# GenericResponse$set("public", "print", function(...) {
#   print(jsonlite::prettify(self$toJSONString()))
#   invisible(self)
# })
## Uncomment below to lock the class to prevent modifications to the method or field
# GenericResponse$lock()

