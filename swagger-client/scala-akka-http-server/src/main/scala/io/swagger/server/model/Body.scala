package io.swagger.server.model


/**
 * @param subject The Subject of the email for example: ''test subject''
 * @param body The contents of the email for example: ''test body''
 * @param from The email address of who this email will be sent from. for example: ''me@domain.com''
 * @param to The email address of who this email will be sent to. for example: ''my@domain.com''
 * @param id The ID of your mail order this will be sent through. for example: ''5000''
 * @param toName The name or title of who this email is being sent to. for example: ''John Doe''
 * @param fromName The name or title of who this email is being sent from. for example: ''Jane Doe''
 */
case class Body (
  subject: String,
  body: String,
  from: String,
  to: String,
  id: Option[Int],
  toName: Option[String],
  fromName: Option[String]
)

