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

class MailStatsType(object):
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
        'time': 'str',
        'usage': 'int',
        'currency': 'str',
        'currency_symbol': 'str',
        'cost': 'float',
        'received': 'int',
        'sent': 'int',
        'volume': 'MailStatsTypeVolume'
    }

    attribute_map = {
        'time': 'time',
        'usage': 'usage',
        'currency': 'currency',
        'currency_symbol': 'currencySymbol',
        'cost': 'cost',
        'received': 'received',
        'sent': 'sent',
        'volume': 'volume'
    }

    def __init__(self, time='1h', usage=None, currency=None, currency_symbol=None, cost=None, received=None, sent=None, volume=None):  # noqa: E501
        """MailStatsType - a model defined in Swagger"""  # noqa: E501
        self._time = None
        self._usage = None
        self._currency = None
        self._currency_symbol = None
        self._cost = None
        self._received = None
        self._sent = None
        self._volume = None
        self.discriminator = None
        if time is not None:
            self.time = time
        if usage is not None:
            self.usage = usage
        if currency is not None:
            self.currency = currency
        if currency_symbol is not None:
            self.currency_symbol = currency_symbol
        if cost is not None:
            self.cost = cost
        if received is not None:
            self.received = received
        if sent is not None:
            self.sent = sent
        if volume is not None:
            self.volume = volume

    @property
    def time(self):
        """Gets the time of this MailStatsType.  # noqa: E501


        :return: The time of this MailStatsType.  # noqa: E501
        :rtype: str
        """
        return self._time

    @time.setter
    def time(self, time):
        """Sets the time of this MailStatsType.


        :param time: The time of this MailStatsType.  # noqa: E501
        :type: str
        """
        allowed_values = ["all", "billing", "month", "7d", "24h", "today", "1h"]  # noqa: E501
        if time not in allowed_values:
            raise ValueError(
                "Invalid value for `time` ({0}), must be one of {1}"  # noqa: E501
                .format(time, allowed_values)
            )

        self._time = time

    @property
    def usage(self):
        """Gets the usage of this MailStatsType.  # noqa: E501


        :return: The usage of this MailStatsType.  # noqa: E501
        :rtype: int
        """
        return self._usage

    @usage.setter
    def usage(self, usage):
        """Sets the usage of this MailStatsType.


        :param usage: The usage of this MailStatsType.  # noqa: E501
        :type: int
        """

        self._usage = usage

    @property
    def currency(self):
        """Gets the currency of this MailStatsType.  # noqa: E501


        :return: The currency of this MailStatsType.  # noqa: E501
        :rtype: str
        """
        return self._currency

    @currency.setter
    def currency(self, currency):
        """Sets the currency of this MailStatsType.


        :param currency: The currency of this MailStatsType.  # noqa: E501
        :type: str
        """

        self._currency = currency

    @property
    def currency_symbol(self):
        """Gets the currency_symbol of this MailStatsType.  # noqa: E501


        :return: The currency_symbol of this MailStatsType.  # noqa: E501
        :rtype: str
        """
        return self._currency_symbol

    @currency_symbol.setter
    def currency_symbol(self, currency_symbol):
        """Sets the currency_symbol of this MailStatsType.


        :param currency_symbol: The currency_symbol of this MailStatsType.  # noqa: E501
        :type: str
        """

        self._currency_symbol = currency_symbol

    @property
    def cost(self):
        """Gets the cost of this MailStatsType.  # noqa: E501


        :return: The cost of this MailStatsType.  # noqa: E501
        :rtype: float
        """
        return self._cost

    @cost.setter
    def cost(self, cost):
        """Sets the cost of this MailStatsType.


        :param cost: The cost of this MailStatsType.  # noqa: E501
        :type: float
        """

        self._cost = cost

    @property
    def received(self):
        """Gets the received of this MailStatsType.  # noqa: E501


        :return: The received of this MailStatsType.  # noqa: E501
        :rtype: int
        """
        return self._received

    @received.setter
    def received(self, received):
        """Sets the received of this MailStatsType.


        :param received: The received of this MailStatsType.  # noqa: E501
        :type: int
        """

        self._received = received

    @property
    def sent(self):
        """Gets the sent of this MailStatsType.  # noqa: E501


        :return: The sent of this MailStatsType.  # noqa: E501
        :rtype: int
        """
        return self._sent

    @sent.setter
    def sent(self, sent):
        """Sets the sent of this MailStatsType.


        :param sent: The sent of this MailStatsType.  # noqa: E501
        :type: int
        """

        self._sent = sent

    @property
    def volume(self):
        """Gets the volume of this MailStatsType.  # noqa: E501


        :return: The volume of this MailStatsType.  # noqa: E501
        :rtype: MailStatsTypeVolume
        """
        return self._volume

    @volume.setter
    def volume(self, volume):
        """Sets the volume of this MailStatsType.


        :param volume: The volume of this MailStatsType.  # noqa: E501
        :type: MailStatsTypeVolume
        """

        self._volume = volume

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
        if issubclass(MailStatsType, dict):
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
        if not isinstance(other, MailStatsType):
            return False

        return self.__dict__ == other.__dict__

    def __ne__(self, other):
        """Returns true if both objects are not equal"""
        return not self == other
