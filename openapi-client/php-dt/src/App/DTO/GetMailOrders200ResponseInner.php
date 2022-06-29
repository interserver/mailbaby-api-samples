<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

class GetMailOrders200ResponseInner
{
    #[DTA\Data(field: "id")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $id = null;

    #[DTA\Data(field: "status")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $status = null;

    #[DTA\Data(field: "username")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $username = null;

    #[DTA\Data(field: "password", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $password = null;

    #[DTA\Data(field: "comment", nullable: true)]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $comment = null;

}
