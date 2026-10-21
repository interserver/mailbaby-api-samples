<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\Annotation as DTA;

/**
 * Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.
 */
class SendMailAdv
{
    /**
     * The subject line of the email.
     * @DTA\Data(field="subject")
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $subject;

    /**
     * The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.
     * @DTA\Data(field="body")
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $body;

    /**
     * The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; object.
     * @DTA\Data(field="from")
     * @DTA\Strategy(name="Object", options={"type":\App\DTO\EmailAddressTypes::class})
     * @DTA\Validator(name="TypeCompliant", options={"type":\App\DTO\EmailAddressTypes::class})
     * @var \App\DTO\EmailAddressTypes|null
     */
    public $from;

    /**
     * One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
     * @DTA\Data(field="to")
     * @DTA\Strategy(name="Object", options={"type":\App\DTO\EmailAddressesTypes::class})
     * @DTA\Validator(name="TypeCompliant", options={"type":\App\DTO\EmailAddressesTypes::class})
     * @var \App\DTO\EmailAddressesTypes|null
     */
    public $to;

    /**
     * Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;.
     * @DTA\Data(field="replyto", nullable=true)
     * @DTA\Strategy(name="Object", options={"type":\App\DTO\EmailAddressesTypes::class})
     * @DTA\Validator(name="TypeCompliant", options={"type":\App\DTO\EmailAddressesTypes::class})
     * @var \App\DTO\EmailAddressesTypes|null
     */
    public $replyto;

    /**
     * Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients.
     * @DTA\Data(field="cc", nullable=true)
     * @DTA\Strategy(name="Object", options={"type":\App\DTO\EmailAddressesTypes::class})
     * @DTA\Validator(name="TypeCompliant", options={"type":\App\DTO\EmailAddressesTypes::class})
     * @var \App\DTO\EmailAddressesTypes|null
     */
    public $cc;

    /**
     * Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
     * @DTA\Data(field="bcc", nullable=true)
     * @DTA\Strategy(name="Object", options={"type":\App\DTO\EmailAddressesTypes::class})
     * @DTA\Validator(name="TypeCompliant", options={"type":\App\DTO\EmailAddressesTypes::class})
     * @var \App\DTO\EmailAddressesTypes|null
     */
    public $bcc;

    /**
     * Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name.
     * @DTA\Data(field="attachments", nullable=true)
     * @DTA\Strategy(name="Object", options={"type":\App\DTO\Collection1::class})
     * @DTA\Validator(name="TypeCompliant", options={"type":\App\DTO\Collection1::class})
     * @var \App\DTO\Collection1|null
     */
    public $attachments;

    /**
     * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.
     * @DTA\Data(field="id", nullable=true)
     * @DTA\Validator(name="Scalar", options={"type":"int"})
     * @var int|null
     */
    public $id;

}
