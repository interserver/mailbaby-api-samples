# coding: utf-8

"""
    Mail Baby API

    This is an API defintion for accesssing the Mail.Baby mail service.  # noqa: E501

    OpenAPI spec version: 1.0.0
    Contact: detain@interserver.net
    Generated by: https://github.com/swagger-api/swagger-codegen.git
"""

import pprint
import re  # noqa: F401

import six

class SendMailAdv(object):
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
        'subject': 'str',
        'body': 'str',
        '_from': 'list[SendMailAdvFrom]',
        'to': 'list[MailContact]',
        'id': 'int',
        'replyto': 'list[MailContact]',
        'cc': 'list[MailContact]',
        'bcc': 'list[MailContact]',
        'attachments': 'list[MailAttachment]'
    }

    attribute_map = {
        'subject': 'subject',
        'body': 'body',
        '_from': 'from',
        'to': 'to',
        'id': 'id',
        'replyto': 'replyto',
        'cc': 'cc',
        'bcc': 'bcc',
        'attachments': 'attachments'
    }

    def __init__(self, subject=None, body=None, _from=None, to=None, id=None, replyto=None, cc=None, bcc=None, attachments=None):  # noqa: E501
        """SendMailAdv - a model defined in Swagger"""  # noqa: E501
        self._subject = None
        self._body = None
        self.__from = None
        self._to = None
        self._id = None
        self._replyto = None
        self._cc = None
        self._bcc = None
        self._attachments = None
        self.discriminator = None
        self.subject = subject
        self.body = body
        self._from = _from
        self.to = to
        self.id = id
        if replyto is not None:
            self.replyto = replyto
        if cc is not None:
            self.cc = cc
        if bcc is not None:
            self.bcc = bcc
        if attachments is not None:
            self.attachments = attachments

    @property
    def subject(self):
        """Gets the subject of this SendMailAdv.  # noqa: E501

        The subject or title of the email  # noqa: E501

        :return: The subject of this SendMailAdv.  # noqa: E501
        :rtype: str
        """
        return self._subject

    @subject.setter
    def subject(self, subject):
        """Sets the subject of this SendMailAdv.

        The subject or title of the email  # noqa: E501

        :param subject: The subject of this SendMailAdv.  # noqa: E501
        :type: str
        """
        if subject is None:
            raise ValueError("Invalid value for `subject`, must not be `None`")  # noqa: E501

        self._subject = subject

    @property
    def body(self):
        """Gets the body of this SendMailAdv.  # noqa: E501

        The main email contents.  # noqa: E501

        :return: The body of this SendMailAdv.  # noqa: E501
        :rtype: str
        """
        return self._body

    @body.setter
    def body(self, body):
        """Sets the body of this SendMailAdv.

        The main email contents.  # noqa: E501

        :param body: The body of this SendMailAdv.  # noqa: E501
        :type: str
        """
        if body is None:
            raise ValueError("Invalid value for `body`, must not be `None`")  # noqa: E501

        self._body = body

    @property
    def _from(self):
        """Gets the _from of this SendMailAdv.  # noqa: E501

        The contact whom is the this email is from.  # noqa: E501

        :return: The _from of this SendMailAdv.  # noqa: E501
        :rtype: list[SendMailAdvFrom]
        """
        return self.__from

    @_from.setter
    def _from(self, _from):
        """Sets the _from of this SendMailAdv.

        The contact whom is the this email is from.  # noqa: E501

        :param _from: The _from of this SendMailAdv.  # noqa: E501
        :type: list[SendMailAdvFrom]
        """
        if _from is None:
            raise ValueError("Invalid value for `_from`, must not be `None`")  # noqa: E501

        self.__from = _from

    @property
    def to(self):
        """Gets the to of this SendMailAdv.  # noqa: E501

        The Contact whom is the primary recipient of this email.  # noqa: E501

        :return: The to of this SendMailAdv.  # noqa: E501
        :rtype: list[MailContact]
        """
        return self._to

    @to.setter
    def to(self, to):
        """Sets the to of this SendMailAdv.

        The Contact whom is the primary recipient of this email.  # noqa: E501

        :param to: The to of this SendMailAdv.  # noqa: E501
        :type: list[MailContact]
        """
        if to is None:
            raise ValueError("Invalid value for `to`, must not be `None`")  # noqa: E501

        self._to = to

    @property
    def id(self):
        """Gets the id of this SendMailAdv.  # noqa: E501

        The ID of the Mail order within our system to use as the Mail Account.  # noqa: E501

        :return: The id of this SendMailAdv.  # noqa: E501
        :rtype: int
        """
        return self._id

    @id.setter
    def id(self, id):
        """Sets the id of this SendMailAdv.

        The ID of the Mail order within our system to use as the Mail Account.  # noqa: E501

        :param id: The id of this SendMailAdv.  # noqa: E501
        :type: int
        """
        if id is None:
            raise ValueError("Invalid value for `id`, must not be `None`")  # noqa: E501

        self._id = id

    @property
    def replyto(self):
        """Gets the replyto of this SendMailAdv.  # noqa: E501

        Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.  # noqa: E501

        :return: The replyto of this SendMailAdv.  # noqa: E501
        :rtype: list[MailContact]
        """
        return self._replyto

    @replyto.setter
    def replyto(self, replyto):
        """Sets the replyto of this SendMailAdv.

        Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.  # noqa: E501

        :param replyto: The replyto of this SendMailAdv.  # noqa: E501
        :type: list[MailContact]
        """

        self._replyto = replyto

    @property
    def cc(self):
        """Gets the cc of this SendMailAdv.  # noqa: E501

        Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.  # noqa: E501

        :return: The cc of this SendMailAdv.  # noqa: E501
        :rtype: list[MailContact]
        """
        return self._cc

    @cc.setter
    def cc(self, cc):
        """Sets the cc of this SendMailAdv.

        Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.  # noqa: E501

        :param cc: The cc of this SendMailAdv.  # noqa: E501
        :type: list[MailContact]
        """

        self._cc = cc

    @property
    def bcc(self):
        """Gets the bcc of this SendMailAdv.  # noqa: E501

        Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.  # noqa: E501

        :return: The bcc of this SendMailAdv.  # noqa: E501
        :rtype: list[MailContact]
        """
        return self._bcc

    @bcc.setter
    def bcc(self, bcc):
        """Sets the bcc of this SendMailAdv.

        Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.  # noqa: E501

        :param bcc: The bcc of this SendMailAdv.  # noqa: E501
        :type: list[MailContact]
        """

        self._bcc = bcc

    @property
    def attachments(self):
        """Gets the attachments of this SendMailAdv.  # noqa: E501

        Optional file attachments to include in the email  # noqa: E501

        :return: The attachments of this SendMailAdv.  # noqa: E501
        :rtype: list[MailAttachment]
        """
        return self._attachments

    @attachments.setter
    def attachments(self, attachments):
        """Sets the attachments of this SendMailAdv.

        Optional file attachments to include in the email  # noqa: E501

        :param attachments: The attachments of this SendMailAdv.  # noqa: E501
        :type: list[MailAttachment]
        """

        self._attachments = attachments

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
        if issubclass(SendMailAdv, dict):
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
        if not isinstance(other, SendMailAdv):
            return False

        return self.__dict__ == other.__dict__

    def __ne__(self, other):
        """Returns true if both objects are not equal"""
        return not self == other