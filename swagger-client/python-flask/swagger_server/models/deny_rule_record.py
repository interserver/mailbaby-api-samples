# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.deny_rule_new import DenyRuleNew  # noqa: F401,E501
from swagger_server import util


class DenyRuleRecord(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, id: str=None, created: datetime=None, user: str=None, type: str=None, data: str=None):  # noqa: E501
        """DenyRuleRecord - a model defined in Swagger

        :param id: The id of this DenyRuleRecord.  # noqa: E501
        :type id: str
        :param created: The created of this DenyRuleRecord.  # noqa: E501
        :type created: datetime
        :param user: The user of this DenyRuleRecord.  # noqa: E501
        :type user: str
        :param type: The type of this DenyRuleRecord.  # noqa: E501
        :type type: str
        :param data: The data of this DenyRuleRecord.  # noqa: E501
        :type data: str
        """
        self.swagger_types = {
            'id': str,
            'created': datetime,
            'user': str,
            'type': str,
            'data': str
        }

        self.attribute_map = {
            'id': 'id',
            'created': 'created',
            'user': 'user',
            'type': 'type',
            'data': 'data'
        }
        self._id = id
        self._created = created
        self._user = user
        self._type = type
        self._data = data

    @classmethod
    def from_dict(cls, dikt) -> 'DenyRuleRecord':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The DenyRuleRecord of this DenyRuleRecord.  # noqa: E501
        :rtype: DenyRuleRecord
        """
        return util.deserialize_model(dikt, cls)

    @property
    def id(self) -> str:
        """Gets the id of this DenyRuleRecord.

        The deny rule Id number.  # noqa: E501

        :return: The id of this DenyRuleRecord.
        :rtype: str
        """
        return self._id

    @id.setter
    def id(self, id: str):
        """Sets the id of this DenyRuleRecord.

        The deny rule Id number.  # noqa: E501

        :param id: The id of this DenyRuleRecord.
        :type id: str
        """
        if id is None:
            raise ValueError("Invalid value for `id`, must not be `None`")  # noqa: E501

        self._id = id

    @property
    def created(self) -> datetime:
        """Gets the created of this DenyRuleRecord.

        the date the rule was created.  # noqa: E501

        :return: The created of this DenyRuleRecord.
        :rtype: datetime
        """
        return self._created

    @created.setter
    def created(self, created: datetime):
        """Sets the created of this DenyRuleRecord.

        the date the rule was created.  # noqa: E501

        :param created: The created of this DenyRuleRecord.
        :type created: datetime
        """
        if created is None:
            raise ValueError("Invalid value for `created`, must not be `None`")  # noqa: E501

        self._created = created

    @property
    def user(self) -> str:
        """Gets the user of this DenyRuleRecord.

        Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.  # noqa: E501

        :return: The user of this DenyRuleRecord.
        :rtype: str
        """
        return self._user

    @user.setter
    def user(self, user: str):
        """Sets the user of this DenyRuleRecord.

        Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.  # noqa: E501

        :param user: The user of this DenyRuleRecord.
        :type user: str
        """

        self._user = user

    @property
    def type(self) -> str:
        """Gets the type of this DenyRuleRecord.

        The type of deny rule.  # noqa: E501

        :return: The type of this DenyRuleRecord.
        :rtype: str
        """
        return self._type

    @type.setter
    def type(self, type: str):
        """Sets the type of this DenyRuleRecord.

        The type of deny rule.  # noqa: E501

        :param type: The type of this DenyRuleRecord.
        :type type: str
        """
        allowed_values = ["domain", "email", "startswith", "destination"]  # noqa: E501
        if type not in allowed_values:
            raise ValueError(
                "Invalid value for `type` ({0}), must be one of {1}"
                .format(type, allowed_values)
            )

        self._type = type

    @property
    def data(self) -> str:
        """Gets the data of this DenyRuleRecord.

        The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.  # noqa: E501

        :return: The data of this DenyRuleRecord.
        :rtype: str
        """
        return self._data

    @data.setter
    def data(self, data: str):
        """Sets the data of this DenyRuleRecord.

        The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.  # noqa: E501

        :param data: The data of this DenyRuleRecord.
        :type data: str
        """
        if data is None:
            raise ValueError("Invalid value for `data`, must not be `None`")  # noqa: E501

        self._data = data
