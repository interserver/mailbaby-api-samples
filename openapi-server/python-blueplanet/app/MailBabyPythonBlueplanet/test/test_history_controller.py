# coding: utf-8

from __future__ import absolute_import

from flask import json
from io import BytesIO

from app.MailBabyPythonBlueplanet.models.error_message import ErrorMessage  # noqa: E501
from app.MailBabyPythonBlueplanet.models.mail_log import MailLog  # noqa: E501
from app.MailBabyPythonBlueplanet.models.mail_stats_type import MailStatsType  # noqa: E501
from MailBabyPythonBlueplanet.test import BaseTestCase


class TestHistoryController(BaseTestCase):
    """HistoryController integration test stubs"""

    def test_get_stats(self):
        """Test case for get_stats

        Account usage, cost, and volume statistics for a time window
        """
        query_string = [('time', '1h')]
        response = self.client.open(
            '/mail/stats',
            method='GET',
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_view_mail_log(self):
        """Test case for view_mail_log

        Query the mail delivery log (filterable, paginated)
        """
        query_string = [('id', 2604),
                        ('origin', '1.2.3.4'),
                        ('mx', 'mx.google.com'),
                        ('_from', 'me@sender.com'),
                        ('to', 'you@receiver.com'),
                        ('subject', 'Your order has shipped'),
                        ('mailid', '185997065c60008840'),
                        ('message_id', '<abc123@yourdomain.com>'),
                        ('replyto', 'replies@sender.com'),
                        ('headerfrom', 'newsletter@sender.com'),
                        ('delivered', 1),
                        ('skip', 0),
                        ('limit', 100),
                        ('start_date', '1641781008'),
                        ('end_date', '1673317008'),
                        ('sort', 'time'),
                        ('dir', 'desc'),
                        ('groupby', 'recipient')]
        response = self.client.open(
            '/mail/log',
            method='GET',
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
