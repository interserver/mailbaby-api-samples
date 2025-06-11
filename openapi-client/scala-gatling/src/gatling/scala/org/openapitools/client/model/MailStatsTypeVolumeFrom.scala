
package org.openapitools.client.model


case class MailStatsTypeVolumeFrom (
    _billingsomedomainCom: Option[Integer],
    _salessomedomainCom: Option[Integer]
)
object MailStatsTypeVolumeFrom {
    def toStringBody(var_billingsomedomainCom: Object, var_salessomedomainCom: Object) =
        s"""
        | {
        | "billingsomedomainCom":$var_billingsomedomainCom,"salessomedomainCom":$var_salessomedomainCom
        | }
        """.stripMargin
}
