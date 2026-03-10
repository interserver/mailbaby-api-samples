
package org.openapitools.client.model


case class MailBlockRspamd (
    /* The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender. */
    _from: String,
    /* The suspicious subject pattern that triggered the block. */
    _subject: String
)
object MailBlockRspamd {
    def toStringBody(var_from: Object, var_subject: Object) =
        s"""
        | {
        | "from":$var_from,"subject":$var_subject
        | }
        """.stripMargin
}
