<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * Parameters for viewMailLog
 */
class ViewMailLogParameterData
{
    /**
     * pass an optional search string for looking up inventory
     */
    #[DTA\Data(subset: "query", field: "search", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "string"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "string"], subset: "query")]
    public string|null $search = null;

    /**
     * maximum number of records to return
     */
    #[DTA\Data(subset: "query", field: "limit", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "int"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "int"], subset: "query")]
    #[DTA\Validator("GreaterThan", ["min" => 1, "inclusive" => true], subset: "query")]
    #[DTA\Validator("LessThan", ["max" => 10000, "inclusive" => true], subset: "query")]
    public int|null $limit = null;

    /**
     * number of records to skip for pagination
     */
    #[DTA\Data(subset: "query", field: "skip", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "int"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "int"], subset: "query")]
    #[DTA\Validator("GreaterThan", ["min" => 0, "inclusive" => true], subset: "query")]
    public int|null $skip = null;

    /**
     * The ID of your mail order this will be sent through.
     */
    #[DTA\Data(subset: "query", field: "id", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "int"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "int"], subset: "query")]
    public int|null $id = null;

}
