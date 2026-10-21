# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from MailBabyPythonFlask.models.error_message import ErrorMessage  # noqa: E501
from MailBabyPythonFlask.models.mail_order import MailOrder  # noqa: E501
from MailBabyPythonFlask.models.mail_order_detail import MailOrderDetail  # noqa: E501
from MailBabyPythonFlask.test import BaseTestCase


class TestServicesController(BaseTestCase):
    """ServicesController integration test stubs"""

    def test_get_mail_order_by_id(self):
        """Test case for get_mail_order_by_id

        Get one mail order's full detail including SMTP password
        """
        response = self.client.open(
            '/mail/{id}'.format(id=789),
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_mail_orders(self):
        """Test case for get_mail_orders

        List your provisioned mail orders (sending accounts)
        """
        response = self.client.open(
            '/mail',
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
