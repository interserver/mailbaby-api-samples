<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * The information to use for the From address in the email. from.
 */
class SendMailAdvFrom
{
    /**
     * The email address
     */
    #[DTA\Data(field: "email")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $email = null;

    /**
     * (optional) Name to use for the sending contact.
     */
    #[DTA\Data(field: "name", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $name = null;

}
