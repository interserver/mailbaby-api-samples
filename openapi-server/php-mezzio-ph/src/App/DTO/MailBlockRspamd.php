<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\Annotation as DTA;

/**
 * A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
 */
class MailBlockRspamd
{
    /**
     * The sender email address.  Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist the sender.
     * @DTA\Data(field="from")
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $from;

    /**
     * The suspicious subject pattern that triggered the block.
     * @DTA\Data(field="subject")
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $subject;

}
