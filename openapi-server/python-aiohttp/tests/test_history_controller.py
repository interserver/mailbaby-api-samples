# coding: utf-8

import pytest
import json
from aiohttp import web

from MailBabyPythonAiohttp.models.error_message import ErrorMessage
from MailBabyPythonAiohttp.models.mail_log import MailLog
from MailBabyPythonAiohttp.models.mail_stats_type import MailStatsType


pytestmark = pytest.mark.asyncio

async def test_get_stats(client):
    """Test case for get_stats

    Account usage, cost, and volume statistics for a time window
    """
    params = [('time', '1h')]
    headers = { 
        'Accept': 'application/json',
        'apiKeyAuth': 'special-key',
    }
    response = await client.request(
        method='GET',
        path='/mail/stats',
        headers=headers,
        params=params,
        )
    assert response.status == 200, 'Response body is : ' + (await response.read()).decode('utf-8')


pytestmark = pytest.mark.asyncio

async def test_view_mail_log(client):
    """Test case for view_mail_log

    Query the mail delivery log (filterable, paginated)
    """
    params = [('id', 2604),
                    ('origin', '1.2.3.4'),
                    ('mx', 'mx.google.com'),
                    ('from', 'me@sender.com'),
                    ('to', 'you@receiver.com'),
                    ('subject', 'Your order has shipped'),
                    ('mailid', '185997065c60008840'),
                    ('messageId', '<abc123@yourdomain.com>'),
                    ('replyto', 'replies@sender.com'),
                    ('headerfrom', 'newsletter@sender.com'),
                    ('delivered', 1),
                    ('skip', 0),
                    ('limit', 100),
                    ('startDate', '1641781008'),
                    ('endDate', '1673317008'),
                    ('sort', 'time'),
                    ('dir', 'desc'),
                    ('groupby', 'recipient')]
    headers = { 
        'Accept': 'application/json',
        'apiKeyAuth': 'special-key',
    }
    response = await client.request(
        method='GET',
        path='/mail/log',
        headers=headers,
        params=params,
        )
    assert response.status == 200, 'Response body is : ' + (await response.read()).decode('utf-8')

