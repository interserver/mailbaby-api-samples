# coding: utf-8

"""
    MailBaby Email Delivery and Management Service API

    **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page.   # noqa: E501

    OpenAPI spec version: 1.1.0
    Contact: support@interserver.net
    Generated by: https://github.com/swagger-api/swagger-codegen.git
"""

from __future__ import absolute_import

import unittest

import swagger_client
from swagger_client.api.history_api import HistoryApi  # noqa: E501
from swagger_client.rest import ApiException


class TestHistoryApi(unittest.TestCase):
    """HistoryApi unit test stubs"""

    def setUp(self):
        self.api = HistoryApi()  # noqa: E501

    def tearDown(self):
        pass

    def test_get_stats(self):
        """Test case for get_stats

        Account usage statistics.  # noqa: E501
        """
        pass

    def test_view_mail_log(self):
        """Test case for view_mail_log

        displays the mail log  # noqa: E501
        """
        pass


if __name__ == '__main__':
    unittest.main()