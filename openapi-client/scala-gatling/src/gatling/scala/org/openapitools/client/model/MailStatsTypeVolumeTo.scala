
package org.openapitools.client.model


case class MailStatsTypeVolumeTo (
    _clientdomainCom: Option[Integer],
    _usersiteNet: Option[Integer],
    _salescompanyCom: Option[Integer],
    _clientanothersiteCom: Option[Integer]
)
object MailStatsTypeVolumeTo {
    def toStringBody(var_clientdomainCom: Object, var_usersiteNet: Object, var_salescompanyCom: Object, var_clientanothersiteCom: Object) =
        s"""
        | {
        | "clientdomainCom":$var_clientdomainCom,"usersiteNet":$var_usersiteNet,"salescompanyCom":$var_salescompanyCom,"clientanothersiteCom":$var_clientanothersiteCom
        | }
        """.stripMargin
}
