<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * The response body returned when an error occurs.
 */
class ErrorMessage
{
    /**
     * The HTTP-style status code associated with the error.
     */
    #[DTA\Data(field: "code")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $code = null;

    /**
     * A human-readable description of the error.
     */
    #[DTA\Data(field: "message")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $message = null;

}
