import connexion
import six

from swagger_server.models.generic_response import GenericResponse  # noqa: E501
from swagger_server.models.inline_response200 import InlineResponse200  # noqa: E501
from swagger_server.models.inline_response401 import InlineResponse401  # noqa: E501
from swagger_server.models.mail_log import MailLog  # noqa: E501
from swagger_server.models.send_mail import SendMail  # noqa: E501
from swagger_server.models.send_mail_adv import SendMailAdv  # noqa: E501
from swagger_server.models.send_mail_adv_attachments import SendMailAdvAttachments  # noqa: E501
from swagger_server.models.send_mail_adv_bcc import SendMailAdvBcc  # noqa: E501
from swagger_server.models.send_mail_adv_cc import SendMailAdvCc  # noqa: E501
from swagger_server.models.send_mail_adv_from import SendMailAdvFrom  # noqa: E501
from swagger_server.models.send_mail_adv_replyto import SendMailAdvReplyto  # noqa: E501
from swagger_server.models.send_mail_adv_to import SendMailAdvTo  # noqa: E501
from swagger_server import util


def get_mail_orders():  # noqa: E501
    """displays a list of mail service orders

     # noqa: E501


    :rtype: List[InlineResponse200]
    """
    return 'do some magic!'


def ping_server():  # noqa: E501
    """Checks if the server is running

     # noqa: E501


    :rtype: None
    """
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
        _from = SendMailAdvFrom.from_dict(connexion.request.get_json())  # noqa: E501
    if connexion.request.is_json:
        to = [SendMailAdvTo.from_dict(d) for d in connexion.request.get_json()]  # noqa: E501
    if connexion.request.is_json:
        replyto = [SendMailAdvReplyto.from_dict(d) for d in connexion.request.get_json()]  # noqa: E501
    if connexion.request.is_json:
        cc = [SendMailAdvCc.from_dict(d) for d in connexion.request.get_json()]  # noqa: E501
    if connexion.request.is_json:
        bcc = [SendMailAdvBcc.from_dict(d) for d in connexion.request.get_json()]  # noqa: E501
    if connexion.request.is_json:
        attachments = [SendMailAdvAttachments.from_dict(d) for d in connexion.request.get_json()]  # noqa: E501
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


def view_mail_log(id=None, search=None, skip=None, limit=None, start_date=None, end_date=None):  # noqa: E501
    """displays the mail log

    By passing in the appropriate options, you can search for available inventory in the system  # noqa: E501

    :param id: The ID of your mail order this will be sent through.
    :type id: int
    :param search: pass an optional search string for looking up inventory
    :type search: str
    :param skip: number of records to skip for pagination
    :type skip: int
    :param limit: maximum number of records to return
    :type limit: int
    :param start_date: earliest date to get emails in unix timestamp format
    :type start_date: int
    :param end_date: earliest date to get emails in unix timestamp format
    :type end_date: int

    :rtype: MailLog
    """
    return 'do some magic!'
