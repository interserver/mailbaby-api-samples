#' Create a new MailLog
#'
#' @description
#' Mail log records
#'
#' @docType class
#' @title MailLog
#' @description MailLog Class
#' @format An \code{R6Class} generator object
#' @field total total number of mail log entries integer
#' @field skip number of emails skipped in listing integer
#' @field limit number of emails to return integer
#' @field emails  list(\link{MailLogEntry})
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
MailLog <- R6::R6Class(
  "MailLog",
  public = list(
    `total` = NULL,
    `skip` = NULL,
    `limit` = NULL,
    `emails` = NULL,
    #' Initialize a new MailLog class.
    #'
    #' @description
    #' Initialize a new MailLog class.
    #'
    #' @param total total number of mail log entries
    #' @param skip number of emails skipped in listing
    #' @param limit number of emails to return
    #' @param emails emails
    #' @param ... Other optional arguments.
    #' @export
    initialize = function(`total`, `skip`, `limit`, `emails`, ...) {
      if (!missing(`total`)) {
        if (!(is.numeric(`total`) && length(`total`) == 1)) {
          stop(paste("Error! Invalid data for `total`. Must be an integer:", `total`))
        }
        self$`total` <- `total`
      }
      if (!missing(`skip`)) {
        if (!(is.numeric(`skip`) && length(`skip`) == 1)) {
          stop(paste("Error! Invalid data for `skip`. Must be an integer:", `skip`))
        }
        self$`skip` <- `skip`
      }
      if (!missing(`limit`)) {
        if (!(is.numeric(`limit`) && length(`limit`) == 1)) {
          stop(paste("Error! Invalid data for `limit`. Must be an integer:", `limit`))
        }
        self$`limit` <- `limit`
      }
      if (!missing(`emails`)) {
        stopifnot(is.vector(`emails`), length(`emails`) != 0)
        sapply(`emails`, function(x) stopifnot(R6::is.R6(x)))
        self$`emails` <- `emails`
      }
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return MailLog in JSON format
    #' @export
    toJSON = function() {
      MailLogObject <- list()
      if (!is.null(self$`total`)) {
        MailLogObject[["total"]] <-
          self$`total`
      }
      if (!is.null(self$`skip`)) {
        MailLogObject[["skip"]] <-
          self$`skip`
      }
      if (!is.null(self$`limit`)) {
        MailLogObject[["limit"]] <-
          self$`limit`
      }
      if (!is.null(self$`emails`)) {
        MailLogObject[["emails"]] <-
          lapply(self$`emails`, function(x) x$toJSON())
      }
      MailLogObject
    },
    #' Deserialize JSON string into an instance of MailLog
    #'
    #' @description
    #' Deserialize JSON string into an instance of MailLog
    #'
    #' @param input_json the JSON input
    #' @return the instance of MailLog
    #' @export
    fromJSON = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      if (!is.null(this_object$`total`)) {
        self$`total` <- this_object$`total`
      }
      if (!is.null(this_object$`skip`)) {
        self$`skip` <- this_object$`skip`
      }
      if (!is.null(this_object$`limit`)) {
        self$`limit` <- this_object$`limit`
      }
      if (!is.null(this_object$`emails`)) {
        self$`emails` <- ApiClient$new()$deserializeObj(this_object$`emails`, "array[MailLogEntry]", loadNamespace("openapi"))
      }
      self
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return MailLog in JSON format
    #' @export
    toJSONString = function() {
      jsoncontent <- c(
        if (!is.null(self$`total`)) {
          sprintf(
          '"total":
            %d
                    ',
          self$`total`
          )
        },
        if (!is.null(self$`skip`)) {
          sprintf(
          '"skip":
            %d
                    ',
          self$`skip`
          )
        },
        if (!is.null(self$`limit`)) {
          sprintf(
          '"limit":
            %d
                    ',
          self$`limit`
          )
        },
        if (!is.null(self$`emails`)) {
          sprintf(
          '"emails":
          [%s]
',
          paste(sapply(self$`emails`, function(x) jsonlite::toJSON(x$toJSON(), auto_unbox = TRUE, digits = NA)), collapse = ",")
          )
        }
      )
      jsoncontent <- paste(jsoncontent, collapse = ",")
      json_string <- as.character(jsonlite::minify(paste("{", jsoncontent, "}", sep = "")))
    },
    #' Deserialize JSON string into an instance of MailLog
    #'
    #' @description
    #' Deserialize JSON string into an instance of MailLog
    #'
    #' @param input_json the JSON input
    #' @return the instance of MailLog
    #' @export
    fromJSONString = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      self$`total` <- this_object$`total`
      self$`skip` <- this_object$`skip`
      self$`limit` <- this_object$`limit`
      self$`emails` <- ApiClient$new()$deserializeObj(this_object$`emails`, "array[MailLogEntry]", loadNamespace("openapi"))
      self
    },
    #' Validate JSON input with respect to MailLog
    #'
    #' @description
    #' Validate JSON input with respect to MailLog and throw an exception if invalid
    #'
    #' @param input the JSON input
    #' @export
    validateJSON = function(input) {
      input_json <- jsonlite::fromJSON(input)
      # check the required field `total`
      if (!is.null(input_json$`total`)) {
        if (!(is.numeric(input_json$`total`) && length(input_json$`total`) == 1)) {
          stop(paste("Error! Invalid data for `total`. Must be an integer:", input_json$`total`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for MailLog: the required field `total` is missing."))
      }
      # check the required field `skip`
      if (!is.null(input_json$`skip`)) {
        if (!(is.numeric(input_json$`skip`) && length(input_json$`skip`) == 1)) {
          stop(paste("Error! Invalid data for `skip`. Must be an integer:", input_json$`skip`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for MailLog: the required field `skip` is missing."))
      }
      # check the required field `limit`
      if (!is.null(input_json$`limit`)) {
        if (!(is.numeric(input_json$`limit`) && length(input_json$`limit`) == 1)) {
          stop(paste("Error! Invalid data for `limit`. Must be an integer:", input_json$`limit`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for MailLog: the required field `limit` is missing."))
      }
      # check the required field `emails`
      if (!is.null(input_json$`emails`)) {
        stopifnot(is.vector(input_json$`emails`), length(input_json$`emails`) != 0)
        tmp <- sapply(input_json$`emails`, function(x) stopifnot(R6::is.R6(x)))
      } else {
        stop(paste("The JSON input `", input, "` is invalid for MailLog: the required field `emails` is missing."))
      }
    },
    #' To string (JSON format)
    #'
    #' @description
    #' To string (JSON format)
    #'
    #' @return String representation of MailLog
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
      # check if the required `total` is null
      if (is.null(self$`total`)) {
        return(FALSE)
      }

      # check if the required `skip` is null
      if (is.null(self$`skip`)) {
        return(FALSE)
      }

      # check if the required `limit` is null
      if (is.null(self$`limit`)) {
        return(FALSE)
      }

      # check if the required `emails` is null
      if (is.null(self$`emails`)) {
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
      # check if the required `total` is null
      if (is.null(self$`total`)) {
        invalid_fields["total"] <- "Non-nullable required field `total` cannot be null."
      }

      # check if the required `skip` is null
      if (is.null(self$`skip`)) {
        invalid_fields["skip"] <- "Non-nullable required field `skip` cannot be null."
      }

      # check if the required `limit` is null
      if (is.null(self$`limit`)) {
        invalid_fields["limit"] <- "Non-nullable required field `limit` cannot be null."
      }

      # check if the required `emails` is null
      if (is.null(self$`emails`)) {
        invalid_fields["emails"] <- "Non-nullable required field `emails` cannot be null."
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
# MailLog$unlock()
#
## Below is an example to define the print function
# MailLog$set("public", "print", function(...) {
#   print(jsonlite::prettify(self$toJSONString()))
#   invisible(self)
# })
## Uncomment below to lock the class to prevent modifications to the method or field
# MailLog$lock()

