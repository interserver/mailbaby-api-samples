import connexion
import six

from swagger_server.models.error_response import ErrorResponse  # noqa: E501
from swagger_server.models.generic_response import GenericResponse  # noqa: E501
from swagger_server.models.mail_log import MailLog  # noqa: E501
from swagger_server.models.mail_order import MailOrder  # noqa: E501
from swagger_server.models.mail_orders import MailOrders  # noqa: E501
from swagger_server.models.send_mail import SendMail  # noqa: E501
from swagger_server import util


def get_mail_orders(id=None):  # noqa: E501
    """displays a list of mail service orders

     # noqa: E501

    :param id: The ID of your mail order this will be sent through.
    :type id: int

    :rtype: MailOrders
    """
    return 'do some magic!'


def ping_server():  # noqa: E501
    """Checks if the server is running

     # noqa: E501


    :rtype: None
    """
    return 'do some magic!'


def place_mail_order(body=None):  # noqa: E501
    """places a mail order

    Adds an item to the system # noqa: E501

    :param body: Inventory item to add
    :type body: dict | bytes

    :rtype: None
    """
    if connexion.request.is_json:
        body = MailOrder.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def send_adv_mail_by_id(body):  # noqa: E501
    """Sends an Email with Advanced Options

    Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc. # noqa: E501

    :param body: 
    :type body: dict | bytes

    :rtype: GenericResponse
    """
    if connexion.request.is_json:
        body = SendMail.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def send_mail_by_id(subject, body, _from, to, id, to_name, from_name):  # noqa: E501
    """Sends an Email

    Sends An email through one of your mail orders. # noqa: E501

    :param subject: 
    :type subject: str
    :param body: 
    :type body: str
    :param _from: 
    :type _from: str
    :param to: 
    :type to: str
    :param id: 
    :type id: int
    :param to_name: 
    :type to_name: str
    :param from_name: 
    :type from_name: str

    :rtype: GenericResponse
    """
    return 'do some magic!'


def validate_mail_order():  # noqa: E501
    """validatess order details before placing an order

     # noqa: E501


    :rtype: None
    """
    return 'do some magic!'


def view_mail_log_by_id(id=None, search_string=None, skip=None, limit=None):  # noqa: E501
    """displays the mail log

    By passing in the appropriate options, you can search for available inventory in the system  # noqa: E501

    :param id: The ID of your mail order this will be sent through.
    :type id: int
    :param search_string: pass an optional search string for looking up inventory
    :type search_string: str
    :param skip: number of records to skip for pagination
    :type skip: int
    :param limit: maximum number of records to return
    :type limit: int

    :rtype: List[MailLog]
    """
    return 'do some magic!'
