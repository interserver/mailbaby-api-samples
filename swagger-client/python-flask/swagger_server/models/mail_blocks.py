# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.mail_block_click_house import MailBlockClickHouse  # noqa: F401,E501
from swagger_server.models.mail_block_rspamd import MailBlockRspamd  # noqa: F401,E501
from swagger_server import util


class MailBlocks(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, local: List[MailBlockClickHouse]=None, mbtrap: List[MailBlockClickHouse]=None, subject: List[MailBlockRspamd]=None):  # noqa: E501
        """MailBlocks - a model defined in Swagger

        :param local: The local of this MailBlocks.  # noqa: E501
        :type local: List[MailBlockClickHouse]
        :param mbtrap: The mbtrap of this MailBlocks.  # noqa: E501
        :type mbtrap: List[MailBlockClickHouse]
        :param subject: The subject of this MailBlocks.  # noqa: E501
        :type subject: List[MailBlockRspamd]
        """
        self.swagger_types = {
            'local': List[MailBlockClickHouse],
            'mbtrap': List[MailBlockClickHouse],
            'subject': List[MailBlockRspamd]
        }

        self.attribute_map = {
            'local': 'local',
            'mbtrap': 'mbtrap',
            'subject': 'subject'
        }
        self._local = local
        self._mbtrap = mbtrap
        self._subject = subject

    @classmethod
    def from_dict(cls, dikt) -> 'MailBlocks':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The MailBlocks of this MailBlocks.  # noqa: E501
        :rtype: MailBlocks
        """
        return util.deserialize_model(dikt, cls)

    @property
    def local(self) -> List[MailBlockClickHouse]:
        """Gets the local of this MailBlocks.


        :return: The local of this MailBlocks.
        :rtype: List[MailBlockClickHouse]
        """
        return self._local

    @local.setter
    def local(self, local: List[MailBlockClickHouse]):
        """Sets the local of this MailBlocks.


        :param local: The local of this MailBlocks.
        :type local: List[MailBlockClickHouse]
        """
        if local is None:
            raise ValueError("Invalid value for `local`, must not be `None`")  # noqa: E501

        self._local = local

    @property
    def mbtrap(self) -> List[MailBlockClickHouse]:
        """Gets the mbtrap of this MailBlocks.


        :return: The mbtrap of this MailBlocks.
        :rtype: List[MailBlockClickHouse]
        """
        return self._mbtrap

    @mbtrap.setter
    def mbtrap(self, mbtrap: List[MailBlockClickHouse]):
        """Sets the mbtrap of this MailBlocks.


        :param mbtrap: The mbtrap of this MailBlocks.
        :type mbtrap: List[MailBlockClickHouse]
        """
        if mbtrap is None:
            raise ValueError("Invalid value for `mbtrap`, must not be `None`")  # noqa: E501

        self._mbtrap = mbtrap

    @property
    def subject(self) -> List[MailBlockRspamd]:
        """Gets the subject of this MailBlocks.


        :return: The subject of this MailBlocks.
        :rtype: List[MailBlockRspamd]
        """
        return self._subject

    @subject.setter
    def subject(self, subject: List[MailBlockRspamd]):
        """Sets the subject of this MailBlocks.


        :param subject: The subject of this MailBlocks.
        :type subject: List[MailBlockRspamd]
        """
        if subject is None:
            raise ValueError("Invalid value for `subject`, must not be `None`")  # noqa: E501

        self._subject = subject