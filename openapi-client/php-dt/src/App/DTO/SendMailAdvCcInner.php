<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * An Email Contact
 */
class SendMailAdvCcInner
{
    /**
     * The email address
     */
    #[DTA\Data(field: "email")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $email = null;

    /**
     * (optional) Name to use for the CC contact.
     */
    #[DTA\Data(field: "name", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $name = null;

}
