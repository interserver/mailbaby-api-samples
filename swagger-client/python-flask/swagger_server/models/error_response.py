# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server import util


class ErrorResponse(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, code: str=None, message: str=None):  # noqa: E501
        """ErrorResponse - a model defined in Swagger

        :param code: The code of this ErrorResponse.  # noqa: E501
        :type code: str
        :param message: The message of this ErrorResponse.  # noqa: E501
        :type message: str
        """
        self.swagger_types = {
            'code': str,
            'message': str
        }

        self.attribute_map = {
            'code': 'code',
            'message': 'message'
        }
        self._code = code
        self._message = message

    @classmethod
    def from_dict(cls, dikt) -> 'ErrorResponse':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The ErrorResponse of this ErrorResponse.  # noqa: E501
        :rtype: ErrorResponse
        """
        return util.deserialize_model(dikt, cls)

    @property
    def code(self) -> str:
        """Gets the code of this ErrorResponse.


        :return: The code of this ErrorResponse.
        :rtype: str
        """
        return self._code

    @code.setter
    def code(self, code: str):
        """Sets the code of this ErrorResponse.


        :param code: The code of this ErrorResponse.
        :type code: str
        """
        if code is None:
            raise ValueError("Invalid value for `code`, must not be `None`")  # noqa: E501

        self._code = code

    @property
    def message(self) -> str:
        """Gets the message of this ErrorResponse.


        :return: The message of this ErrorResponse.
        :rtype: str
        """
        return self._message

    @message.setter
    def message(self, message: str):
        """Sets the message of this ErrorResponse.


        :param message: The message of this ErrorResponse.
        :type message: str
        """
        if message is None:
            raise ValueError("Invalid value for `message`, must not be `None`")  # noqa: E501

        self._message = message