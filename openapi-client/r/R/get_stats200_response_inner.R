#' Create a new GetStats200ResponseInner
#'
#' @description
#' GetStats200ResponseInner Class
#'
#' @docType class
#' @title GetStats200ResponseInner
#' @description GetStats200ResponseInner Class
#' @format An \code{R6Class} generator object
#' @field id  integer
#' @field status  character
#' @field username  character
#' @field password  character [optional]
#' @field comment  character [optional]
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
GetStats200ResponseInner <- R6::R6Class(
  "GetStats200ResponseInner",
  public = list(
    `id` = NULL,
    `status` = NULL,
    `username` = NULL,
    `password` = NULL,
    `comment` = NULL,

    #' @description
    #' Initialize a new GetStats200ResponseInner class.
    #'
    #' @param id id
    #' @param status status
    #' @param username username
    #' @param password password
    #' @param comment comment
    #' @param ... Other optional arguments.
    initialize = function(`id`, `status`, `username`, `password` = NULL, `comment` = NULL, ...) {
      if (!missing(`id`)) {
        if (!(is.numeric(`id`) && length(`id`) == 1)) {
          stop(paste("Error! Invalid data for `id`. Must be an integer:", `id`))
        }
        self$`id` <- `id`
      }
      if (!missing(`status`)) {
        if (!(is.character(`status`) && length(`status`) == 1)) {
          stop(paste("Error! Invalid data for `status`. Must be a string:", `status`))
        }
        self$`status` <- `status`
      }
      if (!missing(`username`)) {
        if (!(is.character(`username`) && length(`username`) == 1)) {
          stop(paste("Error! Invalid data for `username`. Must be a string:", `username`))
        }
        self$`username` <- `username`
      }
      if (!is.null(`password`)) {
        if (!(is.character(`password`) && length(`password`) == 1)) {
          stop(paste("Error! Invalid data for `password`. Must be a string:", `password`))
        }
        self$`password` <- `password`
      }
      if (!is.null(`comment`)) {
        if (!(is.character(`comment`) && length(`comment`) == 1)) {
          stop(paste("Error! Invalid data for `comment`. Must be a string:", `comment`))
        }
        self$`comment` <- `comment`
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
    #' @return GetStats200ResponseInner as a base R list.
    #' @examples
    #' # convert array of GetStats200ResponseInner (x) to a data frame
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
    #' Convert GetStats200ResponseInner to a base R type
    #'
    #' @return A base R type, e.g. a list or numeric/character array.
    toSimpleType = function() {
      GetStats200ResponseInnerObject <- list()
      if (!is.null(self$`id`)) {
        GetStats200ResponseInnerObject[["id"]] <-
          self$`id`
      }
      if (!is.null(self$`status`)) {
        GetStats200ResponseInnerObject[["status"]] <-
          self$`status`
      }
      if (!is.null(self$`username`)) {
        GetStats200ResponseInnerObject[["username"]] <-
          self$`username`
      }
      if (!is.null(self$`password`)) {
        GetStats200ResponseInnerObject[["password"]] <-
          self$`password`
      }
      if (!is.null(self$`comment`)) {
        GetStats200ResponseInnerObject[["comment"]] <-
          self$`comment`
      }
      return(GetStats200ResponseInnerObject)
    },

    #' @description
    #' Deserialize JSON string into an instance of GetStats200ResponseInner
    #'
    #' @param input_json the JSON input
    #' @return the instance of GetStats200ResponseInner
    fromJSON = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      if (!is.null(this_object$`id`)) {
        self$`id` <- this_object$`id`
      }
      if (!is.null(this_object$`status`)) {
        self$`status` <- this_object$`status`
      }
      if (!is.null(this_object$`username`)) {
        self$`username` <- this_object$`username`
      }
      if (!is.null(this_object$`password`)) {
        self$`password` <- this_object$`password`
      }
      if (!is.null(this_object$`comment`)) {
        self$`comment` <- this_object$`comment`
      }
      self
    },

    #' @description
    #' To JSON String
    #' 
    #' @param ... Parameters passed to `jsonlite::toJSON`
    #' @return GetStats200ResponseInner in JSON format
    toJSONString = function(...) {
      simple <- self$toSimpleType()
      json <- jsonlite::toJSON(simple, auto_unbox = TRUE, digits = NA, ...)
      return(as.character(jsonlite::minify(json)))
    },

    #' @description
    #' Deserialize JSON string into an instance of GetStats200ResponseInner
    #'
    #' @param input_json the JSON input
    #' @return the instance of GetStats200ResponseInner
    fromJSONString = function(input_json) {
      this_object <- jsonlite::fromJSON(input_json)
      self$`id` <- this_object$`id`
      self$`status` <- this_object$`status`
      self$`username` <- this_object$`username`
      self$`password` <- this_object$`password`
      self$`comment` <- this_object$`comment`
      self
    },

    #' @description
    #' Validate JSON input with respect to GetStats200ResponseInner and throw an exception if invalid
    #'
    #' @param input the JSON input
    validateJSON = function(input) {
      input_json <- jsonlite::fromJSON(input)
      # check the required field `id`
      if (!is.null(input_json$`id`)) {
        if (!(is.numeric(input_json$`id`) && length(input_json$`id`) == 1)) {
          stop(paste("Error! Invalid data for `id`. Must be an integer:", input_json$`id`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for GetStats200ResponseInner: the required field `id` is missing."))
      }
      # check the required field `status`
      if (!is.null(input_json$`status`)) {
        if (!(is.character(input_json$`status`) && length(input_json$`status`) == 1)) {
          stop(paste("Error! Invalid data for `status`. Must be a string:", input_json$`status`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for GetStats200ResponseInner: the required field `status` is missing."))
      }
      # check the required field `username`
      if (!is.null(input_json$`username`)) {
        if (!(is.character(input_json$`username`) && length(input_json$`username`) == 1)) {
          stop(paste("Error! Invalid data for `username`. Must be a string:", input_json$`username`))
        }
      } else {
        stop(paste("The JSON input `", input, "` is invalid for GetStats200ResponseInner: the required field `username` is missing."))
      }
    },

    #' @description
    #' To string (JSON format)
    #'
    #' @return String representation of GetStats200ResponseInner
    toString = function() {
      self$toJSONString()
    },

    #' @description
    #' Return true if the values in all fields are valid.
    #'
    #' @return true if the values in all fields are valid.
    isValid = function() {
      # check if the required `id` is null
      if (is.null(self$`id`)) {
        return(FALSE)
      }

      # check if the required `status` is null
      if (is.null(self$`status`)) {
        return(FALSE)
      }

      # check if the required `username` is null
      if (is.null(self$`username`)) {
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
      # check if the required `id` is null
      if (is.null(self$`id`)) {
        invalid_fields["id"] <- "Non-nullable required field `id` cannot be null."
      }

      # check if the required `status` is null
      if (is.null(self$`status`)) {
        invalid_fields["status"] <- "Non-nullable required field `status` cannot be null."
      }

      # check if the required `username` is null
      if (is.null(self$`username`)) {
        invalid_fields["username"] <- "Non-nullable required field `username` cannot be null."
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
# GetStats200ResponseInner$unlock()
#
## Below is an example to define the print function
# GetStats200ResponseInner$set("public", "print", function(...) {
#   print(jsonlite::prettify(self$toJSONString()))
#   invisible(self)
# })
## Uncomment below to lock the class to prevent modifications to the method or field
# GetStats200ResponseInner$lock()

