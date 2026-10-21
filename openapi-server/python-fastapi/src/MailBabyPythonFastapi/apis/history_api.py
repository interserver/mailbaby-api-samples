# coding: utf-8

from typing import Dict, List  # noqa: F401
import importlib
import pkgutil

from MailBabyPythonFastapi.apis.history_api_base import BaseHistoryApi
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

from pydantic import Field, field_validator
from typing import Any, Optional
from typing_extensions import Annotated
from MailBabyPythonFastapi.models.error_message import ErrorMessage
from MailBabyPythonFastapi.models.mail_log import MailLog
from MailBabyPythonFastapi.models.mail_stats_type import MailStatsType
from MailBabyPythonFastapi.models.extra_models import TokenModel  # noqa: F401
from MailBabyPythonFastapi.security_api import get_token_apiKeyAuth

router = APIRouter()

ns_pkg = MailBabyPythonFastapi.impl
for _, name, _ in pkgutil.iter_modules(ns_pkg.__path__, ns_pkg.__name__ + "."):
    importlib.import_module(name)


@router.get(
    "/mail/log",
    responses={
        200: {"model": MailLog, "description": "Paginated list of mail log entries"},
        400: {"model": ErrorMessage, "description": "Bad request — one or more input parameters were missing or invalid."},
        401: {"model": ErrorMessage, "description": "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)."},
    },
    tags=["History"],
    summary="Query the mail delivery log (filterable, paginated)",
    response_model_by_alias=True,
)
async def view_mail_log(
    id: Annotated[Optional[int], Field(description="The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from `GET /mail` or `GET /mail/{id}`.")] = Query(None, description="The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from &#x60;GET /mail&#x60; or &#x60;GET /mail/{id}&#x60;.", alias="id", examples=[2604]),
    origin: Annotated[Optional[str], Field(description="Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address.")] = Query(None, description="Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address.", alias="origin", examples=["1.2.3.4"]),
    mx: Annotated[Optional[str], Field(description="Filter by the MX hostname the relay attempted delivery to.  For example `mx.google.com` would return messages destined for Gmail recipients. Maps to `mxHostname` in the `MailLogEntry` response.")] = Query(None, description="Filter by the MX hostname the relay attempted delivery to.  For example &#x60;mx.google.com&#x60; would return messages destined for Gmail recipients. Maps to &#x60;mxHostname&#x60; in the &#x60;MailLogEntry&#x60; response.", alias="mx", examples=["mx.google.com"]),
    var_from: Annotated[Optional[str], Field(description="Filter by SMTP envelope `MAIL FROM` address (exact match).  This is the address the relay used for bounce handling and may differ from the `From:` message header.  For header-level filtering use `headerfrom`.")] = Query(None, description="Filter by SMTP envelope &#x60;MAIL FROM&#x60; address (exact match).  This is the address the relay used for bounce handling and may differ from the &#x60;From:&#x60; message header.  For header-level filtering use &#x60;headerfrom&#x60;.", alias="from", examples=["me@sender.com"]),
    to: Annotated[Optional[str], Field(description="Filter by SMTP envelope `RCPT TO` address (exact match).  This is the delivery address used by the relay and may differ from the `To:` header when BCC recipients are involved.")] = Query(None, description="Filter by SMTP envelope &#x60;RCPT TO&#x60; address (exact match).  This is the delivery address used by the relay and may differ from the &#x60;To:&#x60; header when BCC recipients are involved.", alias="to", examples=["you@receiver.com"]),
    subject: Annotated[Optional[str], Field(description="Filter by email `Subject` header (exact match).  To search for a substring, include it in the full subject text.")] = Query(None, description="Filter by email &#x60;Subject&#x60; header (exact match).  To search for a substring, include it in the full subject text.", alias="subject", examples=["Your order has shipped"]),
    mailid: Annotated[Optional[Annotated[str, Field(min_length=18, max_length=19)]], Field(description="Filter by the relay-assigned mail ID string (exact match).  This corresponds to the `id` field in `MailLogEntry` and to the `text` value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as `185997065c60008840`.")] = Query(None, description="Filter by the relay-assigned mail ID string (exact match).  This corresponds to the &#x60;id&#x60; field in &#x60;MailLogEntry&#x60; and to the &#x60;text&#x60; value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as &#x60;185997065c60008840&#x60;.", alias="mailid", min_length=18, max_length=19, examples=["185997065c60008840"]),
    message_id: Annotated[Optional[str], Field(description="Filter by the `Message-ID` email header using a substring (case-insensitive) match. The `Message-ID` is assigned by the sending mail client and is visible in the `messageId` field of `MailLogEntry`.  Useful when you know the message ID generated by your application but not the relay `mailid`.")] = Query(None, description="Filter by the &#x60;Message-ID&#x60; email header using a substring (case-insensitive) match. The &#x60;Message-ID&#x60; is assigned by the sending mail client and is visible in the &#x60;messageId&#x60; field of &#x60;MailLogEntry&#x60;.  Useful when you know the message ID generated by your application but not the relay &#x60;mailid&#x60;.", alias="messageId", examples=["<abc123@yourdomain.com>"]),
    replyto: Annotated[Optional[str], Field(description="Filter by the `Reply-To` message header address (exact match).  Only returns messages where this header was explicitly set.")] = Query(None, description="Filter by the &#x60;Reply-To&#x60; message header address (exact match).  Only returns messages where this header was explicitly set.", alias="replyto", examples=["replies@sender.com"]),
    headerfrom: Annotated[Optional[str], Field(description="Filter by the `From` message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope `from` parameter when sending on behalf of another address.")] = Query(None, description="Filter by the &#x60;From&#x60; message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope &#x60;from&#x60; parameter when sending on behalf of another address.", alias="headerfrom", examples=["newsletter@sender.com"]),
    delivered: Annotated[Optional[int], Field(description="Filter by delivery status.  `1` returns only messages that were successfully delivered to the destination MX.  `0` returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status.")] = Query(None, description="Filter by delivery status.  &#x60;1&#x60; returns only messages that were successfully delivered to the destination MX.  &#x60;0&#x60; returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status.", alias="delivered", examples=[1]),
    skip: Annotated[Optional[Annotated[int, Field(ge=0)]], Field(description="Number of records to skip for pagination.  Use in combination with `limit` to page through large result sets.  Defaults to `0` (no skip).")] = Query(0, description="Number of records to skip for pagination.  Use in combination with &#x60;limit&#x60; to page through large result sets.  Defaults to &#x60;0&#x60; (no skip).", alias="skip", ge=0, examples=[0]),
    limit: Annotated[Optional[Annotated[int, Field(le=10000, ge=1)]], Field(description="Maximum number of records to return per page.  Defaults to `100`. Maximum allowed value is `10000`.  The response also includes a `total` field with the full matched count so you can calculate the number of pages.")] = Query(100, description="Maximum number of records to return per page.  Defaults to &#x60;100&#x60;. Maximum allowed value is &#x60;10000&#x60;.  The response also includes a &#x60;total&#x60; field with the full matched count so you can calculate the number of pages.", alias="limit", ge=1, le=10000, examples=[100]),
    start_date: Annotated[Optional[Any], Field(description="Earliest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-15` or `last monday`.  Messages with a `time` value **greater than or equal to** this value will be included.")] = Query(None, description="Earliest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by &#x60;strtotime()&#x60; such as &#x60;2024-01-15&#x60; or &#x60;last monday&#x60;.  Messages with a &#x60;time&#x60; value **greater than or equal to** this value will be included.", alias="startDate", examples=[1641781008]),
    end_date: Annotated[Optional[Any], Field(description="Latest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-31` or `yesterday`. Messages with a `time` value **less than or equal to** this value will be included.")] = Query(None, description="Latest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by &#x60;strtotime()&#x60; such as &#x60;2024-01-31&#x60; or &#x60;yesterday&#x60;. Messages with a &#x60;time&#x60; value **less than or equal to** this value will be included.", alias="endDate", examples=[1673317008]),
    sort: Annotated[Optional[str], Field(description="Field to sort results by.  Currently only `time` is supported (sorts by internal row ID which corresponds to chronological order).")] = Query('time', description="Field to sort results by.  Currently only &#x60;time&#x60; is supported (sorts by internal row ID which corresponds to chronological order).", alias="sort", examples=["time"]),
    dir: Annotated[Optional[str], Field(description="Sort direction.  `desc` returns newest first (default), `asc` returns oldest first.")] = Query('desc', description="Sort direction.  &#x60;desc&#x60; returns newest first (default), &#x60;asc&#x60; returns oldest first.", alias="dir", examples=["desc"]),
    groupby: Annotated[Optional[str], Field(description="Controls how results are grouped.  `recipient` (default) returns one row per delivery attempt — a message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and delivery metadata.  `message` collapses to one row per unique message ID; delivery-level fields will reflect one arbitrary recipient per message.  The `total` count in the response matches the grouping mode.")] = Query('recipient', description="Controls how results are grouped.  &#x60;recipient&#x60; (default) returns one row per delivery attempt — a message sent to 4 recipients produces 4 rows, each with its own &#x60;recipient&#x60;, &#x60;delivered&#x60;, &#x60;response&#x60;, and delivery metadata.  &#x60;message&#x60; collapses to one row per unique message ID; delivery-level fields will reflect one arbitrary recipient per message.  The &#x60;total&#x60; count in the response matches the grouping mode.", alias="groupby", examples=["recipient"]),
    token_apiKeyAuth: TokenModel = Security(
        get_token_apiKeyAuth
    ),
) -> MailLog:
    """**Use this to find or audit sent messages.** All filters are optional and combinable. The most useful filters: &#x60;mailid&#x60; (the transaction id returned by a send call), &#x60;from&#x60; / &#x60;to&#x60; (envelope addresses), &#x60;subject&#x60;, &#x60;messageId&#x60; (case-insensitive substring on the &#x60;Message-ID&#x60; header), &#x60;delivered&#x60; (&#x60;1&#x60;&#x3D;delivered, &#x60;0&#x60;&#x3D;queued/failed), and the &#x60;startDate&#x60;/&#x60;endDate&#x60; date range. Returns a paginated list of every email message accepted by the relay for your mail account(s).  **Row grouping** is controlled by the &#x60;groupby&#x60; parameter.  By default (&#x60;groupby&#x3D;recipient&#x60;), the response contains one row per delivery attempt — so a single message sent to 4 recipients produces 4 rows, each with its own &#x60;recipient&#x60;, &#x60;delivered&#x60;, &#x60;response&#x60;, and &#x60;mxHostname&#x60; values.  Set &#x60;groupby&#x3D;message&#x60; to collapse to one row per message (delivery fields will reflect one arbitrary recipient).  **Pagination** is controlled by &#x60;skip&#x60; and &#x60;limit&#x60;.  The &#x60;total&#x60; in the response reflects the row count **after** grouping, so it matches the number of pages you need to fetch.  **Date filtering** accepts either a Unix timestamp (integer) or a date string parseable by PHP &#x60;strtotime()&#x60; such as &#x60;2024-01-15&#x60;, &#x60;last monday&#x60;, or &#x60;2024-01-01 00:00:00&#x60;.  Examples: &#x60;startDate&#x3D;1704067200&amp;endDate&#x3D;1706745599&#x60; or &#x60;startDate&#x3D;2024-01-01&amp;endDate&#x3D;2024-01-31&#x60;.  **Sorting** is controlled by &#x60;sort&#x60; and &#x60;dir&#x60;.  Currently the only sort key is &#x60;time&#x60; (default), which orders by internal row ID.  **Delivery status** can be filtered with the &#x60;delivered&#x60; parameter: &#x60;delivered&#x3D;1&#x60; returns only successfully delivered messages; &#x60;delivered&#x3D;0&#x60; returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (&#x60;from&#x60;, &#x60;to&#x60;) and message headers (&#x60;headerfrom&#x60; for the &#x60;From:&#x60; header, &#x60;replyto&#x60; for &#x60;Reply-To:&#x60;). These may differ when a message is sent on behalf of another address.  The &#x60;mailid&#x60; parameter corresponds to the &#x60;id&#x60; field in the returned &#x60;MailLogEntry&#x60; objects, **not** the &#x60;_id&#x60; field.  It also matches the transaction ID returned in the &#x60;text&#x60; field of a successful send response from &#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, or &#x60;/mail/rawsend&#x60;.  The &#x60;messageId&#x60; parameter searches the &#x60;Message-ID&#x60; email header (case-insensitive substring match). """
    if not BaseHistoryApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseHistoryApi.subclasses[0]().view_mail_log(id, origin, mx, var_from, to, subject, mailid, message_id, replyto, headerfrom, delivered, skip, limit, start_date, end_date, sort, dir, groupby)


@router.get(
    "/mail/stats",
    responses={
        200: {"model": MailStatsType, "description": "OK"},
        401: {"model": ErrorMessage, "description": "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)."},
    },
    tags=["History"],
    summary="Account usage, cost, and volume statistics for a time window",
    response_model_by_alias=True,
)
async def get_stats(
    time: Annotated[Optional[str], Field(description="The time window to scope `received`, `sent`, and `volume` statistics. Does not affect `usage` or `cost`, which are always calculated over the current billing cycle. Defaults to `1h`.")] = Query('1h', description="The time window to scope &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics. Does not affect &#x60;usage&#x60; or &#x60;cost&#x60;, which are always calculated over the current billing cycle. Defaults to &#x60;1h&#x60;.", alias="time"),
    token_apiKeyAuth: TokenModel = Security(
        get_token_apiKeyAuth
    ),
) -> MailStatsType:
    """**Use this for dashboards or billing-cycle reviews.** Returns aggregate sending statistics for your mail account(s). The &#x60;time&#x60; query param controls the window for &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; (&#x60;1h&#x60;, &#x60;24h&#x60;, &#x60;7d&#x60;, &#x60;month&#x60;, &#x60;day&#x60;, &#x60;billing&#x60;, &#x60;all&#x60;). The &#x60;usage&#x60; and &#x60;cost&#x60; fields are always for the current billing cycle, regardless of &#x60;time&#x60;.  The response includes: - **&#x60;usage&#x60;** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **&#x60;cost&#x60;** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **&#x60;received&#x60;** / **&#x60;sent&#x60;** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected &#x60;time&#x60; window. - **&#x60;volume&#x60;** — top-500 breakdown of message counts grouped by source IP (&#x60;ip&#x60;),   destination address (&#x60;to&#x60;), and sender address (&#x60;from&#x60;) within the selected window.   **Time windows** (controlled by the &#x60;time&#x60; parameter): | Value | Window | |-------|--------| | &#x60;1h&#x60; | Last 1 hour (default) | | &#x60;24h&#x60; | Last 24 hours | | &#x60;7d&#x60; | Last 7 days | | &#x60;month&#x60; | Current calendar month (1st to now) | | &#x60;day&#x60; | Today (midnight to now) | | &#x60;billing&#x60; | Current billing cycle (last invoice date to next invoice date) | | &#x60;all&#x60; | All time | """
    if not BaseHistoryApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseHistoryApi.subclasses[0]().get_stats(time)
