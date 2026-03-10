package io.swagger.server.model


/**
 * = ErrorMessage =
 *
 * The response body returned when an error occurs.
 *
 * @param code The HTTP-style status code associated with the error. for example: ''400''
 * @param message A human-readable description of the error. for example: ''The specified ID was invalid.''
 */
case class ErrorMessage (
  code: Int,
  message: String
)

