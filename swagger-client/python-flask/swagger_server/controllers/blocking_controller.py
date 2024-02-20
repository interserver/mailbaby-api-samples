import connexion
import six

from swagger_server.models.deny_rule_new import DenyRuleNew  # noqa: E501
from swagger_server.models.deny_rule_record import DenyRuleRecord  # noqa: E501
from swagger_server.models.error_message import ErrorMessage  # noqa: E501
from swagger_server.models.generic_response import GenericResponse  # noqa: E501
from swagger_server.models.mail_blocks import MailBlocks  # noqa: E501
from swagger_server import util


def add_rule(user, type, data):  # noqa: E501
    """Creates a new email deny rule.

    Adds a new email deny rule into the system to block new emails that match the given criteria # noqa: E501

    :param user: 
    :type user: str
    :param type: 
    :type type: str
    :param data: 
    :type data: str

    :rtype: GenericResponse
    """
    return 'do some magic!'


def add_rule(body):  # noqa: E501
    """Creates a new email deny rule.

    Adds a new email deny rule into the system to block new emails that match the given criteria # noqa: E501

    :param body: These are the fields needed to create a new email deny rule.
    :type body: dict | bytes

    :rtype: GenericResponse
    """
    if connexion.request.is_json:
        body = DenyRuleNew.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def delete_rule(rule_id):  # noqa: E501
    """Removes an deny mail rule.

    Removes one of the configured deny mail rules from the system. # noqa: E501

    :param rule_id: The ID of the Rules entry.
    :type rule_id: int

    :rtype: GenericResponse
    """
    return 'do some magic!'


def delist_block(body):  # noqa: E501
    """Removes an email address from the blocked list

    Removes an email address from the various block lists.  # noqa: E501

    :param body: 
    :type body: dict | bytes

    :rtype: GenericResponse
    """
    if connexion.request.is_json:
        body = str.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def get_mail_blocks():  # noqa: E501
    """displays a list of blocked email addresses

     # noqa: E501


    :rtype: MailBlocks
    """
    return 'do some magic!'


def get_rules():  # noqa: E501
    """Displays a listing of deny email rules.

    Returns a listing of all the deny block rules you have configured. # noqa: E501


    :rtype: List[DenyRuleRecord]
    """
    return 'do some magic!'
