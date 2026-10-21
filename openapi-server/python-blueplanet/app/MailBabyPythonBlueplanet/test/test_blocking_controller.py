# coding: utf-8

from __future__ import absolute_import

from flask import json
from io import BytesIO

from app.MailBabyPythonBlueplanet.models.deny_rule_record import DenyRuleRecord  # noqa: E501
from app.MailBabyPythonBlueplanet.models.email_address_param import EmailAddressParam  # noqa: E501
from app.MailBabyPythonBlueplanet.models.error_message import ErrorMessage  # noqa: E501
from app.MailBabyPythonBlueplanet.models.generic_response import GenericResponse  # noqa: E501
from app.MailBabyPythonBlueplanet.models.mail_blocks import MailBlocks  # noqa: E501
from MailBabyPythonBlueplanet.test import BaseTestCase


class TestBlockingController(BaseTestCase):
    """BlockingController integration test stubs"""

    def test_add_rule(self):
        """Test case for add_rule

        Create a deny rule to block a sender, domain, destination, or prefix
        """
        data = dict(user='user_example',
                    type='type_example',
                    data='data_example')
        response = self.client.open(
            '/mail/rules',
            method='POST',
            data=data,
            content_type='application/x-www-form-urlencoded')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_delete_rule(self):
        """Test case for delete_rule

        Delete a deny rule by its numeric ruleId
        """
        response = self.client.open(
            '/mail/rules/{rule_id}'.format(rule_id=34),
            method='DELETE')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_delist_block(self):
        """Test case for delist_block

        Delist an email address from the spam-filter block lists
        """
        body = {"email":"user@domain.com"}
        response = self.client.open(
            '/mail/blocks/delete',
            method='POST',
            data=json.dumps(body),
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_mail_blocks(self):
        """Test case for get_mail_blocks

        List addresses currently flagged by spam-filter block lists
        """
        response = self.client.open(
            '/mail/blocks',
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_rules(self):
        """Test case for get_rules

        List custom deny rules (sender / domain / destination / prefix)
        """
        response = self.client.open(
            '/mail/rules',
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
