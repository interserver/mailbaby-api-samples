<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\Annotation as DTA;

/**
 * Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
 */
class MailStatsVolume
{
    /**
     * Message counts keyed by destination (envelope &#x60;to&#x60;) email address.
     * @DTA\Data(field="to", nullable=true)
     * @DTA\Strategy(name="Object", options={"type":\App\DTO\Collection3::class})
     * @DTA\Validator(name="TypeCompliant", options={"type":\App\DTO\Collection3::class})
     * @var \App\DTO\Collection3|null
     */
    public $to;

    /**
     * Message counts keyed by sender (envelope &#x60;from&#x60;) email address.
     * @DTA\Data(field="from", nullable=true)
     * @DTA\Strategy(name="Object", options={"type":\App\DTO\Collection4::class})
     * @DTA\Validator(name="TypeCompliant", options={"type":\App\DTO\Collection4::class})
     * @var \App\DTO\Collection4|null
     */
    public $from;

    /**
     * Message counts keyed by originating client IP address.
     * @DTA\Data(field="ip", nullable=true)
     * @DTA\Strategy(name="Object", options={"type":\App\DTO\Collection5::class})
     * @DTA\Validator(name="TypeCompliant", options={"type":\App\DTO\Collection5::class})
     * @var \App\DTO\Collection5|null
     */
    public $ip;

}
