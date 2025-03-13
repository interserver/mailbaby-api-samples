#' Create a new SendMailAdv
#'
#' @description
#' Details for an Email
#'
#' @docType class
#' @title SendMailAdv
#' @description SendMailAdv Class
#' @format An \code{R6Class} generator object
#' @field subject The subject or title of the email character
#' @field body The main email contents. character
#' @field from  \link{EmailAddressTypes}
#' @field to  \link{EmailAddressesTypes}
#' @field replyto  \link{EmailAddressesTypes} [optional]
#' @field cc  \link{EmailAddressesTypes} [optional]
#' @field bcc  \link{EmailAddressesTypes} [optional]
#' @field attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded! list(\link{MailAttachment}) [optional]
#' @field id (optional)  ID of the Mail order within our system to use as the Mail Account. integer [optional]
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
    #' @param subject The subject or title of the email
    #' @param body The main email contents.
    #' @param from from
    #' @param to to
    #' @param replyto replyto
    #' @param cc cc
    #' @param bcc bcc
    #' @param attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded!
    #' @param id (optional)  ID of the Mail order within our system to use as the Mail Account.
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
          self$`from`$toSimpleType()
      }
      if (!is.null(self$`to`)) {
        SendMailAdvObject[["to"]] <-
          self$`to`$toSimpleType()
      }
      if (!is.null(self$`replyto`)) {
        SendMailAdvObject[["replyto"]] <-
          self$`replyto`$toSimpleType()
      }
      if (!is.null(self$`cc`)) {
        SendMailAdvObject[["cc"]] <-
          self$`cc`$toSimpleType()
      }
      if (!is.null(self$`bcc`)) {
        SendMailAdvObject[["bcc"]] <-
          self$`bcc`$toSimpleType()
      }
      if (!is.null(self$`attachments`)) {
        SendMailAdvObject[["attachments"]] <-
          lapply(self$`attachments`, function(x) x$toSimpleType())
      }
      if (!is.null(self$`id`)) {
        SendMailAdvObject[["id"]] <-
          self$`id`
      }
      return(SendMailAdvObject)
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

