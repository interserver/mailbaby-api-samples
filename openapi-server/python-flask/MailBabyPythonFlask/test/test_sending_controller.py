import unittest

from flask import json

from MailBabyPythonFlask.models.email_address_types import EmailAddressTypes  # noqa: E501
from MailBabyPythonFlask.models.email_addresses_types import EmailAddressesTypes  # noqa: E501
from MailBabyPythonFlask.models.error_message import ErrorMessage  # noqa: E501
from MailBabyPythonFlask.models.generic_response import GenericResponse  # noqa: E501
from MailBabyPythonFlask.models.mail_attachment import MailAttachment  # noqa: E501
from MailBabyPythonFlask.models.send_mail_raw import SendMailRaw  # noqa: E501
from MailBabyPythonFlask.models.send_mail_to import SendMailTo  # noqa: E501
from MailBabyPythonFlask.test import BaseTestCase


class TestSendingController(BaseTestCase):
    """SendingController integration test stubs"""

    @unittest.skip("Connexion does not support multiple consumes. See https://github.com/zalando/connexion/pull/760")
    def test_raw_mail(self):
        """Test case for raw_mail

        Send a pre-built RFC 822 message verbatim (preserves DKIM)
        """
        send_mail_raw = {"id":39,"raw_email":"Date: Sun, 16 Nov 2025 14:30:11 -0500\nTo: Me <support@interserver.net>\nFrom: Mail Test <support@interserver.net>\nReply-To: Mail Test <support@interserver.net>\nSubject: testing out raw email api call\nMessage-ID: <9jeLkYQIw7KqYnoiCnnYj7EC0IrSHdp8XMuJq9a5qs@interserver.net>\nMIME-Version: 1.0\nContent-Type: text/plain; charset=utf-8\nDKIM-Signature: v=1; d=interserver.net; s=my; a=rsa-sha256; ...\n\nThis is a test of the rawsend API call.\n"}
        headers = { 
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'apiKeyAuth': 'special-key',
        }
        response = self.client.open(
            '/mail/rawsend',
            method='POST',
            headers=headers,
            data=json.dumps(send_mail_raw),
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    @unittest.skip("Connexion does not support multiple consumes. See https://github.com/zalando/connexion/pull/760")
    def test_send_adv_mail(self):
        """Test case for send_adv_mail

        Send email with multiple recipients, CC/BCC, attachments, named contacts
        """
        headers = { 
            'Accept': 'application/json',
            'Content-Type': 'application/x-www-form-urlencoded',
            'apiKeyAuth': 'special-key',
        }
        data = dict(subject='subject_example',
                    body='body_example',
                    _from=MailBabyPythonFlask.EmailAddressTypes(),
                    to=MailBabyPythonFlask.EmailAddressesTypes(),
                    replyto=MailBabyPythonFlask.EmailAddressesTypes(),
                    cc=MailBabyPythonFlask.EmailAddressesTypes(),
                    bcc=MailBabyPythonFlask.EmailAddressesTypes(),
                    attachments=[MailBabyPythonFlask.MailAttachment()],
                    id=56)
        response = self.client.open(
            '/mail/advsend',
            method='POST',
            headers=headers,
            data=data,
            content_type='application/x-www-form-urlencoded')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    @unittest.skip("Connexion does not support multiple consumes. See https://github.com/zalando/connexion/pull/760")
    def test_send_mail(self):
        """Test case for send_mail

        Send a simple email (single recipient, plain or HTML)
        """
        headers = { 
            'Accept': 'application/json',
            'Content-Type': 'application/x-www-form-urlencoded',
            'apiKeyAuth': 'special-key',
        }
        data = dict(to=MailBabyPythonFlask.SendMailTo(),
                    _from='_from_example',
                    subject='subject_example',
                    body='body_example',
                    id=56)
        response = self.client.open(
            '/mail/send',
            method='POST',
            headers=headers,
            data=data,
            content_type='application/x-www-form-urlencoded')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    unittest.main()
