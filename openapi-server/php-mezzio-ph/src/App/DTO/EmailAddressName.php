<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\Annotation as DTA;

/**
 * An email contact with an optional display name.  Used in structured address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;) in &#x60;SendMailAdv&#x60;.
 */
class EmailAddressName
{
    /**
     * The email address.
     * @DTA\Data(field="email")
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $email;

    /**
     * Optional display name shown to recipients (e.g. in the &#x60;From:&#x60; header).
     * @DTA\Data(field="name", nullable=true)
     * @DTA\Validator(name="Scalar", options={"type":"string"})
     * @var string|null
     */
    public $name;

}
