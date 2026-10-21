# coding: utf-8

from typing import Dict, List  # noqa: F401
import importlib
import pkgutil

from MailBabyPythonFastapi.apis.sending_api_base import BaseSendingApi
import MailBabyPythonFastapi.impl

from fastapi import (  # noqa: F401
    APIRouter,
    Body,
    Cookie,
    Depends,
    Form,
    Header,
    HTTPException,
    Path,
    Query,
    Response,
    Security,
    status,
)

from pydantic import Field, StrictInt, StrictStr
from typing import Any, List, Optional
from typing_extensions import Annotated
from MailBabyPythonFastapi.models.error_message import ErrorMessage
from MailBabyPythonFastapi.models.generic_response import GenericResponse
from MailBabyPythonFastapi.models.mail_attachment import MailAttachment
from MailBabyPythonFastapi.models.send_mail_raw import SendMailRaw
from MailBabyPythonFastapi.models.send_mail_to import SendMailTo
from MailBabyPythonFastapi.models.extra_models import TokenModel  # noqa: F401
from MailBabyPythonFastapi.security_api import get_token_apiKeyAuth

router = APIRouter()

ns_pkg = MailBabyPythonFastapi.impl
for _, name, _ in pkgutil.iter_modules(ns_pkg.__path__, ns_pkg.__name__ + "."):
    importlib.import_module(name)


@router.post(
    "/mail/send",
    responses={
        200: {"model": GenericResponse, "description": "Email accepted for delivery"},
        400: {"model": ErrorMessage, "description": "Bad request — one or more input parameters were missing or invalid."},
        401: {"model": ErrorMessage, "description": "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)."},
        404: {"model": ErrorMessage, "description": "The specified resource was not found or does not belong to your account."},
    },
    tags=["Sending"],
    summary="Send a simple email (single recipient, plain or HTML)",
    response_model_by_alias=True,
)
async def send_mail(
    to: SendMailTo = Form(..., description="", alias="to"),
    var_from: Annotated[StrictStr, Field(description="The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.")] = Form(..., description="The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order.", alias="from"),
    subject: Annotated[StrictStr, Field(description="The subject line of the email.")] = Form(..., description="The subject line of the email.", alias="subject"),
    body: Annotated[StrictStr, Field(description="The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.")] = Form(..., description="The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.", alias="body"),
    id: Annotated[Optional[StrictInt], Field(description="Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.")] = Form(None, description="Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.", alias="id"),
    token_apiKeyAuth: TokenModel = Security(
        get_token_apiKeyAuth
    ),
) -> GenericResponse:
    """**Use this for the simplest case** — one or a few plain-string recipients, no attachments, no CC/BCC, no named contacts. Required: &#x60;from&#x60;, &#x60;to&#x60;, &#x60;subject&#x60;, &#x60;body&#x60;. Optional: &#x60;id&#x60; (selects which mail order to send through; auto-selects your first active order if omitted). Sends through one of your mail orders using a flat set of fields.  **HTML detection** is automatic — if the &#x60;body&#x60; value contains any HTML tags the message will be sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is also automatically set as the &#x60;Reply-To&#x60; header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use &#x60;POST /mail/advsend&#x60; instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use &#x60;POST /mail/rawsend&#x60;.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record. """
    if not BaseSendingApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseSendingApi.subclasses[0]().send_mail(to, var_from, subject, body, id)


@router.post(
    "/mail/rawsend",
    responses={
        200: {"model": GenericResponse, "description": "Email accepted for delivery"},
        400: {"model": ErrorMessage, "description": "Bad request — one or more input parameters were missing or invalid."},
        401: {"model": ErrorMessage, "description": "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)."},
        404: {"model": ErrorMessage, "description": "The specified resource was not found or does not belong to your account."},
    },
    tags=["Sending"],
    summary="Send a pre-built RFC 822 message verbatim (preserves DKIM)",
    response_model_by_alias=True,
)
async def raw_mail(
    send_mail_raw: SendMailRaw = Body(..., description=""),
    token_apiKeyAuth: TokenModel = Security(
        get_token_apiKeyAuth
    ),
) -> GenericResponse:
    """**Use this when you have already built (and possibly DKIM-signed) the full RFC 822 message yourself** and want the relay to transmit it byte-for-byte. Required: &#x60;raw_email&#x60; (full RFC 822 string with headers + body). Optional: &#x60;id&#x60; (mail order to authenticate as). Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact. If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The &#x60;From&#x60; and recipient addresses are parsed automatically from the message headers (&#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, &#x60;Bcc&#x60;).  You do **not** need to specify them separately.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record. """
    if not BaseSendingApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseSendingApi.subclasses[0]().raw_mail(send_mail_raw)


@router.post(
    "/mail/advsend",
    responses={
        200: {"model": GenericResponse, "description": "Email accepted for delivery"},
        400: {"model": ErrorMessage, "description": "Bad request — one or more input parameters were missing or invalid."},
        401: {"model": ErrorMessage, "description": "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)."},
        404: {"model": ErrorMessage, "description": "The specified resource was not found or does not belong to your account."},
    },
    tags=["Sending"],
    summary="Send email with multiple recipients, CC/BCC, attachments, named contacts",
    response_model_by_alias=True,
)
async def send_adv_mail(
    subject: Annotated[StrictStr, Field(description="The subject line of the email.")] = Form(..., description="The subject line of the email.", alias="subject"),
    body: Annotated[StrictStr, Field(description="The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.")] = Form(..., description="The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.", alias="body"),
    var_from: Annotated[Any, Field(description="The sender address.  Accepts a plain email string, an RFC 822 named string (`\\\"Name <email>\\\"`), or a `{\\\"email\\\": \\\"...\\\", \\\"name\\\": \\\"...\\\"}` object.")] = Form(..., description="The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\\\&quot;Name &lt;email&gt;\\\&quot;&#x60;), or a &#x60;{\\\&quot;email\\\&quot;: \\\&quot;...\\\&quot;, \\\&quot;name\\\&quot;: \\\&quot;...\\\&quot;}&#x60; object.", alias="from"),
    to: Annotated[Any, Field(description="One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.")] = Form(..., description="One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.", alias="to"),
    replyto: Annotated[Optional[Any], Field(description="Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.")] = Form(None, description="Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;.", alias="replyto"),
    cc: Annotated[Optional[Any], Field(description="Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.")] = Form(None, description="Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients.", alias="cc"),
    bcc: Annotated[Optional[Any], Field(description="Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.")] = Form(None, description="Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.", alias="bcc"),
    attachments: Annotated[Optional[List[MailAttachment]], Field(description="Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.")] = Form(None, description="Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name.", alias="attachments"),
    id: Annotated[Optional[StrictInt], Field(description="Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.")] = Form(None, description="Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.", alias="id"),
    token_apiKeyAuth: TokenModel = Security(
        get_token_apiKeyAuth
    ),
) -> GenericResponse:
    """**Use this when the simple send is not enough** — multiple recipients, CC/BCC, named contacts, custom Reply-To, or file attachments. Required: &#x60;from&#x60;, &#x60;to&#x60;, &#x60;subject&#x60;, &#x60;body&#x60;. Optional: &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;, &#x60;attachments&#x60; (array of &#x60;{filename,data}&#x60; with base64 data), &#x60;id&#x60;. Sends through one of your mail orders with full control over recipients, headers, and attachments.  **Content-type flexibility** — the request body may be submitted as either &#x60;application/x-www-form-urlencoded&#x60; or &#x60;application/json&#x60;.  When using form encoding, address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) accept both a plain RFC 822 comma-separated string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;, jane@example.com\&quot;&#x60;) and the structured &#x60;[{\&quot;email\&quot;:\&quot;...\&quot;,\&quot;name\&quot;:\&quot;...\&quot;}]&#x60; array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if &#x60;body&#x60; contains HTML tags the &#x60;Content-Type&#x60; is set to &#x60;text/html&#x60;; otherwise &#x60;text/plain&#x60;.  **Attachments** must be base64-encoded.  Each attachment requires at least a &#x60;data&#x60; field; the optional &#x60;filename&#x60; field controls the attachment name shown to recipients.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response &#x60;text&#x60; field contains the relay transaction ID which can be looked up in &#x60;GET /mail/log&#x60; via the &#x60;mailid&#x60; query parameter.  ## Examples  ### Form — basic string addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/x-www-form-urlencoded&#39; \\   -d &#39;subject&#x3D;Welcome&#39; \\   -d &#39;body&#x3D;Hello&#39; \\   -d from&#x3D;user@domain.com \\   -d to&#x3D;support@interserver.net &#x60;&#x60;&#x60; ### Form — RFC 822 named addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/x-www-form-urlencoded&#39; \\   -d &#39;subject&#x3D;Welcome&#39; \\   -d &#39;body&#x3D;Hello&#39; \\   -d &#39;from&#x3D;Joe &lt;user@domain.com&gt;&#39; \\   -d &#39;to&#x3D;Jane &lt;support@interserver.net&gt;&#39; &#x60;&#x60;&#x60; ### Form — multiple recipients as array &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/x-www-form-urlencoded&#39; \\   -d &#39;subject&#x3D;Welcome&#39; -d &#39;body&#x3D;Hello&#39; \\   -d from&#x3D;user@domain.com \\   -d &#39;to[0][name]&#x3D;Joe&#39; -d &#39;to[0][email]&#x3D;support@interserver.net&#39; \\   -d &#39;to[1][name]&#x3D;Jane&#39; -d &#39;to[1][email]&#x3D;jane@interserver.net&#39; &#x60;&#x60;&#x60; ### JSON — structured objects &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -d &#39;{     \&quot;subject\&quot;: \&quot;Welcome\&quot;,     \&quot;body\&quot;: \&quot;&lt;h1&gt;Hello&lt;/h1&gt;\&quot;,     \&quot;from\&quot;: {\&quot;email\&quot;: \&quot;user@domain.com\&quot;, \&quot;name\&quot;: \&quot;Sender Name\&quot;},     \&quot;to\&quot;: [{\&quot;email\&quot;: \&quot;joe@client.com\&quot;, \&quot;name\&quot;: \&quot;Joe Client\&quot;}],     \&quot;cc\&quot;: [{\&quot;email\&quot;: \&quot;manager@client.com\&quot;}],     \&quot;attachments\&quot;: [{\&quot;filename\&quot;: \&quot;report.pdf\&quot;, \&quot;data\&quot;: \&quot;BASE64_DATA\&quot;}]   }&#39; &#x60;&#x60;&#x60; """
    if not BaseSendingApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseSendingApi.subclasses[0]().send_adv_mail(subject, body, var_from, to, replyto, cc, bcc, attachments, id)
