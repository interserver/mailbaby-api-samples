<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\Annotation as DTA;

/**
 * The response body returned when an error occurs.
 */
class ErrorMessage
{
    /**
     * The HTTP-style status code associated with the error.
     * @DTA\Data(field="code")
     * @DTA\Validator(name="Scalar", options={"type":"int"})
     * @var int|null
     */
    public $code;

    /**
     * A human-readable description of the error.
     * @DTA\Data(field="message")
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $message;

}
