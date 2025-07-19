package io.swagger.server.model


/**
 * = ErrorMessage =
 *
 * The resposne when an error occurs.
 *
 * @param code The response code associated with the error. for example: ''400''
 * @param message The details or description of the error. for example: ''There was an error.''
 */
case class ErrorMessage (
  code: Int,
  message: String
)

