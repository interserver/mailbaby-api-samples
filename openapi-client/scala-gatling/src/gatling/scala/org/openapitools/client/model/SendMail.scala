
package org.openapitools.client.model


case class SendMail (
    /* The Contact whom is the primary recipient of this email. */
    _to: Option[String],
    /* The contact whom is the this email is from. */
    _from: Option[String],
    /* The subject or title of the email */
    _subject: Option[String],
    /* The main email contents. */
    _body: Option[String]
)
object SendMail {
    def toStringBody(var_to: Object, var_from: Object, var_subject: Object, var_body: Object) =
        s"""
        | {
        | "to":$var_to,"from":$var_from,"subject":$var_subject,"body":$var_body
        | }
        """.stripMargin
}
