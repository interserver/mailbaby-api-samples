<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\Annotation as DTA;

/**
 * A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
 */
class MailAttachment
{
    /**
     * The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;).
     * @DTA\Data(field="filename")
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $filename;

    /**
     * The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
     * @DTA\Data(field="data")
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $data;

}
