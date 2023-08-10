import connexion
import six

from swagger_server.models.email_address_name import EmailAddressName  # noqa: E501
from swagger_server.models.generic_response import GenericResponse  # noqa: E501
from swagger_server.models.inline_response401 import InlineResponse401  # noqa: E501
from swagger_server.models.mail_attachment import MailAttachment  # noqa: E501
from swagger_server.models.send_mail import SendMail  # noqa: E501
from swagger_server.models.send_mail_adv import SendMailAdv  # noqa: E501
from swagger_server import util


def send_adv_mail(subject, body, _from, to, replyto, cc, bcc, attachments, id):  # noqa: E501
    """Sends an Email with Advanced Options

    Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc. # noqa: E501

    :param subject: 
    :type subject: str
    :param body: 
    :type body: str
    :param _from: 
    :type _from: dict | bytes
    :param to: 
    :type to: list | bytes
    :param replyto: 
    :type replyto: list | bytes
    :param cc: 
    :type cc: list | bytes
    :param bcc: 
    :type bcc: list | bytes
    :param attachments: 
    :type attachments: list | bytes
    :param id: 
    :type id: int

    :rtype: GenericResponse
    """
    if connexion.request.is_json:
        _from = EmailAddressName.from_dict(connexion.request.get_json())  # noqa: E501
    if connexion.request.is_json:
        to = [EmailAddressName.from_dict(d) for d in connexion.request.get_json()]  # noqa: E501
    if connexion.request.is_json:
        replyto = [EmailAddressName.from_dict(d) for d in connexion.request.get_json()]  # noqa: E501
    if connexion.request.is_json:
        cc = [EmailAddressName.from_dict(d) for d in connexion.request.get_json()]  # noqa: E501
    if connexion.request.is_json:
        bcc = [EmailAddressName.from_dict(d) for d in connexion.request.get_json()]  # noqa: E501
    if connexion.request.is_json:
        attachments = [MailAttachment.from_dict(d) for d in connexion.request.get_json()]  # noqa: E501
    return 'do some magic!'


def send_adv_mail(body):  # noqa: E501
    """Sends an Email with Advanced Options

    Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc. # noqa: E501

    :param body: 
    :type body: dict | bytes

    :rtype: GenericResponse
    """
    if connexion.request.is_json:
        body = SendMailAdv.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def send_mail(to, _from, subject, body):  # noqa: E501
    """Sends an Email

    Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead.  # noqa: E501

    :param to: 
    :type to: str
    :param _from: 
    :type _from: str
    :param subject: 
    :type subject: str
    :param body: 
    :type body: str

    :rtype: GenericResponse
    """
    return 'do some magic!'


def send_mail(body):  # noqa: E501
    """Sends an Email

    Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead.  # noqa: E501

    :param body: 
    :type body: dict | bytes

    :rtype: GenericResponse
    """
    if connexion.request.is_json:
        body = SendMail.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'
