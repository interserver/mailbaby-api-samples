
package org.openapitools.client.model


case class MailAttachment (
    /* The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`). */
    _filename: String,
    /* The file contents as a base64-encoded string.  Decode this to retrieve the original binary file. */
    _data: String
)
object MailAttachment {
    def toStringBody(var_filename: Object, var_data: Object) =
        s"""
        | {
        | "filename":$var_filename,"data":$var_data
        | }
        """.stripMargin
}
