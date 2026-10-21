<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\Annotation as DTA;

/**
 * Paginated mail log response returned by &#x60;GET /mail/log&#x60;.  Contains the full matched count (&#x60;total&#x60;) plus a page of &#x60;MailLogEntry&#x60; records.  Use &#x60;skip&#x60; and &#x60;limit&#x60; to page through large result sets.
 */
class MailLog
{
    /**
     * Total number of log entries that match the supplied filters, regardless of &#x60;skip&#x60; and &#x60;limit&#x60;.  Use this to calculate the number of pages: &#x60;ceil(total / limit)&#x60;.
     * @DTA\Data(field="total")
     * @DTA\Validator(name="Scalar", options={"type":"int"})
     * @var int|null
     */
    public $total;

    /**
     * The &#x60;skip&#x60; value used for this page (echoed from the request).
     * @DTA\Data(field="skip")
     * @DTA\Validator(name="Scalar", options={"type":"int"})
     * @var int|null
     */
    public $skip;

    /**
     * The &#x60;limit&#x60; value used for this page (echoed from the request).
     * @DTA\Data(field="limit")
     * @DTA\Validator(name="Scalar", options={"type":"int"})
     * @var int|null
     */
    public $limit;

    /**
     * @DTA\Data(field="emails")
     * @DTA\Strategy(name="Object", options={"type":\App\DTO\Collection2::class})
     * @DTA\Validator(name="TypeCompliant", options={"type":\App\DTO\Collection2::class})
     * @var \App\DTO\Collection2|null
     */
    public $emails;

}
