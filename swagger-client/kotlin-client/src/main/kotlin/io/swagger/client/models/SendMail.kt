/**
 * Mail Baby API
 * This is an API defintion for accesssing the Mail.Baby mail service.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: detain@interserver.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package io.swagger.client.models


/**
 * Details for an Email
 * @param to The Contact whom is the primary recipient of this email.
 * @param from The contact whom is the this email is from.
 * @param subject The subject or title of the email
 * @param body The main email contents.
 */
data class SendMail (

    /* The Contact whom is the primary recipient of this email. */
    val to: kotlin.String,
    /* The contact whom is the this email is from. */
    val from: kotlin.String,
    /* The subject or title of the email */
    val subject: kotlin.String,
    /* The main email contents. */
    val body: kotlin.String
) {
}