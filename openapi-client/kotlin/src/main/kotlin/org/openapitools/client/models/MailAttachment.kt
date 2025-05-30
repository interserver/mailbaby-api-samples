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
 * (optional) File attachments to include in the email.  The file contents must be base64
 *
 * @param filename The filename of the attached file.
 * @param `data` The file contents base64 encoded
 */


data class MailAttachment (

    /* The filename of the attached file. */
    @Json(name = "filename")
    val filename: kotlin.String,

    /* The file contents base64 encoded */
    @Json(name = "data")
    val `data`: kotlin.String

) {


}

