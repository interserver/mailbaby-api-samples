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
	"bytes"
	"fmt"
)

// checks if the EmailAddressName type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &EmailAddressName{}

// EmailAddressName An email contact.
type EmailAddressName struct {
	// The email address.
	Email string `json:"email"`
	// Name to use for the sending contact.
	Name *string `json:"name,omitempty"`
}

type _EmailAddressName EmailAddressName

// NewEmailAddressName instantiates a new EmailAddressName object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewEmailAddressName(email string) *EmailAddressName {
	this := EmailAddressName{}
	this.Email = email
	return &this
}

// NewEmailAddressNameWithDefaults instantiates a new EmailAddressName object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewEmailAddressNameWithDefaults() *EmailAddressName {
	this := EmailAddressName{}
	return &this
}

// GetEmail returns the Email field value
func (o *EmailAddressName) GetEmail() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Email
}

// GetEmailOk returns a tuple with the Email field value
// and a boolean to check if the value has been set.
func (o *EmailAddressName) GetEmailOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Email, true
}

// SetEmail sets field value
func (o *EmailAddressName) SetEmail(v string) {
	o.Email = v
}

// GetName returns the Name field value if set, zero value otherwise.
func (o *EmailAddressName) GetName() string {
	if o == nil || IsNil(o.Name) {
		var ret string
		return ret
	}
	return *o.Name
}

// GetNameOk returns a tuple with the Name field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *EmailAddressName) GetNameOk() (*string, bool) {
	if o == nil || IsNil(o.Name) {
		return nil, false
	}
	return o.Name, true
}

// HasName returns a boolean if a field has been set.
func (o *EmailAddressName) HasName() bool {
	if o != nil && !IsNil(o.Name) {
		return true
	}

	return false
}

// SetName gets a reference to the given string and assigns it to the Name field.
func (o *EmailAddressName) SetName(v string) {
	o.Name = &v
}

func (o EmailAddressName) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o EmailAddressName) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["email"] = o.Email
	if !IsNil(o.Name) {
		toSerialize["name"] = o.Name
	}
	return toSerialize, nil
}

func (o *EmailAddressName) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"email",
	}

	allProperties := make(map[string]interface{})

	err = json.Unmarshal(data, &allProperties)

	if err != nil {
		return err;
	}

	for _, requiredProperty := range(requiredProperties) {
		if _, exists := allProperties[requiredProperty]; !exists {
			return fmt.Errorf("no value given for required property %v", requiredProperty)
		}
	}

	varEmailAddressName := _EmailAddressName{}

	decoder := json.NewDecoder(bytes.NewReader(data))
	decoder.DisallowUnknownFields()
	err = decoder.Decode(&varEmailAddressName)

	if err != nil {
		return err
	}

	*o = EmailAddressName(varEmailAddressName)

	return err
}

type NullableEmailAddressName struct {
	value *EmailAddressName
	isSet bool
}

func (v NullableEmailAddressName) Get() *EmailAddressName {
	return v.value
}

func (v *NullableEmailAddressName) Set(val *EmailAddressName) {
	v.value = val
	v.isSet = true
}

func (v NullableEmailAddressName) IsSet() bool {
	return v.isSet
}

func (v *NullableEmailAddressName) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableEmailAddressName(val *EmailAddressName) *NullableEmailAddressName {
	return &NullableEmailAddressName{value: val, isSet: true}
}

func (v NullableEmailAddressName) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableEmailAddressName) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


