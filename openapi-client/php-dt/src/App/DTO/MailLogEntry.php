<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.
 */
class MailLogEntry
{
    /**
     * Internal auto-increment database row ID.  Not meaningful outside the API.
     */
    #[DTA\Data(field: "_id")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $_id = null;

    /**
     * The relay-assigned mail ID (18–19 hex characters).  This is the value returned as &#x60;text&#x60; by the sending endpoints and accepted as the &#x60;mailid&#x60; filter on &#x60;GET /mail/log&#x60;.
     */
    #[DTA\Data(field: "id")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $id = null;

    /**
     * SMTP envelope &#x60;MAIL FROM&#x60; address (may differ from the &#x60;From:&#x60; header).
     */
    #[DTA\Data(field: "from")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $from = null;

    /**
     * SMTP envelope &#x60;RCPT TO&#x60; address.
     */
    #[DTA\Data(field: "to")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $to = null;

    /**
     * Human-readable creation timestamp in &#x60;YYYY-MM-DD HH:MM:SS&#x60; format.
     */
    #[DTA\Data(field: "created")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $created = null;

    /**
     * Unix timestamp of message acceptance.  Corresponds to the &#x60;startDate&#x60; and &#x60;endDate&#x60; filter parameters on &#x60;GET /mail/log&#x60;.
     */
    #[DTA\Data(field: "time")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $time = null;

    /**
     * The SMTP AUTH username used to submit the message (e.g. &#x60;mb5658&#x60;). Corresponds to the &#x60;username&#x60; field in &#x60;GET /mail&#x60; orders.
     */
    #[DTA\Data(field: "user")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $user = null;

    /**
     * SMTP transaction type negotiated with the relay (e.g. &#x60;ESMTPSA&#x60;).
     */
    #[DTA\Data(field: "transtype")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $transtype = null;

    /**
     * IP address of the client that submitted the message to the relay. Corresponds to the &#x60;origin&#x60; filter parameter on &#x60;GET /mail/log&#x60;.
     */
    #[DTA\Data(field: "origin")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $origin = null;

    /**
     * Relay interface name that accepted the message (e.g. &#x60;feeder&#x60;).
     */
    #[DTA\Data(field: "interface")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $interface = null;

    /**
     * The &#x60;Subject&#x60; header value, if available.
     */
    #[DTA\Data(field: "subject", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $subject = null;

    /**
     * The &#x60;Message-ID&#x60; header value, if present.  Can be used with the &#x60;messageId&#x60; filter on &#x60;GET /mail/log&#x60; for subsequent lookups.
     */
    #[DTA\Data(field: "messageId", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $message_id = null;

    /**
     * The sending zone assigned by the relay for outbound delivery.
     */
    #[DTA\Data(field: "sendingZone", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $sending_zone = null;

    /**
     * Size of the message body in bytes.
     */
    #[DTA\Data(field: "bodySize", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $body_size = null;

    /**
     * Sequence index of this recipient in a multi-recipient message. Starts at 1.
     */
    #[DTA\Data(field: "seq", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $seq = null;

    /**
     * Delivery status flag.  &#x60;1&#x60; &#x3D; successfully delivered to destination MX. &#x60;0&#x60; &#x3D; queued, deferred, or failed.  &#x60;null&#x60; &#x3D; delivery not yet attempted. Corresponds to the &#x60;delivered&#x60; filter parameter on &#x60;GET /mail/log&#x60;.
     */
    #[DTA\Data(field: "delivered", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $delivered = null;

    /**
     * The SMTP response string received from the destination MX server upon delivery attempt (e.g. &#x60;\&quot;250 2.0.0 Ok queued as C91D83E128C\&quot;&#x60;).
     */
    #[DTA\Data(field: "response", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $response = null;

    /**
     * The specific recipient address this delivery record is for.
     */
    #[DTA\Data(field: "recipient", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $recipient = null;

    /**
     * The destination domain.  Corresponds to the &#x60;mx&#x60; filter parameter (which matches &#x60;mxHostname&#x60;, not &#x60;domain&#x60;) on &#x60;GET /mail/log&#x60;.
     */
    #[DTA\Data(field: "domain", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $domain = null;

    /**
     * Whether the queue entry is currently locked for delivery processing.
     */
    #[DTA\Data(field: "locked", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $locked = null;

    /**
     * Millisecond-precision timestamp of the last queue lock acquisition.
     */
    #[DTA\Data(field: "lockTime", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $lock_time = null;

    /**
     * The relay server node assigned to deliver this message.
     */
    #[DTA\Data(field: "assigned", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $assigned = null;

    /**
     * ISO 8601 timestamp when the message was placed into the delivery queue.
     */
    #[DTA\Data(field: "queued", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $queued = null;

    /**
     * The MX hostname the relay connected to for delivery.  Corresponds to the &#x60;mx&#x60; filter parameter on &#x60;GET /mail/log&#x60;.
     */
    #[DTA\Data(field: "mxHostname", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $mx_hostname = null;

}
