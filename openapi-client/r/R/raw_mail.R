#' Create a new RawMail
#'
#' @description
#' Raw Email Object
#'
#' @docType class
#' @title RawMail
#' @description RawMail Class
#' @format An \code{R6Class} generator object
#' @field raw_email The entire email contents character
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
RawMail <- R6::R6Class(
  "RawMail",
  public = list(
    `raw_email` = NULL,

    #' @description
    #' Initialize a new RawMail class.
    #'
    #' @param raw_email The entire email contents
    #' @param ... Other optional arguments.
    initialize = function(`raw_email`, ...) {
      if (!missing(`raw_email`)) {
        if (!(is.character(`raw_email`) && length(`raw_email`) == 1)) {
          stop(paste("Error! Invalid data for `raw_email`. Must be a string:", `raw_email`))
        }
        self$`raw_email` <- `raw_email`
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
    #' @return RawMail as a base R list.
    #' @examples
    #' # convert array of RawMail (x) to a data frame
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
    #' Convert RawMail to a base R type
    #'
    #' @return A base R type, e.g. a list or numeric/character array.
    toSimpleType = function() {
      RawMailObject <- list()
      if (!is.null(self$`raw_email`)) {
        RawMailObject[["raw_email"]] <-
          self$`raw_email`
      }
      return(RawMailObject)
    },

    #' @description
    #' Deserialize JSON string into an instance of RawMail
    #'
    #' @param input_json the JSON input
    #' @return the instance of RawMail
    fromJSON = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      if (!is.null(this_object$`raw_email`)) {
        self$`raw_email` <- this_object$`raw_email`
      }
      self
    },

    #' @description
    #' To JSON String
    #' 
    #' @param ... Parameters passed to `jsonlite::toJSON`
    #' @return RawMail in JSON format
    toJSONString = function(...) {
      simple <- self$toSimpleType()
      json <- jsonlite::toJSON(simple, auto_unbox = TRUE, digits = NA, ...)
      return(as.character(jsonlite::minify(json)))
    },

    #' @description
    #' Deserialize JSON string into an instance of RawMail
    #'
    #' @param input_json the JSON input
    #' @return the instance of RawMail
    fromJSONString = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      self$`raw_email` <- this_object$`raw_email`
      self
    },

    #' @description
    #' Validate JSON input with respect to RawMail and throw an exception if invalid
    #'
    #' @param input the JSON input
    validateJSON = function(input) {
      input_json <- jsonlite::fromJSON(input)
      # check the required field `raw_email`
      if (!is.null(input_json$`raw_email`)) {
        if (!(is.character(input_json$`raw_email`) && length(input_json$`raw_email`) == 1)) {
          stop(paste("Error! Invalid data for `raw_email`. Must be a string:", input_json$`raw_email`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for RawMail: the required field `raw_email` is missing."))
      }
    },

    #' @description
    #' To string (JSON format)
    #'
    #' @return String representation of RawMail
    toString = function() {
      self$toJSONString()
    },

    #' @description
    #' Return true if the values in all fields are valid.
    #'
    #' @return true if the values in all fields are valid.
    isValid = function() {
      # check if the required `raw_email` is null
      if (is.null(self$`raw_email`)) {
        return(FALSE)
      }

      TRUE
    },

    #' @description
    #' Return a list of invalid fields (if any).
    #'
    #' @return A list of invalid fields (if any).
    getInvalidFields = function() {
      invalid_fields <- list()
      # check if the required `raw_email` is null
      if (is.null(self$`raw_email`)) {
        invalid_fields["raw_email"] <- "Non-nullable required field `raw_email` cannot be null."
      }

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
# RawMail$unlock()
#
## Below is an example to define the print function
# RawMail$set("public", "print", function(...) {
#   print(jsonlite::prettify(self$toJSONString()))
#   invisible(self)
# })
## Uncomment below to lock the class to prevent modifications to the method or field
# RawMail$lock()

