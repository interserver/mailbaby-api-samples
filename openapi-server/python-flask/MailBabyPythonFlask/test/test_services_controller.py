import unittest

from flask import json

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
        headers = { 
            'Accept': 'application/json',
            'apiKeyAuth': 'special-key',
        }
        response = self.client.open(
            '/mail/{id}'.format(id=39),
            method='GET',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_mail_orders(self):
        """Test case for get_mail_orders

        List your provisioned mail orders (sending accounts)
        """
        headers = { 
            'Accept': 'application/json',
            'apiKeyAuth': 'special-key',
        }
        response = self.client.open(
            '/mail',
            method='GET',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    unittest.main()
