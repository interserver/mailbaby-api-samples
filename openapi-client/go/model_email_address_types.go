/*
MailBaby Email Delivery and Management Service API

**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 

API version: 1.1.0
Contact: support@interserver.net
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package openapi

import (
	"encoding/json"
	"fmt"
)

// EmailAddressTypes - 
type EmailAddressTypes struct {
	EmailAddressName *EmailAddressName
	String *string
}

// EmailAddressNameAsEmailAddressTypes is a convenience function that returns EmailAddressName wrapped in EmailAddressTypes
func EmailAddressNameAsEmailAddressTypes(v *EmailAddressName) EmailAddressTypes {
	return EmailAddressTypes{
		EmailAddressName: v,
	}
}

// stringAsEmailAddressTypes is a convenience function that returns string wrapped in EmailAddressTypes
func StringAsEmailAddressTypes(v *string) EmailAddressTypes {
	return EmailAddressTypes{
		String: v,
	}
}


// Unmarshal JSON data into one of the pointers in the struct
func (dst *EmailAddressTypes) UnmarshalJSON(data []byte) error {
	var err error
	match := 0
	// try to unmarshal data into EmailAddressName
	err = newStrictDecoder(data).Decode(&dst.EmailAddressName)
	if err == nil {
		jsonEmailAddressName, _ := json.Marshal(dst.EmailAddressName)
		if string(jsonEmailAddressName) == "{}" { // empty struct
			dst.EmailAddressName = nil
		} else {
			match++
		}
	} else {
		dst.EmailAddressName = nil
	}

	// try to unmarshal data into String
	err = newStrictDecoder(data).Decode(&dst.String)
	if err == nil {
		jsonString, _ := json.Marshal(dst.String)
		if string(jsonString) == "{}" { // empty struct
			dst.String = nil
		} else {
			match++
		}
	} else {
		dst.String = nil
	}

	if match > 1 { // more than 1 match
		// reset to nil
		dst.EmailAddressName = nil
		dst.String = nil

		return fmt.Errorf("data matches more than one schema in oneOf(EmailAddressTypes)")
	} else if match == 1 {
		return nil // exactly one match
	} else { // no match
		return fmt.Errorf("data failed to match schemas in oneOf(EmailAddressTypes)")
	}
}

// Marshal data from the first non-nil pointers in the struct to JSON
func (src EmailAddressTypes) MarshalJSON() ([]byte, error) {
	if src.EmailAddressName != nil {
		return json.Marshal(&src.EmailAddressName)
	}

	if src.String != nil {
		return json.Marshal(&src.String)
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance
func (obj *EmailAddressTypes) GetActualInstance() (interface{}) {
	if obj == nil {
		return nil
	}
	if obj.EmailAddressName != nil {
		return obj.EmailAddressName
	}

	if obj.String != nil {
		return obj.String
	}

	// all schemas are nil
	return nil
}

type NullableEmailAddressTypes struct {
	value *EmailAddressTypes
	isSet bool
}

func (v NullableEmailAddressTypes) Get() *EmailAddressTypes {
	return v.value
}

func (v *NullableEmailAddressTypes) Set(val *EmailAddressTypes) {
	v.value = val
	v.isSet = true
}

func (v NullableEmailAddressTypes) IsSet() bool {
	return v.isSet
}

func (v *NullableEmailAddressTypes) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableEmailAddressTypes(val *EmailAddressTypes) *NullableEmailAddressTypes {
	return &NullableEmailAddressTypes{value: val, isSet: true}
}

func (v NullableEmailAddressTypes) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableEmailAddressTypes) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}

