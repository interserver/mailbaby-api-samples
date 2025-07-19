package io.swagger.server.model


/**
 * @param status  for example: ''ok''
 * @param text  for example: ''The command completed successfully.''
 */
case class GenericResponse (
  status: Option[String],
  text: Option[String]
)

