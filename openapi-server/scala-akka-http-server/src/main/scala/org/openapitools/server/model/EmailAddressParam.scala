package org.openapitools.server.model


/**
 * = EmailAddressParam =
 *
 * A single email address parameter used as the body of `POST /mail/blocks/delete`.
 *
 * @param email The email address to delist from all block lists. for example: ''user@domain.com''
*/
final case class EmailAddressParam (
  email: String
)

