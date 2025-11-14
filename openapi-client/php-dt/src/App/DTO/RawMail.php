<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * Raw Email Object
 */
class RawMail
{
    /**
     * The entire email contents
     */
    #[DTA\Data(field: "raw_email")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $raw_email = null;

}
