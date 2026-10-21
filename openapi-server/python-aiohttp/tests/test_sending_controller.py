# coding: utf-8

import pytest
import json
from aiohttp import web

from MailBabyPythonAiohttp.models.email_address_types import EmailAddressTypes
from MailBabyPythonAiohttp.models.email_addresses_types import EmailAddressesTypes
from MailBabyPythonAiohttp.models.error_message import ErrorMessage
from MailBabyPythonAiohttp.models.generic_response import GenericResponse
from MailBabyPythonAiohttp.models.mail_attachment import MailAttachment
from MailBabyPythonAiohttp.models.send_mail_raw import SendMailRaw
from MailBabyPythonAiohttp.models.send_mail_to import SendMailTo


pytestmark = pytest.mark.asyncio

@pytest.mark.skip("Connexion does not support multiple consumes. See https://github.com/zalando/connexion/pull/760")
async def test_raw_mail(client):
    """Test case for raw_mail

    Send a pre-built RFC 822 message verbatim (preserves DKIM)
    """
    body = {"id":39,"raw_email":"Date: Sun, 16 Nov 2025 14:30:11 -0500\nTo: Me <support@interserver.net>\nFrom: Mail Test <support@interserver.net>\nReply-To: Mail Test <support@interserver.net>\nSubject: testing out raw email api call\nMessage-ID: <9jeLkYQIw7KqYnoiCnnYj7EC0IrSHdp8XMuJq9a5qs@interserver.net>\nMIME-Version: 1.0\nContent-Type: text/plain; charset=utf-8\nDKIM-Signature: v=1; d=interserver.net; s=my; a=rsa-sha256; ...\n\nThis is a test of the rawsend API call.\n"}
    headers = { 
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'apiKeyAuth': 'special-key',
    }
    response = await client.request(
        method='POST',
        path='/mail/rawsend',
        headers=headers,
        json=body,
        )
    assert response.status == 200, 'Response body is : ' + (await response.read()).decode('utf-8')


pytestmark = pytest.mark.asyncio

@pytest.mark.skip("Connexion does not support multiple consumes. See https://github.com/zalando/connexion/pull/760")
async def test_send_adv_mail(client):
    """Test case for send_adv_mail

    Send email with multiple recipients, CC/BCC, attachments, named contacts
    """
    headers = { 
        'Accept': 'application/json',
        'Content-Type': 'application/x-www-form-urlencoded',
        'apiKeyAuth': 'special-key',
    }
    data = {
        'subject': 'subject_example',
        'body': 'body_example',
        '_from': MailBabyPythonAiohttp.EmailAddressTypes(),
        'to': MailBabyPythonAiohttp.EmailAddressesTypes(),
        'replyto': MailBabyPythonAiohttp.EmailAddressesTypes(),
        'cc': MailBabyPythonAiohttp.EmailAddressesTypes(),
        'bcc': MailBabyPythonAiohttp.EmailAddressesTypes(),
        'attachments': [MailBabyPythonAiohttp.MailAttachment()],
        'id': 56
        }
    response = await client.request(
        method='POST',
        path='/mail/advsend',
        headers=headers,
        data=data,
        )
    assert response.status == 200, 'Response body is : ' + (await response.read()).decode('utf-8')


pytestmark = pytest.mark.asyncio

@pytest.mark.skip("Connexion does not support multiple consumes. See https://github.com/zalando/connexion/pull/760")
async def test_send_mail(client):
    """Test case for send_mail

    Send a simple email (single recipient, plain or HTML)
    """
    headers = { 
        'Accept': 'application/json',
        'Content-Type': 'application/x-www-form-urlencoded',
        'apiKeyAuth': 'special-key',
    }
    data = {
        'to': MailBabyPythonAiohttp.SendMailTo(),
        '_from': '_from_example',
        'subject': 'subject_example',
        'body': 'body_example',
        'id': 56
        }
    response = await client.request(
        method='POST',
        path='/mail/send',
        headers=headers,
        data=data,
        )
    assert response.status == 200, 'Response body is : ' + (await response.read()).decode('utf-8')

