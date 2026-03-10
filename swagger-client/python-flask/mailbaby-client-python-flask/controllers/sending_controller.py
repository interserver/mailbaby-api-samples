import connexion
import six

from mailbaby-client-python-flask.models.email_address_types import EmailAddressTypes  # noqa: E501
from mailbaby-client-python-flask.models.email_addresses_types import EmailAddressesTypes  # noqa: E501
from mailbaby-client-python-flask.models.error_message import ErrorMessage  # noqa: E501
from mailbaby-client-python-flask.models.generic_response import GenericResponse  # noqa: E501
from mailbaby-client-python-flask.models.mail_attachment import MailAttachment  # noqa: E501
from mailbaby-client-python-flask.models.send_mail import SendMail  # noqa: E501
from mailbaby-client-python-flask.models.send_mail_adv import SendMailAdv  # noqa: E501
from mailbaby-client-python-flask.models.send_mail_raw import SendMailRaw  # noqa: E501
from mailbaby-client-python-flask.models.send_mail_to import SendMailTo  # noqa: E501
from mailbaby-client-python-flask import util


def raw_mail(body):  # noqa: E501
    """Sends a raw RFC 822 email

    Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The &#x60;From&#x60; and recipient addresses are parsed automatically from the message headers (&#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, &#x60;Bcc&#x60;).  You do **not** need to specify them separately.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record.  # noqa: E501

    :param body: 
    :type body: dict | bytes

    :rtype: GenericResponse
    """
    if connexion.request.is_json:
        body = SendMailRaw.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def raw_mail(raw_email, id):  # noqa: E501
    """Sends a raw RFC 822 email

    Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The &#x60;From&#x60; and recipient addresses are parsed automatically from the message headers (&#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, &#x60;Bcc&#x60;).  You do **not** need to specify them separately.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record.  # noqa: E501

    :param raw_email: 
    :type raw_email: str
    :param id: 
    :type id: int

    :rtype: GenericResponse
    """
    return 'do some magic!'


def send_adv_mail(subject, body, _from, to, replyto, cc, bcc, attachments, id):  # noqa: E501
    """Sends an Email with Advanced Options

    Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.  **Content-type flexibility** — the request body may be submitted as either &#x60;application/x-www-form-urlencoded&#x60; or &#x60;application/json&#x60;.  When using form encoding, address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) accept both a plain RFC 822 comma-separated string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;, jane@example.com\&quot;&#x60;) and the structured &#x60;[{\&quot;email\&quot;:\&quot;...\&quot;,\&quot;name\&quot;:\&quot;...\&quot;}]&#x60; array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if &#x60;body&#x60; contains HTML tags the &#x60;Content-Type&#x60; is set to &#x60;text/html&#x60;; otherwise &#x60;text/plain&#x60;.  **Attachments** must be base64-encoded.  Each attachment requires at least a &#x60;data&#x60; field; the optional &#x60;filename&#x60; field controls the attachment name shown to recipients.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response &#x60;text&#x60; field contains the relay transaction ID which can be looked up in &#x60;GET /mail/log&#x60; via the &#x60;mailid&#x60; query parameter.  ## Examples  ### Form — basic string addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\   -d &#x27;subject&#x3D;Welcome&#x27; \\   -d &#x27;body&#x3D;Hello&#x27; \\   -d from&#x3D;user@domain.com \\   -d to&#x3D;support@interserver.net &#x60;&#x60;&#x60; ### Form — RFC 822 named addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\   -d &#x27;subject&#x3D;Welcome&#x27; \\   -d &#x27;body&#x3D;Hello&#x27; \\   -d &#x27;from&#x3D;Joe &lt;user@domain.com&gt;&#x27; \\   -d &#x27;to&#x3D;Jane &lt;support@interserver.net&gt;&#x27; &#x60;&#x60;&#x60; ### Form — multiple recipients as array &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\   -d &#x27;subject&#x3D;Welcome&#x27; -d &#x27;body&#x3D;Hello&#x27; \\   -d from&#x3D;user@domain.com \\   -d &#x27;to[0][name]&#x3D;Joe&#x27; -d &#x27;to[0][email]&#x3D;support@interserver.net&#x27; \\   -d &#x27;to[1][name]&#x3D;Jane&#x27; -d &#x27;to[1][email]&#x3D;jane@interserver.net&#x27; &#x60;&#x60;&#x60; ### JSON — structured objects &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -d &#x27;{     \&quot;subject\&quot;: \&quot;Welcome\&quot;,     \&quot;body\&quot;: \&quot;&lt;h1&gt;Hello&lt;/h1&gt;\&quot;,     \&quot;from\&quot;: {\&quot;email\&quot;: \&quot;user@domain.com\&quot;, \&quot;name\&quot;: \&quot;Sender Name\&quot;},     \&quot;to\&quot;: [{\&quot;email\&quot;: \&quot;joe@client.com\&quot;, \&quot;name\&quot;: \&quot;Joe Client\&quot;}],     \&quot;cc\&quot;: [{\&quot;email\&quot;: \&quot;manager@client.com\&quot;}],     \&quot;attachments\&quot;: [{\&quot;filename\&quot;: \&quot;report.pdf\&quot;, \&quot;data\&quot;: \&quot;BASE64_DATA\&quot;}]   }&#x27; &#x60;&#x60;&#x60;  # noqa: E501

    :param subject: 
    :type subject: str
    :param body: 
    :type body: str
    :param _from: 
    :type _from: dict | bytes
    :param to: 
    :type to: dict | bytes
    :param replyto: 
    :type replyto: dict | bytes
    :param cc: 
    :type cc: dict | bytes
    :param bcc: 
    :type bcc: dict | bytes
    :param attachments: 
    :type attachments: list | bytes
    :param id: 
    :type id: int

    :rtype: GenericResponse
    """
    if connexion.request.is_json:
        _from = EmailAddressTypes.from_dict(connexion.request.get_json())  # noqa: E501
    if connexion.request.is_json:
        to = EmailAddressesTypes.from_dict(connexion.request.get_json())  # noqa: E501
    if connexion.request.is_json:
        replyto = EmailAddressesTypes.from_dict(connexion.request.get_json())  # noqa: E501
    if connexion.request.is_json:
        cc = EmailAddressesTypes.from_dict(connexion.request.get_json())  # noqa: E501
    if connexion.request.is_json:
        bcc = EmailAddressesTypes.from_dict(connexion.request.get_json())  # noqa: E501
    if connexion.request.is_json:
        attachments = [MailAttachment.from_dict(d) for d in connexion.request.get_json()]  # noqa: E501
    return 'do some magic!'


def send_adv_mail(body):  # noqa: E501
    """Sends an Email with Advanced Options

    Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.  **Content-type flexibility** — the request body may be submitted as either &#x60;application/x-www-form-urlencoded&#x60; or &#x60;application/json&#x60;.  When using form encoding, address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) accept both a plain RFC 822 comma-separated string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;, jane@example.com\&quot;&#x60;) and the structured &#x60;[{\&quot;email\&quot;:\&quot;...\&quot;,\&quot;name\&quot;:\&quot;...\&quot;}]&#x60; array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if &#x60;body&#x60; contains HTML tags the &#x60;Content-Type&#x60; is set to &#x60;text/html&#x60;; otherwise &#x60;text/plain&#x60;.  **Attachments** must be base64-encoded.  Each attachment requires at least a &#x60;data&#x60; field; the optional &#x60;filename&#x60; field controls the attachment name shown to recipients.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response &#x60;text&#x60; field contains the relay transaction ID which can be looked up in &#x60;GET /mail/log&#x60; via the &#x60;mailid&#x60; query parameter.  ## Examples  ### Form — basic string addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\   -d &#x27;subject&#x3D;Welcome&#x27; \\   -d &#x27;body&#x3D;Hello&#x27; \\   -d from&#x3D;user@domain.com \\   -d to&#x3D;support@interserver.net &#x60;&#x60;&#x60; ### Form — RFC 822 named addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\   -d &#x27;subject&#x3D;Welcome&#x27; \\   -d &#x27;body&#x3D;Hello&#x27; \\   -d &#x27;from&#x3D;Joe &lt;user@domain.com&gt;&#x27; \\   -d &#x27;to&#x3D;Jane &lt;support@interserver.net&gt;&#x27; &#x60;&#x60;&#x60; ### Form — multiple recipients as array &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\   -d &#x27;subject&#x3D;Welcome&#x27; -d &#x27;body&#x3D;Hello&#x27; \\   -d from&#x3D;user@domain.com \\   -d &#x27;to[0][name]&#x3D;Joe&#x27; -d &#x27;to[0][email]&#x3D;support@interserver.net&#x27; \\   -d &#x27;to[1][name]&#x3D;Jane&#x27; -d &#x27;to[1][email]&#x3D;jane@interserver.net&#x27; &#x60;&#x60;&#x60; ### JSON — structured objects &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -d &#x27;{     \&quot;subject\&quot;: \&quot;Welcome\&quot;,     \&quot;body\&quot;: \&quot;&lt;h1&gt;Hello&lt;/h1&gt;\&quot;,     \&quot;from\&quot;: {\&quot;email\&quot;: \&quot;user@domain.com\&quot;, \&quot;name\&quot;: \&quot;Sender Name\&quot;},     \&quot;to\&quot;: [{\&quot;email\&quot;: \&quot;joe@client.com\&quot;, \&quot;name\&quot;: \&quot;Joe Client\&quot;}],     \&quot;cc\&quot;: [{\&quot;email\&quot;: \&quot;manager@client.com\&quot;}],     \&quot;attachments\&quot;: [{\&quot;filename\&quot;: \&quot;report.pdf\&quot;, \&quot;data\&quot;: \&quot;BASE64_DATA\&quot;}]   }&#x27; &#x60;&#x60;&#x60;  # noqa: E501

    :param body: 
    :type body: dict | bytes

    :rtype: GenericResponse
    """
    if connexion.request.is_json:
        body = SendMailAdv.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def send_mail(to, _from, subject, body, id):  # noqa: E501
    """Sends an Email

    Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.  **HTML detection** is automatic — if the &#x60;body&#x60; value contains any HTML tags the message will be sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is also automatically set as the &#x60;Reply-To&#x60; header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use &#x60;POST /mail/advsend&#x60; instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use &#x60;POST /mail/rawsend&#x60;.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record.  # noqa: E501

    :param to: 
    :type to: dict | bytes
    :param _from: 
    :type _from: str
    :param subject: 
    :type subject: str
    :param body: 
    :type body: str
    :param id: 
    :type id: int

    :rtype: GenericResponse
    """
    if connexion.request.is_json:
        to = SendMailTo.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def send_mail(body):  # noqa: E501
    """Sends an Email

    Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.  **HTML detection** is automatic — if the &#x60;body&#x60; value contains any HTML tags the message will be sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is also automatically set as the &#x60;Reply-To&#x60; header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use &#x60;POST /mail/advsend&#x60; instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use &#x60;POST /mail/rawsend&#x60;.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record.  # noqa: E501

    :param body: 
    :type body: dict | bytes

    :rtype: GenericResponse
    """
    if connexion.request.is_json:
        body = SendMail.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'
