<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.
 */
class SendMailAdv
{
    /**
     * The subject line of the email.
     */
    #[DTA\Data(field: "subject")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $subject = null;

    /**
     * The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.
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
     * Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name.
     */
    #[DTA\Data(field: "attachments", nullable: true)]
    #[DTA\Strategy("Object", ["type" => \App\DTO\Collection1::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\Collection1::class])]
    public \App\DTO\Collection1|null $attachments = null;

    /**
     * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.
     */
    #[DTA\Data(field: "id", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $id = null;

}
