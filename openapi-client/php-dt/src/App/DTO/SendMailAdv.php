<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * Details for an Email
 */
class SendMailAdv
{
    /**
     * The subject or title of the email
     */
    #[DTA\Data(field: "subject")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $subject = null;

    /**
     * The main email contents.
     */
    #[DTA\Data(field: "body")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $body = null;

    #[DTA\Data(field: "from")]
    #[DTA\Strategy("Object", ["type" => \App\DTO\EmailAddressTypes::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\EmailAddressTypes::class])]
    public \App\DTO\EmailAddressTypes|null $from = null;

    #[DTA\Data(field: "to")]
    #[DTA\Strategy("Object", ["type" => \App\DTO\EmailAddressesTypes::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\EmailAddressesTypes::class])]
    public \App\DTO\EmailAddressesTypes|null $to = null;

    #[DTA\Data(field: "replyto", nullable: true)]
    #[DTA\Strategy("Object", ["type" => \App\DTO\EmailAddressesTypes::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\EmailAddressesTypes::class])]
    public \App\DTO\EmailAddressesTypes|null $replyto = null;

    #[DTA\Data(field: "cc", nullable: true)]
    #[DTA\Strategy("Object", ["type" => \App\DTO\EmailAddressesTypes::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\EmailAddressesTypes::class])]
    public \App\DTO\EmailAddressesTypes|null $cc = null;

    #[DTA\Data(field: "bcc", nullable: true)]
    #[DTA\Strategy("Object", ["type" => \App\DTO\EmailAddressesTypes::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\EmailAddressesTypes::class])]
    public \App\DTO\EmailAddressesTypes|null $bcc = null;

    /**
     * (optional) File attachments to include in the email.  The file contents must be base64 encoded!
     */
    #[DTA\Data(field: "attachments", nullable: true)]
    #[DTA\Strategy("Object", ["type" => \App\DTO\Collection4::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\Collection4::class])]
    public \App\DTO\Collection4|null $attachments = null;

    /**
     * (optional)  ID of the Mail order within our system to use as the Mail Account.
     */
    #[DTA\Data(field: "id", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $id = null;

}
