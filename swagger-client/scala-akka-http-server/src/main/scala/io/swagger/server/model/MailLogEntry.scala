package io.swagger.server.model


/**
 * An email record
 *
 * @param _id internal db id for example: ''103172''
 * @param id mail id for example: ''17c7eda538e0005d03''
 * @param from from address for example: ''person@mysite.com''
 * @param to to address for example: ''client@isp.com''
 * @param subject email subject for example: ''sell 0.005 shares''
 * @param messageId message id for example: ''<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>''
 * @param created creation date for example: ''2021-10-14 08:50:10''
 * @param time creation timestamp for example: ''1634215809''
 * @param user user account for example: ''mb5658''
 * @param transtype transaction type for example: ''ESMTPSA''
 * @param transhost transaction host for example: ''relay0.mailbaby.net''
 * @param originhost origin host for example: ''199.231.189.154''
 * @param origin origin ip for example: ''199.231.189.154''
 * @param interface interface name for example: ''feeder''
 * @param date date processed for example: ''Thu, 14 Oct 2021 08:50:09 -0400''
 * @param sendingZone sending zone for example: ''interserver''
 * @param bodySize email body size in bytes for example: ''63''
 * @param sourceMd5 md5 sum of the email for example: ''1d7058e6a30369f200b0c34fab2fac92''
 * @param seq delivery sequency for example: ''1''
 * @param domain to address domain for example: ''interserver.net''
 * @param recipient email receiver address for example: ''client@isp.com''
 * @param locked locked status for example: ''1''
 * @param lockTime lock timestamp for example: ''1634215818533''
 * @param assigned assigned server for example: ''relay1''
 * @param queued queued timestamp for example: ''2021-10-14T12:50:15.487Z''
 * @param _lock lock id for example: ''lock 17c7eda538e0005d03 001''
 * @param logger logger
 * @param mxPort mx port number for example: ''25''
 * @param connectionKey connection key for example: ''206.72.200.46:interserver.net:25''
 * @param mxHostname mx hostname for example: ''mx.j.is.cc''
 * @param sentBodyHash body hash for example: ''1d7058e6a30369f200b0c34fab2fac92''
 * @param sentBodySize sent body size in bytes for example: ''63''
 * @param md5Match md5 checksum matching result for example: ''1''
 */
case class MailLogEntry (
  _id: Int,
  id: String,
  from: String,
  to: String,
  subject: String,
  messageId: String,
  created: String,
  time: Int,
  user: String,
  transtype: String,
  transhost: String,
  originhost: String,
  origin: String,
  interface: String,
  date: String,
  sendingZone: String,
  bodySize: Int,
  sourceMd5: String,
  seq: Int,
  domain: String,
  recipient: String,
  locked: Int,
  lockTime: Int,
  assigned: String,
  queued: String,
  _lock: String,
  logger: String,
  mxPort: Int,
  connectionKey: String,
  mxHostname: String,
  sentBodyHash: String,
  sentBodySize: Int,
  md5Match: Int
)

