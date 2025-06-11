<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * Parameters for getStats
 */
class GetStatsParameterData
{
    /**
     * The timeframe for the statistics.
     */
    #[DTA\Data(subset: "query", field: "time", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "string"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "string"], subset: "query")]
    public string|null $time = null;

}
