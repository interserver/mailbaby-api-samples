<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\Annotation as DTA;

/**
 * A date/time value accepted as either a Unix timestamp (integer seconds since epoch) or a date string parseable by &#x60;strtotime()&#x60; (e.g. &#x60;2024-01-15&#x60;, &#x60;last monday&#x60;).
 */
class DateOrTimestamp
{
}
