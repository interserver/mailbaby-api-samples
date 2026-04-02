import connexion
import six

from mailbaby-client-python-flask import util


def ping_server():  # noqa: E501
    """Checks if the server is running

    A lightweight health-check endpoint.  Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests.  # noqa: E501


    :rtype: str
    """
    return 'do some magic!'
