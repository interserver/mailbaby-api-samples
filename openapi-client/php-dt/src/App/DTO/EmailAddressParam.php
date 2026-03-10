<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * A single email address parameter used as the body of &#x60;POST /mail/blocks/delete&#x60;.
 */
class EmailAddressParam
{
    /**
     * The email address to delist from all block lists.
     */
    #[DTA\Data(field: "email")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $email = null;

}
