package io.swagger.server.model


/**
 * = Root Type for EmailAddress =
 *
 * an email address
 *
 * @param email an email address for example: ''user@domain.com''
 */
case class EmailAddress (
  email: Option[String]
)

