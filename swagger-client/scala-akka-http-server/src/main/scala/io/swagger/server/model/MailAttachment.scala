package io.swagger.server.model


/**
 * = MailAttachment =
 *
 * A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.
 *
 * @param filename The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`). for example: ''message.txt''
 * @param data The file contents as a base64-encoded string.  Decode this to retrieve the original binary file. for example: ''[B@40080827''
 */
case class MailAttachment (
  filename: String,
  data: byte[]
)

