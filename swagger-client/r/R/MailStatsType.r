# MailBaby Email Delivery and Management Service API
#
# **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
#
# OpenAPI spec version: 1.1.0
# Contact: support@interserver.net
# Generated by: https://github.com/swagger-api/swagger-codegen.git

#' MailStatsType Class
#'
#' @field time 
#' @field usage 
#' @field currency 
#' @field currencySymbol 
#' @field cost 
#' @field received 
#' @field sent 
#' @field volume 
#'
#' @importFrom R6 R6Class
#' @importFrom jsonlite fromJSON toJSON
#' @export
MailStatsType <- R6::R6Class(
  'MailStatsType',
  public = list(
    `time` = NULL,
    `usage` = NULL,
    `currency` = NULL,
    `currencySymbol` = NULL,
    `cost` = NULL,
    `received` = NULL,
    `sent` = NULL,
    `volume` = NULL,
    initialize = function(`time`, `usage`, `currency`, `currencySymbol`, `cost`, `received`, `sent`, `volume`){
      if (!missing(`time`)) {
        stopifnot(is.character(`time`), length(`time`) == 1)
        self$`time` <- `time`
      }
      if (!missing(`usage`)) {
        stopifnot(is.numeric(`usage`), length(`usage`) == 1)
        self$`usage` <- `usage`
      }
      if (!missing(`currency`)) {
        stopifnot(is.character(`currency`), length(`currency`) == 1)
        self$`currency` <- `currency`
      }
      if (!missing(`currencySymbol`)) {
        stopifnot(is.character(`currencySymbol`), length(`currencySymbol`) == 1)
        self$`currencySymbol` <- `currencySymbol`
      }
      if (!missing(`cost`)) {
        stopifnot(is.numeric(`cost`), length(`cost`) == 1)
        self$`cost` <- `cost`
      }
      if (!missing(`received`)) {
        stopifnot(is.numeric(`received`), length(`received`) == 1)
        self$`received` <- `received`
      }
      if (!missing(`sent`)) {
        stopifnot(is.numeric(`sent`), length(`sent`) == 1)
        self$`sent` <- `sent`
      }
      if (!missing(`volume`)) {
        stopifnot(R6::is.R6(`volume`))
        self$`volume` <- `volume`
      }
    },
    toJSON = function() {
      MailStatsTypeObject <- list()
      if (!is.null(self$`time`)) {
        MailStatsTypeObject[['time']] <- self$`time`
      }
      if (!is.null(self$`usage`)) {
        MailStatsTypeObject[['usage']] <- self$`usage`
      }
      if (!is.null(self$`currency`)) {
        MailStatsTypeObject[['currency']] <- self$`currency`
      }
      if (!is.null(self$`currencySymbol`)) {
        MailStatsTypeObject[['currencySymbol']] <- self$`currencySymbol`
      }
      if (!is.null(self$`cost`)) {
        MailStatsTypeObject[['cost']] <- self$`cost`
      }
      if (!is.null(self$`received`)) {
        MailStatsTypeObject[['received']] <- self$`received`
      }
      if (!is.null(self$`sent`)) {
        MailStatsTypeObject[['sent']] <- self$`sent`
      }
      if (!is.null(self$`volume`)) {
        MailStatsTypeObject[['volume']] <- self$`volume`$toJSON()
      }

      MailStatsTypeObject
    },
    fromJSON = function(MailStatsTypeJson) {
      MailStatsTypeObject <- jsonlite::fromJSON(MailStatsTypeJson)
      if (!is.null(MailStatsTypeObject$`time`)) {
        self$`time` <- MailStatsTypeObject$`time`
      }
      if (!is.null(MailStatsTypeObject$`usage`)) {
        self$`usage` <- MailStatsTypeObject$`usage`
      }
      if (!is.null(MailStatsTypeObject$`currency`)) {
        self$`currency` <- MailStatsTypeObject$`currency`
      }
      if (!is.null(MailStatsTypeObject$`currencySymbol`)) {
        self$`currencySymbol` <- MailStatsTypeObject$`currencySymbol`
      }
      if (!is.null(MailStatsTypeObject$`cost`)) {
        self$`cost` <- MailStatsTypeObject$`cost`
      }
      if (!is.null(MailStatsTypeObject$`received`)) {
        self$`received` <- MailStatsTypeObject$`received`
      }
      if (!is.null(MailStatsTypeObject$`sent`)) {
        self$`sent` <- MailStatsTypeObject$`sent`
      }
      if (!is.null(MailStatsTypeObject$`volume`)) {
        volumeObject <- MailStatsTypeVolume$new()
        volumeObject$fromJSON(jsonlite::toJSON(MailStatsTypeObject$volume, auto_unbox = TRUE))
        self$`volume` <- volumeObject
      }
    },
    toJSONString = function() {
       sprintf(
        '{
           "time": %s,
           "usage": %d,
           "currency": %s,
           "currencySymbol": %s,
           "cost": %d,
           "received": %d,
           "sent": %d,
           "volume": %s
        }',
        self$`time`,
        self$`usage`,
        self$`currency`,
        self$`currencySymbol`,
        self$`cost`,
        self$`received`,
        self$`sent`,
        self$`volume`$toJSON()
      )
    },
    fromJSONString = function(MailStatsTypeJson) {
      MailStatsTypeObject <- jsonlite::fromJSON(MailStatsTypeJson)
      self$`time` <- MailStatsTypeObject$`time`
      self$`usage` <- MailStatsTypeObject$`usage`
      self$`currency` <- MailStatsTypeObject$`currency`
      self$`currencySymbol` <- MailStatsTypeObject$`currencySymbol`
      self$`cost` <- MailStatsTypeObject$`cost`
      self$`received` <- MailStatsTypeObject$`received`
      self$`sent` <- MailStatsTypeObject$`sent`
      MailStatsTypeVolumeObject <- MailStatsTypeVolume$new()
      self$`volume` <- MailStatsTypeVolumeObject$fromJSON(jsonlite::toJSON(MailStatsTypeObject$volume, auto_unbox = TRUE))
    }
  )
)
