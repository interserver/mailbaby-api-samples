# MailBaby Email Delivery and Management Service API
#
# **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
#
# OpenAPI spec version: 1.1.0
# Contact: support@interserver.net
# Generated by: https://github.com/swagger-api/swagger-codegen.git

#' InlineResponse200 Class
#'
#' @field id 
#' @field status 
#' @field username 
#' @field password 
#' @field comment 
#'
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
InlineResponse200 <- R6::R6Class(
  'InlineResponse200',
  public = list(
    `id` = NULL,
    `status` = NULL,
    `username` = NULL,
    `password` = NULL,
    `comment` = NULL,
    initialize = function(`id`, `status`, `username`, `password`, `comment`){
      if (!missing(`id`)) {
        stopifnot(is.numeric(`id`), length(`id`) == 1)
        self$`id` <- `id`
      }
      if (!missing(`status`)) {
        stopifnot(is.character(`status`), length(`status`) == 1)
        self$`status` <- `status`
      }
      if (!missing(`username`)) {
        stopifnot(is.character(`username`), length(`username`) == 1)
        self$`username` <- `username`
      }
      if (!missing(`password`)) {
        stopifnot(is.character(`password`), length(`password`) == 1)
        self$`password` <- `password`
      }
      if (!missing(`comment`)) {
        stopifnot(is.character(`comment`), length(`comment`) == 1)
        self$`comment` <- `comment`
      }
    },
    toJSON = function() {
      InlineResponse200Object <- list()
      if (!is.null(self$`id`)) {
        InlineResponse200Object[['id']] <- self$`id`
      }
      if (!is.null(self$`status`)) {
        InlineResponse200Object[['status']] <- self$`status`
      }
      if (!is.null(self$`username`)) {
        InlineResponse200Object[['username']] <- self$`username`
      }
      if (!is.null(self$`password`)) {
        InlineResponse200Object[['password']] <- self$`password`
      }
      if (!is.null(self$`comment`)) {
        InlineResponse200Object[['comment']] <- self$`comment`
      }

      InlineResponse200Object
    },
    fromJSON = function(InlineResponse200Json) {
      InlineResponse200Object <- jsonlite::fromJSON(InlineResponse200Json)
      if (!is.null(InlineResponse200Object$`id`)) {
        self$`id` <- InlineResponse200Object$`id`
      }
      if (!is.null(InlineResponse200Object$`status`)) {
        self$`status` <- InlineResponse200Object$`status`
      }
      if (!is.null(InlineResponse200Object$`username`)) {
        self$`username` <- InlineResponse200Object$`username`
      }
      if (!is.null(InlineResponse200Object$`password`)) {
        self$`password` <- InlineResponse200Object$`password`
      }
      if (!is.null(InlineResponse200Object$`comment`)) {
        self$`comment` <- InlineResponse200Object$`comment`
      }
    },
    toJSONString = function() {
       sprintf(
        '{
           "id": %d,
           "status": %s,
           "username": %s,
           "password": %s,
           "comment": %s
        }',
        self$`id`,
        self$`status`,
        self$`username`,
        self$`password`,
        self$`comment`
      )
    },
    fromJSONString = function(InlineResponse200Json) {
      InlineResponse200Object <- jsonlite::fromJSON(InlineResponse200Json)
      self$`id` <- InlineResponse200Object$`id`
      self$`status` <- InlineResponse200Object$`status`
      self$`username` <- InlineResponse200Object$`username`
      self$`password` <- InlineResponse200Object$`password`
      self$`comment` <- InlineResponse200Object$`comment`
    }
  )
)