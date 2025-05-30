/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * An email record
 *
 * @param id internal db id
 * @param id mail id
 * @param from from address
 * @param to to address
 * @param subject email subject
 * @param created creation date
 * @param time creation timestamp
 * @param user user account
 * @param transtype transaction type
 * @param origin origin ip
 * @param `interface` interface name
 * @param sendingZone sending zone
 * @param bodySize email body size in bytes
 * @param seq index of email in the to adderess list
 * @param recipient to address this email is being sent to
 * @param domain to address domain
 * @param locked locked status
 * @param lockTime lock timestamp
 * @param assigned assigned server
 * @param queued queued timestamp
 * @param mxHostname mx hostname
 * @param response mail delivery response
 * @param messageId message id
 */


data class MailLogEntry (

    /* internal db id */
    @Json(name = "_id")
    val id: kotlin.Int,

    /* mail id */
    @Json(name = "id")
    val id: kotlin.String,

    /* from address */
    @Json(name = "from")
    val from: kotlin.String,

    /* to address */
    @Json(name = "to")
    val to: kotlin.String,

    /* email subject */
    @Json(name = "subject")
    val subject: kotlin.String,

    /* creation date */
    @Json(name = "created")
    val created: kotlin.String,

    /* creation timestamp */
    @Json(name = "time")
    val time: kotlin.Int,

    /* user account */
    @Json(name = "user")
    val user: kotlin.String,

    /* transaction type */
    @Json(name = "transtype")
    val transtype: kotlin.String,

    /* origin ip */
    @Json(name = "origin")
    val origin: kotlin.String,

    /* interface name */
    @Json(name = "interface")
    val `interface`: kotlin.String,

    /* sending zone */
    @Json(name = "sendingZone")
    val sendingZone: kotlin.String,

    /* email body size in bytes */
    @Json(name = "bodySize")
    val bodySize: kotlin.Int,

    /* index of email in the to adderess list */
    @Json(name = "seq")
    val seq: kotlin.Int,

    /* to address this email is being sent to */
    @Json(name = "recipient")
    val recipient: kotlin.String,

    /* to address domain */
    @Json(name = "domain")
    val domain: kotlin.String,

    /* locked status */
    @Json(name = "locked")
    val locked: kotlin.Int,

    /* lock timestamp */
    @Json(name = "lockTime")
    val lockTime: kotlin.String,

    /* assigned server */
    @Json(name = "assigned")
    val assigned: kotlin.String,

    /* queued timestamp */
    @Json(name = "queued")
    val queued: kotlin.String,

    /* mx hostname */
    @Json(name = "mxHostname")
    val mxHostname: kotlin.String,

    /* mail delivery response */
    @Json(name = "response")
    val response: kotlin.String,

    /* message id */
    @Json(name = "messageId")
    val messageId: kotlin.String? = null

) {


}

