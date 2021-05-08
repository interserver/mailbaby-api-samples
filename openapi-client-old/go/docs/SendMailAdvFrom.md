# SendMailAdvFrom

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Email** | **string** | The email address | 
**Name** | Pointer to **string** | Optional contact name | [optional] 

## Methods

### NewSendMailAdvFrom

`func NewSendMailAdvFrom(email string, ) *SendMailAdvFrom`

NewSendMailAdvFrom instantiates a new SendMailAdvFrom object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSendMailAdvFromWithDefaults

`func NewSendMailAdvFromWithDefaults() *SendMailAdvFrom`

NewSendMailAdvFromWithDefaults instantiates a new SendMailAdvFrom object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetEmail

`func (o *SendMailAdvFrom) GetEmail() string`

GetEmail returns the Email field if non-nil, zero value otherwise.

### GetEmailOk

`func (o *SendMailAdvFrom) GetEmailOk() (*string, bool)`

GetEmailOk returns a tuple with the Email field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEmail

`func (o *SendMailAdvFrom) SetEmail(v string)`

SetEmail sets Email field to given value.


### GetName

`func (o *SendMailAdvFrom) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *SendMailAdvFrom) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *SendMailAdvFrom) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *SendMailAdvFrom) HasName() bool`

HasName returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


