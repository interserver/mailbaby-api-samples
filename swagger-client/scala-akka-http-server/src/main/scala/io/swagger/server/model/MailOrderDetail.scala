package io.swagger.server.model


/**
 * = MailOrderDetail =
 *
 * Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
 *
 * @param password The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`. for example: ''s3cr3tpassword''
 * @param id The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries. for example: ''21472''
 * @param status The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send. for example: ''active''
 * @param username The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed. for example: ''mb21472''
 * @param comment Optional human-readable note associated with the order.
 */
case class MailOrderDetail (
  password: String,
  id: Int,
  status: String,
  username: String,
  comment: Option[String]
)

