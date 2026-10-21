<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\Annotation as DTA;

/**
 * Request body for &#x60;POST /mail/send&#x60;.  Sends a simple single-recipient message. HTML detection is automatic — if &#x60;body&#x60; contains HTML tags the message is sent as &#x60;text/html&#x60;; otherwise as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is automatically set as both the &#x60;From&#x60; and &#x60;Reply-To&#x60; headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use &#x60;POST /mail/advsend&#x60; instead.
 */
class SendMail
{
    /**
     * @DTA\Data(field="to")
     * @DTA\Strategy(name="Object", options={"type":\App\DTO\SendMailTo::class})
     * @DTA\Validator(name="TypeCompliant", options={"type":\App\DTO\SendMailTo::class})
     * @var \App\DTO\SendMailTo|null
     */
    public $to;

    /**
     * The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order.
     * @DTA\Data(field="from")
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $from;

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
     * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.
     * @DTA\Data(field="id", nullable=true)
     * @DTA\Validator(name="Scalar", options={"type":"int"})
     * @var int|null
     */
    public $id;

}
