<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * Raw Email Object
 */
class SendMailRaw
{
    /**
     * The entire email contents
     */
    #[DTA\Data(field: "raw_email")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $raw_email = null;

    /**
     * Optional order id
     */
    #[DTA\Data(field: "id", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $id = null;

}
