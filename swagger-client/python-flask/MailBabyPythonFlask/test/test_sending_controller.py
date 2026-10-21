# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from MailBabyPythonFlask.models.error_message import ErrorMessage  # noqa: E501
from MailBabyPythonFlask.models.generic_response import GenericResponse  # noqa: E501
from MailBabyPythonFlask.models.mail_attachment import MailAttachment  # noqa: E501
from MailBabyPythonFlask.models.send_mail import SendMail  # noqa: E501
from MailBabyPythonFlask.models.send_mail_adv import SendMailAdv  # noqa: E501
from MailBabyPythonFlask.models.send_mail_raw import SendMailRaw  # noqa: E501
from MailBabyPythonFlask.models.send_mail_to import SendMailTo  # noqa: E501
from MailBabyPythonFlask.test import BaseTestCase


class TestSendingController(BaseTestCase):
    """SendingController integration test stubs"""

    def test_raw_mail(self):
        """Test case for raw_mail

        Send a pre-built RFC 822 message verbatim (preserves DKIM)
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

        Send email with multiple recipients, CC/BCC, attachments, named contacts
        """
        body = SendMailAdv()
        data = dict(subject='subject_example',
                    body='body_example',
                    _from=Object(),
                    to=Object(),
                    replyto=Object(),
                    cc=Object(),
                    bcc=Object(),
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

        Send a simple email (single recipient, plain or HTML)
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
