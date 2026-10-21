# coding: utf-8

from fastapi.testclient import TestClient


from pydantic import Field, field_validator  # noqa: F401
from typing import Optional  # noqa: F401
from typing_extensions import Annotated  # noqa: F401
from MailBabyPythonFastapi.models.error_message import ErrorMessage  # noqa: F401
from MailBabyPythonFastapi.models.mail_log import MailLog  # noqa: F401
from MailBabyPythonFastapi.models.mail_stats_type import MailStatsType  # noqa: F401


def test_view_mail_log(client: TestClient):
    """Test case for view_mail_log

    Query the mail delivery log (filterable, paginated)
    """
    params = [("id", 2604),     ("origin", '1.2.3.4'),     ("mx", 'mx.google.com'),     ("var_from", 'me@sender.com'),     ("to", 'you@receiver.com'),     ("subject", 'Your order has shipped'),     ("mailid", '185997065c60008840'),     ("message_id", '<abc123@yourdomain.com>'),     ("replyto", 'replies@sender.com'),     ("headerfrom", 'newsletter@sender.com'),     ("delivered", 1),     ("skip", 0),     ("limit", 100),     ("start_date", '1641781008'),     ("end_date", '1673317008'),     ("sort", 'time'),     ("dir", 'desc'),     ("groupby", 'recipient')]
    headers = {
        "apiKeyAuth": "special-key",
    }
    # uncomment below to make a request
    #response = client.request(
    #    "GET",
    #    "/mail/log",
    #    headers=headers,
    #    params=params,
    #)

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200


def test_get_stats(client: TestClient):
    """Test case for get_stats

    Account usage, cost, and volume statistics for a time window
    """
    params = [("time", '1h')]
    headers = {
        "apiKeyAuth": "special-key",
    }
    # uncomment below to make a request
    #response = client.request(
    #    "GET",
    #    "/mail/stats",
    #    headers=headers,
    #    params=params,
    #)

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200

