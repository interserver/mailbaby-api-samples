
package org.openapitools.client.model


case class MailLog (
    _id: Option[Long]
)
object MailLog {
    def toStringBody(var_id: Object) =
        s"""
        | {
        | "id":$var_id
        | }
        """.stripMargin
}
