# GenericResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Status** | Pointer to **string** | Always &#x60;\&quot;ok\&quot;&#x60; on success. | [optional] 
**Text** | Pointer to **string** | Operation-specific result string.  For send operations this is the relay transaction ID (e.g. &#x60;185caa69ff7000f47c&#x60;) which can be used as the &#x60;mailid&#x60; parameter in &#x60;GET /mail/log&#x60;.  For create operations this is the new record&#39;s numeric ID.  For delete operations this is a human-readable confirmation. | [optional] 

## Methods

### NewGenericResponse

`func NewGenericResponse() *GenericResponse`

NewGenericResponse instantiates a new GenericResponse object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewGenericResponseWithDefaults

`func NewGenericResponseWithDefaults() *GenericResponse`

NewGenericResponseWithDefaults instantiates a new GenericResponse object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetStatus

`func (o *GenericResponse) GetStatus() string`

GetStatus returns the Status field if non-nil, zero value otherwise.

### GetStatusOk

`func (o *GenericResponse) GetStatusOk() (*string, bool)`

GetStatusOk returns a tuple with the Status field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStatus

`func (o *GenericResponse) SetStatus(v string)`

SetStatus sets Status field to given value.

### HasStatus

`func (o *GenericResponse) HasStatus() bool`

HasStatus returns a boolean if a field has been set.

### GetText

`func (o *GenericResponse) GetText() string`

GetText returns the Text field if non-nil, zero value otherwise.

### GetTextOk

`func (o *GenericResponse) GetTextOk() (*string, bool)`

GetTextOk returns a tuple with the Text field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetText

`func (o *GenericResponse) SetText(v string)`

SetText sets Text field to given value.

### HasText

`func (o *GenericResponse) HasText() bool`

HasText returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


