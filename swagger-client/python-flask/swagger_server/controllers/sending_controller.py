import connexion
import six

from swagger_server.models.email_address_types import EmailAddressTypes  # noqa: E501
from swagger_server.models.email_addresses_types import EmailAddressesTypes  # noqa: E501
from swagger_server.models.error_message import ErrorMessage  # noqa: E501
from swagger_server.models.generic_response import GenericResponse  # noqa: E501
from swagger_server.models.mail_attachment import MailAttachment  # noqa: E501
from swagger_server.models.raw_mail import RawMail  # noqa: E501
from swagger_server.models.send_mail import SendMail  # noqa: E501
from swagger_server.models.send_mail_adv import SendMailAdv  # noqa: E501
from swagger_server import util


def raw_mail(body):  # noqa: E501
    """Sends a raw email

    This call will let you pass the raw / complete email contents (including headers) as a string and have it get sent as-is.  This is useful for things like DKIM signed messages. # noqa: E501

    :param body: 
    :type body: dict | bytes

    :rtype: GenericResponse
    """
    if connexion.request.is_json:
        body = RawMail.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def raw_mail(raw_email):  # noqa: E501
    """Sends a raw email

    This call will let you pass the raw / complete email contents (including headers) as a string and have it get sent as-is.  This is useful for things like DKIM signed messages. # noqa: E501

    :param raw_email: 
    :type raw_email: str

    :rtype: GenericResponse
    """
    return 'do some magic!'


def send_adv_mail(subject, body, _from, to, replyto, cc, bcc, attachments, id):  # noqa: E501
    """Sends an Email with Advanced Options

    Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ --data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ --data \&quot;to[1][name]&#x3D;Joe\&quot; \\ --data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#x27; &#x60;&#x60;&#x60;  # noqa: E501

    :param subject: 
    :type subject: str
    :param body: 
    :type body: str
    :param _from: 
    :type _from: dict | bytes
    :param to: 
    :type to: dict | bytes
    :param replyto: 
    :type replyto: dict | bytes
    :param cc: 
    :type cc: dict | bytes
    :param bcc: 
    :type bcc: dict | bytes
    :param attachments: 
    :type attachments: list | bytes
    :param id: 
    :type id: int

    :rtype: GenericResponse
    """
    if connexion.request.is_json:
        _from = EmailAddressTypes.from_dict(connexion.request.get_json())  # noqa: E501
    if connexion.request.is_json:
        to = EmailAddressesTypes.from_dict(connexion.request.get_json())  # noqa: E501
    if connexion.request.is_json:
        replyto = EmailAddressesTypes.from_dict(connexion.request.get_json())  # noqa: E501
    if connexion.request.is_json:
        cc = EmailAddressesTypes.from_dict(connexion.request.get_json())  # noqa: E501
    if connexion.request.is_json:
        bcc = EmailAddressesTypes.from_dict(connexion.request.get_json())  # noqa: E501
    if connexion.request.is_json:
        attachments = [MailAttachment.from_dict(d) for d in connexion.request.get_json()]  # noqa: E501
    return 'do some magic!'


def send_adv_mail(body):  # noqa: E501
    """Sends an Email with Advanced Options

    Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ --data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ --data \&quot;to[1][name]&#x3D;Joe\&quot; \\ --data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#x27; &#x60;&#x60;&#x60;  # noqa: E501

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
