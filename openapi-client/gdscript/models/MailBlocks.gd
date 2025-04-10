extends Resource
class_name MailBlocks

# THIS FILE WAS AUTOMATICALLY GENERATED by the OpenAPI Generator project.
# For more information on how to customize templates, see:
# https://openapi-generator.tech
# https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator/src/main/resources/gdscript
# The OpenAPI Generator Community, © Public Domain, 2022

# MailBlocks Model
# The listing of blocked emails.


# Required: True
# isArray: true
@export var local: Array:
	set(value):
		__local__was__set = true
		local = value
var __local__was__set := false

# Required: True
# isArray: true
@export var mbtrap: Array:
	set(value):
		__mbtrap__was__set = true
		mbtrap = value
var __mbtrap__was__set := false

# Required: True
# isArray: true
@export var subject: Array:
	set(value):
		__subject__was__set = true
		subject = value
var __subject__was__set := false


func bzz_collect_missing_properties() -> Array:
	var bzz_missing_properties := Array()
	if not self.__local__was__set:
		bzz_missing_properties.append("local")
	if not self.__mbtrap__was__set:
		bzz_missing_properties.append("mbtrap")
	if not self.__subject__was__set:
		bzz_missing_properties.append("subject")
	return bzz_missing_properties


func bzz_normalize() -> Dictionary:
	var bzz_dictionary := Dictionary()
	if self.__local__was__set:
		bzz_dictionary["local"] = self.local
	if self.__mbtrap__was__set:
		bzz_dictionary["mbtrap"] = self.mbtrap
	if self.__subject__was__set:
		bzz_dictionary["subject"] = self.subject
	return bzz_dictionary


# Won't work for JSON+LD
static func bzz_denormalize_single(from_dict: Dictionary):
	var me := new()
	if from_dict.has("local"):
		me.local = MailBlockClickHouse.bzz_denormalize_multiple(from_dict["local"])
	if from_dict.has("mbtrap"):
		me.mbtrap = MailBlockClickHouse.bzz_denormalize_multiple(from_dict["mbtrap"])
	if from_dict.has("subject"):
		me.subject = MailBlockRspamd.bzz_denormalize_multiple(from_dict["subject"])
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

