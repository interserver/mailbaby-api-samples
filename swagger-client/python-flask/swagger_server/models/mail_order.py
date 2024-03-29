# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server import util


class MailOrder(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, id: int=None, status: str=None, username: str=None, comment: str=None):  # noqa: E501
        """MailOrder - a model defined in Swagger

        :param id: The id of this MailOrder.  # noqa: E501
        :type id: int
        :param status: The status of this MailOrder.  # noqa: E501
        :type status: str
        :param username: The username of this MailOrder.  # noqa: E501
        :type username: str
        :param comment: The comment of this MailOrder.  # noqa: E501
        :type comment: str
        """
        self.swagger_types = {
            'id': int,
            'status': str,
            'username': str,
            'comment': str
        }

        self.attribute_map = {
            'id': 'id',
            'status': 'status',
            'username': 'username',
            'comment': 'comment'
        }
        self._id = id
        self._status = status
        self._username = username
        self._comment = comment

    @classmethod
    def from_dict(cls, dikt) -> 'MailOrder':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The MailOrder of this MailOrder.  # noqa: E501
        :rtype: MailOrder
        """
        return util.deserialize_model(dikt, cls)

    @property
    def id(self) -> int:
        """Gets the id of this MailOrder.

        The ID of the order.  # noqa: E501

        :return: The id of this MailOrder.
        :rtype: int
        """
        return self._id

    @id.setter
    def id(self, id: int):
        """Sets the id of this MailOrder.

        The ID of the order.  # noqa: E501

        :param id: The id of this MailOrder.
        :type id: int
        """
        if id is None:
            raise ValueError("Invalid value for `id`, must not be `None`")  # noqa: E501

        self._id = id

    @property
    def status(self) -> str:
        """Gets the status of this MailOrder.

        The order status.  # noqa: E501

        :return: The status of this MailOrder.
        :rtype: str
        """
        return self._status

    @status.setter
    def status(self, status: str):
        """Sets the status of this MailOrder.

        The order status.  # noqa: E501

        :param status: The status of this MailOrder.
        :type status: str
        """
        if status is None:
            raise ValueError("Invalid value for `status`, must not be `None`")  # noqa: E501

        self._status = status

    @property
    def username(self) -> str:
        """Gets the username of this MailOrder.

        The username to use for this order.  # noqa: E501

        :return: The username of this MailOrder.
        :rtype: str
        """
        return self._username

    @username.setter
    def username(self, username: str):
        """Sets the username of this MailOrder.

        The username to use for this order.  # noqa: E501

        :param username: The username of this MailOrder.
        :type username: str
        """
        if username is None:
            raise ValueError("Invalid value for `username`, must not be `None`")  # noqa: E501

        self._username = username

    @property
    def comment(self) -> str:
        """Gets the comment of this MailOrder.

        Optional order comment.  # noqa: E501

        :return: The comment of this MailOrder.
        :rtype: str
        """
        return self._comment

    @comment.setter
    def comment(self, comment: str):
        """Sets the comment of this MailOrder.

        Optional order comment.  # noqa: E501

        :param comment: The comment of this MailOrder.
        :type comment: str
        """

        self._comment = comment
