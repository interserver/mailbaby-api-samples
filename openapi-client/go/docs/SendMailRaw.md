# SendMailRaw

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**RawEmail** | **string** | The entire email contents | 
**Id** | Pointer to **int32** | Optional order id | [optional] 

## Methods

### NewSendMailRaw

`func NewSendMailRaw(rawEmail string, ) *SendMailRaw`

NewSendMailRaw instantiates a new SendMailRaw object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSendMailRawWithDefaults

`func NewSendMailRawWithDefaults() *SendMailRaw`

NewSendMailRawWithDefaults instantiates a new SendMailRaw object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetRawEmail

`func (o *SendMailRaw) GetRawEmail() string`

GetRawEmail returns the RawEmail field if non-nil, zero value otherwise.

### GetRawEmailOk

`func (o *SendMailRaw) GetRawEmailOk() (*string, bool)`

GetRawEmailOk returns a tuple with the RawEmail field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRawEmail

`func (o *SendMailRaw) SetRawEmail(v string)`

SetRawEmail sets RawEmail field to given value.


### GetId

`func (o *SendMailRaw) GetId() int32`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *SendMailRaw) GetIdOk() (*int32, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *SendMailRaw) SetId(v int32)`

SetId sets Id field to given value.

### HasId

`func (o *SendMailRaw) HasId() bool`

HasId returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


