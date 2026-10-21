<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\Annotation as DTA;

/**
 * A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The &#x60;id&#x60; is the numeric identifier used across most API calls.  The &#x60;username&#x60; is always &#x60;mb&lt;id&gt;&#x60; and is the SMTP AUTH username for &#x60;relay.mailbaby.net&#x60;.
 */
class MailOrder
{
    /**
     * The unique numeric ID of the mail order.  Used as the &#x60;id&#x60; parameter on sending calls, log queries, and stats queries.
     * @DTA\Data(field="id")
     * @DTA\Validator(name="Scalar", options={"type":"int"})
     * @var int|null
     */
    public $id;

    /**
     * The current order status.  Only &#x60;active&#x60; orders can be used for sending. &#x60;canceled&#x60; orders are retained for history but cannot send.
     * @DTA\Data(field="status")
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $status;

    /**
     * The SMTP AUTH username for this order, always in the format &#x60;mb&lt;id&gt;&#x60;. Use together with the password from &#x60;GET /mail/{id}&#x60; to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; if needed.
     * @DTA\Data(field="username")
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @DTA\Validator(name="Regex", options={"pattern":"/^mb\\d+$/"})
     * @var string|null
     */
    public $username;

    /**
     * Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
     * @DTA\Data(field="comment", nullable=true)
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $comment;

}
