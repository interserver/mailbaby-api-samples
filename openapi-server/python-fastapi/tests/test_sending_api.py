# coding: utf-8

from fastapi.testclient import TestClient


from pydantic import Field, StrictInt, StrictStr  # noqa: F401
from typing import Any, List, Optional  # noqa: F401
from typing_extensions import Annotated  # noqa: F401
from MailBabyPythonFastapi.models.error_message import ErrorMessage  # noqa: F401
from MailBabyPythonFastapi.models.generic_response import GenericResponse  # noqa: F401
from MailBabyPythonFastapi.models.mail_attachment import MailAttachment  # noqa: F401
from MailBabyPythonFastapi.models.send_mail_raw import SendMailRaw  # noqa: F401
from MailBabyPythonFastapi.models.send_mail_to import SendMailTo  # noqa: F401


def test_send_mail(client: TestClient):
    """Test case for send_mail

    Send a simple email (single recipient, plain or HTML)
    """

    headers = {
        "apiKeyAuth": "special-key",
    }
    data = {
        "to": MailBabyPythonFastapi.SendMailTo(),
        "var_from": 'var_from_example',
        "subject": 'subject_example',
        "body": 'body_example',
        "id": 56
    }
    # uncomment below to make a request
    #response = client.request(
    #    "POST",
    #    "/mail/send",
    #    headers=headers,
    #    data=data,
    #)

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200


def test_raw_mail(client: TestClient):
    """Test case for raw_mail

    Send a pre-built RFC 822 message verbatim (preserves DKIM)
    """
    send_mail_raw = MailBabyPythonFastapi.SendMailRaw()

    headers = {
        "apiKeyAuth": "special-key",
    }
    # uncomment below to make a request
    #response = client.request(
    #    "POST",
    #    "/mail/rawsend",
    #    headers=headers,
    #    json=send_mail_raw,
    #)

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200


def test_send_adv_mail(client: TestClient):
    """Test case for send_adv_mail

    Send email with multiple recipients, CC/BCC, attachments, named contacts
    """

    headers = {
        "apiKeyAuth": "special-key",
    }
    data = {
        "subject": 'subject_example',
        "body": 'body_example',
        "var_from": MailBabyPythonFastapi.EmailAddressTypes(),
        "to": MailBabyPythonFastapi.EmailAddressesTypes(),
        "replyto": MailBabyPythonFastapi.EmailAddressesTypes(),
        "cc": MailBabyPythonFastapi.EmailAddressesTypes(),
        "bcc": MailBabyPythonFastapi.EmailAddressesTypes(),
        "attachments": [MailBabyPythonFastapi.MailAttachment()],
        "id": 56
    }
    # uncomment below to make a request
    #response = client.request(
    #    "POST",
    #    "/mail/advsend",
    #    headers=headers,
    #    data=data,
    #)

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200

