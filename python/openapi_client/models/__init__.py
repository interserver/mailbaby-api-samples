# flake8: noqa

# import all models into this package
# if you have many models here with many references from one model to another this may
# raise a RecursionError
# to avoid this, import only the models that you directly need like:
# from from openapi_client.model.pet import Pet
# or import this package, but before doing it, use:
# import sys
# sys.setrecursionlimit(n)

from openapi_client.model.error_response import ErrorResponse
from openapi_client.model.generic_response import GenericResponse
from openapi_client.model.mail_attachment import MailAttachment
from openapi_client.model.mail_contact import MailContact
from openapi_client.model.mail_log import MailLog
from openapi_client.model.mail_order import MailOrder
from openapi_client.model.mail_orders import MailOrders
from openapi_client.model.send_mail import SendMail
