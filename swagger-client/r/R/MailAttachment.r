# Mail Baby API
#
# This is an API defintion for accesssing the Mail.Baby mail service.
#
# OpenAPI spec version: 1.0.0
# Contact: detain@interserver.net
# Generated by: https://github.com/swagger-api/swagger-codegen.git

#' MailAttachment Class
#'
#' @field filename 
#' @field data 
#'
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
MailAttachment <- R6::R6Class(
  'MailAttachment',
  public = list(
    `filename` = NULL,
    `data` = NULL,
    initialize = function(`filename`, `data`){
      if (!missing(`filename`)) {
        stopifnot(is.character(`filename`), length(`filename`) == 1)
        self$`filename` <- `filename`
      }
      if (!missing(`data`)) {
        stopifnot(is.character(`data`), length(`data`) == 1)
        self$`data` <- `data`
      }
    },
    toJSON = function() {
      MailAttachmentObject <- list()
      if (!is.null(self$`filename`)) {
        MailAttachmentObject[['filename']] <- self$`filename`
      }
      if (!is.null(self$`data`)) {
        MailAttachmentObject[['data']] <- self$`data`
      }

      MailAttachmentObject
    },
    fromJSON = function(MailAttachmentJson) {
      MailAttachmentObject <- jsonlite::fromJSON(MailAttachmentJson)
      if (!is.null(MailAttachmentObject$`filename`)) {
        self$`filename` <- MailAttachmentObject$`filename`
      }
      if (!is.null(MailAttachmentObject$`data`)) {
        self$`data` <- MailAttachmentObject$`data`
      }
    },
    toJSONString = function() {
       sprintf(
        '{
           "filename": %s,
           "data": %s
        }',
        self$`filename`,
        self$`data`
      )
    },
    fromJSONString = function(MailAttachmentJson) {
      MailAttachmentObject <- jsonlite::fromJSON(MailAttachmentJson)
      self$`filename` <- MailAttachmentObject$`filename`
      self$`data` <- MailAttachmentObject$`data`
    }
  )
)