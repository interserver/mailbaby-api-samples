# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.test import BaseTestCase


class TestStatusController(BaseTestCase):
    """StatusController integration test stubs"""

    def test_ping_server(self):
        """Test case for ping_server

        Checks if the server is running
        """
        response = self.client.open(
            '/ping',
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
