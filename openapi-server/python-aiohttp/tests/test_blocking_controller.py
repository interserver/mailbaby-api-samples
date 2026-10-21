# coding: utf-8

import pytest
import json
from aiohttp import web

from MailBabyPythonAiohttp.models.deny_rule_record import DenyRuleRecord
from MailBabyPythonAiohttp.models.email_address_param import EmailAddressParam
from MailBabyPythonAiohttp.models.error_message import ErrorMessage
from MailBabyPythonAiohttp.models.generic_response import GenericResponse
from MailBabyPythonAiohttp.models.mail_blocks import MailBlocks


pytestmark = pytest.mark.asyncio

@pytest.mark.skip("Connexion does not support multiple consumes. See https://github.com/zalando/connexion/pull/760")
async def test_add_rule(client):
    """Test case for add_rule

    Create a deny rule to block a sender, domain, destination, or prefix
    """
    headers = { 
        'Accept': 'application/json',
        'Content-Type': 'application/x-www-form-urlencoded',
        'apiKeyAuth': 'special-key',
    }
    data = {
        'user': 'user_example',
        'type': 'type_example',
        'data': 'data_example'
        }
    response = await client.request(
        method='POST',
        path='/mail/rules',
        headers=headers,
        data=data,
        )
    assert response.status == 200, 'Response body is : ' + (await response.read()).decode('utf-8')


pytestmark = pytest.mark.asyncio

async def test_delete_rule(client):
    """Test case for delete_rule

    Delete a deny rule by its numeric ruleId
    """
    headers = { 
        'Accept': 'application/json',
        'apiKeyAuth': 'special-key',
    }
    response = await client.request(
        method='DELETE',
        path='/mail/rules/{rule_id}'.format(rule_id=34),
        headers=headers,
        )
    assert response.status == 200, 'Response body is : ' + (await response.read()).decode('utf-8')


pytestmark = pytest.mark.asyncio

@pytest.mark.skip("Connexion does not support multiple consumes. See https://github.com/zalando/connexion/pull/760")
async def test_delist_block(client):
    """Test case for delist_block

    Delist an email address from the spam-filter block lists
    """
    body = {"email":"user@domain.com"}
    headers = { 
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'apiKeyAuth': 'special-key',
    }
    response = await client.request(
        method='POST',
        path='/mail/blocks/delete',
        headers=headers,
        json=body,
        )
    assert response.status == 200, 'Response body is : ' + (await response.read()).decode('utf-8')


pytestmark = pytest.mark.asyncio

async def test_get_mail_blocks(client):
    """Test case for get_mail_blocks

    List addresses currently flagged by spam-filter block lists
    """
    headers = { 
        'Accept': 'application/json',
        'apiKeyAuth': 'special-key',
    }
    response = await client.request(
        method='GET',
        path='/mail/blocks',
        headers=headers,
        )
    assert response.status == 200, 'Response body is : ' + (await response.read()).decode('utf-8')


pytestmark = pytest.mark.asyncio

async def test_get_rules(client):
    """Test case for get_rules

    List custom deny rules (sender / domain / destination / prefix)
    """
    headers = { 
        'Accept': 'application/json',
        'apiKeyAuth': 'special-key',
    }
    response = await client.request(
        method='GET',
        path='/mail/rules',
        headers=headers,
        )
    assert response.status == 200, 'Response body is : ' + (await response.read()).decode('utf-8')

