import connexion
import six

from swagger_server.models.error_message import ErrorMessage  # noqa: E501
from swagger_server.models.mail_order import MailOrder  # noqa: E501
from swagger_server import util


def get_mail_orders():  # noqa: E501
    """displays a list of mail service orders

    This will return a list of the mail orders you have in our system including their id, status, username, and optional comment. # noqa: E501


    :rtype: List[MailOrder]
    """
    return 'do some magic!'
