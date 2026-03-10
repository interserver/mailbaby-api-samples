# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from mailbaby-client-python-flask.models.error_message import ErrorMessage  # noqa: E501
from mailbaby-client-python-flask.models.mail_log import MailLog  # noqa: E501
from mailbaby-client-python-flask.models.mail_stats_type import MailStatsType  # noqa: E501
from mailbaby-client-python-flask.test import BaseTestCase


class TestHistoryController(BaseTestCase):
    """HistoryController integration test stubs"""

    def test_get_stats(self):
        """Test case for get_stats

        Account usage statistics
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

        Displays the mail log
        """
        query_string = [('id', 789),
                        ('origin', 'origin_example'),
                        ('mx', 'mx_example'),
                        ('_from', '_from_example'),
                        ('to', 'to_example'),
                        ('subject', 'subject_example'),
                        ('mailid', 'mailid_example'),
                        ('message_id', 'message_id_example'),
                        ('replyto', 'replyto_example'),
                        ('headerfrom', 'headerfrom_example'),
                        ('delivered', 56),
                        ('skip', 1),
                        ('limit', 10000),
                        ('start_date', 9999999999),
                        ('end_date', 9999999999)]
        response = self.client.open(
            '/mail/log',
            method='GET',
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
