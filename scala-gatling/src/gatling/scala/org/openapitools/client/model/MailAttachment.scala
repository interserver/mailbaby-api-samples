
package org.openapitools.client.model

import java.io.File

case class MailAttachment (
    /* Optional filename to specify for the attachment. */
    _filename: Option[String],
    /* Contents of the attached file */
    _data: File
)
object MailAttachment {
    def toStringBody(var_filename: Object, var_data: Object) =
        s"""
        | {
        | "filename":$var_filename,"data":$var_data
        | }
        """.stripMargin
}
