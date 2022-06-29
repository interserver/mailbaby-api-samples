
package org.openapitools.client.model

import java.io.File

case class SendMailAdvAttachmentsInner (
    /* Contents of the attached file (must be base64 encoded) */
    _data: File,
    /* (optional) Filename to specify for the attachment. */
    _filename: Option[String]
)
object SendMailAdvAttachmentsInner {
    def toStringBody(var_data: Object, var_filename: Object) =
        s"""
        | {
        | "data":$var_data,"filename":$var_filename
        | }
        """.stripMargin
}
