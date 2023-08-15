<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

class DenyRuleRecordAllOf
{
    /**
     * The deny rule Id number.
     */
    #[DTA\Data(field: "id")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $id = null;

    /**
     * the date the rule was created.
     */
    #[DTA\Data(field: "created")]
    #[DTA\Strategy("DateTime")]
    #[DTA\Validator("Date", ["format" => \DateTime::RFC3339])]
    public \DateTime|null $created = null;

}
