# MailStatsVolume

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**To** | Pointer to **map[string]int32** | Message counts keyed by destination (envelope &#x60;to&#x60;) email address. | [optional] 
**From** | Pointer to **map[string]int32** | Message counts keyed by sender (envelope &#x60;from&#x60;) email address. | [optional] 
**Ip** | Pointer to **map[string]int32** | Message counts keyed by originating client IP address. | [optional] 

## Methods

### NewMailStatsVolume

`func NewMailStatsVolume() *MailStatsVolume`

NewMailStatsVolume instantiates a new MailStatsVolume object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewMailStatsVolumeWithDefaults

`func NewMailStatsVolumeWithDefaults() *MailStatsVolume`

NewMailStatsVolumeWithDefaults instantiates a new MailStatsVolume object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTo

`func (o *MailStatsVolume) GetTo() map[string]int32`

GetTo returns the To field if non-nil, zero value otherwise.

### GetToOk

`func (o *MailStatsVolume) GetToOk() (*map[string]int32, bool)`

GetToOk returns a tuple with the To field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTo

`func (o *MailStatsVolume) SetTo(v map[string]int32)`

SetTo sets To field to given value.

### HasTo

`func (o *MailStatsVolume) HasTo() bool`

HasTo returns a boolean if a field has been set.

### GetFrom

`func (o *MailStatsVolume) GetFrom() map[string]int32`

GetFrom returns the From field if non-nil, zero value otherwise.

### GetFromOk

`func (o *MailStatsVolume) GetFromOk() (*map[string]int32, bool)`

GetFromOk returns a tuple with the From field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFrom

`func (o *MailStatsVolume) SetFrom(v map[string]int32)`

SetFrom sets From field to given value.

### HasFrom

`func (o *MailStatsVolume) HasFrom() bool`

HasFrom returns a boolean if a field has been set.

### GetIp

`func (o *MailStatsVolume) GetIp() map[string]int32`

GetIp returns the Ip field if non-nil, zero value otherwise.

### GetIpOk

`func (o *MailStatsVolume) GetIpOk() (*map[string]int32, bool)`

GetIpOk returns a tuple with the Ip field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIp

`func (o *MailStatsVolume) SetIp(v map[string]int32)`

SetIp sets Ip field to given value.

### HasIp

`func (o *MailStatsVolume) HasIp() bool`

HasIp returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


