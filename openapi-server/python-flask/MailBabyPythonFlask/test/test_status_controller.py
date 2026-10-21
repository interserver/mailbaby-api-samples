import unittest

from flask import json

from MailBabyPythonFlask.test import BaseTestCase


class TestStatusController(BaseTestCase):
    """StatusController integration test stubs"""

    def test_ping_server(self):
        """Test case for ping_server

        Health check — verify the API is reachable
        """
        headers = { 
            'Accept': 'application/json',
        }
        response = self.client.open(
            '/ping',
            method='GET',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    unittest.main()
