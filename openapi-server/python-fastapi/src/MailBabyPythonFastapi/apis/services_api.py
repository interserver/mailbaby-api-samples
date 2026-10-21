# coding: utf-8

from typing import Dict, List  # noqa: F401
import importlib
import pkgutil

from MailBabyPythonFastapi.apis.services_api_base import BaseServicesApi
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

from pydantic import Field
from typing import List
from typing_extensions import Annotated
from MailBabyPythonFastapi.models.error_message import ErrorMessage
from MailBabyPythonFastapi.models.mail_order import MailOrder
from MailBabyPythonFastapi.models.mail_order_detail import MailOrderDetail
from MailBabyPythonFastapi.models.extra_models import TokenModel  # noqa: F401
from MailBabyPythonFastapi.security_api import get_token_apiKeyAuth

router = APIRouter()

ns_pkg = MailBabyPythonFastapi.impl
for _, name, _ in pkgutil.iter_modules(ns_pkg.__path__, ns_pkg.__name__ + "."):
    importlib.import_module(name)


@router.get(
    "/mail",
    responses={
        200: {"model": List[MailOrder], "description": "OK"},
        401: {"model": ErrorMessage, "description": "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)."},
    },
    tags=["Services"],
    summary="List your provisioned mail orders (sending accounts)",
    response_model_by_alias=True,
)
async def get_mail_orders(
    token_apiKeyAuth: TokenModel = Security(
        get_token_apiKeyAuth
    ),
) -> List[MailOrder]:
    """Use this **before sending** if you need to discover which mail order &#x60;id&#x60; to pass to &#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, &#x60;/mail/rawsend&#x60;, &#x60;/mail/log&#x60;, or &#x60;/mail/stats&#x60;. Returns every mail order (active **and** canceled) on your account. Each record includes the numeric &#x60;id&#x60;, the &#x60;status&#x60; (&#x60;active&#x60; or &#x60;canceled&#x60;), the SMTP &#x60;username&#x60; (always &#x60;mb&lt;id&gt;&#x60;), and an optional &#x60;comment&#x60;.  The &#x60;id&#x60; values returned here are used as the &#x60;id&#x60; input parameter on all sending endpoints (&#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, &#x60;/mail/rawsend&#x60;) as well as the log and stats queries.  When the &#x60;id&#x60; parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use &#x60;GET /mail/{id}&#x60;. """
    if not BaseServicesApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseServicesApi.subclasses[0]().get_mail_orders()


@router.get(
    "/mail/{id}",
    responses={
        200: {"model": MailOrderDetail, "description": "OK"},
        400: {"model": ErrorMessage, "description": "Bad request — one or more input parameters were missing or invalid."},
        401: {"model": ErrorMessage, "description": "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)."},
        404: {"model": ErrorMessage, "description": "The specified resource was not found or does not belong to your account."},
    },
    tags=["Services"],
    summary="Get one mail order&#39;s full detail including SMTP password",
    response_model_by_alias=True,
)
async def get_mail_order_by_id(
    id: Annotated[int, Field(description="The numeric ID of the mail order.")] = Path(..., description="The numeric ID of the mail order.", examples=[39]),
    token_apiKeyAuth: TokenModel = Security(
        get_token_apiKeyAuth
    ),
) -> MailOrderDetail:
    """**Returns the SMTP password** in addition to the basic &#x60;GET /mail&#x60; fields. Use when you need to authenticate against &#x60;relay.mailbaby.net:25&#x60; from an SMTP client directly. Required: &#x60;id&#x60; (path; obtain from &#x60;GET /mail&#x60;). Returns the full detail record for one specific mail order identified by its numeric &#x60;id&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; values returned here can be used directly to authenticate against &#x60;relay.mailbaby.net:25&#x60; (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The &#x60;id&#x60; path parameter is the same integer &#x60;id&#x60; value returned by &#x60;GET /mail&#x60;. """
    if not BaseServicesApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseServicesApi.subclasses[0]().get_mail_order_by_id(id)
