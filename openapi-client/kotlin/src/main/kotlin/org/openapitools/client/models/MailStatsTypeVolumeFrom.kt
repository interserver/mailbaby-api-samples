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
 * 
 *
 * @param billingAtSomedomainCom 
 * @param salesAtSomedomainCom 
 */


data class MailStatsTypeVolumeFrom (

    @Json(name = "billing@somedomain.com")
    val billingAtSomedomainCom: kotlin.Int? = null,

    @Json(name = "sales@somedomain.com")
    val salesAtSomedomainCom: kotlin.Int? = null

) {


}

