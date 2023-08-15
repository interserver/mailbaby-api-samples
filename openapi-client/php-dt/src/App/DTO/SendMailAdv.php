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
    #[DTA\Strategy("Object", ["type" => \App\DTO\EmailAddressName::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\EmailAddressName::class])]
    public \App\DTO\EmailAddressName|null $from = null;

    /**
     * A list of destionation email addresses to send this to
     */
    #[DTA\Data(field: "to")]
    #[DTA\Strategy("Object", ["type" => \App\DTO\Collection10::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\Collection10::class])]
    public \App\DTO\Collection10|null $to = null;

    /**
     * (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
     */
    #[DTA\Data(field: "replyto", nullable: true)]
    #[DTA\Strategy("Object", ["type" => \App\DTO\Collection11::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\Collection11::class])]
    public \App\DTO\Collection11|null $replyto = null;

    /**
     * (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
     */
    #[DTA\Data(field: "cc", nullable: true)]
    #[DTA\Strategy("Object", ["type" => \App\DTO\Collection12::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\Collection12::class])]
    public \App\DTO\Collection12|null $cc = null;

    /**
     * (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
     */
    #[DTA\Data(field: "bcc", nullable: true)]
    #[DTA\Strategy("Object", ["type" => \App\DTO\Collection13::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\Collection13::class])]
    public \App\DTO\Collection13|null $bcc = null;

    /**
     * (optional) File attachments to include in the email.  The file contents must be base64 encoded!
     */
    #[DTA\Data(field: "attachments", nullable: true)]
    #[DTA\Strategy("Object", ["type" => \App\DTO\Collection14::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\Collection14::class])]
    public \App\DTO\Collection14|null $attachments = null;

    /**
     * (optional)  ID of the Mail order within our system to use as the Mail Account.
     */
    #[DTA\Data(field: "id", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $id = null;

}
