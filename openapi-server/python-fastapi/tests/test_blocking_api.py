# coding: utf-8

from fastapi.testclient import TestClient


from pydantic import Field, StrictStr, field_validator  # noqa: F401
from typing import List, Optional  # noqa: F401
from typing_extensions import Annotated  # noqa: F401
from MailBabyPythonFastapi.models.deny_rule_record import DenyRuleRecord  # noqa: F401
from MailBabyPythonFastapi.models.email_address_param import EmailAddressParam  # noqa: F401
from MailBabyPythonFastapi.models.error_message import ErrorMessage  # noqa: F401
from MailBabyPythonFastapi.models.generic_response import GenericResponse  # noqa: F401
from MailBabyPythonFastapi.models.mail_blocks import MailBlocks  # noqa: F401


def test_get_mail_blocks(client: TestClient):
    """Test case for get_mail_blocks

    List addresses currently flagged by spam-filter block lists
    """

    headers = {
        "apiKeyAuth": "special-key",
    }
    # uncomment below to make a request
    #response = client.request(
    #    "GET",
    #    "/mail/blocks",
    #    headers=headers,
    #)

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200


def test_delist_block(client: TestClient):
    """Test case for delist_block

    Delist an email address from the spam-filter block lists
    """
    email_address_param = {"email":"client@domain.com"}

    headers = {
        "apiKeyAuth": "special-key",
    }
    # uncomment below to make a request
    #response = client.request(
    #    "POST",
    #    "/mail/blocks/delete",
    #    headers=headers,
    #    json=email_address_param,
    #)

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200


def test_get_rules(client: TestClient):
    """Test case for get_rules

    List custom deny rules (sender / domain / destination / prefix)
    """

    headers = {
        "apiKeyAuth": "special-key",
    }
    # uncomment below to make a request
    #response = client.request(
    #    "GET",
    #    "/mail/rules",
    #    headers=headers,
    #)

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200


def test_add_rule(client: TestClient):
    """Test case for add_rule

    Create a deny rule to block a sender, domain, destination, or prefix
    """

    headers = {
        "apiKeyAuth": "special-key",
    }
    data = {
        "user": 'user_example',
        "type": 'type_example',
        "data": 'data_example'
    }
    # uncomment below to make a request
    #response = client.request(
    #    "POST",
    #    "/mail/rules",
    #    headers=headers,
    #    data=data,
    #)

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200


def test_delete_rule(client: TestClient):
    """Test case for delete_rule

    Delete a deny rule by its numeric ruleId
    """

    headers = {
        "apiKeyAuth": "special-key",
    }
    # uncomment below to make a request
    #response = client.request(
    #    "DELETE",
    #    "/mail/rules/{ruleId}".format(ruleId=34),
    #    headers=headers,
    #)

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200

