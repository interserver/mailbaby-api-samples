# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server import util


class Body(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, to: str=None, _from: str=None, subject: str=None, body: str=None):  # noqa: E501
        """Body - a model defined in Swagger

        :param to: The to of this Body.  # noqa: E501
        :type to: str
        :param _from: The _from of this Body.  # noqa: E501
        :type _from: str
        :param subject: The subject of this Body.  # noqa: E501
        :type subject: str
        :param body: The body of this Body.  # noqa: E501
        :type body: str
        """
        self.swagger_types = {
            'to': str,
            '_from': str,
            'subject': str,
            'body': str
        }

        self.attribute_map = {
            'to': 'to',
            '_from': 'from',
            'subject': 'subject',
            'body': 'body'
        }
        self._to = to
        self.__from = _from
        self._subject = subject
        self._body = body

    @classmethod
    def from_dict(cls, dikt) -> 'Body':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The body of this Body.  # noqa: E501
        :rtype: Body
        """
        return util.deserialize_model(dikt, cls)

    @property
    def to(self) -> str:
        """Gets the to of this Body.

        The Contact whom is the primary recipient of this email.  # noqa: E501

        :return: The to of this Body.
        :rtype: str
        """
        return self._to

    @to.setter
    def to(self, to: str):
        """Sets the to of this Body.

        The Contact whom is the primary recipient of this email.  # noqa: E501

        :param to: The to of this Body.
        :type to: str
        """

        self._to = to

    @property
    def _from(self) -> str:
        """Gets the _from of this Body.

        The contact whom is the this email is from.  # noqa: E501

        :return: The _from of this Body.
        :rtype: str
        """
        return self.__from

    @_from.setter
    def _from(self, _from: str):
        """Sets the _from of this Body.

        The contact whom is the this email is from.  # noqa: E501

        :param _from: The _from of this Body.
        :type _from: str
        """

        self.__from = _from

    @property
    def subject(self) -> str:
        """Gets the subject of this Body.

        The subject or title of the email  # noqa: E501

        :return: The subject of this Body.
        :rtype: str
        """
        return self._subject

    @subject.setter
    def subject(self, subject: str):
        """Sets the subject of this Body.

        The subject or title of the email  # noqa: E501

        :param subject: The subject of this Body.
        :type subject: str
        """

        self._subject = subject

    @property
    def body(self) -> str:
        """Gets the body of this Body.

        The main email contents.  # noqa: E501

        :return: The body of this Body.
        :rtype: str
        """
        return self._body

    @body.setter
    def body(self, body: str):
        """Sets the body of this Body.

        The main email contents.  # noqa: E501

        :param body: The body of this Body.
        :type body: str
        """

        self._body = body