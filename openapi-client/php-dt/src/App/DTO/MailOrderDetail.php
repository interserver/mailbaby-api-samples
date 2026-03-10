<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * Extended mail order record including the current SMTP password.  Returned by &#x60;GET /mail/{id}&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; fields can be used to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
 */
class MailOrderDetail
{
    /**
     * The unique numeric ID of the mail order.  Used as the &#x60;id&#x60; parameter on sending calls, log queries, and stats queries.
     */
    #[DTA\Data(field: "id")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $id = null;

    /**
     * The current order status.  Only &#x60;active&#x60; orders can be used for sending. &#x60;canceled&#x60; orders are retained for history but cannot send.
     */
    #[DTA\Data(field: "status")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $status = null;

    /**
     * The SMTP AUTH username for this order, always in the format &#x60;mb&lt;id&gt;&#x60;. Use together with the password from &#x60;GET /mail/{id}&#x60; to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; if needed.
     */
    #[DTA\Data(field: "username")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $username = null;

    /**
     * The current SMTP AUTH password for this mail order.  Use with the &#x60;username&#x60; field to authenticate against &#x60;relay.mailbaby.net:25&#x60;.
     */
    #[DTA\Data(field: "password")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $password = null;

    /**
     * Optional human-readable note associated with the order.
     */
    #[DTA\Data(field: "comment", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $comment = null;

}
