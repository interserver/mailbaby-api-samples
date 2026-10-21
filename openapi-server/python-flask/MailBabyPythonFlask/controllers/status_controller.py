import flask
from typing import Dict
from typing import Tuple
from typing import Union

from MailBabyPythonFlask import util


def ping_server():  # noqa: E501
    """Health check — verify the API is reachable

    **No authentication required.** Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests.  # noqa: E501


    :rtype: Union[str, Tuple[str, int], Tuple[str, int, Dict[str, str]]
    """
    return 'do some magic!'
