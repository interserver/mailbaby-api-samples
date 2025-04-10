<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * The data for a email deny rule record.
 */
class DenyRuleRecord
{
    /**
     * The type of deny rule.
     */
    #[DTA\Data(field: "type")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $type = null;

    /**
     * The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
     */
    #[DTA\Data(field: "data")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $data = null;

    /**
     * The deny rule Id number.
     */
    #[DTA\Data(field: "id")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $id = null;

    /**
     * the date the rule was created.
     */
    #[DTA\Data(field: "created")]
    #[DTA\Strategy("DateTime")]
    #[DTA\Validator("DateTime")]
    public \DateTimeInterface|null $created = null;

    /**
     * Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
     */
    #[DTA\Data(field: "user", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $user = null;

}
