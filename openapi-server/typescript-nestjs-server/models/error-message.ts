

/**
 * The response body returned when an error occurs.
 */
export interface ErrorMessage { 
  /**
   * The HTTP-style status code associated with the error.
   */
  code: number;
  /**
   * A human-readable description of the error.
   */
  message: string;
}

