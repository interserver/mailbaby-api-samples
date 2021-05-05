# Body1

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**To** | Pointer to **string** | The Contact whom is the primary recipient of this email. | [optional] 
**From** | Pointer to **string** | The contact whom is the this email is from. | [optional] 
**Subject** | Pointer to **string** | The subject or title of the email | [optional] 
**Body** | Pointer to **string** | The main email contents. | [optional] 

## Methods

### NewBody1

`func NewBody1() *Body1`

NewBody1 instantiates a new Body1 object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewBody1WithDefaults

`func NewBody1WithDefaults() *Body1`

NewBody1WithDefaults instantiates a new Body1 object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTo

`func (o *Body1) GetTo() string`

GetTo returns the To field if non-nil, zero value otherwise.

### GetToOk

`func (o *Body1) GetToOk() (*string, bool)`

GetToOk returns a tuple with the To field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTo

`func (o *Body1) SetTo(v string)`

SetTo sets To field to given value.

### HasTo

`func (o *Body1) HasTo() bool`

HasTo returns a boolean if a field has been set.

### GetFrom

`func (o *Body1) GetFrom() string`

GetFrom returns the From field if non-nil, zero value otherwise.

### GetFromOk

`func (o *Body1) GetFromOk() (*string, bool)`

GetFromOk returns a tuple with the From field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFrom

`func (o *Body1) SetFrom(v string)`

SetFrom sets From field to given value.

### HasFrom

`func (o *Body1) HasFrom() bool`

HasFrom returns a boolean if a field has been set.

### GetSubject

`func (o *Body1) GetSubject() string`

GetSubject returns the Subject field if non-nil, zero value otherwise.

### GetSubjectOk

`func (o *Body1) GetSubjectOk() (*string, bool)`

GetSubjectOk returns a tuple with the Subject field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSubject

`func (o *Body1) SetSubject(v string)`

SetSubject sets Subject field to given value.

### HasSubject

`func (o *Body1) HasSubject() bool`

HasSubject returns a boolean if a field has been set.

### GetBody

`func (o *Body1) GetBody() string`

GetBody returns the Body field if non-nil, zero value otherwise.

### GetBodyOk

`func (o *Body1) GetBodyOk() (*string, bool)`

GetBodyOk returns a tuple with the Body field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBody

`func (o *Body1) SetBody(v string)`

SetBody sets Body field to given value.

### HasBody

`func (o *Body1) HasBody() bool`

HasBody returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


