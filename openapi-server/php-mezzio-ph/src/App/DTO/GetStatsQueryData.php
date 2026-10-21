<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\Annotation as DTA;

/**
 * Query parameters for getStats
 */
class GetStatsQueryData
{
    /**
     * The time window to scope &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics. Does not affect &#x60;usage&#x60; or &#x60;cost&#x60;, which are always calculated over the current billing cycle. Defaults to &#x60;1h&#x60;.
     * @DTA\Data(field="time", nullable=true)
     * @DTA\Strategy(name="QueryStringScalar", options={"type":"string"})
     * @DTA\Validator(name="QueryStringScalar", options={"type":"string"})
     * @var string|null
     */
    public $time;

}
