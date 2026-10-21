package org.openapitools.server.model


/**
 * = EmailAddressTypes =
 *
 * A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (`\"Name <email>\"`), or a structured contact object.
 *
 * @param email The email address. for example: ''user@domain.com''
 * @param name Optional display name shown to recipients (e.g. in the `From:` header). for example: ''John Smith''
*/
final case class EmailAddressTypes (
  email: String,
  name: Option[String] = None
)

