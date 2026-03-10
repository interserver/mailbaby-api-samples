#' Create a new SendMailAdv
#'
#' @description
#' Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.
#'
#' @docType class
#' @title SendMailAdv
#' @description SendMailAdv Class
#' @format An \code{R6Class} generator object
#' @field subject The subject line of the email. character
#' @field body The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. character
#' @field from  \link{EmailAddressTypes}
#' @field to  \link{EmailAddressesTypes}
#' @field replyto  \link{EmailAddressesTypes} [optional]
#' @field cc  \link{EmailAddressesTypes} [optional]
#' @field bcc  \link{EmailAddressesTypes} [optional]
#' @field attachments Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name. list(\link{MailAttachment}) [optional]
#' @field id Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. integer [optional]
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
SendMailAdv <- R6::R6Class(
  "SendMailAdv",
  public = list(
    `subject` = NULL,
    `body` = NULL,
    `from` = NULL,
    `to` = NULL,
    `replyto` = NULL,
    `cc` = NULL,
    `bcc` = NULL,
    `attachments` = NULL,
    `id` = NULL,

    #' @description
    #' Initialize a new SendMailAdv class.
    #'
    #' @param subject The subject line of the email.
    #' @param body The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
    #' @param from from
    #' @param to to
    #' @param replyto replyto
    #' @param cc cc
    #' @param bcc bcc
    #' @param attachments Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
    #' @param id Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
    #' @param ... Other optional arguments.
    initialize = function(`subject`, `body`, `from`, `to`, `replyto` = NULL, `cc` = NULL, `bcc` = NULL, `attachments` = NULL, `id` = NULL, ...) {
      if (!missing(`subject`)) {
        if (!(is.character(`subject`) && length(`subject`) == 1)) {
          stop(paste("Error! Invalid data for `subject`. Must be a string:", `subject`))
        }
        self$`subject` <- `subject`
      }
      if (!missing(`body`)) {
        if (!(is.character(`body`) && length(`body`) == 1)) {
          stop(paste("Error! Invalid data for `body`. Must be a string:", `body`))
        }
        self$`body` <- `body`
      }
      if (!missing(`from`)) {
        stopifnot(R6::is.R6(`from`))
        self$`from` <- `from`
      }
      if (!missing(`to`)) {
        stopifnot(R6::is.R6(`to`))
        self$`to` <- `to`
      }
      if (!is.null(`replyto`)) {
        stopifnot(R6::is.R6(`replyto`))
        self$`replyto` <- `replyto`
      }
      if (!is.null(`cc`)) {
        stopifnot(R6::is.R6(`cc`))
        self$`cc` <- `cc`
      }
      if (!is.null(`bcc`)) {
        stopifnot(R6::is.R6(`bcc`))
        self$`bcc` <- `bcc`
      }
      if (!is.null(`attachments`)) {
        stopifnot(is.vector(`attachments`), length(`attachments`) != 0)
        sapply(`attachments`, function(x) stopifnot(R6::is.R6(x)))
        self$`attachments` <- `attachments`
      }
      if (!is.null(`id`)) {
        if (!(is.numeric(`id`) && length(`id`) == 1)) {
          stop(paste("Error! Invalid data for `id`. Must be an integer:", `id`))
        }
        self$`id` <- `id`
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
    #' @return SendMailAdv as a base R list.
    #' @examples
    #' # convert array of SendMailAdv (x) to a data frame
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
    #' Convert SendMailAdv to a base R type
    #'
    #' @return A base R type, e.g. a list or numeric/character array.
    toSimpleType = function() {
      SendMailAdvObject <- list()
      if (!is.null(self$`subject`)) {
        SendMailAdvObject[["subject"]] <-
          self$`subject`
      }
      if (!is.null(self$`body`)) {
        SendMailAdvObject[["body"]] <-
          self$`body`
      }
      if (!is.null(self$`from`)) {
        SendMailAdvObject[["from"]] <-
          self$extractSimpleType(self$`from`)
      }
      if (!is.null(self$`to`)) {
        SendMailAdvObject[["to"]] <-
          self$extractSimpleType(self$`to`)
      }
      if (!is.null(self$`replyto`)) {
        SendMailAdvObject[["replyto"]] <-
          self$extractSimpleType(self$`replyto`)
      }
      if (!is.null(self$`cc`)) {
        SendMailAdvObject[["cc"]] <-
          self$extractSimpleType(self$`cc`)
      }
      if (!is.null(self$`bcc`)) {
        SendMailAdvObject[["bcc"]] <-
          self$extractSimpleType(self$`bcc`)
      }
      if (!is.null(self$`attachments`)) {
        SendMailAdvObject[["attachments"]] <-
          self$extractSimpleType(self$`attachments`)
      }
      if (!is.null(self$`id`)) {
        SendMailAdvObject[["id"]] <-
          self$`id`
      }
      return(SendMailAdvObject)
    },

    extractSimpleType = function(x) {
      if (R6::is.R6(x)) {
        return(x$toSimpleType())
      } else if (!self$hasNestedR6(x)) {
        return(x)
      }
      lapply(x, self$extractSimpleType)
    },

    hasNestedR6 = function(x) {
      if (R6::is.R6(x)) {
        return(TRUE)
      }
      if (is.list(x)) {
        for (item in x) {
          if (self$hasNestedR6(item)) {
            return(TRUE)
          }
        }
      }
      FALSE
    },

    #' @description
    #' Deserialize JSON string into an instance of SendMailAdv
    #'
    #' @param input_json the JSON input
    #' @return the instance of SendMailAdv
    fromJSON = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      if (!is.null(this_object$`subject`)) {
        self$`subject` <- this_object$`subject`
      }
      if (!is.null(this_object$`body`)) {
        self$`body` <- this_object$`body`
      }
      if (!is.null(this_object$`from`)) {
        `from_object` <- EmailAddressTypes$new()
        `from_object`$fromJSON(jsonlite::toJSON(this_object$`from`, auto_unbox = TRUE, digits = NA))
        self$`from` <- `from_object`
      }
      if (!is.null(this_object$`to`)) {
        `to_object` <- EmailAddressesTypes$new()
        `to_object`$fromJSON(jsonlite::toJSON(this_object$`to`, auto_unbox = TRUE, digits = NA))
        self$`to` <- `to_object`
      }
      if (!is.null(this_object$`replyto`)) {
        `replyto_object` <- EmailAddressesTypes$new()
        `replyto_object`$fromJSON(jsonlite::toJSON(this_object$`replyto`, auto_unbox = TRUE, digits = NA))
        self$`replyto` <- `replyto_object`
      }
      if (!is.null(this_object$`cc`)) {
        `cc_object` <- EmailAddressesTypes$new()
        `cc_object`$fromJSON(jsonlite::toJSON(this_object$`cc`, auto_unbox = TRUE, digits = NA))
        self$`cc` <- `cc_object`
      }
      if (!is.null(this_object$`bcc`)) {
        `bcc_object` <- EmailAddressesTypes$new()
        `bcc_object`$fromJSON(jsonlite::toJSON(this_object$`bcc`, auto_unbox = TRUE, digits = NA))
        self$`bcc` <- `bcc_object`
      }
      if (!is.null(this_object$`attachments`)) {
        self$`attachments` <- ApiClient$new()$deserializeObj(this_object$`attachments`, "array[MailAttachment]", loadNamespace("openapi"))
      }
      if (!is.null(this_object$`id`)) {
        self$`id` <- this_object$`id`
      }
      self
    },

    #' @description
    #' To JSON String
    #' 
    #' @param ... Parameters passed to `jsonlite::toJSON`
    #' @return SendMailAdv in JSON format
    toJSONString = function(...) {
      simple <- self$toSimpleType()
      json <- jsonlite::toJSON(simple, auto_unbox = TRUE, digits = NA, ...)
      return(as.character(jsonlite::minify(json)))
    },

    #' @description
    #' Deserialize JSON string into an instance of SendMailAdv
    #'
    #' @param input_json the JSON input
    #' @return the instance of SendMailAdv
    fromJSONString = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      self$`subject` <- this_object$`subject`
      self$`body` <- this_object$`body`
      self$`from` <- EmailAddressTypes$new()$fromJSON(jsonlite::toJSON(this_object$`from`, auto_unbox = TRUE, digits = NA))
      self$`to` <- EmailAddressesTypes$new()$fromJSON(jsonlite::toJSON(this_object$`to`, auto_unbox = TRUE, digits = NA))
      self$`replyto` <- EmailAddressesTypes$new()$fromJSON(jsonlite::toJSON(this_object$`replyto`, auto_unbox = TRUE, digits = NA))
      self$`cc` <- EmailAddressesTypes$new()$fromJSON(jsonlite::toJSON(this_object$`cc`, auto_unbox = TRUE, digits = NA))
      self$`bcc` <- EmailAddressesTypes$new()$fromJSON(jsonlite::toJSON(this_object$`bcc`, auto_unbox = TRUE, digits = NA))
      self$`attachments` <- ApiClient$new()$deserializeObj(this_object$`attachments`, "array[MailAttachment]", loadNamespace("openapi"))
      self$`id` <- this_object$`id`
      self
    },

    #' @description
    #' Validate JSON input with respect to SendMailAdv and throw an exception if invalid
    #'
    #' @param input the JSON input
    validateJSON = function(input) {
      input_json <- jsonlite::fromJSON(input)
      # check the required field `subject`
      if (!is.null(input_json$`subject`)) {
        if (!(is.character(input_json$`subject`) && length(input_json$`subject`) == 1)) {
          stop(paste("Error! Invalid data for `subject`. Must be a string:", input_json$`subject`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for SendMailAdv: the required field `subject` is missing."))
      }
      # check the required field `body`
      if (!is.null(input_json$`body`)) {
        if (!(is.character(input_json$`body`) && length(input_json$`body`) == 1)) {
          stop(paste("Error! Invalid data for `body`. Must be a string:", input_json$`body`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for SendMailAdv: the required field `body` is missing."))
      }
      # check the required field `from`
      if (!is.null(input_json$`from`)) {
        stopifnot(R6::is.R6(input_json$`from`))
      } else {
        stop(paste("The JSON input `", input, "` is invalid for SendMailAdv: the required field `from` is missing."))
      }
      # check the required field `to`
      if (!is.null(input_json$`to`)) {
        stopifnot(R6::is.R6(input_json$`to`))
      } else {
        stop(paste("The JSON input `", input, "` is invalid for SendMailAdv: the required field `to` is missing."))
      }
    },

    #' @description
    #' To string (JSON format)
    #'
    #' @return String representation of SendMailAdv
    toString = function() {
      self$toJSONString()
    },

    #' @description
    #' Return true if the values in all fields are valid.
    #'
    #' @return true if the values in all fields are valid.
    isValid = function() {
      # check if the required `subject` is null
      if (is.null(self$`subject`)) {
        return(FALSE)
      }

      # check if the required `body` is null
      if (is.null(self$`body`)) {
        return(FALSE)
      }

      # check if the required `from` is null
      if (is.null(self$`from`)) {
        return(FALSE)
      }

      # check if the required `to` is null
      if (is.null(self$`to`)) {
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
      # check if the required `subject` is null
      if (is.null(self$`subject`)) {
        invalid_fields["subject"] <- "Non-nullable required field `subject` cannot be null."
      }

      # check if the required `body` is null
      if (is.null(self$`body`)) {
        invalid_fields["body"] <- "Non-nullable required field `body` cannot be null."
      }

      # check if the required `from` is null
      if (is.null(self$`from`)) {
        invalid_fields["from"] <- "Non-nullable required field `from` cannot be null."
      }

      # check if the required `to` is null
      if (is.null(self$`to`)) {
        invalid_fields["to"] <- "Non-nullable required field `to` cannot be null."
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
# SendMailAdv$unlock()
#
## Below is an example to define the print function
# SendMailAdv$set("public", "print", function(...) {
#   print(jsonlite::prettify(self$toJSONString()))
#   invisible(self)
# })
## Uncomment below to lock the class to prevent modifications to the method or field
# SendMailAdv$lock()

