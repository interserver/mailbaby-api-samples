/** MailBaby Email Delivery and Management Service API
  * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
  *
  * The version of the OpenAPI document: 1.1.0
  * Contact: support@interserver.net
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech
  * Do not edit the class manually.
  */
package org.openapitools.client.models

import io.circe.*
import io.circe.syntax.*
import io.circe.{Decoder, Encoder}


/** 
  */
enum MailStatsTypeTime(val value: String) {
  case All extends MailStatsTypeTime("all")
  case Billing extends MailStatsTypeTime("billing")
  case Month extends MailStatsTypeTime("month")
  case `7d` extends MailStatsTypeTime("7d")
  case `24h` extends MailStatsTypeTime("24h")
  case Today extends MailStatsTypeTime("today")
  case `1h` extends MailStatsTypeTime("1h")
}

object MailStatsTypeTime {

  def withValueOpt(value: String): Option[MailStatsTypeTime] = MailStatsTypeTime.values.find(_.value == value)
  def withValue(value: String): MailStatsTypeTime =
    withValueOpt(value).getOrElse(throw java.lang.IllegalArgumentException(s"MailStatsTypeTime enum case not found: $value"))

  given decoderMailStatsTypeTime: Decoder[MailStatsTypeTime] = Decoder.decodeString.map(withValue)
  given encoderMailStatsTypeTime: Encoder[MailStatsTypeTime] = Encoder.encodeString.contramap[MailStatsTypeTime](_.value)

}

