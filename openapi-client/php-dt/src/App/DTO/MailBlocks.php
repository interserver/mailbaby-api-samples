<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * The listing of blocked emails.
 */
class MailBlocks
{
    #[DTA\Data(field: "local")]
    #[DTA\Strategy("Object", ["type" => \App\DTO\Collection1::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\Collection1::class])]
    public \App\DTO\Collection1|null $local = null;

    #[DTA\Data(field: "mbtrap")]
    #[DTA\Strategy("Object", ["type" => \App\DTO\Collection2::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\Collection2::class])]
    public \App\DTO\Collection2|null $mbtrap = null;

    #[DTA\Data(field: "subject")]
    #[DTA\Strategy("Object", ["type" => \App\DTO\Collection3::class])]
    #[DTA\Validator("TypeCompliant", ["type" => \App\DTO\Collection3::class])]
    public \App\DTO\Collection3|null $subject = null;

}
