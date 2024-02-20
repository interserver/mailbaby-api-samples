# EmailAddressTypes

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Email** | **string** | The email address. | 
**Name** | Pointer to **string** | Name to use for the sending contact. | [optional] 

## Methods

### NewEmailAddressTypes

`func NewEmailAddressTypes(email string, ) *EmailAddressTypes`

NewEmailAddressTypes instantiates a new EmailAddressTypes object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewEmailAddressTypesWithDefaults

`func NewEmailAddressTypesWithDefaults() *EmailAddressTypes`

NewEmailAddressTypesWithDefaults instantiates a new EmailAddressTypes object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetEmail

`func (o *EmailAddressTypes) GetEmail() string`

GetEmail returns the Email field if non-nil, zero value otherwise.

### GetEmailOk

`func (o *EmailAddressTypes) GetEmailOk() (*string, bool)`

GetEmailOk returns a tuple with the Email field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEmail

`func (o *EmailAddressTypes) SetEmail(v string)`

SetEmail sets Email field to given value.


### GetName

`func (o *EmailAddressTypes) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *EmailAddressTypes) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *EmailAddressTypes) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *EmailAddressTypes) HasName() bool`

HasName returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


