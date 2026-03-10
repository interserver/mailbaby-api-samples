import connexion
import six

from mailbaby-client-python-flask.models.deny_rule_new import DenyRuleNew  # noqa: E501
from mailbaby-client-python-flask.models.deny_rule_record import DenyRuleRecord  # noqa: E501
from mailbaby-client-python-flask.models.email_address_param import EmailAddressParam  # noqa: E501
from mailbaby-client-python-flask.models.error_message import ErrorMessage  # noqa: E501
from mailbaby-client-python-flask.models.generic_response import GenericResponse  # noqa: E501
from mailbaby-client-python-flask.models.mail_blocks import MailBlocks  # noqa: E501
from mailbaby-client-python-flask import util


def add_rule(user, type, data):  # noqa: E501
    """Creates a new email deny rule

    Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The &#x60;type&#x60; field selects the matching strategy: - **&#x60;email&#x60;** — exact match against the SMTP envelope &#x60;MAIL FROM&#x60; address. - **&#x60;domain&#x60;** — matches any sender address at the specified domain. - **&#x60;destination&#x60;** — exact match against the SMTP envelope &#x60;RCPT TO&#x60; address. - **&#x60;startswith&#x60;** — matches any sender address whose local-part (the portion   before the &#x60;@&#x60;) starts with the given string.  Only alphanumeric characters   and &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; are permitted in the prefix.   If &#x60;username&#x60; is provided it must be the SMTP username of one of your active mail orders (e.g. &#x60;mb20682&#x60;).  If omitted the rule is associated with your first active order.  On success the response &#x60;text&#x60; field contains the newly created rule&#x27;s &#x60;id&#x60;, which can later be passed to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove it.  # noqa: E501

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
    """Creates a new email deny rule

    Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The &#x60;type&#x60; field selects the matching strategy: - **&#x60;email&#x60;** — exact match against the SMTP envelope &#x60;MAIL FROM&#x60; address. - **&#x60;domain&#x60;** — matches any sender address at the specified domain. - **&#x60;destination&#x60;** — exact match against the SMTP envelope &#x60;RCPT TO&#x60; address. - **&#x60;startswith&#x60;** — matches any sender address whose local-part (the portion   before the &#x60;@&#x60;) starts with the given string.  Only alphanumeric characters   and &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; are permitted in the prefix.   If &#x60;username&#x60; is provided it must be the SMTP username of one of your active mail orders (e.g. &#x60;mb20682&#x60;).  If omitted the rule is associated with your first active order.  On success the response &#x60;text&#x60; field contains the newly created rule&#x27;s &#x60;id&#x60;, which can later be passed to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove it.  # noqa: E501

    :param body: Fields required to create a new email deny rule.
    :type body: dict | bytes

    :rtype: GenericResponse
    """
    if connexion.request.is_json:
        body = DenyRuleNew.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def delete_rule(rule_id):  # noqa: E501
    """Removes a deny mail rule

    Permanently removes a single deny rule identified by its numeric &#x60;ruleId&#x60;.  The &#x60;ruleId&#x60; is the &#x60;id&#x60; field returned by &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field from a successful &#x60;POST /mail/rules&#x60; response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account.  # noqa: E501

    :param rule_id: The numeric ID of the deny rule to delete.  Obtain this from the &#x60;id&#x60; field in &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field of a &#x60;POST /mail/rules&#x60; response.
    :type rule_id: int

    :rtype: GenericResponse
    """
    return 'do some magic!'


def delist_block(body):  # noqa: E501
    """Removes an email address from the block lists

    Delists an email address from all three block list stores: 1. The rspamd spam-filter database (&#x60;fromemail&#x60; / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use &#x60;GET /mail/blocks&#x60; to discover which addresses are currently blocked.  The &#x60;from&#x60; field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules.  # noqa: E501

    :param body: 
    :type body: dict | bytes

    :rtype: GenericResponse
    """
    if connexion.request.is_json:
        body = EmailAddressParam.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def delist_block(email):  # noqa: E501
    """Removes an email address from the block lists

    Delists an email address from all three block list stores: 1. The rspamd spam-filter database (&#x60;fromemail&#x60; / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use &#x60;GET /mail/blocks&#x60; to discover which addresses are currently blocked.  The &#x60;from&#x60; field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules.  # noqa: E501

    :param email: 
    :type email: str

    :rtype: GenericResponse
    """
    return 'do some magic!'


def get_mail_blocks():  # noqa: E501
    """Displays a list of blocked email addresses

    Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s).  Three categories are returned:  - **&#x60;local&#x60;** — messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule.  These are   messages sent to recipients on your account&#x27;s local block list. - **&#x60;mbtrap&#x60;** — messages flagged by the &#x60;MBTRAP&#x60; rspamd rule.  These are messages   that triggered MailBaby&#x27;s internal trap / honeypot detection. - **&#x60;subject&#x60;** — senders whose recent messages contain spam-indicative subjects   (strings containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The &#x60;local&#x60; and &#x60;mbtrap&#x60; results cover the last 5 days.  The &#x60;subject&#x60; results cover the last 3 days.  A sender address returned in any of these lists can be delisted using &#x60;POST /mail/blocks/delete&#x60; with the &#x60;email&#x60; field set to that address.  # noqa: E501


    :rtype: MailBlocks
    """
    return 'do some magic!'


def get_rules():  # noqa: E501
    """Displays a listing of deny email rules

    Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | &#x60;type&#x60; | &#x60;data&#x60; format | Effect | |--------|---------------|--------| | &#x60;email&#x60; | &#x60;user@domain.com&#x60; | Rejects any message from this exact sender address | | &#x60;domain&#x60; | &#x60;domain.com&#x60; | Rejects any message from any address at this domain | | &#x60;destination&#x60; | &#x60;user@domain.com&#x60; | Rejects any message addressed to this recipient | | &#x60;startswith&#x60; | &#x60;prefix&#x60; | Rejects any message whose sender address begins with this string (alphanumeric, &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; only) |  Use &#x60;POST /mail/rules&#x60; to add new rules and &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove them.  The &#x60;id&#x60; field in each returned record is the value needed for the delete call.  # noqa: E501


    :rtype: List[DenyRuleRecord]
    """
    return 'do some magic!'
