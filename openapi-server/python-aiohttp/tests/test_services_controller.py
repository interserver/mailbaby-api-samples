# coding: utf-8

import pytest
import json
from aiohttp import web

from MailBabyPythonAiohttp.models.error_message import ErrorMessage
from MailBabyPythonAiohttp.models.mail_order import MailOrder
from MailBabyPythonAiohttp.models.mail_order_detail import MailOrderDetail


pytestmark = pytest.mark.asyncio

async def test_get_mail_order_by_id(client):
    """Test case for get_mail_order_by_id

    Get one mail order's full detail including SMTP password
    """
    headers = { 
        'Accept': 'application/json',
        'apiKeyAuth': 'special-key',
    }
    response = await client.request(
        method='GET',
        path='/mail/{id}'.format(id=39),
        headers=headers,
        )
    assert response.status == 200, 'Response body is : ' + (await response.read()).decode('utf-8')


pytestmark = pytest.mark.asyncio

async def test_get_mail_orders(client):
    """Test case for get_mail_orders

    List your provisioned mail orders (sending accounts)
    """
    headers = { 
        'Accept': 'application/json',
        'apiKeyAuth': 'special-key',
    }
    response = await client.request(
        method='GET',
        path='/mail',
        headers=headers,
        )
    assert response.status == 200, 'Response body is : ' + (await response.read()).decode('utf-8')

