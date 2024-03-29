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

class MailLogEntry(object):
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
        'id': 'int',
        'id': 'str',
        '_from': 'str',
        'to': 'str',
        'subject': 'str',
        'message_id': 'str',
        'created': 'str',
        'time': 'int',
        'user': 'str',
        'transtype': 'str',
        'origin': 'str',
        'interface': 'str',
        'sending_zone': 'str',
        'body_size': 'int',
        'seq': 'int',
        'recipient': 'str',
        'domain': 'str',
        'locked': 'int',
        'lock_time': 'str',
        'assigned': 'str',
        'queued': 'str',
        'mx_hostname': 'str',
        'response': 'str'
    }

    attribute_map = {
        'id': '_id',
        'id': 'id',
        '_from': 'from',
        'to': 'to',
        'subject': 'subject',
        'message_id': 'messageId',
        'created': 'created',
        'time': 'time',
        'user': 'user',
        'transtype': 'transtype',
        'origin': 'origin',
        'interface': 'interface',
        'sending_zone': 'sendingZone',
        'body_size': 'bodySize',
        'seq': 'seq',
        'recipient': 'recipient',
        'domain': 'domain',
        'locked': 'locked',
        'lock_time': 'lockTime',
        'assigned': 'assigned',
        'queued': 'queued',
        'mx_hostname': 'mxHostname',
        'response': 'response'
    }

    def __init__(self, id=None, id=None, _from=None, to=None, subject=None, message_id=None, created=None, time=None, user=None, transtype=None, origin=None, interface=None, sending_zone=None, body_size=None, seq=None, recipient=None, domain=None, locked=None, lock_time=None, assigned=None, queued=None, mx_hostname=None, response=None):  # noqa: E501
        """MailLogEntry - a model defined in Swagger"""  # noqa: E501
        self._id = None
        self._id = None
        self.__from = None
        self._to = None
        self._subject = None
        self._message_id = None
        self._created = None
        self._time = None
        self._user = None
        self._transtype = None
        self._origin = None
        self._interface = None
        self._sending_zone = None
        self._body_size = None
        self._seq = None
        self._recipient = None
        self._domain = None
        self._locked = None
        self._lock_time = None
        self._assigned = None
        self._queued = None
        self._mx_hostname = None
        self._response = None
        self.discriminator = None
        self.id = id
        self.id = id
        self._from = _from
        self.to = to
        self.subject = subject
        if message_id is not None:
            self.message_id = message_id
        self.created = created
        self.time = time
        self.user = user
        self.transtype = transtype
        self.origin = origin
        self.interface = interface
        self.sending_zone = sending_zone
        self.body_size = body_size
        self.seq = seq
        self.recipient = recipient
        self.domain = domain
        self.locked = locked
        self.lock_time = lock_time
        self.assigned = assigned
        self.queued = queued
        self.mx_hostname = mx_hostname
        self.response = response

    @property
    def id(self):
        """Gets the id of this MailLogEntry.  # noqa: E501

        internal db id  # noqa: E501

        :return: The id of this MailLogEntry.  # noqa: E501
        :rtype: int
        """
        return self._id

    @id.setter
    def id(self, id):
        """Sets the id of this MailLogEntry.

        internal db id  # noqa: E501

        :param id: The id of this MailLogEntry.  # noqa: E501
        :type: int
        """
        if id is None:
            raise ValueError("Invalid value for `id`, must not be `None`")  # noqa: E501

        self._id = id

    @property
    def id(self):
        """Gets the id of this MailLogEntry.  # noqa: E501

        mail id  # noqa: E501

        :return: The id of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._id

    @id.setter
    def id(self, id):
        """Sets the id of this MailLogEntry.

        mail id  # noqa: E501

        :param id: The id of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if id is None:
            raise ValueError("Invalid value for `id`, must not be `None`")  # noqa: E501

        self._id = id

    @property
    def _from(self):
        """Gets the _from of this MailLogEntry.  # noqa: E501

        from address  # noqa: E501

        :return: The _from of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self.__from

    @_from.setter
    def _from(self, _from):
        """Sets the _from of this MailLogEntry.

        from address  # noqa: E501

        :param _from: The _from of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if _from is None:
            raise ValueError("Invalid value for `_from`, must not be `None`")  # noqa: E501

        self.__from = _from

    @property
    def to(self):
        """Gets the to of this MailLogEntry.  # noqa: E501

        to address  # noqa: E501

        :return: The to of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._to

    @to.setter
    def to(self, to):
        """Sets the to of this MailLogEntry.

        to address  # noqa: E501

        :param to: The to of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if to is None:
            raise ValueError("Invalid value for `to`, must not be `None`")  # noqa: E501

        self._to = to

    @property
    def subject(self):
        """Gets the subject of this MailLogEntry.  # noqa: E501

        email subject  # noqa: E501

        :return: The subject of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._subject

    @subject.setter
    def subject(self, subject):
        """Sets the subject of this MailLogEntry.

        email subject  # noqa: E501

        :param subject: The subject of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if subject is None:
            raise ValueError("Invalid value for `subject`, must not be `None`")  # noqa: E501

        self._subject = subject

    @property
    def message_id(self):
        """Gets the message_id of this MailLogEntry.  # noqa: E501

        message id  # noqa: E501

        :return: The message_id of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._message_id

    @message_id.setter
    def message_id(self, message_id):
        """Sets the message_id of this MailLogEntry.

        message id  # noqa: E501

        :param message_id: The message_id of this MailLogEntry.  # noqa: E501
        :type: str
        """

        self._message_id = message_id

    @property
    def created(self):
        """Gets the created of this MailLogEntry.  # noqa: E501

        creation date  # noqa: E501

        :return: The created of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._created

    @created.setter
    def created(self, created):
        """Sets the created of this MailLogEntry.

        creation date  # noqa: E501

        :param created: The created of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if created is None:
            raise ValueError("Invalid value for `created`, must not be `None`")  # noqa: E501

        self._created = created

    @property
    def time(self):
        """Gets the time of this MailLogEntry.  # noqa: E501

        creation timestamp  # noqa: E501

        :return: The time of this MailLogEntry.  # noqa: E501
        :rtype: int
        """
        return self._time

    @time.setter
    def time(self, time):
        """Sets the time of this MailLogEntry.

        creation timestamp  # noqa: E501

        :param time: The time of this MailLogEntry.  # noqa: E501
        :type: int
        """
        if time is None:
            raise ValueError("Invalid value for `time`, must not be `None`")  # noqa: E501

        self._time = time

    @property
    def user(self):
        """Gets the user of this MailLogEntry.  # noqa: E501

        user account  # noqa: E501

        :return: The user of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._user

    @user.setter
    def user(self, user):
        """Sets the user of this MailLogEntry.

        user account  # noqa: E501

        :param user: The user of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if user is None:
            raise ValueError("Invalid value for `user`, must not be `None`")  # noqa: E501

        self._user = user

    @property
    def transtype(self):
        """Gets the transtype of this MailLogEntry.  # noqa: E501

        transaction type  # noqa: E501

        :return: The transtype of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._transtype

    @transtype.setter
    def transtype(self, transtype):
        """Sets the transtype of this MailLogEntry.

        transaction type  # noqa: E501

        :param transtype: The transtype of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if transtype is None:
            raise ValueError("Invalid value for `transtype`, must not be `None`")  # noqa: E501

        self._transtype = transtype

    @property
    def origin(self):
        """Gets the origin of this MailLogEntry.  # noqa: E501

        origin ip  # noqa: E501

        :return: The origin of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._origin

    @origin.setter
    def origin(self, origin):
        """Sets the origin of this MailLogEntry.

        origin ip  # noqa: E501

        :param origin: The origin of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if origin is None:
            raise ValueError("Invalid value for `origin`, must not be `None`")  # noqa: E501

        self._origin = origin

    @property
    def interface(self):
        """Gets the interface of this MailLogEntry.  # noqa: E501

        interface name  # noqa: E501

        :return: The interface of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._interface

    @interface.setter
    def interface(self, interface):
        """Sets the interface of this MailLogEntry.

        interface name  # noqa: E501

        :param interface: The interface of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if interface is None:
            raise ValueError("Invalid value for `interface`, must not be `None`")  # noqa: E501

        self._interface = interface

    @property
    def sending_zone(self):
        """Gets the sending_zone of this MailLogEntry.  # noqa: E501

        sending zone  # noqa: E501

        :return: The sending_zone of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._sending_zone

    @sending_zone.setter
    def sending_zone(self, sending_zone):
        """Sets the sending_zone of this MailLogEntry.

        sending zone  # noqa: E501

        :param sending_zone: The sending_zone of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if sending_zone is None:
            raise ValueError("Invalid value for `sending_zone`, must not be `None`")  # noqa: E501

        self._sending_zone = sending_zone

    @property
    def body_size(self):
        """Gets the body_size of this MailLogEntry.  # noqa: E501

        email body size in bytes  # noqa: E501

        :return: The body_size of this MailLogEntry.  # noqa: E501
        :rtype: int
        """
        return self._body_size

    @body_size.setter
    def body_size(self, body_size):
        """Sets the body_size of this MailLogEntry.

        email body size in bytes  # noqa: E501

        :param body_size: The body_size of this MailLogEntry.  # noqa: E501
        :type: int
        """
        if body_size is None:
            raise ValueError("Invalid value for `body_size`, must not be `None`")  # noqa: E501

        self._body_size = body_size

    @property
    def seq(self):
        """Gets the seq of this MailLogEntry.  # noqa: E501

        index of email in the to adderess list  # noqa: E501

        :return: The seq of this MailLogEntry.  # noqa: E501
        :rtype: int
        """
        return self._seq

    @seq.setter
    def seq(self, seq):
        """Sets the seq of this MailLogEntry.

        index of email in the to adderess list  # noqa: E501

        :param seq: The seq of this MailLogEntry.  # noqa: E501
        :type: int
        """
        if seq is None:
            raise ValueError("Invalid value for `seq`, must not be `None`")  # noqa: E501

        self._seq = seq

    @property
    def recipient(self):
        """Gets the recipient of this MailLogEntry.  # noqa: E501

        to address this email is being sent to  # noqa: E501

        :return: The recipient of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._recipient

    @recipient.setter
    def recipient(self, recipient):
        """Sets the recipient of this MailLogEntry.

        to address this email is being sent to  # noqa: E501

        :param recipient: The recipient of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if recipient is None:
            raise ValueError("Invalid value for `recipient`, must not be `None`")  # noqa: E501

        self._recipient = recipient

    @property
    def domain(self):
        """Gets the domain of this MailLogEntry.  # noqa: E501

        to address domain  # noqa: E501

        :return: The domain of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._domain

    @domain.setter
    def domain(self, domain):
        """Sets the domain of this MailLogEntry.

        to address domain  # noqa: E501

        :param domain: The domain of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if domain is None:
            raise ValueError("Invalid value for `domain`, must not be `None`")  # noqa: E501

        self._domain = domain

    @property
    def locked(self):
        """Gets the locked of this MailLogEntry.  # noqa: E501

        locked status  # noqa: E501

        :return: The locked of this MailLogEntry.  # noqa: E501
        :rtype: int
        """
        return self._locked

    @locked.setter
    def locked(self, locked):
        """Sets the locked of this MailLogEntry.

        locked status  # noqa: E501

        :param locked: The locked of this MailLogEntry.  # noqa: E501
        :type: int
        """
        if locked is None:
            raise ValueError("Invalid value for `locked`, must not be `None`")  # noqa: E501

        self._locked = locked

    @property
    def lock_time(self):
        """Gets the lock_time of this MailLogEntry.  # noqa: E501

        lock timestamp  # noqa: E501

        :return: The lock_time of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._lock_time

    @lock_time.setter
    def lock_time(self, lock_time):
        """Sets the lock_time of this MailLogEntry.

        lock timestamp  # noqa: E501

        :param lock_time: The lock_time of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if lock_time is None:
            raise ValueError("Invalid value for `lock_time`, must not be `None`")  # noqa: E501

        self._lock_time = lock_time

    @property
    def assigned(self):
        """Gets the assigned of this MailLogEntry.  # noqa: E501

        assigned server  # noqa: E501

        :return: The assigned of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._assigned

    @assigned.setter
    def assigned(self, assigned):
        """Sets the assigned of this MailLogEntry.

        assigned server  # noqa: E501

        :param assigned: The assigned of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if assigned is None:
            raise ValueError("Invalid value for `assigned`, must not be `None`")  # noqa: E501

        self._assigned = assigned

    @property
    def queued(self):
        """Gets the queued of this MailLogEntry.  # noqa: E501

        queued timestamp  # noqa: E501

        :return: The queued of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._queued

    @queued.setter
    def queued(self, queued):
        """Sets the queued of this MailLogEntry.

        queued timestamp  # noqa: E501

        :param queued: The queued of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if queued is None:
            raise ValueError("Invalid value for `queued`, must not be `None`")  # noqa: E501

        self._queued = queued

    @property
    def mx_hostname(self):
        """Gets the mx_hostname of this MailLogEntry.  # noqa: E501

        mx hostname  # noqa: E501

        :return: The mx_hostname of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._mx_hostname

    @mx_hostname.setter
    def mx_hostname(self, mx_hostname):
        """Sets the mx_hostname of this MailLogEntry.

        mx hostname  # noqa: E501

        :param mx_hostname: The mx_hostname of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if mx_hostname is None:
            raise ValueError("Invalid value for `mx_hostname`, must not be `None`")  # noqa: E501

        self._mx_hostname = mx_hostname

    @property
    def response(self):
        """Gets the response of this MailLogEntry.  # noqa: E501

        mail delivery response  # noqa: E501

        :return: The response of this MailLogEntry.  # noqa: E501
        :rtype: str
        """
        return self._response

    @response.setter
    def response(self, response):
        """Sets the response of this MailLogEntry.

        mail delivery response  # noqa: E501

        :param response: The response of this MailLogEntry.  # noqa: E501
        :type: str
        """
        if response is None:
            raise ValueError("Invalid value for `response`, must not be `None`")  # noqa: E501

        self._response = response

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
        if issubclass(MailLogEntry, dict):
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
        if not isinstance(other, MailLogEntry):
            return False

        return self.__dict__ == other.__dict__

    def __ne__(self, other):
        """Returns true if both objects are not equal"""
        return not self == other
