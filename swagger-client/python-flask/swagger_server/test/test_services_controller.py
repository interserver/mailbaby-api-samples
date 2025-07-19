# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.error_message import ErrorMessage  # noqa: E501
from swagger_server.models.mail_order import MailOrder  # noqa: E501
from swagger_server.test import BaseTestCase


class TestServicesController(BaseTestCase):
    """ServicesController integration test stubs"""

    def test_get_mail_orders(self):
        """Test case for get_mail_orders

        displays a list of mail service orders
        """
        response = self.client.open(
            '/mail',
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
