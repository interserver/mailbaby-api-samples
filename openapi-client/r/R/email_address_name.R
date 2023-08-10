#' Create a new EmailAddressName
#'
#' @description
#' An email contact.
#'
#' @docType class
#' @title EmailAddressName
#' @description EmailAddressName Class
#' @format An \code{R6Class} generator object
#' @field email The email address. character
#' @field name Name to use for the sending contact. character [optional]
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
EmailAddressName <- R6::R6Class(
  "EmailAddressName",
  public = list(
    `email` = NULL,
    `name` = NULL,
    #' Initialize a new EmailAddressName class.
    #'
    #' @description
    #' Initialize a new EmailAddressName class.
    #'
    #' @param email The email address.
    #' @param name Name to use for the sending contact.
    #' @param ... Other optional arguments.
    #' @export
    initialize = function(`email`, `name` = NULL, ...) {
      if (!missing(`email`)) {
        if (!(is.character(`email`) && length(`email`) == 1)) {
          stop(paste("Error! Invalid data for `email`. Must be a string:", `email`))
        }
        self$`email` <- `email`
      }
      if (!is.null(`name`)) {
        if (!(is.character(`name`) && length(`name`) == 1)) {
          stop(paste("Error! Invalid data for `name`. Must be a string:", `name`))
        }
        self$`name` <- `name`
      }
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return EmailAddressName in JSON format
    #' @export
    toJSON = function() {
      EmailAddressNameObject <- list()
      if (!is.null(self$`email`)) {
        EmailAddressNameObject[["email"]] <-
          self$`email`
      }
      if (!is.null(self$`name`)) {
        EmailAddressNameObject[["name"]] <-
          self$`name`
      }
      EmailAddressNameObject
    },
    #' Deserialize JSON string into an instance of EmailAddressName
    #'
    #' @description
    #' Deserialize JSON string into an instance of EmailAddressName
    #'
    #' @param input_json the JSON input
    #' @return the instance of EmailAddressName
    #' @export
    fromJSON = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      if (!is.null(this_object$`email`)) {
        self$`email` <- this_object$`email`
      }
      if (!is.null(this_object$`name`)) {
        self$`name` <- this_object$`name`
      }
      self
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return EmailAddressName in JSON format
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
        },
        if (!is.null(self$`name`)) {
          sprintf(
          '"name":
            "%s"
                    ',
          self$`name`
          )
        }
      )
      jsoncontent <- paste(jsoncontent, collapse = ",")
      json_string <- as.character(jsonlite::minify(paste("{", jsoncontent, "}", sep = "")))
    },
    #' Deserialize JSON string into an instance of EmailAddressName
    #'
    #' @description
    #' Deserialize JSON string into an instance of EmailAddressName
    #'
    #' @param input_json the JSON input
    #' @return the instance of EmailAddressName
    #' @export
    fromJSONString = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      self$`email` <- this_object$`email`
      self$`name` <- this_object$`name`
      self
    },
    #' Validate JSON input with respect to EmailAddressName
    #'
    #' @description
    #' Validate JSON input with respect to EmailAddressName and throw an exception if invalid
    #'
    #' @param input the JSON input
    #' @export
    validateJSON = function(input) {
      input_json <- jsonlite::fromJSON(input)
      # check the required field `email`
      if (!is.null(input_json$`email`)) {
        if (!(is.character(input_json$`email`) && length(input_json$`email`) == 1)) {
          stop(paste("Error! Invalid data for `email`. Must be a string:", input_json$`email`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for EmailAddressName: the required field `email` is missing."))
      }
    },
    #' To string (JSON format)
    #'
    #' @description
    #' To string (JSON format)
    #'
    #' @return String representation of EmailAddressName
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
      # check if the required `email` is null
      if (is.null(self$`email`)) {
        return(FALSE)
      }

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
      # check if the required `email` is null
      if (is.null(self$`email`)) {
        invalid_fields["email"] <- "Non-nullable required field `email` cannot be null."
      }

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
# EmailAddressName$unlock()
#
## Below is an example to define the print function
# EmailAddressName$set("public", "print", function(...) {
#   print(jsonlite::prettify(self$toJSONString()))
#   invisible(self)
# })
## Uncomment below to lock the class to prevent modifications to the method or field
# EmailAddressName$lock()

