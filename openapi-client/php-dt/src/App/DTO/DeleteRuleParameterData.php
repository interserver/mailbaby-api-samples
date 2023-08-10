<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * Parameters for deleteRule
 */
class DeleteRuleParameterData
{
    /**
     * The ID of the Rules entry.
     */
    #[DTA\Data(subset: "path", field: "ruleId")]
    #[DTA\Strategy("QueryStringScalar", ["type" => "int"], "path")]
    #[DTA\Validator("QueryStringScalar", ["type" => "int"], subset: "path")]
    public int|null $rule_id = null;

}
