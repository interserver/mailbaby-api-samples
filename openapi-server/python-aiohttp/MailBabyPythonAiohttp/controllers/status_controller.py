from typing import List, Dict
from aiohttp import web

from MailBabyPythonAiohttp import util


async def ping_server(request: web.Request, ) -> web.Response:
    """Health check — verify the API is reachable

    **No authentication required.** Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 


    """
    return web.Response(status=200)
