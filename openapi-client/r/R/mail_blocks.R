#' Create a new MailBlocks
#'
#' @description
#' The listing of blocked emails.
#'
#' @docType class
#' @title MailBlocks
#' @description MailBlocks Class
#' @format An \code{R6Class} generator object
#' @field local  list(\link{MailBlockClickHouse})
#' @field mbtrap  list(\link{MailBlockClickHouse})
#' @field subject  list(\link{MailBlockRspamd})
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
MailBlocks <- R6::R6Class(
  "MailBlocks",
  public = list(
    `local` = NULL,
    `mbtrap` = NULL,
    `subject` = NULL,
    #' Initialize a new MailBlocks class.
    #'
    #' @description
    #' Initialize a new MailBlocks class.
    #'
    #' @param local local
    #' @param mbtrap mbtrap
    #' @param subject subject
    #' @param ... Other optional arguments.
    #' @export
    initialize = function(`local`, `mbtrap`, `subject`, ...) {
      if (!missing(`local`)) {
        stopifnot(is.vector(`local`), length(`local`) != 0)
        sapply(`local`, function(x) stopifnot(R6::is.R6(x)))
        self$`local` <- `local`
      }
      if (!missing(`mbtrap`)) {
        stopifnot(is.vector(`mbtrap`), length(`mbtrap`) != 0)
        sapply(`mbtrap`, function(x) stopifnot(R6::is.R6(x)))
        self$`mbtrap` <- `mbtrap`
      }
      if (!missing(`subject`)) {
        stopifnot(is.vector(`subject`), length(`subject`) != 0)
        sapply(`subject`, function(x) stopifnot(R6::is.R6(x)))
        self$`subject` <- `subject`
      }
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return MailBlocks in JSON format
    #' @export
    toJSON = function() {
      MailBlocksObject <- list()
      if (!is.null(self$`local`)) {
        MailBlocksObject[["local"]] <-
          lapply(self$`local`, function(x) x$toJSON())
      }
      if (!is.null(self$`mbtrap`)) {
        MailBlocksObject[["mbtrap"]] <-
          lapply(self$`mbtrap`, function(x) x$toJSON())
      }
      if (!is.null(self$`subject`)) {
        MailBlocksObject[["subject"]] <-
          lapply(self$`subject`, function(x) x$toJSON())
      }
      MailBlocksObject
    },
    #' Deserialize JSON string into an instance of MailBlocks
    #'
    #' @description
    #' Deserialize JSON string into an instance of MailBlocks
    #'
    #' @param input_json the JSON input
    #' @return the instance of MailBlocks
    #' @export
    fromJSON = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      if (!is.null(this_object$`local`)) {
        self$`local` <- ApiClient$new()$deserializeObj(this_object$`local`, "array[MailBlockClickHouse]", loadNamespace("openapi"))
      }
      if (!is.null(this_object$`mbtrap`)) {
        self$`mbtrap` <- ApiClient$new()$deserializeObj(this_object$`mbtrap`, "array[MailBlockClickHouse]", loadNamespace("openapi"))
      }
      if (!is.null(this_object$`subject`)) {
        self$`subject` <- ApiClient$new()$deserializeObj(this_object$`subject`, "array[MailBlockRspamd]", loadNamespace("openapi"))
      }
      self
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return MailBlocks in JSON format
    #' @export
    toJSONString = function() {
      jsoncontent <- c(
        if (!is.null(self$`local`)) {
          sprintf(
          '"local":
          [%s]
',
          paste(sapply(self$`local`, function(x) jsonlite::toJSON(x$toJSON(), auto_unbox = TRUE, digits = NA)), collapse = ",")
          )
        },
        if (!is.null(self$`mbtrap`)) {
          sprintf(
          '"mbtrap":
          [%s]
',
          paste(sapply(self$`mbtrap`, function(x) jsonlite::toJSON(x$toJSON(), auto_unbox = TRUE, digits = NA)), collapse = ",")
          )
        },
        if (!is.null(self$`subject`)) {
          sprintf(
          '"subject":
          [%s]
',
          paste(sapply(self$`subject`, function(x) jsonlite::toJSON(x$toJSON(), auto_unbox = TRUE, digits = NA)), collapse = ",")
          )
        }
      )
      jsoncontent <- paste(jsoncontent, collapse = ",")
      json_string <- as.character(jsonlite::minify(paste("{", jsoncontent, "}", sep = "")))
    },
    #' Deserialize JSON string into an instance of MailBlocks
    #'
    #' @description
    #' Deserialize JSON string into an instance of MailBlocks
    #'
    #' @param input_json the JSON input
    #' @return the instance of MailBlocks
    #' @export
    fromJSONString = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      self$`local` <- ApiClient$new()$deserializeObj(this_object$`local`, "array[MailBlockClickHouse]", loadNamespace("openapi"))
      self$`mbtrap` <- ApiClient$new()$deserializeObj(this_object$`mbtrap`, "array[MailBlockClickHouse]", loadNamespace("openapi"))
      self$`subject` <- ApiClient$new()$deserializeObj(this_object$`subject`, "array[MailBlockRspamd]", loadNamespace("openapi"))
      self
    },
    #' Validate JSON input with respect to MailBlocks
    #'
    #' @description
    #' Validate JSON input with respect to MailBlocks and throw an exception if invalid
    #'
    #' @param input the JSON input
    #' @export
    validateJSON = function(input) {
      input_json <- jsonlite::fromJSON(input)
      # check the required field `local`
      if (!is.null(input_json$`local`)) {
        stopifnot(is.vector(input_json$`local`), length(input_json$`local`) != 0)
        tmp <- sapply(input_json$`local`, function(x) stopifnot(R6::is.R6(x)))
      } else {
        stop(paste("The JSON input `", input, "` is invalid for MailBlocks: the required field `local` is missing."))
      }
      # check the required field `mbtrap`
      if (!is.null(input_json$`mbtrap`)) {
        stopifnot(is.vector(input_json$`mbtrap`), length(input_json$`mbtrap`) != 0)
        tmp <- sapply(input_json$`mbtrap`, function(x) stopifnot(R6::is.R6(x)))
      } else {
        stop(paste("The JSON input `", input, "` is invalid for MailBlocks: the required field `mbtrap` is missing."))
      }
      # check the required field `subject`
      if (!is.null(input_json$`subject`)) {
        stopifnot(is.vector(input_json$`subject`), length(input_json$`subject`) != 0)
        tmp <- sapply(input_json$`subject`, function(x) stopifnot(R6::is.R6(x)))
      } else {
        stop(paste("The JSON input `", input, "` is invalid for MailBlocks: the required field `subject` is missing."))
      }
    },
    #' To string (JSON format)
    #'
    #' @description
    #' To string (JSON format)
    #'
    #' @return String representation of MailBlocks
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
      # check if the required `local` is null
      if (is.null(self$`local`)) {
        return(FALSE)
      }

      # check if the required `mbtrap` is null
      if (is.null(self$`mbtrap`)) {
        return(FALSE)
      }

      # check if the required `subject` is null
      if (is.null(self$`subject`)) {
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
      # check if the required `local` is null
      if (is.null(self$`local`)) {
        invalid_fields["local"] <- "Non-nullable required field `local` cannot be null."
      }

      # check if the required `mbtrap` is null
      if (is.null(self$`mbtrap`)) {
        invalid_fields["mbtrap"] <- "Non-nullable required field `mbtrap` cannot be null."
      }

      # check if the required `subject` is null
      if (is.null(self$`subject`)) {
        invalid_fields["subject"] <- "Non-nullable required field `subject` cannot be null."
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
# MailBlocks$unlock()
#
## Below is an example to define the print function
# MailBlocks$set("public", "print", function(...) {
#   print(jsonlite::prettify(self$toJSONString()))
#   invisible(self)
# })
## Uncomment below to lock the class to prevent modifications to the method or field
# MailBlocks$lock()

