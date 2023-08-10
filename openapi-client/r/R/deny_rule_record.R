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
#' @field id The deny rule Id number. integer
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
    #' Initialize a new DenyRuleRecord class.
    #'
    #' @description
    #' Initialize a new DenyRuleRecord class.
    #'
    #' @param type The type of deny rule.
    #' @param data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
    #' @param id The deny rule Id number.
    #' @param created the date the rule was created.
    #' @param user Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
    #' @param ... Other optional arguments.
    #' @export
    initialize = function(`type`, `data`, `id`, `created`, `user` = NULL, ...) {
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
    #' @return DenyRuleRecord in JSON format
    #' @export
    toJSON = function() {
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
      DenyRuleRecordObject
    },
    #' Deserialize JSON string into an instance of DenyRuleRecord
    #'
    #' @description
    #' Deserialize JSON string into an instance of DenyRuleRecord
    #'
    #' @param input_json the JSON input
    #' @return the instance of DenyRuleRecord
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
    #' @return DenyRuleRecord in JSON format
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
        },
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
    #' Deserialize JSON string into an instance of DenyRuleRecord
    #'
    #' @description
    #' Deserialize JSON string into an instance of DenyRuleRecord
    #'
    #' @param input_json the JSON input
    #' @return the instance of DenyRuleRecord
    #' @export
    fromJSONString = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      self$`user` <- this_object$`user`
      if (!is.null(this_object$`type`) && !(this_object$`type` %in% c("domain", "email", "startswith"))) {
        stop(paste("Error! \"", this_object$`type`, "\" cannot be assigned to `type`. Must be \"domain\", \"email\", \"startswith\".", sep = ""))
      }
      self$`type` <- this_object$`type`
      self$`data` <- this_object$`data`
      self$`id` <- this_object$`id`
      self$`created` <- this_object$`created`
      self
    },
    #' Validate JSON input with respect to DenyRuleRecord
    #'
    #' @description
    #' Validate JSON input with respect to DenyRuleRecord and throw an exception if invalid
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
        if (!(is.numeric(input_json$`id`) && length(input_json$`id`) == 1)) {
          stop(paste("Error! Invalid data for `id`. Must be an integer:", input_json$`id`))
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
    #' To string (JSON format)
    #'
    #' @description
    #' To string (JSON format)
    #'
    #' @return String representation of DenyRuleRecord
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
# DenyRuleRecord$unlock()
#
## Below is an example to define the print function
# DenyRuleRecord$set("public", "print", function(...) {
#   print(jsonlite::prettify(self$toJSONString()))
#   invisible(self)
# })
## Uncomment below to lock the class to prevent modifications to the method or field
# DenyRuleRecord$lock()

