#' Create a new DenyRuleRecord
#'
#' @description
#' The data for a email deny rule record.
#'
#' @docType class
#' @title DenyRuleRecord
#' @description DenyRuleRecord Class
#' @format An \code{R6Class} generator object
#' @field user Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. character [optional]
#' @field type The type of deny rule. character
#' @field data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. character
#' @field id The deny rule Id number. character
#' @field created the date the rule was created. character
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
DenyRuleRecord <- R6::R6Class(
  "DenyRuleRecord",
  public = list(
    `user` = NULL,
    `type` = NULL,
    `data` = NULL,
    `id` = NULL,
    `created` = NULL,

    #' @description
    #' Initialize a new DenyRuleRecord class.
    #'
    #' @param type The type of deny rule.
    #' @param data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
    #' @param id The deny rule Id number.
    #' @param created the date the rule was created.
    #' @param user Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
    #' @param ... Other optional arguments.
    initialize = function(`type`, `data`, `id`, `created`, `user` = NULL, ...) {
      if (!missing(`type`)) {
        if (!(`type` %in% c("domain", "email", "startswith", "destination"))) {
          stop(paste("Error! \"", `type`, "\" cannot be assigned to `type`. Must be \"domain\", \"email\", \"startswith\", \"destination\".", sep = ""))
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
      if (!missing(`id`)) {
        if (!(is.character(`id`) && length(`id`) == 1)) {
          stop(paste("Error! Invalid data for `id`. Must be a string:", `id`))
        }
        self$`id` <- `id`
      }
      if (!missing(`created`)) {
        if (!(is.character(`created`) && length(`created`) == 1)) {
          stop(paste("Error! Invalid data for `created`. Must be a string:", `created`))
        }
        self$`created` <- `created`
      }
      if (!is.null(`user`)) {
        if (!(is.character(`user`) && length(`user`) == 1)) {
          stop(paste("Error! Invalid data for `user`. Must be a string:", `user`))
        }
        self$`user` <- `user`
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
    #' @return DenyRuleRecord as a base R list.
    #' @examples
    #' # convert array of DenyRuleRecord (x) to a data frame
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
    #' Convert DenyRuleRecord to a base R type
    #'
    #' @return A base R type, e.g. a list or numeric/character array.
    toSimpleType = function() {
      DenyRuleRecordObject <- list()
      if (!is.null(self$`user`)) {
        DenyRuleRecordObject[["user"]] <-
          self$`user`
      }
      if (!is.null(self$`type`)) {
        DenyRuleRecordObject[["type"]] <-
          self$`type`
      }
      if (!is.null(self$`data`)) {
        DenyRuleRecordObject[["data"]] <-
          self$`data`
      }
      if (!is.null(self$`id`)) {
        DenyRuleRecordObject[["id"]] <-
          self$`id`
      }
      if (!is.null(self$`created`)) {
        DenyRuleRecordObject[["created"]] <-
          self$`created`
      }
      return(DenyRuleRecordObject)
    },

    #' @description
    #' Deserialize JSON string into an instance of DenyRuleRecord
    #'
    #' @param input_json the JSON input
    #' @return the instance of DenyRuleRecord
    fromJSON = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      if (!is.null(this_object$`user`)) {
        self$`user` <- this_object$`user`
      }
      if (!is.null(this_object$`type`)) {
        if (!is.null(this_object$`type`) && !(this_object$`type` %in% c("domain", "email", "startswith", "destination"))) {
          stop(paste("Error! \"", this_object$`type`, "\" cannot be assigned to `type`. Must be \"domain\", \"email\", \"startswith\", \"destination\".", sep = ""))
        }
        self$`type` <- this_object$`type`
      }
      if (!is.null(this_object$`data`)) {
        self$`data` <- this_object$`data`
      }
      if (!is.null(this_object$`id`)) {
        self$`id` <- this_object$`id`
      }
      if (!is.null(this_object$`created`)) {
        self$`created` <- this_object$`created`
      }
      self
    },

    #' @description
    #' To JSON String
    #' 
    #' @param ... Parameters passed to `jsonlite::toJSON`
    #' @return DenyRuleRecord in JSON format
    toJSONString = function(...) {
      simple <- self$toSimpleType()
      json <- jsonlite::toJSON(simple, auto_unbox = TRUE, digits = NA, ...)
      return(as.character(jsonlite::minify(json)))
    },

    #' @description
    #' Deserialize JSON string into an instance of DenyRuleRecord
    #'
    #' @param input_json the JSON input
    #' @return the instance of DenyRuleRecord
    fromJSONString = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      self$`user` <- this_object$`user`
      if (!is.null(this_object$`type`) && !(this_object$`type` %in% c("domain", "email", "startswith", "destination"))) {
        stop(paste("Error! \"", this_object$`type`, "\" cannot be assigned to `type`. Must be \"domain\", \"email\", \"startswith\", \"destination\".", sep = ""))
      }
      self$`type` <- this_object$`type`
      self$`data` <- this_object$`data`
      self$`id` <- this_object$`id`
      self$`created` <- this_object$`created`
      self
    },

    #' @description
    #' Validate JSON input with respect to DenyRuleRecord and throw an exception if invalid
    #'
    #' @param input the JSON input
    validateJSON = function(input) {
      input_json <- jsonlite::fromJSON(input)
      # check the required field `type`
      if (!is.null(input_json$`type`)) {
        if (!(is.character(input_json$`type`) && length(input_json$`type`) == 1)) {
          stop(paste("Error! Invalid data for `type`. Must be a string:", input_json$`type`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for DenyRuleRecord: the required field `type` is missing."))
      }
      # check the required field `data`
      if (!is.null(input_json$`data`)) {
        if (!(is.character(input_json$`data`) && length(input_json$`data`) == 1)) {
          stop(paste("Error! Invalid data for `data`. Must be a string:", input_json$`data`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for DenyRuleRecord: the required field `data` is missing."))
      }
      # check the required field `id`
      if (!is.null(input_json$`id`)) {
        if (!(is.character(input_json$`id`) && length(input_json$`id`) == 1)) {
          stop(paste("Error! Invalid data for `id`. Must be a string:", input_json$`id`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for DenyRuleRecord: the required field `id` is missing."))
      }
      # check the required field `created`
      if (!is.null(input_json$`created`)) {
        if (!(is.character(input_json$`created`) && length(input_json$`created`) == 1)) {
          stop(paste("Error! Invalid data for `created`. Must be a string:", input_json$`created`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for DenyRuleRecord: the required field `created` is missing."))
      }
    },

    #' @description
    #' To string (JSON format)
    #'
    #' @return String representation of DenyRuleRecord
    toString = function() {
      self$toJSONString()
    },

    #' @description
    #' Return true if the values in all fields are valid.
    #'
    #' @return true if the values in all fields are valid.
    isValid = function() {
      # check if the required `type` is null
      if (is.null(self$`type`)) {
        return(FALSE)
      }

      # check if the required `data` is null
      if (is.null(self$`data`)) {
        return(FALSE)
      }

      # check if the required `id` is null
      if (is.null(self$`id`)) {
        return(FALSE)
      }

      # check if the required `created` is null
      if (is.null(self$`created`)) {
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
      # check if the required `type` is null
      if (is.null(self$`type`)) {
        invalid_fields["type"] <- "Non-nullable required field `type` cannot be null."
      }

      # check if the required `data` is null
      if (is.null(self$`data`)) {
        invalid_fields["data"] <- "Non-nullable required field `data` cannot be null."
      }

      # check if the required `id` is null
      if (is.null(self$`id`)) {
        invalid_fields["id"] <- "Non-nullable required field `id` cannot be null."
      }

      # check if the required `created` is null
      if (is.null(self$`created`)) {
        invalid_fields["created"] <- "Non-nullable required field `created` cannot be null."
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
# DenyRuleRecord$unlock()
#
## Below is an example to define the print function
# DenyRuleRecord$set("public", "print", function(...) {
#   print(jsonlite::prettify(self$toJSONString()))
#   invisible(self)
# })
## Uncomment below to lock the class to prevent modifications to the method or field
# DenyRuleRecord$lock()

