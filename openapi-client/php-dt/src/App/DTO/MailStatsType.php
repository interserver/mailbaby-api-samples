<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * Account usage statistics returned by &#x60;GET /mail/stats&#x60;.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 */
class MailStatsType
{
    /**
     * The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover.
     */
    #[DTA\Data(field: "time", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $time = null;

    /**
     * Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value.
     */
    #[DTA\Data(field: "usage", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $usage = null;

    /**
     * The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;).
     */
    #[DTA\Data(field: "currency", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $currency = null;

    /**
     * Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
     */
    #[DTA\Data(field: "cost", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "float"])]
    public float|null $cost = null;

    /**
     * Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue.
     */
    #[DTA\Data(field: "received", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $received = null;

    /**
     * Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;.
     */
    #[DTA\Data(field: "sent", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $sent = null;

    #[DTA\Data(field: "volume", nullable: true)]
    #[DTA\Strategy("Object", ["type" => \App\DTO\MailStatsVolume::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\MailStatsVolume::class])]
    public \App\DTO\MailStatsVolume|null $volume = null;

}
