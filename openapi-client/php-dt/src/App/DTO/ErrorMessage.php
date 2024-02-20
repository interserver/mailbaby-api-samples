<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * The resposne when an error occurs.
 */
class ErrorMessage
{
    /**
     * The response code associated with the error.
     */
    #[DTA\Data(field: "code")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $code = null;

    /**
     * The details or description of the error.
     */
    #[DTA\Data(field: "message")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $message = null;

}
