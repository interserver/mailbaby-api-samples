
package org.openapitools.client.model


case class SendMail (
    /* The Contact whom is the primary recipient of this email. */
    _to: String,
    /* The contact whom is the this email is from. */
    _from: String,
    /* The subject or title of the email */
    _subject: String,
    /* The main email contents. */
    _body: String,
    /* Optional Order ID */
    _id: Option[Integer]
)
object SendMail {
    def toStringBody(var_to: Object, var_from: Object, var_subject: Object, var_body: Object, var_id: Object) =
        s"""
        | {
        | "to":$var_to,"from":$var_from,"subject":$var_subject,"body":$var_body,"id":$var_id
        | }
        """.stripMargin
}
