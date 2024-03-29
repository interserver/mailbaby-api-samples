# coding: utf-8

"""
    MailBaby Email Delivery and Management Service API

    **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page.   # noqa: E501

    OpenAPI spec version: 1.1.0
    Contact: support@interserver.net
    Generated by: https://github.com/swagger-api/swagger-codegen.git
"""

import pprint
import re  # noqa: F401

import six

class DenyRuleNew(object):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    """
    Attributes:
      swagger_types (dict): The key is attribute name
                            and the value is attribute type.
      attribute_map (dict): The key is attribute name
                            and the value is json key in definition.
    """
    swagger_types = {
        'user': 'str',
        'type': 'str',
        'data': 'str'
    }

    attribute_map = {
        'user': 'user',
        'type': 'type',
        'data': 'data'
    }

    def __init__(self, user=None, type=None, data=None):  # noqa: E501
        """DenyRuleNew - a model defined in Swagger"""  # noqa: E501
        self._user = None
        self._type = None
        self._data = None
        self.discriminator = None
        if user is not None:
            self.user = user
        self.type = type
        self.data = data

    @property
    def user(self):
        """Gets the user of this DenyRuleNew.  # noqa: E501

        Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.  # noqa: E501

        :return: The user of this DenyRuleNew.  # noqa: E501
        :rtype: str
        """
        return self._user

    @user.setter
    def user(self, user):
        """Sets the user of this DenyRuleNew.

        Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.  # noqa: E501

        :param user: The user of this DenyRuleNew.  # noqa: E501
        :type: str
        """

        self._user = user

    @property
    def type(self):
        """Gets the type of this DenyRuleNew.  # noqa: E501

        The type of deny rule.  # noqa: E501

        :return: The type of this DenyRuleNew.  # noqa: E501
        :rtype: str
        """
        return self._type

    @type.setter
    def type(self, type):
        """Sets the type of this DenyRuleNew.

        The type of deny rule.  # noqa: E501

        :param type: The type of this DenyRuleNew.  # noqa: E501
        :type: str
        """
        if type is None:
            raise ValueError("Invalid value for `type`, must not be `None`")  # noqa: E501
        allowed_values = ["domain", "email", "startswith", "destination"]  # noqa: E501
        if type not in allowed_values:
            raise ValueError(
                "Invalid value for `type` ({0}), must be one of {1}"  # noqa: E501
                .format(type, allowed_values)
            )

        self._type = type

    @property
    def data(self):
        """Gets the data of this DenyRuleNew.  # noqa: E501

        The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.  # noqa: E501

        :return: The data of this DenyRuleNew.  # noqa: E501
        :rtype: str
        """
        return self._data

    @data.setter
    def data(self, data):
        """Sets the data of this DenyRuleNew.

        The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.  # noqa: E501

        :param data: The data of this DenyRuleNew.  # noqa: E501
        :type: str
        """
        if data is None:
            raise ValueError("Invalid value for `data`, must not be `None`")  # noqa: E501

        self._data = data

    def to_dict(self):
        """Returns the model properties as a dict"""
        result = {}

        for attr, _ in six.iteritems(self.swagger_types):
            value = getattr(self, attr)
            if isinstance(value, list):
                result[attr] = list(map(
                    lambda x: x.to_dict() if hasattr(x, "to_dict") else x,
                    value
                ))
            elif hasattr(value, "to_dict"):
                result[attr] = value.to_dict()
            elif isinstance(value, dict):
                result[attr] = dict(map(
                    lambda item: (item[0], item[1].to_dict())
                    if hasattr(item[1], "to_dict") else item,
                    value.items()
                ))
            else:
                result[attr] = value
        if issubclass(DenyRuleNew, dict):
            for key, value in self.items():
                result[key] = value

        return result

    def to_str(self):
        """Returns the string representation of the model"""
        return pprint.pformat(self.to_dict())

    def __repr__(self):
        """For `print` and `pprint`"""
        return self.to_str()

    def __eq__(self, other):
        """Returns true if both objects are equal"""
        if not isinstance(other, DenyRuleNew):
            return False

        return self.__dict__ == other.__dict__

    def __ne__(self, other):
        """Returns true if both objects are not equal"""
        return not self == other
