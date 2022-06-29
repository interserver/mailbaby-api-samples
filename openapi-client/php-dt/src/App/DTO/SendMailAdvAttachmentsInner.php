<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * A File attachment for an email
 */
class SendMailAdvAttachmentsInner
{
    /**
     * Contents of the attached file (must be base64 encoded)
     */
    #[DTA\Data(field: "data")]
    #[DTA\Strategy("Object", ["type" => \SplFileObject::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \SplFileObject::class])]
    public \SplFileObject|null $data = null;

    /**
     * (optional) Filename to specify for the attachment.
     */
    #[DTA\Data(field: "filename", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $filename = null;

}
