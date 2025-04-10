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
 * An email contact.
 *
 * @param email The email address.
 * @param name Name to use for the sending contact.
 */


data class EmailAddressName (

    /* The email address. */
    @Json(name = "email")
    val email: kotlin.String,

    /* Name to use for the sending contact. */
    @Json(name = "name")
    val name: kotlin.String? = null

) {


}

