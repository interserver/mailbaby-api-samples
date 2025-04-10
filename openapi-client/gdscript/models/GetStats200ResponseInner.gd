extends Resource
class_name GetStats200ResponseInner

# THIS FILE WAS AUTOMATICALLY GENERATED by the OpenAPI Generator project.
# For more information on how to customize templates, see:
# https://openapi-generator.tech
# https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator/src/main/resources/gdscript
# The OpenAPI Generator Community, © Public Domain, 2022

# GetStats200ResponseInner Model


# Required: True
# Example: 1234
# isArray: false
@export var id: int:
	set(value):
		__id__was__set = true
		id = value
var __id__was__set := false

# Required: True
# Example: active
# isArray: false
@export var status: String = "":
	set(value):
		__status__was__set = true
		status = value
var __status__was__set := false

# Required: True
# Example: mb1234
# isArray: false
@export var username: String = "":
	set(value):
		__username__was__set = true
		username = value
var __username__was__set := false

# Required: False
# Example: guest123
# isArray: false
@export var password: String = "":
	set(value):
		__password__was__set = true
		password = value
var __password__was__set := false

# Required: False
# Example: main mail account
# isArray: false
@export var comment: String = "":
	set(value):
		__comment__was__set = true
		comment = value
var __comment__was__set := false


func bzz_collect_missing_properties() -> Array:
	var bzz_missing_properties := Array()
	if not self.__id__was__set:
		bzz_missing_properties.append("id")
	if not self.__status__was__set:
		bzz_missing_properties.append("status")
	if not self.__username__was__set:
		bzz_missing_properties.append("username")
	return bzz_missing_properties


func bzz_normalize() -> Dictionary:
	var bzz_dictionary := Dictionary()
	if self.__id__was__set:
		bzz_dictionary["id"] = self.id
	if self.__status__was__set:
		bzz_dictionary["status"] = self.status
	if self.__username__was__set:
		bzz_dictionary["username"] = self.username
	if self.__password__was__set:
		bzz_dictionary["password"] = self.password
	if self.__comment__was__set:
		bzz_dictionary["comment"] = self.comment
	return bzz_dictionary


# Won't work for JSON+LD
static func bzz_denormalize_single(from_dict: Dictionary):
	var me := new()
	if from_dict.has("id"):
		me.id = from_dict["id"]
	if from_dict.has("status"):
		me.status = from_dict["status"]
	if from_dict.has("username"):
		me.username = from_dict["username"]
	if from_dict.has("password"):
		me.password = from_dict["password"]
	if from_dict.has("comment"):
		me.comment = from_dict["comment"]
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

