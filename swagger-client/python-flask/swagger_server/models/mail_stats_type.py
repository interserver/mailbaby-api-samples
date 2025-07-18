# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.mail_stats_type_volume import MailStatsTypeVolume  # noqa: F401,E501
from swagger_server import util


class MailStatsType(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, time: str='1h', usage: int=None, currency: str=None, currency_symbol: str=None, cost: float=None, received: int=None, sent: int=None, volume: MailStatsTypeVolume=None):  # noqa: E501
        """MailStatsType - a model defined in Swagger

        :param time: The time of this MailStatsType.  # noqa: E501
        :type time: str
        :param usage: The usage of this MailStatsType.  # noqa: E501
        :type usage: int
        :param currency: The currency of this MailStatsType.  # noqa: E501
        :type currency: str
        :param currency_symbol: The currency_symbol of this MailStatsType.  # noqa: E501
        :type currency_symbol: str
        :param cost: The cost of this MailStatsType.  # noqa: E501
        :type cost: float
        :param received: The received of this MailStatsType.  # noqa: E501
        :type received: int
        :param sent: The sent of this MailStatsType.  # noqa: E501
        :type sent: int
        :param volume: The volume of this MailStatsType.  # noqa: E501
        :type volume: MailStatsTypeVolume
        """
        self.swagger_types = {
            'time': str,
            'usage': int,
            'currency': str,
            'currency_symbol': str,
            'cost': float,
            'received': int,
            'sent': int,
            'volume': MailStatsTypeVolume
        }

        self.attribute_map = {
            'time': 'time',
            'usage': 'usage',
            'currency': 'currency',
            'currency_symbol': 'currencySymbol',
            'cost': 'cost',
            'received': 'received',
            'sent': 'sent',
            'volume': 'volume'
        }
        self._time = time
        self._usage = usage
        self._currency = currency
        self._currency_symbol = currency_symbol
        self._cost = cost
        self._received = received
        self._sent = sent
        self._volume = volume

    @classmethod
    def from_dict(cls, dikt) -> 'MailStatsType':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The MailStatsType of this MailStatsType.  # noqa: E501
        :rtype: MailStatsType
        """
        return util.deserialize_model(dikt, cls)

    @property
    def time(self) -> str:
        """Gets the time of this MailStatsType.


        :return: The time of this MailStatsType.
        :rtype: str
        """
        return self._time

    @time.setter
    def time(self, time: str):
        """Sets the time of this MailStatsType.


        :param time: The time of this MailStatsType.
        :type time: str
        """
        allowed_values = ["all", "billing", "month", "7d", "24h", "today", "1h"]  # noqa: E501
        if time not in allowed_values:
            raise ValueError(
                "Invalid value for `time` ({0}), must be one of {1}"
                .format(time, allowed_values)
            )

        self._time = time

    @property
    def usage(self) -> int:
        """Gets the usage of this MailStatsType.


        :return: The usage of this MailStatsType.
        :rtype: int
        """
        return self._usage

    @usage.setter
    def usage(self, usage: int):
        """Sets the usage of this MailStatsType.


        :param usage: The usage of this MailStatsType.
        :type usage: int
        """

        self._usage = usage

    @property
    def currency(self) -> str:
        """Gets the currency of this MailStatsType.


        :return: The currency of this MailStatsType.
        :rtype: str
        """
        return self._currency

    @currency.setter
    def currency(self, currency: str):
        """Sets the currency of this MailStatsType.


        :param currency: The currency of this MailStatsType.
        :type currency: str
        """

        self._currency = currency

    @property
    def currency_symbol(self) -> str:
        """Gets the currency_symbol of this MailStatsType.


        :return: The currency_symbol of this MailStatsType.
        :rtype: str
        """
        return self._currency_symbol

    @currency_symbol.setter
    def currency_symbol(self, currency_symbol: str):
        """Sets the currency_symbol of this MailStatsType.


        :param currency_symbol: The currency_symbol of this MailStatsType.
        :type currency_symbol: str
        """

        self._currency_symbol = currency_symbol

    @property
    def cost(self) -> float:
        """Gets the cost of this MailStatsType.


        :return: The cost of this MailStatsType.
        :rtype: float
        """
        return self._cost

    @cost.setter
    def cost(self, cost: float):
        """Sets the cost of this MailStatsType.


        :param cost: The cost of this MailStatsType.
        :type cost: float
        """

        self._cost = cost

    @property
    def received(self) -> int:
        """Gets the received of this MailStatsType.


        :return: The received of this MailStatsType.
        :rtype: int
        """
        return self._received

    @received.setter
    def received(self, received: int):
        """Sets the received of this MailStatsType.


        :param received: The received of this MailStatsType.
        :type received: int
        """

        self._received = received

    @property
    def sent(self) -> int:
        """Gets the sent of this MailStatsType.


        :return: The sent of this MailStatsType.
        :rtype: int
        """
        return self._sent

    @sent.setter
    def sent(self, sent: int):
        """Sets the sent of this MailStatsType.


        :param sent: The sent of this MailStatsType.
        :type sent: int
        """

        self._sent = sent

    @property
    def volume(self) -> MailStatsTypeVolume:
        """Gets the volume of this MailStatsType.


        :return: The volume of this MailStatsType.
        :rtype: MailStatsTypeVolume
        """
        return self._volume

    @volume.setter
    def volume(self, volume: MailStatsTypeVolume):
        """Sets the volume of this MailStatsType.


        :param volume: The volume of this MailStatsType.
        :type volume: MailStatsTypeVolume
        """

        self._volume = volume
