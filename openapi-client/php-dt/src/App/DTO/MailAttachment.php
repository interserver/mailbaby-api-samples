<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
 */
class MailAttachment
{
    /**
     * The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;).
     */
    #[DTA\Data(field: "filename")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $filename = null;

    /**
     * The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
     */
    #[DTA\Data(field: "data")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $data = null;

}
