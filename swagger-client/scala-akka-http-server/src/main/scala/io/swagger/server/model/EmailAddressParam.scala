package io.swagger.server.model


/**
 * = EmailAddressParam =
 *
 * A single email address parameter used as the body of `POST /mail/blocks/delete`.
 *
 * @param email The email address to delist from all block lists. for example: ''user@domain.com''
 */
case class EmailAddressParam (
  email: String
)

