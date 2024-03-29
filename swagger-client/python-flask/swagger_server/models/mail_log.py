# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.mail_log_entry import MailLogEntry  # noqa: F401,E501
from swagger_server import util


class MailLog(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, total: int=None, skip: int=None, limit: int=None, emails: List[MailLogEntry]=None):  # noqa: E501
        """MailLog - a model defined in Swagger

        :param total: The total of this MailLog.  # noqa: E501
        :type total: int
        :param skip: The skip of this MailLog.  # noqa: E501
        :type skip: int
        :param limit: The limit of this MailLog.  # noqa: E501
        :type limit: int
        :param emails: The emails of this MailLog.  # noqa: E501
        :type emails: List[MailLogEntry]
        """
        self.swagger_types = {
            'total': int,
            'skip': int,
            'limit': int,
            'emails': List[MailLogEntry]
        }

        self.attribute_map = {
            'total': 'total',
            'skip': 'skip',
            'limit': 'limit',
            'emails': 'emails'
        }
        self._total = total
        self._skip = skip
        self._limit = limit
        self._emails = emails

    @classmethod
    def from_dict(cls, dikt) -> 'MailLog':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The MailLog of this MailLog.  # noqa: E501
        :rtype: MailLog
        """
        return util.deserialize_model(dikt, cls)

    @property
    def total(self) -> int:
        """Gets the total of this MailLog.

        total number of mail log entries  # noqa: E501

        :return: The total of this MailLog.
        :rtype: int
        """
        return self._total

    @total.setter
    def total(self, total: int):
        """Sets the total of this MailLog.

        total number of mail log entries  # noqa: E501

        :param total: The total of this MailLog.
        :type total: int
        """
        if total is None:
            raise ValueError("Invalid value for `total`, must not be `None`")  # noqa: E501

        self._total = total

    @property
    def skip(self) -> int:
        """Gets the skip of this MailLog.

        number of emails skipped in listing  # noqa: E501

        :return: The skip of this MailLog.
        :rtype: int
        """
        return self._skip

    @skip.setter
    def skip(self, skip: int):
        """Sets the skip of this MailLog.

        number of emails skipped in listing  # noqa: E501

        :param skip: The skip of this MailLog.
        :type skip: int
        """
        if skip is None:
            raise ValueError("Invalid value for `skip`, must not be `None`")  # noqa: E501

        self._skip = skip

    @property
    def limit(self) -> int:
        """Gets the limit of this MailLog.

        number of emails to return  # noqa: E501

        :return: The limit of this MailLog.
        :rtype: int
        """
        return self._limit

    @limit.setter
    def limit(self, limit: int):
        """Sets the limit of this MailLog.

        number of emails to return  # noqa: E501

        :param limit: The limit of this MailLog.
        :type limit: int
        """
        if limit is None:
            raise ValueError("Invalid value for `limit`, must not be `None`")  # noqa: E501

        self._limit = limit

    @property
    def emails(self) -> List[MailLogEntry]:
        """Gets the emails of this MailLog.


        :return: The emails of this MailLog.
        :rtype: List[MailLogEntry]
        """
        return self._emails

    @emails.setter
    def emails(self, emails: List[MailLogEntry]):
        """Sets the emails of this MailLog.


        :param emails: The emails of this MailLog.
        :type emails: List[MailLogEntry]
        """
        if emails is None:
            raise ValueError("Invalid value for `emails`, must not be `None`")  # noqa: E501

        self._emails = emails
