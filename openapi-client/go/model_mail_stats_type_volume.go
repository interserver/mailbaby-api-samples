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
)

// checks if the MailStatsTypeVolume type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &MailStatsTypeVolume{}

// MailStatsTypeVolume struct for MailStatsTypeVolume
type MailStatsTypeVolume struct {
	To *MailStatsTypeVolumeTo `json:"to,omitempty"`
	From *MailStatsTypeVolumeFrom `json:"from,omitempty"`
	Ip *MailStatsTypeVolumeIp `json:"ip,omitempty"`
}

// NewMailStatsTypeVolume instantiates a new MailStatsTypeVolume object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewMailStatsTypeVolume() *MailStatsTypeVolume {
	this := MailStatsTypeVolume{}
	return &this
}

// NewMailStatsTypeVolumeWithDefaults instantiates a new MailStatsTypeVolume object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewMailStatsTypeVolumeWithDefaults() *MailStatsTypeVolume {
	this := MailStatsTypeVolume{}
	return &this
}

// GetTo returns the To field value if set, zero value otherwise.
func (o *MailStatsTypeVolume) GetTo() MailStatsTypeVolumeTo {
	if o == nil || IsNil(o.To) {
		var ret MailStatsTypeVolumeTo
		return ret
	}
	return *o.To
}

// GetToOk returns a tuple with the To field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *MailStatsTypeVolume) GetToOk() (*MailStatsTypeVolumeTo, bool) {
	if o == nil || IsNil(o.To) {
		return nil, false
	}
	return o.To, true
}

// HasTo returns a boolean if a field has been set.
func (o *MailStatsTypeVolume) HasTo() bool {
	if o != nil && !IsNil(o.To) {
		return true
	}

	return false
}

// SetTo gets a reference to the given MailStatsTypeVolumeTo and assigns it to the To field.
func (o *MailStatsTypeVolume) SetTo(v MailStatsTypeVolumeTo) {
	o.To = &v
}

// GetFrom returns the From field value if set, zero value otherwise.
func (o *MailStatsTypeVolume) GetFrom() MailStatsTypeVolumeFrom {
	if o == nil || IsNil(o.From) {
		var ret MailStatsTypeVolumeFrom
		return ret
	}
	return *o.From
}

// GetFromOk returns a tuple with the From field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *MailStatsTypeVolume) GetFromOk() (*MailStatsTypeVolumeFrom, bool) {
	if o == nil || IsNil(o.From) {
		return nil, false
	}
	return o.From, true
}

// HasFrom returns a boolean if a field has been set.
func (o *MailStatsTypeVolume) HasFrom() bool {
	if o != nil && !IsNil(o.From) {
		return true
	}

	return false
}

// SetFrom gets a reference to the given MailStatsTypeVolumeFrom and assigns it to the From field.
func (o *MailStatsTypeVolume) SetFrom(v MailStatsTypeVolumeFrom) {
	o.From = &v
}

// GetIp returns the Ip field value if set, zero value otherwise.
func (o *MailStatsTypeVolume) GetIp() MailStatsTypeVolumeIp {
	if o == nil || IsNil(o.Ip) {
		var ret MailStatsTypeVolumeIp
		return ret
	}
	return *o.Ip
}

// GetIpOk returns a tuple with the Ip field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *MailStatsTypeVolume) GetIpOk() (*MailStatsTypeVolumeIp, bool) {
	if o == nil || IsNil(o.Ip) {
		return nil, false
	}
	return o.Ip, true
}

// HasIp returns a boolean if a field has been set.
func (o *MailStatsTypeVolume) HasIp() bool {
	if o != nil && !IsNil(o.Ip) {
		return true
	}

	return false
}

// SetIp gets a reference to the given MailStatsTypeVolumeIp and assigns it to the Ip field.
func (o *MailStatsTypeVolume) SetIp(v MailStatsTypeVolumeIp) {
	o.Ip = &v
}

func (o MailStatsTypeVolume) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o MailStatsTypeVolume) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.To) {
		toSerialize["to"] = o.To
	}
	if !IsNil(o.From) {
		toSerialize["from"] = o.From
	}
	if !IsNil(o.Ip) {
		toSerialize["ip"] = o.Ip
	}
	return toSerialize, nil
}

type NullableMailStatsTypeVolume struct {
	value *MailStatsTypeVolume
	isSet bool
}

func (v NullableMailStatsTypeVolume) Get() *MailStatsTypeVolume {
	return v.value
}

func (v *NullableMailStatsTypeVolume) Set(val *MailStatsTypeVolume) {
	v.value = val
	v.isSet = true
}

func (v NullableMailStatsTypeVolume) IsSet() bool {
	return v.isSet
}

func (v *NullableMailStatsTypeVolume) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableMailStatsTypeVolume(val *MailStatsTypeVolume) *NullableMailStatsTypeVolume {
	return &NullableMailStatsTypeVolume{value: val, isSet: true}
}

func (v NullableMailStatsTypeVolume) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableMailStatsTypeVolume) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


