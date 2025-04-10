extends Resource
class_name SendMailAdv

# THIS FILE WAS AUTOMATICALLY GENERATED by the OpenAPI Generator project.
# For more information on how to customize templates, see:
# https://openapi-generator.tech
# https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator/src/main/resources/gdscript
# The OpenAPI Generator Community, © Public Domain, 2022

# SendMailAdv Model
# Details for an Email


# The subject or title of the email
# Required: True
# Example: Your Package has been Delivered!
# isArray: false
@export var subject: String = "":
	set(value):
		__subject__was__set = true
		subject = value
var __subject__was__set := false

# The main email contents.
# Required: True
# Example: The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.
# isArray: false
@export var body: String = "":
	set(value):
		__body__was__set = true
		body = value
var __body__was__set := false

# Required: True
# isArray: false
@export var from: EmailAddressTypes:
	set(value):
		__from__was__set = true
		from = value
var __from__was__set := false

# Required: True
# isArray: false
@export var to: EmailAddressesTypes:
	set(value):
		__to__was__set = true
		to = value
var __to__was__set := false

# Required: False
# isArray: false
@export var replyto: EmailAddressesTypes:
	set(value):
		__replyto__was__set = true
		replyto = value
var __replyto__was__set := false

# Required: False
# isArray: false
@export var cc: EmailAddressesTypes:
	set(value):
		__cc__was__set = true
		cc = value
var __cc__was__set := false

# Required: False
# isArray: false
@export var bcc: EmailAddressesTypes:
	set(value):
		__bcc__was__set = true
		bcc = value
var __bcc__was__set := false

# (optional) File attachments to include in the email.  The file contents must be base64 encoded!
# Required: False
# Example: [
        {
            \"filename\": \"text.txt\",
            \"data\": \"base64_encoded_contents\"
        }
]
# isArray: true
@export var attachments: Array:
	set(value):
		__attachments__was__set = true
		attachments = value
var __attachments__was__set := false

# (optional)  ID of the Mail order within our system to use as the Mail Account.
# Required: False
# Example: 5000
# isArray: false
@export var id: float:
	set(value):
		__id__was__set = true
		id = value
var __id__was__set := false


func bzz_collect_missing_properties() -> Array:
	var bzz_missing_properties := Array()
	if not self.__subject__was__set:
		bzz_missing_properties.append("subject")
	if not self.__body__was__set:
		bzz_missing_properties.append("body")
	if not self.__from__was__set:
		bzz_missing_properties.append("from")
	if not self.__to__was__set:
		bzz_missing_properties.append("to")
	return bzz_missing_properties


func bzz_normalize() -> Dictionary:
	var bzz_dictionary := Dictionary()
	if self.__subject__was__set:
		bzz_dictionary["subject"] = self.subject
	if self.__body__was__set:
		bzz_dictionary["body"] = self.body
	if self.__from__was__set:
		bzz_dictionary["from"] = self.from
	if self.__to__was__set:
		bzz_dictionary["to"] = self.to
	if self.__replyto__was__set:
		bzz_dictionary["replyto"] = self.replyto
	if self.__cc__was__set:
		bzz_dictionary["cc"] = self.cc
	if self.__bcc__was__set:
		bzz_dictionary["bcc"] = self.bcc
	if self.__attachments__was__set:
		bzz_dictionary["attachments"] = self.attachments
	if self.__id__was__set:
		bzz_dictionary["id"] = self.id
	return bzz_dictionary


# Won't work for JSON+LD
static func bzz_denormalize_single(from_dict: Dictionary):
	var me := new()
	if from_dict.has("subject"):
		me.subject = from_dict["subject"]
	if from_dict.has("body"):
		me.body = from_dict["body"]
	if from_dict.has("from"):
		me.from = EmailAddressTypes.bzz_denormalize_single(from_dict["from"])
	if from_dict.has("to"):
		me.to = EmailAddressesTypes.bzz_denormalize_single(from_dict["to"])
	if from_dict.has("replyto"):
		me.replyto = EmailAddressesTypes.bzz_denormalize_single(from_dict["replyto"])
	if from_dict.has("cc"):
		me.cc = EmailAddressesTypes.bzz_denormalize_single(from_dict["cc"])
	if from_dict.has("bcc"):
		me.bcc = EmailAddressesTypes.bzz_denormalize_single(from_dict["bcc"])
	if from_dict.has("attachments"):
		me.attachments = MailAttachment.bzz_denormalize_multiple(from_dict["attachments"])
	if from_dict.has("id"):
		me.id = from_dict["id"]
	return me


# Won't work for JSON+LD
static func bzz_denormalize_multiple(from_array: Array):
	var mes := Array()
	for element in from_array:
		if element is Array:
			mes.append(bzz_denormalize_multiple(element))
		elif element is Dictionary:
			# TODO: perhaps check first if it looks like a match or an intermediate container
			mes.append(bzz_denormalize_single(element))
		else:
			mes.append(element)
	return mes

