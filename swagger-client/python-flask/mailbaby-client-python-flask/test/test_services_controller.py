# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from mailbaby-client-python-flask.models.error_message import ErrorMessage  # noqa: E501
from mailbaby-client-python-flask.models.mail_order import MailOrder  # noqa: E501
from mailbaby-client-python-flask.models.mail_order_detail import MailOrderDetail  # noqa: E501
from mailbaby-client-python-flask.test import BaseTestCase


class TestServicesController(BaseTestCase):
    """ServicesController integration test stubs"""

    def test_get_mail_order_by_id(self):
        """Test case for get_mail_order_by_id

        Displays details for a single mail order
        """
        response = self.client.open(
            '/mail/{id}'.format(id=789),
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_mail_orders(self):
        """Test case for get_mail_orders

        Displays a list of mail service orders
        """
        response = self.client.open(
            '/mail',
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
