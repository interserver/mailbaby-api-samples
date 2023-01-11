# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.generic_response import GenericResponse  # noqa: E501
from swagger_server.models.inline_response200 import InlineResponse200  # noqa: E501
from swagger_server.models.inline_response401 import InlineResponse401  # noqa: E501
from swagger_server.models.mail_log import MailLog  # noqa: E501
from swagger_server.models.send_mail import SendMail  # noqa: E501
from swagger_server.models.send_mail_adv import SendMailAdv  # noqa: E501
from swagger_server.models.send_mail_adv_attachments import SendMailAdvAttachments  # noqa: E501
from swagger_server.models.send_mail_adv_bcc import SendMailAdvBcc  # noqa: E501
from swagger_server.models.send_mail_adv_cc import SendMailAdvCc  # noqa: E501
from swagger_server.models.send_mail_adv_from import SendMailAdvFrom  # noqa: E501
from swagger_server.models.send_mail_adv_replyto import SendMailAdvReplyto  # noqa: E501
from swagger_server.models.send_mail_adv_to import SendMailAdvTo  # noqa: E501
from swagger_server.test import BaseTestCase


class TestDefaultController(BaseTestCase):
    """DefaultController integration test stubs"""

    def test_get_mail_orders(self):
        """Test case for get_mail_orders

        displays a list of mail service orders
        """
        response = self.client.open(
            '/mail',
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_ping_server(self):
        """Test case for ping_server

        Checks if the server is running
        """
        response = self.client.open(
            '/ping',
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_send_adv_mail(self):
        """Test case for send_adv_mail

        Sends an Email with Advanced Options
        """
        body = SendMailAdv()
        data = dict(subject='subject_example',
                    body='body_example',
                    _from=SendMailAdvFrom(),
                    to=SendMailAdvTo(),
                    replyto=SendMailAdvReplyto(),
                    cc=SendMailAdvCc(),
                    bcc=SendMailAdvBcc(),
                    attachments=SendMailAdvAttachments(),
                    id=789)
        response = self.client.open(
            '/mail/advsend',
            method='POST',
            data=json.dumps(body),
            data=data,
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_send_mail(self):
        """Test case for send_mail

        Sends an Email
        """
        body = SendMail()
        data = dict(to='to_example',
                    _from='_from_example',
                    subject='subject_example',
                    body='body_example')
        response = self.client.open(
            '/mail/send',
            method='POST',
            data=json.dumps(body),
            data=data,
            content_type='application/x-www-form-urlencoded')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_view_mail_log(self):
        """Test case for view_mail_log

        displays the mail log
        """
        query_string = [('id', 789),
                        ('origin', 'origin_example'),
                        ('mx', 'mx_example'),
                        ('_from', '_from_example'),
                        ('to', 'to_example'),
                        ('subject', 'subject_example'),
                        ('mailid', 'mailid_example'),
                        ('skip', 1),
                        ('limit', 10000),
                        ('start_date', 9999999999),
                        ('end_date', 9999999999)]
        response = self.client.open(
            '/mail/log',
            method='GET',
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
