import connexion
import six

from mailbaby-client-python-flask import util


def ping_server():  # noqa: E501
    """Checks if the server is running

    A lightweight health-check endpoint.  Returns a plain-text &#x60;200 OK&#x60; when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks.  # noqa: E501


    :rtype: None
    """
    return 'do some magic!'
