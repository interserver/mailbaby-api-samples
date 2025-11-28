import connexion
import six

from swagger_server.models.error_message import ErrorMessage  # noqa: E501
from swagger_server.models.mail_log import MailLog  # noqa: E501
from swagger_server.models.mail_stats_type import MailStatsType  # noqa: E501
from swagger_server import util


def get_stats(time=None):  # noqa: E501
    """Account usage statistics.

    Returns information about the usage on your mail accounts. # noqa: E501

    :param time: The timeframe for the statistics.
    :type time: str

    :rtype: MailStatsType
    """
    return 'do some magic!'


def view_mail_log(id=None, origin=None, mx=None, _from=None, to=None, subject=None, mailid=None, skip=None, limit=None, start_date=None, end_date=None, replyto=None, headerfrom=None, delivered=None):  # noqa: E501
    """displays the mail log

    Get a listing of the emails sent through this system  # noqa: E501

    :param id: The ID of your mail order this will be sent through.
    :type id: int
    :param origin: originating ip address sending mail
    :type origin: str
    :param mx: mx record mail was sent to
    :type mx: str
    :param _from: from email address
    :type _from: str
    :param to: to/destination email address
    :type to: str
    :param subject: subject containing this string
    :type subject: str
    :param mailid: mail id
    :type mailid: str
    :param skip: number of records to skip for pagination
    :type skip: int
    :param limit: maximum number of records to return
    :type limit: int
    :param start_date: earliest date to get emails in unix timestamp format
    :type start_date: int
    :param end_date: earliest date to get emails in unix timestamp format
    :type end_date: int
    :param replyto: Reply-To Email Address
    :type replyto: str
    :param headerfrom: Header From Email Address
    :type headerfrom: str
    :param delivered: Limiting the emails to wether or not they were delivered.
    :type delivered: str

    :rtype: MailLog
    """
    return 'do some magic!'
