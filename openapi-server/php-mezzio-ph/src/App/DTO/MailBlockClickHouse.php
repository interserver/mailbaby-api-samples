<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\Annotation as DTA;

/**
 * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
 */
class MailBlockClickHouse
{
    /**
     * The date the block event was recorded.
     * @DTA\Data(field="date")
     * @DTA\Strategy(name="Date")
     * @DTA\Validator(name="Date")
     * @var \DateTime|null
     */
    public $date;

    /**
     * The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it.
     * @DTA\Data(field="from")
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $from;

    /**
     * The &#x60;Subject&#x60; header of the blocked message.
     * @DTA\Data(field="subject")
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $subject;

    /**
     * The serialized list of recipients of the blocked message.
     * @DTA\Data(field="to")
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $to;

    /**
     * The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present.
     * @DTA\Data(field="messageId", nullable=true)
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $message_id;

}
