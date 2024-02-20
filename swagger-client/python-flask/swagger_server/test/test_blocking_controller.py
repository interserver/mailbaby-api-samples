# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.deny_rule_new import DenyRuleNew  # noqa: E501
from swagger_server.models.deny_rule_record import DenyRuleRecord  # noqa: E501
from swagger_server.models.error_message import ErrorMessage  # noqa: E501
from swagger_server.models.generic_response import GenericResponse  # noqa: E501
from swagger_server.models.mail_blocks import MailBlocks  # noqa: E501
from swagger_server.test import BaseTestCase


class TestBlockingController(BaseTestCase):
    """BlockingController integration test stubs"""

    def test_add_rule(self):
        """Test case for add_rule

        Creates a new email deny rule.
        """
        body = DenyRuleNew()
        data = dict(user='user_example',
                    type='type_example',
                    data='data_example')
        response = self.client.open(
            '/mail/rules',
            method='POST',
            data=json.dumps(body),
            data=data,
            content_type='application/x-www-form-urlencoded')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_delete_rule(self):
        """Test case for delete_rule

        Removes an deny mail rule.
        """
        response = self.client.open(
            '/mail/rules/{ruleId}'.format(rule_id=56),
            method='DELETE')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_delist_block(self):
        """Test case for delist_block

        Removes an email address from the blocked list
        """
        body = '{   \"value\" : {     \"email\" : \"client@domain.com\"   } }'
        response = self.client.open(
            '/mail/blocks/delete',
            method='POST',
            data=json.dumps(body),
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_mail_blocks(self):
        """Test case for get_mail_blocks

        displays a list of blocked email addresses
        """
        response = self.client.open(
            '/mail/blocks',
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_rules(self):
        """Test case for get_rules

        Displays a listing of deny email rules.
        """
        response = self.client.open(
            '/mail/rules',
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
