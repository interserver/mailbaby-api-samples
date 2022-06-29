# SendMailAdvAttachmentsInner

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Filename** | Pointer to **string** | (optional) Filename to specify for the attachment. | [optional] 
**Data** | ***os.File** | Contents of the attached file (must be base64 encoded) | 

## Methods

### NewSendMailAdvAttachmentsInner

`func NewSendMailAdvAttachmentsInner(data *os.File, ) *SendMailAdvAttachmentsInner`

NewSendMailAdvAttachmentsInner instantiates a new SendMailAdvAttachmentsInner object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSendMailAdvAttachmentsInnerWithDefaults

`func NewSendMailAdvAttachmentsInnerWithDefaults() *SendMailAdvAttachmentsInner`

NewSendMailAdvAttachmentsInnerWithDefaults instantiates a new SendMailAdvAttachmentsInner object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetFilename

`func (o *SendMailAdvAttachmentsInner) GetFilename() string`

GetFilename returns the Filename field if non-nil, zero value otherwise.

### GetFilenameOk

`func (o *SendMailAdvAttachmentsInner) GetFilenameOk() (*string, bool)`

GetFilenameOk returns a tuple with the Filename field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFilename

`func (o *SendMailAdvAttachmentsInner) SetFilename(v string)`

SetFilename sets Filename field to given value.

### HasFilename

`func (o *SendMailAdvAttachmentsInner) HasFilename() bool`

HasFilename returns a boolean if a field has been set.

### GetData

`func (o *SendMailAdvAttachmentsInner) GetData() *os.File`

GetData returns the Data field if non-nil, zero value otherwise.

### GetDataOk

`func (o *SendMailAdvAttachmentsInner) GetDataOk() (**os.File, bool)`

GetDataOk returns a tuple with the Data field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetData

`func (o *SendMailAdvAttachmentsInner) SetData(v *os.File)`

SetData sets Data field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


