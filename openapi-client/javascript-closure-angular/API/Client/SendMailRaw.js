goog.provide('API.Client.SendMailRaw');

/**
 * Request body for `POST /mail/rawsend`.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing `DKIM-Signature` header intact.  The `From`, `To`, `Cc`, and `Bcc` addresses are extracted from the message headers automatically — you do not need to specify them separately.
 * @record
 */
API.Client.SendMailRaw = function() {}

/**
 * The complete RFC 822 email message including all headers and the body. Must include at minimum `From`, `To`, `Subject`, `Date`, and `MIME-Version` headers.  DKIM signatures in the `DKIM-Signature` header are transmitted verbatim and will pass verification at the destination.
 * @type {!string}
 * @export
 */
API.Client.SendMailRaw.prototype.rawEmail;

/**
 * Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by `GET /mail`.
 * @type {!number}
 * @export
 */
API.Client.SendMailRaw.prototype.id;

