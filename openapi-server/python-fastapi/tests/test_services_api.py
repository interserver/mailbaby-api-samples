# coding: utf-8

from fastapi.testclient import TestClient


from pydantic import Field  # noqa: F401
from typing import List  # noqa: F401
from typing_extensions import Annotated  # noqa: F401
from MailBabyPythonFastapi.models.error_message import ErrorMessage  # noqa: F401
from MailBabyPythonFastapi.models.mail_order import MailOrder  # noqa: F401
from MailBabyPythonFastapi.models.mail_order_detail import MailOrderDetail  # noqa: F401


def test_get_mail_orders(client: TestClient):
    """Test case for get_mail_orders

    List your provisioned mail orders (sending accounts)
    """

    headers = {
        "apiKeyAuth": "special-key",
    }
    # uncomment below to make a request
    #response = client.request(
    #    "GET",
    #    "/mail",
    #    headers=headers,
    #)

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200


def test_get_mail_order_by_id(client: TestClient):
    """Test case for get_mail_order_by_id

    Get one mail order's full detail including SMTP password
    """

    headers = {
        "apiKeyAuth": "special-key",
    }
    # uncomment below to make a request
    #response = client.request(
    #    "GET",
    #    "/mail/{id}".format(id=39),
    #    headers=headers,
    #)

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200

