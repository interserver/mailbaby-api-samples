<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * The complete set of blocked addresses and message patterns returned by &#x60;GET /mail/blocks&#x60;.  Three independent block sources are combined into one response. Use &#x60;POST /mail/blocks/delete&#x60; with a &#x60;from&#x60; address from any entry to delist it.
 */
class MailBlocks
{
    /**
     * Messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
     */
    #[DTA\Data(field: "local")]
    #[DTA\Strategy("Object", ["type" => \App\DTO\Collection6::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\Collection6::class])]
    public \App\DTO\Collection6|null $local = null;

    /**
     * Messages flagged by the &#x60;MBTRAP&#x60; rspamd rule in the last 5 days. These triggered MailBaby&#39;s honeypot / trap address detection.
     */
    #[DTA\Data(field: "mbtrap")]
    #[DTA\Strategy("Object", ["type" => \App\DTO\Collection7::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\Collection7::class])]
    public \App\DTO\Collection7|null $mbtrap = null;

    /**
     * Senders whose messages contained spam-indicative subjects (containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with more than 4 occurrences of the same subject in the last 3 days.
     */
    #[DTA\Data(field: "subject")]
    #[DTA\Strategy("Object", ["type" => \App\DTO\Collection8::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\Collection8::class])]
    public \App\DTO\Collection8|null $subject = null;

}
