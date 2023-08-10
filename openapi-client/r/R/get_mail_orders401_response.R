#' Create a new GetMailOrders401Response
#'
#' @description
#' GetMailOrders401Response Class
#'
#' @docType class
#' @title GetMailOrders401Response
#' @description GetMailOrders401Response Class
#' @format An \code{R6Class} generator object
#' @field code  character
#' @field message  character
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
GetMailOrders401Response <- R6::R6Class(
  "GetMailOrders401Response",
  public = list(
    `code` = NULL,
    `message` = NULL,
    #' Initialize a new GetMailOrders401Response class.
    #'
    #' @description
    #' Initialize a new GetMailOrders401Response class.
    #'
    #' @param code code
    #' @param message message
    #' @param ... Other optional arguments.
    #' @export
    initialize = function(`code`, `message`, ...) {
      if (!missing(`code`)) {
        if (!(is.character(`code`) && length(`code`) == 1)) {
          stop(paste("Error! Invalid data for `code`. Must be a string:", `code`))
        }
        self$`code` <- `code`
      }
      if (!missing(`message`)) {
        if (!(is.character(`message`) && length(`message`) == 1)) {
          stop(paste("Error! Invalid data for `message`. Must be a string:", `message`))
        }
        self$`message` <- `message`
      }
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return GetMailOrders401Response in JSON format
    #' @export
    toJSON = function() {
      GetMailOrders401ResponseObject <- list()
      if (!is.null(self$`code`)) {
        GetMailOrders401ResponseObject[["code"]] <-
          self$`code`
      }
      if (!is.null(self$`message`)) {
        GetMailOrders401ResponseObject[["message"]] <-
          self$`message`
      }
      GetMailOrders401ResponseObject
    },
    #' Deserialize JSON string into an instance of GetMailOrders401Response
    #'
    #' @description
    #' Deserialize JSON string into an instance of GetMailOrders401Response
    #'
    #' @param input_json the JSON input
    #' @return the instance of GetMailOrders401Response
    #' @export
    fromJSON = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      if (!is.null(this_object$`code`)) {
        self$`code` <- this_object$`code`
      }
      if (!is.null(this_object$`message`)) {
        self$`message` <- this_object$`message`
      }
      self
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return GetMailOrders401Response in JSON format
    #' @export
    toJSONString = function() {
      jsoncontent <- c(
        if (!is.null(self$`code`)) {
          sprintf(
          '"code":
            "%s"
                    ',
          self$`code`
          )
        },
        if (!is.null(self$`message`)) {
          sprintf(
          '"message":
            "%s"
                    ',
          self$`message`
          )
        }
      )
      jsoncontent <- paste(jsoncontent, collapse = ",")
      json_string <- as.character(jsonlite::minify(paste("{", jsoncontent, "}", sep = "")))
    },
    #' Deserialize JSON string into an instance of GetMailOrders401Response
    #'
    #' @description
    #' Deserialize JSON string into an instance of GetMailOrders401Response
    #'
    #' @param input_json the JSON input
    #' @return the instance of GetMailOrders401Response
    #' @export
    fromJSONString = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      self$`code` <- this_object$`code`
      self$`message` <- this_object$`message`
      self
    },
    #' Validate JSON input with respect to GetMailOrders401Response
    #'
    #' @description
    #' Validate JSON input with respect to GetMailOrders401Response and throw an exception if invalid
    #'
    #' @param input the JSON input
    #' @export
    validateJSON = function(input) {
      input_json <- jsonlite::fromJSON(input)
      # check the required field `code`
      if (!is.null(input_json$`code`)) {
        if (!(is.character(input_json$`code`) && length(input_json$`code`) == 1)) {
          stop(paste("Error! Invalid data for `code`. Must be a string:", input_json$`code`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for GetMailOrders401Response: the required field `code` is missing."))
      }
      # check the required field `message`
      if (!is.null(input_json$`message`)) {
        if (!(is.character(input_json$`message`) && length(input_json$`message`) == 1)) {
          stop(paste("Error! Invalid data for `message`. Must be a string:", input_json$`message`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for GetMailOrders401Response: the required field `message` is missing."))
      }
    },
    #' To string (JSON format)
    #'
    #' @description
    #' To string (JSON format)
    #'
    #' @return String representation of GetMailOrders401Response
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
      # check if the required `code` is null
      if (is.null(self$`code`)) {
        return(FALSE)
      }

      # check if the required `message` is null
      if (is.null(self$`message`)) {
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
      # check if the required `code` is null
      if (is.null(self$`code`)) {
        invalid_fields["code"] <- "Non-nullable required field `code` cannot be null."
      }

      # check if the required `message` is null
      if (is.null(self$`message`)) {
        invalid_fields["message"] <- "Non-nullable required field `message` cannot be null."
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
# GetMailOrders401Response$unlock()
#
## Below is an example to define the print function
# GetMailOrders401Response$set("public", "print", function(...) {
#   print(jsonlite::prettify(self$toJSONString()))
#   invisible(self)
# })
## Uncomment below to lock the class to prevent modifications to the method or field
# GetMailOrders401Response$lock()

