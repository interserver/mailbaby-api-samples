#
# Mail Baby API
# 
# This is an API for accesssing the mail services.
# The version of the OpenAPI document: 1.0.0
# Contact: detain@interserver.net
# Generated by: https://openapi-generator.tech
#

import json
import tables


type MailOrder* = object
  ## 
  id*: int
  status*: string
  username*: string
  password*: string
  comment*: string