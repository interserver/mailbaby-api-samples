# coding: utf-8

from typing import Dict, List  # noqa: F401
import importlib
import pkgutil

from MailBabyPythonFastapi.apis.status_api_base import BaseStatusApi
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

from pydantic import StrictStr
from typing import Any

router = APIRouter()

ns_pkg = MailBabyPythonFastapi.impl
for _, name, _ in pkgutil.iter_modules(ns_pkg.__path__, ns_pkg.__name__ + "."):
    importlib.import_module(name)


@router.get(
    "/ping",
    responses={
        200: {"model": str, "description": "Server is up and running"},
        "default": {"description": "Something is wrong"},
    },
    tags=["Status"],
    summary="Health check — verify the API is reachable",
    response_model_by_alias=True,
)
async def ping_server(
) -> str:
    """**No authentication required.** Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. """
    if not BaseStatusApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseStatusApi.subclasses[0]().ping_server()
