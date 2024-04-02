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
     * earliest date to get emails in unix timestamp format
     */
    #[DTA\Data(subset: "query", field: "endDate", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "int"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "int"], subset: "query")]
    #[DTA\Validator("GreaterThan", ["min" => 0, "inclusive" => true], subset: "query")]
    #[DTA\Validator("LessThan", ["max" => 9999999999, "inclusive" => true], subset: "query")]
    public int|null $end_date = null;

    /**
     * subject containing this string
     */
    #[DTA\Data(subset: "query", field: "subject", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "string"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "string"], subset: "query")]
    public string|null $subject = null;

    /**
     * originating ip address sending mail
     */
    #[DTA\Data(subset: "query", field: "origin", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "string"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "string"], subset: "query")]
    public string|null $origin = null;

    /**
     * number of records to skip for pagination
     */
    #[DTA\Data(subset: "query", field: "skip", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "int"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "int"], subset: "query")]
    #[DTA\Validator("GreaterThan", ["min" => 0, "inclusive" => true], subset: "query")]
    public int|null $skip = null;

    /**
     * mx record mail was sent to
     */
    #[DTA\Data(subset: "query", field: "mx", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "string"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "string"], subset: "query")]
    public string|null $mx = null;

    /**
     * Header From Email Address
     */
    #[DTA\Data(subset: "query", field: "headerfrom", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "string"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "string"], subset: "query")]
    public string|null $headerfrom = null;

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
     * Reply-To Email Address
     */
    #[DTA\Data(subset: "query", field: "replyto", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "string"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "string"], subset: "query")]
    public string|null $replyto = null;

    /**
     * from email address
     */
    #[DTA\Data(subset: "query", field: "from", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "string"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "string"], subset: "query")]
    public string|null $from = null;

    /**
     * mail id
     */
    #[DTA\Data(subset: "query", field: "mailid", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "string"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "string"], subset: "query")]
    public string|null $mailid = null;

    /**
     * The ID of your mail order this will be sent through.
     */
    #[DTA\Data(subset: "query", field: "id", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "int"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "int"], subset: "query")]
    public int|null $id = null;

    /**
     * to/destination email address
     */
    #[DTA\Data(subset: "query", field: "to", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "string"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "string"], subset: "query")]
    public string|null $to = null;

    /**
     * earliest date to get emails in unix timestamp format
     */
    #[DTA\Data(subset: "query", field: "startDate", nullable: true)]
    #[DTA\Strategy("QueryStringScalar", ["type" => "int"], "query")]
    #[DTA\Validator("QueryStringScalar", ["type" => "int"], subset: "query")]
    #[DTA\Validator("GreaterThan", ["min" => 0, "inclusive" => true], subset: "query")]
    #[DTA\Validator("LessThan", ["max" => 9999999999, "inclusive" => true], subset: "query")]
    public int|null $start_date = null;

}
