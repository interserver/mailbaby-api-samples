# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.error_response import ErrorResponse  # noqa: E501
from swagger_server.models.generic_response import GenericResponse  # noqa: E501
from swagger_server.models.mail_attachment import MailAttachment  # noqa: E501
from swagger_server.models.mail_contact import MailContact  # noqa: E501
from swagger_server.models.mail_log import MailLog  # noqa: E501
from swagger_server.models.mail_order import MailOrder  # noqa: E501
from swagger_server.models.mail_orders import MailOrders  # noqa: E501
from swagger_server.models.send_mail import SendMail  # noqa: E501
from swagger_server.models.send_mail_adv import SendMailAdv  # noqa: E501
from swagger_server.models.send_mail_adv_from import SendMailAdvFrom  # noqa: E501
from swagger_server.test import BaseTestCase


class TestDefaultController(BaseTestCase):
    """DefaultController integration test stubs"""

    def test_get_mail_orders(self):
        """Test case for get_mail_orders

        displays a list of mail service orders
        """
        query_string = [('id', 789)]
        response = self.client.open(
            '/mail',
            method='GET',
            query_string=query_string)
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

    def test_place_mail_order(self):
        """Test case for place_mail_order

        places a mail order
        """
        body = MailOrder()
        response = self.client.open(
            '/mail/order',
            method='POST',
            data=json.dumps(body),
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
                    _from=SendMailAdvFrom(),
                    to=MailContact(),
                    id=789,
                    replyto=MailContact(),
                    cc=MailContact(),
                    bcc=MailContact(),
                    attachments=MailAttachment())
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

    def test_validate_mail_order(self):
        """Test case for validate_mail_order

        validatess order details before placing an order
        """
        response = self.client.open(
            '/mail/order',
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_view_mail_log(self):
        """Test case for view_mail_log

        displays the mail log
        """
        query_string = [('id', 789),
                        ('search_string', 'search_string_example'),
                        ('skip', 1),
                        ('limit', 50)]
        response = self.client.open(
            '/mail/log',
            method='GET',
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
