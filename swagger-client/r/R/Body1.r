# Mail Baby API
#
# This is an API defintion for accesssing the Mail.Baby mail service.
#
# OpenAPI spec version: 1.0.0
# Contact: detain@interserver.net
# Generated by: https://github.com/swagger-api/swagger-codegen.git

#' Body1 Class
#'
#' @field to 
#' @field from 
#' @field subject 
#' @field body 
#'
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
Body1 <- R6::R6Class(
  'Body1',
  public = list(
    `to` = NULL,
    `from` = NULL,
    `subject` = NULL,
    `body` = NULL,
    initialize = function(`to`, `from`, `subject`, `body`){
      if (!missing(`to`)) {
        stopifnot(is.character(`to`), length(`to`) == 1)
        self$`to` <- `to`
      }
      if (!missing(`from`)) {
        stopifnot(is.character(`from`), length(`from`) == 1)
        self$`from` <- `from`
      }
      if (!missing(`subject`)) {
        stopifnot(is.character(`subject`), length(`subject`) == 1)
        self$`subject` <- `subject`
      }
      if (!missing(`body`)) {
        stopifnot(is.character(`body`), length(`body`) == 1)
        self$`body` <- `body`
      }
    },
    toJSON = function() {
      Body1Object <- list()
      if (!is.null(self$`to`)) {
        Body1Object[['to']] <- self$`to`
      }
      if (!is.null(self$`from`)) {
        Body1Object[['from']] <- self$`from`
      }
      if (!is.null(self$`subject`)) {
        Body1Object[['subject']] <- self$`subject`
      }
      if (!is.null(self$`body`)) {
        Body1Object[['body']] <- self$`body`
      }

      Body1Object
    },
    fromJSON = function(Body1Json) {
      Body1Object <- jsonlite::fromJSON(Body1Json)
      if (!is.null(Body1Object$`to`)) {
        self$`to` <- Body1Object$`to`
      }
      if (!is.null(Body1Object$`from`)) {
        self$`from` <- Body1Object$`from`
      }
      if (!is.null(Body1Object$`subject`)) {
        self$`subject` <- Body1Object$`subject`
      }
      if (!is.null(Body1Object$`body`)) {
        self$`body` <- Body1Object$`body`
      }
    },
    toJSONString = function() {
       sprintf(
        '{
           "to": %s,
           "from": %s,
           "subject": %s,
           "body": %s
        }',
        self$`to`,
        self$`from`,
        self$`subject`,
        self$`body`
      )
    },
    fromJSONString = function(Body1Json) {
      Body1Object <- jsonlite::fromJSON(Body1Json)
      self$`to` <- Body1Object$`to`
      self$`from` <- Body1Object$`from`
      self$`subject` <- Body1Object$`subject`
      self$`body` <- Body1Object$`body`
    }
  )
)