#' Create a new DenyRuleNew
#'
#' @description
#' The data for a email deny rule record.
#'
#' @docType class
#' @title DenyRuleNew
#' @description DenyRuleNew Class
#' @format An \code{R6Class} generator object
#' @field user Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. character [optional]
#' @field type The type of deny rule. character
#' @field data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. character
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
DenyRuleNew <- R6::R6Class(
  "DenyRuleNew",
  public = list(
    `user` = NULL,
    `type` = NULL,
    `data` = NULL,
    #' Initialize a new DenyRuleNew class.
    #'
    #' @description
    #' Initialize a new DenyRuleNew class.
    #'
    #' @param type The type of deny rule.
    #' @param data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
    #' @param user Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
    #' @param ... Other optional arguments.
    #' @export
    initialize = function(`type`, `data`, `user` = NULL, ...) {
      if (!missing(`type`)) {
        if (!(`type` %in% c("domain", "email", "startswith"))) {
          stop(paste("Error! \"", `type`, "\" cannot be assigned to `type`. Must be \"domain\", \"email\", \"startswith\".", sep = ""))
        }
        if (!(is.character(`type`) && length(`type`) == 1)) {
          stop(paste("Error! Invalid data for `type`. Must be a string:", `type`))
        }
        self$`type` <- `type`
      }
      if (!missing(`data`)) {
        if (!(is.character(`data`) && length(`data`) == 1)) {
          stop(paste("Error! Invalid data for `data`. Must be a string:", `data`))
        }
        self$`data` <- `data`
      }
      if (!is.null(`user`)) {
        if (!(is.character(`user`) && length(`user`) == 1)) {
          stop(paste("Error! Invalid data for `user`. Must be a string:", `user`))
        }
        self$`user` <- `user`
      }
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return DenyRuleNew in JSON format
    #' @export
    toJSON = function() {
      DenyRuleNewObject <- list()
      if (!is.null(self$`user`)) {
        DenyRuleNewObject[["user"]] <-
          self$`user`
      }
      if (!is.null(self$`type`)) {
        DenyRuleNewObject[["type"]] <-
          self$`type`
      }
      if (!is.null(self$`data`)) {
        DenyRuleNewObject[["data"]] <-
          self$`data`
      }
      DenyRuleNewObject
    },
    #' Deserialize JSON string into an instance of DenyRuleNew
    #'
    #' @description
    #' Deserialize JSON string into an instance of DenyRuleNew
    #'
    #' @param input_json the JSON input
    #' @return the instance of DenyRuleNew
    #' @export
    fromJSON = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      if (!is.null(this_object$`user`)) {
        self$`user` <- this_object$`user`
      }
      if (!is.null(this_object$`type`)) {
        if (!is.null(this_object$`type`) && !(this_object$`type` %in% c("domain", "email", "startswith"))) {
          stop(paste("Error! \"", this_object$`type`, "\" cannot be assigned to `type`. Must be \"domain\", \"email\", \"startswith\".", sep = ""))
        }
        self$`type` <- this_object$`type`
      }
      if (!is.null(this_object$`data`)) {
        self$`data` <- this_object$`data`
      }
      self
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return DenyRuleNew in JSON format
    #' @export
    toJSONString = function() {
      jsoncontent <- c(
        if (!is.null(self$`user`)) {
          sprintf(
          '"user":
            "%s"
                    ',
          self$`user`
          )
        },
        if (!is.null(self$`type`)) {
          sprintf(
          '"type":
            "%s"
                    ',
          self$`type`
          )
        },
        if (!is.null(self$`data`)) {
          sprintf(
          '"data":
            "%s"
                    ',
          self$`data`
          )
        }
      )
      jsoncontent <- paste(jsoncontent, collapse = ",")
      json_string <- as.character(jsonlite::minify(paste("{", jsoncontent, "}", sep = "")))
    },
    #' Deserialize JSON string into an instance of DenyRuleNew
    #'
    #' @description
    #' Deserialize JSON string into an instance of DenyRuleNew
    #'
    #' @param input_json the JSON input
    #' @return the instance of DenyRuleNew
    #' @export
    fromJSONString = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      self$`user` <- this_object$`user`
      if (!is.null(this_object$`type`) && !(this_object$`type` %in% c("domain", "email", "startswith"))) {
        stop(paste("Error! \"", this_object$`type`, "\" cannot be assigned to `type`. Must be \"domain\", \"email\", \"startswith\".", sep = ""))
      }
      self$`type` <- this_object$`type`
      self$`data` <- this_object$`data`
      self
    },
    #' Validate JSON input with respect to DenyRuleNew
    #'
    #' @description
    #' Validate JSON input with respect to DenyRuleNew and throw an exception if invalid
    #'
    #' @param input the JSON input
    #' @export
    validateJSON = function(input) {
      input_json <- jsonlite::fromJSON(input)
      # check the required field `type`
      if (!is.null(input_json$`type`)) {
        if (!(is.character(input_json$`type`) && length(input_json$`type`) == 1)) {
          stop(paste("Error! Invalid data for `type`. Must be a string:", input_json$`type`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for DenyRuleNew: the required field `type` is missing."))
      }
      # check the required field `data`
      if (!is.null(input_json$`data`)) {
        if (!(is.character(input_json$`data`) && length(input_json$`data`) == 1)) {
          stop(paste("Error! Invalid data for `data`. Must be a string:", input_json$`data`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for DenyRuleNew: the required field `data` is missing."))
      }
    },
    #' To string (JSON format)
    #'
    #' @description
    #' To string (JSON format)
    #'
    #' @return String representation of DenyRuleNew
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
      # check if the required `type` is null
      if (is.null(self$`type`)) {
        return(FALSE)
      }

      # check if the required `data` is null
      if (is.null(self$`data`)) {
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
      # check if the required `type` is null
      if (is.null(self$`type`)) {
        invalid_fields["type"] <- "Non-nullable required field `type` cannot be null."
      }

      # check if the required `data` is null
      if (is.null(self$`data`)) {
        invalid_fields["data"] <- "Non-nullable required field `data` cannot be null."
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
# DenyRuleNew$unlock()
#
## Below is an example to define the print function
# DenyRuleNew$set("public", "print", function(...) {
#   print(jsonlite::prettify(self$toJSONString()))
#   invisible(self)
# })
## Uncomment below to lock the class to prevent modifications to the method or field
# DenyRuleNew$lock()

