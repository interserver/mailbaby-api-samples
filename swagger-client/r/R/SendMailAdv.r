# Mail Baby API
#
# This is an API defintion for accesssing the Mail.Baby mail service.
#
# OpenAPI spec version: 1.0.0
# Contact: detain@interserver.net
# Generated by: https://github.com/swagger-api/swagger-codegen.git

#' SendMailAdv Class
#'
#' @field subject 
#' @field body 
#' @field from 
#' @field to 
#' @field id 
#' @field replyto 
#' @field cc 
#' @field bcc 
#' @field attachments 
#'
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
SendMailAdv <- R6::R6Class(
  'SendMailAdv',
  public = list(
    `subject` = NULL,
    `body` = NULL,
    `from` = NULL,
    `to` = NULL,
    `id` = NULL,
    `replyto` = NULL,
    `cc` = NULL,
    `bcc` = NULL,
    `attachments` = NULL,
    initialize = function(`subject`, `body`, `from`, `to`, `id`, `replyto`, `cc`, `bcc`, `attachments`){
      if (!missing(`subject`)) {
        stopifnot(is.character(`subject`), length(`subject`) == 1)
        self$`subject` <- `subject`
      }
      if (!missing(`body`)) {
        stopifnot(is.character(`body`), length(`body`) == 1)
        self$`body` <- `body`
      }
      if (!missing(`from`)) {
        stopifnot(is.list(`from`), length(`from`) != 0)
        lapply(`from`, function(x) stopifnot(R6::is.R6(x)))
        self$`from` <- `from`
      }
      if (!missing(`to`)) {
        stopifnot(is.list(`to`), length(`to`) != 0)
        lapply(`to`, function(x) stopifnot(R6::is.R6(x)))
        self$`to` <- `to`
      }
      if (!missing(`id`)) {
        stopifnot(is.numeric(`id`), length(`id`) == 1)
        self$`id` <- `id`
      }
      if (!missing(`replyto`)) {
        stopifnot(is.list(`replyto`), length(`replyto`) != 0)
        lapply(`replyto`, function(x) stopifnot(R6::is.R6(x)))
        self$`replyto` <- `replyto`
      }
      if (!missing(`cc`)) {
        stopifnot(is.list(`cc`), length(`cc`) != 0)
        lapply(`cc`, function(x) stopifnot(R6::is.R6(x)))
        self$`cc` <- `cc`
      }
      if (!missing(`bcc`)) {
        stopifnot(is.list(`bcc`), length(`bcc`) != 0)
        lapply(`bcc`, function(x) stopifnot(R6::is.R6(x)))
        self$`bcc` <- `bcc`
      }
      if (!missing(`attachments`)) {
        stopifnot(is.list(`attachments`), length(`attachments`) != 0)
        lapply(`attachments`, function(x) stopifnot(R6::is.R6(x)))
        self$`attachments` <- `attachments`
      }
    },
    toJSON = function() {
      SendMailAdvObject <- list()
      if (!is.null(self$`subject`)) {
        SendMailAdvObject[['subject']] <- self$`subject`
      }
      if (!is.null(self$`body`)) {
        SendMailAdvObject[['body']] <- self$`body`
      }
      if (!is.null(self$`from`)) {
        SendMailAdvObject[['from']] <- lapply(self$`from`, function(x) x$toJSON())
      }
      if (!is.null(self$`to`)) {
        SendMailAdvObject[['to']] <- lapply(self$`to`, function(x) x$toJSON())
      }
      if (!is.null(self$`id`)) {
        SendMailAdvObject[['id']] <- self$`id`
      }
      if (!is.null(self$`replyto`)) {
        SendMailAdvObject[['replyto']] <- lapply(self$`replyto`, function(x) x$toJSON())
      }
      if (!is.null(self$`cc`)) {
        SendMailAdvObject[['cc']] <- lapply(self$`cc`, function(x) x$toJSON())
      }
      if (!is.null(self$`bcc`)) {
        SendMailAdvObject[['bcc']] <- lapply(self$`bcc`, function(x) x$toJSON())
      }
      if (!is.null(self$`attachments`)) {
        SendMailAdvObject[['attachments']] <- lapply(self$`attachments`, function(x) x$toJSON())
      }

      SendMailAdvObject
    },
    fromJSON = function(SendMailAdvJson) {
      SendMailAdvObject <- jsonlite::fromJSON(SendMailAdvJson)
      if (!is.null(SendMailAdvObject$`subject`)) {
        self$`subject` <- SendMailAdvObject$`subject`
      }
      if (!is.null(SendMailAdvObject$`body`)) {
        self$`body` <- SendMailAdvObject$`body`
      }
      if (!is.null(SendMailAdvObject$`from`)) {
        self$`from` <- lapply(SendMailAdvObject$`from`, function(x) {
          fromObject <- SendMailAdvFrom$new()
          fromObject$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE))
          fromObject
        })
      }
      if (!is.null(SendMailAdvObject$`to`)) {
        self$`to` <- lapply(SendMailAdvObject$`to`, function(x) {
          toObject <- MailContact$new()
          toObject$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE))
          toObject
        })
      }
      if (!is.null(SendMailAdvObject$`id`)) {
        self$`id` <- SendMailAdvObject$`id`
      }
      if (!is.null(SendMailAdvObject$`replyto`)) {
        self$`replyto` <- lapply(SendMailAdvObject$`replyto`, function(x) {
          replytoObject <- MailContact$new()
          replytoObject$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE))
          replytoObject
        })
      }
      if (!is.null(SendMailAdvObject$`cc`)) {
        self$`cc` <- lapply(SendMailAdvObject$`cc`, function(x) {
          ccObject <- MailContact$new()
          ccObject$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE))
          ccObject
        })
      }
      if (!is.null(SendMailAdvObject$`bcc`)) {
        self$`bcc` <- lapply(SendMailAdvObject$`bcc`, function(x) {
          bccObject <- MailContact$new()
          bccObject$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE))
          bccObject
        })
      }
      if (!is.null(SendMailAdvObject$`attachments`)) {
        self$`attachments` <- lapply(SendMailAdvObject$`attachments`, function(x) {
          attachmentsObject <- MailAttachment$new()
          attachmentsObject$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE))
          attachmentsObject
        })
      }
    },
    toJSONString = function() {
       sprintf(
        '{
           "subject": %s,
           "body": %s,
           "from": [%s],
           "to": [%s],
           "id": %d,
           "replyto": [%s],
           "cc": [%s],
           "bcc": [%s],
           "attachments": [%s]
        }',
        self$`subject`,
        self$`body`,
        lapply(self$`from`, function(x) paste(x$toJSON(), sep=",")),
        lapply(self$`to`, function(x) paste(x$toJSON(), sep=",")),
        self$`id`,
        lapply(self$`replyto`, function(x) paste(x$toJSON(), sep=",")),
        lapply(self$`cc`, function(x) paste(x$toJSON(), sep=",")),
        lapply(self$`bcc`, function(x) paste(x$toJSON(), sep=",")),
        lapply(self$`attachments`, function(x) paste(x$toJSON(), sep=","))
      )
    },
    fromJSONString = function(SendMailAdvJson) {
      SendMailAdvObject <- jsonlite::fromJSON(SendMailAdvJson)
      self$`subject` <- SendMailAdvObject$`subject`
      self$`body` <- SendMailAdvObject$`body`
      self$`from` <- lapply(SendMailAdvObject$`from`, function(x) SendMailAdvFrom$new()$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE)))
      self$`to` <- lapply(SendMailAdvObject$`to`, function(x) MailContact$new()$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE)))
      self$`id` <- SendMailAdvObject$`id`
      self$`replyto` <- lapply(SendMailAdvObject$`replyto`, function(x) MailContact$new()$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE)))
      self$`cc` <- lapply(SendMailAdvObject$`cc`, function(x) MailContact$new()$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE)))
      self$`bcc` <- lapply(SendMailAdvObject$`bcc`, function(x) MailContact$new()$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE)))
      self$`attachments` <- lapply(SendMailAdvObject$`attachments`, function(x) MailAttachment$new()$fromJSON(jsonlite::toJSON(x, auto_unbox = TRUE)))
    }
  )
)