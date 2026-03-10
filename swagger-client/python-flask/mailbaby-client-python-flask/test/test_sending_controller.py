# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from mailbaby-client-python-flask.models.email_address_types import EmailAddressTypes  # noqa: E501
from mailbaby-client-python-flask.models.email_addresses_types import EmailAddressesTypes  # noqa: E501
from mailbaby-client-python-flask.models.error_message import ErrorMessage  # noqa: E501
from mailbaby-client-python-flask.models.generic_response import GenericResponse  # noqa: E501
from mailbaby-client-python-flask.models.mail_attachment import MailAttachment  # noqa: E501
from mailbaby-client-python-flask.models.send_mail import SendMail  # noqa: E501
from mailbaby-client-python-flask.models.send_mail_adv import SendMailAdv  # noqa: E501
from mailbaby-client-python-flask.models.send_mail_raw import SendMailRaw  # noqa: E501
from mailbaby-client-python-flask.models.send_mail_to import SendMailTo  # noqa: E501
from mailbaby-client-python-flask.test import BaseTestCase


class TestSendingController(BaseTestCase):
    """SendingController integration test stubs"""

    def test_raw_mail(self):
        """Test case for raw_mail

        Sends a raw RFC 822 email
        """
        body = SendMailRaw()
        data = dict(raw_email='raw_email_example',
                    id=789)
        response = self.client.open(
            '/mail/rawsend',
            method='POST',
            data=json.dumps(body),
            data=data,
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_send_adv_mail(self):
        """Test case for send_adv_mail

        Sends an Email with Advanced Options
        """
        body = SendMailAdv()
        data = dict(subject='subject_example',
                    body='body_example',
                    _from=EmailAddressTypes(),
                    to=EmailAddressesTypes(),
                    replyto=EmailAddressesTypes(),
                    cc=EmailAddressesTypes(),
                    bcc=EmailAddressesTypes(),
                    attachments=MailAttachment(),
                    id=789)
        response = self.client.open(
            '/mail/advsend',
            method='POST',
            data=json.dumps(body),
            data=data,
            content_type='application/x-www-form-urlencoded')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_send_mail(self):
        """Test case for send_mail

        Sends an Email
        """
        body = SendMail()
        data = dict(to=SendMailTo(),
                    _from='_from_example',
                    subject='subject_example',
                    body='body_example',
                    id=789)
        response = self.client.open(
            '/mail/send',
            method='POST',
            data=json.dumps(body),
            data=data,
            content_type='application/x-www-form-urlencoded')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
