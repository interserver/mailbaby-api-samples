#' Create a new DenyRuleRecordAllOf
#'
#' @description
#' DenyRuleRecordAllOf Class
#'
#' @docType class
#' @title DenyRuleRecordAllOf
#' @description DenyRuleRecordAllOf Class
#' @format An \code{R6Class} generator object
#' @field id The deny rule Id number. integer
#' @field created the date the rule was created. character
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
DenyRuleRecordAllOf <- R6::R6Class(
  "DenyRuleRecordAllOf",
  public = list(
    `id` = NULL,
    `created` = NULL,
    #' Initialize a new DenyRuleRecordAllOf class.
    #'
    #' @description
    #' Initialize a new DenyRuleRecordAllOf class.
    #'
    #' @param id The deny rule Id number.
    #' @param created the date the rule was created.
    #' @param ... Other optional arguments.
    #' @export
    initialize = function(`id`, `created`, ...) {
      if (!missing(`id`)) {
        if (!(is.numeric(`id`) && length(`id`) == 1)) {
          stop(paste("Error! Invalid data for `id`. Must be an integer:", `id`))
        }
        self$`id` <- `id`
      }
      if (!missing(`created`)) {
        if (!(is.character(`created`) && length(`created`) == 1)) {
          stop(paste("Error! Invalid data for `created`. Must be a string:", `created`))
        }
        self$`created` <- `created`
      }
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return DenyRuleRecordAllOf in JSON format
    #' @export
    toJSON = function() {
      DenyRuleRecordAllOfObject <- list()
      if (!is.null(self$`id`)) {
        DenyRuleRecordAllOfObject[["id"]] <-
          self$`id`
      }
      if (!is.null(self$`created`)) {
        DenyRuleRecordAllOfObject[["created"]] <-
          self$`created`
      }
      DenyRuleRecordAllOfObject
    },
    #' Deserialize JSON string into an instance of DenyRuleRecordAllOf
    #'
    #' @description
    #' Deserialize JSON string into an instance of DenyRuleRecordAllOf
    #'
    #' @param input_json the JSON input
    #' @return the instance of DenyRuleRecordAllOf
    #' @export
    fromJSON = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      if (!is.null(this_object$`id`)) {
        self$`id` <- this_object$`id`
      }
      if (!is.null(this_object$`created`)) {
        self$`created` <- this_object$`created`
      }
      self
    },
    #' To JSON string
    #'
    #' @description
    #' To JSON String
    #'
    #' @return DenyRuleRecordAllOf in JSON format
    #' @export
    toJSONString = function() {
      jsoncontent <- c(
        if (!is.null(self$`id`)) {
          sprintf(
          '"id":
            %d
                    ',
          self$`id`
          )
        },
        if (!is.null(self$`created`)) {
          sprintf(
          '"created":
            "%s"
                    ',
          self$`created`
          )
        }
      )
      jsoncontent <- paste(jsoncontent, collapse = ",")
      json_string <- as.character(jsonlite::minify(paste("{", jsoncontent, "}", sep = "")))
    },
    #' Deserialize JSON string into an instance of DenyRuleRecordAllOf
    #'
    #' @description
    #' Deserialize JSON string into an instance of DenyRuleRecordAllOf
    #'
    #' @param input_json the JSON input
    #' @return the instance of DenyRuleRecordAllOf
    #' @export
    fromJSONString = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      self$`id` <- this_object$`id`
      self$`created` <- this_object$`created`
      self
    },
    #' Validate JSON input with respect to DenyRuleRecordAllOf
    #'
    #' @description
    #' Validate JSON input with respect to DenyRuleRecordAllOf and throw an exception if invalid
    #'
    #' @param input the JSON input
    #' @export
    validateJSON = function(input) {
      input_json <- jsonlite::fromJSON(input)
      # check the required field `id`
      if (!is.null(input_json$`id`)) {
        if (!(is.numeric(input_json$`id`) && length(input_json$`id`) == 1)) {
          stop(paste("Error! Invalid data for `id`. Must be an integer:", input_json$`id`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for DenyRuleRecordAllOf: the required field `id` is missing."))
      }
      # check the required field `created`
      if (!is.null(input_json$`created`)) {
        if (!(is.character(input_json$`created`) && length(input_json$`created`) == 1)) {
          stop(paste("Error! Invalid data for `created`. Must be a string:", input_json$`created`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for DenyRuleRecordAllOf: the required field `created` is missing."))
      }
    },
    #' To string (JSON format)
    #'
    #' @description
    #' To string (JSON format)
    #'
    #' @return String representation of DenyRuleRecordAllOf
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
    #' Return a list of invalid fields (if any).
    #'
    #' @description
    #' Return a list of invalid fields (if any).
    #'
    #' @return A list of invalid fields (if any).
    #' @export
    getInvalidFields = function() {
      invalid_fields <- list()
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
# DenyRuleRecordAllOf$unlock()
#
## Below is an example to define the print function
# DenyRuleRecordAllOf$set("public", "print", function(...) {
#   print(jsonlite::prettify(self$toJSONString()))
#   invisible(self)
# })
## Uncomment below to lock the class to prevent modifications to the method or field
# DenyRuleRecordAllOf$lock()

