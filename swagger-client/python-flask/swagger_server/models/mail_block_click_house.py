# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server import util


class MailBlockClickHouse(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, _date: date=None, _from: str=None, message_id: str=None, subject: str=None, to: str=None):  # noqa: E501
        """MailBlockClickHouse - a model defined in Swagger

        :param _date: The _date of this MailBlockClickHouse.  # noqa: E501
        :type _date: date
        :param _from: The _from of this MailBlockClickHouse.  # noqa: E501
        :type _from: str
        :param message_id: The message_id of this MailBlockClickHouse.  # noqa: E501
        :type message_id: str
        :param subject: The subject of this MailBlockClickHouse.  # noqa: E501
        :type subject: str
        :param to: The to of this MailBlockClickHouse.  # noqa: E501
        :type to: str
        """
        self.swagger_types = {
            '_date': date,
            '_from': str,
            'message_id': str,
            'subject': str,
            'to': str
        }

        self.attribute_map = {
            '_date': 'date',
            '_from': 'from',
            'message_id': 'messageId',
            'subject': 'subject',
            'to': 'to'
        }
        self.__date = _date
        self.__from = _from
        self._message_id = message_id
        self._subject = subject
        self._to = to

    @classmethod
    def from_dict(cls, dikt) -> 'MailBlockClickHouse':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The MailBlockClickHouse of this MailBlockClickHouse.  # noqa: E501
        :rtype: MailBlockClickHouse
        """
        return util.deserialize_model(dikt, cls)

    @property
    def _date(self) -> date:
        """Gets the _date of this MailBlockClickHouse.


        :return: The _date of this MailBlockClickHouse.
        :rtype: date
        """
        return self.__date

    @_date.setter
    def _date(self, _date: date):
        """Sets the _date of this MailBlockClickHouse.


        :param _date: The _date of this MailBlockClickHouse.
        :type _date: date
        """
        if _date is None:
            raise ValueError("Invalid value for `_date`, must not be `None`")  # noqa: E501

        self.__date = _date

    @property
    def _from(self) -> str:
        """Gets the _from of this MailBlockClickHouse.


        :return: The _from of this MailBlockClickHouse.
        :rtype: str
        """
        return self.__from

    @_from.setter
    def _from(self, _from: str):
        """Sets the _from of this MailBlockClickHouse.


        :param _from: The _from of this MailBlockClickHouse.
        :type _from: str
        """
        if _from is None:
            raise ValueError("Invalid value for `_from`, must not be `None`")  # noqa: E501

        self.__from = _from

    @property
    def message_id(self) -> str:
        """Gets the message_id of this MailBlockClickHouse.


        :return: The message_id of this MailBlockClickHouse.
        :rtype: str
        """
        return self._message_id

    @message_id.setter
    def message_id(self, message_id: str):
        """Sets the message_id of this MailBlockClickHouse.


        :param message_id: The message_id of this MailBlockClickHouse.
        :type message_id: str
        """
        if message_id is None:
            raise ValueError("Invalid value for `message_id`, must not be `None`")  # noqa: E501

        self._message_id = message_id

    @property
    def subject(self) -> str:
        """Gets the subject of this MailBlockClickHouse.


        :return: The subject of this MailBlockClickHouse.
        :rtype: str
        """
        return self._subject

    @subject.setter
    def subject(self, subject: str):
        """Sets the subject of this MailBlockClickHouse.


        :param subject: The subject of this MailBlockClickHouse.
        :type subject: str
        """
        if subject is None:
            raise ValueError("Invalid value for `subject`, must not be `None`")  # noqa: E501

        self._subject = subject

    @property
    def to(self) -> str:
        """Gets the to of this MailBlockClickHouse.


        :return: The to of this MailBlockClickHouse.
        :rtype: str
        """
        return self._to

    @to.setter
    def to(self, to: str):
        """Sets the to of this MailBlockClickHouse.


        :param to: The to of this MailBlockClickHouse.
        :type to: str
        """
        if to is None:
            raise ValueError("Invalid value for `to`, must not be `None`")  # noqa: E501

        self._to = to