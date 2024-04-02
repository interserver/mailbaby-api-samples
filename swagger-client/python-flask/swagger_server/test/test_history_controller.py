# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.error_message import ErrorMessage  # noqa: E501
from swagger_server.models.inline_response200 import InlineResponse200  # noqa: E501
from swagger_server.models.mail_log import MailLog  # noqa: E501
from swagger_server.test import BaseTestCase


class TestHistoryController(BaseTestCase):
    """HistoryController integration test stubs"""

    def test_get_stats(self):
        """Test case for get_stats

        Account usage statistics.
        """
        response = self.client.open(
            '/mail/stats',
            method='GET')
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
                        ('end_date', 9999999999),
                        ('replyto', 'replyto_example'),
                        ('headerfrom', 'headerfrom_example')]
        response = self.client.open(
            '/mail/log',
            method='GET',
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
