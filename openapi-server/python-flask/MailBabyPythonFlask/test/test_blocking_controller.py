import unittest

from flask import json

from MailBabyPythonFlask.models.deny_rule_record import DenyRuleRecord  # noqa: E501
from MailBabyPythonFlask.models.email_address_param import EmailAddressParam  # noqa: E501
from MailBabyPythonFlask.models.error_message import ErrorMessage  # noqa: E501
from MailBabyPythonFlask.models.generic_response import GenericResponse  # noqa: E501
from MailBabyPythonFlask.models.mail_blocks import MailBlocks  # noqa: E501
from MailBabyPythonFlask.test import BaseTestCase


class TestBlockingController(BaseTestCase):
    """BlockingController integration test stubs"""

    @unittest.skip("Connexion does not support multiple consumes. See https://github.com/zalando/connexion/pull/760")
    def test_add_rule(self):
        """Test case for add_rule

        Create a deny rule to block a sender, domain, destination, or prefix
        """
        headers = { 
            'Accept': 'application/json',
            'Content-Type': 'application/x-www-form-urlencoded',
            'apiKeyAuth': 'special-key',
        }
        data = dict(user='user_example',
                    type='type_example',
                    data='data_example')
        response = self.client.open(
            '/mail/rules',
            method='POST',
            headers=headers,
            data=data,
            content_type='application/x-www-form-urlencoded')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_delete_rule(self):
        """Test case for delete_rule

        Delete a deny rule by its numeric ruleId
        """
        headers = { 
            'Accept': 'application/json',
            'apiKeyAuth': 'special-key',
        }
        response = self.client.open(
            '/mail/rules/{rule_id}'.format(rule_id=34),
            method='DELETE',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    @unittest.skip("Connexion does not support multiple consumes. See https://github.com/zalando/connexion/pull/760")
    def test_delist_block(self):
        """Test case for delist_block

        Delist an email address from the spam-filter block lists
        """
        email_address_param = {"email":"user@domain.com"}
        headers = { 
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'apiKeyAuth': 'special-key',
        }
        response = self.client.open(
            '/mail/blocks/delete',
            method='POST',
            headers=headers,
            data=json.dumps(email_address_param),
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_mail_blocks(self):
        """Test case for get_mail_blocks

        List addresses currently flagged by spam-filter block lists
        """
        headers = { 
            'Accept': 'application/json',
            'apiKeyAuth': 'special-key',
        }
        response = self.client.open(
            '/mail/blocks',
            method='GET',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_rules(self):
        """Test case for get_rules

        List custom deny rules (sender / domain / destination / prefix)
        """
        headers = { 
            'Accept': 'application/json',
            'apiKeyAuth': 'special-key',
        }
        response = self.client.open(
            '/mail/rules',
            method='GET',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    unittest.main()
