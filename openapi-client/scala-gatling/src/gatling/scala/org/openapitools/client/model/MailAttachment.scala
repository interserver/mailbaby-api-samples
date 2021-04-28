
package org.openapitools.client.model

import java.io.File

case class MailAttachment (
    /* Contents of the attached file */
    _data: File,
    /* Optional filename to specify for the attachment. */
    _filename: Option[String]
)
object MailAttachment {
    def toStringBody(var_data: Object, var_filename: Object) =
        s"""
        | {
        | "data":$var_data,"filename":$var_filename
        | }
        """.stripMargin
}
