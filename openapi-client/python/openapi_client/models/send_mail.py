# coding: utf-8

"""
    MailBaby Email Delivery and Management Service API

    **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 

    The version of the OpenAPI document: 1.1.0
    Contact: support@interserver.net
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json



from pydantic import BaseModel, Field, StrictStr

class SendMail(BaseModel):
    """
    Details for an Email
    """
    to: StrictStr = Field(..., description="The Contact whom is the primary recipient of this email.")
    var_from: StrictStr = Field(..., alias="from", description="The contact whom is the this email is from.")
    subject: StrictStr = Field(..., description="The subject or title of the email")
    body: StrictStr = Field(..., description="The main email contents.")
    __properties = ["to", "from", "subject", "body"]

    class Config:
        """Pydantic configuration"""
        allow_population_by_field_name = True
        validate_assignment = True

    def to_str(self) -> str:
        """Returns the string representation of the model using alias"""
        return pprint.pformat(self.dict(by_alias=True))

    def to_json(self) -> str:
        """Returns the JSON representation of the model using alias"""
        return json.dumps(self.to_dict())

    @classmethod
    def from_json(cls, json_str: str) -> SendMail:
        """Create an instance of SendMail from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                          },
                          exclude_none=True)
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> SendMail:
        """Create an instance of SendMail from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return SendMail.parse_obj(obj)

        _obj = SendMail.parse_obj({
            "to": obj.get("to"),
            "var_from": obj.get("from"),
            "subject": obj.get("subject"),
            "body": obj.get("body")
        })
        return _obj

