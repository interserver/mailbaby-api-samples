<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\PhpAttribute as DTA;

/**
 * An email record
 */
class MailLogEntry
{
    /**
     * internal db id
     */
    #[DTA\Data(field: "_id")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $_id = null;

    /**
     * mail id
     */
    #[DTA\Data(field: "id")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $id = null;

    /**
     * from address
     */
    #[DTA\Data(field: "from")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $from = null;

    /**
     * to address
     */
    #[DTA\Data(field: "to")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $to = null;

    /**
     * email subject
     */
    #[DTA\Data(field: "subject")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $subject = null;

    /**
     * message id
     */
    #[DTA\Data(field: "messageId")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $message_id = null;

    /**
     * creation date
     */
    #[DTA\Data(field: "created")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $created = null;

    /**
     * creation timestamp
     */
    #[DTA\Data(field: "time")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $time = null;

    /**
     * user account
     */
    #[DTA\Data(field: "user")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $user = null;

    /**
     * transaction type
     */
    #[DTA\Data(field: "transtype")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $transtype = null;

    /**
     * transaction host
     */
    #[DTA\Data(field: "transhost")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $transhost = null;

    /**
     * origin host
     */
    #[DTA\Data(field: "originhost")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $originhost = null;

    /**
     * origin ip
     */
    #[DTA\Data(field: "origin")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $origin = null;

    /**
     * interface name
     */
    #[DTA\Data(field: "interface")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $interface = null;

    /**
     * date processed
     */
    #[DTA\Data(field: "date")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $date = null;

    /**
     * sending zone
     */
    #[DTA\Data(field: "sendingZone")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $sending_zone = null;

    /**
     * email body size in bytes
     */
    #[DTA\Data(field: "bodySize")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $body_size = null;

    /**
     * md5 sum of the email
     */
    #[DTA\Data(field: "sourceMd5")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $source_md5 = null;

    /**
     * delivery sequency
     */
    #[DTA\Data(field: "seq")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $seq = null;

    /**
     * to address domain
     */
    #[DTA\Data(field: "domain")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $domain = null;

    /**
     * email receiver address
     */
    #[DTA\Data(field: "recipient")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $recipient = null;

    /**
     * locked status
     */
    #[DTA\Data(field: "locked")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $locked = null;

    /**
     * lock timestamp
     */
    #[DTA\Data(field: "lockTime")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $lock_time = null;

    /**
     * assigned server
     */
    #[DTA\Data(field: "assigned")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $assigned = null;

    /**
     * queued timestamp
     */
    #[DTA\Data(field: "queued")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $queued = null;

    /**
     * lock id
     */
    #[DTA\Data(field: "_lock")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $_lock = null;

    /**
     * logger
     */
    #[DTA\Data(field: "logger")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $logger = null;

    /**
     * mx port number
     */
    #[DTA\Data(field: "mxPort")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $mx_port = null;

    /**
     * connection key
     */
    #[DTA\Data(field: "connectionKey")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $connection_key = null;

    /**
     * mx hostname
     */
    #[DTA\Data(field: "mxHostname")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $mx_hostname = null;

    /**
     * body hash
     */
    #[DTA\Data(field: "sentBodyHash")]
    #[DTA\Validator("Scalar", ["type" => "string"])]
    public string|null $sent_body_hash = null;

    /**
     * sent body size in bytes
     */
    #[DTA\Data(field: "sentBodySize")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $sent_body_size = null;

    /**
     * md5 checksum matching result
     */
    #[DTA\Data(field: "md5Match")]
    #[DTA\Validator("Scalar", ["type" => "int"])]
    public int|null $md5_match = null;

}
